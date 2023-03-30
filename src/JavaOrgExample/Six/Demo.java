package JavaOrgExample.Six;



import JavaOrgExample.Four.Collection.Customer.CustomerDao;
import JavaOrgExample.Four.Collection.Product.Product;
import JavaOrgExample.Four.Collection.Product.ProductDao;
import JavaOrgExample.Three.JDBC.Customer;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * FP
 * <p>
 * <li>1. Supplier<E> </li>
 * <li>2. Consumer<E> </li>  -> pohlepni objekat koji konzumira i ništa void accept E element
 * <li>3. Function<T,R> </li>
 * <li>4. Predicate<E></li>  -> sumnjičavi objekat koji radi test -> true/false
 * </p>
 */
public class Demo {
    public static void main(String[] args) {
        //BAZA: customers     JAVA PROGRAM: Customer
        //DESIGN PATTERN: DAO Data Access Object    Dao<E>   -> CustomerDao implements Dao<Customer>
        CustomerDao customerDao = new CustomerDao();
        List<Customer> customers = customerDao.getAll();
        //printCustomersWithPointsLowerThan(customers, 1000);
        //Napravite funkciju pomoću koje ćete
        // ispisati sve customer objekte koji imaju više od 1000 poena
        //ali ispis ne treba da bude ovakav nego želim vidjeti samo ime i prezime kupca
        //customPrintOfCustomers(customers, 1000);
//        printOlderThan(customers, LocalDate.of(1990, 1, 1));
//        printYoungerThan(customers, LocalDate.of(1990, 1, 1));
//        printCustomerBornOnFromState(customers, LocalDate.of(1991, 9, 4), "IL");
//        customers
//                .stream()
//                .filter(c->c.getPoints()>=1000)
//                .filter(c->c.getState().equals("MA"))
//                .filter(c->c.getBirthdate().isBefore(LocalDate.of(1990, 1, 1)))
//                .map(c -> c.getFirstName()+" " + c.getLastName()+","+c.getBirthdate())
//                .forEach(c -> System.out.println(c));
        //processElements(customers, c->c.getPoints()>1000, c -> System.out.println(c));
        List<Product> products = new ProductDao().getAll();
        //processElements(products, p->p.getQuantityInStock()>30, p-> System.out.println(p));
        Integer[] numbers = {23, 77, 0, 7, 34};
        //Arrays
        processElements(Arrays.asList(numbers),n->n.equals(23), n-> System.out.println(n));
        var number = 23;
    }

    static <E> void processElements(List<E> elements, Predicate<E> tester, Consumer<E> consumer){
        elements
                .stream()
                .filter(tester)
                .forEach(consumer);
    }

//    static void print(List<Customer> customers, Predicate<Customer> tester, Consumer<Customer> consumer){
//        customers.stream()
//                .filter(tester)
//                .forEach(consumer);
//    }


    static void printCustomerBornOnFromState(List<Customer> customers, LocalDate birthdate, String countryStateCode){
        customers
                .stream()
                .filter(customer->customer.getBirthdate().isEqual(birthdate))
                .filter(c->c.getState().equals(countryStateCode))
                .forEach(c -> System.out.println(c));
    }
    static void printCustomerBornOn(List<Customer> customers, LocalDate birthdate){
        customers
                .stream()
                .filter(customer->customer.getBirthdate().isEqual(birthdate))
                .forEach(c -> System.out.println(c));
    }

    static void printYoungerThan(List<Customer> customers, LocalDate date){
        customers
                .stream()
                .filter(c -> c.getBirthdate().isBefore(date))
                .forEach(c -> System.out.println(c));
    }

    static void printOlderThan(List<Customer> customers, LocalDate date){
        customers
                .stream()
                .filter(c->c.getBirthdate().isAfter(date))
                .map(c -> c.getFirstName()+" " + c.getLastName()+", "+c.getBirthdate())
                .forEach(c -> System.out.println(c));
    }

    //f-je open/close -> open for extension close for modification
    static void printCustomers(List<Customer> customers) {
        Consumer<Customer> customerConsumer = c -> System.out.println(c);
        customers.forEach(customerConsumer);
    }

    //points >= 1000
    static void printCustomers(List<Customer> customers, int points) {
        Predicate<Customer> tester = c -> c.getPoints() >= points;
        Consumer<Customer> customerConsumer = c -> System.out.println(c);
        customers
                .stream()// 1. izvor
                .filter(tester) // 2. filter
                .forEach(customerConsumer);//terminating operation
    }

    static void printCustomersWithPointsLowerThan(List<Customer> customers, int points) {
        //FLUENT PROGRAMMING
        customers // List<Customer>
                .stream() // in : List<Customer> out: Stream<Customer>
                .filter(c -> c.getPoints() < points)// in: Stream<Customer out: Stream<Customer>
                .forEach(c -> System.out.println(c));// in: Stream<Customer> out: void
    }

    static void customPrintOfCustomers(List<Customer> customers, int points){
        Function<Customer, String> transformer = c -> c.getFirstName()+" " + c.getLastName();
        customers
                .stream()//1. IZVOR STREAMA  in: List<Customer> out: Stream<Customer>
                .filter(customer->customer.getPoints()>=points)//2. MEĐUOP in: Stream<Customer>    out: Stream<Customer>
//                .filter(customer -> customer.getFirstName().startsWith("F"))//2. in: Stream<Customer> out: Stream<Customer>
                .map(transformer) // in: Stream<Customer> out:Stream<String>
                .forEach(nameSurname-> System.out.println(nameSurname));//3. in: Stream<String> out: void
        ;
    }
}

