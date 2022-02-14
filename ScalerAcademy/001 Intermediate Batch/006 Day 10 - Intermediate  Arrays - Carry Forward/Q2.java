/* 

Q2. Closest MinMax


Problem Description

Given an array A. Find the size of the smallest subarray such that it contains atleast one occurrence of the maximum value of the array

and atleast one occurrence of the minimum value of the array.



Problem Constraints

1 <= |A| <= 2000



Input Format

First and only argument is vector A



Output Format

Return the length of the smallest subarray which has atleast one occurrence of minimum and maximum element of the array



Example Input

Input 1:

A = [1, 3]
Input 2:

A = [2]


Example Output

Output 1:

 2
Output 2:

 1


Example Explanation

Explanation 1:

 Only choice is to take both elements.
Explanation 2:

 Take the whole array.




 */
 
 
 public class Solution {
    public int solve(int[] A) {
        int N = A.length;
        if(N==1){
            return 1;
        }
        if(N==2){
            return 2;
        }
        
        int ans = N;
        int max_val = A[0];
        int min_val = A[0];
        for(int i=1; i<N; i++){
            if(A[i]>max_val){
                max_val=A[i];
            }else if(A[i]<min_val){
                min_val=A[i];
            }
        }
        
        if(max_val==min_val){
            return 1;
        }
        
        int max_index=-1, min_index=-1;
        for(int i=N-1; i>=0;i--){
            if(A[i]==min_val){
                min_index = i;
                if(max_index !=-1){
                    //Subarray[min_index max_index]
                    ans=Math.min(ans,max_index-min_index +1);
                }
            }else if(A[i]==max_val){
                max_index = i;
                if(min_index !=-1){
                    //Subarray[max_index min_index]
                    ans=Math.min(ans,min_index-max_index +1);
                }
            }
        }
        return ans;
    }
}



/* 

Hint 1
One simple thing can be to generate all possible subarray and then compute the ans, but can we do better?
If we know the last occurence of min and max element in a particular subarray under consideration, can we do something?

Solution Approach
This problem can be solved in a simple O(N) complexity.
We can implement sliding window kind of algorithm using two pointers. We can slide over the array and keep in track for every last occurence of the minimim and maximum element of the array.
In order to find the start point we can simply remember the last occurrences of a minimum and a maximum value, respectively. And for each min max pair we check the length of the subarray that encloses them and then update out overall based on that.


 */
 
 
 public class Solution {
    public int solve(int[] A) {
        
        int min_Index = -1, max_Index = -1;
        int min_ele = Integer.MAX_VALUE, max_ele = Integer.MIN_VALUE;
        
        int ans = Integer.MAX_VALUE;
        for(int x:A)
        {
            min_ele = Math.min(min_ele, x);
            max_ele = Math.max(max_ele, x);
        }
        
        for(int i=0 ; i<A.length ; i++)
        {
            if(A[i] == min_ele) min_Index = Math.max(min_Index, i);
            if(A[i] == max_ele) max_Index = Math.max(max_Index, i);
            
            if(min_Index != -1 && max_Index != -1)
            {
                int len = Math.abs(max_Index - min_Index) + 1;
                ans = Math.min(ans, len);
            }
                
        }
        
        return ans;
    }
}