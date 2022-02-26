/* 

Q7. Spiral Order Matrix II


Problem Description
Given an integer A, generate a square matrix filled with elements from 1 to A2 in spiral order.



Problem Constraints
1 <= A <= 1000



Input Format
First and only argument is integer A


Output Format
Return a 2-D matrix which consists of the elements in spiral order.



Example Input
Input 1:

1
Input 2:

2


Example Output
Output 1:

[ [1] ]
Output 2:

[ [1, 2], [4, 3] ]


Example Explanation
Explanation 1:

 
Only 1 is to be arranged.
Explanation 2:

1 --> 2
      |
      |
4<--- 3

 */
 
 
public class Solution {
    public int[][] generateMatrix(int A) {
        int[][] C = new int[A][A];

        int x=0,y=0;
        int i=1;
        if(A==1){
            C[0][0]=1;
            return C;
        }
        while (A>=2){
            for(int k=1;k<A;k++){
                C[x][y]=i;
                i++;
                y++;
            }
            for(int k=1;k<A;k++){
                C[x][y]=i;
                i++;
                x++;
            }
            for(int k=1;k<A;k++){
                C[x][y]=i;
                i++;
                y--;
            }
            for(int k=1;k<A;k++){
                C[x][y]=i;
                i++;
                x--;
            }       
            x++;y++;A=A-2;   
            
        }
        if(A%2==1){
            C[x][y]=i;
        }
        //System.out.println(A%2==1||A%2==-1);
        //System.out.println(C[x][y]);
        return C;
    }
}


 /* 

Hint 1
This is more of a simulation problem.

Try to figure out when to change direction and when to terminate the algorithm.

Solution Approach
This is more of a simulation problem.

You need to maintain state indicating which direction you are traversing to ( left to right, right to left, top to down, down to top ) and then know when to change the directions.

Note that in each direction, either row or column remains constant.

Based on the constant row or column, you can predict when to change the direction.


 */
 
public class Solution {
    public ArrayList<ArrayList<Integer>> generateMatrix(int A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
	    int rows, cols;
	    int row, col;
	    rows = cols = A;
	    int num = 1;
	    int max = A * A;
	    for (int i = 0; i < rows; i++) {
	        res.add(new ArrayList<>());
	        for (int j = 0; j < rows; j++) {
	            res.get(i).add(0);
	        }
	    }
	    row = col = 0;
	    int dir = 0;
	    int layer = 0;
	    res.get(0).set(0, 1);
	    for (int step = 2; step <= A * A; step++) {
	        switch(dir) {
	            // Go right
	            case 0:
	                if (col == cols - layer - 1) {
	                    row++;
	                    dir = 1;
	                } 
	                else
	                    col++;
	                break;
	           // Go down     
	           case 1:
	               if (row == rows - layer - 1) {
	                   dir = 2;
	                   col--;
	               } else
	                   row++;
	               break;
	           // Go left    
	           case 2:
	               if (col == layer) {
	                   row--;
	                   dir = 3;
	               } else
	                   col--;
	               break;
	           // Go up    
	           case 3:
	               if (row == layer + 1) {
	                   dir = 0;
	                   col++;
	                   layer++;
	               } else
	                   row--;
	               break;
	        }
	        res.get(row).set(col, step);
	    }
	    return res;
	}
} 