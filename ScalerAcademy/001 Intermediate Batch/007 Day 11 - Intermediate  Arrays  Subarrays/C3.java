/* 

Find Max subarray sum with len = k

ar[10] = -3 4 -2 5 3 -2 8 2 -1 4
k=5

[s e]	sum
[0 4]	7
[1 5]	8
[2 6]	12
[3 7]	16
[4 8]	10
[5 9]	11

Max Sub Array Sum = 16

Solution 1: Brute Force

For every subarray of len=k get sum

s=0,e=k-1
ans=INT_MIN
for( ;s<=N-k;s++,e++){
	sum=0
	(i=s;i<=e;i++){
		sum+=ar[i];
	}
	ans=max(ans,sum)
}

Exact Iterations = K*(N-K+1)
K range of value :{1 N}
If k=1 T.C=1*(N-1+1) =>N
If k=N T.C=N*(N-N+1) =>N
If k=N/2 T.C=N/2*(N-N/2+1) => N2

T.C = O(N2)
S.C = O(1)

Solution 2: Prefix Sum (As previous solution is N2)

1) Create prefix sum[]
For every subarray of len=k get sum using prefix sum
2)s=0,e=k-1,ans=INT_MIN
3)
for( ;s<=N-k;s++,e++){
	sum=[s e] using pf[]
	ans=max(ans,sum)
}

T.C:O(N)
S.C:O(N)

Solution 3: Sliding window technique (As previous solution needs space of N variable)

ar[10] = -3 4 -2 5 3 -2 8 2 -1 4
k=5


index	 0 1  2 3 4  5 6 7  8 9
ar[10]	-3 4 -2 5 3 -2 8 2 -1 4
[0 4]   -3 4 -2 5 3				: 7
[1 5]	   4 -2 5 3 -2			: 8 => prevSum - leaving element + next element => 7 -(-3) + (-2) = 8 
[2 6]	     -2 5 3 -2 8		: 12 => 8-4+8=12
[3 7]	        5 3 -2 8 2		: 16 => 12-(-2)+2=16
[4 8]	          3 -2 8 2 -1 	: 10 => 16-5+-1=10
[5 9]	            -2 8 2 -1 4	: 11 => 10-3+4=11

Generalize:

N array elements with widow size k

0 1 2 ... k-1 k k+1 k+2  .... N-1

1st Sub array sum: [0 k-1]: sum = {iterate [0 k-1]and get sum}
2nd Sub Array sum: [1 k]: sum = sum -ar[0]+ar[k]
3rd Sub Array sum: [2 k+1]: sum = sum -ar[1]+ar[k+1]
4th Sub Array sum: [3 k+2]: sum = sum -ar[2]+ar[k+2]
5th Sub Array sum: [4 k+3]: sum = sum -ar[3]+ar[k+3]
.
.
.
Last Sub Array sum:[N-k N-1]: sum = sum - ar[N-k-1] + ar[N-1]

Pseudo Code:

sum=0;
(i=0;i<k;i++){
	sum=A[i]
}
ans=sum
s=1,e=k
for( ;s<=N-k; s++,e++){
	sum = sum - A[s-1] + A[e]
	ans = Max(ans,sum)
}

T.C: K+N-k => O(N)
S.C: O(1)

 */
 
 

import java.io.*;
import java.util.*;

public class C3{
	
	public static void main(String[] args){
		
		int[] ar = {-3,4,-2,5,3,-2,8,2,-1,4};
		int N = ar.length;
		
		System.out.println("Sub Arrays for given array ar : "+ Arrays.toString(ar));
		
		System.out.println("\nMax Sum wiht Sub Arrays length 5 for given array ar : "+ Arrays.toString(ar)+"\n Max Sum :"+maxSumSubArrayBruteForce(ar,N,5));

		System.out.println("\nUsing PrefixArray\nMax Sum wiht Sub Arrays length 5 for given array ar : "+ Arrays.toString(ar)+"\n Max Sum :"+maxSumSubArrayPrefixArray(ar,N,5));

		System.out.println("\nSliding Window Technique\nMax Sum wiht Sub Arrays length 5 for given array ar : "+ Arrays.toString(ar)+"\n Max Sum :"+maxSumSubArraySlidingWindow(ar,N,5));
		
	}
	
	public static int maxSumSubArrayBruteForce(int[] A, int N, int K){
		int ans = Integer.MIN_VALUE;
		for(int s=0,e=K-1; s<= N-K; s++,e++){
			int sum =0;
			for(int i=s;i<=e;i++){
				sum+=A[i];
			}
			ans = Math.max(ans,sum);
		}
		return ans;
	}
	
	public static int maxSumSubArrayPrefixArray(int[] A, int N, int K){
		int[] pfSum = generatePFSumArray(A,N);
		int ans = Integer.MIN_VALUE;
		for(int s=0,e=K-1; s<= N-K; s++,e++){
			int sum =0;
			sum = getSumFromPrefix(pfSum,s,e);
			ans = Math.max(ans,sum);
		}
		return ans;
	}
	
	public static int[] generatePFSumArray(int[] A, int N){
		int[] pfSum = new int[N];
			pfSum[0]=A[0];
			for(int k=1;k<N;k++){
				pfSum[k]= pfSum[k-1]+A[k];
			}
		return pfSum;
	}
	
	public static int getSumFromPrefix(int[] pfSum, int L, int R){
		if(L==0){
			return pfSum[R];
		}
		return pfSum[R]-pfSum[L-1];
	}
	
	public static int maxSumSubArraySlidingWindow(int[] A, int N, int K){
		int sum=0;
		for(int i=0;i<K;i++){
			sum+=A[i];
		}
		int ans=sum;
		int s=1,e=K;
		for(	; s<=N-K;s++,e++){
			sum = sum - A[s-1] + A[e];
			ans = Math.max(ans,sum);
		}
		return ans;
	}

} 
  
  
  
  /* 

Output:

Sub Arrays for given array ar : [-3, 4, -2, 5, 3, -2, 8, 2, -1, 4]

Max Sum wiht Sub Arrays length 5 for given array ar : [-3, 4, -2, 5, 3, -2, 8, 2, -1, 4]
 Max Sum :16

Using PrefixArray
Max Sum wiht Sub Arrays length 5 for given array ar : [-3, 4, -2, 5, 3, -2, 8, 2, -1, 4]
 Max Sum :16

Sliding Window Technique
Max Sum wiht Sub Arrays length 5 for given array ar : [-3, 4, -2, 5, 3, -2, 8, 2, -1, 4]
 Max Sum :16
  */