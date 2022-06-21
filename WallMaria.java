/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project2_6;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Satryo
 */
public class WallMaria {
    public static void main(String[] args) {
        List<List<Integer>> wallMaria = new ArrayList<>();
        int maxIndex = 50;
        int weakestSpot = 0;
        int spotNumber = 0;
        int[] totalSpots = new int[maxIndex];
        
        // construct array list for every wall layer
        ArrayList<Integer> layer1 = new ArrayList<>();
        ArrayList<Integer> layer2 = new ArrayList<>();
        ArrayList<Integer> layer3 = new ArrayList<>();
        ArrayList<Integer> layer4 = new ArrayList<>();
        
        // add layers to the array list
        // layer 1
        layer1.add(2);
        layer1.add(4);
        layer1.add(7);
        wallMaria.add(layer1);
        // layer 2
        layer2.add(1);
        layer2.add(5);
        layer2.add(8);
        layer2.add(10);
        wallMaria.add(layer2);
        // layer 3
        layer3.add(3);
        layer3.add(6);
        layer3.add(7);
        layer3.add(9);
        wallMaria.add(layer3);
        // layer 4
        layer4.add(1);
        layer4.add(7);
        wallMaria.add(layer4);
        
        // print the layer edges
        for(int wm = 0; wm < wallMaria.size(); wm++)
        {   System.out.print("Layer " + (wm + 1) + " ");
        for(int l = 0; l < wallMaria.get(wm).size(); l++)
        {   System.out.print(" " + wallMaria.get(wm).get(l));
        totalSpots[wallMaria.get(wm).get(l)] = totalSpots[wallMaria.get(wm).get(l)] + 1;
        }
        System.out.println("");
        }
        
        for (int i = 0; i < totalSpots.length; i++) {
        
        // finding the wall's weakest spot
        if(weakestSpot <= totalSpots[i]){
        weakestSpot = totalSpots[i];
        spotNumber = i;
        }
        }
        System.out.println("");
        System.out.println("Counter Weakest spot: " + weakestSpot);
        System.out.println("Weakest spot: " + spotNumber);
        }        
    }
