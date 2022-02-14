/* 

Q1. Special Subsequences "AG"


Problem Description

You have given a string A having Uppercase English letters.

You have to find that how many times subsequence "AG" is there in the given string.

NOTE: Return the answer modulo 109 + 7 as the answer can be very large.



Problem Constraints

1 <= length(A) <= 105



Input Format

First and only argument is a string A.



Output Format

Return an integer denoting the answer.



Example Input

Input 1:

 A = "ABCGAG"
Input 2:

 A = "GAB"


Example Output

Output 1:

 3
Output 2:

 0


Example Explanation

Explanation 1:

 Subsequence "AG" is 3 times in given string 
Explanation 2:

 There is no subsequence "AG" in the given string.

 */
 
 
public class Solution {
    public int solve(String A) {
        int ans=0, countOfG=0;
        int N=A.length();
        //System.out.print(N);
        for(int i=N-1; i>=0; i--){
            if(A.charAt(i)=='G'){
                countOfG++;
            }else if(A.charAt(i)=='A'){
                ans += countOfG;
            }
        }
        return ans;
    }
}


 /* 

Hint 1
The main task is to find the number of times subsequence “AG” appear in a string.
Can counting A’s and G’s in given string can help in any way?

Solution Approach
The main task is to find the number of times subsequence “AG” appear in a string.
Simply, find the number of G’s after any index i by taking suffix sum.
Then traverse the string again and when you encounter an ‘A’ add number of G’s after that to the answer.

 */
 
 
public class Solution {
    public int solve(String A) {
        int n = A.length(), ans = 0, MOD = 1000*1000*1000 + 7;
        int cnt_G[] = new int[n], count = 0;
        //Suffix count of G
        for(int i = n-1 ; i >= 0 ; i--){
            if(A.charAt(i) == 'G')
            count = count + 1;
            cnt_G[i] = count;
        }
        // traverse the string again from beginning
        for(int i = 0; i < n; i++){
            // if current character is "A" then add number of G's after that 
            if(A.charAt(i) == 'A') {
                ans = ans + cnt_G[i];
                ans = ans % MOD;
            }
        }
        return ans;
    }
} 