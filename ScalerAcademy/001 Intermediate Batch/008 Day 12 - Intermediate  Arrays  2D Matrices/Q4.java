/* 

Q4. Matrix Multiplication

Problem Description

You are given two integer matrices A(having M X N size) and B(having N X P). You have to multiply matrix A with B and return the resultant matrix. (i.e. return the matrix AB).

image



Problem Constraints

1 <= M, N, P <= 100

-100 <= A[i][j], B[i][j] <= 100



Input Format

First argument is a 2D integer matrix A.

Second argument is a 2D integer matrix B.



Output Format

Return a 2D integer matrix denoting AB.



Example Input

Input 1:

 A = [[1, 2],            B = [[5, 6],
      [3, 4]]                 [7, 8]] 
Input 2:

 A = [[1, 1]]            B = [[2],
                              [3]] 


Example Output

Output 1:

 [[19, 22],
  [43, 50]]
Output 2:

 [[5]]


Example Explanation

Explanation 1:

 image
Explanation 2:

 [[1, 1]].[[2, 3]] = [[1 * 2 + 1 * 3]] = [[5]]


 */
 
public class Solution {
    public int[][] solve(int[][] A, int[][] B) {
        int rowsA = A.length;
        int columnA = A[0].length;
        int rowsB = B.length;
        int columnB = B[0].length;
        
        int[][] C = new int[rowsA][columnB];
        if(columnA == rowsB){
            for(int i=0;i<rowsA;i++){
                for(int j=0;j<columnB;j++){
                    for(int k=0;k<rowsB;k++)
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        
            
        return C;
    }
}


 /* 

Hint 1
This is a simple implementation problem requiring knowledge of loops and 2D arrays.

Solution Approach
If two matrices A (M x N) and B (N x P) are multiplied, then the order of the resultant matrix C will be (M x P).

Algorithm
Begin
Define C matrix as (M x P) having initial values equal to 0.
for i in range 0 to M - 1, do
for j in range 0 to N – 1, do
for k in range 0 to P - 1, do
C[i, j] = C[i, j] + (A[i, k] * B[k, j])
done
done
done
End



 */
 
 
public class Solution {
    public int[][] solve(int[][] A, int[][] B) {
        int M = A.length;
        int N = A[0].length;
        int P = B[0].length;
    
        int[][] C = new int[M][P];
    
        for (int i = 0; i < M;i++){
            for (int j = 0; j < P;j++){
                C[i][j] = 0;
            }
        }
    
        for (int i = 0; i < M;i++){
            for (int j = 0; j < P;j++){
                for (int k = 0; k < N;k++){
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
    
        return C;
    }
}
 