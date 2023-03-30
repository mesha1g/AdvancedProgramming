package JavaOrgExample.Six;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberDemo {
    public static void main(String[] args) {
        //Streamovi ->

        List<Double> doubleNumbers = Arrays.asList(23.45, 34.56, 190.34, 1900.34);
        double doubleSum = sum(doubleNumbers);
        System.out.println(doubleSum);
    }

    // ? WILDCARD ili DZOKERSKI TIP
    /*
       Dvije vrste generičkih tipova:
        <li> 1. Unbounded E
        <li> 2. E extends Number
       Dzokerski tipova imamo tri grupe:
       <li> 1. ? Unbounded
       <li> 2. ? BOUNDED
             2.1 UPPER BOUNDED  ? super Number
             2.2 LOWER BOUNDED  ? extends Number
     */
    static double sum(List<Double> numbers){
        double sum = 0.0;
        for(Number number: numbers){
            sum = sum + number.doubleValue();
        }
        return sum;
//        return numbers
//                .stream()
//                .reduce(0.0, (x1, x2)->x1+x2);
    }
}
