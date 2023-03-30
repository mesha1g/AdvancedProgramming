package JavaOrgExample.One.Two.OOP.Demo;


import JavaOrgExample.One.Two.OOP.Esspresso;
import JavaOrgExample.One.Two.OOP.MilkDecorator;
import JavaOrgExample.One.Two.OOP.Tea;

public class BeverageDemo {
    public static void main(String[] args) {
        //FileReader filReader = new FileReader()
        Esspresso esspresso = new Esspresso();
        //BufferedReader reader = new Buffered(fileReader);
        MilkDecorator milkDecorator = new MilkDecorator(esspresso);
        milkDecorator.drink();
        milkDecorator.print();

        esspresso.drink();
        esspresso.print();

        Tea tea = new Tea();
        tea.drink();
        tea.print();

        MilkDecorator beverage = new MilkDecorator(tea);
        beverage.drink();
        beverage.print();

//        System.out.println(beverage.cost());
    }
}
