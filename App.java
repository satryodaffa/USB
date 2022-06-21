/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ScoutingMission;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Divka
 */
public class App {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Map<Integer, List<Integer>> gameMap = new HashMap<>();
        gameMap.put(0, Arrays.asList(1, 5, 7));
        gameMap.put(1, Arrays.asList(0, 2, 4, 6));
        
        int startingPoint = 0;
        List<Integer> path = findPath(gameMap, startingPoint);
        
        System.out.println(createPathString(path));
    }

    public static List<Integer> findPath(Map<Integer, List<Integer>> gameMap, int startingPoint) {
        List<Integer> moveOptions = gameMap.get(startingPoint);
        
        for(Integer option : moveOptions) {
            //fancy hamiltonian cycle algorithm here, possibly recursive?
        }
    }
    
    /**
     * takes the whole path like 0,1,5,7,4,2,.... and creates the output string like
     * 
     * Path found!
     * 0-->1-->5-->7-->4-->2
     * @param path
     * @return
     */
    public static String createPathString(List<Integer> path) {
        //TODO: case when no valid path 😅
        /* possibly with something like 
         * if(hasValidPath(gameMap, startingPoint)){
         *         // my StringBuilder Stuff
         * } else {
         *         return "No path found!"
         * }
         * 
         *  But I don't know how to solve the hamiltionian cycle. But I guess there is an easy way to know beforehand if it is solvable
         */
        StringBuilder stringBuilder = new StringBuilder(); //StringBuilder is faster when concatenating a lot of Strings, but you could do it with "+" too
        stringBuilder.append("Path found!\n");
        for(int i = 0; i < path.size(); i++) {
            stringBuilder.append(path.get(i));
            if(i < path.size()) {
                stringBuilder.append("-->");
            } 
        }
    }
}

