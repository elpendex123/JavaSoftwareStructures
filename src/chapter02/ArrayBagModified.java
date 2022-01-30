package chapter02;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

// Add user control of the bag's capacity.
// Eliminate the automatic expansion of the array.
// The revised class should throw a FullBagException when an element is added to a full bag.
// Add a method call isFull() that returns true if the bag is full.
// Add a method to expand the capacity by a particular number of cells.
public class ArrayBagModified implements BagADT {
    private static Random rand = new Random();
    private final int DEFAULT_CAPACITY = 100;
    private final int NOT_FOUND = -1;
    private int count;
    private Object[] contents;

    public ArrayBagModified() {
        count = 0;
        contents = new Object[DEFAULT_CAPACITY];
    }

    public ArrayBagModified(int initialCapacity) {
        count = 0;
        contents = new Object[initialCapacity];
    }

    @Override
    public void add(Object element) {
        if (size() == contents.length)
            expandCapacity();

        contents[count] = element;
        count++;
    }

    public void addAll(BagADT bag) {
        Iterator scan = bag.iterator();

        while (scan.hasNext())
            add(scan.next());
    }

    @Override
    public Object removeRandom() throws EmptyBagException {
        if (isEmpty())
            throw new EmptyBagException();

        int choice = rand.nextInt(count);
        Object result = contents[choice];
        contents[choice] = contents[count - 1];
        contents[count - 1] = null;
        count--;

        return result;
    }

    @Override
    public Object remove(Object target) throws EmptyBagException, NoSuchElementException {
        int search = NOT_FOUND;

        if (isEmpty())
            throw new EmptyBagException();

        for (int index = 0; index < count && search == NOT_FOUND; index++) {
            if (contents[index].equals(target)) {
                search = index;
            }
        }

        if (search == NOT_FOUND)
            throw new NoSuchElementException();

        Object result = contents[count - 1];
        contents[search] = contents[count - 1];
        contents[count - 1] = null;
        count--;

        return result;
    }

    @Override
    public BagADT union(BagADT bag) {
        ArrayBagModified both = new ArrayBagModified();

        for (int index = 0; index < count; index++)
            both.add(contents[index]);

        Iterator scan = bag.iterator();

        while (scan.hasNext())
            both.add(scan.next());

        return both;
    }

    @Override
    public boolean contains(Object target) {
        int search = NOT_FOUND;

        for (int index = 0; index < count && search == NOT_FOUND; index++) {
            if (contents[index].equals(target)) {
                search = index;
            }
        }

        return (search != NOT_FOUND);
    }

    @Override
    public boolean equals(BagADT bag) throws EmptyBagException {
        boolean result = false;
        ArrayBagModified temp1 = new ArrayBagModified();
        ArrayBagModified temp2 = new ArrayBagModified();
        Object obj;

        if (size() == bag.size()) {
            temp1.addAll(this);
            temp2.addAll(bag);

            Iterator scan = bag.iterator();

            while (scan.hasNext()) {
                obj = scan.next();

                if (temp1.contains(obj)) {
                    temp1.remove(obj);
                    temp2.remove(obj);
                }
            }

            result = (temp1.isEmpty() && temp2.isEmpty());
        }

        return result;
    }

    @Override
    public boolean isEmpty() {
        return (count == 0);
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public Iterator iterator() {
        return new ArrayIterator(contents, count);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (int index = 0; index < count; index++)
            result.append(contents[index].toString()).append("\n");

        return result.toString();
    }

    private void expandCapacity() {
        Object[] larger = new Object[contents.length * 2];

        for (int index = 0; index < contents.length; index++)
            larger[index] = contents[index];

        contents = larger;
    }
}
