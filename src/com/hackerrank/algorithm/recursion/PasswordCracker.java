package com.hackerrank.algorithm.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/*
 * https://www.hackerrank.com/challenges/password-cracker
 */

public class PasswordCracker {

	private static boolean checkIfValid(String checkString, int startIndex, int endIndex, List<String> passwords,
			List<String> result,boolean isValid,int minLength,int maxLength,HashMap<String,Boolean> hMap) {

		if(startIndex < checkString.length() && endIndex <=checkString.length()){
			int origStartIndex=-1;
			int origEndIndex= -1;
			String subString=checkString.substring(startIndex,endIndex);
			if(passwords.contains(subString)){
				origStartIndex=startIndex;
				origEndIndex=endIndex;
				result.add(subString);		
				startIndex=endIndex;
				endIndex=startIndex+minLength;
				isValid=true;
				
			}else{
				isValid=false;
				endIndex=endIndex+1;
				if(endIndex-startIndex>maxLength || endIndex>checkString.length()){
					return false;
				}
			}			
			for(int i=0;i<maxLength;i++){
				if(hMap.containsKey(startIndex+"-"+endIndex)){
					isValid=hMap.get(startIndex+"-"+endIndex);
				}else{
					isValid=checkIfValid(checkString,startIndex,endIndex,passwords,result,isValid,minLength,maxLength,hMap);
					hMap.put(startIndex+"-"+endIndex,isValid);
				}
				System.out.println(subString+" "+startIndex+" "+endIndex+" "+isValid);
				hMap.put(subString, isValid);
				if(!isValid){					
					if(origStartIndex>-1 && origEndIndex>-1 && ((origEndIndex+1-origStartIndex)<=maxLength) && (origEndIndex+1<=checkString.length() )){
						startIndex=origStartIndex;
						endIndex= origEndIndex+1;
						if(!result.isEmpty()){
							String str=checkString.substring(origStartIndex,origEndIndex);
							if(result.get(result.size()-1).equals(str)){
								result.remove(result.size()-1);
							}							
						}						
					}else{
						break;
					}				
							
				}else{
					break;
				}
			}
		}
		
		return isValid;

	}	

	

	private static void checkIfPasswordValid(String checkString, List<String> passwords,int minLength,int maxLength) {
		List<String> results=new ArrayList<String>();
		boolean valid=false;
		HashMap<String,Boolean> hMap=new HashMap<String,Boolean>();
		valid= checkIfValid(checkString,0,minLength,passwords,results,valid,minLength,maxLength,hMap);
		if(!valid){
			System.out.println("WRONG PASSWORD");
		}else{
			for(String result:results){
				System.out.print(result+" ");
			}		
			System.out.println("");
		}
	}



	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
		int noOfCases= scanner.nextInt();
		List<String> passwords= new ArrayList<String>();		
		for(int i=0;i<noOfCases;i++){
			int noOfPwds= scanner.nextInt();
			int minLength= Integer.MAX_VALUE;
			int maxLength= Integer.MIN_VALUE;
			for(int j=0;j<noOfPwds;j++){
				String pwd= scanner.next();
				passwords.add(pwd);
				if(pwd.length()<minLength){
					minLength=pwd.length();
				}
				if(pwd.length()>maxLength){
					maxLength=pwd.length();
				}
			}
			String checkString= scanner.next();
			checkIfPasswordValid(checkString,passwords,minLength,maxLength);
		}

	}
}
