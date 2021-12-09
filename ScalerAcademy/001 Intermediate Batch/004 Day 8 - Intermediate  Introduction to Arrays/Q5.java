/* 

Q5. Search Element

Problem Description

You are given an integer T (Number of test cases). For each test case, you are given array A and an integer B. You have to tell whether B is present in array A or not.


Problem Constraints

1 <= T <= 10

1 <= |A| <= 105

1 <= A[i], B <= 109



Input Format

First line of the input contains a single integer T.

Next, each of the test case consists of 2 lines:
First line begins with an integer |A| denoting the length of array, and then |A| integers denote the array elements.
Second line contains a single integer B



Output Format

For each test case, print on a separate line 1 if the element exists, else print 0.


Example Input

Input 1:

 1 
 5 4 1 5 9 1
 5

Input 2:

 1
 3 7 7 2
 1 



Example Output

Output 1:

 1 

Output 2:

 0 



Example Explanation

Explanation 1:

  B = 5  is present at position 3 in A 

Explanation 2:

  B = 1  is not present in A. 


 */
 
 
import java.lang.*;
import java.util.*;

public class Q5 {
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i=0;i<T;i++){
            int n = sc.nextInt();
            int A[] = new int[n];
            for(int k=0; k<n;k++){
                A[k] = sc.nextInt();
            
            }
            int B = sc.nextInt();
            int flag = 0;

            for(int j=0; j<n;j++){
                if(A[j]== B){
                    flag =1;
                    break;
                }
            }

            System.out.println(flag);
        }


    }
}


/* 

Hint 1

This is am simple implementation problem, Try to iterate through the array. 

Solution Approach

You can iterate through the array elements using simple for or while loop, and check for each element whether equals
to B or not.

import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-- > 0){
            int N = sc.nextInt();
            int[] A = new int[N];
            for(int i = 0;i < N;i++){
                A[i] = sc.nextInt();
            }
            int B;
            B = sc.nextInt();
            int found = 0;
            for (int i = 0; i < N;i++){
                if(A[i] ==  B){
                    found = 1;
                }
            }
            System.out.println(found);
        }
    }
}

 */