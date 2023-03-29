package com.muzhevsky.main;


import com.muzhevsky.core.shareBots.Exchange;
import com.muzhevsky.core.shareBots.Share;
import com.muzhevsky.core.shareBots.TradeBot;
import com.muzhevsky.core.student.Student;
import com.muzhevsky.spring.NewTrafficLight;
import com.muzhevsky.spring.StudentCreator;
import com.muzhevsky.spring.streamingPlatform.MyFileReader;
import com.muzhevsky.spring.streamingPlatform.MyFileWriter;
import com.muzhevsky.spring.streamingPlatform.StringConverter;
import com.muzhevsky.spring.streamingPlatform.StringHandler;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) throws Exception {
        var ctx = new AnnotationConfigApplicationContext("com");

        var trafficLight = (NewTrafficLight)ctx.getBean("trafficLight");
        System.out.println(trafficLight.toString());
        trafficLight.getNext();
        System.out.println(trafficLight.toString());
        trafficLight.turnOn();
        System.out.println(trafficLight.toString());
        trafficLight.getNext();
        System.out.println(trafficLight.toString());
        trafficLight.turnOff();
        System.out.println(trafficLight.toString());


        var defaultStudent = (Student)ctx.getBean("defaultStudent");
        var anotherStudent = (Student)ctx.getBean("anotherStudent");

        defaultStudent.addMarks(2,3,4,5);
        anotherStudent.addMarks(2,3,4,5);


        var studentCreator = (StudentCreator)ctx.getBean("studentCreator");


        defaultStudent = studentCreator.GetStudent("vasya");
        defaultStudent.addMarks(2,3,4,5);


        var fileReader = (MyFileReader)ctx.getBean("fileReader");
        var fileWriter = (MyFileWriter)ctx.getBean("fileWriter");
        fileReader.setPath("input.txt");
        fileWriter.setPath("output.txt");


        var converter = (StringConverter)ctx.getBean("stringConverter");
        converter.handle(fileReader, fileWriter);


        var exchange = (Exchange)ctx.getBean("exchange");
        var tradeBot = (TradeBot)ctx.getBean("tradeBot1");
        tradeBot.setNewShare(exchange, "test1");
        tradeBot.setNewShare(exchange, "test2");
    }
}