public class caesar {
	
	// Rotate - function for shifting a character n letters
	// This function takes a character c and shifts it n letters
	// For example, if c = A and n = 1, it would return 'B'
	// If c = A and n = 2, it would return 'C', and so forth
	public static char rotate(char c, int n) {
		char answer = ' ';
		if (Character.isUpperCase(c)) {
			answer = (char)(((int) c + n - 65) % 26 + 65);
		}
		else {
			answer = (char)(((int) c + n - 97) % 26 + 97);
		}
		return answer;
	}
	
	// Cipher - function for adjustable Caesar Cipher
	// This function takes a string input and an offset integer n
	// It then uses the rotate function above to shift each character
	// in the string n characters, and returns the fully-shifted string
	public static String cipher(String input, int n) {
		String answer = "";
		int len = input.length();
		for (int i = 0; i < len; i++) {
			answer += rotate(input.charAt(i), n);
		}
		return answer;
	}
	
	// Polyalpha - function for simple polyalphabetic cipher
	// This function works just like the cipher function, but takes
	// two input integer offsets, n and z. It uses the n offset for every
	// even letter, and the z offset for every odd letter in the input
	// string.
	public static String polyalpha(String input, int n, int z) {
		String answer = "";
		int len = input.length();
		for (int i = 0; i < len; i++) {
			if(i % 2 == 0) {
				answer += rotate(input.charAt(i), n);
			}
			else {
				answer += rotate(input.charAt(i), z);
			}
		}
		return answer;
	}

	// Testing section
	public static void main(String[] args) {
		// This should return 'F' if your rotate function is working properly
		System.out.println(rotate('B', 30));
		// This should return 'URYYBJBEYQ' if your rotate and cipher functions are working properly
		System.out.println(cipher("HELLOWORLD", 13));
		// This should return 'HELLOWORLD' if your rotate and cipher functions are working properly
		System.out.println(cipher("URYYBJBEYQ", 13));
		// This should return 'UVYCBNBIYU' if your polyalpha function is working properly
		System.out.println(polyalpha("HELLOWORLD", 13, 17));
		System.out.println(decode("MAXLXVKXMBLMATMMABLBLGMLXVNKX"));
	}
	
	public static String decode(String input) {
		String answer = cipher(input, 7);
		return answer;
	}
}
