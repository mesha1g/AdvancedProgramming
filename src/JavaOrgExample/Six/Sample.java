package JavaOrgExample.Six;


import java.util.Arrays;
import java.util.List;

public class Sample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 34, 343, 5, 4, 54, 45, 2323, 544, 5);
        int result = 0;
        for (Integer number : numbers) {
            if (number % 2 == 0) {
                result = result + 2 * number;
            }
        }
        System.out.println(result);

        //Collection pipeline Martin Fowler
        //Elegancija u ndeostatku performansa enije dobra
        System.out.println(numbers
                .stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * 2)
                .reduce(0, (x1, x2) -> x1 + x2));
    }
}

