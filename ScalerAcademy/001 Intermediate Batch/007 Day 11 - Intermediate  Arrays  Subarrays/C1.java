/* 

Sub Array 

ar[7]= 0 1 2 3 4 5 6 7

Subarray starting at 0

[s e]

[0 0]	[0 0]
[0 1]
[0 2]
[0 3]
[0 4]
[0 5]
[0 6]	[0 N-1]

Total: 7 Sub arrays {Total Sub arrays are from [0 N-1] => N-1-0+1 => N}

-----------------------------------------------------
Subarray starting at 1

[1 1]	[1 1]
[1 2]
[1 3]
[1 4]
[1 5]
[1 6]	[1 N-1]

Total: 6 Sub arrays {Total Sub arrays are from [1 N-1] => N-1-1+1 => N-1}

-----------------------------------------------------
Subarray starting at 2

[2 2]	[2 2]
[2 3]
[2 4]
[2 5]
[2 6]	[2 N-1]

Total: 5 Sub arrays {Total Sub arrays are from [2 N-1] => N-1-2+1 => N-2}

-----------------------------------------------------
Subarray starting at N-1

[N-1 N-1]

Total: 1 Sub arrays {Total Sub arrays are from [N-1 N-1] => N-1-N-1+1 => 1}


$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

Generalized:

For N array elements total sub arrays to be formed are the sum of sub arrays starting from index 0 to index N-1

Thus from above 
Total => N + N-1 + N-2 + ---- + 1 = (N(N+1))/2

$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$


Given N array elements Print all subarrays:

ar[3]={2,8,9}

Index	Output
[0 0]	2
[0 1]	2 8
[0 2]	2 8 9
[1 1]	8
[1 2]	8 9
[2 2]	9


Psuedo Code:


(int i=0;i<N;i++)	//starting index 
	(int j=i;j<N;j++)	//loop till from index N-1
		(int k=i;k<=j;k++){// k to hold [i j]sub array
			print(ar[k])
		}
		print("\n")
		
		
		
T.C:O(N^3)
S.C:O(1)

Cant be optimized as it needs to be print all the values

 */
 
import java.io.*;
import java.util.*;

public class C1{
	
	public static void main(String[] args){
		
		int[] ar = {2,8,9};
		int N = ar.length;
		
		system.out.println("All the subarrays of given array"+ ar.toString());
		
		for(int i=0;i<N;i++){//starting index
			for	(int j=i;j<N;j++){//loop till from index N-1
				for	(int k=i;k<=j;k++){// k to print [i j]sub array
						system.out.println(ar[k]"\t");
				}
				system.out.println("\n");
			}
		}	 
		
	}
	
}
 /* 

Output:

All the subarrays of given array: [2, 8, 9]
2	
2	8	
2	8	9	
8	
8	9	
9	


 */
 