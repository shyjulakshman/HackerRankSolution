package com.hackerrank.algorithm.implementation;

import java.util.Scanner;

public class TheTimeinWords {
	
	private static String printTime(int hour, int min) {
		String[] hourName= new String[]{"one","two","three","four","five","six","seven","eight","nine","ten",
				"eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen","twenty"};
		if(min==0){
			return hourName[hour-1]+" o' clock";
		}else if((min>0 && min<15) || (min>15&& min<=20)){
			if(min==1){
				return hourName[min-1]+" minute past "+hourName[hour-1];
			}else{
				return hourName[min-1]+" minutes past "+hourName[hour-1];
			}
		}else if(min==15){
			return "quarter past "+hourName[hour-1];
		}else if(min>20 && min<30){
			return "twenty "+hourName[min-21]+" minutes past "+hourName[hour-1];
		}else if(min==30){
			return "half past "+hourName[hour-1];
		}else if(min>30 && min<40){
			return "twenty "+ hourName[60-min-21]+ " minutes to "+hourName[hour];
		}else if((min>=40 && min<45)){
			if(min==40){
				return "twenty minutes to "+hourName[hour];
			}else{
				return hourName[59-min]+ " minutes to "+hourName[hour];
			}			
		}else if(min==45){
			return "quarter to "+hourName[hour];
		}else if(min>45 && min < 60){
			if(min==59){
				return hourName[59-min]+ " minute to "+hourName[hour];
			}else{
				return hourName[59-min]+ " minutes to "+hourName[hour];
			}
		}
		return null;
	}
	
	public static void main(String args[]){
		Scanner scanner=new Scanner(System.in);
		int hour=scanner.nextInt();
		int min=scanner.nextInt();		
		System.out.println(printTime(hour,min));
	}

	

}
