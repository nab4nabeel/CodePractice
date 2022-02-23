/* 

Rectangular matrix


All Squares are Rectangles as well hence everything applied on Rectangle will apply on square as well

Q) Given a Rectangular matrix print all the diagnols  from Right to Left


mat[3][5]

0,0	0,1	0,2	0,3	0,4
1,0	1,1	1,2	1,3	1,4
2,0	2,1	2,2	2,3	2,4

Diagnols:
0,0
0,1>1,0
0,2>1,1>2,0
0,3>1,2>2,1
0,4>1,3>2,2
1,4>2,3
2,4


We can start the diagnols from first row to last column

0,0 till 2,4

Observations:
Diagnols R-L either can start form 0th row or Last Column
(No of elements in 0th row= N)
(No of elements in last column= M)

Hence, Total Diagnols = N + M-1 (-1 as top right is counted in both)


Idea:

Step 1: Print all the diagnols starting at 0th row (Thus all the N diagnols starting on 0th row will be printed)

(j=0; j<M; j++){
	(x,y)=(0,j);
	while(x<n && y>=0){
		print(Mat[x][y])
		x++,y--
	}
}

Remaining diagnols

Step 2: Print all the diagnols starting at 0th row (Thus all the N diagnols starting on 0th row will be printed)

(i=1;i<n;i++){
	(x,y)=(i,M-1);
	while(x<n && y>=0){
		print(Mat[x][y])
		x++,y--
	}
}

T.C=O(M*N)
S.C=O(1)

 */
 
 
import java.io.*;
import java.util.*;

public class C3{
	public static void main(String[] args){
			
		int[][] A = new int[3][5];
		int n = A.length;//rows
		int m = A[0].length;//columns
		
		System.out.println("\nPrinting the index of all diagnols in Matrix of row: " + n +" and columns: " + m  +"\n");
		
		//printing all the diagnols staring on 0th row
		for(int j=0;j<m;j++){
			int x=0,y=j;
			while(x<n && y>=0){
				System.out.print(x +","+y +" >\t");
				x++;y--;
			}
			System.out.println();
			
		}
		
		//print all the elements on last column i=0 diagnol is already printed
		for(int i=1;i<n;i++){
			int x=i,y=m-1;
			while(x<n && y>=0){
				System.out.print(x +","+y +" >\t");
				x++;y--;
			}
			System.out.println();
		}
	}
} 

/* 

Output

Printing the index of all diagnols in Matrix of row: 3 and columns: 5

0,0 >	
0,1 >	1,0 >	
0,2 >	1,1 >	2,0 >	
0,3 >	1,2 >	2,1 >	
0,4 >	1,3 >	2,2 >	
1,4 >	2,3 >	
2,4 >	

 */
