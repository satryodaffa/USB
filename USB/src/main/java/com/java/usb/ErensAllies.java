/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project2_1;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Satryo
 */
public class ErensAllies {
    public static void main(String[] args) {
    // input the characters' statistics
        String[][] Statistics = {{"Reiner Braun", "185", "95", "9", "7", "7", "10", "8"}, 
                                 {"Armin Arlert", "163", "55", "2", "6", "10", "8", "8"},
                                 {"Annie Leonhart", "153","54", "10", "7", "7", "3", "1"},
                                 {"Bertholdt Hoover", "192", "81", "9", "4", "6", "9", "2"},
                                 {"Jean Kristein", "175", "65", "9", "8", "7", "5", "9"},
                                 {"Sasha Blouse", "165", "55", "6", "3", "5", "6", "7"},
                                 {"Connie Springer", "158", "58", "6", "7", "3", "7", "5"},
                                 {"Mikasa Ackerman", "170", "68", "10", "9", "8", "6", "7"},
                                 {"Eren Yeager", "170", "63", "9", "10", "3", "5", "10"},
                                 {"Historia Reiss", "145", "42", "4", "8", "7", "6", "5"},
                                 {"Levi Ackerman", "160", "65", "12", "12", "7", "8", "8"},
                                 {"Erwin Smith", "188", "92", "8", "8", "11", "10", "12"},
                                 {"Hange Zoë", "170", "60", "9", "9", "12", "7", "11"}};
    PrintWriter outputStream = null;
    
    // data.txt
    try {
        outputStream = new PrintWriter(new FileOutputStream("C:/Users/Satryo/Documents/FSKTM/Linkedlist/data.txt"));
        }   
    catch (FileNotFoundException ex) {
        Logger.getLogger(ReadErensAllies.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    // print names
    for(int alliesIndex = 0; alliesIndex < Statistics.length; alliesIndex++){   
    System.out.println("Enter Name: " + Statistics[alliesIndex][0]);
    String characteristics = "";
    
    // print characteristics
    for(int charaIndex = 1; charaIndex < Statistics[alliesIndex].length; charaIndex++){
    characteristics = characteristics + Statistics[alliesIndex][charaIndex] + " "; 
    }
    System.out.println("Enter Characteristics: " + characteristics);
    outputStream.println(Statistics[alliesIndex][0] + " " + characteristics);
    }
    outputStream.close();
  }
}