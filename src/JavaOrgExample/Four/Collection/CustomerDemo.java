package JavaOrgExample.Four.Collection;



import JavaOrgExample.Four.Collection.Customer.CustomerDao;
import JavaOrgExample.Three.JDBC.Customer;

import java.util.List;

public class CustomerDemo {
    public static void main(String[] args) {
        CustomerDao customerDao = new CustomerDao();
        Customer customer = customerDao.get(5);
        List<Customer> customers = customerDao.getAll();
        //iterator
//        for (Customer c : customers) {
//            printCustomer(c);
//        }

        //spliterator
        //Consumer<Customer> customerConsumer = c -> printCustomer(c);
        customers.forEach(CustomerDemo::printCustomer);
    }

    static void printCustomer(Customer customer) {
        System.out.println(customer);
    }
}
