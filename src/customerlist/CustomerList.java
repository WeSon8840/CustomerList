/*
 *
 * The purpose of the program is to create a program to store a customer's name, address, 
   city, province and postal code to a CustomerList file for Discount Fly.
 */

package customerlist;
import java.io.*;
import javax.swing.*;

/**
 *
 * @author Gloria Song
 * Date : 22/10/2018
 */
public class CustomerList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        //Set the variables.
        String name, address, city, province, postcode = "";
        String myLine = "";
        String numberCustomers = "";
        String info;
        int numLine = 0;
        int numCustomers = 0;
        
        //Open the text file and attach a BufferedReader.
        BufferedReader readFile = new BufferedReader(new FileReader("CustomerList.txt"));
        
        //Read the CustomerList.txt and print it.
        while ((myLine = readFile.readLine()) != null){
            System.out.println(myLine);
        }
        
        readFile.close();
        
        
        //PrintWriter class is used to open a file for output
        PrintWriter fileOut = new PrintWriter(new FileWriter("CustomerList.txt",true));
        
        boolean isError = true;
        
        //User input
        while (isError){
            try{
                numberCustomers = JOptionPane.showInputDialog("How many customers would you like to input?");
                //Crash on non-integer inputs
                numCustomers = Integer.parseInt(numberCustomers);
                isError = false;
            }catch (NumberFormatException nfe) {
             //found an exception
             System.out.println("Please enter a integer");
             System.out.println(nfe);
        }
        
        //User input
        for(int i = 0; i < numCustomers; i++){
            name = JOptionPane.showInputDialog("What is the name of customer " + (i + 1) + "?");
            address = JOptionPane.showInputDialog("What is the address of customer " + (i + 1) + "?");
            city = JOptionPane.showInputDialog("What city does customer " + (i + 1) + " live in?");
            province = JOptionPane.showInputDialog("What province does the customer " + (i + 1) + " live in?");
            
            //Error guard the postal code
            isError = true;
            while(isError){
                postcode =  JOptionPane.showInputDialog("What is the post code of customer " + (i + 1) + "?" + "\n" + "(No space)");
                
                //check if enter a correct postcode
                if ((Character.isLetter(postcode.charAt(0))) && (Character.isDigit(postcode.charAt(1))) 
                       && (Character.isLetter(postcode.charAt(2))) && (Character.isDigit(postcode.charAt(3)))
                       && (Character.isLetter(postcode.charAt(4))) && (Character.isDigit(postcode.charAt(5))) ){
                    JOptionPane.showMessageDialog(null, "This is a correct post code, your information has now been saved to Customerist.");
                    isError = false;
                } else {
                    JOptionPane.showMessageDialog(null, "That is an incorrect postal code, pleas try again.");
                }
            }
            //Output directly to file
            fileOut.println("-------------------------------------");
            fileOut.println("Name: " + name + "\n" + "Address: " + address + "\n" 
                    + "City: " + city + "\n" + "Province: " + province + "\n" + "Post Code: " + postcode);
            
        }
        //The file must be closed after writing is complete
        fileOut.close();
    }
    
   }
}
