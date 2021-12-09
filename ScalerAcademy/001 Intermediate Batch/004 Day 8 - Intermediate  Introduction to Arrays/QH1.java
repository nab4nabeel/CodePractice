/* 

Q1. Little Ponny and Maximum Element

Problem Description

Little Ponny is given an array, A, of N integers. In a particular operation, he can set any element of the array equal to -1.

He wants your help for finding out the minimum number of operations required such that the maximum element of the resulting array is B. If it is not possible then return -1.


Problem Constraints

1 <= |A| <= 105

1 <= A[i] <= 109


Input Format

The first argument of input contains an integer array, A.

The second argument of input contains an integer, B.


Output Format

Return an integer representing the answer.


Example Input

Input 1:

 A = [2, 4, 3, 1, 5]
 B = 3 

Input 2:

 A = [1, 4, 2]
 B = 3 



Example Output

Output 1:

 2 

Output 2:

 -1 



Example Explanation

Explanation 1:

 We need to remove 4 and 5 to make 3 the biggest element. 

Explanation 2:

 As 3 doesn't exist in the array, the answer is -1. 


 */
 
 
public class Solution {
    public int solve(int[] A, int B) {
        int count = 0;
        int foundB = 0;
        for(int i=0;i<A.length;i++){
            if(A[i] > B){
                A[i] = -1;
                count++;
            }
            if(A[i] == B){
                foundB =1;
            }
        }
        if(foundB==1 && count > 0){
            return count;
        }else{
            return -1;
        }
        
    }
}


/* 

Hint 1

The elements less than and equal to B are irrelevant.

We only need to consider the element greater than B.

We will need to remove all of them.


Solution Approach

If the element exists in the array, then the answer is the number of elements that are greater than B.

If the element does not exist in the array, then the answer is -1.

Just do a linear traversal to find both the conditions.

Time complexity is O(N).

Space complexity is O(1).


int Solution::solve(vector<int> &A, int B) {
    int cnt = 0, flag = 0;
    for(int i : A){
        if(i == B) flag = 1;
        if(i > B) cnt++;
    }
    if(flag) return cnt;
    return -1;
}


 */