/* 

Square matrix

Q) Given a Square matrix mat[n][n] roate it 90degree with O(1) Space complexity
	

Observation: No extra space > matrix itself has to change

mat[5][5]

1	2	3	4	5
6	7	8	9	10
11	12	13	14	15
16	17	18	19	20
21	22	23	24	25

expected output

21	16	11	6	1
22	17	12	7	2
23	18	13	8	3
24	19	14	9	4
25	20	15	10	5


Observation: 

If we look at the transpose of matrix:

transpose of above

1	6	11	16	21
2	7	12	17	22
3	8	13	18	23
4	9	14	19	24
5	10	15	20	25

90 degree roate can be formed by reverse every row from transpose of matrix

 */
 

import java.io.*; 
import java.util.*; 
 
public class C5{
	
	
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

		System.out.println("\nPrinting the values after roatinng the innnitial matrix by 90 degree, Using transpose matrix of row: " + n +" and columns: " + m +"\n");
		
		
		for(int i=0;i<n;i++){
			for(int j=0;j<m/2;j++){
				int temp = A[i][j];
				A[i][j] = A[i][m-1-j];
				A[i][m-1-j]= temp;
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
 
 
 /* 

Output:


Printing the values in Matrix of row: 5 and columns: 5

1	2	3	4	5	
6	7	8	9	10	
11	12	13	14	15	
16	17	18	19	20	
21	22	23	24	25	

Printing the values after transpose using upper right triangle Matrix of row: 5 and columns: 5

1	6	11	16	21	
2	7	12	17	22	
3	8	13	18	23	
4	9	14	19	24	
5	10	15	20	25	

Printing the values after roatinng the innnitial matrix by 90 degree, Using transpose matrix of row: 5 and columns: 5

21	16	11	6	1	
22	17	12	7	2	
23	18	13	8	3	
24	19	14	9	4	
25	20	15	10	5	



 */