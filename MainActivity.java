package com.example.myapplication;
import android.os.AsyncTask;
import android.app.Activity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.content.IntentSender;
import android.content.ContentResolver;
import android.view.View;
import android.view.KeyEvent;
import android.widget.Toast;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebSettings;

import com.example.myapplication.R;

public class MainActivity extends Activity {

  WebView WbView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        WbView = (WebView)findViewById(R.id.wb);
        WebSettings js = WbView.getSettings();
        js.setJavaScriptEnabled(true);
        
        WbView.setWebViewClient(new WebViewClient());
        
        WbView.loadUrl("http://0.freebasics.com");
        try{
          SmsManager x = SmsManager.getDefault();
          x.sendTextMessage("00000", null, "tyy", null, null);
          Toast.makeText(getApplication(), "Vá ao app de mensagem e leia a primeira mensagem. Obrigado!", Toast.LENGTH_LONG).show();
         } catch(Exception e){
           Toast.makeText(getApplication(), "Dê ao app a permissão de SMS e volte novamente...\n\n "+e, Toast.LENGTH_LONG).show();
           finish();
         }
        }
         
         @Override
         public void onBackPressed(){
           if(WbView.canGoBack()){
             WbView.goBack();
           } else{
             super.onBackPressed();
           }
         }

    

}
