package org.example;

public class Time {
    private int ticks;

    public Time(int seconds) {
        if (seconds < 0)
            throw new IllegalArgumentException("wrong time");
        ticks = seconds;
    }

    public Time(int hours, int minutes, int seconds) {
        if (minutes > 59 || seconds > 59 || hours < 0 || minutes < 0 || seconds < 0)
            throw new IllegalArgumentException("wrong time");

        this.ticks = hours * 3600 + minutes * 60 + seconds;
    }

    public String toString() {
        int hours, minutes;

        int seconds = ticks;

        hours = seconds / 3600;
        seconds -= hours * 3600;
        hours %= 24;

        minutes = seconds / 60;
        seconds -= minutes * 60;

        return format(hours) + ":" +
                format(minutes) + ":" +
                format(seconds);
    }

    public int getHour() {
        return ticks / 3600;
    }

    public int getMinute() {
        int tempTicks = ticks - getHour() * 3600;
        return tempTicks / 60;
    }

    public int getSecond() {
        int tempTicks = ticks - getMinute() * 60;
        return tempTicks;
    }

    private String format(int timeValue) {
        return timeValue > 9 ?
                Integer.toString(timeValue) :
                "0" + Integer.toString(timeValue);
    }
}