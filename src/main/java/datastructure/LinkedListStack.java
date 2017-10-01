package datastructure;

/**
 * Stack implemented by linked list
 */
public class LinkedListStack<T> implements Stack<T> {

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean push(T item) {
        return false;
    }

    @Override
    public T pop() {
        return null;
    }

    @Override
    public boolean empty() {
        return false;
    }
}
