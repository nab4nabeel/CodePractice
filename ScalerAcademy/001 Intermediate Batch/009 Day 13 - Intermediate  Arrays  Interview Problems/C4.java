/* 

Q3) Find no of triplets i,j,k such that i<j<k and ar[i]<ar[j]<ar[k]

Ex:

1)

A[]=	3 4 6 9 2
index	0 1 2 3 4


Triplets
i j k	A[i]	A[j]	A[k]
0 1 2	3		4		6
0 2 3	3		6		9
0 1 3 	3		4		9
1 2 3	4		6		9

Ans=4


2)

A[]=	2 6 9 4 10
index	0 1 2 3 4


Triplets
i j k	A[i]	A[j]	A[k]
0 1 2	2		6		9
0 1 4	2		6		10
0 2 4	2		9		10
0 3 4	2		4		10
1 2	4	6		9		10

Ans=5



Pseudo Code

count=0

(i=0;i<n;i++){
	(j=i+1;j<n;j++){
		(k=j+1;k<n;k++){
			if(ar[i]<ar[j]<ar[k]){
				count++;
			}
		}
	}
}

T.C = O(N^3)
S.C = O(1)


********************************

(Contribution technique)
Idea: Fix the center element and check left right

ar[]=	3	6	9	12	5	16	8	7	11
index=	0 	1	2 	3  	4  	5 	6 	7 	8	

left =	 	1	2	3	1	5	3	3
right=		6	3	1	4	0	1	1
Total=		6	6	3	4	0	3	3	= 25

Pseudo Code:
count=0
(i=1;i<n-1;i++){
	left= number of elements < A[i] in left[0,i-1]
	right= number of elements > A[i] in right[i+1,n-1]
	count=count+left*right
}

T.C=O(N^2)
S.C=O(1)

$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

Final optimized solution T.C=O(n log n)
1) Balanced BST
2) Segmented Trees


 */
 

import java.io.*;
import java.util.*;
 
public class C1{
	public static void main(String[] args){
		
		int[] A = {3,6,9,12,5,16,8,7,11};
		int n = A.length;
		
		System.out.println("\nno of triplets i,j,k such that i<j<k and ar[i]<ar[j]<ar[k] "+ Arrays.toString(A));
		System.out.println("Brute Force");
		System.out.println(getTripletsBrute(A,n));
		
		System.out.println("\nno of triplets i,j,k such that i<j<k and ar[i]<ar[j]<ar[k] "+ Arrays.toString(A));
		System.out.println("Contribution Technique");
		System.out.println(getTripletsContrib(A,n));
		
		
		
	
	}
	
	public static int getTripletsBrute(int[] A, int n){
		int count=0;
		for(int i=0;i<n;i++){
			for(int j=i+1;j<n;j++){
				for(int k=j+1;k<n;k++){
					if(A[i]<A[j]&& A[j]<A[k]){
						count++;
					}
				}
			}
		}
		return count;
	}
	
	public static int getTripletsContrib(int[] A, int n){
		int count=0;
		for(int i=1;i<n-1;i++){
			int left = getLesserThanCount(A,i);
			int right = getGreaterThanCount(A,i);
			count += left*right;
		}
		return count;
	}
	
	public static int getLesserThanCount(int[] A, int index){
		int leftCount = 0;
		for(int i=index-1; i>=0;i--){
			if(A[index]>A[i]){
				leftCount++;
			}
		}
		return leftCount;
	}
	
	public static int getGreaterThanCount(int[] A, int index){
		int rightCount = 0;
		for(int i=index+1; i<A.length;i++){
			if(A[index]<A[i]){
				rightCount++;
			}
		}
		return rightCount;
	}
}
 
 
 
 /* 

no of triplets i,j,k such that i<j<k and ar[i]<ar[j]<ar[k] [3, 6, 9, 12, 5, 16, 8, 7, 11]
Brute Force
25

no of triplets i,j,k such that i<j<k and ar[i]<ar[j]<ar[k] [3, 6, 9, 12, 5, 16, 8, 7, 11]
Contribution Technique
25


 */