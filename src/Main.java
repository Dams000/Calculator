import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String rpn;
        System.out.println("input: (q to quit)");

        while (!(rpn = sc.nextLine().replace(" ", "")).equals("q")) {
            String[] tokens;
            try {
                tokens = ShuntingYard.infixToRpn(rpn).split(" ");
            } catch (Exception e) {
                System.out.println("Invalid expression");
                System.out.println("\ninput: (q to quit)");
                continue;
            }

            Formula formula = new Calculator(new FormulaFactory()).analyze(tokens);

            System.out.println(formula.asValue());

            System.out.println("\ninput: (q to quit)");
        }
    }
}