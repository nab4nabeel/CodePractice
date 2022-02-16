/* 

Q3. Leaders in an array

Problem Description

Given an integer array A containing N distinct integers, you have to find all the leaders in the array A.

An element is leader if it is strictly greater than all the elements to its right side.

NOTE:The rightmost element is always a leader.



Problem Constraints

1 <= N <= 105

1 <= A[i] <= 108



Input Format

First and only argument is an integer array A.



Output Format

Return an integer array denoting all the leader elements of the array.

NOTE: Ordering in the output doesn't matter.



Example Input

Input 1:

 A = [16, 17, 4, 3, 5, 2]
Input 2:

 A = [1, 2]


Example Output

Output 1:

 [17, 2, 5]
Output 2:

 [2]


Example Explanation

Explanation 1:

 Element 17 is strictly greater than all the elements on the right side to it.
 Element 2 is strictly greater than all the elements on the right side to it.
 Element 5 is strictly greater than all the elements on the right side to it.
 So we will return this three elements i.e [17, 2, 5], we can also return [2, 5, 17] or [5, 2, 17] or any other ordering.
Explanation 2:

 Only 2 the rightmost element is the leader in the array.


 */
 
 
public class Solution {
    public int[] solve(int[] A) {
        int N = A.length;
        List<Integer> values = new ArrayList<Integer>();
        int max = A[N-1];
        values.add(max);
        for(int i=N-1; i>=0;i--){
            if(A[i]>max){
                max=A[i];
                values.add(max);
            }
        }
        int[] B = new int[values.size()];
        int j=0;
        for(int value: values){
            B[j++]=value;
        }        
        return B;
    }
}


 /* 

Hint 1
A leader element must be greater than all the elements on the right to it simply means the leader element must be greater then the maximum of all the elements on the right side of it.

Try to use the above fact and find a solution to the problem.


ethod 1: (Simple)
Use two loops. The outer loop runs from 0 to size – 1 and one by one picks all elements from left to right. The inner loop compares the picked element to all the elements to its right side. If the picked element is greater than all the elements to its right side, then the picked element is the leader.
Time Complexity: O(N2)

Method 2: (Scan from right) Optimized Approach
Scan all the elements from right to left in an array and keep track of maximum till now. When maximum changes its value, print it.
Below image is a dry run of the above approach:
Time Complexity: O(N)




 */