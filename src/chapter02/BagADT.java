package chapter02;

import java.util.Iterator;

public interface BagADT {
    void add(Object element);

    Object removeRandom() throws EmptyBagException;

    Object remove(Object element) throws EmptyBagException;

    BagADT union(BagADT set);

    boolean contains(Object target);

    boolean equals(BagADT bag) throws EmptyBagException;

    boolean isEmpty();

    int size();

    @SuppressWarnings("rawtypes")
    Iterator iterator();

    String toString();
}
