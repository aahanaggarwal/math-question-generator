package com.Aahan;

import java.text.DecimalFormat;

/**
 * Created by aahan on 16-02-2017.
 */
class heronsForm {
    private static varGen heronsForm = new varGen(3);
    static void generate(int dif){
        heronsForm.setVars(dif*4);
    }
    static String print(){
        int[] x=heronsForm.getVars();
        x[0]=Math.abs(x[0]);
        x[1]=Math.abs(x[1]);
        x[2]=Math.abs(x[2]);
        return ("Find the area of the triangle with sides\n"+x[0]+"\t"+x[1]+"\t"+x[2]);
    }
    static String answer(){
        int[] x=heronsForm.getVars();
        x[0]=Math.abs(x[0]);
        x[1]=Math.abs(x[1]);
        x[2]=Math.abs(x[2]);
        boolean valid=checkValid(x[0], x[1], x[2]);
        if(valid) {
            double s = (x[0] + x[1] + x[2]) / 2.0;
            double ans = s * (s - x[0]) * (s - x[1]) * (s - x[2]);
            double finAns = Math.sqrt(ans);
            finAns = Double.parseDouble(new DecimalFormat("##.###").format(finAns));
            if(finAns!=0)
                return ("The area of the triangle is: " + finAns);
            else
                return ("Triangle forms a line.");
        }
        else
            return ("Impossible Triangle");
    }

    private static boolean checkValid(int a, int b, int c) {
        if((a+b)<c||(b+c)<a||(a+c)<b){
            return false;
        }
        return true;
    }
}
