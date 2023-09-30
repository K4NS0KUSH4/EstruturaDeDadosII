import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Utilities {

    public int countChars(char argChar, String argString) {
        int count = 0;

        for(int i = 0; i < argString.length(); i++) {
            if(argString.charAt(i) == argChar) {
                count++;
            }
        }

        return count;
    }

    public static boolean isOperator(String currStr) {
        return currStr.equals("+") || currStr.equals("*") || currStr.equals("-") || currStr.equals("/");
    }

    public static boolean isOperand(String currStr) {
        return !(isOperator(currStr) || currStr.equals("(") || currStr.equals(")"));
    }

    public static int getPriority(String argOperator) {
        if(argOperator.equals("*") || argOperator.equals("/")) {
            return 2;
        }

        return 1;
    }
    
    public static List<String> infixToPostfixConversion(List<String> infixTokens) {
        List<String> postfixExp = new ArrayList<>();
        Stack<String> stack = new Stack<>();

        for(int i = 0; i < infixTokens.size(); i++) {
            if(isOperand(infixTokens.get(i))) {
                postfixExp.add(infixTokens.get(i));
            }

            if(isOperator(infixTokens.get(i))) {
                while(!(stack.isEmpty()) && isOperator(stack.peek())) {
                    if(getPriority(stack.peek()) >= getPriority(infixTokens.get(i))) {
                        postfixExp.add(stack.pop());
                    }
                }

                stack.push(infixTokens.get(i));
            }

            if(infixTokens.get(i).equals("(")) {
                stack.push(infixTokens.get(i));
            }

            if(infixTokens.get(i).equals(")")) {
                while(!(stack.isEmpty())) {
                    String removed = stack.pop();
                    if(removed.equals("(")) {
                        break;
                    } else {
                        postfixExp.add(removed);
                    }
                }
            }
        }

        while(!(stack.isEmpty())) {
            postfixExp.add(stack.pop());
        }

        return postfixExp;
    }

}