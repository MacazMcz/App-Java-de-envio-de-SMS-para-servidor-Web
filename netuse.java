package com.example.myapplication;

import android.os.*;
import java.net.*;
import java.lang.Thread;

public class netuse extends Thread{
 String site = "http://127.0.0.1:8080";
 public void run(){
   try{
     URL url = new URL(site);
     HttpURLConnection con = (HttpURLConnection) url.openConnection();
     con.setRequestMethod("POST");
     int status = con.getResponseCode();
   }catch (Exception e){
     
   }
 }
 
  //netuse obj = new netuse();
  //obj.start();
}
