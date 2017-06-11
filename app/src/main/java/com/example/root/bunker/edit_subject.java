package com.example.root.bunker;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class edit_subject extends AppCompatActivity {
    Toolbar toolbar;
    EditText sub;
    EditText add;
    EditText ld;
    EditText la;
    EditText pr;
    EditText ls;
    TextView cp;
    TextWatcher per_watch;
    float c;float a,d;
    String subi,addi,colour;
    int ldi,lai,pri,abi,id,lbi,lsi;float cpi;
rowentryy rowentry;
    bunker_db_adapter bunker_db;
Cursor cursor;
     @Override
      protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_subject);
        toolbar=(Toolbar)findViewById(R.id.toolbar_editsub);
        setSupportActionBar(toolbar);
        //////////**********///////////
        bunker_db=new bunker_db_adapter(this);


        sub=(EditText)findViewById(R.id.edit_subject);
        add=(EditText)findViewById(R.id.edit_lec_add);
        ld=(EditText)findViewById(R.id.edit_lec_del);
        la=(EditText)findViewById(R.id.edit_lec_att);
        pr=(EditText)findViewById(R.id.edit_per_req);
        ls=(EditText)findViewById(R.id.edit_lec_size);
        cp=(TextView)findViewById(R.id.edit_cur_per);
        int di = getIntent().getIntExtra("id",1);

        SQLiteDatabase db=bunker_db.helper.getReadableDatabase();
        Cursor cursor=bunker_db.getrow(di);

        cursor.moveToFirst();

        subi=cursor.getString(cursor.getColumnIndex(bunker_db.helper.SUB));
        addi=cursor.getString(cursor.getColumnIndex(bunker_db.helper.ADD));
        colour=cursor.getString(cursor.getColumnIndex(bunker_db.helper.C_C));
        abi=cursor.getInt(cursor.getColumnIndex(bunker_db.helper.A_B));
        pri=cursor.getInt(cursor.getColumnIndex(bunker_db.helper.P_R));
        cpi=cursor.getFloat(cursor.getColumnIndex(bunker_db.helper.C_P));
        ldi=cursor.getInt(cursor.getColumnIndex(bunker_db.helper.L_D));
        lai=cursor.getInt(cursor.getColumnIndex(bunker_db.helper.L_A));
        lbi=cursor.getInt(cursor.getColumnIndex(bunker_db.helper.L_B));
        lsi=cursor.getInt(cursor.getColumnIndex(bunker_db.helper.L_S));

        if(lsi<=0){lsi=1;}

        SharedPreferences check=getSharedPreferences("check",MODE_PRIVATE);
        String ls_check=check.getString("size_flag","n/a");
        final SharedPreferences.Editor editorc=check.edit();
        /////****////  dialog box
        if(ls_check.equals("n/a")) {


            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);


            alertDialogBuilder.setTitle("Remember!");
            alertDialogBuilder.setIcon(R.drawable.ic_action_reminder);

            alertDialogBuilder
                    .setMessage("Lecture Size is the size of lecture in terms of periods. Ex. Lecture size = 3 means 3 Periods.")
                    .setCancelable(false)
                    .setPositiveButton("Remember", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // SharedPreferences check=getSharedPreferences("check",MODE_PRIVATE);

                            editorc.putString("size_flag","1");
                            editorc.apply();
                            dialog.cancel();
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

                            dialog.cancel();
                        }
                    });


            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
        //int id = Integer.parseInt(di);

        sub.setText(subi, TextView.BufferType.EDITABLE);
        add.setText(addi, TextView.BufferType.EDITABLE);
        if(ldi!=-1)
        {
        ld.setText(String.valueOf(ldi), TextView.BufferType.EDITABLE);
        la.setText(String.valueOf(lai), TextView.BufferType.EDITABLE);
        pr.setText(String.valueOf(pri), TextView.BufferType.EDITABLE);
        ls.setText(String.valueOf(lsi), TextView.BufferType.EDITABLE);
        String cps= Float.toString(cpi);
        cp.setText(String.valueOf(cps+"%"));

        //message.message(this,""+cps);
            }
        ld.addTextChangedListener(new TextWatcher()
        {
            public void afterTextChanged(Editable s){}
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                cp=(TextView)findViewById(R.id.edit_cur_per);
                try {
                    d = Integer.parseInt(ld.getText().toString());
                } catch (NumberFormatException e) {
                    d=0;
                }

                try {
                    a = Integer.parseInt(la.getText().toString());
                } catch (NumberFormatException e) {
                    a=0;
                }
                if(d!=0){
                    c=a/d;
                    c=c*100;
                }
                c= (float)Math.round(c * 100) / 100;
                float c1;int c0;
                String fc="";
                c1=(float)Math.round(c * 10) / 10;
                c0=(int)Math.round(c);
                if(c==c1)
                {
                    c=c1;
                    if(c==c0)
                    {c=c0;

                        fc=Integer.toString(c0);
                    }
                    else{
                        fc= Float.toString(c);}
                }else{c=(float)Math.round(c * 100) / 100;
                    fc= Float.toString(c);}
                cp.setText(String.valueOf(fc+"%"));
            }

        });
        ls.addTextChangedListener(new TextWatcher()
        {
            public void afterTextChanged(Editable s){

                int rs;
                String we=ls.getText().toString();
             if(we.matches("")){
                 lsi=1;
             }
             else{
                 rs = Integer.parseInt(ls.getText().toString());
                 if(rs>0){
                     lsi=rs;
                 }
                 else{
                     ls.setText(String.valueOf(1));
                     lsi=1;
                 }
             }
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

        });

        la.addTextChangedListener(new TextWatcher()
        {
            public void afterTextChanged(Editable s){}
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                cp=(TextView)findViewById(R.id.edit_cur_per);
                try {
                    d = Integer.parseInt(ld.getText().toString());
                } catch (NumberFormatException e) {
                    d=0;
                }

                try {
                    a = Integer.parseInt(la.getText().toString());
                } catch (NumberFormatException e) {
                    a=0;
                }
                if(d!=0){
                    c=a/d;
                    c=c*100;
                }

                c= (float)Math.round(c * 100) / 100;
                float c1;int c0;String fc="";
                c1=(float)Math.round(c * 10) / 10;
                c0=(int)Math.round(c);
                if(c==c1)
                {
                    c=c1;
                    if(c==c0)
                    {c=c0;

                        fc=Integer.toString(c0);
                    }
                    else{
                        fc= Float.toString(c);}
                }else{ c= (float)Math.round(c * 100) / 100;

                    fc= Float.toString(c);}
               // message.message(getBaseContext(),"d "+d);
                if(d==0 || d==-1){
                    int qw = Integer.parseInt(la.getText().toString());
                    c0 =qw*100;fc=Integer.toString(c0);}
                cp.setText(String.valueOf(fc+"%"));
            }

        });

        bunker_db=new bunker_db_adapter(this);


       }
       public void inc_del(View view){
//message.message(this,""+lsi);
        int d;
        try {
            d = Integer.parseInt(ld.getText().toString());
        } catch (NumberFormatException e) {
            d=0;
        }
        ld.setText(String.valueOf(d+lsi));
        // this.show_per();
       }
       public void dec_del(View view){

        int d;
        try {
            d = Integer.parseInt(ld.getText().toString());
        } catch (NumberFormatException e) {
            d=0;
        }
        if(d<=0)
        {
           // message.message(this,"Lecture can't be less than 0");
            ld.setText(String.valueOf(""));
        }
        else{
            if(d<lsi){ld.setText(String.valueOf(0));}else{
            ld.setText(String.valueOf(d-lsi));}
        }
        // this.show_per();
    }
    public void inc_att(View view){

        int a;
        try {
            a = Integer.parseInt(la.getText().toString());
        } catch (NumberFormatException e) {
            a=0;
        }
        la.setText(String.valueOf(a+lsi));
        // this.show_per();
    }
    public void dec_att(View view){

        int d;
        try {
            d = Integer.parseInt(la.getText().toString());
        } catch (NumberFormatException e) {
            d=0;
        }
        if(d<=0)
        {
            //message.message(this,"Lecture can't be less than 0");
      //      la.setText(String.valueOf(""));
        }
        else{
            if(d<lsi){la.setText(String.valueOf(0));}else{
                la.setText(String.valueOf(d-lsi));}
        }
        // this.show_per();
    }
    public void inc_per(View view){

        int p;
        try {
            p = Integer.parseInt(pr.getText().toString());
        } catch (NumberFormatException e) {
            p=0;
        }
        if(p<100){p=p+5;}
        pr.setText(String.valueOf(p));
    }
    public void dec_per(View view){

        int d;
        try {
            d = Integer.parseInt(pr.getText().toString());
        } catch (NumberFormatException e) {
            d=0;
        }
        if(d<=0)
        {
            //message.message(this,"%age can't be less than 0");
            pr.setText(String.valueOf(""));
        }
        else{
            pr.setText(String.valueOf(d-5));}
    }
    public void inc_size(View view){

        int p;
        try {
            p = Integer.parseInt(ls.getText().toString());
        } catch (NumberFormatException e) {
            p=0;
        }
        ls.setText(String.valueOf(p+1));
        lsi=p+1;
    }
    public void dec_size(View view){

        int d;
        try {
            d = Integer.parseInt(ls.getText().toString());
        } catch (NumberFormatException e) {
            d=0;
        }
        if(d==1)
        {
           // message.message(this,"Lecture size can't be less than 0");
            ls.setText(String.valueOf(""));
        }
        else if(d>1){
            ls.setText(String.valueOf(d-1));
             lsi=d-1;}
        }

    public void getvalue(String subi,String addi,String colour,float cpi,int abi,int pri,int id,int ldi,int lai,int lbi,int lsi){
        this.subi=subi;
        this.addi=addi;
        this.colour=colour;
        this.cpi=cpi;
        this.pri=pri;
        this.abi=abi;
        this.id=id;
        this.ldi=ldi;
        this.lai=lai;
        this.lbi=lbi;
        this.lsi=lsi;


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuin1=getMenuInflater();
        menuin1.inflate(R.menu.menu_edit,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        try {
            int save=item.getItemId();
            if(save== R.id.edit){


                String subj= null;
                String addr= null;
                int ldh= -1;
                int lah= -1;
                int prh= -1;
                int lsh= 1;
                try {
                    subj = sub.getText().toString();
                    addr = add.getText().toString();
                    if(ld==null){ldh=-1;}
                    else{
                        ldh = Integer.parseInt(ld.getText().toString());}
                    if(la==null){lah=-1;}
                    else{
                        lah = Integer.parseInt(la.getText().toString());}
                    if(pr==null){prh=-1;}
                    else{
                        prh = Integer.parseInt(pr.getText().toString());}
                    if(ls==null){lsh=1;}
                    else{
                        lsh = Integer.parseInt(ls.getText().toString());}

                } catch (NumberFormatException e) {
                    //message.message(this,""+e);
                }
                if (subj.matches("")) {
                    message.message(this,"Subject field can't be empty.");
                }
                else{
                    if(ldh<lah)
                    {
                        message.message(this,"Lecture Deliverd must be more than Lecture Attended");
                    }
                    if(prh>100)
                    {
                        message.message(this,"Min. %age can't be more than 100");
                    }
                    if(sub==null)
                    {
                        message.message(this,"Subject Field can't be empty");
                    }
                    else if(ldh>=lah && prh<=100){

                        String d,a,p,s;
                        d=Integer.toString(ldh);

                        a=Integer.toString(lah);

                        p=Integer.toString(prh);
                        s=Integer.toString(lsh);
                        backgroundtask backgroundtask = new backgroundtask(this);
                        try {
                            int di = getIntent().getIntExtra("id",1);
                            String id = Integer.toString(di);
                            backgroundtask.execute("update_data",subj,d,a,p,s,addr,id);
                        } catch (Exception e) {
                            message.message(this,""+e);
                        }
                        setResult(RESULT_OK);
                        finish();
                    }
                    //editor.putString("")
                }}
            return true;
        } catch (Exception e) {
            message.message(this,""+e);
        }
        return true;
    }

}
