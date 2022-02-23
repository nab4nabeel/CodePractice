/* 


2D Matrices


int A[rows][columns]
int A[N][M]

0,0	0,1	0,2	0,3 .... 0,M-1
1,0	1,1	1,2	1,3 .... 1,M-1
2,0	2,1	2,2	2,3 .... 2,M-1
...
...
...
N-1,0 N-1,1		...	N-1,M-1


When we iterate on a row; columns inndex changes from [0,M-1]
When we iterate on a columns; rows index changes from [0,M-1]


Q) Given a matrix A[N][M] find max column wise sum

3	8	9	2
1	2	3	6
4	10	11	17

Idea:
For every column get sum and calculate overall sum

maxSum=INT_MIN
j=0;j<m;j++
	sum=0
	i=0;i<n;i++
		sum+=A[i][j]
	maxSum=Math.max(sum,maxSum)

T.C=O(N*M)
S.C=O(1)


 */


import java.io.*; 
import java.util.*; 
 
public class C1{
	
	
	public static void main(String[] args){
		int[][] A = {{3,8,9,2},{1,2,3,6},{4,10,11,13}};
		int n = A.length;//rows
		int m = A[0].length;//columns
		
		System.out.println("\nPrinting the index in Matrix of row: " + n +" and columns: " + m  +"\n");
		
		
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				System.out.print(i +","+ j + "\t");
			}
			System.out.println( );
		}
		
		System.out.println("\nPrinting the values in Matrix of row: " + n +" and columns: " + m +"\n");
		
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				System.out.print(A[i][j] + "\t");
			}
			System.out.println( );
		}
		
		System.out.println("\nFind max column wise sum \n");
		
		int maxColumnSum = Integer.MIN_VALUE;
		
		for(int j=0;j<m;j++){
			int sum=0;
			for(int i=0;i<n;i++){
				sum+=A[i][j];
			}
			System.out.println("\nColumn:"+ j +" e sum :"+ sum);
			maxColumnSum= Math.max(sum,maxColumnSum);
		}

		System.out.println("\n Max column wise sum :"+ maxColumnSum);
		
	}
	
}


/* 


Printing the index in Matrix of row: 3 and columns: 4

0,0	0,1	0,2	0,3	
1,0	1,1	1,2	1,3	
2,0	2,1	2,2	2,3	

Printing the values in Matrix of row: 3 and columns: 4

3	8	9	2	
1	2	3	6	
4	10	11	13	

Find max column wise sum 


Column:0 e sum :8

Column:1 e sum :20

Column:2 e sum :23

Column:3 e sum :21

 Max column wise sum :23

 */