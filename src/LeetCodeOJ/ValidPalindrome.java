package LeetCodeOJ;

import java.util.ArrayList;

/*Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

 For example,
 "A man, a plan, a canal: Panama" is a palindrome.
 "race a car" is not a palindrome.

 Note:
 Have you consider that the string might be empty? This is a good question to ask during an interview.

 For the purpose of this problem, we define empty string as valid palindrome.*/

public class ValidPalindrome {

	public boolean isPalindrome(String s) {
		if (s == null || s.length() <= 1) {
			return true;
		}
		char[] lowercase = s.toLowerCase().toCharArray();
		int left = 0;
		int right = lowercase.length - 1;
		while (left < right) {
			if (!Character.isLetterOrDigit(lowercase[left])
					&& left <= lowercase.length) {
				left++;
				continue;
			}
			if (!Character.isLetterOrDigit(lowercase[right]) && right >= 0) {
				right--;
				continue;
			}
			if (lowercase[left] != lowercase[right])
				return false;
			left++;
			right--;

		}
		return true;
	/*	s=s.toLowerCase();
	    s=s.replaceAll("[^0-9a-zA-Z]", "");
	    char c[]=s.toCharArray();
	    int head=0,tail=s.length()-1;
	    while(head<=s.length()-1&&tail>=0){
	        if(c[head]!=c[tail]) return false;
	        head++;
	        tail--;
	    }
	    return true;*/

	}
}
