package com.hackerrank.algorithm.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class JimandtheOrders {

	static class Order{
		int orderTime;
		int processTime;
		int index=0;

		Order(int orderTime,int processTime,int index){
			this.orderTime=orderTime;
			this.processTime=processTime;
			this.index=index;
		}
	}

	private static void orderProcessTime(List<Order> orderList, int n) {	
		
		
		Collections.sort(orderList,new Comparator<Order>(){
			@Override
			public int compare(Order o1, Order o2) {

				int o1Time=o1.orderTime+o1.processTime;
				int o2Time=o2.orderTime+o2.processTime;

				if(o1Time < o2Time){
					return -1;
				}else if(o1Time >o2Time){
					return 1;
				}else{
					if(o1.orderTime<o2.orderTime){
						return -1;
					}else if(o1.orderTime>o2.orderTime){
						return 1;
					}else{
						return 0;
					}

				}

			}
		});
		
		for(int i=0;i<orderList.size();i++){
			System.out.print(orderList.get(i).index+" ");
		}

	}


	public static void main(String args[]){
		Scanner scanner=new Scanner(System.in);

		int n= scanner.nextInt();
		List<Order> orderList= new ArrayList<Order>();
		for(int i=0;i<n;i++){
			orderList.add(new Order(scanner.nextInt(),scanner.nextInt(),i+1));
		}
		orderProcessTime(orderList,n);
		scanner.close();
	}



}
