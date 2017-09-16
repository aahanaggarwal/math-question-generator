package com.Aahan;

/**
 * Created by aahan on 10-11-2016.
 */
class simpleQuadratic{
    private static varGen simpleQuadratic=new varGen(3);
    static void generate(int dif){
        int setting=dif*3;
        simpleQuadratic.setVars(setting);
    }
    static String print(){
        int[] x=simpleQuadratic.getVars();
        return ("Solve for x: \n"+x[0] + "x\u00B2 + " + x[1] + "x + " + x[2] + " = 0");
    }
    static String answer(){
        int[] x=simpleQuadratic.getVars();
        int a=x[0];
        int b=x[1];
        int c=x[2];
        boolean noRoots=((b*b)-(4*a*c))<0;
        double ans1=(((0-b)+Math.sqrt((b*b)-(4*a*c)))/(2*a));
        ans1=(int)(ans1*1000);
        ans1/=1000;
        double ans2=(((0-b)-Math.sqrt((b*b)-(4*a*c)))/(2*a));
        ans2=(int)(ans2*1000);
        ans2/=1000;
        if(!noRoots) {
            return ("The roots are: " + ans1 + ", " + ans2);
        }
        else{
            return ("No Real roots");
        }
    }
}
