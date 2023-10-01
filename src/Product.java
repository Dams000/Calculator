public class Product implements Operator {

    @Override
    public String symbol() {
        return "*";
    }

    @Override
    public double cumulativeValue(double a, double b) {
        return a * b;
    }
}
