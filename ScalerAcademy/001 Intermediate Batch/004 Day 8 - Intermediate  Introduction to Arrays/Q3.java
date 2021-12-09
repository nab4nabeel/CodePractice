/* 
Q3. Max and Min of an Array

Problem Description

Write a program to print maximum and minimum elements of the input array A of size N where you have to take integer N and further N elements as input from user.



Problem Constraints

1 <= N <= 1000

1 <= A <= 1000



Input Format

A single line representing N followed by N integers of the array A



Output Format

A single line containing two space separated integers representing maximum and minimum elements of the input array.



Example Input

Input 1:

5 1 2 3 4 5

Input 2:

4 10 50 40 80



Example Output

Output 1:

5 1

Output 2:

80 10

 */
 
 
import java.lang.*;
import java.util.*;

public class Q3 {
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        

        Scanner sc = new Scanner(System.in);
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        int n = sc.nextInt();
        int[] A = new int[n];

        for(int i=0;i<n;i++){
            A[i] = sc.nextInt();
            if(maxValue < A[i]){
                maxValue = A[i];
            }
            if(minValue > A[i]){
                minValue = A[i];
            }
        }

        System.out.println(maxValue + " " + minValue);

    }
}

/* 
Hint 1

Just use two variables to store max and min of all elements.


Solution Approach

Iterate all elements of the array and compare the elements with the max and min variable one by one and update it accordingly.


 */