package wipro;

import java.io.*;
import java.util.*;

public class Wipro_37 {

    public static void main(String[] args) {
        String filename = "batchmates.txt";

        // Sample list of batchmates
        List<String> batchmates = Arrays.asList(
            "Manikumar",
            "Rahul",
            "Priya",
            "Anjali",
            "Kiran"
        );

        // Write to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (String name : batchmates) {
                writer.write(name);
                writer.newLine();
            }
            System.out.println("Batchmates list written to " + filename);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

        // Read from the file and display
        System.out.println("\nBatchmates list:");
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("- " + line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
/*Batchmates list written to batchmates.txt

Batchmates list:
- Manikumar
- Rahul
- Priya
- Anjali
- Kiran
*/