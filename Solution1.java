import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result1 {

    /*
     * Complete the 'checkMagazine' function below.
     *
     * The function accepts following parameters:
     *  1. STRING_ARRAY magazine
     *  2. STRING_ARRAY note
     */

    public static void checkMagazine(List<String> magazine, List<String> note) {
        // Write your code here
        HashMap<String, Integer> hashMap = new HashMap<>();
        for(String word: magazine){
            if(hashMap.containsKey(word))
                hashMap.put(word, hashMap.get(word) + 1);
            else hashMap.put(word, 1);
        }
        for(String word: note){
            if(hashMap.containsKey(word) && hashMap.get(word) > 0){
                hashMap.put(word, hashMap.get(word) - 1);
            }else{
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }

}

public class Solution1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(firstMultipleInput[0]);

        int n = Integer.parseInt(firstMultipleInput[1]);

        List<String> magazine = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .collect(toList());

        List<String> note = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .collect(toList());

        Result1.checkMagazine(magazine, note);

        bufferedReader.close();
    }
}
