package com.Aahan;

/**
 * Created by aahan on 12-11-2016.
 */
class compMult {
    private static varGen compMult=new varGen(4);
    static void generate(int dif){
        int setting = 3*dif;
        compMult.setVars(setting);
    }
    static String print(){
        int[] x=compMult.getVars();
        return ("Find the resulting complex number\n ("+x[0]+" + "+x[1]+"i)("+x[2]+" + "+x[3]+"i)");
    }
    static String answer(){
        int[] x=compMult.getVars();
        int real=(x[0]*x[2])-(x[1]*x[3]);
        int imag=(x[0]*x[3])+(x[1]*x[2]);
        return("The resulting number is: ("+real+" + "+imag+"i)");
    }
}
