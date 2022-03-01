/* 

Range:

int [-2*10^9, 2*10^9]
long [-8*10^18, 8*10^18]

-----------------------------------------------------

% > Modulo/Remainder

10%2=2
13%5=3

Divident = Divisor * Quotient + Remainder

Remainder 	= Divident - (Divisor * Quotient)
150%11 		= 150 - (11*13)

Divisor * Quotient => Greatest Multiple of divisor <= Divident
-----------------------------------------------------
Positive Divident

150%11 	= 7	= 150 - 143(11*13)
100%7 	= 2 = 100 - 98 (7*14)

-----------------------------------------------------
Negative Divident

-40%7	= -40 - (Greatest Multiple of 7 <= -40)
-40%7	= -40 - (-35 <= -40) > XWrong as -35>-40
-40%7	= -40 - (-42 <= -40)
-40%7	= -40 - (-42)
-40%7	= 2

-60%9	= -60 - (Greatest Multiple of 9 <= -60)
-60%9	= -60 - (-63 <= -60)
-60%9	= -60 - (-63)
-60%9	= 3

-----------------------------------------------------

In Phython:

-40%7	= 2
-60%9	= 3
-30%4	= 2


In C/C++/Java/JS:

-40%7	= -5
-60%9	= -6
-30%4	= -2

Thus to get the right answer

-40%7	= -5+7	=2
-60%9	= -6+9	=3
-30%4	= -2+4	=2

a%b: if(a<0)=> a%b+b


-----------------------------------------------------


Why Modulus?

35%10=5

{Output Range}
x%10 = [0, 9]	{Output Range}

if x %M = [-Infinite, Infinite]
{Output Range} = [0, M-1]

****************************************************
Advantage of % : limit our data to a particular range
****************************************************

Usages:
1>Consistent Hashing
2>Hashmap/Hastable/Dictionary/Map
3>Encryption


-----------------------------------------------------

Modular arithmetic

(a+b) % M = (a%M + b%M) % M

(a*b) % M = (a%M * b%M) % M


 */
 
 /* 
 
Q)Given power(a,N,p) a N p calculate (a^N)%p 
 
EX:
a=2,n=5,p=7 => (2^5)%7 => (32)%7 = 4 
a=3,n=4,p=6 => (3^4)%6 => (81)%6 = 3 


int power(a,N,p){

	int ans=1;
	(i=1;i<=n;i++){
		ans = ans*a;
	} 
	return ans%p
}

if a=10, n=40 a^n=10^40

10^40 cant be stored on int and long variable (over flow problem)

long power(a,N,p){

	long ans=1;
	(i=1;i<=n;i++){
		ans = (ans*a)%p;	//p=>[0,10^9]
		ans = (ans%p * a%p)%p;
	//range:  ((p-1) * (p-1))%p
	//range:  ((p-1)^2)%p	//(p-1)^2=>10^8 long can store this value
	//range:  ((p-1)^2)%p	
	//range:  (p-1)	//result will range below 10^8-1
	
	
	} 
	return ans
}

T.C=O(N)
S.C=O(1)

Over flow:
int a=10^5 b=10^6
int c

int c=a*b		//overflow
long c=a*b		//overflow
long c=long(a*b)//overflow
long c=(long)a*b//Correct Ans



 */