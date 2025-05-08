import java.io.*;
import java.util.*;

class Queue<T>{
    Stack<T> stack1;
    Stack<T> stack2;

    Queue(){
        stack1 = new Stack<T>();
        stack2 = new Stack<T>();
    }

    public void enqueue(T data){
        stack1.push(data);
    }

    public void dequeue(){
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (!stack2.isEmpty()) {
            stack2.pop();
        }

    }

    public void peek(){
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (!stack2.isEmpty()) {
            System.out.println(stack2.peek());
        }

    }
}

public class Solution3 {

    public static void main(String[] args) throws IOException{
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        Queue<Integer> queue = new Queue<>();
        for(int i = 0 ; i < n ; i++){
            String line = scan.nextLine();
            String[] query = line.split(" ");
            int op = Integer.parseInt(query[0]);
            if(op == 1){
                queue.enqueue(Integer.parseInt(query[1]));
            }else if(op == 2){
                queue.dequeue();
            }else if(op == 3){
                queue.peek();
            }
        }
        scan.close();
    }
}