/* 

Q1. Counting Subarrays Easy

Problem Description
Given an array A of N non-negative numbers and you are also given non-negative number B.

You need to find the number of subarrays in A having sum less than B. We may assume that there is no overflow.



Problem Constraints
1 <= N <= 103

1 <= A[i] <= 1000

1 <= B <= 107



Input Format
First argument is an integer array A.

Second argument is an integer B.



Output Format
Return an integer denoting the number of subarrays in A having sum less than B.



Example Input
Input 1:

 A = [2, 5, 6]
 B = 10
Input 2:

 A = [1, 11, 2, 3, 15]
 B = 10


Example Output
Output 1:

 4
Output 2:

 4


Example Explanation
Explanation 1:

 The subarrays with sum less than B are {2}, {5}, {6} and {2, 5},
Explanation 2:

 The subarrays with sum less than B are {1}, {2}, {3} and {2, 3}
 
 

 */
 
public class Solution {
    public int solve(int[] A, int B) {//T.C = O(N3)
            
        int count = 0, N = A.length;
		for(int i=0;i<N;i++){//starting index
			for	(int j=i;j<N;j++){//loop till from index N-1
                int sum=0;
				for	(int k=i;k<=j;k++){// k to print [i j]sub array
						sum+= A[k];
				}
                if(sum < B){
                    count++;
                }
			}
		}
        return count;
    }
}

/* 
Below solution with T.C=O(N2) using S.C=O(N) with prefix sum we can eliminate the thrid iteration to loop start and end index
 */


public class Solution {
    public int solve(int[] A, int B) {
            
        int N=A.length;
        int[] pfSum = generatePFSumArray(A,N);
		int count=0;
        for(int s=0;s<N;s++){
            int sum =0;
		    for (int e=s;e<N;e++){
	    		sum = getSumFromPrefix(pfSum,s,e);
		        //System.out.println(sum);
                if(sum < B){
                    count++;
                }
            }
            
        }
		return count;
    }
    	public static int[] generatePFSumArray(int[] A, int N){
		int[] pfSum = new int[N];
			pfSum[0]=A[0];
			for(int k=1;k<N;k++){
				pfSum[k]= pfSum[k-1]+A[k];
			}
		return pfSum;
	}
	
	public static int getSumFromPrefix(int[] pfSum, int L, int R){
		if(L==0){
			return pfSum[R];
		}
		return pfSum[R]-pfSum[L-1];
	}
}


/* 

Hint 1
The constraints are small. Have you tried doing just what the question says?

Solution Approach
The constraints are small. Have you tried doing just what the question says?
Since the constraints are small we can generate all subarrays using 2 loops. This can be done in O(N^2). Then find the sum of each subarray and if the sum is less than B we add 1 to our answer.
Note that we cannot iterate over the subarray after generating the left index and right index to find the sum as this will increase the time complexity of the solution to O(N^3). We can find the sum of each subarray in O(1) with the help of a prefix sum array, which takes an O(N) precomputation.
Please refer to the complete solution for implementation.


C++

int solve(vector <int> &A,int B){
    int n=A.size();
    int dp[n+1];
    dp[0]=0;
    int ans=0;
    for(int i=0;i<n;i++)dp[i+1]=dp[i]+A[i];
    for(int i=0;i<n;i++){
        for (int j=i;j<n;j++){
            int val=dp[j+1]-dp[i];
            if(val<B)ans++;
        }
    }
    return ans;
}

 */