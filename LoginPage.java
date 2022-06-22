package FinalProject;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Haqimi
 */
public class LoginPage {
    public static void runLoginPage() {
        Scanner sc = new Scanner(System.in);
        System.out.println("==========================================================================================");
        System.out.println("||                           Welcome to the World of Titan!                             ||");
        System.out.println("==========================================================================================");
        System.out.println("|| What would you like to do today?                                                     ||");
        System.out.println("||  1. See Eren's Allies                                                                ||");
        System.out.println("||  2. See Soldiers Arrangement and Grouping                                            ||");
        System.out.println("||  3. Check Titan Evaluation and Killing priority                                      ||");
        System.out.println("||  4. Scouting mission inside the Wall                                                 ||");
        System.out.println("||  5. Check the best path to kill Titans                                               ||");
        System.out.println("||  6. Convert a Marley sentence to Paradis                                             ||");
        System.out.println("||  7. Check weakest part of the Wall of Maria                                          ||");
        System.out.println("||                                                                                      ||");
        System.out.println("||                         *NOTE: You can enter \"0\" to exit*                            ||");
        System.out.println("==========================================================================================");
        System.out.print("Input any number stated above to continue: ");
        String instructionNum = sc.nextLine();
        while (!isValidInstruction(instructionNum)){
            System.out.print("Please enter a valid instruction: ");
            instructionNum = sc.nextLine(); 
        }
        carrySpecificInstruction(instructionNum);
    }
    
    public static boolean isValidInstruction(String instructionNum){
        if(instructionNum.equals("0")
            || instructionNum.equals("1")
            || instructionNum.equals("2")
            || instructionNum.equals("3")
            || instructionNum.equals("4")
            || instructionNum.equals("5")
            || instructionNum.equals("6")
            || instructionNum.equals("7")){
            return true;
        }
        return false;
    }
    
    public static void carrySpecificInstruction(String instructionNum){
        switch(instructionNum){
            case "0":
                System.out.println("\n");
                System.out.println("See you next time! Have a good day!");
                System.out.println();
                System.exit(0);
            case "1":
                ReadErensAllies.erenAllies();
                break;
            case "2":
                SortingSearching.soldierArrangementGrouping();
                break;
            case "3":
                KillingPriority.killPriority();
                break;
            case "4":
                ScoutingMission.scoutingMission();
                break;
            case "5":
                BestPath.bestPath();
                break;
            case "6":
                Converter.convert();
                break;
            case "7":
            {
                try {
                    WallMaria.weakLayer();
                } catch (IOException ex) {
                    Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break;
        }
    }
}
