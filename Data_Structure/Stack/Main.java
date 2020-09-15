package Stack;

public class Main{

    public static void main(String[] args){

        MyStack<Integer> stack = new MyStack<>();
        
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.pop();
        stack.pop();

        System.out.println(stack.peek());
        System.out.println(stack.size());

        MyStack<Integer> sub_stack = new MyStack<>();

        sub_stack.push(5);
        sub_stack.push(6);
        sub_stack.push(7);
        sub_stack.pop();

        System.out.println(sub_stack.peek());
        System.out.println(sub_stack.size());

        stack.merge(sub_stack);

        System.out.println(stack.peek());
        System.out.println(stack.size());

        System.out.println(stack.contains(4));
        System.out.println(stack.contains(5));
    }
}