package JavaOrgExample.Seven.Concurency;

import java.util.Arrays;
import java.util.List;

public class Primjer2 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 34, 342, 5, 4, 54, 456, 23, 2323, 5);
        int sum = 0;
        for (int number : numbers) {
            if (number % 2 == 0) {
                sum = sum + number * 2;
            }
        }
        //System.out.println(sum);
        //System.out.println(numbers.stream().filter(n -> n % 2 == 0).map(n -> n * 2).reduce(0, (n1, n2) -> n1 + n2));
        numbers.parallelStream()
                .map(Primjer2::transform)
                .forEach(Primjer2::printIt);
    }


    static int transform(int number) {
        System.out.println("transform: " + Thread.currentThread().getName());
        return number;
    }

    //total = 0
    //total = total + number
    //total = total + number
    static int add(int total, int number) {
        int result = total + number;
        System.out.println("total = " + total + "   number: " + number);
        return result;
    }

    static void printIt(Integer number) {
        System.out.println(number + " " + Thread.currentThread().getName());
    }

}

