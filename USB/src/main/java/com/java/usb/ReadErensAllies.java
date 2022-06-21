/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project2_1;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.LinkedList;
/**
 *
 * @author Satryo
 */
public class ReadErensAllies {
    public static void main(String[] args) {
    // Read ErensAllies File
    Scanner inputStream = null;
    LinkedList<Allies> ReadErensAllies = new LinkedList<Allies>();
    try {
    inputStream = new Scanner(new FileInputStream("C:/Users/Satryo/Documents/FSKTM/Linkedlist/data.txt"));}
    
    catch (FileNotFoundException e) {
    System.out.println("File was not found"); }
    
    while (inputStream.hasNextLine()){
    String input = inputStream.nextLine();
    String[] Statistics = input.split("\s+"); // to convert string into array 
    ReadErensAllies.add(new Allies(Statistics[0] + " " + (Statistics[1]), 
                          Integer.parseInt(Statistics[2]), 
                          Integer.parseInt(Statistics[3]),
                          Integer.parseInt(Statistics[4]),
                          Integer.parseInt(Statistics[5]),
                          Integer.parseInt(Statistics[6]),
                          Integer.parseInt(Statistics[7]),
                          Integer.parseInt(Statistics[8])));
    }
    inputStream.close();
        for (Allies ReadErensAlly : ReadErensAllies) {
        ReadErensAlly.display();
        System.out.println(" ");
        }
  }
}