
public class Matrice {
	
	public static void main(String[] args){
		
		int[] niz = new int[5];
		int visina = 5, duzina = 3;
		int[][] matrica = new int[visina][];
		
		for(int i = 0; i < matrica.length; i++){
			matrica[i] = new int[ visina - i ];
		}
		
		
		for(int i = 0; i < matrica.length; i++ ){
			for(int j = 0; j < matrica[i].length; j++){
				System.out.print(matrica[i][j] + " ");
			}
			System.out.println();
		}
		
		
	}

}
