package com.training.nmusabirova.hw8task1;

import java.util.*;

public class CustomList<E> implements List<E> {
    private int size;
    private Object[] values = new Object[0];
    private static final int MAX_CAPACITY = 9;

    @Override
    public int size() {
        return values.length;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size(); i++) {
            if (values[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        if (checkForTypeAndSize(e)) {
            try {
                ensureCapacityInternal(size + 1);
            } catch (FullListException ex) {
                System.out.println(ex.getMessage());
                return false;
            }

            values[size++] = e;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean remove(Object o) {
            for (int index = 0; index < size(); index++) {
                if (o.equals(values[index]) || (o == null && values[index] == null)) {
                    removeElement(index);
                    return true;
                }
            }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        values = new Object[0];
    }

    @Override
    public E get(int index) {
        E result;
        try {
            result = (E) values[index];
        } catch (Exception ex) {
            result = null;
            System.out.println("Error! Index cannot be negative and larger than the size of the list.");
        }
        return result;
    }

    @Override
    public E set(int index, E element) {
        E result;
        try {
            if (size() > 1) {
                if (checkForType(element)) {
                    values[index] = element;
                }
            } else {
                values[index] = element;
            }
            result = (E) values[index];
        } catch (Exception ex) {
            result = null;
            System.out.println("Error! Index cannot be negative and larger than the size of the list.");
        }
        return result;
    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    private boolean checkForTypeAndSize(E e) {
        boolean check = false;
        if (size() > 0) {
            if (checkForType(e)) {
                check = true;
            }
        } else {
            check = true;
        }
        return check;
    }

    private boolean checkForType(E e) {
        if (values[0].getClass() == e.getClass()) {
            return true;
        }
        return false;
    }

    private void ensureCapacityInternal(int size) throws FullListException {
        if (checkSize(size)) {
            Object[] newData = new Object[size];
            for (int i = 0; i < size(); i++) {
                newData[i] = values[i];
            }
            values = newData;
        }
    }

    private boolean checkSize(int size) throws FullListException {
        boolean check = false;
        if (size > MAX_CAPACITY) {
            throw new FullListException("Error! The list is full.");
        } else {
            check = true;
        }
        return check;
    }

    private void removeElement(int index) {
        Object[] newData = new Object[size() - 1];
        boolean found = false;
        for (int i = 0; i < size(); i++) {
            if (i == index) {
                found = true;
            } else if (i != index && found == true) {
                newData[i - 1] = values[i];
            } else if (i != index && found == false) {
                newData[i] = values[i];
            }
        }
        values = newData;
    }
}