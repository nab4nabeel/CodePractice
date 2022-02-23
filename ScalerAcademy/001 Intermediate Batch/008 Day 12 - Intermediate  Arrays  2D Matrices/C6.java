/* 

/* 

Square matrix

Q) Given a Square matrix mat[n][n] print boundaries in clock wise direction
	

mat[5][5]

1	2	3	4	5
6	7	8	9	10
11	12	13	14	15
16	17	18	19	20
21	22	23	24	25

output:

1	2	3	4	5	10	15	20	25	24	23	22	21	16	11	6


Idea: Prinnt only corders of rows leaving the last elements

1) Print 0th row			[0,0] > [0,3] : 4 Iterations
2) Print N-1th Col			[0,4] > [3,4] : 4 Iterations
3) Print N-1th row reverse	[4,4] > [4,1] : 4 Iterations
4) Print 0th Col			[4,0] > [1,0] : 4 Iterations


// Generalized Senario N*N matrin

0,0		....		0,N-1

.						.
.						.
.						.

N-1,0	....		N-1,N-1


1)[0,0]>[0,N-2]		: N-1 Iterations
2)[0,N-1]>[N-2,N-1]	: N-1 Iterations
3)[N-1,N-1]>[N-1,1]	: N-1 Iterations
4)[N-1,0]>[1,0]		: N-1 Iterations


Pseudocode:

(i,j)=(0,0)

for(k=1;k<n;k++){//to iterate N-1 times
	print(mat[i][j]);
	j++;
}

(i,j)=(0,N-1)
for(k=1;k<n;k++){//to iterate N-1 times
	print(mat[i][j]);
	i++;
}

(i,j)=(N-1,N-1)
for(k=1;k<n;k++){//to iterate N-1 times
	print(mat[i][j]);
	j--;
}

(i,j)=(N-1,0)
for(k=1;k<n;k++){//to iterate N-1 times
	print(mat[i][j]);
	i--;
}


 */
 

import java.io.*; 
import java.util.*; 
 
public class C6{
	
	
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

		System.out.println("\nPrinting boundary values in clock wise direction for Matrix of row: " + n +" and columns: " + m +"\n");
		
		int i=0,j=0;
		for(int k=1;k<n;k++){
			System.out.print(A[i][j] + "\t");
			j++;
		}
		for(int k=1;k<n;k++){
			System.out.print(A[i][j] + "\t");
			i++;
		}
		for(int k=1;k<n;k++){
			System.out.print(A[i][j] + "\t");
			j--;
		}
		for(int k=1;k<n;k++){
			System.out.print(A[i][j] + "\t");
			i--;
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

Printing boundary values in clock wise direction for Matrix of row: 5 and columns: 5

1	2	3	4	5	10	15	20	25	24	23	22	21	16	11	6	


 */