
public class Matrice {

	public static void main(String[] args) {
		int[][] set1 ={{1,4,1},{1,0,0}};
		int[][] set2 ={{0,0,5},{7,5,0}};
		int[][] finalset = new int[2][3];

		for(int i=0;i<2;i++){
			for(int j=0;j<3;j++){
				if(set1[0][1] == 4){
					set1[0][1] = 3;
				}
				
				finalset[i][j] = (set1[i][j]+set2[i][j]);
				System.out.println(finalset[i][j]);
			}
		}
	}
}
