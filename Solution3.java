import java.io.*;
import java.util.*;

public class Solution3 {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        Set<Set<String>> set = new HashSet<>();

        for(int i = 0 ; i < n ; i++){
            Set<String> pair = new HashSet<>();
            String[] pairArr = bufferedReader.readLine().trim().split(" ");
            pair.add(pairArr[0]);
            pair.add(pairArr[1]);
            set.add(pair);
            int result = set.size();
            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
