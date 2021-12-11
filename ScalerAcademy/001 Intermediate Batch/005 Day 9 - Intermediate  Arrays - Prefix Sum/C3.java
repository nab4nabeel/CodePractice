/* 

Given N array elements and Q queries for each query calculate sum of all even indices in given range


		   0, 1, 2, 3, 4, 5, 6, 7
arr[10]=  {3, 4,-2, 8, 6, 2, 1, 3}

Q = 5

L-R		Sum
2-5		4
3-7		7
0-7		8
7-7		0
4-4		6


PFeven[i]= Sum of all even index from [0,i]

		   0, 1, 2, 3, 4, 5, 6, 7
arr[10]=  {3, 4,-2, 8, 6, 2, 1, 3}

PFeven[i]= Sum of all even index from [0,i]
PFeven[0]= sum of even indices [0,0]	= 3	(Calculate)
PFeven[1]= sum of even indices [0,1]	= 3 (Copy)
PFeven[2]= sum of even indices [0,2]	= 1 (Calculate)
PFeven[3]= sum of even indices [0,3]	= 1 (Copy)
PFeven[4]= sum of even indices [0,4]	= 7 (Calculate)
PFeven[5]= sum of even indices [0,5]	= 7 (Copy)
PFeven[6]= sum of even indices [0,6]	= 8 (Calculate)
PFeven[7]= sum of even indices [0,7]	= 8 (Copy)

(Copy) when the index is not even we can copy from previous even index

			 0, 1, 2, 3, 4, 5, 6, 7
arr[10]=  	{3, 4,-2, 8, 6, 2, 1, 3}
PFeven[10]= {3, 3, 1, 1, 7, 7, 8, 8}


Psuedo Code:

PFEven[0] = 0;
(i=1;i<n;i++)
{
		if(i%2==1){
			PFEven[i] = PFEven[i-1];
		}else{
			PFEven[i] = PFEven[i-1] + arr[i];
		}
}


			 0, 1, 2, 3, 4, 5, 6, 7
arr[10]=  	{3, 4,-2, 8, 6, 2, 1, 3}
PFOdd[10]= 	{0, 1, 1, 4, 4, 9, 9, 16}

			 0, 1, 2, 3, 4, 5, 6, 7
arr[10]=  	{3, 4,-2, 8, 6, 2, 1, 3}
PFeven[10]= {3, 3, 1, 1, 7, 7, 8, 8}
PFOdd[10]= 	{0, 4, 4,12,12,14,14,17}

Q = 5

L-R		EvenSum		OddSum
2-5		4			10
3-7		7			13
0-7		8			17
7-7		0			3
4-4		6			0

 */
 
 
 
import java.lang.*;
import java.util.*;

public class C3 {
    public static void main(String[] args) {
        

		int[] A = {3, 4,-2, 8, 6, 2, 1, 3};
		int[] PFEven = getPrefixEvenArray(A);
		int[][] Q = { {2,3,0,7,4}, {5,7,7,7,4}};

		System.out.println("A: "+Arrays.toString(A));
		System.out.println("PFEven: "+Arrays.toString(PFEven));

		System.out.println();			

		System.out.println("Sum of all even elements in given range");
		printSumInRange( Q, PFEven);

		System.out.println();

		int[] PFOdd = getPrefixOddArray(A);

		System.out.println("A: "+Arrays.toString(A));
		System.out.println("PFOdd: "+Arrays.toString(PFOdd));

		System.out.println();			
		
		
		System.out.println("Sum of all odd elements in given range");
		printSumInRange( Q, PFOdd);
		
	}   

	
	public static int[] getPrefixEvenArray(int[] A){

		int[] PF = new int[A.length];
		PF[0] = A[0];
		for(int i=1;i<A.length;i++){
				if(i%2==0){
					PF[i] = PF[i-1] + A[i]; 
				}else{
					PF[i] = PF[i-1];
				}
		}
		return PF;
	}
	
	public static int[] getPrefixOddArray(int[] A){

		int[] PF = new int[A.length];
		PF[0] = 0;
		for(int i=1;i<A.length;i++){
				if(i%2==1){
					PF[i] = PF[i-1] + A[i]; 
				}else{
					PF[i] = PF[i-1];
				}
		}
		return PF;
	}
	
	public static void printSumInRange(int[][] Q, int[] PF){
				for(int q = 0; q < Q[0].length; q++){
				int L = Q[0][q];
				int R = Q[1][q];
				
				System.out.print("L: " +L +"-R: " +R);
				
				if(L==0){
					System.out.print("  Sum :" + PF[R]);
				}else{
					System.out.print("  Sum :" + (PF[R]-PF[L-1]));
				}
				System.out.println();			
		}
	}
} 


/* 

A: [3, 4, -2, 8, 6, 2, 1, 3]
PFEven: [3, 3, 1, 1, 7, 7, 8, 8]

Sum of all even elements in given range
L: 2-R: 5  Sum :4
L: 3-R: 7  Sum :7
L: 0-R: 7  Sum :8
L: 7-R: 7  Sum :0
L: 4-R: 4  Sum :6

A: [3, 4, -2, 8, 6, 2, 1, 3]
PFOdd: [0, 4, 4, 12, 12, 14, 14, 17]

Sum of all odd elements in given range
L: 2-R: 5  Sum :10
L: 3-R: 7  Sum :13
L: 0-R: 7  Sum :17
L: 7-R: 7  Sum :3
L: 4-R: 4  Sum :0

 */