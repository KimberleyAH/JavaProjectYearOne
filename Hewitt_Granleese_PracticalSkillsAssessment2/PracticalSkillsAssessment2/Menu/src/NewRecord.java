
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 *
 * @author Kimberley Hewitt B00751100, Christopher Granleese B00751099.
 */
/* A Class to hold a method which take user input to add a new Student
B number and module mark and confirm the addition of the record to the file 
to the user.*/ 
public class NewRecord {
    /**
     * @throws java.io.IOException
     */
    public void AddRecord() throws IOException {
        
        // Creating new Scanner class to take input from User.       
        Scanner input = new Scanner(System.in);
        
        // Iniating the scanner as a string.
        String BCodeData;
        System.out.println("Please enter the 'B' number: ");
        BCodeData = input.nextLine();
        
        String MarkData;
        System.out.println("Please enter the students mark: ");
        MarkData = input.nextLine();
        
        // Creating variable to handle file.
        File file = new File("marksFile.txt");
        
        PrintWriter pw;
        try ( // Creating writers to handle the appending to the file.
            FileWriter fw = new FileWriter(file, true)) {
            pw = new PrintWriter(fw);
            // Using the printwriter to add the new string to the file.
            pw.println(BCodeData + "," + MarkData );
            // Append comformation
            System.out.println("Append complete.");
            // Closing file
        }
        pw.close();
    }
           
}
