public class PravoDugZadatak {

	/**
	 * Kreira i vraca matricu zadanih dimenzija
	 * 
	 * @param visina
	 * @param sirina
	 * @return prazna matrica zadanih dimenzija
	 */
	public static int[][] kreirajMatricu(int visina, int sirina) {
		int[][] matrica = new int[visina][sirina];
		return matrica;
	}

	/**
	 * Ispisuje matricu poslanu kao argument na standardni izlaz
	 * 
	 * @param matrica
	 *            matricu koju zelimo ispisati
	 */
	public static void ispisiMatricu(int[][] matrica) {
		for (int i = 0; i < matrica.length; i++) {
			for (int j = 0; j < matrica[i].length; j++) {
				System.out.print(matrica[i][j] + " ");
			}
			System.out.println();
		}
	}

	/**
	 * Trazi unos koordinate od korisnika
	 * 
	 * @param min
	 *            najmanja moguca vrijednost koordinate
	 * @param max
	 *            najveca moguca vrijednost koordinate
	 * @return unesena koordinata
	 */
	public static int unosKoordinate(int min, int max) {
		System.out.println("Unesi koordinatu x: ");
		int koordinata = TextIO.getlnInt();
		while (koordinata < min || koordinata > max) {
			System.out.println("Koordinata nije validna.\nUnesi koordinat: ");
			koordinata = TextIO.getlnInt();
		}
		return koordinata;
	}

	/**
	 * Mijenja vrijednost zadane matrice
	 * 
	 * @param matrica
	 * @return matrica sa novim brojem
	 */
	public static int[][] postaviVrijednost(int[][] matrica) {
		int x = 0, y = 0;
		do {
			System.out.println("Unesi koordinatu x: ");
			x = TextIO.getlnInt();
			while (x < 0 || x >= matrica.length) {
				System.out
						.println("Koordinata nije validna.\nUnesi koordinatu x: ");
				x = TextIO.getlnInt();
			}

			System.out.println("Unesi koordinatu y: ");
			y = TextIO.getlnInt();
			while (y < 0 || y >= matrica[x].length) {
				System.out
						.println("Koordinata nije validna.\nUnesi koordinatu y: ");
				y = TextIO.getlnInt();
			}
		} while (matrica[x][y] != 0);

		System.out.println("Koji broj: ");
		int value = TextIO.getlnInt();

		matrica[x][y] = value;

		return matrica;

	}
	
	/**
	 * Racuna sumu u jednom redu
	 * @param red niz brojeva
	 * @return suma clanova tog niza
	 */
	public static int sumaReda(int[] red){
		int suma = 0;
		for(int i = 0; i < red.length; i++){
			suma += red[i];
		}
		return suma;
	}
	
	/**
	 * Vraca sumu clanova kolone u matrici
	 * @param matrica dvodimenzionalni niz
	 * @param kolona kolona za koju zelimo dobiti sumu
	 * @return suma clanova kolone
	 */
	public static int sumaKolone(int[][] matrica, int kolona){
		int suma = 0;
		for(int i = 0; i < matrica.length; i++){
			suma += matrica[i][kolona];
		}
		return suma;
	}
	
	/**
	 * Vraca sumu elemenata da dijagonali matrice
	 * @param matrica matrica za koju racunamo sumu
	 * @return suma elemenata na dijagonali
	 */
	public static int zbirNaDiagonali(int[][] matrica){
		int sum = 0;
		for(int i = 0; i < matrica.length; i++){
			sum += matrica[i][i];
		}
		return sum;
	}
	
	/**
	 * Vraca sumu elemenata da kontra dijagonali matrice
	 * @param matrica matrica za koju racunamo sumu
	 * @return suma elemenata na kontra dijagonali
	 */
	public static int zbirNaKontraDiagonali(int[][] matrica){
		int sum = 0;
		int j = matrica.length - 1;
		for(int i = 0; i < matrica.length; i++){
			sum += matrica[i][ j - i];
		}
		return sum;
	}
	
	/**
	 * Provjerava da li su svi elementi u redu jednaki
	 * @param red niz elemenata
	 * @return true ako su svi elementi jednaki false u suprotnom
	 */
	public static boolean sviIstiRed(int[] red){
		for(int i = 1; i < red.length; i++){
			if( red[i-1] != red[i] )
				return false;
		}
		return true;
	}
	
	/**
	 * Provjerava da li su svi elementi u koloni jednaki
	 * @param matrica
	 * @param kolona index kolone koju provjeravamo
	 * @return true ako su elementi jednaki, false u suprotnom
	 */
	public static boolean sviIstiKolona(int[][] matrica, int kolona){
		int prviClan = matrica[0][kolona];
		for(int  i = 1; i < matrica.length; i++){
			if( prviClan != matrica[i][kolona] )
				return false;
		}
		return true;
	}
	
	/**
	 * Vraca sumu elemenata da dijagonali matrice
	 * @param matrica matrica za koju racunamo sumu
	 * @return suma elemenata na dijagonali
	 */
	public static boolean sviIstiDijagonala(int[][] matrica){
		for(int i = 1; i < matrica.length; i++){
			if( matrica[i-1][i-1] != matrica[i][i])
				return false;
		}
		return true;
	}
	
	/**
	 * Vraca sumu elemenata da kontra dijagonali matrice
	 * @param matrica matrica za koju racunamo sumu
	 * @return suma elemenata na kontra dijagonali
	 */
	public static boolean sviIstiKontraDijagonala(int[][] matrica){
		int j = matrica.length - 1;
		for(int i = 1; i < matrica.length; i++){
			int k = j - i;
			if(matrica[i-1][k + 1] != matrica[i][k]){
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {

		int visina, sirina;
		System.out.println("Unesi visinu: ");
		visina = TextIO.getlnInt();
		System.out.println("Unesi sirinu: ");
		sirina = TextIO.getlnInt();

		int[][] matrica = kreirajMatricu(visina, sirina);
		ispisiMatricu(matrica);

		matrica = postaviVrijednost(matrica);

		ispisiMatricu(matrica);
		matrica = postaviVrijednost(matrica);
		ispisiMatricu(matrica);
		
		System.out.println("Suma redova: ");
		for (int i = 0; i < matrica.length; i++) {
			int suma = sumaReda(matrica[i]);
			System.out.println(suma);
		}
		System.out.println("Suma kolona: ");
		for (int i = 0; i < matrica[0].length; i++) {
			int suma = sumaKolone(matrica, i);
			System.out.println(suma);
		}
		System.out.println("Suma na dijagonali: " 
		+ zbirNaDiagonali(matrica));
		
		System.out.println("Suma na dijagonali: " 
				+ zbirNaKontraDiagonali(matrica));
	
		System.out.println("Svi isti red: ");
		for(int i = 0; i < matrica.length; i++){
			System.out.println(sviIstiRed(matrica[i]));
		}
		
		System.out.println("Svi isti kolona: ");
		for(int i = 0; i < matrica[0].length; i++){
			System.out.println(sviIstiKolona(matrica, i));
		}
		
		System.out.println("Svi isti dijagonala " + sviIstiDijagonala(matrica));
		System.out.println("Svi isti kontra dijagonala: " + sviIstiKontraDijagonala(matrica));
		
		
		
	}

}
