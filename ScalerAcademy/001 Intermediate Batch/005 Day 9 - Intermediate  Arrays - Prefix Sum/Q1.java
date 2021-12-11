/* 

Q1. Equilibrium index of an array



Problem Description

You are given an array A of integers of size N.

Your task is to find the equilibrium index of the given array

Equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to the sum of elements at higher indexes.

NOTE:

Array indexing starts from 0.
If there is no equilibrium index then return -1.
If there are more than one equilibrium indexes then return the minimum index.



Problem Constraints

1<=N<=1e5
-1e5<=A[i]<=1e5



Input Format

First arugment contains an array A .


Output Format

Return the equilibrium index of the given array. If no such index is found then return -1.


Example Input

Input 1:

A=[-7, 1, 5, 2, -4, 3, 0]

Input 2:

A=[1,2,3]



Example Output

Output 1:

3

Output 2:

-1



Example Explanation

Explanation 1:

3 is an equilibrium index, because: 
A[0] + A[1] + A[2] = A[4] + A[5] + A[6]

Explanation 1:

There is no such index.


 */
 
 
public class Solution {
    public int solve(int[] A) {
        int n = A.length;
        int PF[] = getPrefixSumArray(A, n);

        for(int i=0; i < n; i++){
            int leftSum=0;
            int rightSum=0;
            if(i==0){
                leftSum = 0;
            }else{
                leftSum = PF[i-1]; 
            }
            rightSum = PF[n-1]-PF[i];
            if(leftSum == rightSum){
                return i;
            }
        }

        return -1;
    }

    public int[] getPrefixSumArray(int[] A, int n){
        int[] PF = new int[n];
        PF[0] =A[0];
        for(int i=1 ; i < n ;i ++){
            PF[i]= PF[i-1] + A[i];
        }
        return PF;
    }
}

public class Solution {
    public int solve(int[] A) {
        int n = A.length;
        
        int arraySum = 0;
        for(int i=0; i < n; i++){
            arraySum += A[i];
        }

        int leftSum=0;
        for(int i=0; i < n; i++){
            arraySum -= A[i];
            if(leftSum == arraySum){
                return i;
            }
            leftSum += A[i];
        }
        return -1;
    }

}


 /* 

Hint 1

Try to find answer for any particular index 'i' .
Try to maintain the prefix sum and suffix sum


Solution Approach

The idea is to get the total sum of the array first. Then Iterate through the array and keep updating the left sum which is initialized as zero. In the loop, we can get the right sum by subtracting the elements one by one.

1) Initialize leftsum  as 0
2) Get the total sum of the array as sum
3) Iterate through the array and for each index i, do following.
    a)  Update sum to get the right sum.  
           sum = sum - arr[i] 
       // sum is now right sum
    b) If leftsum is equal to sum, then return current index. 
       // update leftsum for next iteration.
    c) leftsum = leftsum + arr[i]
4) return -1 
// If we come out of loop without returning then
// there is no equilibrium index

C++


int equilibrium(int arr[], int n)
{
    int sum = 0; // initialize sum of whole array
    int leftsum = 0; // initialize leftsum
 
    // Find sum of the whole array
    for (int i = 0; i < n; ++i)
        sum += arr[i];
 
    for (int i = 0; i < n; ++i)
    {
        sum -= arr[i]; // sum is now right sum for index i
 
        if (leftsum == sum)
            return i;
 
        leftsum += arr[i];
    }
 
    // If no equilibrium index found, then return -1
    return -1;
}
 
int Solution::solve(vector<int> &A) {
    int n=A.size();
    int arr[n];
    for(int i=0;i<n;i++) arr[i]=A[i];
    return equilibrium(arr,n);
}




 */