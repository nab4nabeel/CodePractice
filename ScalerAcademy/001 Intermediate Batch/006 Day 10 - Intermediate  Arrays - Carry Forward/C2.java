/* 

Leaders in a Array

Q) Given in an array ar[N], you have to find all leaders in ar[]. An element is a leader, if it is strictly greater thatn all elements on its right side

Note: ar[N-1] is always considered as leader

Ex1:

0,  1,2,3,4,5,6,7
15,-1,7,2,5,4,2,3
Y, N,Y,N,Y,Y,N,Y

total leaders: 5

Ex1:

 0,1,2,3,4,5
10,7,9,3,2,4
Y, N,Y,N,N,Y

total leaders: 3

Idea: Iterate from right to left and check the count for max 

Psuedo Code 

int c=1; as left most value is always leader
int max=ar[N-1]
(i=N-2;i>=0;i--){
	if(ar[i] > max){
		c++;
		max =ar[i];
	}
}
return c;

T.C = O(N)
S.C = O(1)


 */
 
import java.lang.*;
import java.util.*;

public class C2 {
    public static void main(String[] args) {
        

		int[] A = {15,-1,7,2,5,4,2,3};	
		int N = A.length;
	
		System.out.println("A: " + Arrays.toString(A));
		System.out.println("Number of leaders: " + carryForwardRightLeft(A,N));
		
		int[] B = {15};
		int M = B.length;
		
		System.out.println("B: " + Arrays.toString(B));
		System.out.println("Number of leaders: " + carryForwardRightLeft(B,M));
		
		int[] C = {15,8,8};
		int P = C.length;
		
		System.out.println("C: " + Arrays.toString(C));
		System.out.println("Number of leaders: " + carryForwardRightLeft(C,P));
		
	}   
		
	
	private static int carryForwardRightLeft(int[] A, int N){
		int c=1, max=A[N-1];
		for(int i=N-2;i>=0;i--){
			if(A[i] > max){
				c++;
				max = A[i];
			}
		}
		return c;
	}
	

}

/* 

Output:

A: [15, -1, 7, 2, 5, 4, 2, 3]
Number of leaders: 5
B: [15]
Number of leaders: 1
C: [15, 8, 8]
Number of leaders: 2
 */
