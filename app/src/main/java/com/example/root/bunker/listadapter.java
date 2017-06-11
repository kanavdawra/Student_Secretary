package com.example.root.bunker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 24/5/17.
 */

public class listadapter extends ArrayAdapter {
    List list =new ArrayList();
    Context context;
    boolean bunkclicked = false;
    public listadapter(Context context, int resource) {

        super(context, resource);
        this.context=context;
    }


    public void add(list_get_all object) {
        list.add(object);
        super.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return  list.get(position);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View getView(int position, final View convertView, ViewGroup parent) {
        View row = convertView;
        final listholder listholder;
        if(row == null){
            LayoutInflater layoutInflater=(LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=layoutInflater.inflate(R.layout.sub_list,parent,false);
            listholder=new listholder();
            listholder.sub = (TextView) row.findViewById(R.id.list_sub);
            listholder.per = (TextView) row.findViewById(R.id.list_per);
            listholder.bunk = (TextView) row.findViewById(R.id.list_bunk);
            listholder.list_colour=(LinearLayout)row.findViewById(R.id.sub_list_layout);
            listholder.edit=(Button)row.findViewById(R.id.sub_edit);
            listholder.delete=(Button)row.findViewById(R.id.sub_del);
            row.setTag(listholder);
        }
        else{
            listholder=(listholder)row.getTag();
        }
        final list_get_all list_get=(list_get_all)getItem(position);


        //*********************///////////////**************


        listholder.sub.setText(list_get.getSub());

        if(list_get.getCp()==-1)
        {
            listholder.per.setText("");
        }
        else{
            listholder.per.setText(list_get.getCp()+"%");}


        listholder.edit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {

                    Activity activity;
                    Intent intent = new Intent(context, edit_subject.class);
                    intent.putExtra("sub", list_get.getSub());
                    context.startActivity(intent);
                }
            });


        int u=0;
        if(list_get.getPr()==0 || list_get.getPr()==-1){
            listholder.bunk.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_action_infinite, 0);u=1;
            listholder.bunk.setText("");
        }
        if(list_get.getPr()!=0 && list_get.getPr()!=-1){
            if(u==0){
                listholder.bunk.setText(Integer.toString(list_get.getAb()));
                listholder.bunk.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
        }


        listholder.bunk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bunkclicked){
                    //This will shrink textview to 2 lines if it is expanded.
                    listholder.bunk.setMaxLines(1);
                    bunkclicked  = false;

                    listholder.list_colour.setLayoutHeight(60);
                } else {
                    //This will expand the textview if it is of 2 lines
                    listholder.bunk.setMaxLines(3);
                    bunkclicked  = true;
                }
            }

        });

       /* listholder.edit.setBackgroundTintList(ContextCompat.getColorStateList(getContext(),R.color.red));
        listholder.list_colour.setBackgroundColor(Color.parseColor(list_get.getColour()));
        listholder.edit.setBackgroundColor(Color.parseColor(list_get.getColour()));
        listholder.delete.setBackgroundColor(Color.parseColor(list_get.getColour()));*/
String a=list_get.getColour();

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP){
            // Do something for lollipop and above versions
            //message.message(context,"color");
            if("#d6e2393b".equals(a)){
                listholder.edit.setBackgroundTintList(ContextCompat.getColorStateList(getContext(),R.color.red));
                listholder.list_colour.setBackgroundTintList(ContextCompat.getColorStateList(getContext(),R.color.red));
                listholder.delete.setBackgroundTintList(ContextCompat.getColorStateList(getContext(),R.color.red));
                //message.message(context,"red");
                }
            else if("#d41fa42c".equals(a)){
                listholder.edit.setBackgroundTintList(ContextCompat.getColorStateList(getContext(),R.color.gree));
                listholder.list_colour.setBackgroundTintList(ContextCompat.getColorStateList(getContext(),R.color.gree));
                listholder.delete.setBackgroundTintList(ContextCompat.getColorStateList(getContext(),R.color.gree));}
            else if("#e1e100".equals(a)){
                listholder.edit.setBackgroundTintList(ContextCompat.getColorStateList(getContext(),R.color.yellow));
                listholder.list_colour.setBackgroundTintList(ContextCompat.getColorStateList(getContext(),R.color.yellow));
                listholder.delete.setBackgroundTintList(ContextCompat.getColorStateList(getContext(),R.color.yellow));}
            else if("#E7AEAEA6".equals(a)){
                listholder.edit.setBackgroundTintList(ContextCompat.getColorStateList(getContext(),R.color.gry));
                listholder.list_colour.setBackgroundTintList(ContextCompat.getColorStateList(getContext(),R.color.gry));
                listholder.delete.setBackgroundTintList(ContextCompat.getColorStateList(getContext(),R.color.gry));}
        } else if(Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP){
            listholder.list_colour.setBackgroundColor(Color.parseColor(list_get.getColour()));
            listholder.edit.setBackgroundColor(Color.parseColor(list_get.getColour()));
            listholder.delete.setBackgroundColor(Color.parseColor(list_get.getColour()));
        }





        if(list_get.getE_d()==1)
        {
            listholder.edit.setClickable(false);
            listholder.delete.setClickable(true);
            listholder.edit.setVisibility(View.GONE);
            listholder.delete.setVisibility(View.VISIBLE);
            //listholder.list_colour.setBackgroundColor(Color.parseColor(list_get.getColour()));
            listholder.delete.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v)
                {
                    String id = Integer.toString(list_get.getId());
                    bunker_db_adapter bunker_db=new bunker_db_adapter(context);
                    backgroundtask backgroundtask = new backgroundtask(context);
                    try {
                        backgroundtask.execute("row_del",id);
                    } catch (Exception e) {
                        message.message(context,""+e);
                    }
                    if(context instanceof final_main) {
                        ((final_main) context).onResume();
                    }
                    //bunker_db.helper.del_row(list_get.getId());
                }});
        }if(list_get.getE_d()==0) {
            listholder.edit.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                   try {
                        int s=list_get.getId();
                        //message.message(context,""+s);
                        Activity activity;
                        Intent intent = new Intent(context, edit_subject.class);
                        intent.putExtra("id", list_get.getId());
                        context.startActivity(intent);
                    } catch (Exception e) {
                        message.message(context, "intent: " + e);
                    }
                   /* Intent intent = new Intent(context, show_row.class);
                    intent.putExtra("id", list_get.getId());
                    context.startActivity(intent);*/

                }
            });


        }
row.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(context, show_row.class);
        intent.putExtra("id", list_get.getId());
        context.startActivity(intent);
    }
});

        return row;
    }

    static class listholder
    {
        TextView sub;
        TextView per;
        TextView bunk;
        LinearLayout list_colour;
        Button edit;
        Button delete;
    }
}
