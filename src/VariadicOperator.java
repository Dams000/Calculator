public class VariadicOperator implements Formula {

    private final Operator operator;
    private final Formula leftFormula, rightFormula;

    public VariadicOperator(Operator operator, Formula leftFormula, Formula rightFormula) {
        this.operator = operator;
        this.leftFormula = leftFormula;
        this.rightFormula = rightFormula;
    }

    @Override
    public String asString() {
        return "(" + leftFormula.asString() +
                operator.symbol() +
                rightFormula.asString() +
                ")";
    }

    @Override
    public double asValue() {
        return operator.cumulativeValue(leftFormula.asValue(), rightFormula.asValue());
    }
}
