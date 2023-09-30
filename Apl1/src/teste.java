import java.util.List;

public class teste {
    public static void main(String[] args) {
        Utilities util = new Utilities();
        Tokenizer tkn = new Tokenizer("1 + 2 * 3");
        List<String> teste = tkn.tokenize();
        for(String element : teste) {
            System.out.println(element + ",");
        }

        System.out.println();

        List<String> post = util.infixToPostfixConversion(teste);
        for(String a : post) {
            System.out.println(a + ",");
        }
    }
}
