package utilities;

import java.util.Scanner;

public class Utilities {
	
	private static Scanner scanner = new Scanner(System.in);

	public static int readInt(String prompt) {

		int result = 0;
		boolean test = false;

		while (test == false) {
			try {
				System.out.print(prompt);
				result = scanner.nextInt();
				test = true;
			} catch (Exception ex) {
				System.out.println("Bitte geben Sie eine Zahl ein! ");
				scanner.nextLine();
			}
		}

		return result;
	}

}
