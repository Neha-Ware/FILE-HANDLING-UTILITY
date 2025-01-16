
import java.io.BufferedReader;// Provides reading of characters from input stream
import java.io.BufferedWriter; // Provides writing of characters from input stream
import java.io.FileReader; // For reading character files
import java.io.FileWriter; // For writing character files
import java.io.IOException; // handling runtime exception

public class FileHandlingUtility {

    public static void main(String args[]) {
        String FileName = "Data.txt";

        // Writing a Data in Data.txt file
        String DataToWrite = "\nCODTECH IT SOLUTIONS PVT.LTD IT SERVICES & IT CONSULTING ";
        WritingFile(FileName, DataToWrite);

        // Readind a Data in Data.txt file
        System.out.println("This a File Data before modification:");
        ReadingFile(FileName);

        // Modifying a Data into Data.txt file
        String DataToModify = "**CODTECH IT SOLUTIONS PVT.LTD IT SERVICES & IT CONSULTING**";
        String newData = "**WELLCOME TO CODTECH IT INTERNSHIP PROGRAM**";
        modificationOfFile(FileName, DataToModify, newData);

        // Read the Data into file again to ensure the modification
        System.out.println("File Data doing after modification:");
        ReadingFile(FileName);
    }

    // Method to writing character from a text file
    public static void WritingFile(String FileName, String Data) {
        try (BufferedWriter writing = new BufferedWriter(new FileWriter(FileName))) {
            writing.write(Data);
            System.out.println(" writing a data into file done successfully.");
        } catch (IOException exc) {
            System.err.println("Error writing to file: " + exc.getMessage());
        }
    }

    // Method to reading character from a Data.text file
    public static void ReadingFile(String FileName) {
        try (BufferedReader reading = new BufferedReader(new FileReader(FileName))) {
            String line;
            while ((line = reading.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException exc) {
            System.err.println("Error reading from file: " + exc.getMessage());
        }
    }

    // Method to modification of character from a Data.text file
    public static void modificationOfFile(String FileName, String oldData, String newData) {
        try {
            // Read the original file data
            StringBuilder FileData = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new FileReader(FileName))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    FileData.append(line).append(System.lineSeparator());
                }
            }

            // Replace old data with new data
            String updatedData = FileData.toString().replace(oldData, newData);

            // Write the updated data back to the file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FileName))) {
                writer.write(updatedData);
                System.out.println("modification of file done successfully.");
            }
        } catch (IOException exc) {
             System.err.println("Error modifying file: " + exc.getMessage());

        }
    }
}
