package JavaOrgExample.Four.Generic;



import JavaOrgExample.First.Gender;
import JavaOrgExample.First.Person;
import JavaOrgExample.Three.Homework.Container;

import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {
        //raw type
        Container container = new Container();

        //person container
        Person person = new Person();
        person.setName("Mirsad");
        person.setSurname("Škandro");
        person.setGender(Gender.MALE);

        Person person2 = new Person();
        person2.setName("Dejla");
        person2.setSurname("Šarić");
        person2.setGender(Gender.FEMALE);

        Container<Person> personContainer = new Container<>();
        personContainer.add(person);
        personContainer.add(person);
        personContainer.add(person2);

        personContainer.remove(person);
        for (Person p : personContainer) {
            System.out.println(p);
        }

        Container<Integer> integerContainer = new Container<>();
        integerContainer.add(23);
        integerContainer.add(34);
        for (Integer broj : integerContainer) {
            System.out.println(broj);
        }

        ArrayList<Person> personArrayList = new ArrayList<>();
    }
}
