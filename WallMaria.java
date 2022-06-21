/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FinalProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Nayatama
 */

public class WallMaria {
    public static void weakLayer() throws IOException {
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
        
        BufferedReader bi = new BufferedReader(
            new InputStreamReader(System.in));
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of layers: ");
        int layers = sc.nextInt();
        for(int i = 1; i-1 < layers; i++){
            System.out.print("Enter brick edges of layer " + i + ": ");
            String[] strNums = bi.readLine().split(" ");
            for (int j = 0; j < strNums.length; j++) {
                switch(i){
                    case 1:
                        layer1.add(Integer.parseInt(strNums[j]));
                        break;
                    case 2:
                        layer2.add(Integer.parseInt(strNums[j]));
                        break;
                    case 3:
                        layer3.add(Integer.parseInt(strNums[j]));
                        break;
                    case 4:
                        layer4.add(Integer.parseInt(strNums[j]));
                        break;
                }
            }
            if(i == 1){
                wallMaria.add(layer1);
            }
            else if(i == 2){
                wallMaria.add(layer2);
            }
            else if(i == 3){
                wallMaria.add(layer3);
            }
            else{
                wallMaria.add(layer4);
            } 
        }
        
        // print the layer edges
        for(int wm = 0; wm < wallMaria.size(); wm++)
        {   System.out.print("Layer " + (wm + 1) + ": ");
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
//        System.out.println("Counter Weakest spot: " + weakestSpot);
        System.out.println("Weakest part of the wall is at postion " + spotNumber);
        }
    
}
