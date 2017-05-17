/**
 *
 * @author Scott Pantall
 */
import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.function.Function;
import static java.util.stream.Collectors.*;

public class Main {
    public static void main (String[] args) throws IOException {
        Path file = Paths.get(args[0]);
        BufferedReader buffer = Files.newBufferedReader(file);
        String line;
        
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            char[] digits = line.toCharArray();
            List<Integer> digitList = new ArrayList();
            
            // Change character array into an ArrayList of integers
            for(char digit : digits) {
                int i = Character.getNumericValue(digit);
                digitList.add(i);
            }
            
            happyNumber(digitList);         
        }
    }
    
    public static void happyNumber(List<Integer> digits) {
        int result = 0;
        Function<Integer, Integer> square = x -> x * x;
        
        System.out.println(digits);
        digits = digits.stream().map(square).collect(toList());
        System.out.println(digits);
        
        // Seperate result into individual digits
        // Square the digits
        // Add them together into result
        // Check to see if result == 1

    }
}
