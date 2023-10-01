import java.util.Stack;

public class Calculator {

    private final FormulaFactory factory;

    public Calculator(FormulaFactory factory) {
        this.factory = factory;
    }

    public Formula analyze(String... tokens) {
        Stack<Formula> stack = new Stack<>();
        analyzeToken(stack, tokens);
        return stack.pop();
    }

    private void analyzeToken(Stack<Formula> stack, String[] tokens) {
        for (String token : tokens)
            switch (token) {
                case "+" -> analyzeSum(stack);
                case "-" -> analyzeSubtraction(stack);
                case "*" -> analyzeProduct(stack);
                case "/" -> analyzeDivision(stack);
                case "^" -> analyzePower(stack);
                default -> analyzeConstant(stack, token);
            }
    }

    private void analyzeConstant(Stack<Formula> stack, String token) {
        stack.push(factory.createConstant(Double.parseDouble(token)));
    }

    private void analyzeSum(Stack<Formula> stack) {
        stack.push(factory.createSum(stack.pop(), stack.pop()));
    }

    private void analyzeSubtraction(Stack<Formula> stack) {
        Formula a = stack.pop();
        Formula b = stack.pop();
        stack.push(factory.createSubtraction(b, a));
    }

    private void analyzeProduct(Stack<Formula> stack) {
        stack.push(factory.createProduct(stack.pop(), stack.pop()));
    }

    private void analyzeDivision(Stack<Formula> stack) {
        Formula a = stack.pop();
        Formula b = stack.pop();
        stack.push(factory.createDivision(b, a));
    }

    private void analyzePower(Stack<Formula> stack) {
        Formula a = stack.pop();
        Formula b = stack.pop();
        stack.push(factory.createPower(b, a));
    }
}
