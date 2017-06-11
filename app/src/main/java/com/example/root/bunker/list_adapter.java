package com.example.root.bunker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by root on 23/5/17.
 */

public class list_adapter extends ArrayAdapter {
    private Context context;
    private ArrayList<list_get_all> list_get;
int but;
    public list_adapter(Context context, int textViewResourceId, ArrayList objects,int but) {
        super(context,textViewResourceId, objects);

        this.context= context;
        list_get=objects;
        this.but=but;

    }


    private class ViewHolder
    {
        TextView sub;
        TextView per;
        TextView bunk;
        LinearLayout list_colour;
        Button edit;
        Button delete;
        Button remove;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {View view = convertView;

            ViewHolder holder=null;
            if (convertView == null)
            {
                LayoutInflater vi = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = vi.inflate(R.layout.sub_list, null);

                holder = new ViewHolder();
                holder.sub = (TextView) convertView.findViewById(R.id.list_sub);
                holder.per = (TextView) convertView.findViewById(R.id.list_per);
                holder.bunk = (TextView) convertView.findViewById(R.id.list_bunk);
                holder.list_colour=(LinearLayout)convertView.findViewById(R.id.sub_list_layout);
                holder.edit=(Button)convertView.findViewById(R.id.sub_edit);
                holder.delete=(Button)convertView.findViewById(R.id.sub_del);
                convertView.setTag(holder);

            }
            else {
                holder = (ViewHolder) convertView.getTag();
            }
            final list_get_all individualsub= list_get.get(position);
            holder.sub.setText(individualsub.getSub());
            if(individualsub.getCp()==-1)
            {
                holder.per.setText("");
            }
                else{
            holder.per.setText(individualsub.getCp()+"%");}
        //int x=individualsub.getAb();
        //String abs=Integer.toString(x);
        holder.edit.setBackgroundColor(Color.parseColor(individualsub.getColour()));
        holder.list_colour.setBackgroundColor(Color.parseColor(individualsub.getColour()));
        holder.edit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                //message.message(context,individualsub.getSub());

                try {
                    Activity activity;
                    Intent intent = new Intent(context, edit_subject.class);
                    intent.putExtra("sub", individualsub.getSub());
                    context.startActivity(intent);
                } catch (Exception e) {
                    message.message(context,"intent: "+e);
                }
            }});
        int u=0;
        if(individualsub.getPr()==0 || individualsub.getPr()==-1){
            holder.bunk.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_action_infinite, 0);u=1;
            holder.bunk.setText("");
        }
      if(individualsub.getPr()!=0 && individualsub.getPr()!=-1){
          if(u==0){
            holder.bunk.setText(Integer.toString(individualsub.getAb()));
              holder.bunk.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
              }
      }
      //message.message(context,"but = "+but);
      if(but==1)
      {
          holder.edit.setClickable(false);
          holder.delete.setClickable(true);
          holder.edit.setVisibility(View.GONE);
          holder.delete.setVisibility(View.VISIBLE);
          holder.delete.setBackgroundColor(Color.parseColor(individualsub.getColour()));
          holder.list_colour.setBackgroundColor(Color.parseColor(individualsub.getColour()));
          holder.delete.setOnClickListener(new View.OnClickListener() {
              public void onClick(View v)
              {
                 //message.message(context,"delete");
              }});

      }if(but==0) {
        holder.edit.setBackgroundColor(Color.parseColor(individualsub.getColour()));
        holder.list_colour.setBackgroundColor(Color.parseColor(individualsub.getColour()));
        holder.edit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //message.message(context,individualsub.getSub());

                try {
                    Activity activity;
                    Intent intent = new Intent(context, edit_subject.class);
                    intent.putExtra("sub", individualsub.getSub());
                    context.startActivity(intent);
                } catch (Exception e) {
                    message.message(context, "intent: " + e);
                }
            }
        });


    }

        return convertView;


    }


}
