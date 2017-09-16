package com.Aahan;

import java.text.DecimalFormat;

/**
 * Created by aahan on 15-02-2017.
 */
class logs {
    private static varGen logs=new varGen(5);
    static void generate(int dif){
        logs.setVars(dif*4);
    }
    static String print(){
        int[] x=logs.getVars();
        x[0]=Math.abs(x[0]);
        x[1]=Math.abs(x[1]);
        x[2]=Math.abs(x[2]);
        x[3]=Math.abs(x[3]);
        char c=x[4]%2==0?'/':'*';
        return ("Find the value of\nlog"+x[0]+"("+x[1]+") "+c+" log"+x[2]+"("+x[3]+")");
    }
    static String answer(){
        int[] x=logs.getVars();
        x[0]=Math.abs(x[0]);
        x[1]=Math.abs(x[1]);
        x[2]=Math.abs(x[2]);
        x[3]=Math.abs(x[3]);
        char c=x[4]%2==0?'/':'*';
        double part1=Math.log(x[1])/Math.log(x[0]);
        double part2=Math.log(x[3])/Math.log(x[2]);
        double ans=c=='*'?part1*part2:part1/part2;
        ans=Double.parseDouble(new DecimalFormat("##.###").format(ans));
        return ("The value is: "+ans);
    }
}
