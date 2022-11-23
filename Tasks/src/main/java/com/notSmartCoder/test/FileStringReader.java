package com.notSmartCoder.test;

public class FileStringReader implements Reader<String>{
    String result;
    public FileStringReader(String path){
        /*path*/
        result = "123";
    }
    public String read(){
        return result;
    }
}
