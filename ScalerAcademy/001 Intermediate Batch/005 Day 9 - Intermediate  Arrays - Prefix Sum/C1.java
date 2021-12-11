/* 

Prefix Array:

Q) Given N array elements and Q qeries on same array. For each query calculate sum of all elements in given range


arr[10]={-3,6,2,4,5,2,8,-9,3,1}

Q = 5

L-R		Sum
4-8		9
2-7		12
1-3		12
0-4		14
7-7		-9

Idea:

		  0,1,2,3,4,5,6,7 ,8,9
arr[10]={-3,6,2,4,5,2,8,-9,3,1}
pf[10] ={-3,3,5,9,14,16,24,15,18,19}

L-R				Sum
4-8				9
4,5,6,7,8 

pf[8] = 0,1,2,3,4,5,6,7,8	Sum of all array elements from [0-i]
pf[8] = pf[3]+sum[4-8]
		{0,1,2,3} + {4,5,6,7,8}

sum[4-8] = pf[8] - pf[3]

lly
sum[3-7] = pf[7] - pf[2]
sum[4-9] = pf[9] - pf[3]
sum[0-7] = pf[7]

Generalized:
sum[i-j] = pf[j] - pf[i-1]
if(i==0)
sum[0-j] = pf[j]

Psuedo Code for sum of elements in range L-R:

i=1;i<=Q;i++{
	Read L R;
	if(L==0)
		print(pf[R])
	else
		print(pf[R] - pf[L-1])
}
T.C = O(Q)

---------------------------------------	
Prefix Array:
pf[i] = Sum of all array elements from [0-i]

pf[0] = arr[0]
pf[1] = arr[0] + arr[1]
pf[2] = arr[0] + arr[1] + arr[2]

pf[i]= arr[0] + arr[1] + arr[2] ...  arr[i-1] + arr[i]
		{              pf[i-1]               }							pf[i-1] = arr[0] + arr[1] + arr[2] ...  arr[i-1]

pf[i] = pf[i-1]+arr[i]


Psuedo Code for prefix array:
pf[n] = arr[0]
i=1;i<n;i++{
	pf[i] = pf[i-1] + arr[i]
}

T.C = O(N)

Total T.C = O(Q+N)

S.C = O(N)			{Creating a prefix array of N elements}
 */
 
import java.lang.*;
import java.util.*;

public class C1 {
    public static void main(String[] args) {
        

		int[] A = {-3,6,2,4,5,2,8,-9,3,1};
		
		int[][] Q = { {4,2,1,0,7}, {8,7,3,4,7}};
		
		int[] PF = new int[A.length];
		PF[0] = A[0];
		for(int i =1; i< A.length; i++){
			PF[i] = PF[i-1] + A[i];
		}
		
		System.out.println("A: "+Arrays.toString(A));
		System.out.println("PF: "+Arrays.toString(PF));
		System.out.println("Sum of all elements in given range");
		
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

Output:

A: [-3, 6, 2, 4, 5, 2, 8, -9, 3, 1]
PF: [-3, 3, 5, 9, 14, 16, 24, 15, 18, 19]
Sum of all elements in given range
L: 4-R: 8  Sum :9
L: 2-R: 7  Sum :12
L: 1-R: 3  Sum :12
L: 0-R: 4  Sum :14
L: 7-R: 7  Sum :-9

 */
