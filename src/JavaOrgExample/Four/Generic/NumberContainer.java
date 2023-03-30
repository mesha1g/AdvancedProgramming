package JavaOrgExample.Four.Generic;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Simulirati dinamičke nizove
 * <li>
 *     1. add(E element)
 *     2. removeAt(int index)
 *     3. remove(E element)
 *     4. iterator() -> Iterator -> private class
 *
 * </li>
 */
public class NumberContainer<E extends Number> implements Iterable<E> {
    private int capacity = 0;
    private E[] numbers = (E[]) new Object[capacity];

    public void add(E element) {
        capacity++;
        numbers = Arrays.copyOf(numbers, capacity);
        numbers[capacity - 1] = element;
    }

    public void removeAt(int index) {
        if (index < 0 || index >= capacity) {
            System.err.println("Index out of range..");
        } else {
            for (int i = index; i < capacity - 1; i++) {
                numbers[i] = numbers[i + 1];
            }
            Arrays.copyOfRange(numbers, 0, capacity - 1);
            capacity--;
        }
    }

    public void remove(E element) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i].equals(element)) {
                removeAt(i);
                break;
            }
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new NumberIterator();
    }

    private class NumberIterator implements Iterator<E> {
        private int nextIndex = 0;

        @Override
        public boolean hasNext() {
            boolean imaJos = (nextIndex <= capacity - 1);
            return imaJos;
        }

        @Override
        public E next() {
            E element = numbers[nextIndex];
            nextIndex++;
            return element;
        }
    }
}
