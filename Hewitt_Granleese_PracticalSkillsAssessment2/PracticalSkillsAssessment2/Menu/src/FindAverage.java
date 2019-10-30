
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author Kimberley Hewitt B00751100, Christopher Granleese B00751099.
 */
/* A Class to hold a method which will read in a file and .*/ 
public class FindAverage {
    
     /**
     * @throws java.io.FileNotFoundException
     */
    public void getAverage()throws FileNotFoundException {
        
    /*Read in a csv file with comma seperated values, create new file to use as 
      a parameter.*/
        String fileName = "marksFile.txt";
        File fileMarks = new File(fileName);
        
     
            /*Read the data from the contents of the csv file by using the 
            parameter (fileMarks)and surround with a try/catch block to catch 
            the exception that the file may not exist.*/
            try (Scanner inputStream = new Scanner(fileMarks)) {
                
                //Initialize values with zero.
                int sum = 0;
                
                //Initialize values with zero.
                int numberOfMarks = 0; 
                
                //Format the output to two decimal places.
                DecimalFormat df = new DecimalFormat("###.00");
               
                
                /*While there is data in the input stream retrieve this data, 
                  it gets the entire line from the csv file.*/
                while (inputStream.hasNext()){ 
                    String data = inputStream.next();
                    
                 /*The split method returns a string array. It splits the data 
                   string into an array of strings with the comma.
                   Takes a string parses into a integer value.*/
                    String[] values = data.split(",");
                    
                    /*Takes a string and parses it into an integer value and
                    and finds the second value in the array.*/
                    int studentMark = Integer.parseInt(values[1]);
                    
                    /*The sum plus the current Mark and increment the number of 
                    marks by 1. Then prints out the student marks.*/ 
                    sum += studentMark; 
                    numberOfMarks++;
                    System.out.println(studentMark); 
                }
                //Close the input stream.
                inputStream.close();
                
                /*The sum divided by the number of Marks to calculate the average
                  formatted to two decimal places.*/
                System.out.println("\n The average of the Student's Marks equals: " + df.format(sum / + numberOfMarks)); 
            }catch (IOException e){
        }
    }
}
    
