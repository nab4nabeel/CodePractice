/* 

Q1. Rotation Game

Problem Description

You are given an integer array A and an integer B. You have to print the same array after rotating it B times towards right.

NOTE: You can use extra memory.



Problem Constraints

1 <= |A| <= 106

1 <= A[i] <= 109

1 <= B <= 109



Input Format

First line begins with an integer |A| denoting the length of array, and then |A| integers denote the array elements.
Second line contains a single integer B



Output Format

Print an array of integers which is the Bth right rotation of input array A, on a separate line.


Example Input

Input 1:

 4 1 2 3 4
 2

Input 2:

 3 1 2 2
 3



Example Output

Output 1:

 3 4 1 2

Output 2:

 1 2 2



Example Explanation

Explanation 1:

 [1,2,3,4] => [4,1,2,3] => [3,4,1,2]


Explanation 2:

 [1,2,2] => [2,1,2] => [2,2,1] => [1,2,2]


 */


import java.lang.*;
import java.util.*;

public class Q1 {
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner sc = new Scanner(System.in);
        int arraySize = sc.nextInt();
        int[] a = new int[arraySize];
        for(int i=0; i<arraySize; i++){
            a[i]= sc.nextInt();
        }
        int rotations = sc.nextInt();
        //System.out.println(Arrays.toString(a));
        //System.out.println(rotations);

        reverse(a,0,arraySize-1);
        
        rotations %= arraySize;
        reverse(a,0,rotations-1);

        reverse(a,rotations,arraySize-1);

        for(int i=0; i<arraySize; i++){
            System.out.print(a[i]+" ");
        }

    }

    private static void reverse(int[] a, int start, int end){
        int i=start, j=end;
        while(i<=j){
            int temp = a[i];
            a[i] = a[j];
            a[j] =temp;
            i++;
            j--;
        }
    }
    
}




/* 

Hint 1

Can we reverse certain parts of an array to rotate it by B times?



Solution Approach

Let, n be the length of the array.
Rotating an array by n and 2 * n times give same results, i.e., rotating i or i % n times is same.
So, we update B to B % n.

When we rotate the array B times, B elements from the back end of the array come to the front 
and the rest of the elements from the front shift backwards.

In this approach, we firstly reverse all the elements of the array. 
Then, reversing the first B elements followed by reversing the rest N - B elements gives us the required result.


Complete Solution

import java.lang.*;
import java.util.*;

public class Main {
    public static void reverse(int[] A, int start, int end) {
        int i, j;
        for (i = start, j = end; i < j; i++, j--) {
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        int B = sc.nextInt() % n;
        reverse(A, 0, n - 1);
        reverse(A, 0, B - 1);
        reverse(A, B, n - 1);

        for (int i = 0; i < n; i++) {
            System.out.print(A[i] + " ");
        }
        System.out.println("");

    }
}

https://www.jdoodle.com/online-java-compiler/

 */