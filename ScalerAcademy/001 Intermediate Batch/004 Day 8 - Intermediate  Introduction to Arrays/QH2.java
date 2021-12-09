/* 

Q2. Second Largest


Problem Description

You are given an integer T (Number of test cases). For each test case, You are given an integer array A. You have to find the second largest element/value in the array or report that no such element exists.


Problem Constraints

1 <= T <= 10

1 <= |A| <= 105

0 <= A[i] <= 109



Input Format

First line consists of a single integer T.

Each test case, on a separate line,first integer is an integer |A| denoting the length of array, and then |A| integers denote the array elements.



Output Format

For each test case, If such an element exists, print its value, else print -1, on a separate line.


Example Input

Input 1:

 1
 3 2 1 2 

Input 2:

 1
 1 2



Example Output

Output 1:

 2 

Output 2:

 -1 



Example Explanation

Explanation 1:

 First largest element = 2
 Second largest element = 2
 Third largest element = 1

Explanation 2:

 There is no second largest element in the array.

 */
 
 
 
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

        for(int k=0;k<T;k++){
        
            int N = sc.nextInt();
            int[] a = new int[N];
            for(int m = 0; m < N; m++){
                a[m] = sc.nextInt();
            }

            if(N == 1){
                System.out.println(-1);
            }else{
                int max1 = -1;
                int max2 = -1;
                for (int i = 0; i < N; i++)   
                {
                    if(a[i]> max1){
                        max2 = max1;
                        max1 = a[i];
                    }else if(a[i] > max2 || a[i]== max1){
                        max2=a[i];
                    }
                }

            System.out.println(max2);
            }
        }

    }
}


 /* 

Hint

You can loop through the array maintaining two variables:
1) largest : denoting the largest element in the array processed.
2) secondLargest : denoting the second largest element in the array processed.

                  OR

Try to find out the largest element, and then we can find second largest using it.


Solution Approach

First, we find out the index / position of the largest element in the array. If there are multiple such indices, we can use any
such index. Then using it we can find the largest value present in the array excluding the largest element index.


#include<stdio.h>
#include<stdlib.h>

int main()  {
    // YOUR CODE GOES HERE
    // Please take input and print output to standard input/output (stdin/stdout)
    // E.g. 'scanf' for input & 'printf' for output
    int T, N, A[100005], largeIdx = 0, i, secondLargest;
    
    scanf("%d", &T);
    
    while(T--){
    
        scanf("%d", &N);
        
        largeIdx = 0;
        
        for (i = 0; i < N;i++){
            scanf("%d", &A[i]);
            if(A[i] > A[largeIdx]){
                largeIdx = i;
            }
        }
        
        secondLargest = -1;
        
        for (i = 0; i < N;i++){
            if(i != largeIdx){
                if(A[i] > secondLargest){
                    secondLargest = A[i];
                }
            }
        }
    
        printf("%d\n", secondLargest);
    }
    return 0;
}


 */