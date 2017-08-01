package com.hackerrank.algorithm.greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/*
 * https://www.hackerrank.com/challenges/luck-balance
 */
public class LuckBalance {
	
	static class Luck{
		int importance;
		int balance;
		
		Luck(int importance,int balance){
			this.importance=importance;
			this.balance=balance;
		}
	}
	
	private static void findMaxLuckBalance(List<Luck> luckList,int k) {
		int balance=0;
		int importantLoses=0;
		luckList.sort(new Comparator<Luck>(){
			public int compare(Luck luck1,Luck luck2){
				if(luck1.balance>luck2.balance){
					return -1;
				}else if(luck2.balance>luck1.balance){
					return 1;
				}else{
					return 0;
				}
			}					
		});
		
		for(Luck luck:luckList){
			if(luck.importance==0){
				balance = balance +luck.balance;
			}
			if(luck.importance==1){
				if(importantLoses<k){
					balance = balance +luck.balance;
					importantLoses++;
				}else{
					balance= balance-luck.balance;
				}
			}	
		}
		System.out.println(balance);
	}
		
	
	public static void main(String args[]){
		Scanner scanner =new Scanner(System.in);
		int n=scanner.nextInt();
		int k=scanner.nextInt();
		List<Luck> luckList=new ArrayList<Luck>();
		for(int i=0;i<n;i++){
			int balance=scanner.nextInt();
			int imp=scanner.nextInt();
			luckList.add(new Luck(imp,balance));
		}
		findMaxLuckBalance(luckList,k);
		scanner.close();
	}

	
}
