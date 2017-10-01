package datastructure;

/**
 * Stack interface
 */
public interface Stack<T> {
    int size();
    boolean push(T item);
    T pop();
    boolean empty();
}
