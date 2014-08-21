package LeetCodeOJ;

/*You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?*/

public class ClimbingStairs {

	public int climbStairs(int n) {
		if(n==0|n==1|n==2)return n;
		int stepOne=1,stepTwo=1;
	    int result=0;
	    for(int i=2;i<=n;i++){
	        result=stepOne+stepTwo;
	        stepTwo=stepOne;
	        stepOne=result;
	    }
	    return result;
	}
}
