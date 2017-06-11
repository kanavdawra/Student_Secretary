package com.example.root.bunker;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListView;

/**
 * Created by root on 24/5/17.
 */

public class backgroundtask extends AsyncTask<String,list_get_all,String> {

    Context ctx;
    listadapter listadapter;
    Activity activity;
    ListView listview;
    backgroundtask(Context ctx){
        this.ctx=ctx;
        activity=(Activity) ctx;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }
    @Override
    protected String doInBackground(String... params) {


            bunker_db_adapter bunker_db;
        edit_subject edit_subject;
            bunker_db=new bunker_db_adapter(ctx);
            String method=params[0];
            String but=params[1];

        if(method.equals("set_data")){
            String subj=params[1];
            int ldh=Integer.parseInt(params[2]);
            int lah=Integer.parseInt(params[3]);
            int prh=Integer.parseInt(params[4]);
            int lsh=Integer.parseInt(params[5]);
            String addr=params[6];
            long id=bunker_db.insertdata(subj,ldh,lah,prh,lsh,addr);
        if(id<0)
        {return "Unfortunatly: Subject Data was not Saved  Either: Subject is not unique Or Something went wrong :(";
        }
        else {
            return "Subject Data Saved Successfully";
        }
        }
        if(method.equals("update_data")){
            String subj=params[1];
            int ldh=Integer.parseInt(params[2]);
            int lah=Integer.parseInt(params[3]);
            int prh=Integer.parseInt(params[4]);
            int lsh=Integer.parseInt(params[5]);
            String addr=params[6];
            int id =Integer.parseInt(params[7]);
            long d=bunker_db.updatedata(subj,ldh,lah,prh,lsh,addr,id);
            if(d<0)
            {return "Unfortunatly: Subject Data was not Saved  Either: Subject is not unique Or Something went wrong :(";
            }
            else {
                return "Subject Data Saved Successfully";
            }
        }
        else if(method.equals("get_data")){


                SQLiteDatabase db=bunker_db.helper.getReadableDatabase();
                Cursor cursor=bunker_db.getData(db);
                listview=(ListView)activity.findViewById(R.id.list_view);
                listadapter =new listadapter(ctx,R.layout.sub_list);
                String sub,colour,add;
                int ab,e_d,pr,r=0,id;
                float cp;
                r=1;
                e_d=Integer.parseInt(but);
                while (cursor.moveToNext()){
                    sub=cursor.getString(cursor.getColumnIndex(bunker_db.helper.SUB));
                    add=cursor.getString(cursor.getColumnIndex(bunker_db.helper.ADD));
                    colour=cursor.getString(cursor.getColumnIndex(bunker_db.helper.C_C));
                    ab=cursor.getInt(cursor.getColumnIndex(bunker_db.helper.A_B));
                    pr=cursor.getInt(cursor.getColumnIndex(bunker_db.helper.P_R));
                    cp=cursor.getFloat(cursor.getColumnIndex(bunker_db.helper.C_P));
                    id=cursor.getInt(cursor.getColumnIndex(bunker_db.helper.UID));
                    list_get_all list_get_all=new list_get_all(sub,add,colour,cp,ab,pr,e_d,id);
                    publishProgress(list_get_all);
                }
                return "get_data";
            }
            else if(method.equals("get_row")){

            int id;
            String di;
            di=params[1];
            id=Integer.parseInt(di);
            SQLiteDatabase db=bunker_db.helper.getReadableDatabase();
            Cursor cursor=bunker_db.getrow(id);

            String sub,colour,add;
            int ld,la,ls,lb,ab,pr,e_d=0;float cp;

            sub=cursor.getString(cursor.getColumnIndex(bunker_db.helper.SUB));
            add=cursor.getString(cursor.getColumnIndex(bunker_db.helper.ADD));
            colour=cursor.getString(cursor.getColumnIndex(bunker_db.helper.C_C));
            ab=cursor.getInt(cursor.getColumnIndex(bunker_db.helper.A_B));
            pr=cursor.getInt(cursor.getColumnIndex(bunker_db.helper.P_R));
            cp=cursor.getFloat(cursor.getColumnIndex(bunker_db.helper.C_P));
            ld=cursor.getInt(cursor.getColumnIndex(bunker_db.helper.L_D));
            la=cursor.getInt(cursor.getColumnIndex(bunker_db.helper.L_A));
            lb=cursor.getInt(cursor.getColumnIndex(bunker_db.helper.L_B));
            ls=cursor.getInt(cursor.getColumnIndex(bunker_db.helper.L_S));
            //rowentryy rowentryy=new rowentryy(sub,add,colour,cp,ab,pr,id,ld,la,lb,ls);
            //edit_subject edit_subject1=new edit_subject();
           // edit_subject1.getvalue(sub,add,colour,cp,ab,pr,id,ld,la,lb,ls);

        }
else if(method.equals("row_del")){
            int id;
            String di;
            di=params[1];
            id=Integer.parseInt(di);
            boolean x=bunker_db.row_del(id);
            if(x==false)
                return "Something went Wrong :(   Try restarting the app";
            else{return "Successfully Deleted :)";
            }
        }
return null;
    }




    @Override
    protected void onProgressUpdate(list_get_all... values) {

listadapter.add(values[0]);

    }


    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        if(result.equals("get_data"))
        {
            listview.setAdapter(listadapter);
        }
        else{
        message.message(ctx,""+result);}
    }
}
