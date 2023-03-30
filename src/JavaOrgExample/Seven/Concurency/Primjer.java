package JavaOrgExample.Seven.Concurency;

import java.util.Arrays;
import java.util.List;

public class Primjer {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 34, 342, 5, 4, 54, 456, 23, 2323, 5);
        int sum = 0;
        for (int number : numbers) {
            if (number % 2 == 0) {
                sum = sum + number * 2;
            }
        }
        System.out.println(sum);
        System.out.println(numbers.stream().filter(n -> n % 2 == 0).map(n -> n * 2).reduce(0, (n1, n2) -> n1 + n2));
    }
}
