/* 

Q1. Max Sum Contiguous Subarray	(Video)

Problem Description
Find the contiguous non empty subarray within an array, A of length N which has the largest sum.



Problem Constraints
1 <= N <= 1e6
-1000 <= A[i] <= 1000



Input Format
The first and the only argument contains an integer array, A.



Output Format
Return an integer representing the maximum possible sum of the contiguous subarray.



Example Input
Input 1:

 A = [1, 2, 3, 4, -10] 
Input 2:

 A = [-2, 1, -3, 4, -1, 2, 1, -5, 4] 


Example Output
Output 1:

 10 
Output 2:

 6 


Example Explanation
Explanation 1:

 The subarray [1, 2, 3, 4] has the maximum possible sum of 10. 
Explanation 2:

 The subarray [4,-1,2,1] has the maximum possible sum of 6. 


 */

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int maxSubArray(final int[] A) {
        int N = A.length;
        int[] pfSum = new int[N];
        pfSum[0] = A[0];
        for(int i=1;i<N;i++){
            pfSum[i] = pfSum[i-1] + A[i];
        }
        //System.out.println(Arrays.toString(pfSum));
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<N;i++){
            for(int j=i;j<N;j++){
                int sum=0;
                sum += getPrefixSum(pfSum,i,j);
                ans=Math.max(sum,ans);
            }
        }
        return ans;
    }

    public int getPrefixSum(int[] pfSum, int L, int R){
        if(L==0){
            return pfSum[R];
        }
        return pfSum[R]-pfSum[L-1];
    }
}

 /* Above solution throws TLE as T.C=O(N2) as input Constraints 10^6 it goes beyound 10^8

 */
 


 /* 
	optimal Solution with T.C=O(N)

 */
 
public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int maxSubArray(final int[] A) {
        int N = A.length;
        //System.out.println(Arrays.toString(pfSum));
        int max_sum = Integer.MIN_VALUE;
        int cur_sum=0;
        for(int i=0;i<N;i++){
                cur_sum += A[i];
                max_sum=Math.max(max_sum,cur_sum);
                if(cur_sum<0){
                    cur_sum=0;
                }
        }
        return max_sum;
    }
}
 
 
 
 /* 

Hint 1
O(n^3) solution is simple.

You look at every pair (i,j) and compute the sum of elements between i and j and then take the maximum of the sums.

Obviously, this is not the best solution.

Next improvement is O(n^2) when you notice that you don’t need to sum up all the elements between i and j. You can just add A[j] to the sum you have already calculated in the previous loop from i to j-1.

However, we are looking for something better than N^2.

For O(n) solution can you look at optimal subarray and deduce some observations from it?
If you start taking every element greedily when should you stop?


Solution Approach
Let us say Ai, Ai+1 … Aj is our optimal solution.

Note that no prefix of the solution will ever have a negative sum.

Let us say Ai … Ak prefix had a negative sum.

Sum ( Ai Ai+1 … Aj ) = Sum (Ai … Ak) + Sum(Ak+1 … Aj)

Sum ( Ai Ai+1 … Aj) - Sum(Ak+1 … Aj) = Sum(Ai … Ak)

Now, since Sum(Ai … Ak) < 0,

Sum (Ai Ai+1 … Aj) - Sum (Ak+1 … Aj) < 0

which means Sum(Ak+1 … Aj ) > Sum (Ai Ai+1 … Aj)

This contradicts the fact that Ai, Ai+1 … Aj is our optimal solution.

Instead, Ak+1, Ak+2 … Aj will be our optimal solution.

Similarily, you can prove that for optimal solution, it is always good to include a prefix with positive sum.

Try to come up with a solution based on the previous 2 facts.

If this still does not make sense, watch this video for more detailed explanation :



 */