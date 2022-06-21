/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Project2_3_1;
import java.util.Collections;
import java.util.PriorityQueue;
/**
 *
 * @author Satryo
 */
public class KillingPriority {
    public static void main(String[] args) {
    PriorityQueue<TitanData> titanDataQueue = new PriorityQueue<>(Collections.reverseOrder());
    titanDataQueue.add(new TitanData (1, 15, 2, 30, "Not Repeated pattern", "Can climb", "Normal", ""));
    titanDataQueue.add(new TitanData(4, 10, 2, 15, "Normal pattern", "Cannot climb", "Normal", ""));
    titanDataQueue.add(new TitanData(2, "Abnormal"));
    titanDataQueue.add(new TitanData(3, "One of nine titans"));
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
        System.out.println("Total distance moved: " + distance);
        System.out.println("Sequence to be killed: " + sequenceMoved);
    }
}