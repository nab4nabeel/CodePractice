/* 

Q5. Matrix Subtraction


Problem Description

You are given two integer matrices A and B having same size(Both having same number of rows (N) and columns (M)). You have to subtract matrix A from B and return the resultant matrix. (i.e. return the matrix A - B).

If X and Y are two matrices of the same order (same dimensions). Then X - Y is a matrix of the same order as X and Y and its elements are obtained by subtracting the elements of Y from the corresponding elements of X. Thus if Z = [z[i][j]] = X - Y, then [z[i][j]] = [x[i][j]] – [y[i][j]].



Problem Constraints

1 <= N, M <= 103

-109 <= A[i][j], B[i][j] <= 109



Input Format

First argument is a 2D integer matrix A.

Second argument is a 2D integer matrix B.



Output Format

Return a 2D matrix denoting A - B.



Example Input

Input 1:

 A = [[1, 2, 3],            B = [[9, 8, 7],
      [4, 5, 6],                 [6, 5, 4],
      [7, 8, 9]]                 [3, 2, 1]]
Input 2:

 A = [[1, 1]]               B = [[2, 3]]


Example Output

Output 1:

 [[-8, -6, -4],
  [-2, 0, 2],
  [4, 6, 8]]
Output 2:

 [[-1, -2]]


Example Explanation

Explanation 1:

 image
Explanation 2:

 [[1, 1]] - [[2, 3]] = [[1 - 2, 1 - 3]] = [[-1, -2]]

 */
 
public class Solution {
    public int[][] solve(int[][] A, int[][] B) {
        int rowsA = A.length;
        int columnA = A[0].length;
        int rowsB = A.length;
        int columnB = A[0].length;
        
        int[][] C = new int[rowsA][columnB];

        for(int i=0;i<rowsA;i++){
            for(int j=0;j<columnA;j++){
                C[i][j] = A[i][j] - B[i][j];
            }
        }
        return C;
    }
}



 /* 

Hint 1
This is a simple implementation problem requiring knowledge of loops and 2D arrays.



Solution Approach
Below mentioned steps explains how we can find difference of two matrices:
=> To subtract two matrices we have to subtract their corresponding elements. For example, C[i][j] = A[i][j] - B[i][j].
=> Traverse both matrices row wise(first all elements of a row, then jump to next row) using two loops.
=> For every element A[i][j], subtract it with corresponding element B[i][j] and store the result in difference matrix at C[i][j].

public class Solution {
    public int[][] solve(int[][] A, int[][] B) {
        int N = A.length;
        int M = A[0].length;
    
        int[][] C = new int[N][M];
        
        for (int i = 0; i < N;i++){
            for (int j = 0; j < M;j++){
                C[i][j] = A[i][j] - B[i][j];
            }
        }
    
        return C;
    }
}

 */
 