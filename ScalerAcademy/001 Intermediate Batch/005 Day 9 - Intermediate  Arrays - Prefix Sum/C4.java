/* 

Special Index:


An index is said to be special index,
if after deleting that index Sum of all even index value = Sum of all odd idex values
Count how many special index are there?



Ex 1:
			 0, 1, 2, 3, 4, 5
arr[ ]=  	{4, 3, 2, 7, 6,-2}


Delete Index 0 (Y)
			 0, 1, 2, 3, 4
arr[ ]=  	{3, 2, 7, 6,-2}

PFEven[ ]= 	{3, 2,10,10, 8}
PFOdd[ ]= 	{0, 2, 2, 8, 8}

Delete Index 1 (N)
			 0, 1, 2, 3, 4
arr[ ]=  	{4, 2, 7, 6,-2}

PFEven[ ]= 	{4, 4,11,11, 9}
PFOdd[ ]= 	{0, 2, 2, 8, 8}

Delete Index 2 (Y)
			 0, 1, 2, 3, 4
arr[ ]=  	{4, 3, 7, 6,-2}

PFEven[ ]= 	{4, 4,11,11, 9}
PFOdd[ ]= 	{0, 3, 3, 9, 9}

============================================================================

Ex 2: Observation

Index:		0, 1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12,13

If we are deleting index 5

Index:		0, 1, 2, 3, 4,__, 6, 7, 8, 9,10,11,12,13
			SumEven[0,4]    	SumEven[6,13]		{We are left with even values after deleting 5}
			SumOdd[0,4]     	SumOdd[6,13]		{We are left with odd values after deleting 5}

As 5 is deleted from the array rest of the arrays after 5 are shifted to left making odd index to even and even to odd
Thus,

	TotalSumEven 	= SumEven[0,4] + SumOdd[6,13]
	TotalSumOdd 	= SumOdd[0,4] + SumEven[6,13]

Generalized:

After deleting index i

TotalSumEven =	SumEven[0,i-1]	+	SumOdd[i+1,n-1]
TotalSumOdd = 	SumOdd[0,i-1]	+	SumEven[i+1,n-1]

=================================================================================

Implement

			 0, 1, 2, 3, 4, 5
arr[ ]=  	{4, 3, 2, 7, 6,-2}
PFEven[ ]= 	{4, 4, 6, 6,12,12}
PFOdd[ ]= 	{0, 3, 3,10, 0, 8}

-----------------------------
Delete 0 Index:

Delete Index 0 (Y)
			 0, 1, 2, 3, 4
arr[ ]=  	{3, 2, 7, 6,-2}

PFEven[ ]= 	{3, 2,10,10, 8}
PFOdd[ ]= 	{0, 2, 2, 8, 8}
-----------------------------

TotalSumEven =	SumEven[0,i-1]	+	SumOdd[i+1,n-1]
TotalSumOdd = 	SumOdd[0,i-1]	+	SumEven[i+1,n-1]

TotalSumEven = SumOdd[1,5] = PFOdd[5] - PFOdd[1-1]	=	12 - 4	= 8 
TotalSumOdd = SumEven[1,5] = PFEven[5] - PFEven[1-1]=	8 - 0 	= 8

******************************************************************************************
			 0, 1, 2, 3, 4, 5
arr[ ]=  	{4, 3, 2, 7, 6,-2}
PFEven[ ]= 	{4, 4, 6, 6,12,12}
PFOdd[ ]= 	{0, 3, 3,10, 0, 8}

-----------------------------
Delete Index 2 (Y)
			 0, 1, 2, 3, 4
arr[ ]=  	{4, 3, 7, 6,-2}

PFEven[ ]= 	{4, 4,11,11, 9}
PFOdd[ ]= 	{0, 3, 3, 9, 9}

-----------------------------

TotalSumEven =	SumEven[0,i-1]	+	SumOdd[i+1,n-1]
TotalSumOdd = 	SumOdd[0,i-1]	+	SumEven[i+1,n-1]


TotalSumEven	= SumEven[0,1] + SumOdd[3,5]	=	PFEven[1]	+ (PFOdd[5]-PFOdd[3-1]) = 	4+(8-3)= 9
TotalSumOdd		= SumOdd[0,1] + SumEven[3,5]	=	PFOdd[1]	+ (PFEven[5]-PFEven[3-1])=	3+(12-6)=9


================================================================================================


PsuedoCode:

1) Generate PrefixEven array		T.C= O(N)	 S.C= O(N)
2) Generate PrefixOdd array			T.C= O(N)	 S.C= O(N)
3)		count =0 
		(i=0;i<n;i++){			//Handle i=0 and i=n-1 carefully		T.C= O(N)	 S.C= O(1)
			//Check if special Index

				TotalSumEven =	SumEven[0,i-1]	+	SumOdd[i+1,n-1]
				TotalSumOdd = 	SumOdd[0,i-1]	+	SumEven[i+1,n-1]

				if(TotalSumEven == TotalSumOdd)
					count++
			
		}
		
	Total T.C = O(N+N+N) => O(N) 
	Total S.C= O(N+N+1) => O(N) 
	
 */
 
 

import java.lang.*;
import java.util.*;

public class C2 {
    public static void main(String[] args) {
        
		int[] A = {4, 3, 2, 7, 6,-2};
		int n = A.length;
		
		int[] PFEven = getPrefixEvenArray(A);
		int[] PFOdd = getPrefixOddArray(A);
		
		
		System.out.println("A: "+Arrays.toString(A));
		System.out.println("PFEven: "+Arrays.toString(PFEven));
		System.out.println("PFOdd: "+Arrays.toString(PFOdd));

		System.out.println();			

		
		int count =0;
		for(int i=0;i<n;i++){
			
			//TotalSumEven =	SumEven[0,i-1]	+	SumOdd[i+1,n-1]
			//TotalSumOdd = 	SumOdd[0,i-1]	+	SumEven[i+1,n-1]


			int totalEvenSum=0;
			int totalOddSum=0;
			if(i==0){
				totalEvenSum = getSumInRange(PFOdd,1,n-1);
				totalOddSum = getSumInRange(PFEven,1,n-1);
			}else if(i== n-1){
				totalEvenSum = getSumInRange(PFEven,0,n-2);
				totalOddSum = getSumInRange(PFOdd,0,n-2);
			}else{
				totalEvenSum = getSumInRange(PFEven,0,i-1) + getSumInRange(PFOdd,i+1,n-1);
				totalOddSum = getSumInRange(PFOdd,0,i-1) + getSumInRange(PFEven,i+1,n-1);
			}
						
			System.out.println("Index: "+ i +"  totalEvenSum :" + totalEvenSum + "  totalOddSum :" + totalOddSum);
			if(totalEvenSum == totalOddSum){
				System.out.println("Special Index: "+ i);
				count++;
			}
			System.out.println();
		}
		System.out.println(" Total Special index : "+ count);
	
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
	
	public static int getSumInRange(int[] PF,int L,int R){
				
				System.out.print("L: " +L +"-R: " +R);
				int sum =0;
				if(L==0){
					sum = PF[R];
					System.out.print("  Sum :" + sum);
				}else{
					sum = PF[R]-PF[L-1];
					System.out.print("  Sum :" + sum);
				}
				System.out.println();			
				return sum;
	}
} 


/* 

A: [4, 3, 2, 7, 6, -2]
PFEven: [4, 4, 6, 6, 12, 12]
PFOdd: [0, 3, 3, 10, 10, 8]

L: 1-R: 5  Sum :8
L: 1-R: 5  Sum :8
Index: 0  totalEvenSum :8  totalOddSum :8
Special Index: 0

L: 0-R: 0  Sum :4
L: 2-R: 5  Sum :5
L: 0-R: 0  Sum :0
L: 2-R: 5  Sum :8
Index: 1  totalEvenSum :9  totalOddSum :8

L: 0-R: 1  Sum :4
L: 3-R: 5  Sum :5
L: 0-R: 1  Sum :3
L: 3-R: 5  Sum :6
Index: 2  totalEvenSum :9  totalOddSum :9
Special Index: 2

L: 0-R: 2  Sum :6
L: 4-R: 5  Sum :-2
L: 0-R: 2  Sum :3
L: 4-R: 5  Sum :6
Index: 3  totalEvenSum :4  totalOddSum :9

L: 0-R: 3  Sum :6
L: 5-R: 5  Sum :-2
L: 0-R: 3  Sum :10
L: 5-R: 5  Sum :0
Index: 4  totalEvenSum :4  totalOddSum :10

L: 0-R: 4  Sum :12
L: 0-R: 4  Sum :10
Index: 5  totalEvenSum :12  totalOddSum :10

 Total Special index : 2

 */