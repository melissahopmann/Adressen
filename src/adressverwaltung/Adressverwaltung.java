package adressverwaltung;

import static utilities.Utilities.*;

public class Adressverwaltung {

	private static final String[][] ADRESS_DB = new String[100][4];

	public static void main(String[] args) {

		int menue = menueAnzeigen();
		
		System.out.println("Sie haben " + menue + " gew�hlt.");

	}

	private static int menueAnzeigen() {
		int menue;

		do {
			System.out.println("W�hlen Sie aus dem Men� aus:");
			System.out.println("1. Adresse eingeben");
			System.out.println("2. Alle Adressen anzeigen");
			System.out.println("3. bestimmte Adresse anzeigen");
			System.out.println("4. Adresse �ndern");
			System.out.println("5. Adresse l�schen");
			System.out.println("6. Beenden");
			menue = readInt("Auswahl: ");
		} while (menue < 1 || menue > 6);
		return menue;
	}
}
