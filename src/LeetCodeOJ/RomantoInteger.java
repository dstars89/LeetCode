package LeetCodeOJ;

import java.util.HashMap;

/*Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.*/

public class RomantoInteger {

	 public int romanToInt(String s) {
		 int length = s.length();  
	        if(length <1) return 0;  
	        HashMap<Character, Integer> m=new HashMap<Character, Integer>();
	        m.put('I', 1);
	        m.put('V', 5);
	        m.put('X', 10);
	        m.put('L', 50);
	        m.put('C', 100);
	        m.put('D', 500);
	        m.put('M', 1000);
	        int i = length-1;  
	        int sum = m.get(s.charAt(i--));  
	        while(i>=0)  
	            if(m.get(s.charAt(i+1)) >m.get(s.charAt(i)))  
	                sum -= m.get(s.charAt(i--));  
	            else  
	                sum += m.get(s.charAt(i--));  
	        return sum;  
	    }
	
}
