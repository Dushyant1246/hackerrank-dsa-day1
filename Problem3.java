import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result3 {

    /*
     * Complete the 'makingAnagrams' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING s1
     *  2. STRING s2
     */

    public static int makingAnagrams(String s1, String s2) {
        // Write your code here
        Map<Character, Integer> freq = new HashMap<>();
        for(char c : s1.toCharArray()){
            if(freq.containsKey(c))
                freq.put(c, freq.get(c) + 1);
            else
                freq.put(c, 1);
        }
        int count = 0;
        for(char c : s2.toCharArray()){
            if(freq.containsKey(c)){
                int f = freq.get(c);
                if(f > 1)
                    freq.put(c, freq.get(c) - 1);
                else
                    freq.remove(c);
            }
            else
                count++;
        }
        for(int i : freq.values()){
            count += i;
        }
        return count;

    }

}

public class Problem3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s1 = bufferedReader.readLine();

        String s2 = bufferedReader.readLine();

        int result = Result3.makingAnagrams(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
