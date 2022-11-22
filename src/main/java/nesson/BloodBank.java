package nesson;

import java.util.*;

public class BloodBank {
    
    private String Bloodtype;
    private String RhpFactor;
    
    public BloodBank(){
        this.Bloodtype = "O";    
        this.RhpFactor = "+";
    }
    public String getBloodtype () {
        return Bloodtype;
    }
    public String getRhpFactor (){
       return RhpFactor;
    }  
            
    public void setbloodtype(String Blood){
        if (!Blood.isEmpty()) this.Bloodtype = Blood;
    }
    public void setRhpFactor(String factor){
        if (!factor.isEmpty()) this.RhpFactor = factor;
    }
    
  public static void main(String[] args) {
         
        BloodBank b = new BloodBank();
        Scanner s = new Scanner(System.in);
        
        System.out.print("Enter blood type of patient:");
        String ans1 = s.nextLine();
        b.setbloodtype(ans1);
        System.out.print("Enter the Rhesus (+ Or -) : " );
        String ans2 = s.nextLine();
        b.setRhpFactor(ans2);
        System.out.println (b.getBloodtype()+ "" + b.getRhpFactor()+" is added to the blood bank");
        System.out.print("Enter blood type of patient:");
        String ans3 = s.nextLine();
        b.setbloodtype(ans3);
        System.out.print("Enter the Rhesus (+ Or -) : " );
        String ans4 = s.nextLine();
        b.setRhpFactor(ans4);
        System.out.println (b.getBloodtype()+b.getRhpFactor()+ " is added to the blood bank");   
     }	
}