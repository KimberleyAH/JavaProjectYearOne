
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author Kimberley Hewitt B00751100, Christopher Granleese B00751099.
 */
public class FindMinimum {
     /**
     * @throws java.io.FileNotFoundException
     */
    public void getMinimum()throws FileNotFoundException {
        
        /*Read in a csv file with comma seperated values, create new file to use as 
          a parameter.*/
        String fileName = "marksFile.txt";
        File fileMarks = new File(fileName);
        
        /*Read the data from the contents of the csv file by using the 
          parameter (fileMarks)and surround with a try/catch block to catch 
          the exception that the file may not exist.*/
        try (Scanner inputStream = new Scanner(fileMarks)) { //Read the data from the contents of the csv file.
            
            //Initialize values with 101.
            int minMark = 101; 
            
            /*While there is data in the input stream retrieve this data, 
              it gets the entire line from the csv file.*/
            while (inputStream.hasNext()){ 
                String data = inputStream.next();
                
                /*The split method returns a string array. It splits the data 
                  string into an array of strings with the comma.
                  Takes a string parses into a integer value.*/
                String[] values = data.split(",");
                
                /*Takes a string parses into an integer value while the output
                 is a list of the students marks.*/
                int thisMark = Integer.parseInt(values[1]); 
                System.out.println(thisMark);
                
                /*If the current student mark is less than the minimum mark
                  then "thisMark" is passed to the minimum mark. This is
                  continued through each mark until the list is finished.*/
                if(thisMark < minMark){
                    minMark = thisMark;
                }
            }
            //Close the input stream.
            inputStream.close();
            
            //The system prints out the minimum mark.
                System.out.println("\n The minimum of the Student's Marks equals: " + minMark); //Prints out the minimum student mark.
        }catch (IOException e){
        }
    }
}

