package LeetCodeOJ;

/*Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.*/

public class IntegertoRoman {
	
	
/*	有几条须注意掌握：
	基本数字Ⅰ、X 、C 中的任何一个，自身连用构成数目，或者放在大数的右边连用构成数目，
	都不能超过三个；放在大数的左边只能用一个。
	不能把基本数字V 、L 、D 中的任何一个作为小数放在大数的左边采用相减的方法构成数目；
	放在大数的右边采用相加的方式构成数目，只能使用一个。
	V 和X 左边的小数字只能用Ⅰ。
	L 和C 左边的小数字只能用X。
	D 和M 左边的小数字只能用C。*/
	
	/*
	 * If num is 4 times of x (x = 1000, 100, 10, 1), add x 5x
	 * If num is greater than x, add x
	 * If num is smaller than x (x = 1000, 100, 10, 1) but it is 9 times of x/10, add 10/x x
	 * */
	public String intToRoman(int num) {
		StringBuilder result = new StringBuilder();
		int base[] = { 1000, 500, 100, 50, 10, 5, 1, 0 };
		char baseC[] = { 'M', 'D', 'C', 'L', 'X', 'V', 'I' };
		int basen = 0;
		while (num > 0) {
			if (basen % 2 == 0 && num / base[basen] == 4) {//If num is 4 times of x (x = 1000, 100, 10, 1), add x 5x
				result.append(baseC[basen]);
				result.append(baseC[basen - 1]);
				num -= base[basen] * 4;
			} else if (num >= base[basen]) {//If num is greater than x, add x
				result.append(baseC[basen]);
				num -= base[basen];
			} else if (basen % 2 == 0 && num / base[basen + 2] == 9) {//If num is smaller than x (x = 1000, 100, 10, 1) but it is 9 times of x/10, add 10/x xi
				result.append(baseC[basen + 2]);
				result.append(baseC[basen]);
				num -= base[basen + 2] * 9;
			} else {
				basen++;
			}
		}
		return result.toString();
	}

}
