/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package customerlist;
import java.io.*;
import javax.swing.*;

/**
 *
 * @author glSon8840
 */
public class CustomerList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
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
        
        PrintWriter fileOut = new PrintWriter(new FileWriter("CustomerList.txt",true));
        
        boolean isError = true;
        
        while (isError){
            try{
                numberCustomers = JOptionPane.showInputDialog("How many customers would you like to input?");
                numCustomers = Integer.parseInt(numberCustomers);
                isError = false;
            }catch (Exception e){
                JOptionPane.showInputDialog("Please enter a integer");
            }
        }
        
        for(int i = 0; i < numCustomers; i++){
            name = JOptionPane.showInputDialog("What is the name of customer " + (i + 1) + "?");
            address = JOptionPane.showInputDialog("What is the address of customer " + (i + 1) + "?");
            city = JOptionPane.showInputDialog("What city does customer " + (i + 1) + "live in?");
            province = JOptionPane.showInputDialog("What province does the customer " + (i + 1) + "live in?");
        }
        
       
    }
    
}
