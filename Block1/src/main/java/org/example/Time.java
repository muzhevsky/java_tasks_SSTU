package org.example;

public class Time implements IPrintable {
    private int _ticks;

    public Time(int ticks){
        if (ticks >= 0)
            _ticks = ticks;
        else
            _ticks = 0;
    }

    public String getDataForPrinting(){
        int hours, minutes;

        int seconds = _ticks;

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