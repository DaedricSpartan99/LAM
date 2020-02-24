#include <unistd.h>
#include <string.h>
#include <stdlib.h>
#include <iostream>

using namespace std;

char * getCwd() {

	char buf[50];
	
	return getcwd(&buf[0], 50);
}

int main() {

	char * obj = new char[0];
	const char * h = "java -classpath \"";
	strcat(obj, h);
	char * path = getCwd();
	strcat(obj, path);
	strcat(obj, "/bin\" \"graphics.Main\"");

	cout << obj << endl;
	
	system(obj);
}
