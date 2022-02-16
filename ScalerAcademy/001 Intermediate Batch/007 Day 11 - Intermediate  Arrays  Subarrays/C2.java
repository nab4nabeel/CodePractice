/* 

Print start and end index of all subarrays of len=k

ar[12]

k=6

output
[s e]

[0 5]
[1 6]
[2 7]
[3 8]
[4 9]
[5 10]
[6 11]

Total Sub Arrays: 7


k=2

output
[s e]

[0 1]
[1 2]
[2 3]
[3 4]
[4 5]
.
.
.
[10 11]

Total Sub Arrays: 11

Generalized:

N array elements s,e index of len=k

[s e]

[0 k-1]
[1 k]
[2 k+1]
[3 k+2]
[3 k+3]
.
.
.
[N-k N-1]	=> N-1 -(N-k) +1 => N-1-N+k+1 => K elements


Total Number of Sub arrays of len k 
consider start index range s => 0 to N-k => N-k-0+1
=> N-k+1 total elements

Pseudocode:

e=K-1
(s=0; s<=N-k; s++,e++)
	print from(s to e)
	
	
T.C = No of subarrays => O(N-k+1)
 */

import java.io.*;
import java.util.*;

public class C2{
	
	public static void main(String[] args){
		
		int[] ar = {0,1,2,3,4,5,6,7,8,9,10,11};
		int N = ar.length;
		
		System.out.println("Sub Arrays for given array ar : "+ Arrays.toString(ar));
		
		System.out.println("\nSub Arrays length 6 for given array ar : "+ Arrays.toString(ar));
		
		printSubArrays(ar,N,6);

		System.out.println("\nSub Arrays length 2 for given array ar : "+ Arrays.toString(ar));
		
		printSubArrays(ar,N,2);
		
	}
	
	public static void printSubArrays(int[] A, int N, int K){
		
		for(int s=0,e=K-1; s<= N-K; s++,e++){
			System.out.println("Index : [" + s +" "+ e +"]");
		}
		
		System.out.println("Total :" + (N-K+1));
	}
} 
 
 
 /* 

Output:

Sub Arrays for given array ar : [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]

Sub Arrays length 6 for given array ar : [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]
Index : [0 5]
Index : [1 6]
Index : [2 7]
Index : [3 8]
Index : [4 9]
Index : [5 10]
Index : [6 11]
Total :7

Sub Arrays length 2 for given array ar : [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]
Index : [0 1]
Index : [1 2]
Index : [2 3]
Index : [3 4]
Index : [4 5]
Index : [5 6]
Index : [6 7]
Index : [7 8]
Index : [8 9]
Index : [9 10]
Index : [10 11]
Total :11


 */