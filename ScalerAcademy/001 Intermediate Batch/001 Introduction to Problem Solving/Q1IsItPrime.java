/* 

Q1. Is It Prime?
Problem Description:

Given an integer A, you have to tell whether it is a prime number or not.
A prime number is a natural number greater than 1 which is divisible only by 1 and itself.



Problem Constraints

1 <= A <= 10^6


Input Format

First and only line of the input contains a single integer A.


Output Format

Print YES if A is a prime, else print NO.


Example Input

Input 1:

 3 

Input 2:

 4 



Example Output

Output 1:

 YES 

Output 2:

 NO 



Example Explanation

Explanation 1:

 3 is a prime number as it is only divisible by 1 and 3.

Explanation 2:

 4 is not a prime number as it is divisible by 2.

 */
 
 
import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        String num = myObj.nextLine();  // Read user input
        if(isPrimeNum(Integer.parseInt(num))){
            System.out.println("YES");  // Output
        }else{
            System.out.println("NO");  // Output
        }
    }

    private static boolean isPrimeNum(int n){
        int count = 0;
        for(int i=1; i*i <= n;i++){
            if(n%i == 0){
                if(n%i == i){
                    count +=1;
                }else{
                    count +=2;
                }
            }
        }
        return (count==2);
    }
}

/* 

Solution Approach

If we find such a X such that X != 1 & X != A, and A % X == 0, then A is not a prime. Else A is a prime number.
To find X we can just iterate through all the numbers in the range [2, A - 1]. 

Complete Solution


import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
    
        boolean flag = true;
        for(int i = 2; i < A; i++){
            if(A % i == 0){
                flag = false;
                break;
            }
        }
            
            
        if(flag == true)
            System.out.print("YES");
        else
            System.out.print("NO");
    }
}

*/

