package com.Aahan;

/**
 * Created by aahan on 13-02-2017.
 */
class geoSum {
    private static varGen GeoSum=new varGen(2);
    static void generate(int dif){
        int setting = 3*dif;
        GeoSum.setVars(setting);
    }
    static String print(){
        int[] x=GeoSum.getVars();
        double r=1.0/x[1];
        return ("Find the sum of the infinite series with\na = "+x[0]+" r = "+r);
    }
    static String answer(){
        int[] x=GeoSum.getVars();
        double r=1.0/x[1];
        double ans=(x[0])/(1-r);
        return ("The sum is: "+ans);
    }
}
