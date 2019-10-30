
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Kimberley Hewitt B00751100, Christopher Granleese B00751099.
 */
/* This class controls all methods in relation to the menu .*/ 
public class Menu {
    
    //Instance variable exit equal to false so does not need a value.    
    boolean exit;

    /*The main argument calls an instance of the menu and is directed to run
    the menu*/
    public static void main(String[] args ) throws IOException
    
    {
        Menu menu = new Menu();
        menu.runMenu();
    }   
    
    /*A method to run the menu, it calls the method printHeader once and
      a while loop to say while we are not exiting the program call the 
      printMenu method./*
    */
    public void runMenu() throws IOException{
        printHeader();
        while(!exit){
            printMenu();
            
            /*Choices numbered with integers so we need to read in the user's
              choice from the method getInfo, to get the information we need 
            from the user regarding what selection they want to make.*/
            int choice = getInfo();
            performTask(choice); 
        } 
    }
    
    /*A private method that can only be called within this class that
     prints out a welcome header for the user to begin the
     programme.*/
    private void printHeader(){
        System.out.println("---------------------------------------");
        System.out.println("*              Welcome to             *");
        System.out.println("*              Chris's Program            *");
        System.out.println("---------------------------------------");   
    }
    
    /*A private method that can only be called within this class
      to print out the menu giving the user several options to choose
      from to complete different tasks.*/
    private void printMenu(){
        System.out.print("\n Please make a selection: \n");
        System.out.print("\n1) Display the full list of Student ID Numbers and Module Marks.\n");
        System.out.print("2) Enter a new record into the Marks File.\n");
        System.out.print("3) Edit a student's existing mark in the Marks File.\n");
        System.out.print("4) Delete an existing mark from the Marks File resulting in full record deletion.\n");
        System.out.print("5) Count the number of students in the Marks File.\n");
        System.out.print("6) Display the average module mark.\n");
        System.out.print("7) Display the maximum module mark.\n");
        System.out.print("8) Display the minimum module mark.\n");
        System.out.print("0) Exit the program.\n");
    }
    
    /*A method to return an integer. Integer set to negative 1 so it does
      not get confused with any menu options*/
    private int getInfo(){
        Scanner scan = new Scanner(System.in);
        int choice = -1;
        
        /*Use of a while loop to say while the choice is invalid print "Enter
          your choice" and while the user input is less than 0 or more 
          than 8 use a try/catch block to catch an exception such as reading in 
          a number with an issue with number format meaning an invalid choice will put
          out the statement "Invalid choice".*/
        while (choice < 0 || choice > 8){
            try {
               System.out.print("\nEnter your choice: ");
               choice = Integer.parseInt(scan.nextLine());
            }
            catch(NumberFormatException e){
                System.out.print("Invalid choice please select a number from the Menu.");       
            }
        }
        //Once user has put in a valid input, choice is returned.
        return choice;
    }
    /* A method to perform the task based on the choice, taking 
       in the int choice. A switch statement takes in each case based on
       the choice.*/   
    private void performTask(int choice) throws IOException {
        switch(choice){
            
            //If the choice is 0 exit is set to true and we exit the program.
            case 0:
             exit = true;
                System.out.println("Thank you for using our program!");
                break;
            
            /*If case is 1 it calls a method within a class to display a list
              of students and their marks. Then calls the redisplay menu method 
              to redisplay menu choices.*/
            case 1:
                {       
                    DisplayList listObject = new DisplayList();
                    listObject.showList(); 
                }
                ReDisplayMenu();
                break;
            
            /*If case is 2 it calls a method within a class to add a new record
              of a student and their mark. Then calls the redisplay menu method 
              to redisplay menu choices.*/
            case 2:
            {
                NewRecord recordObject = new NewRecord();
                recordObject.AddRecord();
            }
            ReDisplayMenu();
                break;
                
            /*If case is 3 it calls a method within a class to edit a record
              of a student's mark. Then calls the redisplay menu method 
              to redisplay menu choices.*/
            case 3:
            {
                EditStudentMark editObject = new EditStudentMark();
                editObject.EditMark();
            }
            ReDisplayMenu();
                break;
                
            /*If case is 4 it calls a method within a class to delete a record
              of a student and their mark. Then calls the redisplay menu method 
              to redisplay menu choices.*/
            case 4:
            {
                DeleteRecord deleteObject = new DeleteRecord();
                deleteObject.DeleteMark();
            }
            ReDisplayMenu();
                break;
                
           /*If case is 5 it calls a method within a class to count how many
             students are in the file. Then calls the redisplay menu method 
              to redisplay menu choices.*/
            case 5:
            { 
                StudentNum studentObject = new StudentNum();
                studentObject.studentCount();
            }
            ReDisplayMenu();
                break;
                
            /*If case is 6 it calls a method within a class to get the average
             of the student's marks. Then calls the redisplay menu method 
              to redisplay menu choices.*/
            case 6:
            {
                FindAverage averageObject = new FindAverage();
                averageObject.getAverage();
            }
            ReDisplayMenu();
            
            /*If case is 7 it calls a method within a class to get the maximum
             of the student's marks. Then calls the redisplay menu method 
              to redisplay menu choices.*/
            case 7:
            {
                FindMaximum maxObject = new FindMaximum();
                maxObject.getMaximum();
            }
            ReDisplayMenu();
                break;
                
             /*If case is 8 it calls a method within a class to get the minimum
             of the student's marks. Then calls the redisplay menu method 
              to redisplay menu choices.*/
            case 8:
            {   
                FindMinimum minObject = new FindMinimum();
                minObject.getMinimum();
            }
            ReDisplayMenu();
            
            /*Default prints out error as validation checks that input is
              valid and code is not broken*/
            default:
            {
                System.out.println("An unknown error has occurred!");
            }
    }
        
}
    /* A method to redisplay the menu. Giving the user the option of entering 'y'
       to redisplay the menu or 'n' to exit the program.*/ 
        private void ReDisplayMenu(){
            System.out.println("To redisplay the menu press 'y' or press 'n' to exit the menu.");
            
            Scanner y = new Scanner(System.in);
            
            String Yes = y.nextLine();
            
            /*if y equals yes then reprint method containing menu choices or
              if not exit the program*/
            if("y".equals(Yes)) {
            printMenu(); 
            }
            else
            {
                exit = true;
                System.out.println("Thank you for using our program!");
                    
                }
                
                
            }

    }


