/* 

Q) Find the sum of all sub arrays:

For this we will have to iterate through all the values present in the sub arrays to get the sum which would need two pointers to identify the range of every new sub array and another loop to loop through those range. Causing to have T.C of O(N2)


But It can be done using contribution technique:

To understand contribution technique consider below observations:

In How many Sub arrays index 3 is present?

ar[]	= 3,-2, 4,-1, 2, 6
index	= 0, 1, 2, 3, 4, 5

consider sub arrays to left and right of the element including the element

left	right
0		3
1		4
2		5
3

Total Sub arrays where element 3 is present
= 4*3 = 12

In How many Sub arrays index 1 is present?

ar[]	= 3,-2, 4,-1, 2, 6
index	= 0, 1, 2, 3, 4, 5

consider sub arrays to left and right of the element including the element

left	right
0		1
1		2
		3
		4
		5

Total Sub arrays where element 3 is present
= 2*5 = 12


considering above observations for all elements


ar[]				= 3,-2, 4,-1, 2, 6
index				= 0, 1, 2, 3, 4, 5

left				= 1, 2, 3, 4, 5, 6
right				= 6, 5, 4, 3, 2, 1

No of times			= 6,10,12,12,10, 6	
(This says in all sub arrays how many times the particular index contribute to)

ar[]				= 3,-2, 4,-1, 2, 6
No of times			= 6,10,12,12,10, 6	

mul the contribution=18-20+48-12+20+30=	90

Generalized:

Given N elements in how many sub arrays index i is present?

Index: 0 1 2 3 ... i i+1 i+2 ... N-1

left: [0 i]=i+1
right:[i N-1]=N-1-i+1=N-i

No of sub arrays = left * right = (i+1)*(N-i)

Psuedo Code:

sum=0
(i=0;i<N;i++){
	left = i+1
	right = N-i
	c= left * right
	sum += A[i] * C
}

T.C:O(N)
S.C:O(1)

 */



import java.io.*;
import java.util.*;
 
public class C4{
	
	public static void main(String[] args){
		
		
		int[] A = {3,-2,4,-1,2,6};
		int N = A.length;
		
		System.out.println("\nContribution  Technique\nMax Sum wiht Sub Arrays length 5 for given array ar : "+ Arrays.toString(A)+"\n Max Sum :"+maxSumSubArrayContribution(A,N));
	}
	
	public static int maxSumSubArrayContribution(int[] A, int N){
		int sum = 0,left,right,cont;
		for(int i=0;i<N;i++){
			left = i+1;
			right = N-i;
			cont = left * right;
			sum += A[i] * cont;
		}
		return sum;
	}
		
	
} 



 /* 

Contribution  Technique
Max Sum wiht Sub Arrays length 5 for given array ar : [3, -2, 4, -1, 2, 6]
Max Sum :90




 */