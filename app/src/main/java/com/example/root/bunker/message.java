package com.example.root.bunker;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by root on 20/5/17.
 */

public class message {
    public static void message(Context context,String message){
        Toast.makeText(context,message,Toast.LENGTH_LONG).show();
    }
}
