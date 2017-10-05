import java.util.Stack;

/*
Implement the following operations of a queue using stacks.

push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.
Notes:
You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
 */
public class Problem232 {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);

        while (!myQueue.empty()) {
            System.out.println(myQueue.pop());
        }
    }
}

class MyQueue {

    private Stack<Integer> data = new Stack<>();

    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        Stack<Integer> temp_stack = new Stack<>();
        while (!data.isEmpty()) {
            temp_stack.push(data.pop());
        }
        temp_stack.push(x);

        while (!temp_stack.isEmpty()) {
            data.push(temp_stack.pop());
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return data.pop();
    }

    /** Get the front element. */
    public int peek() {
        return data.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return data.isEmpty();
    }
}
