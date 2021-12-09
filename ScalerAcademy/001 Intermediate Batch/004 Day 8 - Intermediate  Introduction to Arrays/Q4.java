/* 

Q4. Reverse the Array

Problem Description

You are given a constant array A.

You are required to return another array which is the reversed form of input array.



Problem Constraints

1 <= A.size() <= 10000

1 <= A[i] <= 10000



Input Format

First argument is a constant array A.



Output Format

You have to return an integer array.


Example Input

Input 1:

A = [1,2,3,2,1]

Input 2:

A = [1,1,10]



Example Output

Output 1:

 [1,2,3,2,1] 

Output 2:

 [10,1,1] 



Example Explanation

Explanation 1:

Reversed form of input array is same as original array

Explanation 2:

Clearly, Reverse of [1,1,10] is [10,1,1]
 */
 
 
public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int[] solve(final int[] A) {
        int n = A.length;
        int[] B = new int[n];
        
        for(int i=0; i < n; i++){
            B[n-i-1] = A[i];
        }

        return B;
    }
}


/* 
Hint 1

Make an array and keep pushing elements in it one by one from orignal in backward direction.


Solution Approach

Ley N be the size of the input array.
First of all, intialize an output array of size equal to N.
Then, iterate over the input array given in the function.
Inside the loop make output[i] = input[N-i-1], where N is the size of the input array.
After that just return output array from the function.




vector<int> Solution::solve(const vector<int> &A) {
    int n = A.size();
    vector<int> ans;
    for(int i = 0; i < n; i++)ans.push_back(A[n-i-1]);
    return ans;
}


 */
 
 