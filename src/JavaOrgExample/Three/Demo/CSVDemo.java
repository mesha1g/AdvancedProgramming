package JavaOrgExample.Three.Demo;





import JavaOrgExample.First.Gender;
import JavaOrgExample.Two.Collection.Person;
import JavaOrgExample.Two.Collection.PersonCsvReader;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class CSVDemo {
    public static void main(String[] args) {

        Person person = new Person()
                .setGender(Gender.MALE)
                .setName("Alden")
                .setSurname("Efendić");
        //LAMBDA -> - zamjena za new ali samo kada se kreiraju objekti tipa FI
        PersonTester personTester = (p) -> p.getGender().equals(Gender.FEMALE);
        personTester.test(person);


        PersonCsvReader personCsvReader = new PersonCsvReader("persons.csv");
        List<Person> personList = personCsvReader.readPersonList();
        personList.stream().filter(p->p.getGender().equals(Gender.FEMALE)).forEach(p-> System.out.println(p));
        //printPersons(personList, p -> true);
        //printPersons(personList);
        //printFemalePersons(personList);
        //printPersons(personList, p->p.getGender().equals(Gender.FEMALE));
        //printMalePersons(personList);
        //printPersons(personList, p->p.getGender().equals(Gender.MALE));
        //printPersonsOlderThan(personList, 20);
        //printPersons(personList, p -> p.getAge() >= 20, p -> System.out.println(p));
        //printPersonsYoungerThan(personList, 20);
        //printPersons(personList, p -> p.getAge() < 20);
    }

    //ENHANCED : Iterable<Person>  ... Iterator<Person>
//        for (Person person : personList) {
//            if (personTester.test(person)) {
//                System.out.println(person);
//            }
//        }
    //Java 8... Spliterator<Person> Martin Fowler
    static void printPersons(List<Person> personList, Predicate<Person> personPredicate, Consumer<Person> personConsumer) {

        personList.stream()//1. IZVOR
                .filter(personPredicate)//2. MEĐUOPERACIJA
                .forEach(personConsumer);//3. TERMINATE function
    }
//
//    static void printPersons(List<Person> personList) {
//        for (int i = 0; i < personList.size(); i++) {
//            Person person = personList.get(i);
//            System.out.println(person);
//        }
//    }
//
//    static void printFemalePersons(List<Person> personList) {
//        for (int i = 0; i < personList.size(); i++) {
//            Person person = personList.get(i);
//            if (person.getGender().equals(Gender.FEMALE)) {
//                System.out.println(person);
//            }
//        }
//    }
//
//    static void printMalePersons(List<Person> personList) {
//        for (int i = 0; i < personList.size(); i++) {
//            Person person = personList.get(i);
//            if (person.getGender().equals(Gender.MALE)) {
//                System.out.println(person);
//            }
//        }
//    }
//
//    static void printPersonsOlderThan(List<Person> personList, int age) {
//        for (int i = 0; i < personList.size(); i++) {
//            Person person = personList.get(i);
//            if (person.getAge() >= age) {
//                System.out.println(person);
//            }
//
//        }
//    }
//
//    static void printPersonsYoungerThan(List<Person> personList, int age) {
//        for (int i = 0; i < personList.size(); i++) {
//            Person person = personList.get(i);
//            if (person.getAge() < age) {
//                System.out.println(person);
//            }
//
//        }
//    }

}
