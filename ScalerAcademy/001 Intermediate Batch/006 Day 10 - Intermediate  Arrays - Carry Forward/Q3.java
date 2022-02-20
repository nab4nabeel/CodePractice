/* 

Q3. Bulbs

Problem Description

N light bulbs are connected by a wire.

Each bulb has a switch associated with it, however due to faulty wiring, a switch also changes the state of all the bulbs to the right of current bulb.

Given an initial state of all bulbs, find the minimum number of switches you have to press to turn on all the bulbs.

You can press the same switch multiple times.

Note: 0 represents the bulb is off and 1 represents the bulb is on.



Problem Constraints

1 <= N <= 5*105
0 <= A[i] <= 1



Input Format

The first and the only argument contains an integer array A, of size N.



Output Format

Return an integer representing the minimum number of switches required.



Example Input

Input 1:

 A = [0, 1, 0, 1]
Input 2:

 A = [1, 1, 1, 1]


Example Output

Output 1:

 4
Output 2:

 0


Example Explanation

Explanation 1:

 press switch 0 : [1 0 1 0]
 press switch 1 : [1 1 0 1]
 press switch 2 : [1 1 1 0]
 press switch 3 : [1 1 1 1]
Explanation 2:

 There is no need to turn any switches as all the bulbs are already on.


Solution:

We dont have to worry about the order in which we change the state of the values

Ex:

 A = [0, 1, 0, 1]

 press switch 0 : [1 0 1 0]
 press switch 1 : [1 1 0 1]


 A = [0, 1, 0, 1]

 press switch 1 : [0 0 1 0]
 press switch 0 : [1 1 0 1]

In both the above examples we could see that sequence of switch doesnt matter and the answer remains same

Pseudo code:

int ans=0,state=0;

(i=0;i<n;i++){
	if(A[i]==state){
		ans++;
		state = 1- state;
	}
}
return ans;

Trace:

 A = [0, 1, 0, 1]

iteration	state	ans
0			1		1
1			0		2
2			1		3
3			0		4

 */
 
 
public class Solution {
    public int bulbs(int[] A) {

        int ans=0,state=0;
        int N = A.length;
        for(int i=0;i<N;i++){
            if(A[i]==state){
                ans++;
                state = 1-state;
            }
        }
        return ans;
    }
}


 /* 

Hint 1:

You will never need to press the same switch twice. Why? Because it is equivalent to not pressing the switch and you will end up with the same state as before. So we can always solve the problem in at most n switch flips.


Solution Approach
The order in which you press the switch does not affect the final state.

Example:

Input : [0 1 0 1]

Case 1:
	Press switch 0 : [1 0 1 0]
	Press switch 1 : [1 1 0 1]
	
Case 2:
	Press switch 1 : [0 0 1 0]
	Press switch 0 : [1 1 0 1]	
Therefore we can choose a particular order. To make things easier lets go from left to right. At the current position if the bulb is on we move to the right, else we switch it on. This works because changing any switch to the right of it will not affect it anymore.

 */
 
public class Solution {
  public int bulbs(ArrayList < Integer > A) {

    int state = 0, ans = 0;

    // state variable will represent the state which we have to change.
    for (int i = 0; i < A.size(); i++) {

      if (A.get(i) == state) {
        ans++;
        // As we will switch this, all the bulbs on right side will also change. So, change state = 1 - state
        state = 1 - state;
      }
    } 