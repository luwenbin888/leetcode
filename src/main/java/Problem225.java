import java.util.LinkedList;
import java.util.Queue;

/*
Implement the following operations of a stack using queues.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
empty() -- Return whether the stack is empty.
Notes:
You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
 */
public class Problem225 {
    public static void main(String[] args) {
        MyStack mystack = new MyStack();
        System.out.println(mystack.empty());
        mystack.push(1);
        mystack.push(2);
        mystack.push(3);
        System.out.println(mystack.top());

        while (!mystack.empty()) {
            System.out.println(mystack.pop());
        }
    }
}

class MyStack {

    Queue<Integer> data = new LinkedList<>();

    /** Initialize your data structure here. */
    public MyStack() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        Queue<Integer> temp_queue = new LinkedList<>();
        temp_queue.offer(x);
        while (!data.isEmpty()) {
            temp_queue.offer(data.poll());
        }

        /*
        while (!temp_queue.isEmpty()) {
            data.offer(temp_queue.poll());
        }
        */
        data = temp_queue;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return data.poll();
    }

    /** Get the top element. */
    public int top() {
        return data.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return data.isEmpty();
    }
}
