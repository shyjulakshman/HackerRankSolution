package com.hackerrank.algorithm.strings;

import java.util.Scanner;
import java.util.Stack;

public class SuperReducedString {
	
	static String super_reduced_string(String s){
		int index=0;
		while(index<s.length()-1){
			if(s.charAt(index)==s.charAt(index+1)){
				s= s.substring(0,index) + s.substring(index+2, s.length());
				index=0;
			}else{
				index++;
			}
		}
		return (s!=null && s.length()>0)? s: "Empty String";
   
    }
	
	static String super_reduced_string_Stack(String s){		
		Stack<Character> stack =new Stack<Character>();
		for(int i=0;i<s.length();i++){
			if(!stack.isEmpty() && stack.peek()==s.charAt(i)){
				stack.pop();
			}else{
				stack.add(s.charAt(i));
			}
		}
		if(stack.isEmpty()){
			return "Empty String";
		}
		StringBuffer buf = new StringBuffer();
		while(!stack.isEmpty()){
			buf.append(stack.pop());
		}
		return buf.reverse().toString();
   
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = super_reduced_string_Stack(s);
        System.out.println(result);
    }

}
