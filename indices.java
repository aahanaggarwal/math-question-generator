package com.Aahan;

/**
 * Created by aahan on 16-02-2017.
 */
class indices{
    private static varGen indices = new varGen(8);
    static void generate(int dif){
        indices.setVars(dif*4);
    }
    static String print(){
        int[] x=indices.getVars();
        char c1=x[2]%2==0?'/':'*';
        char c2=x[5]%2==0?'/':'*';
        String part1=x[0]+"^("+x[1]+")";
        String part2=x[3]+"^("+x[4]+")";
        String part3=x[6]+"^("+x[7]+")";
        return (part1+" "+c1+" "+part2+" "+c2+" "+part3);
    }
    static String answer(){
        int[] x=indices.getVars();
        double part1=Math.pow(x[0], x[1]);
        double part2=Math.pow(x[3], x[4]);
        double part3=Math.pow(x[6], x[7]);
        char c1=x[2]%2==0?'/':'*';
        char c2=x[5]%2==0?'/':'*';
        double part4=c1=='*'?part1*part2:part1/part2;
        double part5=c2=='*'?part4*part3:part4/part3;
        double ans=part5;
        return ("The answer is: "+ans);
    }
}
