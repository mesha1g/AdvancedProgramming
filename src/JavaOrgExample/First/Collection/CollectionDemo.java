package JavaOrgExample.First.Collection;

import java.util.*;

public class CollectionDemo {
    public static void main(String[] args) {
        List<String> nameList = new ArrayList<>();
        nameList.add("Adis");
        nameList.add("Alden");
        nameList.add("Zejd");
        nameList.add("Anja");
        nameList.add("Anja");
        nameList.add("Anja");
        nameList.add("Anja");
        nameList.add("Slađana");
        nameList.add("Dejla");
        for (int i = 0; i < nameList.size(); i++) {
            String name = nameList.get(i);
            System.out.println(name);
        }

        Set<String> setOfNames = new TreeSet<>();
        setOfNames.add("Adis");
        setOfNames.add("Alden");
        setOfNames.add("Zejd");
        setOfNames.add("Anja");
        setOfNames.add("Anja");
        setOfNames.add("Anja");
        setOfNames.add("Anja");
        setOfNames.add("Slađana");
        setOfNames.add("Dejla");
        System.out.println();
        System.out.println("SETOVI:........");
        for (String name : setOfNames) {
            System.out.println(name);
        }
    }
}
