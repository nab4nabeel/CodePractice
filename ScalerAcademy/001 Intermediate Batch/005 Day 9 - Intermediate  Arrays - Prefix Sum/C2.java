/* 

Equilibrium Index:

Q) Given N array elements, count no of Equilibrium Index.

An index is said to be Equilibrium Index if

Sum of all elements before ith index = Sum of all elements after ith index

Sum[0,i-1] = Sum[i+1,N-1]

Note:
if i==0 leftSum = 0
if i==N-1 rightSum =0

Ex1:

		   0, 1, 2, 3, 4, 5, 6
arr[10]= {-7, 1, 5, 2,-4, 3, 0}
leftSum:   0 -7 -6 -1  1 -3  0
rightSum:  7  6  1 -1  3  0  0

Equilibrium Index : 3 and 6

Ex2:
		   0, 1, 2, 3, 4, 5, 6
arr[10]=  {3,-1, 2,-1, 1, 2, 1}
leftSum:   0  3  2  4  3  4  7
rightSum:  4  5  3  4  3  1  0

Equilibrium Index : 3 and 4

Generalized:
	leftSum = SUM[0,i-1] => PF[i-1]
	rightSum = SUM[i+1,N-1] => PF[N-1] - PF[i]


Psuedo Code:
//Generate PF[]		T.C = O(N) S.C= O(N)
int count=0
(i=0;i<n;i++){		T.C = O(N) S.C= O(1)
	
	if(i==0){
		leftSum = 0;
	}else{
		leftSum = SUM[0,i-1] => PF[i-1]
	}

	rightSum = SUM[i+1,N-1] => PF[N-1] - PF[i]

	if(leftSum == rightSum){
		count++;
	}
}
return count

Total T.C = O(N) S.C= O(N)

 */
 
 


import java.lang.*;
import java.util.*;

public class C2 {
    public static void main(String[] args) {
        
		int[] A = {-7, 1, 5, 2,-4, 3, 0};
		
		int[] PF = getPrefixArray(A);
		
		System.out.println("A: "+Arrays.toString(A));
		System.out.println("No of Equilibrium Index: " + noOfEquilibriumIndex(PF, A.length));
		
		int[] B = {3,-1, 2,-1, 1, 2, 1};
		int[] PFB = getPrefixArray(B);
		
		System.out.println();
		System.out.println("B: "+Arrays.toString(A));
		System.out.println("No of Equilibrium Index: " + noOfEquilibriumIndex(PFB, B.length));
		
		
		
	}   
	
	public static int[] getPrefixArray(int[] A){

		int[] PF = new int[A.length];
		PF[0] = A[0];
		for(int i =1; i< A.length; i++){
			PF[i] = PF[i-1] + A[i];
		}
		
		return PF;
	}
	
	public static int noOfEquilibriumIndex(int[] PF, int n){
		int count = 0;
		for(int i=0;i<n;i++){
			int leftSum = 0;
			int rightSum = 0;
			
			System.out.print("Index: "+i);
		
			if(i==0){
				leftSum =0;
			}else{
				leftSum = PF[i-1];
			}
			
			rightSum = PF[n-1] - PF[i];
			System.out.print("   Left Sum : "+ leftSum);
			System.out.print("   Right Sum: "+ rightSum);
		
		
			if(leftSum == rightSum){
				count++;
				System.out.print("   Equilibrium Index ");
			}
			System.out.println();
		}
		return count;
	}

} 


/* 

A: [-7, 1, 5, 2, -4, 3, 0]
Index: 0   Left Sum : 0   Right Sum: 7
Index: 1   Left Sum : -7   Right Sum: 6
Index: 2   Left Sum : -6   Right Sum: 1
Index: 3   Left Sum : -1   Right Sum: -1   Equilibrium Index 
Index: 4   Left Sum : 1   Right Sum: 3
Index: 5   Left Sum : -3   Right Sum: 0
Index: 6   Left Sum : 0   Right Sum: 0   Equilibrium Index 
No of Equilibrium Index: 2

B: [-7, 1, 5, 2, -4, 3, 0]
Index: 0   Left Sum : 0   Right Sum: 4
Index: 1   Left Sum : 3   Right Sum: 5
Index: 2   Left Sum : 2   Right Sum: 3
Index: 3   Left Sum : 4   Right Sum: 4   Equilibrium Index 
Index: 4   Left Sum : 3   Right Sum: 3   Equilibrium Index 
Index: 5   Left Sum : 4   Right Sum: 1
Index: 6   Left Sum : 6   Right Sum: 0
No of Equilibrium Index: 2

 */