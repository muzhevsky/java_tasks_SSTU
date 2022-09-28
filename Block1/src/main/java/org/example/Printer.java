package org.example;

public class Printer {
    public void Print(IPrintable item){
        System.out.println(item.getDataForPrinting());
    }
}
