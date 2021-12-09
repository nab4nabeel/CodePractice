/* 

C1 : Given N array elements check if there exits a pai i,j such that A[i]+A[j]= k && i != j 

Given 1:
A[ ]:{3,-2,1,4,3,6,8}
k=10	   

Ans = A[3]+A[5] = 4 + 6 = 10 => return true

Given 2:
A[ ]:{2,4,-3,7}
k=5	   

Ans = return false


Given 3:
A[ ]:{2,4,-3,7}
k=8	   

Ans = A[1]+A[1] = 8 => i != j => return false

Idea:
Consider every pair of indices (i,j) such that i != j

Consider below matrix of pairs iterate either upper or lower triangle of diagnol to get all combinations of (i,j) such that i!=j


If A[] => N=4 => indices => 0,1,2,3

(0,0)	(0,1)	(0,2)	(0,3)
(1,0)	(1,1)	(1,2)	(1,3)
(2,0)	(2,1)	(2,2)	(2,3)
(3,0)	(3,1)	(3,2)	(3,3)


 */

import java.lang.*;
import java.util.*;

public class C2 {
    public static void main(String[] args) {
        

		int[] A = {3,-2,1,4,3,6,8};
		int k=10;

		int[] B = {3,-2,1,4,3,6,8};
		int k2=15;
		
		System.out.println("Given N array elements check if there exits a pai i,j such that A[i]+A[j]= k ");

		System.out.println("Upper Matrix " + iterateUpperElements(A, k2, A.length));
		
		System.out.println("Lower Matrix " + iterateLowerElements(B, k2, B.length));

	}   
	
	/* 
		Solution 1: 
			Step 1: Iterate Upper left matrix
			
			T.C = O(N^2)
			S.C = O(1)
	*/
	private static boolean iterateUpperElements(int[] A, int k, int N){
		
		for(int i=0; i < N; i++){
			for(int j=i+1; j < N; j++){
				//System.out.print("i:"+ i +"j:"+j+"\t");
				if( A[i] + A[j] == k){
					return true;
				}
			}
			//System.out.println("\n");
		}
		return false;
	}

	/* 
		Solution 2: 
			Step 1: Iterate Lower left matrix
			
			T.C = O(N^2)
			S.C = O(1)
	*/
	private static boolean iterateLowerElements(int[] A, int k, int N){
		
		for(int i=N-1; i >= 0; i--){
			for(int j=i-1; j >= 0; j--){
				//System.out.print("i:"+ i +"j:"+j+"\t");
				if( A[i] + A[j] == k){
					return true;
				}
			}
			//System.out.println("\n");
		}
		return false;
	}


}