/* 

Q4. Range Sum Query

Problem Description

You are given an integer array A of length N.
You are also given a 2D integer array B with dimensions M x 2, where each row denotes a [L, R] query.
For each query, you have to find the sum of all elements from L to R indices in A (1 - indexed).
More formally, find A[L] + A[L + 1] + A[L + 2] +... + A[R - 1] + A[R] for each query.



Problem Constraints
1 <= N, M <= 105
1 <= A[i] <= 109
1 <= L <= R <= N



Input Format
The first argument is the integer array A.
The second argument is the 2D integer array B.



Output Format
Return an integer array of length M where ith element is the answer for ith query in B.



Example Input
Input 1:

A = [1, 2, 3, 4, 5]
B = [[1, 4], [2, 3]]

Input 2:

A = [2, 2, 2]
B = [[1, 1], [2, 3]]



Example Output
Output 1:

[10, 5]

Output 2:

[2, 4]



Example Explanation
Explanation 1:

The sum of all elements of A[1 ... 4] = 1 + 2 + 3 + 4 = 10.
The sum of all elements of A[2 ... 3] = 2 + 3 = 5.

Explanation 2:

The sum of all elements of A[1 ... 1] = 2 = 2.
The sum of all elements of A[2 ... 3] = 2 + 2 = 4.




 */
 
 
 public class Solution {
    public long[] rangeSum(int[] A, int[][] B) {
        int n=A.length;
        long[] result = new long[B.length];

        long[] PF = new long[n];
        PF[0] = A[0];
        for(int i=1; i < n; i++){
            PF[i] = PF[i-1] + A[i];
        }

        
        for(int m=0;m<B.length;m++){
            int L = B[m][0];
            int R = B[m][1];
            if(L==1){
                result[m] = PF[R-1];
            }else{
                result[m] = PF[R-1] - PF[L-2];                
            }
            
        }
        return result;
    }
}


/* 

Hint 1

The brute force approach is very simple. 
Think of any way to pre - process the given array to make the answering each query faster.

Solution Approach

We have to find a way to optimize the time complexity of answering our query.
We can do this by creating an auxilliary array pref, 
where pref[i] is the sum of all elements from the beginning to the i-th element.

We can easily create the pref array using the following equation: 
pref[i] = pref[i - 1] + A[i]

Now, we can answer all our queries in O(1). 
The answer to each query will be pref[R] - pref[L - 1].

Time Complexity : O(N)
Space Complexity : O(N)

Refer to the complete solution for more details.


public class Solution {
    public long[] rangeSum(int[] A, int[][] B) {
        int n = A.length;
        int m = B.length;
        long[] pref = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            pref[i] = pref[i - 1] + A[i - 1];
        }
        long[] ans = new long[m];
        for (int i = 0; i < m; i++) {
            ans[i] = pref[B[i][1]] - pref[B[i][0] - 1];
        }
        return ans;
    }


 */
