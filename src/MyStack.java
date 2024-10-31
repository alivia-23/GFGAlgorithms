import java.util.LinkedList;
import java.util.Queue;

/**
 *
 */

public class MyStack {
    private Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.add(x);
        for (int i = 1; i <= queue.size() - 1; i++) {
            queue.add(queue.remove());  // remove previous elements and add those to the back
        }
    }

    public int pop() {
        return queue.remove();
    }

    public int top() {
        return queue.peek();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(15);
        stack.push(20);
        stack.push(5);
        stack.push(10);
        int[] result = new int[4];
        result[0] = stack.pop();
        result[1] = stack.pop();
        int top = stack.top();
        System.out.println("Top: "+top);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }

}
