package org.example;

public class Time{
    private int ticks;

    public Time(int ticks){
        if (ticks >= 0)
            this.ticks = ticks;
        else
            this.ticks = 0;
    }

    public Time(int hours, int minutes, int seconds){
        this(hours*3600 + minutes*60 + seconds);
    }

    public String toString(){
        int hours, minutes;

        int seconds = ticks;

        hours = seconds / 3600;
        seconds -= hours * 3600;
        hours %= 24;

        minutes = seconds / 60;
        seconds -= minutes * 60;

        return format(hours)+":"+
               format(minutes)+":"+
               format(seconds);
    }

    private String format(int timeValue){
        return timeValue > 9 ?
                Integer.toString(timeValue) :
                "0" + Integer.toString(timeValue);
    }
}