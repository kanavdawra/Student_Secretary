package com.example.root.bunker;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button;
    Button del;
    Toolbar toolbar;
    public static final String DEFAULT="N/A";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);



        button = (Button) findViewById(R.id.go_bunker);
        //del = (Button) findViewById(R.id.clear);
        // Capture button clicks
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                SharedPreferences sharedPreferences=getSharedPreferences("check",MODE_PRIVATE);
                String bunker_check=sharedPreferences.getString("bunker_flag",DEFAULT);
                final SharedPreferences.Editor editorc=sharedPreferences.edit();
                if(bunker_check.equals(DEFAULT)){

                    Intent Intent2 = new Intent(MainActivity.this, final_main.class);
                    finish();
                    startActivity(Intent2);
                    setContentView(R.layout.activity_main);
                    editorc.putString("bunker_flag","1");
                    editorc.apply();
                }
                else
                {//Start next to getdata
                    Intent Intent2 = new Intent(MainActivity.this, final_main.class);
                    finish();
                  //  Intent2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(Intent2);
                }
            }
        });

    }
    public void check(){

    }
}
