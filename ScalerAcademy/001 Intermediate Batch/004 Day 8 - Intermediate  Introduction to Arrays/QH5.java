/* 

Q5. Multiple left rotations of the array


Problem Description

Given an array of integers A and multiple values in B which represents number of times array A needs to be left rotated.

Find the rotated array for each value and return the result in the from of a matrix where i'th row represents the rotated array for the i'th value in B.



Problem Constraints

1 <= length of both arrays <= 2000 -10^9 <= A[i] <= 10^9 0 <= B[i] <= 2000


Input Format

The first argument given is the integer array A.
The second argument given is the integer array B.


Output Format

Return the resultant matrix.


Example Input

Input 1:

 
    A = [1, 2, 3, 4, 5]
    B = [2, 3]


Input 2:

  
    A = [5, 17, 100, 11]
    B = [1]




Example Output

Output 1:

 
    [ [3, 4, 5, 1, 2]
     [4, 5, 1, 2, 3] ]



Output 2:


    
    [ [17, 100, 11, 5] ]




Example Explanation

for input 1 -> B[0] = 2 which requires 2 times left rotations

1: [2, 3, 4, 5, 1]

2: [3, 4, 5, 1, 2]

B[1] = 3 which requires 3 times left rotation

1: [2, 3, 4, 5, 1]

2: [3, 4, 5, 1, 2]

2: [4, 5, 1, 2, 4]

 */
 
 
public class Solution {
    public int[][] solve(int[] A, int[] B) {

        int[][] S = new int[B.length][A.length];
        
        for(int i = 0; i < B.length; i++){
            int[] C = new int[A.length];
            for (int k = 0; k < A.length; k++) {
                C[k] = A[k];
            }
            int rotations = B[i] % A.length;
            this.reverseArray(C, 0, A.length-1);
            this.reverseArray(C, 0, A.length-rotations-1);
            this.reverseArray(C, A.length-rotations, A.length-1);
            
            for(int m=0; m < A.length; m++){
                S[i][m] = C[m];
            }       
        }

        return S;
    }

    public void reverseArray(int[] Arr, int start, int end){
        int i=start, j=end;
        while(i<=j){
            int temp = Arr[i];
            Arr[i] = Arr[j];
            Arr[j] = temp;
            i++;j--;
        }
    }
}

public class Solution2 {
    public int[][] solve(int[] A, int[] B) {

        int[][] S = new int[B.length][A.length];

        for(int i = 0; i < B.length; i++){
            for(int m=0; m < A.length; m++){
                int index = (m+B[i]) % A.length;
                S[i][m] = A[index];
            }
        }

        return S;
    }

 /* 

Hint 1

Try to reduce the number of rotations below arrays size and then perform rotations


Solution Approach

If we are required to do K left rotations , we can append first K elements of the array to the back and delete and delete them from front

If K is greater than size of the array we can simply perform modulo on it with array size as after exactly rotation of array’s size times the array return to it original state




public class Solution {
    public ArrayList<ArrayList<Integer>> solve(ArrayList<Integer> a, ArrayList<Integer> b) {
        ArrayList< ArrayList<Integer> > ans = new ArrayList<>();
        int n = a.size();
        for(int x : b) {
            ArrayList<Integer> temp = new ArrayList<>();
            for(int i = 0; i < n; i++)  temp.add(a.get( (i+x) % n ));
            ans.add(temp);
        }
        return ans;
    }
}




 */