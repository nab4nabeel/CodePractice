/* 

Q8. Rotate Matrix


Problem Description

You are given a n x n 2D matrix A representing an image.

Rotate the image by 90 degrees (clockwise).

You need to do this in place.

Note: If you end up using an additional array, you will only receive partial score.



Problem Constraints

1 <= n <= 1000



Input Format

First argument is a 2D matrix A of integers



Output Format

Return the 2D rotated matrix.



Example Input

Input 1:

 [
    [1, 2],
    [3, 4]
 ]
Input 2:

 [
    [1]
 ]


Example Output

Output 1:

 [
    [3, 1],
    [4, 2]
 ]
Output 2:

 [
    [1]
 ]


Example Explanation

Explanation 1:

 After rotating the matrix by 90 degree:
 1 goes to 2, 2 goes to 4
 4 goes to 3, 3 goes to 1
Explanation 2:

 2D array remains the ssame as there is only element.
 
 

 */
 
public class Solution {
    public void solve(int[][] A) {
        int row=A.length;
        int column=A[0].length;

        for(int i=0;i<row;i++){
            for(int j=i;j<column;j++){
                int temp = A[i][j];
                A[i][j]=A[j][i];
                A[j][i]=temp;
            }
        }

        for(int i=0;i<row;i++){
            for(int j=0;j<column/2;j++){
                int temp = A[i][j];
                A[i][j]=A[i][column-1-j];
                A[i][column-1-j]=temp;
            }
        }

    }
}


 /* 

Hint 1
Lets say our matrix is ,

        * * * ^ * * *
        * * * | * * *
        * * * | * * *
        * * * | * * *
After rotating right, it appears (observe arrow direction)

        * * * *
        * * * *
        * * * *
        -- - - >
        * * * *
        * * * *
        * * * *
The idea is simple. Transform each row of source matrix into required column of final matrix.

From the above picture, we can observe that

first row of source ------> last column of destination
second row of source ------> last but-one column of destination
so ... on
last row of source ------> first column of destination
Thus, if we were allowed extra memory, the solution should be easy.

    result[j][matrix.size() - i - 1] = matrix[i][j];
Now that you know the basic relation, can you do it in place ( without using extra memory ) ?


 */
 
public class Solution {
    public void solve(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
	    if (A == null || n == 0)
	        return;
	    int layers = n;
	    for (int layer = 0; layer < layers / 2; layer++) {
	        int first = layer;
	        int last = n - layer - 1;
	        for (int i = first; i < last; i++) {
	            int offset = i - layer;
	            int top = A.get(first).get(i);
	            A.get(first).set(i, A.get(last - offset).get(first));
	            A.get(last - offset).set(first, A.get(last).get(last - offset));
	            A.get(last).set(last - offset, A.get(i).get(last));
	            A.get(i).set(last, top);
	        }
	    }
    }
} 