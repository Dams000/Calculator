public class Constant implements Formula {

    private final double value;

    public Constant(double value) {
        this.value = value;
    }

    @Override
    public String asString() {
        return String.valueOf(value);
    }

    @Override
    public double asValue() {
        return value;
    }
}
