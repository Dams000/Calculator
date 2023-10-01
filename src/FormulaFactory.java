public class FormulaFactory {

    public Formula createConstant(double value) {
        return new Constant(value);
    }

    public Formula createSum(Formula leftFormula, Formula rightFormula) {
        return new VariadicOperator(new Sum(), leftFormula, rightFormula);
    }

    public Formula createSubtraction(Formula leftFormula, Formula rightFormula) {
        return new VariadicOperator(new Subtraction(), leftFormula, rightFormula);
    }

    public Formula createProduct(Formula leftFormula, Formula rightFormula) {
        return new VariadicOperator(new Product(), leftFormula, rightFormula);
    }

    public Formula createDivision(Formula leftFormula, Formula rightFormula) {
        return new VariadicOperator(new Division(), leftFormula, rightFormula);
    }

    public Formula createPower(Formula leftFormula, Formula rightFormula) {
        return new VariadicOperator(new Power(), leftFormula, rightFormula);
    }
}
