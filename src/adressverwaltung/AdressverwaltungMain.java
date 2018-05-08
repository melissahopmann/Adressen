package adressverwaltung;

import static adressverwaltung.AdressverwaltungUI.*;

public class AdressverwaltungMain {

	public static void main(String[] args) {

		int menue;

		do {

			menue = menueAnzeigen();

			System.out.println("Sie haben die Option " + menue + " gewählt.");

			if (menue == 1) {
				adressEingabe();
			}

			if (menue == 2) {
				adressAuflistung();
			}

			if (menue == 3) {
				adressAnzeige();
			}

			if (menue == 4) {
				adresseAendern();
			}

			if (menue == 5) {
				adresseLoeschen();

			}

			if (menue == 6) {

				System.out.println("Das Programm wurde beendet. Auf Wiedersehen!");
				System.exit(0);

			}
		} while (menue != 6);
	}

	
}
