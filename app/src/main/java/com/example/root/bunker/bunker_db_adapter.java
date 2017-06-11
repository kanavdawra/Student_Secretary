package com.example.root.bunker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;


public class bunker_db_adapter {
    bunker_db helper;
    public bunker_db_adapter(Context context){
        helper=new bunker_db(context);
    }


    public long insertdata(String sub,int ld,int la,int pr,int ls, String add){
        int lb=0;float cp=0;String colour="#E7AEAEA6";
       // message.message(helper.context,"database  1    : ld: "+ld+" la: "+la+" pr: "+pr+" ls: "+ls);

        if(ld!=-1)
        {
            if(la==-1)
            {la=0;}
            if(pr==-1)
            {pr=0;}
            int ldd=ld,laa=la;

            lb=ldd-laa;
            float c=0,a=(float)laa,d=(float)ldd;
            cp=a/d;
            cp=cp*100;

            if(cp<pr)
            {
                colour="#d6e2393b";
            }
            else if(cp>pr){
                colour="#d41fa42c";
                d = d + ls;
                c = a / d;
                c = c * 100;

                if (c < pr) {
                    colour = "#e1e100";
                }
            }

            cp= (float)Math.round(cp * 100) / 100;
            float c1;int c0;
            c1=(float)Math.round(cp * 10) / 10;
            c0=(int)Math.round(cp);
            if(cp==c1)
            {
                cp=c1;
                if(cp==c0)
                {cp=(float) c0;
                }
            }else{ cp= (float)Math.round(cp * 100) / 100;
            }

        }
        if(ld==-1)
        {
            ld=-1;
            lb=-1;
            la=-1;
            pr=-1;
            colour="#E7AEAEA6";
            cp=-1;
            ls=-1;
        }
if(pr==0)
{
    colour="#d41fa42c";
}

int mb=0;
if(pr!=0 && pr!=-1){
        mb = bunk(ld,la,ls,cp,pr);}
        else
{mb=1;}

        SQLiteDatabase db=helper.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(bunker_db.SUB,sub);
        contentValues.put(bunker_db.ADD,add);
        contentValues.put(bunker_db.L_D,ld);
        contentValues.put(bunker_db.L_A,la);
        contentValues.put(bunker_db.L_B,lb);
        contentValues.put(bunker_db.P_R,pr);
        contentValues.put(bunker_db.C_P,cp);
        contentValues.put(bunker_db.L_S,ls);
        contentValues.put(bunker_db.A_B,mb);
        contentValues.put(bunker_db.C_C,colour);

        long id=db.insert(bunker_db.TABLE_NAME,null,contentValues);
        db.close();
        return id;

    }
    public int bunk(int ld,int la,int ls,float cp,float pr){
        float mb=0,a=(float) la,d=(float) ld;
        float s=(float) ls;
        int i=1,j,k,l,b=0;
        float c;
        c=a/d;
        c=c*100;
        if(cp<pr){
        while(i>0)
        { c=a/d;
            c=c*100;
            if(c>=pr){break;}
            a=a+s;
            d=d+s;
            b++;

        }
        b=b*-1;
            return b;
        }
        if(cp>=pr)
        {d=d+s;
            while(i>0)
            { c=a/d;
                c=c*100;
                if(c<pr){break;}
                d=d+s;
                b++;

            }
        }
        return b;
    }
    public String getdata() {
        String selectQuery = "SELECT  * FROM " + bunker_db.TABLE_NAME;
        SQLiteDatabase db  = helper.getReadableDatabase();
        Cursor cursor      = db.rawQuery(selectQuery, null);
        StringBuffer buffer=new StringBuffer();
        while (cursor.moveToNext()){
            int cid=cursor.getInt(0);
            String sub=cursor.getString(1);
            String add=cursor.getString(2);
            int ld=cursor.getInt(3);
            int la=cursor.getInt(4);
            int lb=cursor.getInt(5);
            int pr=cursor.getInt(6);
            buffer.append(cid+" "+sub+" "+add+" "+ld+" "+la+" "+lb+" "+pr+"\n");
        }

        cursor.close();
        return buffer.toString();
    }
public long updatedata(String sub,int ld,int la,int pr,int ls,String add,int id){
    int lb=0;float cp=0;String colour="#E7AEAEA6";
    if(ld!=-1)
    {
        if(la==-1)
        {la=0;}
        if(pr==-1)
        {pr=0;}
        int ldd=ld,laa=la;

        lb=ldd-laa;
        float c=0,a=(float)laa,d=(float)ldd;
        cp=a/d;
        cp=cp*100;

        if(cp<pr)
        {
            colour="#d6e2393b";
        }
        else if(cp>pr){
            colour="#d41fa42c";
            d = d + ls;
            c = a / d;
            c = c * 100;

            if (c <= pr) {
                colour = "#e1e100";
            }
        }

        cp= (float)Math.round(cp * 100) / 100;
        float c1;int c0;
        c1=(float)Math.round(cp * 10) / 10;
        c0=(int)Math.round(cp);
        if(cp==c1)
        {
            cp=c1;
            if(cp==c0)
            {cp=(float) c0;
            }
        }else{ cp= (float)Math.round(cp * 100) / 100;
        }

    }
    if(ld==-1)
    {
        ld=-1;
        lb=-1;
        la=-1;
        pr=-1;
        colour="#E7AEAEA6";
        cp=-1;
        ls=-1;
    }
    if(pr==0)
    {
        colour="#d41fa42c";
    }

    int mb=0;
    if(pr!=0 && pr!=-1){
        mb = bunk(ld,la,ls,cp,pr);}
    else
    {mb=1;}
    if(mb==0){colour = "#e1e100";}
    ContentValues con = new ContentValues();
    con.put(bunker_db.ADD, add);
    con.put(bunker_db.L_D, ld);
    con.put(bunker_db.L_A, la);
    con.put(bunker_db.P_R,pr);
    con.put(bunker_db.C_P,cp);
    con.put(bunker_db.L_S,ls);
    con.put(bunker_db.A_B,mb);
    con.put(bunker_db.C_C,colour);
    SQLiteDatabase db=helper.getWritableDatabase();
    //long id=db.update(bunker_db.TABLE_NAME, con, sub + "=" + bunker_db.SUB,null);
    //long id=db.update(bunker_db.TABLE_NAME,con,bunker_db.SUB +"="+ sub,null);
    String update="UPDATE " + bunker_db.TABLE_NAME + " SET " + bunker_db.ADD + "= '" + add +"', "+ bunker_db.L_D + "= '" + ld +"', "+ bunker_db.SUB + "= '" + sub +"', "+ bunker_db.L_A + "= '" + la +"', "+ bunker_db.L_B + "= '" + lb +"', "+ bunker_db.L_S + "= '" + ls +"', "+ bunker_db.P_R + "= '" + pr +"', "+ bunker_db.C_P + "= '" + cp +"', "+ bunker_db.A_B + "= '" + mb +"', "+ bunker_db.C_C + "= '" + colour +"' "+ " WHERE " + bunker_db.UID +"= "+ id ;
      //String update="UPDATE subjects SET lec_add= '123' WHERE subject= 'jsjs';";
   String row_if="SELECT COUNT(*) FROM subjects WHERE _id= "+id;
    long x=0;
    try {
        db.execSQL(update);
        Cursor cursor = db.rawQuery("SELECT COUNT(*) FROM subjects WHERE _id=? ",new String[] { String.valueOf(id) });
        int count = 0;
        if(null != cursor)
            if(cursor.getCount() > 0){
                cursor.moveToFirst();
                count = cursor.getInt(0);
            }
        cursor.close();

    } catch (SQLException e) {
       x=-1;
       // message.message(helper.context,""+x);
    }
    return x;
}
    public ArrayList<list_get_all> getData() {
        SQLiteDatabase db = helper.getWritableDatabase();
        ArrayList<list_get_all> sub= new ArrayList<list_get_all>();
        Cursor result = db.rawQuery("select * from " + bunker_db.TABLE_NAME , null);

            while(result.moveToNext()){
                //sub.add( new list_get_all(result.getString(result.getColumnIndex(bunker_db.SUB)), result.getString(result.getColumnIndex(bunker_db.ADD)), result.getString(result.getColumnIndex(bunker_db.C_C)), result.getFloat(result.getColumnIndex(bunker_db.C_P)), result.getInt(result.getColumnIndex(bunker_db.A_B)), result.getInt(result.getColumnIndex(bunker_db.P_R))));

            }

result.close();
        return sub;
    }

    public long rowcount() {
        SQLiteDatabase db = helper.getWritableDatabase();
        DatabaseUtils du=new DatabaseUtils();
        long cnt  = du.queryNumEntries(db, bunker_db.TABLE_NAME);
        db.close();
        return cnt;
    }
    public Cursor getData(SQLiteDatabase db){
        //SQLiteDatabase db = helper.getReadableDatabase();
        String[] data={bunker_db.SUB,bunker_db.ADD,bunker_db.C_C,bunker_db.C_P,bunker_db.A_B,bunker_db.P_R,bunker_db.UID};
        Cursor cursor = db.query(bunker_db.TABLE_NAME,data, null,null,null,null,null);


        return cursor;
    }
    public Cursor getrow(int id){
        SQLiteDatabase db=helper.getWritableDatabase();
        Cursor result = null;
        try {
            result = db.rawQuery("SELECT * FROM " + bunker_db.TABLE_NAME +" WHERE _id= "+id , null);
        } catch (Exception e) {
            message.message(helper.context,""+e);
        }
        return result;
    }
    public boolean row_del(int id){
        int x=0;
        SQLiteDatabase db=helper.getWritableDatabase();
        return db.delete(bunker_db.TABLE_NAME, bunker_db.UID + "=" + id, null) > 0;

    }
    public String[] getlist(){

        String[] sub = new String[]{bunker_db.SUB,bunker_db.C_P,bunker_db.C_C};
        return sub;
    }
    static class bunker_db extends SQLiteOpenHelper{
        private static final String DATABASE_NAME="bunker_db";
        private static final String TABLE_NAME="subjects";
        private static final int DATABASE_VERSION =1;
         static final String UID="_id";
         static final String SUB="subject";
         static final String L_D="lec_del";
         static final String L_A="lec_att";
         static final String L_B="lec_bunk";
         static final String L_S="lec_size";
         static final String P_R="per_req";
         static final String ADD="lec_add";
         static final String C_P="cur_per";
         static final String C_C="colour";
         static final String A_B="avl_bunk";
        private Context context;
        private static final String create_table="CREATE TABLE "+TABLE_NAME+" ("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+SUB+" VARCHAR(255) UNIQUE, "+ADD+" VARCHAR(255), "+L_D+" INTEGER, "+L_A+" INTEGER, "+L_B+" INTEGER, "+P_R+" INTEGER, "+L_S+" INTEGER, "+A_B+" INTEGER, "+C_P+" decimal(3,4), "+C_C+" VARCHAR(225));";
        public bunker_db(Context context){
            super(context,DATABASE_NAME,null,DATABASE_VERSION);
            this.context=context;
            //message.message(context,"constucter was called");
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

            try {
                db.execSQL(create_table);
                //message.message(context,"oncreate");
            } catch (SQLException e) {
                message.message(context,""+e);
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}
