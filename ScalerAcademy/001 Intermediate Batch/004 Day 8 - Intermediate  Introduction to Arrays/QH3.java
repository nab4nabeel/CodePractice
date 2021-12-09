/* 
Q3. MINIMUM PICKS

Problem Description

You are given an array of integers A of size N.
Return the difference between the maximum among all even numbers of A and the minimum among all odd numbers in A.


Problem Constraints

2 <= N <= 1e5
-1e9 <= A[i] <= 1e9
There is atleast 1 odd and 1 even number in A


Input Format

The first argument given is the integer array, A.


Output Format

Return maximum among all even numbers of A - minimum among all odd numbers in A.


Example Input

Input 1:

 A = [0, 2, 9]

Input 2:

 A = [5, 17, 100, 1]



Example Output

Output 1:

-7

Output 2:

99



Example Explanation

Explanation 1:

Maximum of all even numbers = 2
Minimum of all odd numbers = 9
ans = 2 - 9 = -7

Explanation 2:

Maximum of all even numbers = 100
Minimum of all odd numbers = 1
ans = 100 - 1 = 99


 */
 
 
public class Solution {
    public int solve(int[] A) {

        int maxEven = Integer.MIN_VALUE; 
        int minOdd = Integer.MAX_VALUE;

        for(int i =0; i< A.length; i++){
            if(A[i] % 2 == 0){
                maxEven = Math.max(maxEven, A[i]);
            }else{
                minOdd = Math.min(minOdd, A[i]);
          }
        }
        //System.out.println(maxEven + "-" + minOdd);
        return maxEven - minOdd;
    }
}


 /* 

Hint 1

We can try to just traverse through the array to find the minimum and maximum elements and find their difference at the end.



Solution Approach

We can initialize two integers, lets say OddMin and EvMax and initialize them with values infinity and -infinity, respectively.
Now, we do a linear traversal through the array and if the number is even, we take EvMax = max(EvMax, A[i]), and if the number is odd, we take OddMin = min(OddMin, A[i]).
At the end of the traversal, we can return the required difference.



public class Solution {
  public int solve(int[] A) {
    int maxx = Integer.MIN_VALUE, minn = Integer.MAX_VALUE;
    for (int i = 0; i < A.length; i++) {
      if (A[i] % 2 == 0)
        maxx = Math.max(A[i], maxx);
      else
        minn = Math.min(A[i], minn);
    }

    return maxx - minn;
  }
}

 */