package datastructure;

import java.util.ArrayList;

/**
 * Stack implemented by Array
 */
public class ArrayStack<T> implements Stack<T>{
    ArrayList<T> data = new ArrayList<>();

    @Override
    public synchronized int size() {
        return data.size();
    }

    @Override
    public synchronized boolean push(T item) {
        return data.add(item);
    }

    @Override
    public synchronized T pop() {
        T item = data.get(data.size() - 1);
        data.remove(data.size() - 1);
        return item;
    }

    @Override
    public synchronized boolean empty() {
        return data.isEmpty();
    }
}
