/* 

Q6. Matrix Transpose

Problem Description

You are given a matrix A, you have to return another matrix which is the transpose of A.

NOTE: Transpose of a matrix A is defined as - AT[i][j] = A[j][i] ; Where 1 ≤ i ≤ col and 1 ≤ j ≤ row



Problem Constraints

1 <= A.size() <= 1000

1 <= A[i].size() <= 1000

1 <= A[i][j] <= 1000



Input Format

First argument is vector of vector of integers A representing matrix.



Output Format

You have to return a vector of vector of integers after doing required operations.



Example Input

Input 1:

A = [[1, 2, 3],[4, 5, 6],[7, 8, 9]]
Input 2:

A = [[1, 2],[1, 2],[1, 2]]


Example Output

Output 1:

[[1, 4, 7], [2, 5, 8], [3, 6, 9]]
Output 2:

[[1, 1, 1], [2, 2, 2]]


Example Explanation

Explanation 1:

Cearly after converting rows to column and columns to rows of [[1, 2, 3],[4, 5, 6],[7, 8, 9]] we will get [[1, 4, 7], [2, 5, 8], [3, 6, 9]].

 */
 
public class Solution {
    public int[][] solve(int[][] A) {
        int rowsA = A.length;
        int columnA = A[0].length;
        int[][] C = new int[columnA][rowsA];

        for(int i=0;i<columnA;i++){
            for(int j=0;j<rowsA;j++){
                //System.out.print(A[i][j]+"\t");
                C[i][j] = A[j][i];
            }
            //System.out.println();
        }
        return C;
    }
}


 /* 

Hint 1
Just intialize an ans vector and push column by column elements into it.

Solution Approach
Run a outer loop from i = 1  to i = col,
    initialize a temp vector,
    Run a inner loop from j = 1  to j = row, and Push A[j][i]into temp,
    push temp in ans vector,
return the updated ans matrix.

C++

vector<vector<int> > Solution::solve(vector<vector<int> > &A) {
    int row = A.size(), col = A[0].size();
    vector<vector<int> > ans;
    for(int i = 0; i < col; i++){
        vector<int> temp;
        for(int j = 0; j < row; j++)
            temp.push_back(A[j][i]);
        ans.push_back(temp);
    }
    return ans;
}

 */