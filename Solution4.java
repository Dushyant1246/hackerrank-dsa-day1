import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution4 {

    // Complete the countTriplets function below
    static long countTriplets(List<Long> arr, long r) {
        Map<Long, Long> potentialPairs = new HashMap<>();
        Map<Long, Long> potentialTriplets = new HashMap<>();
        long count = 0;

        for (Long val : arr) {
            count += potentialTriplets.getOrDefault(val, 0L);

            if (potentialPairs.containsKey(val)) {
                long freq = potentialPairs.get(val);
                potentialTriplets.put(val * r, potentialTriplets.getOrDefault(val * r, 0L) + freq);
            }

            potentialPairs.put(val * r, potentialPairs.getOrDefault(val * r, 0L) + 1);
        }

        return count;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        long ans = countTriplets(arr, r);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
