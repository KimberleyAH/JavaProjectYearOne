
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;



/**
 *
 * @author Kimberley Hewitt B00751100, Christopher Granleese B00751099.
 */
/* A Class to hold three methods which will search through a file and edit 
a record which will be specified by the user.   */ 
public class EditStudentMark {

    /**
     *
     * @throws IOException
     */
    /* Method created to handle the variables as well as the creation of file 
    readers etc.    */
    public void EditMark() throws IOException{
        
        // Creating an Array list to store file conetents to the Array List.
        ArrayList<String> list = new ArrayList<String>();
        
        // Creating a scanner to read in the file. 
        Scanner fileReader = new Scanner(new File("marksFile.txt"));
        
        /* Using a while loop to read through the file, as long as it 
        has a ".nextLine()".    */
        while (fileReader.hasNextLine()){
            String records = fileReader.nextLine();
            list.add(records);
        }
        
        // Creating a scanner to read in User Input. 
        Scanner recordToEdit = new Scanner(System.in);
        
        // Prompting the user to enter data for the record they wish to edit.
        System.out.println("Enter Student ID and their corresponding mark that "
                + "you wish to edit.");
        
        // Converting the scanner input to string.
        String editData = recordToEdit.nextLine();
        
        /* Creating a scanner to read in User Input for the new record they wish
        to append into the file.    */
        Scanner recordAppend = new Scanner(System.in);
        
        // Prompting the user to enter data.
        System.out.println("Enter the Student ID and their new corresponding "
                + "mark.");
        
        // Converting the scanner input to string.
        String newData = recordAppend.nextLine();
        
        /* Pass the variables into the list to be updated to the file. */
        UpdateToFile(list, editData, newData);
        
        // Displaying the ArrayList to the user.
        System.out.println(list.toString());
        
        // Wrting the list back to the file.
        writeToFile(list);  
    }
    
    // Using an Array list to write the ArrayList conetents to the file.
    public static void writeToFile(ArrayList<String> list) {
        
        // Creating try/catch to catch exceptions.
        try {
            
            // Creating the writing path to the file through required writers.
            BufferedWriter writer = new BufferedWriter(new FileWriter("marksFile.txt"));
            
            // For loop to work through the list and writing it to the file.
            for (String x:list){
                writer.write(x);
                writer.newLine();
            } 
            // Closing the writer.
            writer.close();
        }
        
        catch(IOException e){
            e.getStackTrace();
        }
    }
    
    /* Method created to handle the search for the user input, as well as 
    formatting how the results will print out.*/
    public static void UpdateToFile(ArrayList<String> list, String search, String update) {
        
        /* Adding format using string, before printing the original list before.
        the edit occurs */
        System.out.println("\nThis is the list before deletion occurs: \n" + list.toString());
        
        // Creating for loop to read through file.
        for(int i = 0; i < list.size(); i++)
            
            /* Creating an IF statement to check each record until it finds a 
            match of the record the user has input. */
            if (list.get(i).equals(search)) {
                list.set(i, update);
                writeToFile(list);
                System.out.println("\nUpdate complete, this is the list after being updated: ");
        }
    } 
}
