/* 

C1 : Given N array elements count no of elements having atleast 1 element greater than itself[No external libraries]

A[7]:{-3,-2,6,8,4,8,5}
	   O  O O X O X O
	   
Ans = Total Elements - Maximum Element Occurance	   
Ans = 7-2 = 5

 */

import java.lang.*;
import java.util.*;

public class C1 {
    public static void main(String[] args) {
        
		
		int[] A = {-3,-2,6,8,4,8,5};

		System.out.println("Elements in array having at least one element greater than itself :" + noOfGreaterElements(A));
		

				

	}   
	
	/* 
		Solution 1: 
			Step 1: Iterate and Get Maximum Value in the Array
			Step 2: Iterate and Get No of occurance of Maximum Value in the Array
			Step 3: No of Elements - Count
			
			T.C = O(N)
	*/
	private static int noOfGreaterElements(int[] A){
		
		int maxValue = Integer.MIN_VALUE;
		int maxValueCount = 0;
		for(int i=0; i < A.length; i++){
			if(maxValue < A[i]){
				maxValue = A[i];
			}
		}

		for(int i=0; i < A.length; i++){
			if(A[i] == maxValue){
				maxValueCount++;
			}
		}
		
		return A.length - maxValueCount;
	}


}