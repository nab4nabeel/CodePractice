/* 


Q1. Time to equality


Problem Description
Given an integer array A of size N. In one second you can increase the value of one element by 1.

Find the minimum time in seconds to make all elements of the array equal.



Problem Constraints

1 <= N <= 1000000

1 <= A[i] <= 1000



Input Format

First argument is an integer array A.


Output Format

Return an integer denoting the minimum time to make all elements equal.


Example Input

A = [2, 4, 1, 3, 2]


Example Output

8


Example Explanation

We can change the array A = [4, 4, 4, 4, 4]. The time required will be 8 seconds.

 */
 
 
 public class Solution {
    public int solve(int[] A) {

        int n = A.length;
        int maxValue = Integer.MIN_VALUE;
        
        for (int i=0;i<n;i++){
            maxValue = Math.max(maxValue, A[i]);
        }

        int seconds = 0;
        for (int i=0;i<n;i++){
            seconds += maxValue - A[i];
        }

        return seconds;

    }
}


/* 

Hint 1

Since we can only increase the element by 1. We should increase all element upto the maximum element.


Solution Approach

Since we can only increase the element by 1. We should increase all element upto the maximum element.
We can find the maximum element and for finding the minimum number of moves we should find the summation of absolute difference of all 
elements with maximum element.  



Complete Solution

int Solution::solve(vector<int> &A) {
    int n=A.size();
      int val=0;
      for(int i=0;i<n;i++)
      {
        val=max(val,A[i]);
      }
      int ans=0;
      for(int i=0;i<n;i++)
      {
        ans+=val-A[i];
      }
      return ans;
}




 */