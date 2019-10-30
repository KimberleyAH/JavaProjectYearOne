
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Kimberley Hewitt B00751100, Christopher Granleese B00751099.
 */
public class StudentNum {
        /**
     * @throws java.io.FileNotFoundException
     */
    public void studentCount() throws FileNotFoundException {
        
    /*Read in a csv file with comma seperated values, create new file to use as 
      a parameter.*/
        String fileName = "marksFile.txt";
        File file = new File(fileName);
        
        /*Read the data from the contents of the csv file by using the 
          parameter (fileMarks)and surround with a try/catch block to catch 
          the exception that the file may not exist.*/
            try (Scanner inputStream = new Scanner(file)) {
                                
                //Initialize values with zero.
                int numberOfMarks = 0; 
        
                /*While there is data in the input stream retrieve this data, 
                  it gets the entire line from the csv file.*/ 
                while (inputStream.hasNext()){ 
                    String data = inputStream.next();
                    
                /*The split method returns a string array. It splits the data 
                  string into an array of strings with the comma.*/
                    String[] values = data.split(",");
                    
                  //Increment the current Mark by one.
                    numberOfMarks++;
                }
                //Close the input stream.
                inputStream.close();
                
                /*Print the number of student ID's and marks representing how 
                  many are in the file.*/ 
                System.out.println("The amount of Students ID's and Marks equals: " + (numberOfMarks)); 
            }
        } 
    }

