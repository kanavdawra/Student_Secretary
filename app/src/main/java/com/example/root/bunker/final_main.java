package com.example.root.bunker;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ListAdapter;
import java.util.ArrayList;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class final_main extends AppCompatActivity {


    Toolbar toolbar,toolbar1;
    bunker_db_adapter bunker_db;
    ListView mlistview;
    int but=0;

    private static final int Rc = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subjects);
        TextView sub=(TextView)findViewById(R.id.list_sub);
        TextView cp=(TextView)findViewById(R.id.list_per);
        toolbar = (Toolbar) findViewById(R.id.toolbar_sub_first);
        setSupportActionBar(toolbar);
        toolbar1 = (Toolbar) findViewById(R.id.default_bar);
        // setSupportActionBar(toolbar1);
        mlistview=(ListView)findViewById(R.id.list_view);
        bunker_db=new bunker_db_adapter(this);
        populateListView(but);
        long data=bunker_db.rowcount();
        //   message.message(this,""+data);
    }

    private void populateListView(int but) {
           /* list_adapter list_adapter;

        ArrayList<list_get_all> sublist=null;

        sublist=bunker_db.getData();
        list_adapter= new list_adapter(this,R.layout.sub_list,sublist,but);

        mlistview = (ListView) findViewById(R.id.list_view);
        mlistview.setAdapter(list_adapter);*/
        backgroundtask backgroundtask =new backgroundtask(this);
        String e_d=Integer.toString(but);
        backgroundtask.execute("get_data",e_d);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuin1=getMenuInflater();
        menuin1.inflate(R.menu.menu_sub,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int dot=item.getItemId();
        if(dot== R.id.action_menu_plus){

            Intent intent = new Intent(getApplicationContext(),AddSubject.class);
            startActivityForResult(intent, Rc);
            //message.message(this,"plus");
        }
        if(dot== R.id.action_menu_remove){
            //message.message(this,"but = "+but);
            if(but==0){
                but=1;
                //message.message(this,"but = "+but);
            }
            else if(but==1)
            {but=0;
                //  message.message(this,"but = "+but);
            }

            this.populateListView(but);
        }

        return true;
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode==Rc){
            if(resultCode==RESULT_OK){

                Intent intent = getIntent();
                finish();

                startActivity(intent);

            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onResume() {
        super.onResume();
        populateListView(but);
    }


}
