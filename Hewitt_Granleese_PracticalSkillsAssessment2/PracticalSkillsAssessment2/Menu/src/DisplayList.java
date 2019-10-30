import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Kimberley Hewitt B00751100, Christopher Granleese B00751099.
 */
/* A Class to hold a method which will search through a file and display 
all records.*/ 
public class DisplayList {
        
        /**
         * *@param args the command line arguments
     * @throws java.io.IOException
         */

public void showList() throws IOException {
        // Crating variable to hold file name.
        String fileName = "marksFile.txt";
        
        // Initialising the variable line as a string.
        String line;
        
        // Creating a new ArrayList as aList.
        ArrayList aList = new ArrayList();
        
        // Creating a try catch to hold the if statement.
        try {
            try(BufferedReader input = new BufferedReader(new FileReader(fileName))) {
                
                // If statement to control exception.
                if (!input.ready()) {
                    throw new IOException();
                }
                
                // While loop to pass file data into "aList".
                while ((line = input.readLine()) != null) {
                    aList.add(line);
                }
            }
        // Creating catch to be throw exception and not break program.
        } catch (IOException e) {
            System.out.println(e);
        }
        
        // Creating a variable to hold the size of the aList. 
        int sz = aList.size();
        
        // For loop to work through "aList".
        for (int i = 0; i < sz; i++) {
            
            // Printing each seperate record within the array to a string.
            System.out.println(aList.get(i).toString());
        } 
    }
}

