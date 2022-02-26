/* 

Q1. Add the matrices

Problem Description

You are given two matrices A & B of same size, you have to return another matrix which is the sum of A and B.



Problem Constraints

1 <= A.size(), B.size() <= 1000

1 <= A[i].size(), B[i].size() <= 1000

1 <= A[i][j], B[i][j] <= 1000



Input Format

First argument is vector of vector of integers representing matrix A.

Second argument is vecotor of vector of integers representing matrix B.



Output Format

You have to return a vector of vector of integers after doing required operations.



Example Input

Input 1:

A = [[1, 2, 3],[4, 5, 6],[7, 8, 9]]
B = [[9, 8, 7],[6, 5, 4],[3, 2, 1]]


Example Output

Output 1:

[[10, 10, 10], [10, 10, 10], [10, 10, 10]]


Example Explanation

Explanation 1:

A + B = [[1+9, 2+8, 3+7],[4+6, 5+5, 6+4],[7+3, 8+2, 9+1]] = [[10, 10, 10], [10, 10, 10], [10, 10, 10]].

 */
 
 
public class Solution {
    public int[][] solve(int[][] A, int[][] B) {
        int rowsA = A.length;
        int coloumnsA = A[0].length;
        int rowsB = B.length;
        int coloumnsB = B[0].length;

        int[][] C = new int[rowsA][coloumnsA];

        for(int i=0;i< rowsA; i++){
            for(int j=0;j<coloumnsA; j++){
                C[i][j] = A[i][j] + B[i][j];
            }
        }
        return C;
    }
}

 /* 

Hint 1
Just intialize an ans vector and push sum of elements of both matrices accordingly.

Solution Approach
Run a outer loop from i = 1  to i = row,
    Run a inner loop from j = 1  to j = col, and do A[i][j] += B[i][j],
return the updated ans matrix.




 */