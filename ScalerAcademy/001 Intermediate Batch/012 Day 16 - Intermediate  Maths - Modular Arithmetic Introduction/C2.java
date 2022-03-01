/* 

Q) Given N array elements calculate sum of array elements

Constrains:
1	<=	N		<=10^5
1	<=	ar[i]	<=10^6


If we observe the constains sum value will range as below

1	<=	sum		<=10^11

if we use int to store the value of sum in every iteration it will overflow for the max value

Hence always observe the constrains


 */
 
long getArraySum(int[] A){
	long sum = 0;
	for(int i=0;i<A.length;i++){
		sum+= A[i];
	}
	return sum;
}