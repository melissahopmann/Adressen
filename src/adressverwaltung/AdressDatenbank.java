package adressverwaltung;

public class AdressDatenbank {

	private static final int MAX_ADRESSES = 100;
	public static final int NR_OF_COLUMNS = 4;

	private static final String[][] ADRESS_DB = new String[MAX_ADRESSES][NR_OF_COLUMNS];
	private static int nextAdress = 0;

	public static String[][] alleAdressen() {
		int anzahlAdressen = anzahlAdressen();
		String[][] gesamtAdressen = new String[anzahlAdressen][NR_OF_COLUMNS];

		int k = 0;
		for (int i = 0; i < MAX_ADRESSES; i++) {
			if (ADRESS_DB[i][0] != null) {
				gesamtAdressen[k] = ADRESS_DB[i];
				k++;
			}
		}
		return gesamtAdressen;
	}

	public static String[] gibAdresseN(int n) {
		String[] adresse = new String[NR_OF_COLUMNS];

		int index = bestimmeIndexDesNtenSatzes(n);
		if (index != -1) {
			adresse = ADRESS_DB[index];
		}
		return adresse;
	}

	public static void loescheAdresseN(int n) {

		int index = bestimmeIndexDesNtenSatzes(n);

		if (index != -1) {
			ADRESS_DB[index] = new String[NR_OF_COLUMNS];
		}
	}
	
	public static void adressenfeldAendern(int satznummer, int feldnummer, String neuerWert) {
		
		int feldIndex = feldnummer - 1;
		int satzIndex = bestimmeIndexDesNtenSatzes(satznummer);
		
		if (satzIndex != -1) {
			ADRESS_DB[satzIndex][feldIndex] = neuerWert;
		}
	}

	private static int bestimmeIndexDesNtenSatzes(int n) {

		int zaehler = 0;
		for (int i = 0; i < MAX_ADRESSES; i++) {
			if (ADRESS_DB[i][0] != null) {
				zaehler++;
				if (zaehler == n) {
					return i;
				}
			}
		}
		return -1;
	}
	

	public static int anzahlAdressen() {
		int anzahlAdressen = 0;
		for (int i = 0; i < MAX_ADRESSES; i++) {
			if (ADRESS_DB[i][0] != null) {
				anzahlAdressen++;
			}
		}
		return anzahlAdressen;
	}

	public static void adresseSpeichern(String name, String strasse, String ort, String plz) {
		ADRESS_DB[nextAdress] = new String[] { name, strasse, ort, plz };
		nextAdress++;
	}

	public static void adresseLoeschen(int zeileLoeschen) {
		ADRESS_DB[nextAdress] = new String[] { null, null, null, null };
	}
}
