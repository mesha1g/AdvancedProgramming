package JavaOrgExample.Three.Homework;


import JavaOrgExample.First.IntegerArray;

/**
 * Imam klasu koja se zove DynamicArray i koja implementira Iterable<Integer>
 * <p>
 * <>iterator()  -> Iterator<Integer></>
 *
 * <li>1. enhanced for loop -> Iterable<Integer</li>
 * <li>2. Iterable me natjera da definiram Iterator </li>
 * <p>
 * ZADACA:
 * <li>1. IntegerArray kopirati jer ćemo ovaj ostaviti za uspomenu i dugo sjećanje</li>
 * <li>2. Preimenovati tu klasu tako da je nazovemo Container<E></li>
 * <li>3. Kontejnter zvani Container treba da parametrizujemo sa E element i da umjesto
 * da imamo mogućnost da ubacujemo samo Integer brojeve možemo u taj kontejner ubaciti
 * i Person element i Double element i Dog i Cat....</li>
 * <li>4. Use case: <p>
 * Container<Person> personContainer = new Container<>();
 * Person alden = new Person();
 * personContainer.add(alden);
 * Person dejla = new Person();
 * personContainer.add(dejla);
 * </p>
 * <p>
 *     Container<Double> decimalNumberContainer = new Container<Double>();
 *     decimalNumberContainer.add(23.4);
 * </p
 * <p>
 *     Container<String> nameContainer = new Container<String();
 *     nameContainer.add("Alden");
 *     nameContainer.add("Dejla");
 *     nameContainer.add("Greta);
 *     nameContainer.removeAt(0);
 *     nameContainer.add("Rahima");
 *     nameContainer.add("Elvira);
 *     nameContainer.add("Amela");
 * </p>
 * </li>
 */
public class HomeworkDemo {
    public static void main(String[] args) {
        int[] numbers = new int[3];
        for (int number : numbers) {

        }
        //IntegerArray -> Iterable<Integer> ->
        IntegerArray numberArray = new IntegerArray();
        numberArray.add(23);
        numberArray.add(24);
        numberArray.add(29);
        numberArray.removeAt(2);
        numberArray.add(120);
        numberArray.add(24);
        numberArray.add(24);
        numberArray.remove(24);
        for (Integer number : numberArray) {
            System.out.println(number);
        }

    }
}
