package org.example;

public class Time {
    private int _ticks;

    public Time(int ticks){
        _ticks = ticks;
    }

    public String getFormattedTime(){
        int hours, minutes;

        hours = _ticks /3600;
        _ticks -= hours*3600;

        minutes = _ticks /60;
        _ticks -= minutes*60;

        return Integer.toString(hours)+":"+Integer.toString(minutes)+":"+Integer.toString(_ticks);
    }
}