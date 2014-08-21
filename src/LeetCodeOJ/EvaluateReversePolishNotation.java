package LeetCodeOJ;

import java.util.Stack;

/*Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6*/
public class EvaluateReversePolishNotation {
	public int evalRPN(String[] tokens) {
		Stack<String> tokenStack = new Stack<String>();
		for (int i = 0; i < tokens.length; i++) {
			String token = tokens[i];
			if (!token.equals("+") && !token.equals("-") && !token.equals("*")
					&& !token.equals("/")) {
				tokenStack.push(token);
			} else {
				tokenStack.push(Count(tokenStack.pop(),tokenStack.pop(),token));
			}
		}
		return Integer.parseInt(tokenStack.pop());

	}

	public String Count(String a, String b, String c) {
		int result=0;
		switch (c) {
		case "+":
			result= Integer.parseInt(a)+Integer.parseInt(b);
			break;
		case "-":
			result= Integer.parseInt(b)-Integer.parseInt(a);
			break;
		case "*":
			result= Integer.parseInt(a)*Integer.parseInt(b);
			break;
		case "/":
			result= Integer.parseInt(b)/Integer.parseInt(a);
			break;
		default:
			break;
		}
		return String.valueOf(result);
	}
}
