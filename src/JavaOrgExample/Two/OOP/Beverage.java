package JavaOrgExample.Two.OOP;

public abstract class Beverage implements Drinkable{
    private final String name;

    public Beverage(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    protected abstract double cost();

    public void print(){
        System.out.println(getName()+" košta " + cost());
    }
}
