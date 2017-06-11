package com.example.root.bunker;

import android.content.Context;

/**
 * Created by root on 23/5/17.
 */

public class list_get_all {


    private String sub;
    private String add;
    private String colour;
    private float cp;
    private int ab;
    private int e_d;
    private int pr;
    private int id;
Context context;


    public list_get_all(String sub, String add, String colour, float cp, int ab,int pr,int e_d,int id) {
        this.colour = colour;
        this.sub = sub;
        this.add = add;
        this.cp = cp;
        this.ab = ab;
        this.pr = pr;
        this.id = id;
        this.e_d = e_d;

    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public float getCp() {
        return cp;
    }

    public void setCp(float cp) {
        this.cp = cp;
    }

    public int getAb() {
        try {
            return ab;
        } catch (Exception e) {
            message.message(context,"getter ab");
        }
        return ab;
    }

    public void setAb(int ab) {
        this.ab = ab;
    }

    public int getPr() {
        return pr;
    }

    public void setPr(int pr) {
        this.pr = pr;
    }

    public int getE_d() {
        return e_d;
    }

    public void setE_d(int e_d) {
        this.e_d = e_d;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}