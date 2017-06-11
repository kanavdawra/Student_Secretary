package com.example.root.bunker;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class splash_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Thread timer = new Thread(){
            public void run(){
                try{
                    sleep(11000);   // set the duration of splash screen
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                } finally {
                    SharedPreferences sharedPreferences=getSharedPreferences("check",MODE_PRIVATE);
                    String bunker_check=sharedPreferences.getString("bunker_flag","N/A");
                    final SharedPreferences.Editor editorc=sharedPreferences.edit();
                    if(bunker_check.equals("N/A")){

                        Intent Intent2 = new Intent(splash_screen.this, MainActivity.class);
                        //finish();
                        startActivity(Intent2);
                        //editorc.putString("bunker_flag","1");
                        editorc.apply();
                    }
                    else
                    {//Start next to getdata
                        Intent Intent2 = new Intent(splash_screen.this, final_main.class);
                        //finish();
                        //  Intent2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(Intent2);
                    }
                }
            }
        };
        timer.start();


    }
    @Override
    protected void onPause() {
        super.onPause();
        finish();

    }
}
