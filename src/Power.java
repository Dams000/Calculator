public class Power implements Operator {

    @Override
    public String symbol() {
        return "^";
    }

    @Override
    public double cumulativeValue(double a, double b) {
        return Math.pow(a, b);
    }
}
