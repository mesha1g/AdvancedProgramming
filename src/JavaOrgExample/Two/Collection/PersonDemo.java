package JavaOrgExample.One.Two.Collection;

import java.util.List;

public class PersonDemo {
    public static void main(String[] args) {
        PersonCsvReader personCsvReader = new PersonCsvReader("persons.csv");
        List<Person> personList = personCsvReader.readPersonList();
        for (int i = 0; i < personList.size(); i++) {
            Person person = personList.get(i);
            System.out.println(person);
        }
        System.out.println("ANother way ENHANCED...");
        for (Person person : personList) {
            System.out.println(person);
        }
        System.out.println();
        System.out.println("Pravi ENHANCED");
        personList.forEach(p -> System.out.println(p));
    }
}

