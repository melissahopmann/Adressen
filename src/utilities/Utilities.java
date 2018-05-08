package utilities;

import java.util.Scanner;

public class Utilities {

	public static Scanner scanner = new Scanner(System.in);

	// Eingabe einer Zahl inkl. Fehlerbehandlung
	public static int readInt(String prompt) {

		int result = 0;
		boolean zahl = false;

		while (zahl == false) {
			try {
				System.out.print(prompt);
				result = scanner.nextInt();
				zahl = true;
			} catch (Exception ex) {
				System.out.println("Bitte geben Sie eine Zahl ein! ");
			}
			scanner.nextLine();
		}

		return result;
	}

	public static String readString(String prompt) {
		System.out.print(prompt);
		return scanner.nextLine();
	}
}
