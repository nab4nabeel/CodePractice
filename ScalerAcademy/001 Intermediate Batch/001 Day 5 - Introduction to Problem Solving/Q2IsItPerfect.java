/* 
Q2. Is It Perfect?

Problem Description

You are given N positive integers.

For each given integer A, you have to tell whether it is a perfect number or not.

Perfect number is a positive integer which is equal to the sum of its proper positive divisors.



Problem Constraints

1 <= N <= 10

1 <= A <= 106



Input Format

First line of the input contains a single integer N.

Each of the next N lines contains a single integer A.



Output Format

In a seperate line, print YES if a given integer is perfect, else print NO.


Example Input

Input 1:

 2
 4
 6 

Input 2:

 1
 3 



Example Output

Output 1:

 NO
 YES 

Output 2:

 NO 



Example Explanation

Explanation 1:

 For A = 4, the answer is "NO" as sum of its proper divisors = 1 + 2 = 3, is not equal to 4. 
 For A = 6, the answer is "YES" as sum of its proper divisors = 1 + 2 + 3 = 6, is equal to 6. 

Explanation 2:

 For A = 3, the answer is "NO" as sum of its proper divisors = 1, is not equal to 3. 

 */
 
 
import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        
        Scanner s = new Scanner(System.in);
        int range = s.nextInt();
        for(int i=1;i<=range;i++){
            if(isPerfectNum(s.nextInt()))
                System.out.println("YES");
            else
                System.out.println("NO");
        } 
    }

    private static boolean isPerfectNum(int n){
        int sum = 0;
        for(int i=1; sum < n; i++){
            if(n%i==0){
                sum += i;
                if(sum == n)
                    return true;
            }
        }
        return false;
    }
}


/* 

Solution Approach

ALGORITHM:
=> Initialize a variable to store sum of proper positive divisors, say sum = 0.
=> Run a loop from 1 to A/2, increment 1 in each iteration. The loop structure should look like for(i=1; i<=A/2; i++).
   Why iterating from 1 to A/2, why not till A? Because a number does not have any proper positive divisor greater than A/2.
=> Inside the loop if current number i.e. i is proper positive divisor of A (A % i == 0), then add it to sum.


import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        
        while(N-- > 0)
        {
            int A = sc.nextInt();
            
            long sum = 0;
            for (int i = 1; i < A;i++){
                if(A % i == 0){
                    sum += i;
                }
            }
            if(sum == A){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
    }
}

 */
 