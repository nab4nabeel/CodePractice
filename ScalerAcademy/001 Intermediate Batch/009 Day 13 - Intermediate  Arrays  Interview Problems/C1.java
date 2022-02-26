/* 

Q1) Given N array elements replace every element ar[i] with prod of all array elements except itself
you cannot use division in code

Ex:

1)

ar[5]	= 2, 4, 1, 3, 5
index	= 0, 1, 2, 3, 4

ar[5]	=60,30,120,40,24
[60, 30, 120, 40, 24]

2)
ar[4]	= 1, 6, 2, 3 = prod of all 36
index	= 0, 1, 2, 3

ar[4]	=36/1,36/6,36/2,36/2

But we are not allowed to use division

3)

ar[7]	= 2, 1, 3, 2, 1, 4, 2
index	= 0, 1, 2, 3, 4, 5, 6

ar[7]	= 2, 1, 3, 2, 1, 4, 2

---------------------------------------------------

Brute Force:

(i=0;i<N;i++){
	
	i > product of all elements except ith index
	i > prod[0,i-1]* prod[i+1,N-1]
	i > prod of left * prod of right

	left = 1
	(j=0;j<i;j++){
		left = left * ar[j]
	}
	right = 1
	(j=i+1;j<n;j++){
		right = right * ar[j]
	}
	
	prod[i]=left* right
}

T.C = O(N^2)
S.C = O(N)


---------------------------------------------------

Idea:

In above which part of code is taking more time?
Its the inner loop carry left to right

Idea 1) we can use prefix product

preP[i] = product of all elements from [0, i]
preP[i] = pref[i-1] * ar[i]

Note: Product of all indices from [i, j] 
preP[j]=prefP[i-1]* prod[i-j]
prod[i-j] = preP[j]/preP[i-1]

We cant use this as we cant use the division

Idea 2) Use Suffix for getting product of right side of i

Note:

Prefix: Starting at 0th index
pf[i]= product of all elements [0,i]

Suffix:Ending at N-1th index
sf[i]= product of all elements [i,N-1]

Hence Product[i] =>
	i > product of all elements except ith index
	i > Prefix[0,i-1]* Suffix[i+1,N-1]
	i > Prefix[i-1] * Suffix[i+1]


---------------------------------------------------


Psuedo Code:

1)preP[N]

preP[0]=ar[0]
(i=1;i<n;i++){
	preP[i] = preP[i-1] * ar[i]
}

2)sufP[N]: sufP[i] = product od all elements [i,N-1]

sufP[N-1]=ar[N-1]
(i=N-2;i>=0;i--){
	sufP[i] = ar[i]* sufP[i+1]
}

3) get product of left to right using preP and sufP


(i=0;i<n;i++){
	left = prod[0,i-1]= preP[i-1]{i==0>left=1}
	right = prod[i+1,N-1] = sufP[i+1]{i==N-1>right=1}
	ar[i]=left*right
}


T.C = O(N+N+N)= O(N)
S.C = O(N+N)

We can save the space by excluding preP as we can carry forward the left sum

ToDO: 	
Use Carry forward here
left = prod[0,i-1]= preP[i-1]{i==0>left=1}

T.C = O(N+N)= O(N)
S.C = O(N)

 */
 
 
import java.io.*;
import java.util.*;
 
public class C1{
	public static void main(String[] args){
		
		int[] A = {2,4,1,3,5};
		int n = A.length;
		
		System.out.println("\nPrinting Product of i ar[i] with prod of all array elements except itself  "+ Arrays.toString(A));
		
		System.out.println("\nBrute Force method");
		int[] R = solveBruteForce(A, n);
		
		System.out.println(Arrays.toString(R));
		
				
		System.out.println("\nPrefix and Suffix method");
		int[] C = solvePrefSuffMethod(A, n);
		
		System.out.println(Arrays.toString(C));
						
		System.out.println("\nCarry Forwad Left and Right Suffix method");
		int[] D = solveCarryForwardSuffMethod(A, n);
		
		System.out.println(Arrays.toString(D));
		
	}
	
	public static int[] solveBruteForce(int[] A,int n){
		int[] C = new int[n];
		for(int i=0;i<n;i++){
			int left=1;
			for(int j=0;j<i;j++){
				left = left * A[j];
			}
			int right=1;
			for(int j=i+1;j<n;j++){
				right = right * A[j];
			}
			C[i]=left*right;
		}
		return C;
	}
	
	
	public static int[] solvePrefSuffMethod(int[] A,int n){
		
		int[] preP = new int[n];
		preP[0]=A[0];
		for(int i=1;i<n;i++){
			preP[i] = preP[i-1] * A[i]; 
		}
		
		int[] sufP = new int[n];
		sufP[n-1] = A[n-1];
		for(int i=n-2;i>=0;i--){
			sufP[i] = A[i] * sufP[i+1];
		}
		
		int[] C = new int[n];
		for(int i=0;i<n;i++){
			int left = (i==0)? 1: getFromPrefixProduct(preP,i-1);
			int right = (i==n-1)? 1: getFromSuffixProduct(sufP,i+1);
			C[i]=left*right;
		}
		return C;
	}
	
	public static int getFromPrefixProduct(int[] prefP,int index){
		return prefP[index];
		
	}
	
	public static int getFromSuffixProduct(int[] suffP,int index){
		return suffP[index];
		
	}
	
		
	public static int[] solveCarryForwardSuffMethod(int[] A,int n){

		int[] sufP = new int[n];
		sufP[n-1] = A[n-1];
		for(int i=n-2;i>=0;i--){
			sufP[i] = A[i] * sufP[i+1];
		}
		
		int[] C = new int[n];
		int left=1;
		for(int i=0;i<n;i++){
			left = (i==0)? 1 : left * A[i-1];
			int right = (i==n-1)? 1: getFromSuffixProduct(sufP,i+1);
			C[i]=left*right;
		}
		return C;
	}
	
	
} 



/* 

Output:

Printing Product of i ar[i] with prod of all array elements except itself  [2, 4, 1, 3, 5]

Brute Force method
[60, 30, 120, 40, 24]

Prefix and Suffix method
[60, 30, 120, 40, 24]

Carry Forwad Left and Right Suffix method
[60, 30, 120, 40, 24]

 */