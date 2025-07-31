package wipro;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Wipro_43 {

    public static void main(String[] args) {
        String filePath = "sample.txt"; // Make sure this file exists in your project folder

        // Try-with-resources ensures automatic closing of BufferedReader
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            System.out.println("Reading contents of file: " + filePath);
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("An error occurred while reading the file:");
            e.printStackTrace();
        }
    }
}
