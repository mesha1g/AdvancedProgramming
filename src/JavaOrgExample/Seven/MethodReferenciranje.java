package JavaOrgExample.Seven;



import JavaOrgExample.First.Person;
import JavaOrgExample.Four.Collection.Customer.CustomerDao;
import JavaOrgExample.Three.JDBC.Customer;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * ->     @FunctionalInterface
 * <p>
 * new
 * ->
 * <li>1. Predicate<E>   boolean test  E element    </li>
 * <li>2. Consumer<E>   void      E element</li>
 * <li>3. Supplier<E>    E element   ()   </li>
 * <li>4. Function<T, R> R returnedElement  T takenElement  </li>
 *
 * <p>
 * Kada LAMBDA ne radi ništa drugo nego poziva samo metodu ili funkciju
 * gotovu onda se samo REFERENCIRAJ NA TU METODU
 * </p>
 * <p>
 * Postoje 4 vrste METHOD REFERENCIRANJA:
 * <li>1. Referenca na STATIČKU METODU</li>
 * <li>2. Referenca na INSTANCNU/OBJEKTNU METODU</li>
 * <li>3. Referenca na INSTANCNU METODU određenog tipa</li>
 * <li>4. Referenca na KONSTRUKTOR</li>
 * </p>
 */
public class MethodReferenciranje {
    public static void main(String[] args) {
        List<Customer> customers = new CustomerDao().getAll();
        Consumer<Customer> customerConsumer = System.out::println;
        customers.forEach(System.out::println);
        Collections.sort(customers, MethodReferenciranje::compareByAddress);

        //THIRD PART library -> Customer[] customerArray
        Customer[] customerArray = customers.toArray(new Customer[customers.size()]);
        CustomComparator customComparator = new CustomComparator();
        Comparator<Customer> comparator = (c1, c2) -> c1.getFirstName().compareTo(c2.getFirstName());
        Arrays.sort(customerArray, customComparator::compare);
        Comparator<Customer> ageComparator = (o1, o2) -> o1.compareByAge(o2);
        Arrays.sort(customerArray, ageComparator);
        String[] names = {"Slađana", "DEjla", "DEJLA", "Rahima", "Anja"};
        Arrays.sort(names, String::compareToIgnoreCase);
      /*  for(String name: names){
            System.out.println(name);
        }*/
        Person person = new Person();
        Supplier<HashSet<Person>> personSupplier = HashSet::new;

        Supplier<HashSet<Customer>> hashSetSupplier = HashSet::new;
        Supplier<TreeSet<Customer>> linkedHashSetSupplier = TreeSet::new;

        TreeSet<Customer> customerHashSet = transferElements(customers, TreeSet::new);
        transferElements(customers, LinkedList::new);
        transferElements(customerHashSet, ArrayList::new);

    }

    //GENERIC TYPES ->
    // 3 generička tipa -> E  Customer , SRC extends Collection<E>, DST extends Collection<E>
    static <E, SRC extends Collection<E>, DST extends Collection<E>> DST transferElements(SRC src, Supplier<DST> dst) {
        DST destinationCollection = dst.get();
        for (E element : src) {
            destinationCollection.add(element);
        }
        return destinationCollection;
    }

    static int compareByAddress(Customer n1, Customer n2) {
        return n1.getAddress().compareToIgnoreCase(n2.getAddress());
    }

    static class CustomComparator implements Comparator<Customer> {
        @Override
        public int compare(Customer o1, Customer o2) {
            return o2.getCustomerId().compareTo(o1.getCustomerId());
        }
    }
}

