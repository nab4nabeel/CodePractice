/* 
Problem Description

Given a number A. Return square root of the number if it is perfect square otherwise return -1.


Problem Constraints

1 <= A <= 10^8



Input Format

First argument is an integer A.



Output Format

Return an integer which is the square root of A if A is perfect square otherwise return -1.


Example Input

Input 1:

A = 4

Input 2:

A = 1001



Example Output

Output 1:

2

Output 2:

-1



Example Explanation

Explanation 1:

sqrt(4) = 2

Explanation 2:

1001 is not a perfect square.

 */
 
 
public class Solution {
    public int solve(int A) {
        long min=1, max=A;
        while(min<=max){
            long mid = (min + max)/2;
            long sqrRoot = mid * mid;
            if(sqrRoot == A){
                return (int)mid;
            }
            else if(mid * mid > A){
                max = mid - 1;
            }else{
                min = mid + 1;
            }
        }
        return -1;
    }
}



/* 
Solution Approach

Run a loop for i from 1 to N and see i^2 is N or not. 
For optimization you may look at the constraints and notice that we have to run loop just upto 10000. 


int Solution::solve(int A) {
    for(int i = 1; i < 10000; i++){
        if(i*i==A){
            return i;
        }
    }
    return -1;
}

 */
 