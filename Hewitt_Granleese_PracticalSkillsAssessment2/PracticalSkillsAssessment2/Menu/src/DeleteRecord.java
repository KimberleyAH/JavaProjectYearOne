
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kimberley Hewitt B00751100, Christopher Granleese B00751099.
 */
    /* A Class to hold three methods which will search through a file and delete 
a record which will be specified by the user.   */ 
public class DeleteRecord {
    
    /* Method created to handle the variables as well as the creation of file 
    readers etc.    */
    public void DeleteMark() throws IOException{
        
        // Creating an Array list to store file conetents to the Array List.
        ArrayList<String> list = new ArrayList<String>();
        
        // Creating a scanner to read in the file. 
        Scanner reader = new Scanner(new File("marksFile.txt"));
        
        /* Using a while loop to read through the file, as long as it 
        has a ".nextLine()".    */
        while (reader.hasNextLine()){
            String record = reader.nextLine();
            list.add(record);
        }
        
        // Creating a scanner to read in User Input. 
        Scanner recordToDelete = new Scanner(System.in);
        
        // Prompting the user to enter data for the record they wish to delete.
        System.out.println("Enter Student ID and their corresponding mark that "
                + "you wish to delete.");
        
        // Converting the scanner input to string.
        String deleteData = recordToDelete.nextLine();
        
        /* Pass the variables into the list to deleted to the file. */
        deleteFromFile(list, deleteData);
        
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
    public static void deleteFromFile(ArrayList<String> list, String search) {
        
        /* Adding format using string, before printing the original list before.
        the delete occurs */
        System.out.println("\nThis is the list before deletion occurs: \n" + list.toString());
        
        // Creating for loop to read through file.
        for(int i = 0; i < list.size(); i++)
            
            /* Creating an IF statement to check each record until it finds a 
            match of the record the user has input. */
            if (list.get(i).equals(search)) {
                list.remove(i);
                writeToFile(list);
                System.out.println("\nDeletion complete, this is the list after being updated: ");
        }
    }
}
