package com.hackerrank.contests.weekofcode34;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class SameOccurence {

	private static class Occurence{
		List<Integer> list= new ArrayList<Integer>();
		int countx=0;
		int county=0;
		
		Occurence(int x,int y){
			this.countx=x;
			this.county=y;
		}

		public void setList(List<Integer> list){
			this.list=list;
		}

		public List<Integer> getList(){
			return this.list;
		}
	}

	public static int findSubsetCount(int[] arr,int x,int y){
		int maxSubSet=0;
		HashMap<Integer,List<Occurence>> hMap = new HashMap<Integer,List<Occurence>>();
		List<Occurence> list= new ArrayList<Occurence>();
		List<Integer> listO= new ArrayList<Integer>();
		List<Integer> list1= new ArrayList<Integer>();

		Occurence occ= new Occurence(0,0);
		occ.setList(listO);

		Occurence occ1= new Occurence(0,0);
		list1.add(arr[0]);
		occ.setList(list1);
		if(arr[0]==x){
			occ.countx=1;
		}else if(arr[0]==y){
			occ.county=1;
		}else{
			maxSubSet++;
		}		

		list.add(occ);
		list.add(occ1);
		hMap.put(0,list);

		for(int i=1;i<arr.length;i++){
			List<Occurence> listNew = new  ArrayList<Occurence>();	
			List<Occurence> listPrev = hMap.get(i-1);
			listNew.addAll(listPrev);
			for(Occurence oc :listPrev){
				List<Integer> lt= oc.getList();
				if(lt.isEmpty() || lt.get(lt.size()-1)==arr[i-1]){
					Occurence newoc= new Occurence(oc.countx,oc.county);
					List<Integer> ltn=new ArrayList<Integer>();
					ltn.addAll(lt);
					ltn.add(arr[i]);
					newoc.setList(ltn);
					if(arr[i]==x){
						newoc.countx=oc.countx+1;
					}else if(arr[i]==y){
						newoc.county=oc.county+1;
					}
					if(newoc.countx==newoc.county){
						maxSubSet++;
					}
					listNew.add(newoc);
				}
			}
			hMap.put(i, listNew);
		}
		return maxSubSet;
	}





	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int q = in.nextInt();
		int[] arr = new int[n];
		for(int arr_i = 0; arr_i < n; arr_i++){
			arr[arr_i] = in.nextInt();
		}
		for(int a0 = 0; a0 < q; a0++){
			int x = in.nextInt();
			int y = in.nextInt();
			int value=findSubsetCount(arr,x,y);
			System.out.println(value);
		}
		in.close();
		
		/*int arr[] = new int[]{1,2,3,4,5};
		int value=findSubsetCount(arr,1,2);
		System.out.println(value);*/
	}


}
