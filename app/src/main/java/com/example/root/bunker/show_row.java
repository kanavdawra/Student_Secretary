package com.example.root.bunker;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class show_row extends AppCompatActivity {
    Toolbar toolbar;
    TextView sub,add,ld,la,lb,ls,pr,cp,ab;
    LinearLayout subl,addl,ldl,lal,lbl,lsl,prl,cpl,abl;
    String subi,addi,colour,idi;
    String colou;
    int ldi,lai,pri,abi,id,lbi,lsi;float cpi;
    bunker_db_adapter bunker_db;
    Cursor cursor;
    Context context =this;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_row);
        toolbar=(Toolbar)findViewById(R.id.toolbar_show_row);
        try {
            setSupportActionBar(toolbar);
        } catch (Exception e) {
            message.message(this,""+e);
        }
        bunker_db=new bunker_db_adapter(this);
        int di = getIntent().getIntExtra("id",1);
        String idi = Integer.toString(di);
       // message.message(this,"id "+idi);
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

        sub=(TextView) findViewById(R.id.text_sub_value);
        add=(TextView) findViewById(R.id.text_lec_add_value);
        ld=(TextView) findViewById(R.id.text_lec_del_value);
        la=(TextView) findViewById(R.id.text_lec_att_value);
        lb=(TextView) findViewById(R.id.text_lec_bunk_value);
        pr=(TextView) findViewById(R.id.text_lec_pr_value);
        cp=(TextView) findViewById(R.id.text_lec_cp_value);
        ls=(TextView) findViewById(R.id.text_lec_size_value);
        ab=(TextView) findViewById(R.id.text_lec_ab_value);

        subl=(LinearLayout)findViewById(R.id.show_layout_sub);
        addl=(LinearLayout)findViewById(R.id.show_layout_add);
        ldl=(LinearLayout)findViewById(R.id.show_layout_del);
        lal=(LinearLayout)findViewById(R.id.show_layout_att);
        lbl=(LinearLayout)findViewById(R.id.show_layout_bunk);
        prl=(LinearLayout)findViewById(R.id.show_layout_pr);
        cpl=(LinearLayout)findViewById(R.id.show_layout_cp);
        lsl=(LinearLayout)findViewById(R.id.show_layout_size);
        abl=(LinearLayout)findViewById(R.id.show_layout_ab);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP){
            // Do something for lollipop and above versions

            if("#d6e2393b".equals(colour)){
                subl.setBackgroundTintList(ContextCompat.getColorStateList(this,R.color.red));
                addl.setBackgroundTintList(ContextCompat.getColorStateList(this,R.color.redd));
                ldl.setBackgroundTintList(ContextCompat.getColorStateList(this,R.color.red));
                lal.setBackgroundTintList(ContextCompat.getColorStateList(this,R.color.redd));
                lbl.setBackgroundTintList(ContextCompat.getColorStateList(this,R.color.red));
                prl.setBackgroundTintList(ContextCompat.getColorStateList(this,R.color.redd));
                cpl.setBackgroundTintList(ContextCompat.getColorStateList(this,R.color.red));
                lsl.setBackgroundTintList(ContextCompat.getColorStateList(this,R.color.redd));
                abl.setBackgroundTintList(ContextCompat.getColorStateList(this,R.color.red));
            }
            else if("#d41fa42c".equals(colour)){
                subl.setBackgroundTintList(ContextCompat.getColorStateList(this,R.color.gree));
                addl.setBackgroundTintList(ContextCompat.getColorStateList(this,R.color.greed));
                ldl.setBackgroundTintList(ContextCompat.getColorStateList(this,R.color.gree));
                lal.setBackgroundTintList(ContextCompat.getColorStateList(this,R.color.greed));
                lbl.setBackgroundTintList(ContextCompat.getColorStateList(this,R.color.gree));
                prl.setBackgroundTintList(ContextCompat.getColorStateList(this,R.color.greed));
                cpl.setBackgroundTintList(ContextCompat.getColorStateList(this,R.color.gree));
                lsl.setBackgroundTintList(ContextCompat.getColorStateList(this,R.color.greed));
                abl.setBackgroundTintList(ContextCompat.getColorStateList(this,R.color.gree));}
            else if("#e1e100".equals(colour)){
                    subl.setBackgroundTintList(ContextCompat.getColorStateList(this,R.color.yellow));
                    addl.setBackgroundTintList(ContextCompat.getColorStateList(this,R.color.yellowd));
                    ldl.setBackgroundTintList(ContextCompat.getColorStateList(this,R.color.yellow));
                    lal.setBackgroundTintList(ContextCompat.getColorStateList(this,R.color.yellowd));
                    lbl.setBackgroundTintList(ContextCompat.getColorStateList(this,R.color.yellow));
                    prl.setBackgroundTintList(ContextCompat.getColorStateList(this,R.color.yellowd));
                    cpl.setBackgroundTintList(ContextCompat.getColorStateList(this,R.color.yellow));
                    lsl.setBackgroundTintList(ContextCompat.getColorStateList(this,R.color.yellowd));
                    abl.setBackgroundTintList(ContextCompat.getColorStateList(this,R.color.yellow));}
            else if("#E7AEAEA6".equals(colour)){
                        subl.setBackgroundTintList(ContextCompat.getColorStateList(this,R.color.gry));
                        addl.setBackgroundTintList(ContextCompat.getColorStateList(this,R.color.gryd));
                        ldl.setBackgroundTintList(ContextCompat.getColorStateList(this,R.color.gry));
                        lal.setBackgroundTintList(ContextCompat.getColorStateList(this,R.color.gryd));
                        lbl.setBackgroundTintList(ContextCompat.getColorStateList(this,R.color.gry));
                        prl.setBackgroundTintList(ContextCompat.getColorStateList(this,R.color.gryd));
                        cpl.setBackgroundTintList(ContextCompat.getColorStateList(this,R.color.gry));
                        lsl.setBackgroundTintList(ContextCompat.getColorStateList(this,R.color.gryd));
                        abl.setBackgroundTintList(ContextCompat.getColorStateList(this,R.color.gry));
        }} else if(Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP){

            if("#d6e2393b".equals(colour)){
                colou="#d23537";
            }
            else if("#d41fa42c".equals(colour)){
                colou="#1d9e29";
  }
            else if("#e1e100".equals(colour)){
                colou="#caca00";
            }
            else if("#E7AEAEA6".equals(colour)){
                colou="#93938c";
            }
                        subl.setBackgroundColor(Color.parseColor(colour));
                        addl.setBackgroundColor(Color.parseColor(colou));
                        ldl.setBackgroundColor(Color.parseColor(colour));
                        lal.setBackgroundColor(Color.parseColor(colou));
                        lbl.setBackgroundColor(Color.parseColor(colour));
                        prl.setBackgroundColor(Color.parseColor(colou));
                        cpl.setBackgroundColor(Color.parseColor(colour));
                        lsl.setBackgroundColor(Color.parseColor(colou));
                        abl.setBackgroundColor(Color.parseColor(colour));
        }

        sub.setText(String.valueOf(subi));
        add.setText(String.valueOf(addi));
        if(ldi!=-1){
        String cip=Float.toString(cpi);
        cp.setText(String.valueOf(cip+"%"));
        String pir= Integer.toString(pri);
        pr.setText(String.valueOf(pir+"%"));
        String lid= Integer.toString(ldi);
        ld.setText(String.valueOf(lid));
        String lia= Integer.toString(lai);
        la.setText(String.valueOf(lia));
        String lib= Integer.toString(lbi);
        lb.setText(String.valueOf(lib));
        String lis= Integer.toString(lsi);
        ls.setText(String.valueOf(lis));
        String aib= Integer.toString(abi);
        ab.setText(String.valueOf(aib));}
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuin1 = getMenuInflater();
        menuin1.inflate(R.menu.menu_show_row, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int save = item.getItemId();
        if (save == R.id.menu_back) {


finish();
        }
        if (save == R.id.menu_del) {




            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);


            alertDialogBuilder.setTitle("Alert!");
            alertDialogBuilder.setIcon(R.drawable.ic_not_delete);

            alertDialogBuilder
                    .setMessage("Do You really want to delete")
                    .setCancelable(false)
                    .setPositiveButton("Delete",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,int id) {
                            int di = getIntent().getIntExtra("id",1);
                            String idi = Integer.toString(di);
                            //String id = Integer.toString(list_get.getId());
                            ///bunker_db_adapter bunker_db=new bunker_db_adapter(this);

                            try {
                                backgroundtask backgroundtask = new backgroundtask(context);
                                backgroundtask.execute("row_del",idi);
                            } catch (Exception e) {
                                message.message(context,""+e);
                            }
                            finish();
                        }
                    })
                    .setNegativeButton("Cancel",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,int id) {
                            // if this button is clicked, just close
                            // the dialog box and do nothing
                            dialog.cancel();
                        }
                    });


            AlertDialog alertDialog = alertDialogBuilder.create();


            try {
                alertDialog.show();
            } catch (Exception e) {
               message.message(this,""+e);
            }

        }
        return true;
    }
}
