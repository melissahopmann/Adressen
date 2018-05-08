package adressverwaltung;

import static adressverwaltung.AdressDatenbank.NR_OF_COLUMNS;
import static adressverwaltung.AdressDatenbank.adresseSpeichern;
import static adressverwaltung.AdressDatenbank.*;
import static utilities.Utilities.readInt;
import static utilities.Utilities.readString;

public class AdressverwaltungUI {

	public static int menueAnzeigen() {
		int menue;
		do {
			System.out.println("\n\n\n\n\n\n\n\n\n");
			System.out.println("W�hlen Sie aus dem Men� aus:");
			System.out.println("1. Adresse eingeben");
			System.out.println("2. Alle Adressen anzeigen");
			System.out.println("3. bestimmte Adresse anzeigen");
			System.out.println("4. Adresse �ndern");
			System.out.println("5. Adresse l�schen");
			System.out.println("6. Beenden");

			menue = readInt("Auswahl: ");

			if (menue < 1 || menue > 6) {
				System.out.println("Bitte geben Sie eine g�ltige Zahl ein! ");
			}
		} while (menue < 1 || menue > 6);
		return menue;
	}

	public static void adressEingabe() {

		String name = readString("Bitte geben Sie den Namen ein: ");
		String strasse = readString("Bitte geben Sie Stra�e und Hausnummer an: ");
		String ort = readString("Bitte geben Sie den Ort ein: ");
		String plz = readString("Bitte geben Sie die Postleitzahl ein: ");

		System.out.println();

		adresseSpeichern(name, strasse, ort, plz);
	}

	public static void adressAuflistung() {
		String[][] adressen = alleAdressen();
		int anzahl = adressen.length;

		for (int zeilenZ = 0; zeilenZ < anzahl; zeilenZ++) {
			for (int spaltenZ = 0; spaltenZ < NR_OF_COLUMNS; spaltenZ++) {
				System.out.print(adressen[zeilenZ][spaltenZ]);
				if (spaltenZ < NR_OF_COLUMNS - 1) {
					System.out.print(", ");
				}
			}
			System.out.println();
		}
	}

	public static void adressAnzeige() {
		int adressNr = adressAuswahl("W�hlen Sie aus, welche Adresse Sie anzeigen m�chten: ");

		String[] adresse = gibAdresseN(adressNr);

		for (int spalte = 0; spalte < NR_OF_COLUMNS; spalte++)
			System.out.print(adresse[spalte] + " ");
	}

	public static int adressAuswahl(String prompt) {
		int adressNr;
		do {
			adressNr = readInt(prompt);
			if (adressNr < 1 || adressNr > anzahlAdressen()) {
				System.out.println("Bitte geben Sie eine Zahl zwischen 1 und " + anzahlAdressen() + " ein.");
			}
		} while (adressNr < 1 || adressNr > anzahlAdressen());
		return adressNr;
	}

	public static void adresseAendern() {

		int keineWeitereAenderung = 5;
		int adressNr = adressAuswahl("W�hlen Sie aus, welche Adresse Sie �ndern m�chten: ");
		int feldIndex = aenderungsFeldAuswahl();

		while (feldIndex != keineWeitereAenderung) {

			System.out.println(feldIndexUebersetzen(feldIndex));
			
			String neuerWert = readString("Bitte geben Sie den neuen Wert ein: ");
			
			adressenfeldAendern (adressNr, feldIndex, neuerWert);

			feldIndex = aenderungsFeldAuswahl();
		}
	}

	private static String feldIndexUebersetzen(int feldIndex) {
		switch (feldIndex) {
		case 1:
			return "Den Namen eingeben.";
		case 2:
			return "Die Stra�e eingeben.";
		case 3:
			return "Den Ort eingeben.";
		case 4:
			return "Die Postleitzahl eingeben.";
		}
		return "";
	}

	public static int aenderungsFeldAuswahl() {
		int menue;
		do {
			System.out.println();
			System.out.println("W�hlen Sie aus folgenden Optionen:");
			System.out.println("1. Namen �ndern");
			System.out.println("2. Stra�e und Hausnummer �ndern");
			System.out.println("3. Ort �ndern");
			System.out.println("4. Postleitzahl �ndern");
			System.out.println("5. Fertig!");

			menue = readInt("Auswahl: ");

			if (menue < 1 || menue > 5) {
				System.out.println("Bitte geben Sie eine g�ltige Option ein! ");
			}
		} while (menue < 1 || menue > 5);

		return menue;
	}

	public static void adresseLoeschen() {
		int adressNr = adressAuswahl("W�hlen Sie aus, welche Adresse Sie l�schen m�chten: ");

		loescheAdresseN(adressNr);
	}
}
