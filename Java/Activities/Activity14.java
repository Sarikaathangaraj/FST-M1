import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class Activity14_main {
    public static void main(String[] args) {
        try {
            // Step 1: Create a new file using File class
            File file = new File("sample.txt");
            boolean fStatus = file.createNewFile(); // Creates a new file

            if (fStatus) {
                System.out.println("File created successfully: " + file.getName());
            } else {
                System.out.println("File already exists: " + file.getName());
            }

            // Step 2: Write some text into the file
            String content = "Hello, this is a test file for Activity 14.";
            FileUtils.writeStringToFile(file, content, "UTF8");
            System.out.println("Data written to file successfully.");

            // Step 3: Read data from the file
            String fileData = FileUtils.readFileToString(file, "UTF8");
            System.out.println("Data in file: " + fileData);

            // Step 4: Create a new directory named "destDir"
            File destDir = new File("destDir");
            destDir.mkdir();
            System.out.println("Directory created: " + destDir.getName());

            // Step 5: Copy the text file into the new directory
            FileUtils.copyFileToDirectory(file, destDir);
            System.out.println("File copied to directory successfully.");

            // Step 6: Get the file from the new directory
            File newFile = FileUtils.getFile(destDir, "sample.txt");

            // Step 7: Read data from the copied file
            String newFileData = FileUtils.readFileToString(newFile, "UTF8");
            System.out.println("Data from copied file: " + newFileData);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}