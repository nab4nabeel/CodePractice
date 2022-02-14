/* 

Closest Min Max (Sub Array)

Q) Given in an array find the length of smallest subarray which contains both Min and Max of array.

(Sub Array)
Single element is sub array
Whole array is a sub array
subarray[s e]; len = e-s+1

T.C
Arrays.sort() => O(NlogN)
max(a,b) => O(1)
min(a,b) => O(1)


Ex1:

0,1,2,3,4,5,6,7,8,9
1,2,3,1,3,4,6,4,6,3

Min: 1
Max: 6

3,4,5,6,7,8
1,3,4,6,4,6
Len=6

3,4,5,6
1,3,4,6
Len=4

Ex2:

0,1,2,3,4,5,6,7,8,9,10
2,2,6,4,5,1,5,2,6,4,1

Min: 1
Max: 6

2,3,4,5
6,4,5,1
Len=4

8,9,10
6,4,1
Len=3


Ex3:

0,1,2,3,4
8,8,8,8,8

Min: 8
Max: 8

Len=1


Observation:

1) Final Ans subarray it should only contain one min and one max
2) min and max should be in extremes of subarray


Idea: Iterate if we get first min get the next closest max and vise versa

Psuedo Code 

ans=N
iterate and get min_val
iterate and get max_val
(i=0;i<N;i++){
	if(ar[i]==min_val){
		(j=i;j<N;j++){
			if(ar[j]==max_val){
				ans=min(ans,j-i+1)
				break
			}
		}
	}else if(ar[i]==max_val){
		(j=i;j<N;j++){
			if(ar[j]==min_val){
				ans=min(ans,j-i+1)
				break
			}
		}
	}
}


T.C = O(N2)
S.C = O(1)

Optimization: 

From the above pseudocode we can understand that finding the next min_val/max_val is taking time and we need to keep account of minimum length

We can utilize this observation to carry forward the length of min_index and max_index by iterating from right to left


min_val = 1
max_val = 6

index	0,1,2,3,4,5,6,7,8,9,10,11,12
values	1,6,4,6,5,1,5,2,6,4, 4, 2, 1
minI	0,5,5,5,5,5,12,12,12,12,12,12,12	-1
maxI	2,1,3,3,8,8,8,8,8,0, 0, 0,-1	-1
len		2,5,0,3,0,4,0,0,5,0, 0, 0, 0
ans		2,3,3,3,4,4,5,5,5,12,12,12,12	12

Pseudocode:

1) iterate and get max_val
2) iterate and get min_val
3)
if(max_val == min_val){
	return 1;
}
ans = N minIndex=-1 maxIndex=-1
(i=N-1;i>=0;i--){
		if(ar[i]==min_val){
			minIndex = i
			if(maxIndex != -1){//There is a max_index to right
				//subarray[min_index max_index]
				ans = min(ans, maxIndex- minIndex +1)
			}
		}
		else if(ar[i]==max_val){
			maxIndex = i
			if(minIndex != -1){//There is a maxIndex to right
				//subarray[max_index min_index]
				ans = min(ans, minIndex - maxIndex +1)
			}
		}
		return ans;
}


T.C = O(N)
S.C = O(1)


 */
	 
	import java.lang.*;
	import java.util.*;

	public class C3 {
		public static void main(String[] args) {
			

			int[] A = {1,6,4,6,5,1,5,2,6,4,4,2,1};	
			int N = A.length;
		
			int min_val = A[0];
			int max_val = A[0];
			for(int i=1;i<N;i++){
				if(A[i]>max_val){
					max_val = A[i];
				}else if(A[i]<min_val){
					min_val = A[i];
				}
			}
		
			System.out.println("A: " + Arrays.toString(A));
			System.out.println("max_val: " + max_val);
			System.out.println("min_val: " + min_val);
			System.out.println("Closest Min Max Sub Array length: " + bruteForce(A,N,min_val,max_val));
			System.out.println("Closest Min Max Sub Array length: " + carryForwardRightLeft(A,N,min_val,max_val));
					
		}   

		private static int bruteForce(int[] A, int N,int min_val,int max_val){	
			int ans = N;
			for(int i=0;i<N;i++){
				if(A[i]==min_val){
					for(int j=i;j<N;j++){
						if(A[j]==max_val){
							ans = Math.min(ans, j-i+1);
							break;
						}
					}
				}else if(A[i]==max_val){
					for(int j=i;j<N;j++){
						if(A[j]==min_val){
							ans = Math.min(ans, j-i+1);
							break;
						}
					}
				}
			}
			return ans;	
		}
		
		
		
		private static int carryForwardRightLeft(int[] A, int N,int min_val,int max_val){
			if(min_val==max_val){
				return 1;
			}
			int ans = N, min_index=-1, max_index=-1;
			for(int i=N-1;i>=0;i--){
					if(A[i]==min_val){
						min_index = i;
						if(max_index != -1){
							ans = Math.min(ans, max_index - min_index +1);
						}
					}else if(A[i]==max_val){
						max_index = i;
						if(min_index != -1){
							ans = Math.min(ans, min_index - max_index +1);
						}
					}

			}
			
			return ans;
		}
		
	}


/* 

Output:

A: [1, 6, 4, 6, 5, 1, 5, 2, 6, 4, 4, 2, 1]
max_val: 6
min_val: 1
Closest Min Max Sub Array length: 2
Closest Min Max Sub Array length: 2

 */
