package com.Aahan;

/**
 * Created by aahan on 14-02-2017.
 */
class arithSum {
    private static varGen arithSum=new varGen(3);
    static void generate(int dif){
        arithSum.setVars(dif*5);
    }
    static String print(){
        int[] x=arithSum.getVars();
        x[0]=Math.abs(x[0])+1;
        return ("Find the sum of the arithmetic series with:\nn = "+x[0]+" a = "+x[1]+" d = "+x[2]);
    }
    static String answer(){
        int[] x=arithSum.getVars();
        int n=Math.abs(x[0])+1; int a=x[1]; int d=x[2];
        double sum=(n/2)*((2*a)+((n-1)*d));
        return ("The sum is: "+sum);
    }
}
