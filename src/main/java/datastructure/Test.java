package datastructure;

public class Test {
    public static void main(String[] args) {
        Stack<Integer> stack = new LinkedListStack<>();
        System.out.println(stack.empty());
        stack.push(1);
        stack.push(2);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.empty());
    }
}
