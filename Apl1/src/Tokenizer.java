import java.util.ArrayList;
import java.util.List;
import java.util.InputMismatchException;

public class Tokenizer {
    Utilities util = new Utilities();
    private char[] input;
    private int index;

    public Tokenizer(String str) {
        input = str.toCharArray();
        index = 0;
    }

    private char getNextChar() {
        if(index >= input.length) { return '\0'; }
        return input[index++];
    }

    public List<String> tokenize() {
        List<String> tokens = new ArrayList<>();
        StringBuilder buffer = new StringBuilder();
        char currChar = getNextChar();

        boolean isTokenizing = true;
        while(isTokenizing) {

            while(Character.isWhitespace(currChar)) {
                currChar = getNextChar();
            }

            if(Character.isDigit(currChar)){
                buffer.setLength(0);

                while(Character.isDigit(currChar)) {
                    buffer.append(currChar);
                    currChar = getNextChar();
                    if(currChar == '.') {
                        buffer.append(currChar);
                        currChar = getNextChar();
                    }
                }

                if(util.countChars('.', buffer.toString()) > 1) {
                    throw new InputMismatchException("Entrada de expressão inválida.");
                }

                tokens.add(buffer.toString());
            }

            else if(currChar == '+') {
                tokens.add("+");
                currChar = getNextChar();
            }

            else if(currChar == '*') {
                tokens.add("*");
                currChar = getNextChar();
            }

            else if(currChar == '/') {
                tokens.add("/");
                currChar = getNextChar();
            }

            else if(currChar == '-') {
                tokens.add("-");
                currChar = getNextChar();
            }

            else if(currChar == '(') {
                tokens.add("(");
                currChar = getNextChar();
            }

            else if(currChar == ')') {
                tokens.add(")");
                currChar = getNextChar();
            }

            else if(currChar == '\0') {
                isTokenizing = false;
            }

            else {
                isTokenizing = false;
                throw new InputMismatchException("Entrada de expressão inválida.");
            }
        }

        return tokens;
    }
}
