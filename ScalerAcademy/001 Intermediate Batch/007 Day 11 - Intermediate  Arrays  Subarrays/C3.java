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

Solution 1:

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

Solution 2:

For every subarray of len=k get sum using prefix sum

s=0,e=k-1
ans=INT_MIN
for( ;s<=N-k;s++,e++){
	sum=[s e] using pf[]
	ans=max(ans,sum)
}

T.C:O(N)
S.C:O(N)

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
		int ans = Integer.MIN_VALUE;
		for(int s=0,e=K-1; s<= N-K; s++,e++){
			int sum =0;
			int[] pfSum = new int[N];
			pfSum[0]=A[0];
			for(int k=1;k<N;k++){
				pfSum[k]= pfSum[k-1]+A[k];
			}
			sum = getSumFromPrefix(pfSum,s,e);
			ans = Math.max(ans,sum);
		}
		return ans;
	}
	
	public static int getSumFromPrefix(int[] pfSum, int L, int R){
		if(L==0){
			return pfSum[R];
		}
		return pfSum[R]-pfSum[L-1];
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


  */