package chapter02;

import java.util.Iterator;
import java.util.NoSuchElementException;

@SuppressWarnings("ALL")
public class ArrayIterator implements Iterator {

    private int count;
    private int current;
    private Object[] items;

    public ArrayIterator(Object[] collection, int size) {
        items = collection;
        count = size;
        current = 0;
    }

    @Override
    public boolean hasNext() {
        return (current < count);
    }

    @Override
    public Object next() {
        if (!hasNext())
            throw new NoSuchElementException();

        current++;
        return items[current - 1];
    }

    public void remove() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }
}
