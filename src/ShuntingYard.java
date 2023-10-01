import java.util.Stack;
import java.lang.Character;

class ShuntingYard {

    private static boolean letter(char c) {
        return Character.isLetter(c);
    }

    private static boolean digit(char c) {
        return Character.isDigit(c);
    }

    static int getPrecedence(char ch) {
        if (ch == '+' || ch == '-')
            return 1;
        else if (ch == '*' || ch == '/')
            return 2;
        else if (ch == '^')
            return 3;
        else
            return -1;
    }

    static boolean hasLeftAssociativity(char ch) {
        return ch == '+' || ch == '-' || ch == '/' || ch == '*';
    }

    static String infixToRpn(String expression) {
        Stack<Character> stack = new Stack<>();

        StringBuilder output = new StringBuilder();
        boolean lastWasDigitOrLetter = false;

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (digit(c) || letter(c)) {
                if (!lastWasDigitOrLetter) output.append(' ');
                output.append(c);
                lastWasDigitOrLetter = true;
            }
            else if (c == '(') {
                stack.push(c);
                lastWasDigitOrLetter = false;
            }
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(')
                    output.append(' ').append(stack.pop());
                stack.pop();
                lastWasDigitOrLetter = false;
            }
            else {
                while (!stack.isEmpty() && getPrecedence(c) <= getPrecedence(stack.peek()) && hasLeftAssociativity(c))
                    output.append(' ').append(stack.pop());
                stack.push(c);
                lastWasDigitOrLetter = false;
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek() == '(')
                throw new IllegalArgumentException("This expression is invalid");
            output.append(' ').append(stack.pop());
        }

        return output.toString().trim();
    }


    public static void main(String[] args) {
        String expression1 = "89+5-5+4*4/45+45454-5454545";//89+5-5+4*4/45+45454-5454545

        System.out.println(infixToRpn(expression1));
    }
}
