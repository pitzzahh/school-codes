package wakeUp;

import java.time.LocalDateTime;

public class Monday extends WeekDay {

     private String time;

     public static void main(String[] args) {
         Monday monday = new Monday();
         monday.setAlarm("05:30");
         monday.showAlarm();
     }

     @Override
     public void setAlarm(String time) {
        this.time = time;
     }

     @Override
     public void showAlarm() {
         LocalDateTime alarm = LocalDateTime.parse(time);
         LocalDateTime now = LocalDateTime.now();
            if (alarm.isAfter(now)) System.out.println("Alarm is set for tomorrow!");
            else System.out.println("I'll wake you up later!");
     }

 }



