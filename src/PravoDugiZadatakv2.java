
public class PravoDugiZadatakv2 {

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
				System.out.print(" | " + matrica[i][j] + " |");
			}
			System.out.println();
			for (int j = 0; j < matrica[i].length; j++) {
				System.out.print(" ____ ");
			}
			System.out.println();
		}
	}
	
	/**
	 * Mijenja vrijednost zadane matrice
	 * 
	 * @param matrica
	 * @return matrica sa novim brojem
	 */
	public static int[][] postaviVrijednost(int[][] matrica, int brojac) {
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

		
		int value = brojac % 2 + 1;

		matrica[x][y] = value;

		return matrica;

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
	
	public static boolean imaNule(int[][] matrica){
		
		for(int i = 0; i < matrica.length; i++){
			for(int j = 0; j < matrica[i].length; j++){
				if( matrica[i][j] == 0)
					return true;
			}
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		int visina;
		System.out.println("Unesi visinu: ");
		visina = TextIO.getlnInt();

		int[][] matrica = kreirajMatricu(visina, visina);
		ispisiMatricu(matrica);
		boolean trebaPonavljati = true;
		int brojac = 0;
		do {
			
			matrica = postaviVrijednost(matrica, brojac);
			
			for(int i = 0; i < matrica.length; i++){
				if( sviIstiRed(matrica[i]) == true && matrica[i][0] != 0){
					trebaPonavljati = false;
				}
			}
			
			for(int i = 0; i < matrica[0].length; i++){
				if( sviIstiKolona(matrica, i) == true && matrica[0][i] != 0){
					trebaPonavljati = false;
				}
			}
			
			if( sviIstiDijagonala(matrica) == true && matrica[0][0] != 0){
				trebaPonavljati = false;
			}
			if( sviIstiKontraDijagonala(matrica) == true && matrica[0][ matrica.length-1 ] != 0){
				trebaPonavljati = false;
			}
			brojac++;
			ispisiMatricu(matrica);
		}while( imaNule(matrica) == true && trebaPonavljati == true );
		brojac--;
		
		if( imaNule(matrica) == true || trebaPonavljati == false){
			System.out.println("Pobjednik je " + (brojac % 2 + 1));
		} else {
			System.out.println("Igraj ponovo");
		}
		
		
		ispisiMatricu(matrica);

	}

}
