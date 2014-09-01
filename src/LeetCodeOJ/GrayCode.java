package LeetCodeOJ;

import java.util.ArrayList;
import java.util.List;

/*The gray code is a binary numeral system where two successive values differ in only one bit.

 Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

 For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

 00 - 0
 01 - 1
 11 - 3
 10 - 2
 Note:
 For a given n, a gray code sequence is not uniquely defined.

 For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.

 For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.*/


//二进制转格雷码：gray = (binary) xor (binary >> 1)

public class GrayCode {
	public List<Integer> grayCode(int n) {
		List<Integer> res=new ArrayList<Integer>();
		if(n==0){
			res.add(0);
			return res;
		}
		int num=1<<n;
		for (int i = 0; i < num; i++) {
			res.add(i^(i>>1));
		}
		return res;

	}
}
