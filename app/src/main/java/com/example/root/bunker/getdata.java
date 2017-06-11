package com.example.root.bunker;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.Toast;

import java.sql.SQLData;

public class getdata extends AppCompatActivity {
    CheckedTextView mon;
    CheckedTextView teus;
    CheckedTextView wed;
    CheckedTextView thurs;
    CheckedTextView fri;
    CheckedTextView sat;
    CheckedTextView sun;
    bunker_db_adapter bunker_db;
Button button;
    Toolbar toolbar;
    public static final String DEFAULT="N/A";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getdata);
        bunker_db=new bunker_db_adapter(this);
        SQLiteDatabase sqdb=bunker_db.helper.getWritableDatabase();
        toolbar=(Toolbar)findViewById(R.id.toolbar_getdata);
        setSupportActionBar(toolbar);
        SharedPreferences data=getSharedPreferences("data",MODE_PRIVATE);
        final SharedPreferences.Editor editor=data.edit();
        sun=(CheckedTextView)findViewById(R.id.sun);
        sun.setCheckMarkDrawable(R.drawable.unchecked);
        sun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sun.isChecked()) {
                    sun.setChecked(false);
                    sun.setCheckMarkDrawable(R.drawable.unchecked);
                    //String sunc=data.getString("sun",0);
                    editor.putString("sun","0");
                    editor.apply();
                }
                else{
                    sun.setChecked(true);
                    sun.setCheckMarkDrawable(R.drawable.checked);

                    editor.putString("sun","1");

                    //editor.commit();

                }
            }
        });
        mon=(CheckedTextView)findViewById(R.id.mon);
        mon.setCheckMarkDrawable(R.drawable.unchecked);
        mon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mon.isChecked()) {
                    mon.setChecked(false);
                    mon.setCheckMarkDrawable(R.drawable.unchecked);
                    //String monc=data.getString("mon",0);
                    editor.putString("mon","0");
                    editor.apply();
                }
                else{
                    mon.setChecked(true);
                    mon.setCheckMarkDrawable(R.drawable.checked);

                    editor.putString("mon","1");

                    editor.apply();
                }
            }
        });
        teus=(CheckedTextView)findViewById(R.id.teus);
        teus.setCheckMarkDrawable(R.drawable.unchecked);
        teus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (teus.isChecked()) {
                    teus.setChecked(false);
                    teus.setCheckMarkDrawable(R.drawable.unchecked);
                    //String teusc=data.getString("teus",0);
                    editor.putString("teus","0");
                    editor.apply();
                }
                else{
                    teus.setChecked(true);
                    teus.setCheckMarkDrawable(R.drawable.checked);

                    editor.putString("teus","1");

                    editor.apply();
                }
            }
        });
        wed=(CheckedTextView)findViewById(R.id.wed);
        wed.setCheckMarkDrawable(R.drawable.unchecked);
        wed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (wed.isChecked()) {
                    wed.setChecked(false);
                    wed.setCheckMarkDrawable(R.drawable.unchecked);
                   // String wedc=data.getString("wed",0);
                    editor.putString("wed","0");
                    editor.apply();
                }
                else{
                    wed.setChecked(true);
                    wed.setCheckMarkDrawable(R.drawable.checked);

                    editor.putString("wed","1");
                    editor.apply();
                }
            }
        });
        thurs=(CheckedTextView)findViewById(R.id.thurs);
        thurs.setCheckMarkDrawable(R.drawable.unchecked);
        thurs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (thurs.isChecked()) {
                    thurs.setChecked(false);
                    thurs.setCheckMarkDrawable(R.drawable.unchecked);
                   // String thursc=data.getString("thurs",0);
                    editor.putString("thurs","0");
                    editor.apply();
                }
                else{
                    thurs.setChecked(true);
                    thurs.setCheckMarkDrawable(R.drawable.checked);
                    editor.putString("thurs","1");
                    editor.apply();
                }
            }
        });
        fri=(CheckedTextView)findViewById(R.id.fri);
        fri.setCheckMarkDrawable(R.drawable.unchecked);
        fri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fri.isChecked()) {
                    fri.setChecked(false);
                    fri.setCheckMarkDrawable(R.drawable.unchecked);
                   // String fric=data.getString("fri",0);
                   editor.putString("fri","0");
                   editor.apply();
                }
                else{
                    fri.setChecked(true);
                    fri.setCheckMarkDrawable(R.drawable.checked);

                    editor.putString("fri","1");
                    editor.apply();
                }
            }
        });
        sat=(CheckedTextView)findViewById(R.id.sat);
        sat.setCheckMarkDrawable(R.drawable.unchecked);
        sat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sat.isChecked()) {
                    sat.setChecked(false);
                    sat.setCheckMarkDrawable(R.drawable.unchecked);
                   // String satc=data.getString("sat",0);
                   editor.putString("sat","0");
                   editor.apply();
                }
                else{
                    sat.setChecked(true);
                    sat.setCheckMarkDrawable(R.drawable.checked);

                    editor.putString("sat","1");
                    editor.apply();
                }
            }
        });
        editor.apply();
        SharedPreferences check=getSharedPreferences("check",MODE_PRIVATE);
        final SharedPreferences.Editor editorc=check.edit();
        button = (Button) findViewById(R.id.savedays);
      //  final String sunc=data.getString("sun",DEFAULT);
        final String monc=data.getString("mon",DEFAULT);
        final String teusc=data.getString("teus",DEFAULT);
        final String wedc=data.getString("wed",DEFAULT);
        final String thursc=data.getString("thurs",DEFAULT);
        final String fric=data.getString("fri",DEFAULT);
        final String satc=data.getString("sat",DEFAULT);
        final Boolean sunc=sun.isChecked();
        final Intent Intent = new Intent(getdata.this, subjects.class);

        // Capture button clicks
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View arg) {

               if(sun.isChecked() || mon.isChecked() ||  teus.isChecked() || wed.isChecked() || thurs.isChecked() || fri.isChecked() || sat.isChecked()){
                    // Start activitymain.class
                    //Intent3.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                   editorc.putString("bunker_flag","1");
                   editorc.apply();
                   startActivity(Intent);
                }

                else
                {//Start next to subjects
                    //editor.commit();
                    //Intent3.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

                    Context context = getApplicationContext();
                    message.message(context,"Select atlest one entry :)");
                }
            }
        });

    }
}
