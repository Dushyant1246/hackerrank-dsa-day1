import java.io.*;
import java.util.*;

public class Solution2 {

    static Stack<Character> stack;
    static Queue<Character> queue;

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String word = reader.readLine().trim();

        stack = new Stack<>();
        queue = new LinkedList<>();

        for(char c: word.toCharArray()){
            stack.push(c);
            queue.offer(c);
        }
        boolean isPalindrome = true;
        while(!stack.isEmpty()){
            if(stack.pop() != queue.poll()){
                isPalindrome = false;
                break;
            }
        }
        String result;
        if(isPalindrome){
            result = "The word, " + word + ", is a palindrome.";
        }else{
            result = "The word, " + word + ", is not a palindrome.";
        }

        writer.write(result);

        writer.close();
        reader.close();
    }
}