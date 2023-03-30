package JavaOrgExample.Seven;



import JavaOrgExample.Four.Collection.Customer.CustomerDao;
import JavaOrgExample.Three.JDBC.Customer;

import java.util.*;
import java.util.stream.Collectors;

public class MethoReferencingDemo {
    public static void main(String[] args) {
        //customers DB <-----> Customer Java
        //DAO
        CustomerDao customerDao = new CustomerDao();
        List<Customer> customers = customerDao.getAll();
        System.out.println("LIST:::::::");
        // customers.forEach(c-> System.out.println(c));
        Customer[] customerArray = customers.toArray(new Customer[customers.size()]);
        System.out.println();
        //sortiranja po imenu
        //1. način
        //java.util.Arrays
        Arrays.sort(customerArray, new CustomerComparator());
        for(Customer customer: customerArray){
            //    System.out.println(customer);
        }
        //2. način TreeSet<Customer>
        System.out.println("TREE SET::::::");
        // TreeSet<Customer> customerTreeSet = new TreeSet<>(customers);
        //customerTreeSet.forEach(c-> System.out.println(c));
        System.out.println();
        //3. način Collections da sortirate elemente
        //Collections.sort(customers, new CustomerComparator());
        //Collections.sort(customers, new CustomerAgeComparator());
        //customers.forEach(c -> System.out.println(c));
        //4. orderBy
        CustomerComparator customerComparator = new CustomerComparator();
        customers.stream().sorted(customerComparator).forEach(c -> System.out.println(c));
       /* List<String> listOfNames = new ArrayList<>();
        listOfNames.add("Dejla");
        listOfNames.add("Dejla");
        listOfNames.add("Dejla");
        listOfNames.add("Anja");
        listOfNames.add("Slađana");
        listOfNames.add("Rahima");
        System.out.println("LIST OF NAMES::");
        listOfNames.forEach(name -> System.out.println(name));
        TreeSet<String> treeSetOfNames = new TreeSet<>(listOfNames);
        System.out.println("TREE SET OF NAMES::");
        treeSetOfNames.forEach(name -> System.out.println(name));*/
    }

    private static class CustomerComparator implements Comparator<Customer>{

        @Override
        public int compare(Customer c1, Customer c2) {
            return c2.getCustomerId().compareTo(c1.getCustomerId());
        }
    }

    static class CustomerAgeComparator implements Comparator<Customer>{
        @Override
        public int compare(Customer o1, Customer o2) {
            return o1.getAge().compareTo(o2.getAge());
        }
    }
}
