package com.Aahan;

import java.util.Random;

/**
 * Created by aahan on 10-11-2016.
 */

class varGen {
    private int varNo;
    private int[] vars;
    varGen(int varNo) {
        this.varNo = varNo;
        vars=new int[varNo];
    }
    void setVars(int MinMax){
        for (int i=0; i<varNo; i++){
            Random r=new Random();
            vars[i]=((r.nextInt(MinMax-1))+1)*(r.nextInt(2)==0?-1:1);
        }
        vars[0]=Math.abs(vars[0]);
    }

    int[] getVars() {
        return vars;
    }
}