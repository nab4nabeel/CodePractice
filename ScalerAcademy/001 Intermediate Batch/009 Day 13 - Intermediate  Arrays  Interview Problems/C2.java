/* 

Q2) Max consecutive 1's

Given a binarry array we can atmost replace a single 0 with 1 find max consecutive 1's we can get

Ex:

1)

0 1 1 1 0 1 1 0 1 1 0
^
1 1 1 1 0 1 1 0 1 1 0	>4
-------
0 1 1 1 0 1 1 0 1 1 0
		^
0 1 1 1 1 1 1 0 1 1 0	>6
-------
0 1 1 1 0 1 1 0 1 1 0
			  ^
0 1 1 1 0 1 1 1 1 1 0	>5
-------
0 1 1 1 0 1 1 0 1 1 0
					^
0 1 1 1 0 1 1 0 1 1 1	>3

Max=>6


********************************************

Brute force:

ans=0;
(i=0;i<n;i++){
	if A[i]==0{
		l = No of consecutive 1's on left
		r = No of consecutive 1's on right
		t=l+r+1;
		ans=max(t,ans)
	}
}

Pseudo code:

Iterate and get no of 1's
if(noI == n){
	return n;
}
ans=0;
(i=0;i<n;i++){
	if A[i]==0{
		l = 0
		(j=i-1;j>=0;j--){
			if(A[j]==1){l++}
			else{break;}
		}
		r = 0
		(j=i+1;j<n;j++){
			if(A[j]==1){r++}
			else{break;}
		}
		t=l+r+1;
		ans=max(t,ans)
	}
}

T.C=O(N+N+N)=> O(N)
S.C=O(1)

T.C=O(N+N+N) > (No of i + No of max left + No of max right)

T.C=O(N) as at a given time left and right cant be n iterations and are some constant value as we break after the value is 0 in inner loop
	
 */
 

import java.io.*;
import java.util.*;
 
public class C1{
	public static void main(String[] args){
		
		int[] A = {0,1,1,1,0,1,1,0,1,1,0};
		int n = A.length;
		
		System.out.println("\nwe can atmost replace a single 0 with 1 find max consecutive 1's  "+ Arrays.toString(A));
		System.out.println(getMaxConse1(A,n));
	
	}
	
	public static int getMaxConse1(int[] A, int n){
		int counti=0;
		for(int i=0;i<n;i++){
			if(A[i]==1){
				counti++;
			}
		}
		if(counti == n){
			return n;
		}
		int ans=0;
		for(int i=0;i<n;i++){
			int l=0;
			for(int j=i-1;j>=0;j--){
				if(A[j]==1){
					l++;
				}else{
					break;
				}
			}
			int r=0;
			for(int j=i+1;j<n;j++){
				if(A[j]==1){
					r++;
				}else{
					break;
				}
			}
			int total = l+r+1;
			ans = Math.max(total,ans);
		}
		return ans;
	}
}

/* 

we can atmost replace a single 0 with 1 find max consecutive 1's  [0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0]
6


 */