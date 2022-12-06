package wakeUp;

import java.time.LocalTime;
import java.util.Scanner;

public class Monday extends WeekDay {

     private String time;

     public static void main(String[] args) {
         Monday monday = new Monday();
         System.out.print("Enter time for alarm in this format (HH:MM): ");
         monday.setAlarm(new Scanner(System.in).nextLine());
         monday.showAlarm();
     }

     @Override
     public void setAlarm(String time) {
        this.time = time;
     }

     @Override
     public void showAlarm() {
         LocalTime alarm = LocalTime.parse(this.time);
         LocalTime now = LocalTime.now();
            if (alarm.isAfter(now)) System.out.println("I'll wake you up later!");
            else System.out.println("Alarm is set for tomorrow!");
     }

}

interface Alarm {
    void setAlarm(String time);
    void showAlarm();
}

abstract class WeekDay implements Alarm {

}

