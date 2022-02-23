/* 

Square matrix

Q) Given a Square matrix mat[n][n] find transpose without extra space
	

Observation: No extra space > matrix itself has to change

mat[5][5]

1	2	3	4	5
6	7	8	9	10
11	12	13	14	15
16	17	18	19	20
21	22	23	24	25


transpose of above

1	6	11	16	21
2	7	12	17	22
3	8	13	18	23
4	9	14	19	24
5	10	15	20	25


Idea:
Observation: 
1) Diagnol values from top left to bottom right reamains same
2) 
0,1 swaps with 1,0
0,2 swaps with 2,0
3,2 swaps with 2,3
Thus i,j is swapping to j,i
3) we need to swap with only any one triangle of diagnol as if we iterate on whole matrix and swap we will get the same matrix

Psuedo Code:

Iterate over upper triangle



*/



import java.io.*; 
import java.util.*; 
 
public class C4{
	
	
	public static void main(String[] args){
		int[][] A = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
		int n = A.length;//rows
		int m = A[0].length;//columns
		
		System.out.println("\nPrinting the values in Matrix of row: " + n +" and columns: " + m +"\n");
		
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				System.out.print(A[i][j] + "\t");
			}
			System.out.println( );
		}

		System.out.println("\nPrinting the values after transpose using upper right triangle Matrix of row: " + n +" and columns: " + m +"\n");
		
		for(int i=0;i<n;i++){
			for(int j=i;j<m;j++){
				int temp = A[i][j];
				A[i][j] = A[j][i];
				A[j][i] = temp;
			}
		}

		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				System.out.print(A[i][j] + "\t");
			}
			System.out.println( );
		}

		System.out.println("\nPrinting the values after transpose using lower left triangle Matrix of row: " + n +" and columns: " + m +"\n");
		
		
		for(int i=0;i<n;i++){
			for(int j=0;j<=i;j++){
				int temp = A[i][j];
				A[i][j] = A[j][i];
				A[j][i] = temp;
			}
		}

		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				System.out.print(A[i][j] + "\t");
			}
			System.out.println( );
		}

	}
	
}

