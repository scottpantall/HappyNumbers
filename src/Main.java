/**
 *
 * @author Scott Pantall
 */
import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.function.Function;
import static java.util.stream.Collectors.*;
import static java.util.stream.Collectors.toList;

public class Main {
    public static void main (String[] args) throws IOException {
        Path file = Paths.get(args[0]);
        BufferedReader buffer = Files.newBufferedReader(file);
        String line;
        
        while ((line = buffer.readLine()) != null) {
            line = line.trim();        
            System.out.println(happyNumber(line));
        }
    }

    public static String happyNumber(String line) {
        String s = "1";
        
        if(line.equals(s)) {
            return s;
        }
        
        int result = 0;
        
        char[] digits = line.toCharArray();
        List<Integer> digitList = new ArrayList();
        Function<Integer, Integer> square = x -> x * x;

        // Change character array into an ArrayList of integers
        for(char digit : digits) {
            int i = Character.getNumericValue(digit);
            digitList.add(i);
        }

        // Square each number in the list`
        digitList = digitList.stream().map(square).collect(toList());

        // Add numbers together into a result
        for(int number : digitList) {
            result += number;
        }

        // Turn the the result into a string and return it
        s = Integer.toString(result);

        return happyNumber(s);
    }
}
