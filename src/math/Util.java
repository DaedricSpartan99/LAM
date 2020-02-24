package math;

import java.math.BigDecimal;

public class Util {

	public static float round(float d, int decimalPlace) {
		
        BigDecimal bd = new BigDecimal(Float.toString(d));
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd.floatValue();
    }
	
	public static int maxValue(int[] array) {
		
		int max = 0;
		
		for(int i = 0; i < array.length; i++) {
			
			if(array[i] > max)
				max = array[i];
		}
		
		return max;
	}
	
	public static float maxValue(float[] array) {
		
		float max = 0;
		
		for(int i = 0; i < array.length; i++) {
			
			if(array[i] > max)
				max = array[i];
		}
		
		return max;
	}
}
