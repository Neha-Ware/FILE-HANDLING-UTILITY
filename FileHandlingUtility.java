
import java.io.BufferedReader; // Provides reading of characters from input stream
import java.io.BufferedWriter; // Provides writing of characters from output stream
import java.io.FileReader; // For reading character files
import java.io.FileWriter; // For writing character files
import java.io.IOException; // Handling runtime exceptions

public class FileHandlingUtility {

    public static void main(String[] args) {
        String fileName = "Data.txt";

        // Writing data to Data.txt file
        String dataToWrite = "\nCODTECH IT SOLUTIONS PVT.LTD IT SERVICES & IT CONSULTING ";
        writeFile(fileName, dataToWrite);

        // Reading data from Data.txt file
        System.out.println("This is the file data before modification:");
        readFile(fileName);

        // Modifying data in Data.txt file
        String dataToModify = "CODTECH IT SOLUTIONS PVT.LTD IT SERVICES & IT CONSULTING";
        String newData = "WELCOME TO CODTECH IT INTERNSHIP PROGRAM";
        modifyFile(fileName, dataToModify, newData);

        // Read the data from the file again to ensure the modification
        System.out.println("File data after modification:");
        readFile(fileName);
    }

    // Method to write characters to a text file
    public static void writeFile(String fileName, String data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(data);
            System.out.println("Writing data into file done successfully.");
        } catch (IOException exc) {
            System.err.println("Error writing to file: " + exc.getMessage());
        }
    }

    // Method to read characters from a text file
    public static void readFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException exc) {
            System.err.println("Error reading from file: " + exc.getMessage());
        }
    }

    // Method to modify characters in a text file
    public static void modifyFile(String fileName, String oldData, String newData) {
        try {
            // Read the original file data
            StringBuilder fileData = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    fileData.append(line).append(System.lineSeparator());
                }
            }

            // Replace old data with new data
            String updatedData = fileData.toString().replace(oldData, newData);

            // Write the updated data back to the file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
                writer.write(updatedData);
                System.out.println("Modification of file done successfully.");
            }
        } catch (IOException exc) {
            System.err.println("Error modifying file: " + exc.getMessage());
        }
    }
}
