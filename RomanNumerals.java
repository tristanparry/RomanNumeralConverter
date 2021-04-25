package javaProjects;

// NEW ROMANCONVERSION CLASS
class RomanConversion { // New class created for the blueprint/idea of the RomanConversion code (this class contains 2 methods, convertToString() and convertToInt())
	
	// METHOD TO CONVERT DECIMAL TO ROMAN NUMERAL
	public static String convertToString(short number) { // New class method convertToString, which passes an short value (number) as its one parameter (this decimal number will be converted to a roman numeral within this method). As the method is described as public static String, it will return a String value without having to instantiate the class
		String romanNumber = ""; // Declares a new String variable with an initial empty value (this String will be manipulated + concantenated by the program, and returned in the method)
		Object[][] indices = {{1000,"M"},{900,"CM"},{500,"D"},{400,"CD"},{100,"C"},{90,"XC"},{50,"L"},{40,"XL"},{10,"X"},{9,"IX"},{5,"V"},{4,"IV"},{1,"I"}}; // Initializes/declares a new 2D Java Object array. The elements of each subarray are corresponding numeric decimal/roman numeral values (this 2D array is essentially a dictionary, assigning each integer to its roman numeral counterpart)
		
		if ((number >= 1) && (number <= 3999)) { // If the number is within the required range for this program [1,3999], inclusive...
			for (int i = 0; i < indices.length; i++) { // Initializes a new for loop with an int variable/object, used to store int values. Compares the i value to the length of the indices array (less than), and sets the variable to increment by 1 each loop iteration (effectively iterates over all subarray indices in the 2D array)
				while (number >= (int) indices[i][0]) { // Loop while the number is greater or equal to the current iterated indices integer value (uses (int) casting to return the proper data type in the Object[][] array)...
					romanNumber += indices[i][1]; // Concantenate the romanNumber string with the current iterated String value in the indices array
					number -= (int) indices[i][0]; // Subtract the current iterated indices integer value from the number value (this uses the basis of roman numeral conversion, the subtraction principle) - (uses (int) casting to return the proper data type in the Object[][] array)
				}
			}
		} else { // Conditional entered if all previous conditionals cannot be satisfied
			return "Out of range."; // Return that the entered number is out of range
		}
		return romanNumber; // Returns the final romanNumber String value, constructed throughout the convertToString method
	}
	
	// METHOD TO ROMAN NUMERAL TO DECIMAL
	public static short convertToInt(String romanNumber) { // New class method convertToInt, which passes a String value (romanNumber) as its one parameter (this roman numeral will be converted to a decimal number within this method). As the method is described as public static short, it will return an short value without having to instantiate the class
		short number = 0; // Declares a new short variable with an initial value of 0 (this short will be manipulated + added to by the program, and returned in the method)
		Object[][] indices = {{1000,'M'},{500,'D'},{100,'C'},{50,'L'},{10,'X'},{5,'V'},{1,'I'}}; // Initializes/declares a new 2D Java Object array. The elements of each subarray are corresponding numeric decimal/roman numeral values (this 2D array is essentially a dictionary, assigning each integer to its roman numeral counterpart)
		Object[][] specialIndices = {{200,"CM"},{200,"CD"},{20,"XC"},{20,"XL"},{2,"IX"},{2,"IV"}}; // Initializes/declares a new 2D Java Object array. The elements of each subarray are corresponding numeric decimal/roman numeral values (this 2D array is essentially a dictionary, assigning each integer to its roman numeral counterpart)

		for (int i = 0; i < romanNumber.length(); i++) { // Initializes a new for loop with an int variable/object, used to store int values. Compares the i value to the length of the entered roman numeral String (less than), and sets the variable to increment by 1 each loop iteration (effectively iterates over all characters in the roman numeral)
			for (int j = 0; j < indices.length; j++) { // Initializes a new for loop with an int variable/object, used to store int values. Compares the j value to the length of the indices 2D array (less than), and sets the variable to increment by 1 each loop iteration (effectively iterates over all subarray indices in the 2D array)
				if (romanNumber.charAt(i) == (char) indices[j][1]) { // If the current iterated character in the romanNumber String is equal to the current iterated String value in the indices array...
					number += (int) indices[j][0]; // Add the current iterated indices integer value to the number value (uses (int) casting to return the proper data type in the Object[][] array)
				}
			}
		}
		for (int i = 0; i < specialIndices.length; i++) { // Initializes a new for loop with an int variable/object, used to store int values. Compares the i value to the length of the specialIndices 2D array (less than), and sets the variable to increment by 1 each loop iteration (effectively iterates over all subarray indices in the 2D array)
			if (romanNumber.contains((String) specialIndices[i][1])) { // If the romanNumber String contains the current iterated String value in the specialIndices array...
				number -= (int) specialIndices[i][0]; // Subtract the current iterated specialIndices integer value from the number value (uses (int) casting to return the proper data type in the Object[][] array)
			}
		}
		return number; // Returns the final number short value, constructed throughout the convertToInt method
	}
}

// MAIN PROGRAM CLASS/RUN CLASS
public class RomanNumerals { // New main method, which which is used to run the program file
	public static void main(String[] args) { // Class method using the String[] args parameter to run and execute code from this/other file classes
		// VARIABLE INITIALIZATIONS
		short userNumber = 3999; // Initializes a new short variable, set to 3999 (can be set to any number 1-3999, to be converted to its roman numeral String)
		String userRomanNumber = "MMMCMXCIX"; // Initializes a new String variable, set to MMMCMXCIX (can be set to any roman numeral I-MMMCMXCIX, to be converted to its decimal number integer)
		
		// ROMANCONVERSION CLASS CALLING CODE
		System.out.println("The roman numeral for " + userNumber + " is " + RomanConversion.convertToString(userNumber)); // Calls the convertToString method on the RomanConversion class, using the userNumber variable value as its parameter
		System.out.println("The decimal number for " + userRomanNumber + " is " + RomanConversion.convertToInt(userRomanNumber)); // Calls the convertToInt method on the RomanConversion class, using the userRomanNumber variable value as its parameter
	}
}