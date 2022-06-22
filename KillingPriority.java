/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package FinalProject;
// 2.3(1) Scouting Mission inside the Wall

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Scanner;
/**
 *
 *
 * @author Satryo
 */
public class KillingPriority {
    public static void killPriority() {
        // Array List of Titans
    List<Object> titanStats = new ArrayList<>();
    titanStats.add(new TitanData(1, 15, 2, 30, "Not Repeated pattern", "Can climb", "Normal", ""));
    titanStats.add(new TitanData(4, 15, 2, 30, "Not Repeated pattern", "Can climb", "Normal", ""));
    titanStats.add(new TitanData(2, "Abnormal"));
    titanStats.add(new TitanData(3, "One of nine titans"));
    titanStats.add(new TitanData(5, 7, 4, 8, "Repeated Pattern", "Cannot climb", "Normal", ""));
    titanStats.add(new TitanData(6, 5, 2, 15, "Not Repeated Pattern", "Can climb", "Normal", ""));
    titanStats.add(new TitanData(8, 20, 2, 12, "Normal Pattern", "Cannot climb", "Normal", ""));
    titanStats.add(new TitanData(7, 15, 2, 15, "Normal Pattern", "Cannot climb", "Normal", ""));
    titanStats.add(new TitanData(10, "One of nine titans"));
    titanStats.add(new TitanData(9, "Abnormal"));
    titanStats.add(new TitanData(12, 12, 4, 5, "Repeated Pattern", "Cannot climb", "Normal", ""));
    titanStats.add(new TitanData(11, 3, 2, 3, "Repeated Pattern", "Can climb", "Normal", ""));
    titanStats.add(new TitanData(13, 11, 0, 30, "Normal Pattern", "Cannot climb", "Normal", ""));
    titanStats.add(new TitanData(14, 14, 2, 14, "Normal Pattern", "Can climb", "Normal", ""));
    
    Scanner sc = new Scanner(System.in);
    Random rand = new Random();
    
    System.out.print("Number of Titans: ");
    int input = sc.nextInt();
    
        System.out.println();
        PriorityQueue<TitanData> titanDataQueue = new PriorityQueue<>();
        System.out.print("Generating "+ input + " Titans ....");
    for(int i = 0; i < input; i++){
        int r = rand.nextInt(13) +1;
        titanDataQueue.add((TitanData) titanStats.get(r));
//        TitanData D = titanDataQueue.peek();

    }
        System.out.println(); 
        
    TitanData td = titanDataQueue.peek();
    int distance = 0;
    int previousIndex = 0;
    String sequenceMoved = "";
    while ((td = titanDataQueue.poll())!= null) {
        System.out.println(td);
            if(titanDataQueue.size() == 0){
                sequenceMoved = sequenceMoved + "Titan " + td.getNumber();
            }
            else sequenceMoved = sequenceMoved + "Titan " + td.getNumber() + " --> ";
            distance = Math.abs((td.getNumber() - previousIndex)) + distance;
            previousIndex = td.getNumber();
        }
        System.out.println();
        System.out.println("Sequence to be killed: " + sequenceMoved);
        System.out.println("Total distance moved: " + distance);
        logout();
    }

     public static void logout(){
        Scanner sc = new Scanner(System.in);
        System.out.println("");
        System.out.println("What would you like to do next? (Enter \"1\" to see the Titan Evaluation and Killing Priority or \"0\" to go back to the Main Menu)/n");
        System.out.print("Input command: ");
        int in = sc.nextInt();
        if(in == 0){
             for (int i = 0; i < 50; ++i) 
                System.out.println();
            LoginPage.runLoginPage();
        }
        else if(in == 1){
            System.out.println();
            killPriority();
        }
        else{
            System.out.println("Please enter a valid command!");
            logout();
        }
        
    }
}
