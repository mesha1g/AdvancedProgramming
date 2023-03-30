package JavaOrgExample.One.Two.OOP;

public class MilkDecorator extends Beverage {
    private Beverage beverage;

    public MilkDecorator(Beverage beverage) {
        super(" s mlijekom");
        this.beverage = beverage;
    }

    @Override
    protected double cost() {
        return beverage.cost() + 0.5;
    }

    @Override
    public void drink() {
        System.out.println(beverage.getName() + " s mlijekom pijem");
    }
}
