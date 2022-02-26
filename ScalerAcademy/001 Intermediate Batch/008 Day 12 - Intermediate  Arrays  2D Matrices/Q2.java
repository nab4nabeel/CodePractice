/* 

Q2. Anti Diagonals


Problem Description

Give a N * N square matrix A, return an array of its anti-diagonals. Look at the example for more details.


Problem Constraints

1<= N <= 1000
1<= A[i][j] <= 1e9


Input Format

First argument is an integer N, denoting the size of square 2D matrix.
Second argument is a 2D array A of size N * N.


Output Format

Return a 2D integer array of size (2 * N-1) * N, representing the anti-diagonals of input array A.
The vacant spaces in the grid should be assigned to 0.


Example Input

Input 1:
3
1 2 3
4 5 6
7 8 9
Input 2:

1 2
3 4


Example Output

Output 1:
1 0 0
2 4 0
3 5 7
6 8 0
9 0 0
Output 2:

1 0
2 3
4 0


Example Explanation

For input 1:
The first anti diagonal of the matrix is [1 ], the rest spaces shoud be filled with 0 making the row as [1, 0, 0].
The second anti diagonal of the matrix is [2, 4 ], the rest spaces shoud be filled with 0 making the row as [2, 4, 0].
The third anti diagonal of the matrix is [3, 5, 7 ], the rest spaces shoud be filled with 0 making the row as [3, 5, 7].
The fourth anti diagonal of the matrix is [6, 8 ], the rest spaces shoud be filled with 0 making the row as [6, 8, 0].
The fifth anti diagonal of the matrix is [9 ], the rest spaces shoud be filled with 0 making the row as [9, 0, 0].
For input 2:

The first anti diagonal of the matrix is [1 ], the rest spaces shoud be filled with 0 making the row as [1, 0, 0].
The second anti diagonal of the matrix is [2, 4 ], the rest spaces shoud be filled with 0 making the row as [2, 4, 0].
The third anti diagonal of the matrix is [3, 0, 0 ], the rest spaces shoud be filled with 0 making the row as [3, 0, 0].

 */
 
public class Solution {
    public int[][] diagonal(int[][] A) {

        int n = A.length;//rows
        int m= A[0].length;//columns
        int[][] R = new int[n+n-1][n];

        int p=0,q=0;
        for(int j=0;j<n;j++){
            int x=0,y=j;
            q=0;
            while(x<n && y>=0){
                R[p][q] = A[x][y];
                x++;y--;
                q++;
            }
            p++;
        }

        for(int i=1;i<n;i++){
            int x=i,y=n-1;
            q=0;
            while(x<n && y>=0){
                R[p][q] = A[x][y];
                x++;y--;
                q++;
            }
            p++;
        }

        return R;
    
    }
}


 /* 

Hint 1
Lets look at how the co-ordinates change when you move from one element to the other in the anti-diagonal.

With every movement, row increases by one, and the column decreases by one ( or in other words (1, -1) gets added to the current co-ordinates ).

Now, all we need to know is the start ( or the first element ) in each diagonal.

Can you figure out which elements qualify as the first elements in each diagonal ?


Solution Approach
Lets look at how the co-ordinates change when you move from one element to the other in the anti-diagonal.

With every movement, row increases by one, and the column decreases by one ( or in other words (1, -1) gets added to the current co-ordinates ).

Now, all we need to know is the start ( or the first element ) in each diagonal.

Can you figure out which elements qualify as the first elements in each diagonal ?



 */
 
public class Solution {
    public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {
        int l = A.size();
	    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 2 * l - 1; ++i) {
    	    int offset = i < l ? 0 : i - l + 1;
	        ArrayList<Integer> row = new ArrayList<Integer>();
	        int k=0;
    	    for (int j = offset; j <= i - offset; ++j) {
		        row.add(A.get(j).get(i - j));
		        k++;
    	    }
    	    for(int j = k; j< l ;j++){
    	        row.add(0);
    	    }
	        res.add(row);
        }
        return res;
    }
}
 