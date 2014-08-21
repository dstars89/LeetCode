package LeetCodeOJ;

/*Given an array of integers, every element appears three times except for one. 
 * Find that single one.
Note:
Your algorithm should have a linear runtime complexity. 
Could you implement it without using extra memory?*/



/*To solve this problem using only constant space, you have to rethink how the numbers are being represented in computers -- using bits.

If you sum the ith bit of all numbers and mod 3, it must be either 0 or 1 due to the constraint of this problem where each number must appear either three times or once. This will be the ith bit of that "single number".

A straightforward implementation is to use an array of size 32 to keep track of the total count of ith bit.

int singleNumber(int A[]) {
    int count[] = {0};
    int result = 0;
    for (int i = 0; i < 32; i++) {
        for (int j = 0; j < A.length; j++) {
            if ((A[j] >> i) & 1) {
                count[i]++;
            }
        }
        result |= ((count[i] % 3) << i);
    }
    return result;
}

We can improve this based on the previous solution using three bitmask variables:

ones as a bitmask to represent the ith bit had appeared once.
twos as a bitmask to represent the ith bit had appeared twice.
threes as a bitmask to represent the ith bit had appeared three times.
When the ith bit had appeared for the third time, clear the ith bit of both ones and twos to 0. The final answer will be the value of ones.*/

public class SingleNumberII {
	public int singleNumber(int[] A) {
		/* Rethinking "and" and "xor" operations from the view of bit manipulations, 
		 * "and" means (a+b) / 2. And "xor" means (a+b) % 2. 
		 * So "twos|= ones&A[i];" means marking the bits emerged 2, 3 or more times. 
		 * "ones= ones^A[i];" means marking the bits emerged 1 or 3 times.
		 *  "xthrees= ~(ones&twos);" means excluding the bits emerged 3 times.*/
		int ones = 0, twos = 0, threes = 0;
	    for (int i = 0; i <A.length; i++) {
	        twos |= ones & A[i];
	        ones ^= A[i];
	        threes = ones & twos;
	        ones &= ~threes;
	        twos &= ~threes;
	    }
	    return ones;

	}
}
