import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s =new Scanner(System.in);
        int totalCount = Integer.parseInt(s.nextLine());
        for(int i=0;i < totalCount ; i++)
            {

                int length =Integer.parseInt(s.nextLine());     
                int[] elements = getIntArray(s.nextLine());
                int max_so_far = 0;
                int max_ending_here = 0;
                int max_non_contiguos = 0;
                for(int j=0;j < elements.length ; j++)
                    {
                     
                    max_ending_here = max_ending_here + elements[j];
                    if(max_ending_here < 0)
                        max_ending_here = 0;
                    if( max_so_far < max_ending_here)
                        max_so_far = max_ending_here;  
                    
                    if(elements[j] >= 0)
                        max_non_contiguos += elements[j];
                }
            max_so_far = checkForAllNegative(elements,max_so_far);
            max_non_contiguos = checkForAllNegative(elements,max_non_contiguos);
            System.out.println(max_so_far + " " + max_non_contiguos);
        }
        s.close();
      
    }
    
    private static int[] getIntArray(String s)
        {
       
        String[] seprated = s.split(" ");
        int[] intArray = new int[seprated.length];
        for(int i=0;i < seprated.length; i++)
            {
            intArray[i] = Integer.valueOf(seprated[i]);
        }
        return intArray;
    }
    
    private static int checkForAllNegative(int[] elements,int max_so_far)
        {
        int cur = elements[0];
        for(int i=0; i < elements.length; i++)
            {
            if(elements[i] < 0  )
                {
                if( elements[i] > cur )
                cur = elements[i];
            }
            else
                {
                return max_so_far;
            }
                
        }
        return cur;
    }
}
/*
The Maximum
Subarray
Problem Statement
Given an array of elements, find the maximum possible sum of a
1. Contiguous subarray
2. Non-contiguous (not necessarily contiguous) subarray.
Empty subarrays/subsequences should not be considered.
This Youtube video by Ben Wright might be useful to understand the Kadane algorithm for the maximum
subarray in a 1-D sequence.
Input Format
First line of the input has an integer . cases follow.
Each test case begins with an integer . In the next line, integers follow representing the elements of
array .
Constraints:
The subarray and subsequences you consider should have at least one element.
Output Format
Two, space separated, integers denoting the maximum contiguous and non-contiguous subarray. At least
one integer should be selected and put into the subarrays (this may be required in cases where all elements
are negative).
Sample Input
2
4
A = {a1
,a2
,…,aN} N
T T
N N
A
1 = T = 10
1 = N = 10
5
-10 = =
4 ai 10
4
1 2 3 4
6
2 -1 2 3 4 -5
Sample Output
10 10
10 11
Explanation
In the first case:
The max sum for both contiguous and non-contiguous elements is the sum of ALL the elements (as they are
all positive).
In the second case:
[2 -1 2 3 4] --> This forms the contiguous sub-array with the maximum sum.
For the max sum of a not-necessarily-contiguous group of elements, simply add all the positive elements.
*/