package com.example.root.bunker;

import android.content.Context;

/**
 * Created by root on 23/5/17.
 */

public class rowentryy {


    private String sub;
    private String add;
    private String colour;
    private float cp;
    private int ab;
    private int pr;
    private int id;
    private int ld,la,lb,ls;
    Context context;


    public rowentryy(String sub, String add, String colour, float cp, int ab, int pr, int id, int ld, int la, int lb, int ls) {
        this.colour = colour;
        this.sub = sub;
        this.add = add;
        this.cp = cp;
        this.ab = ab;
        this.pr = pr;
        this.id = id;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLd() {
        return ld;
    }

    public void setLd(int ld) {
        this.ld = ld;
    }

    public int getLa() {
        return la;
    }

    public void setLa(int la) {
        this.la = la;
    }

    public int getLb() {
        return lb;
    }

    public void setLb(int lb) {
        this.lb = lb;
    }

    public int getLs() {
        return ls;
    }

    public void setLs(int ls) {
        this.ls = ls;
    }
}