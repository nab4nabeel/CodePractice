/* 

Below we will define an n-interesting polygon. Your task is to find the area of a polygon for a given n.

A 1-interesting polygon is just a square with a side of length 1. An n-interesting polygon is obtained by taking the n - 1-interesting polygon and appending 1-interesting polygons to its rim, side by side. You can see the 1-, 2-, 3- and 4-interesting polygons in the picture below.



Example

For n = 2, the output should be
solution(n) = 5;
For n = 3, the output should be
solution(n) = 13.
Input/Output

[execution time limit] 3 seconds (java)

[input] integer n

Guaranteed constraints:
1 ≤ n < 104.

[output] integer

The area of the n-interesting polygon.



 */
 
 
 
 /* My Solution Start */
 
int solution(int n) {
    int ans = 1 ;
    for(int i=2;i<=n;i++){
        ans += (i * 4) - 4;
    }
    return ans;
}

 
 /* My Solution End */
 
 
 
 
 
 
 
 
 
 
 
 
 


int solution(int n) {
  return (n*n)+( (n-1)*(n-1) ); 
}


int solution(int n) {
    if(n == 1) return 1;
    return 4*(n-1) + solution(n-1);
}


int solution(int n) {
    return (int) Math.pow(n, 2) + (int) Math.pow(n-1, 2);
}

