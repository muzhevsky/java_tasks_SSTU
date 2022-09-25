package org.example;

public class Time {
    private int ticks;

    public Time(int ticks){
        this.ticks = ticks;
    }

    public String getFormattedTime(){
        int hours, minutes;

        hours = ticks/3600;
        ticks -= hours*3600;

        minutes = ticks/60;
        ticks -= minutes*60;

        return Integer.toString(hours)+":"+Integer.toString(minutes)+":"+Integer.toString(ticks);
    }
}