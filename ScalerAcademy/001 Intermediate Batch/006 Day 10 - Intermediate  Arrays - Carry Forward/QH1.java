/* 


Q1. Amazing Subarrays

You are given a string S, and you have to find all the amazing substrings of S.

Amazing Substring is one that starts with a vowel (a, e, i, o, u, A, E, I, O, U).

Input

Only argument given is string S.
Output

Return a single integer X mod 10003, here X is number of Amazing Substrings in given string.
Constraints

1 <= length(S) <= 1e6
S can have special characters
Example

Input
    ABEC

Output
    6

Explanation
    Amazing substrings of given string are :
    1. A
    2. AB
    3. ABE
    4. ABEC
    5. E
    6. EC
    here number of substrings are 6 and 6 % 10003 = 6.

 */
 
 
 
 public class Solution {
    public int solve(String A) {
        int N = A.length();

        int ans = 0;

        for(int i=0;i<N;i++){
            if(isVowel(A.charAt(i))){
                ans += N-i;
            }
        }
        return ans % 10003;
    }

    public boolean isVowel(char c){
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}


/* 

Hint 1
Brute Force Approach is to find all the substrings and count the substrings those start with a vowel.
This approach will result in the timeout as the time complexity of the same is O(n^2).

Is there any need of finding all the substrings?

Solution Approach
The main idea to solve this problem is to traverse the string and when you encounter a vowel, add ( length(string) - position_of_curr_char ) to the answer.


int Solution::solve(string s) {
    
    map<char, bool> m;
    m['a'] = m['e'] = m['i'] = m['o'] = m['u'] = 1;
    m['A'] = m['E'] = m['I'] = m['O'] = m['U'] = 1;
    
    int n = s.length();
    long long ans = 0;
    for(int i = 0; i < n; i += 1) {
        if(m[s[i]])
            ans += (n - i);
    }
    return ans % 10003;
}

 */