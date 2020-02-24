package math;

public class Generators {
	
	/**
	 * Generators constants
	 */
	
	public static final int NEW_A_Z = 36969;
	public static final int NEW_A_W = 18000;
	public static final int BIT32_MOD = 2147483647;
	
	/**
	 * Generators variable
	 */
	
	public static int CONG_A = 69069; // linear coefficient
	public static int CONG_C = 1234567; // affine transform
	public static int CONG_M = BIT32_MOD; // modulus = 2**31 - 1
	
	public static int MIDSQ_DIGITS = 4; // Digits range
	public static boolean MIDSQ_DINAMIC = true; // Dinamic digits
	
	public static int FIB_Y = 0; // Fibonacci's second seed
	public static int FIB_M = BIT32_MOD; // modulus = 2**31 -1
	
	public static int GSK_Y = 0;
	public static int GSK_M = BIT32_MOD;
	public static int[] GSK_ARGS;
	public static boolean GSK_INIT = true;
	public static int GSK_DIFF = 16;
	
	public static int[] LFSR_TAP = {32, 31, 30}; // default taps of LFSR
	public static boolean LFSR_INIT = true;
	public static int LFSR_SEED;
	public static int LFSR_BITS = 30;
	
	public static int[] SHR3_TAP = {17, 13, 5}; // default taps of SHR3
	
	public static int MWC_A = 69069;
	public static int MWC_M = 0xffff;
	public static int MWC_C = 23;
	public static int MWC_K = 24;
	public static int[] MWC_ARGS;
	public static boolean MWC_INIT = true;
	
	public static int KISS_MWC_A = MWC_A;
	public static int KISS_MWC_M = MWC_M;
	public static int KISS_MWC_C = MWC_C;
	public static int KISS_MWC_K = 24;
	public static int[] KISS_MWC_ARGS;
	public static boolean KISS_MWC_INIT = true;
	public static int KISS_CONG_A = CONG_A;
	public static int KISS_CONG_C = CONG_C;
	public static int KISS_CONG_M = BIT32_MOD;
	public static int[] KISS_SHR3_TAP = SHR3_TAP;
	
	/**
	 * Pseudo Random Number Generators
	 */
	
	private static int bin_abs(int x) {
		
		if (x < 0)
			x -= (1 << 31); // Turf off the first bit of number (the sign bit) and make it positive
		return x;
	}

	public static int CONG(int seed) { // The Linear Congruential method
		
		seed = (int)(((long)CONG_A * seed + CONG_C) % CONG_M);
		
		return seed;
	}
	
	public static int MIDSQ(int seed) { // The Middle Square Generator
		
		int length;
		
		if (!MIDSQ_DINAMIC) {
			
			length = MIDSQ_DIGITS;
			
			int _length = (int)Math.log10(seed) + 1;
			
			while(length < _length) {
				seed /= 10;
				_length --;
			}
		} else {
			if (seed > 0)
				length = (int)Math.log10(seed) + 1;
			else {
				length = 1;
			}
		}
		
		long _seed = seed * seed;
		
		if (_seed < 0)
			_seed *= -1;
			
		long f = _seed / (long)Math.pow(10, (length + 1) / 2);
		
		_seed = f - (f / (long)Math.pow(10, length)) * (long)Math.pow(10, length);
		
		seed = (int)_seed;
		
		if (seed < 0)
			seed *= -1;
		
		return seed;
	}
	
	public static int FIB(int seed) { // The Fibonacci method
		
		int temp = seed;
		seed = (int)(((long) seed + FIB_Y) % FIB_M);
		FIB_Y = temp;
			
		return seed;
	}
	
	public static int GSK(int seed) { // The Green, Smith and Klem method
		
		if (GSK_INIT) {
			
			GSK_ARGS = new int[GSK_DIFF + 1];
			GSK_ARGS[0] = GSK_Y;
			GSK_ARGS[1] = seed;
			
			for (int i = 2; i < GSK_DIFF + 1; i++) {
				
				GSK_ARGS[i] = (int)(((long)GSK_ARGS[i - 1] + GSK_ARGS[i - 2]) % GSK_M);
			}
			
			GSK_INIT = false;
		}
		
		seed = (int)(((long) GSK_ARGS[0] + seed) % GSK_M);
		
		for (int i = 1; i < GSK_DIFF + 1; i++) {
			
			GSK_ARGS[i - 1] = GSK_ARGS[i];
		}
		
		GSK_ARGS[GSK_DIFF] = seed;
		             
		return seed; 
	}
	
	public static int LFSR(int seed) { // Linear Feedback Shift Register method
		
		if (LFSR_INIT) {
			LFSR_SEED = seed;
			LFSR_INIT = false;
		}
		
		int buffer = 0;
		
		for (int i = 0; i < LFSR_BITS; i++) {
			
			buffer <<= 1;
		
			int xor = LFSR_SEED >> (32 - LFSR_TAP[0]);
		
			for (int j = 1; j < LFSR_TAP.length; j++)
				xor ^= (LFSR_SEED >> (32 - LFSR_TAP[j]));
	
			xor = (xor & 1) << 30;
		
			buffer |= LFSR_SEED & 1;
	
			LFSR_SEED = (LFSR_SEED >>> 1) | xor;
		}
		
		return buffer;
	}
	
	public static int SHR3(int seed) { // Marsaglia's xORshift
		
		seed ^= (seed << SHR3_TAP[0]);
		seed ^= (seed >>> SHR3_TAP[1]);
		seed ^= (seed << SHR3_TAP[2]);
		
		seed = bin_abs(seed);
		
		return seed;
	}
	
	public static int MWC(int seed) { // Multiply With Carry method
		
		if (MWC_INIT) {
			
			MWC_ARGS = new int[MWC_K];
			MWC_ARGS[0] = seed;
			for (int i = 1; i < MWC_K; i++) {
				seed = (int)(((long)MWC_A * seed + MWC_C) % MWC_M);
				MWC_ARGS[i] = seed;
			}
			
			MWC_INIT = false;
		}
		
		seed = (int)(((long)MWC_A * MWC_ARGS[0] + MWC_C) % MWC_M);
		MWC_C = (int)(((long)MWC_A * MWC_ARGS[0] + MWC_C) / MWC_M);
		
		for (int i = 0; i < MWC_K - 1; i++) {
			MWC_ARGS[i] = MWC_ARGS[i + 1];
		}
		
		MWC_ARGS[MWC_K - 1] = seed;
		
		//seed = bin_abs(seed);
		
		return seed;
	}
	
	public static int KISS(int seed) { // The KISS generator: a combination of MWC, Linear Congruential and SHR3
		
		
		//seed = (MWC(seed) ^ CONG(seed)) + SHR3(seed);
		
		int x = seed;
		
		/**
		 * Multiply with carry
		 */
		
		if (KISS_MWC_INIT) {
			
			KISS_MWC_ARGS = new int[KISS_MWC_K];
			KISS_MWC_ARGS[0] = seed;
			for (int i = 1; i < KISS_MWC_K; i++) {
				seed = (int)(((long)KISS_MWC_A * seed + KISS_MWC_C) % KISS_MWC_M);
				KISS_MWC_ARGS[i] = seed;
			}
			
			KISS_MWC_INIT = false;
		}
		
		seed = (int)(((long)KISS_MWC_A * KISS_MWC_ARGS[0] + KISS_MWC_C) % KISS_MWC_M);
		KISS_MWC_C = (int)(((long)KISS_MWC_A * KISS_MWC_ARGS[0] + KISS_MWC_C) / KISS_MWC_M);
		
		for (int i = 0; i < KISS_MWC_K - 1; i++) {
			KISS_MWC_ARGS[i] = KISS_MWC_ARGS[i + 1];
		}
		
		KISS_MWC_ARGS[KISS_MWC_K - 1] = seed;
		
		/**
		 * Linear congruential
		 */
		
		seed += (int)(((long)KISS_CONG_A * x + KISS_CONG_C) % KISS_CONG_M);
		
		/**
		 * xORShift
		 */
		
		x ^= x << KISS_SHR3_TAP[0];
		x ^= x >>> KISS_SHR3_TAP[1];
		x ^= x << KISS_SHR3_TAP[2];
		
		x = bin_abs(x);
		
		seed += x;
		
		seed = bin_abs(seed);
		
		return seed;
	}
}
