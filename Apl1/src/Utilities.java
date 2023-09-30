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

    public boolean isOperator(String currStr) {
        return currStr.equals("+") || currStr.equals("*") || currStr.equals("-") || currStr.equals("/");
    }

    public boolean isOperand(String currStr) {
        return !(isOperator(currStr) || currStr.equals("(") || currStr.equals(")"));
    }

    public int getPriority(String argOperator) {
        if(!isOperator(argOperator)) {
            return -1;
        }

        if(argOperator.equals("*") || argOperator.equals("/")) {
            return 2;
        }

        return 1;
    }
    
    public List<String> infixToPostfixConversion(List<String> infixTokens) {
        List<String> postfixExp = new ArrayList<>();
        Stack<String> stack = new Stack<>();

        for(int i = 0; i < infixTokens.size(); i++) {
            if(isOperand(infixTokens.get(i))) {
                postfixExp.add(infixTokens.get(i));
            }

            else if(isOperator(infixTokens.get(i))) {
                while(!stack.isEmpty() && getPriority(stack.peek()) >= getPriority(infixTokens.get(i))) {
                    postfixExp.add(stack.pop());
                }

                stack.push(infixTokens.get(i));
            }

            else if(infixTokens.get(i).equals("(")) {
                stack.push(infixTokens.get(i));
            }

            else if(infixTokens.get(i).equals(")")) {
                String removed = stack.pop();
                while(!removed.equals("(")) {
                    postfixExp.add(removed);
                }
            }
        }

        while(!stack.isEmpty()) {
            postfixExp.add(stack.pop());
        }

        return postfixExp;
    }
}