/* 

Q2) Max consecutive 1's (atmost swap a single 0)

Given a binarry array we can atmost swap a single 0 with 1 find max consecutive 1's we can get

Ex:

1)

1 1 0 1 1 0 1
	^
1 1 1 1 1 0 0	>5
-------
1 1 0 1 1 0 1
		  ^	
1 1 0 1 1 1 1	>4

Max=>5

1 1 0 1 0 1 0 1 1
    ^
1 1 1 1 0 1 0 1 0	>4
-------
1 1 0 1 0 1 0 1 1
        ^
1 1 0 1 1 1 0 1 0	>3
-------
1 1 0 1 0 1 0 1 1
			^
0 1 0 1 0 1 1 1 1	>4

Max=>4


********************************************

Pseudo code:

Iterate and get no of 1's
if(count1 == n){
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
		if(count1 > l+r){// I can spare extra 1
			ans = max(ans, l+r+1)
		}else{
			ans = max(ans, l+r)
		}
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
		
		System.out.println("\nwe can atmost swap a single 0 with 1 find max consecutive 1's  "+ Arrays.toString(A));
		System.out.println(getMaxConse1(A,n));
		
		int[] B = {1,1,0,1,0,1,0,1,1};
		System.out.println("\nwe can atmost swap a single 0 with 1 find max consecutive 1's  "+ Arrays.toString(B));
		System.out.println(getMaxConse1(B,B.length));
		
		
	
	}
	
	public static int getMaxConse1(int[] A, int n){
		int count1=0;
		for(int i=0;i<n;i++){
			if(A[i]==1){
				count1++;
			}
		}
		if(count1 == n){
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
			if(count1 > l+r){
				ans = Math.max(ans, l+r+1);
			}else{
				ans = Math.max(ans, l+r);
			}
		}
		return ans;
	}
}

/* 

we can atmost swap a single 0 with 1 find max consecutive 1's  [0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0]
6

we can atmost swap a single 0 with 1 find max consecutive 1's  [1, 1, 0, 1, 0, 1, 0, 1, 1]
4


 */