/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FinalProject;
// 2.2 Soldiers Arrangement and Grouping

import FinalProject.Allies;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.ArrayList;
/**
 *
 * @author Haqimi
 */
public class SortingSearching {
    // Binary Search
   public String binarySearch(LinkedList<Allies> list, int key, String attributes) {
        int low = 0;
        int high = list.size() - 1;
        ArrayList<Allies> index = new ArrayList();
        String names = "";
        int tempValue = 0;
        int countDuplicateValue = 0;
        
        for (Allies allies : list) {
            if ((attributes.equals("Agility") && key == allies.getAgility())
                    || (attributes.equals("Strength") && key == allies.getStrength())
                    || (attributes.equals("Height") && key == allies.getHeight())
                    || (attributes.equals("Weight") && key == allies.getWeight())
                    || (attributes.equals("Coordination") && key == allies.getCoordination())
                    || (attributes.equals("Intelligence") && key == allies.getIntelligence())
                    || (attributes.equals("Leadership") && key == allies.getLeadership())) {
                countDuplicateValue++;
            }

        }

        while (high >= low) {
            int mid = (low + high) / 2;
            if (attributes.equals("Agility")) {
                tempValue = list.get(mid).getAgility();
            } 
            else if (attributes.equals("Strength")) {
                tempValue = list.get(mid).getStrength();
            } 
            else if (attributes.equals("Height")) {
                tempValue = list.get(mid).getHeight();
            } 
            else if (attributes.equals("Weight")) {
                tempValue = list.get(mid).getWeight();
            } 
            else if (attributes.equals("Coordination")) {
                tempValue = list.get(mid).getCoordination();
            } 
            else if (attributes.equals("Intelligence")) {
                tempValue = list.get(mid).getIntelligence();
            } 
            else if (attributes.equals("Leadership")) {
                tempValue = list.get(mid).getLeadership();
            }
            if (key < tempValue) {
                low = mid + 1;
            } else if (key == tempValue) {
                index.add(list.get(mid));
                //re-search again if still have value same as key inside the list
                list.remove(mid);
                if (countDuplicateValue == 0) {
                    break;
                } else {
                    countDuplicateValue--;
                    low = 0;
                    high = list.size() - 1;
                }
            } else {
                high = mid - 1;
            }
    }
        
    for (int i = 0; i < index.size(); i++) {
            if (i == index.size() - 1) {
                names = names + index.get(i).getName();
            } 
            else {
                names = names + index.get(i).getName() + ", ";
            }
        }
        return names;
    }
   
    public static void soldierArrangementGrouping() {
    SortingSearching sortingSearchingTwo = new SortingSearching();
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
    
    // Linked List
    LinkedList<Allies> allies = new LinkedList<Allies>();
    
    // print names
    for(int alliesIndex = 0; alliesIndex < Statistics.length; alliesIndex++){   
    // System.out.println("Enter Name: " + Statistics[alliesIndex][0]);
    String characteristics = "";
    
    // print characteristics
    for(int charaIndex = 1; charaIndex < Statistics[alliesIndex].length; charaIndex++){
    characteristics = characteristics + Statistics[alliesIndex][charaIndex] + " "; }
    // System.out.println("Enter Characteristics: " + characteristics);
    // System.out.println(" ");
    
    // Add allies to Linked List & Convert from String to integer
    allies.add(new Allies(Statistics[alliesIndex][0], 
                          Integer.parseInt(Statistics[alliesIndex][1]), 
                          Integer.parseInt(Statistics[alliesIndex][2]),
                          Integer.parseInt(Statistics[alliesIndex][3]),
                          Integer.parseInt(Statistics[alliesIndex][4]),
                          Integer.parseInt(Statistics[alliesIndex][5]),
                          Integer.parseInt(Statistics[alliesIndex][6]),
                          Integer.parseInt(Statistics[alliesIndex][7])));
   }
   
   // Sort the Characters' Attributes
//   System.out.println(" ");
   Scanner inputString = new Scanner(System.in);
   System.out.print("Enter Attribute: ");
   String characters = inputString.next();
//   System.out.println(characters);
   
   // Strength
   if(characters.equals("Strength")){
   Collections.sort(allies, new Comparator<Allies>() {
            @Override
            public int compare(Allies o1, Allies o2) {
                return o2.getStrength() - o1.getStrength();
            }
        });
   for (Allies allyStrength : allies) {
   allyStrength.specificDisplay(characters); 
   System.out.println(" "); }
   }
   
   // Height
   if(characters.equals("Height")){
       Collections.sort(allies, new Comparator<Allies>() {
            @Override
            public int compare(Allies o1, Allies o2) {
                return o2.getHeight() - o1.getHeight();
            }
        });
   for (Allies allyHeight : allies) {
   allyHeight.specificDisplay(characters);  
   System.out.println(" "); }
   }
   
   // Weight
   if(characters.equals("Weight")){
        Collections.sort(allies, new Comparator<Allies>() {
            @Override
            public int compare(Allies o1, Allies o2) {
                return o2.getWeight() - o1.getWeight();
            }
        });
   for (Allies allyWeight : allies) {
   allyWeight.specificDisplay(characters); 
   System.out.println(" "); }
   }
   
   // Agility
   if(characters.equals("Agility")){
       Collections.sort(allies, new Comparator<Allies>() {
            @Override
            public int compare(Allies o1, Allies o2) {
                return o2.getAgility() - o1.getAgility();
            }
        });
   for (Allies allyAgility : allies) {
   allyAgility.specificDisplay(characters);  
   System.out.println(" "); }
   }
   
   // Intelligence
   if(characters.equals("Intelligence")){
       Collections.sort(allies, new Comparator<Allies>() {
            @Override
            public int compare(Allies o1, Allies o2) {
                return o2.getIntelligence() - o1.getIntelligence();
            }
        });
   for (Allies allyIntelligence : allies) {
   allyIntelligence.specificDisplay(characters);  
   System.out.println(" "); }
   }
   
   // Coordination
   if(characters.equals("Coordination")){
       Collections.sort(allies, new Comparator<Allies>() {
            @Override
            public int compare(Allies o1, Allies o2) {
                return o2.getCoordination() - o1.getCoordination();
            }
        });
   for (Allies allyCoordination : allies) {
   allyCoordination.specificDisplay(characters); 
   System.out.println(" "); }
   }
   
   // Leadership
   if(characters.equals("Leadership")){
       Collections.sort(allies, new Comparator<Allies>() {
            @Override
            public int compare(Allies o1, Allies o2) {
                return o2.getLeadership() - o1.getLeadership();
            }
        });
   for (Allies allyLeadership : allies) {
   allyLeadership.specificDisplay(characters); 
   System.out.println(" "); }
   }
   
   
   
   // Searching
   Scanner inputSearching = new Scanner(System.in);
   String names = "";
   LinkedList<String> namesComma = new LinkedList<String>();
   System.out.print("Finding ability: ");
   String attributes = inputSearching.next();
   
   Scanner inputValue = new Scanner(System.in);
   System.out.print("Value: ");
   int value = inputValue.nextInt();
   
   // Strength
   if(attributes.equals("Strength")){
   Collections.sort(allies, new Comparator<Allies>() {
            @Override
            public int compare(Allies o1, Allies o2) {
                return o2.getStrength() - o1.getStrength();
            }
        });
    names = sortingSearchingTwo.binarySearch(allies, value, attributes);
   }
   
   // Height
   if(attributes.equals("Height")){
       Collections.sort(allies, new Comparator<Allies>() {
            @Override
            public int compare(Allies o1, Allies o2) {
                return o2.getHeight() - o1.getHeight();
            }
        });
   names = sortingSearchingTwo.binarySearch(allies, value, attributes);
   }
   
   // Weight
   if(attributes.equals("Weight")){
        Collections.sort(allies, new Comparator<Allies>() {
            @Override
            public int compare(Allies o1, Allies o2) {
                return o2.getWeight() - o1.getWeight();
            }
        });
   names = sortingSearchingTwo.binarySearch(allies, value, attributes);
   }
   
   // Agility
   if(attributes.equals("Agility")){
       Collections.sort(allies, new Comparator<Allies>() {
            @Override
            public int compare(Allies o1, Allies o2) {
                return o2.getAgility() - o1.getAgility();
            }
        });
   names = sortingSearchingTwo.binarySearch(allies, value, attributes);
   }
   
   // Intelligence
   if(attributes.equals("Intelligence")){
       Collections.sort(allies, new Comparator<Allies>() {
            @Override
            public int compare(Allies o1, Allies o2) {
                return o2.getIntelligence() - o1.getIntelligence();
            }
        });
   names = sortingSearchingTwo.binarySearch(allies, value, attributes);
   }
   
   // Coordination
   if(attributes.equals("Coordination")){
       Collections.sort(allies, new Comparator<Allies>() {
            @Override
            public int compare(Allies o1, Allies o2) {
                return o2.getCoordination() - o1.getCoordination();
            }
        });
   names = sortingSearchingTwo.binarySearch(allies, value, attributes);
   }
   
   // Leadership
   if(attributes.equals("Leadership")){
       Collections.sort(allies, new Comparator<Allies>() {
            @Override
            public int compare(Allies o1, Allies o2) {
                return o2.getLeadership() - o1.getLeadership();
            }
        });
   names = sortingSearchingTwo.binarySearch(allies, value, attributes);
   }
   
   System.out.println("Soldier: " + names + " ");
   logout();
 }
    
    public static void logout(){
        Scanner sc = new Scanner(System.in);
        System.out.println("");
        System.out.println("What would you like to do next? (Enter \"1\" to check Soldiers Arrangement and Grouping again or \"0\" to go back to the Main Menu)/n");
        System.out.print("Input command: ");
        int in = sc.nextInt();
        if(in == 0){
             for (int i = 0; i < 50; ++i) 
                System.out.println();
            LoginPage.runLoginPage();
        }
        else if(in == 1){
            System.out.println();
            soldierArrangementGrouping();
        }
        else{
            System.out.println("Please enter a valid command!");
            logout();
        }
        
    }
}
