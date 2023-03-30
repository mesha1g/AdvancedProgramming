package JavaOrgExample.First;

import java.util.Arrays;
import java.util.Iterator;

/**
 * <li>1. polja ..capacity, numbers</li>
 * <li>2. mora konstruktor</li>
 * <li>3. add(broj)</li>
 * <li>4. inner klase</li>
 * <p>
 * DynamicArray dynamicArray = new DynamicArray();
 * <p>
 * for(int number: dynamicArray){
 * <p>
 * }ž
 * Moramo:
 * <li>1. implement Iterable<Integer></li>
 * <li>2. Iterator iterator()</li>
 *
 * <DZ>
 * remove()-> sami uraditi
 * </DZ>
 */
public class IntegerArray implements Iterable<Integer> {
    private int capacity = 0;
    private int[] numbers = new int[capacity];

    public IntegerArray() {
        super();
    }

    public void add(int number) {
        capacity++;
        numbers = Arrays.copyOf(numbers, capacity);
        numbers[capacity - 1] = number;
    }

    public void removeAt(int index) {
        if (index < 0 || index >= capacity) {
            System.err.println("Index out of range..");
        } else {
            for (int i = index; i < capacity - 1; i++) {
                numbers[i] = numbers[i + 1];
            }
            Arrays.copyOfRange(numbers, 0, capacity-1);
            capacity--;
        }
    }

    public void remove(int number){
        for(int i = 0; i<numbers.length; i++){
            if(numbers[i] == number){
                removeAt(i);
                break;
            }
        }
    }


    @Override
    public Iterator<Integer> iterator() {
        Iterator<Integer> iterator = new IntegerIterator();
        return iterator;
    }


    private class IntegerIterator implements Iterator<Integer> {
        private int nextIndex = 0;

        @Override
        public boolean hasNext() {
            boolean imaJos = (nextIndex <= capacity - 1);
            return imaJos;
        }

        @Override
        public Integer next() {
            int number = numbers[nextIndex];
            nextIndex++;
            return number;
        }
    }

}
