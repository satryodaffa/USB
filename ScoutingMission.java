package FinalProject;
// 2.3(2) Scouting Mission insied the Wall

import java.util.Scanner;

/**
 *
 * @author PREDATOR
 */
public class ScoutingMission {
    final int totalVertex = 16; 
    int[] path;
 
    boolean isGood(int vertex, int graph[][], int[] path, int position) {
        if (graph[path[position - 1]][vertex] == 0)
            return false;
        
        for (int i = 0; i < position; i++)
            if (path[i] == vertex)
                return false;
        
        return true;
    }
 
    boolean hamiltonianCycleUtility(int[][] graph, int[] path, int position) {
        if (position == totalVertex) {
            if (graph[path[position - 1]][path[0]] == 1)
                return true;
            else
                return false;
        }
 
        for (int v = 0; v < totalVertex; v++) {
            if (isGood(v, graph, path, position)) {
                path[position] = v;
 
                if (hamiltonianCycleUtility(graph, path, position + 1) == true)
                    return true;
 
                path[position] = -1;
            }
        }
        return false;
    }
 
    int hamiltonianCycle(int[][] graph, int startingPoint) {
        path = new int[totalVertex];
        for (int i = 0; i < totalVertex; i++)
            path[i] = -1;
 
        path[0] = startingPoint;
        if (hamiltonianCycleUtility(graph, path, 1) == false) {
            System.out.println("\nNo path found. ");
            return 0;
        }
 
        displaySolution(path);
        return 1;
    }
 
    void displaySolution(int[] path) {
        System.out.println("\nPath found! ");
        for (int i = 0; i < totalVertex; i++)
            System.out.print(path[i] + "-->");
 
        System.out.println(path[0] + " ");
    }
    
    public static void scoutingMission() {
        Scanner Hc = new Scanner(System.in);
        System.out.print("Enter starting point : ");
        int startingPoint = Hc.nextInt();    
                   
        ScoutingMission sC = new ScoutingMission();

        int[][] paradisMap = {{0,1,0,0,0,1,0,1,0,0,0,0,0,0,0,0},
                        {1,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0},
                        {0,1,0,1,0,0,0,0,0,0,0,1,0,1,0,0},
                        {0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0},
                        {0,1,0,0,0,0,1,0,0,0,1,0,0,0,0,0},
                        {1,0,0,0,0,0,1,1,0,0,0,0,1,0,0,0},
                        {0,1,0,0,1,1,0,0,1,0,0,0,0,0,0,1},
                        {1,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0},
                        {0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0},
                        {0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,1},
                        {0,0,0,1,1,0,0,0,1,0,0,0,0,0,1,0},
                        {0,0,1,0,0,0,0,0,0,0,0,0,0,1,0,0},
                        {0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0},
                        {0,0,1,0,0,0,0,0,0,0,0,1,0,0,1,0},
                        {0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,1},
                        {0,0,0,0,0,0,1,0,0,1,0,0,0,0,1,0}};
        sC.hamiltonianCycle(paradisMap, startingPoint);
        logout();
    }
     public static void logout(){
        Scanner sc = new Scanner(System.in);
        System.out.println("");
        System.out.println("What would you like to do next? (Enter \"1\" to see the Scouting Mission Path again or \"0\" to go back to the Main Menu)/n");
        System.out.print("Input command: ");
        int in = sc.nextInt();
        if(in == 0){
             for (int i = 0; i < 50; ++i) 
                System.out.println();
            LoginPage.runLoginPage();
        }
        else if(in == 1){
            System.out.println();
            scoutingMission();
        }
        else{
            System.out.println("Please enter a valid command!");
            logout();
        }
        
    }
    
}
