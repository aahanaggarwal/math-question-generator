package com.Aahan;

/**
 * Created by aahan on 17-11-2016.
 */
class simpVectors {
    private static varGen simpVector=new varGen(5);
    private static String type;
    static void generate(int dif){
        int setting = dif*3;
        simpVector.setVars(setting);
    }
    static String print(){
        int x[] = simpVector.getVars();
        type=chooseQuestion(x[4]);
        switch (type){
            case "add": return ("Find the sum of the following vectors\n"+x[0]+"i +"+x[1]+"j and "+x[2]+"i + "+x[3]+"j");
            case "dot": return ("Find the dot product of the following vectors\n"+x[0]+"i +"+x[1]+"j and "+x[2]+"i + "+x[3]+"j");
            default: return ("Please restart");
        }
    }
    private static String chooseQuestion(int a){
        a=Math.abs(a%2);
        switch (a){
            case 0: return ("add");
            case 1: return ("dot");
            default: return ("Error");
        }
    }
    static String answer(){
        int[] x=simpVector.getVars();
        int x1=x[0];
        int y1=x[1];
        int x2=x[2];
        int y2=x[3];
        switch (type){
            case "add":
                int resX=x1+x2;
                int resY=y1+y2;
                return ("The resultant vector is: "+ resX+"i + "+resY+"j");
            case "dot":
                double dotProd=(x1*x2)+(y1*y2);
                return ("The dot product is: "+dotProd);
            default:
                return ("INVALID");

        }
    }
}
