/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project2_1;
import java.text.DecimalFormat;
/**
 *
 * @author Satryo
 */
public class Allies implements Comparable<Allies> {
    public String name;
       public int height;		
       public int weight;
       public int strength;
       public int agility;
       public int intelligence;
       public int coordination;
       public int leadership;
       DecimalFormat formatter = new DecimalFormat("#0.00");
       
       public Allies(){  
       }
       
       public Allies(String name){  
       setName(name);
       }
       
       public Allies(String name,int height) {
       setName(name);
       setHeight(height);
       }
       
       public Allies(String name,int height,int weight) {
       setName(name);
       setHeight(height);
       setWeight(weight);  
       }
       
       public Allies(String name,int height,int weight,int strength,
       int agility,int intelligence,int coordination,int leadership) {
       setName(name);
       setHeight(height);
       setWeight(weight);
       setStrength(strength);
       setAgility(agility);
       setIntelligence(intelligence);
       setCoordination(coordination);
       setLeadership(leadership);    
       }
 
       public void setHeight(int Alliesheight){ 
       height = Alliesheight;
       }   
       
       public int getHeight() { 
       return height;
       }    
       
       public void setName(String Alliesname){ 
       name = Alliesname;
       }    
       
       public String getName() {
       return name;
       }     
       
       public void setWeight(int Alliesweight) { 
       weight = Alliesweight;
       }    
       
       public int getWeight() {
       return weight;
       }     
       
       public void setStrength(int Alliesstrength){
       strength = Alliesstrength;
       }    
       
       public int getStrength() {
       return strength;
       }     
       
       public void setAgility(int Alliesagility) { 
       agility = Alliesagility;
       }    
       
       public int getAgility() {
       return agility;
       }     
       
       public void setIntelligence(int Alliesintelligence) {
       intelligence = Alliesintelligence;
       }    
       
       public int getIntelligence() { 
       return intelligence;
       }
       
       public void setCoordination(int Alliescoordination) {
       coordination = Alliescoordination;
       }    
       
       public int getCoordination() { 
       return coordination;
       }
       
       public void setLeadership(int Alliesleadership) {
       leadership = Alliesleadership;
       }    
       
       public int getLeadership() { 
       return leadership;
       }
       
       public void display(){
       System.out.println("Name: " + name);
       System.out.println("Height: " + height);
       System.out.println("Weight: " + weight);
       System.out.println("Strength: " + strength);
       System.out.println("Agility: " + agility);
       System.out.println("Intelligence: " + intelligence);
       System.out.println("Coordination: " + coordination);
       System.out.println("Leadership: " + leadership);
       }

       public void specificDisplay(String attributes){
       System.out.println("Name: " + name);
       if(attributes.equals("Strength")){
           System.out.println("Strength: " + strength);
       }
       if(attributes.equals("Height")){
           System.out.println("Height: " + height);
       }
       if(attributes.equals("Weight")){
           System.out.println("Weight: " + weight);
       }
       if(attributes.equals("Agility")){
           System.out.println("Agility: " + agility);
       }
       if(attributes.equals("Intelligence")){
           System.out.println("Intelligence: " + intelligence);
       }
       if(attributes.equals("Coordination")){
           System.out.println("Coordination: " + coordination);
       }
       if(attributes.equals("Leadership")){
           System.out.println("Leadership: " + leadership);
       }
}
       
    @Override
    public int compareTo(Allies o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}