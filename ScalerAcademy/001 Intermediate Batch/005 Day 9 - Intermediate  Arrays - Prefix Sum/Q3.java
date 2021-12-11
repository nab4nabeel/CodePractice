/* 

Q3. Pick from both sides!


Problem Description

Given an integer array A of size N.

You can pick B elements from either left or right end of the array A to get maximum sum.

Find and return this maximum possible sum.

NOTE: Suppose B = 4 and array A contains 10 elements then

You can pick first four elements or can pick last four elements or can pick 1 from front and 3 from back etc . you need to return the maximum possible sum of elements you can pick.


Problem Constraints

1 <= N <= 105

1 <= B <= N

-103 <= A[i] <= 103



Input Format

First argument is an integer array A.

Second argument is an integer B.



Output Format

Return an integer denoting the maximum possible sum of elements you picked.


Example Input

Input 1:

 A = [5, -2, 3 , 1, 2]
 B = 3

Input 2:

 A = [1, 2]
 B = 1



Example Output

Output 1:

 8

Output 2:

 2



Example Explanation

Explanation 1:

 Pick element 5 from front and element (1, 2) from back so we get 5 + 1 + 2 = 8

Explanation 2:

 Pick element 2 from end as this is the maximum we can get




 */
 
 
public class Solution {
    public int solve(int[] A, int B) {

		int n = A.length;
		
        int[] PFF = getPrefixSumFront(A,n);
        int[] PFR = getPrefixSumReverse(A,n);
        
        //System.out.println("A: "+Arrays.toString(A));
		//System.out.println("PFF: "+Arrays.toString(PFF));
		//System.out.println("PFR: "+Arrays.toString(PFR));
		
		int maxSum = Math.max(PFF[B-1], PFR[n-B]);
        //System.out.println("maxSum Before: "+ maxSum);
		
		for(int i=1;i<B;i++){
		        maxSum = Math.max( maxSum, PFF[i-1] + PFR[n-(B-i)]);
		}

        //System.out.println("maxSum After: "+ maxSum);
        return maxSum;

    }

    public static int[] getPrefixSumFront(int[] A, int n){
        int[] PF = new int[n];
        PF[0]=A[0];
        for(int i=1;i<n;i++){
                PF[i] = PF[i-1] + A[i]; 
        }
        return PF;
    }

    public static int[] getPrefixSumReverse(int[] A, int n){
        int[] PF = new int[n];
        PF[n-1]=A[n-1];
        for(int i=n-2;i>=0;i--){
                PF[i] = PF[i+1] + A[i]; 
        }
        return PF;
    }


}
 
 
 
 /* 

Hint 1

Try to use prefix and suffix sum array to solve the problem.

You can try to pick one by one from left and then use suffix array to pick from right.

Solution Approach

Approach using Prefix and Suffix Sums:

Maintain two arrays prefix[i] and suffix[i] where prefix[i] denotes sum of elements from index [0,i] and suffix[i] denotes sum of elements from index [i,N-1].

Now iterate from left and one by one pick elements from left for example: if you pick ‘a’ elements from left and remaining ‘k-a’ elements from right.
So the sum in this case will be prefix[a-1] + suffix[n-(k-a)]

Maintain the maximum among all and return it.

Time Complexity: O(N)
Space Complexity: O(N)

where N is number of elements in array A

Bonus: Try solving it in O(1) space.


Complete Solution

int Solution::solve(vector < int > & A, int B) {
    int n = A.size();
    int suff[n + 1];
    suff[n] = 0;
    suff[n - 1] = A[n - 1];
    for (int i = n - 2; i >= 0; i--)
        suff[i] = A[i] + suff[i + 1];
    int prefSum = 0;
    int ans = suff[n - B];
    for (int i = 0; i < B; i++) {
        prefSum = prefSum + A[i];
        int suffSum = suff[n - B + (i + 1)];
        ans = max(ans, prefSum + suffSum);
    }
    return ans;

}

 */