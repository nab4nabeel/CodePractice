/* 

Carry Forward:  Count Pair of "ag"

Q) Given in a string, calculate no of pairs i,j such that i<j && s[i]='a' && s[j]='g' 

Ex1:

0,1,2,3,4,5,6,7
b,a,a,g,d,c,a,g

Pairs: 
<1,3>, <1,7>
<2,3>, <2,7>
<6,7>

Idea: Iterate when we find 'a' in string then count number of 'g' to the right

Psuedo Code 

count c=0
i=0;i<N;i++{
	if(s[i]=='a'){
		j=i+1;j<=N;j++{
			if(s[j]=='g'){
				c++
			}
		}
	}
}
return c;

T.C = O(N2)
S.C = O(1)

---------------------------------------	

Carry Forward:

Idea 1: Iterate from right to left when we find 'g' increase counter then when we find 'a' upadate answer with 'g' count

Ex1:

Index	0,1,2,3,4,5,6,7
Value	b,a,a,g,d,c,a,g
GCount	2,2,2,2,1,1,1,1
Ans		0,5,3,1,1,1,1,0

Ex2:

Index	0,1,2,3,4,5,6,7,8
Value	a,d,g,a,g,a,g,f,g
GCount	4,4,4,3,3,2,2,1,1
Ans		9,5,5,5,2,2,0,0,0

Psuedo Code 

count c=0, ans=0
i=N-1;i>=0;i--{
	if(s[i]=='g'){
		c++
	}else if(s[i]=='a')
		ans+=c
	}
}
return ans;

T.C = O(N)
S.C = O(1)


Idea 2: Iterate from left to right when we find 'g' get the number of 'a' to the left update the answer 

Ex1:

Index	0,1,2,3,4,5,6,7
Value	b,a,a,g,d,c,a,g
ACount	0,1,2,2,2,2,3,3
Ans		0,0,0,2,2,2,2,5

Ex2:

Index	0,1,2,3,4,5,6,7,8
Value	a,d,g,a,g,a,g,f,g
GCount	1,1,1,2,2,3,3,3,3
Ans		0,0,1,1,3,3,6,6,9

Psuedo Code 

count c=0, ans=0
(i=0;i<N;i++){
	if(s[i]=='a'){
		c++
	}else if(s[i]=='g')
		ans+=c
	}
}
return ans;

T.C = O(N)
S.C = O(1)


 */
 
import java.lang.*;
import java.util.*;

public class C1 {
    public static void main(String[] args) {
        

		char[] S = {'a','d','g','a','g','a','g','f','g'};
		
		int N = S.length;
		
		System.out.println("S: " + Arrays.toString(S));
		System.out.println("Number of Pairs using brute Force method: " + bruteForce(S,N));
		System.out.println("Number of Pairs using Carry Forward right to left: " + carryForwardRightLeft(S,N));
		System.out.println("Number of Pairs using Carry Forward left to right: " + carryForwardLeftRight(S,N));
				
	}   
	
	private static int bruteForce(char[] S, int N){
		int c=0;
		for(int i=0;i<N;i++){
			if(S[i]=='a'){
				for(int j=i+1;j<N;j++){
					if(S[j]=='g'){
						c++;
					}
				}
			}
		}
		return c;
	}	
	
	
	private static int carryForwardRightLeft(char[] S, int N){
		int c=0, ans=0;
		for(int i=N-1;i>=0;i--){
			if(S[i]=='g'){
				c++;
			}else if(S[i]=='a'){
				ans+=c;
			}
		}
		return ans;
	}
	
	private static int carryForwardLeftRight(char[] S, int N){
		int c=0, ans=0;
		for(int i=0;i<N;i++){
			if(S[i]=='a'){
				c++;
			}else if(S[i]=='g'){
				ans+=c;
			}
		}
		return ans;
	}

}

/* 

Output:

S: [a, d, g, a, g, a, g, f, g]
Number of Pairs using brute Force method: 9
Number of Pairs using Carry Forward right to left: 9
Number of Pairs using Carry Forward left to right: 9


 */
