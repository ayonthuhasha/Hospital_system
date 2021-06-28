
package controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class timeController {
    private int mins;
    private int hours;
    private String AmPmState;

    public timeController(String timeString){
        String[] resultString=timeString.split(":", 0);
            this.hours=Integer.parseInt(resultString[0]);
            
            resultString=resultString[1].split(" ");
            this.mins=Integer.parseInt(resultString[0]);
            this.AmPmState=resultString[1];
            
    }
    
    public timeController(int minutes, int hours, String AmPmState) {
        this.mins = minutes;
        this.hours = hours;
        this.AmPmState = AmPmState;
    }
    
    public timeController(){
        DateTimeFormatter hoursFormat = DateTimeFormatter.ofPattern("HH");
        DateTimeFormatter minutesFormat = DateTimeFormatter.ofPattern("mm");
        DateTimeFormatter AmPmFormat = DateTimeFormatter.ofPattern("a");
        
        LocalDateTime now = LocalDateTime.now();  
        this.hours=Integer.parseInt(hoursFormat.format(now));
        this.mins=Integer.parseInt(minutesFormat.format(now));
        this.AmPmState=AmPmFormat.format(now);
    }

    public int getMinutes() {
        return mins;
    }

    public void setMinutes(int minutes) {
        this.mins = minutes;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public String getAmPmState() {
        return AmPmState;
    }

    public void setAmPmState(String AmPmState) {
        this.AmPmState = AmPmState;
    }
    
    @Override
    public String toString(){
        return getHours()+":"+
                getMinutes()+" "+
                getAmPmState();
    }
}
