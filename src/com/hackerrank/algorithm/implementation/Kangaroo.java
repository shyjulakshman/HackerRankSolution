package com.hackerrank.algorithm.implementation;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Kangaroo {

    static String kangaroo(int x1, int v1, int x2, int v2) {
        if((x1>x2 && v1>=v2) || (x2>x1 && v2>=v1)){
          return "NO";
        }
        
        if((x1==x2) && (v1!=v2)){
          return "NO";
        }
        int y=1;
        int min = Math.min(x1,x2);
        int origMin=min;
        int minVel = x1<x2? v1: v2;        
        int max= Math.max(x1,x2);
        int origMax=max;
        int maxVel = x1>x2? v1: v2;
        
        while(min<max){    
            min = origMin + (minVel*y);
            max = origMax + (maxVel*y);
            if(min==max){
               return "YES";
            }else{              
              y++;
            }
         }
       return "NO";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x1 = in.nextInt();
        int v1 = in.nextInt();
        int x2 = in.nextInt();
        int v2 = in.nextInt();
        String result = kangaroo(x1, v1, x2, v2);
        System.out.println(result);
    }
}
