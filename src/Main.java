import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Insert the .CSV file full path:");
        String path = sc.nextLine();

        Map<String, Integer> voting = new TreeMap<>();

        try(BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();
            while (line != null){
                String[] fields = line.split(",");
                String candidate = fields[0];
                int votes = Integer.parseInt(fields[1]);

                if (voting.containsKey(candidate)){
                    int countVotes = voting.get(candidate);
                    voting.put(candidate,votes + countVotes);
                } else {
                    voting.put(candidate, votes);
                }

                line = br.readLine();
            }

            for (String key : voting.keySet()){
                System.out.println(key + ": " + voting.get(key));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        sc.close();
    }
}