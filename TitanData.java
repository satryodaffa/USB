/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FinalProject;
/**
 *
 * @author Satryo
 */
public class TitanData implements Comparable<TitanData> {
// attributes of the titans
private int number;
private int height;
private int walkingLegs;
private int runningSpeed;
private String walkingPattern;
private String climbingSkill;
private String abnormal = "";
private String nineTitan = "";
private Integer dangerRisk = 0;

// TitanData constructors
public TitanData(int number, int height, int walkingLegs, int runningSpeed,
String walkingPattern, String climbingSkill, String abnormal,
String nineTitan){
this.number = number;
this.setHeight(height);
this.setWalkingLegs(walkingLegs);
this.setRunningSpeed(runningSpeed);
this.setWalkingPattern(walkingPattern);
this.setClimbingSkill(climbingSkill);
this.setAbnormal(abnormal);
this.setNineTitan(nineTitan);
}

// if the titan is abnormal
public TitanData(int number, String abnormal){
this.number = number;
if(abnormal.equals("Abnormal")){
    this.setAbnormal(abnormal);
} 
    else this.setNineTitan(abnormal);
}

// completing the functions and inputing the data
public int getNumber(){
    return number;
}
public int getHeight(){
    return height;
}
public void setHeight(int height){
    this.height = height;
    // danger risk 3
    if(height > 20){
        this.setDangerRisk(this.dangerRisk + 3);
    }
    // danger risk 2
    else if(height > 10){
        this.setDangerRisk(this.dangerRisk + 2);
    }
    // danger risk 1
    else if(height < 10){
        this.setDangerRisk(this.dangerRisk + 1);
    }
}
public int getWalkingLegs(){
    return walkingLegs;
}
public void setWalkingLegs(int walkingLegs){
    this.walkingLegs = walkingLegs;
    // danger risk 3
    if(walkingLegs == 4){
        this.setDangerRisk(this.dangerRisk + 3);
    }
    // danger risk 2
    else if (walkingLegs == 2){
        this.setDangerRisk(this.dangerRisk + 2);
    }
    // danger risk 1
    if(walkingLegs == 0){
        this.setDangerRisk(this.dangerRisk + 1);
    }
}
public int getRunningSpeed(){
    return runningSpeed;
}
public void setRunningSpeed(int runningSpeed){
    this.runningSpeed = runningSpeed;
    // danger risk 3
    if(runningSpeed > 20){
        this.setDangerRisk(this.dangerRisk + 3);
    }
    // danger risk 2
    else if(runningSpeed > 10){
        this.setDangerRisk(this.dangerRisk + 2);
    }
    // danger risk 1
    else if(runningSpeed < 10){
        this.setDangerRisk(this.dangerRisk + 1);
    }
}
public String getWalkingPattern(){
    return walkingPattern;
}
public void setWalkingPattern(String walkingPattern){
    this.walkingPattern = walkingPattern;
    // danger risk 3
    if(walkingPattern.equals("Not Repeated pattern")){
        this.setDangerRisk(this.dangerRisk + 3);
    }
    // danger risk 2
    else if(walkingPattern.equals("Repeated pattern")){
        this.setDangerRisk(this.dangerRisk + 2);
    }
    // danger risk 1
    else if(walkingPattern.equals("Normal pattern")){
        this.setDangerRisk(this.dangerRisk + 1);
    }
}
public String getClimbingSkill(){
    return climbingSkill;
}
public void setClimbingSkill(String climbingSkill){
    this.climbingSkill = climbingSkill;
    // danger risk 3
    if(climbingSkill.equals("Can climb")){
        this.setDangerRisk(this.dangerRisk + 3);
    }
    // danger risk 1
    else if(climbingSkill.equals("Cannot climb")){
        this.setDangerRisk(this.dangerRisk + 1);
    }
}
public String getAbnormal(){
    return abnormal;
}
public void setAbnormal(String abnormal){
    this.abnormal = abnormal;
    // abnormal titan = danger risk 15
    if(abnormal.equals("Abnormal")){
        this.setDangerRisk(this.dangerRisk + 15);
    }
}
public String getNineTitan(){
    return nineTitan;
}
public void setNineTitan(String nineTitan){
    this.nineTitan = nineTitan;
    // nine titan = danger risk 19
    if(nineTitan.equals("One of nine titans")){
        this.setDangerRisk(this.dangerRisk + 19);
    }
}
public Integer getDangerRisk(){
    return dangerRisk;
}
public void setDangerRisk(int dangerRisk){
    this.dangerRisk = dangerRisk;
}   
    @Override
    public int compareTo(TitanData o) {
        return this.getDangerRisk().compareTo(o.getDangerRisk());
    }

    @Override
    public String toString() {
        if(abnormal.equals("Abnormal")){
            return "titan " + number + ": " + "Abnormal Titan Risk = " + dangerRisk;
        }
        else if(nineTitan.equals("One of nine titans")){
            return "titan " + number + ": " + "One of nine titans = " + dangerRisk;
        }
        return "titan " + number + ": " + abnormal + " (" + height + "m, " + walkingLegs + " legs, " 
        + runningSpeed + "ms, " + walkingPattern + ", " + climbingSkill + ") "
        + "Risk = "+ dangerRisk;
    }
}
