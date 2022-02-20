/* 

Q2. Good Subarrays Easy


Problem Description
Given an array of integers A.
A subarray of an array is said to be good if it fulfils any one of the criteria:
1. Length of the subarray must be even and the sum of all the elements of the subarray must be less than B.
2. Length of the subarray must be odd and the sum of all the elements of the subarray must be greater than B.
Your task is to find the count of good subarrays in A.


Problem Constraints
1 <= len(A) <= 103
1 <= A[i] <= 103
1 <= B <= 107


Input Format
The first argument given is the integer array A.
The second argument given is an integer B.


Output Format
Return the count of good subarrays in A.


Example Input
Input 1:
A = [1, 2, 3, 4, 5]
B = 4
Input 2:

A = [13, 16, 16, 15, 9, 16, 2, 7, 6, 17, 3, 9]
B = 65


Example Output
Output 1:
6
Output 2:

36


Example Explanation
Explanation 1:
Even length good subarrays = {1, 2}
Odd length good subarrays = {1, 2, 3}, {1, 2, 3, 4, 5}, {2, 3, 4}, {3, 4, 5}, {5} 


 */
 
public class Solution {
    public int solve(int[] A, int B) {
        int N = A.length;
        int evenSum=0,oddSum=0;
        for(int i=0;i<N;i++){//starting index
			for	(int j=i;j<N;j++){//loop till from index N-1
		        long sum=0;
				for	(int k=i;k<=j;k++){// k to print [i j]sub array
						sum+= A[k];
				}
                if( (j-i+1) %2==0 && sum < B){
                    evenSum++;
                }else if((j-i+1) %2!=0 && sum > B){
                    oddSum++;
                }
			}
		}
        return evenSum+oddSum;

    }
}



/* 
Below solution with T.C=O(N2) using S.C=O(N) with prefix sum we can eliminate the thrid iteration to loop start and end index
 */

public class Solution {
    public int solve(int[] A, int B) {
        
        int N=A.length;
        int[] pfSum = generatePFSumArray(A,N);
		int evenSum=0,oddSum=0;
        for(int s=0;s<N;s++){
            int sum =0;
		    for (int e=s;e<N;e++){
	    		sum = getSumFromPrefix(pfSum,s,e);
		        //System.out.println(sum);
                if( (e-s+1) %2==0 && sum < B){
                    evenSum++;
                }else if((e-s+1) %2!=0 && sum > B){
                    oddSum++;
                }
            }
            
        }
		return evenSum+oddSum;
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
The constraints are small.
Have you tried doing just what the question says?

Solution Approach
The constraints are small.
Have you tried doing just what the question says?
Since the constraints are small we can generate all subarrays using 2 loops. This can be done in O(N^2). Then find the sum of each subarray and check both the conditions.
Note that we cannot iterate over the subarray after generating the left index and right index to find the sum as this will increase the time complexity of the solution to O(N^3). We can find the sum of each subarray in O(1) with the help of a prefix sum array, which takes an O(N) precomputation.
Please refer to the complete solution for implementation.

C++
Python
int Solution::solve(vector <int> &A,int B){
    int n=A.size();
    int dp[n+1];
    dp[0]=0;
    int ans=0;
    for(int i=0;i<n;i++)dp[i+1]=dp[i]+A[i];
    for(int i=0;i<n;i++){
        for (int j=i;j<n;j++){
            int sz=j-i+1;
            int sum=dp[j+1]-dp[i];
            if(sz%2==0 && sum<B)ans++;
            if(sz&1 && sum>B)ans++;
        }
    }
    return ans;
}

 */
 
 
 