package JavaOrgExample.Three.Homework;

import java.util.Arrays;
import java.util.Iterator;

public class Container<E> implements Iterable<E> {
    private int capacity = 0;
    private E[] elements = (E[]) new Object[capacity];

    public Container() {
        super();
    }

    public void add(E element) {
        capacity++;
        elements = Arrays.copyOf(elements, capacity);
        elements[capacity - 1] = element;
    }

    public void removeAt(int index) {
        if (index < 0 || index >= capacity) {
            System.err.println("Index out of range..");
        } else {
            for (int i = index; i < capacity - 1; i++) {
                elements[i] = elements[i + 1];
            }
            Arrays.copyOfRange(elements, 0, capacity - 1);
            capacity--;
        }
    }

    public void remove(E element) {
        for (int i = 0; i < elements.length; i++) {
            if (elements[i].equals(element)) {
                removeAt(i);
                break;
            }
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new ElementIterator();
    }

    private class ElementIterator implements Iterator<E> {
        private int nextIndex = 0;

        @Override
        public boolean hasNext() {
            boolean imaJos = (nextIndex <= capacity - 1);
            return imaJos;
        }

        @Override
        public E next() {
            E element = elements[nextIndex];
            nextIndex++;
            return element;
        }
    }
}
