package JavaOrgExample.Three.Demo;


import JavaOrgExample.First.Gender;
import JavaOrgExample.Two.Collection.Person;

public class FemalePersonTester implements PersonTester{
    @Override
    public boolean test(Person person) {
        boolean test = person.getGender().equals(Gender.FEMALE);
        return test;
    }
}
