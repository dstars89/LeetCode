package LeetCodeOJ;

import java.util.ArrayList;
import java.util.List;

/*Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)*/

public class RestoreIPAddresses {

	public List<String> restoreIpAddresses(String s) {
		List<String> resList=new ArrayList<String>();
		if(s==null||s.length()<4)return resList; 
		restoreIpAddressesRescur(s, 0, 1, "", resList);
		return resList;
	}
	
	private void restoreIpAddressesRescur(String s,int start,int step,String res,List<String> resList){

		if(start>s.length())return;
		if(step==4){//end
			String  str = s.substring(start);
	        if(isValid(str))
	        {
	            resList.add(res+"."+str);
	        }
	        return;
		}
		for (int i = 1; i <4&&(i+start)<=s.length(); i++) {//ip 最大3
			String 	str=s.substring(start, start+i);
			if(isValid(str)){
				if(step==1)restoreIpAddressesRescur(s, start+i, step+1, str, resList);
				else restoreIpAddressesRescur(s, start+i, step+1,res+"."+str, resList);
			}
		}
	}
	
	/**
	 * 首先要在0-255之间，其次前面字符不能是0。
	 * @param str
	 * @return
	 */
	private boolean isValid(String str)
	{
		 if(str==null || str.length()>3||str.length()==0)
	        return false;
	    int num = Integer.parseInt(str);
	    if(str.charAt(0)=='0' && str.length()>1)
	        return false;
	    if(num>=0 && num<=255)
	        return true;
	    return false;
	}
}
