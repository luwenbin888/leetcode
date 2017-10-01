package datastructure;

/**
 * Stack implemented by linked list
 */
public class LinkedListStack<T> implements Stack<T> {

    private int size;
    private StackListNode<T> head;
    private StackListNode<T> tail;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean push(T item) {
        StackListNode<T> node = new StackListNode<>();
        node.item = item;
        node.next = null;

        if (head == null) {
            head = node;
            tail = node;
        }
        else {
            node.next = head;
            head = node;
        }

        size++;

        return true;
    }

    @Override
    public T pop() {
        if (head == null) return null;
        T item = head.item;
        head = head.next;
        size--;
        return item;
    }

    @Override
    public boolean empty() {
        return head == null;
    }

    private class StackListNode<T> {
        public T item;
        public StackListNode<T> next;
    }
}
