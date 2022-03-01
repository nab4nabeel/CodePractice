/* 

Q2. Christmas Trees

**Problem Description**

You are given an array A consisting of heights of Christmas trees, and an array B of same size consisting of the cost of each of the trees (Bi is the cost of tree Ai, where 1 ≤ i ≤ size(A)), and you are supposed to choose 3 trees (let's say, indices p, q and r), such that Ap < Aq < Ar, where p < q < r.
The cost of these trees is Bp + Bq + Br.

You are to choose 3 such trees, so they have the minimum cost and find the minimum cost.

If not possible to choose 3 such trees, return -1.



**Problem Constraints**

1 <= A[i], B[i] <= 109
3 <= size(A) = size(B) <= 3000



**Input Format**

First argument is an integer array A.
Second argument is an integer array B.



**Output Format**

Return an integer denoting the minimum cost of choosing 3 trees whose heights are strictly in increasing order, if not possible, -1.



**Example Input**

Input 1:

 A = [1, 3, 5]
 B = [1, 2, 3]
Input 2:

 A = [1, 6, 4, 2, 6, 9]
 B = [2, 5, 7, 3, 2, 7]


**Example Output**

Output 1:

 6 
Output 2:

 7 


**Example Explanation**

Explanation 1:

 We can choose the trees with indices 1, 2 and 3, and the cost is 1 + 2 + 3 = 6. 


 */
 
public class Solution {
    public int solve(int[] A, int[] B) {
        int sizeA = A.length;
        int sizeB = B.length;

        if(sizeA<3){
            return -1;
        }

        int minCost = Integer.MAX_VALUE;
        
        /* // Brute Force TLE Solution

        for(int i=0; i< sizeA; i++){
            for(int j=i+1; j< sizeA; j++){
                if(A[i]<A[j]){
                    for(int k=j+1; k< sizeA; k++){
                        if(A[j]<A[k]){
                            minCost = Math.min(minCost, B[i]+B[j]+B[k]);
                        }
                        
                    }

                }
            }
        }
        */

        for(int j=1;j<sizeA-1;j++){
            int leftLeast = getLeftMin(A,B,j);
            int rightLeast = getRightMin(A,B,j);
            if(leftLeast != Integer.MAX_VALUE && rightLeast != Integer.MAX_VALUE){
                minCost = Math.min(minCost, leftLeast+B[j]+rightLeast);
            }
        }
        return (minCost== Integer.MAX_VALUE) ? -1 : minCost ;
    }

    public static int getLeftMin(int[] A, int[] B, int index){
        int leastValue = Integer.MAX_VALUE;        
        for(int i=index-1;i>=0;i--){
            if(A[i]<A[index] && B[i]<leastValue){
                leastValue = B[i];
            }
        }
        return leastValue;
    }

    public static int getRightMin(int[] A, int[] B, int index){
        int leastValue = Integer.MAX_VALUE;
        for(int k=index+1;k<A.length;k++){
            if(A[k]>A[index] && B[k]<leastValue){
                leastValue = B[k];
            }
        }
        return leastValue;
    }
}
 /* 

Hint 1
As the constraints for size(A) is upto 3000, we see that an O(n2) solution should pass, as 300^2 is < 10^8.

Hence, we can think of an O(n2) solution, where we can fix one element, and traverse the other elements that satisfy our condition.

Solution Approach
To solve this, let’s take three indices, p, q and r.

p is the index of the tree that is to be chosen first, i.e. the one with the smallest height.
q is the index of the tree that is to be chosen second, i.e. the one with the middle height.
r is the index of the tree that is to be chosen third, i.e. the one with the largest height.
We should now traverse the array by fixing index q. Lets N be the size of the array.

For q, that goes from index 2 to N-1, we can find an index p that goes from 2 to q-1 such that A[p] < A[q], and C[p] is minimum.
Similarly, find an index r that goes from q+1 to N such that A[r] > A[q], and C[r] is minimum.

This way, for all q we can find the minimum values, and we choose the minimum values from all the q values.


 */
 
 public class Solution {
  public int solve(int[] A, int[] C) {
    long n = A.length;
    long min_ans = Long.MAX_VALUE;
    for (int q = 1; q < n - 1; q++) { //traversing over q
      long mid = (long) A[q];
      long minn = Long.MAX_VALUE;
      long ans = 0;
      for (int p = 0; p < q; p++) { //finding minimum cost height < A[q]
        if (A[p] < mid) {
          minn = Math.min((long) C[p], minn);
        }
      }
      if (minn == Long.MAX_VALUE) { //if it doesn't exist, skip
        continue;
      } else ans += minn;
      minn = Long.MAX_VALUE;
      for (int r = (int) q + 1; r < (int) n; r++) { //finding minimum cost height > A[q]
        if (A[r] > mid) {
          minn = Math.min((long) C[r], minn);
        }
      }
      if (minn == Long.MAX_VALUE) { //if it doesn't exist, skip
        continue;
      } else ans += minn;
      ans += C[q];
      min_ans = Math.min(min_ans, ans);
    }
    if (min_ans == Long.MAX_VALUE) { //if doesnt exist, return -1
      return -1;
    } else return (int) min_ans;
  }
}