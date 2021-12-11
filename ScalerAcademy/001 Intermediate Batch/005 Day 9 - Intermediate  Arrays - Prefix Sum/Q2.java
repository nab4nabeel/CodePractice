
/* 

Q2. Count ways to make sum of odd and even indexed elements equal by removing an array element


Problem Description

Given an array, arr[] of size N, the task is to find the count of array indices such that removing an element from these indices makes the sum of even-indexed and odd-indexed array elements equal.


Problem Constraints

1<=n<=1e5
-1e5<=A[i]<=1e5



Input Format

First argument contains an array A of integers of size N


Output Format

Return the count of array indices such that removing an element from these indices makes the sum of even-indexed and odd-indexed array elements equal.


Example Input

Input 1:

A=[2, 1, 6, 4]

Input 2:

A=[1, 1, 1]



Example Output

Output 1:

1

Output 2:

3



Example Explanation

Explanation 1:

Removing arr[1] from the array modifies arr[] to { 2, 6, 4 } such that, arr[0] + arr[2] = arr[1]. 
Therefore, the required output is 1. 

Explanation 2:

 Removing arr[0] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1] 
Removing arr[1] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1] 
Removing arr[2] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1] 
Therefore, the required output is 3.




 */



public class Solution {

    public int solve(int[] A) {

        int n =A.length;
        int[] PFEven = getPrefixSumEvenArray(A,n);
        int[] PFOdd = getPrefixSumOddArray(A,n);

        int count = 0;

        for(int i=0;i<n;i++){
            int totalEvenSum = 0;
            int totalOddSum = 0;

            if(i==0){
				totalEvenSum = getSumInRange(PFOdd,1,n-1);
				totalOddSum = getSumInRange(PFEven,1,n-1);
			}else if(i== n-1){
				totalEvenSum = getSumInRange(PFEven,0,n-2);
				totalOddSum = getSumInRange(PFOdd,0,n-2);
			}else{
				totalEvenSum = getSumInRange(PFEven,0,i-1) + getSumInRange(PFOdd,i+1,n-1);
				totalOddSum = getSumInRange(PFOdd,0,i-1) + getSumInRange(PFEven,i+1,n-1);
			}
						
			if(totalEvenSum == totalOddSum){
				count++;
			}
        }
        return count;
    }

    public int[] getPrefixSumEvenArray(int[] A, int n){
        int[] PF = new int[n];
        PF[0]=A[0];
        for(int i=1;i<n;i++){
            if(i%2==0){
                PF[i] = PF[i-1] + A[i]; 
            }else{
                PF[i] = PF[i-1];
            }
        }
        return PF;
    }

    public int[] getPrefixSumOddArray(int[] A, int n){
        int[] PF = new int[n];
        PF[0]=0;
        for(int i=1;i<n;i++){
            if(i%2==1){
                PF[i] = PF[i-1] + A[i]; 
            }else{
                PF[i] = PF[i-1];
            }
        }
        return PF;
    }

	public static int getSumInRange(int[] PF,int L,int R){
				
				int sum =0;
				if(L==0){
					sum = PF[R];
				}else{
					sum = PF[R]-PF[L-1];
				}
				return sum;
	}

}


/* 

Hint 1

The simplest approach to solve this problem is to traverse the array 
and for each array element, check 
if removing the element from the array makes the sum of even-indexed and odd-indexed array elements equal or not. 
If found to be true, then increment the count. Finally, print the count.

Solution Approach

based on the observation that removing any element from the given array makes even indices of succeeding elements as odd and odd indices of the succeeding elements as even. Follow the steps below to solve the problem:

 Initialize two variables, say evenSum and oddSum,
 to store the sum of odd-indexed and even-indexed elements of the given array respectively.
Traverse the array using variable i.
Remove every ith element of the array and update the sum of the remaining even-indexed elements 
and the odd-indexed elements based on the above observation. Check if the sums are equal or not. 
If found to be true, then increment the count.
Finally, print the count obtained.



 */