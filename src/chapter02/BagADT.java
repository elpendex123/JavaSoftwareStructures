package chapter02;

import java.util.Iterator;

public interface BagADT {
    public void add(Object element);

    public Object removeRandom() throws EmptyBagException;

    public Object remove(Object element) throws EmptyBagException;

    public BagADT union(BagADT set);

    public boolean contains(Object target);

    public boolean equals(BagADT bag) throws EmptyBagException;

    public boolean isEmpty();

    public int size();

    public Iterator iterator();

    public String toString();
}
