/* 

Square matrix

Q) Given a Square matrix mat[n][n] print diagnols:
	Top-left>bottom-right
	Top-right>bottom-left
	
-----------------------------
Top-left>bottom-right
	
mat[4][4]	

0,0
	1,1
		2,2
			3,3

i=0
while(i<n){
	print(mat[i][i])
	i++
}
T.C=O(N)
S.C=O(N)

-----------------------------

Top-right>bottom-left

mat[4][4]	

				0,3
			1,2
		2,1
	3,0

i=0;j=N-1
while(i<n && j>=0){
	print(mat[i][j])
	i++,j--
}
T.C=O(N)
S.C=O(N)


 */
 

import java.io.*; 
import java.util.*; 
 
public class C2{
	
	
	public static void main(String[] args){
		int[][] A = new int[4][4];
		int n = A.length;//rows
		int m = A[0].length;//columns
		
		System.out.println("\nPrinting the index of top left to bottom right diagnols in Matrix of row: " + n +" and columns: " + m  +"\n");
		
		int i=0;
		while(i<n){
			System.out.println(i+","+i);
			i++;
		}
		
		System.out.println("\nPrinting the index of top right to bottom left diagnols in Matrix of row: " + n +" and columns: " + m  +"\n");
		
		i=0;
		int j=n-1;
		while(i<n){
			System.out.println(i+","+j);
			i++;
			j--;
		}
	}
}

 
 