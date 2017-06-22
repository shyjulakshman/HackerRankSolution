package com.hackerrank.algorithm.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class GridlandMetro {
	
	private static class Track{
		int row;
		int columnStart;
		int columnEnd;
		
		Track(int row,int columnStart,int columnEnd){
			this.row=row;
			this.columnStart=columnStart;
			this.columnEnd=columnEnd;
		}
		
	}
	
	private static long findCount(HashMap<Integer,List<Track>> hMap) {;
	    long count=0;
		Set<Entry<Integer,List<Track>>> set = hMap.entrySet();
		Iterator<Entry<Integer,List<Track>>> iter= set.iterator();
		while(iter.hasNext()){
			Entry<Integer,List<Track>> entry = iter.next();
			int row= entry.getKey();
			List<Track> trackList= entry.getValue();
			for(Track track:trackList){
				int columnStart = track.columnStart;
				int columnEnd= track.columnEnd;
				count += (columnEnd-columnStart)+1;
			}
			
		}		
		return count;
	}
	
	
	
	public static List<Track> getTrackList(List<Track> list, Track e){
		
		if(list.isEmpty()){
			list.add(e);
		}else{
			int index=0;
			while(index<list.size()){
				Track cur= list.get(index);		
				
				// cur 3 4   e  4 5
				if(e.columnStart==cur.columnEnd){
					cur.columnEnd=e.columnEnd;
					return list;
				}
				
				// cur 3 4  e 1 3
				if(e.columnEnd==cur.columnStart){
					cur.columnStart=e.columnStart;
					return list;
				}
				
				
				//if within range ignore
				if(e.columnStart>=cur.columnStart && e.columnEnd<=cur.columnEnd){
					return list;
				}
				
			
				if(e.columnStart<cur.columnStart && e.columnEnd==cur.columnEnd){
					cur.columnStart=e.columnStart;
					if(index>0){
						Track prev= list.get(index-1);
						if(prev.columnEnd==cur.columnStart){							
							cur.columnStart= prev.columnStart;
							list.remove(index-1);
						}						
					}
					return list;
				}
				
				if(e.columnStart==cur.columnStart &&  e.columnEnd>cur.columnEnd){
					 cur.columnEnd=e.columnEnd;
					 if(index<=list.size()-2){
						 Track next= list.get(index+1);
						 if(next.columnStart==cur.columnEnd){
							 cur.columnEnd=next.columnEnd;
							 list.remove(index+1);
						 }
					 }
					 return list;
				}			
				
				
				if(e.columnEnd<cur.columnStart){
					list.add(0,e);
					return list;
			    }
					
				if(e.columnStart>cur.columnEnd){
					if(index==list.size()-1){
						list.add(e);
						return list;
					}
				}
				index++;
			}
		}
		return list;		
		
	}
	
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int rows= scanner.nextInt();
		int columns = scanner.nextInt();
		int tracks = scanner.nextInt();		
		HashMap<Integer,List<Track>> trackMap = new HashMap<Integer,List<Track>>();
		if(tracks>0){
			for(int i=0;i<tracks;i++){
				int trainRow= scanner.nextInt();
				int trainColumnStart =scanner.nextInt();
				int trainColumnEnd= scanner.nextInt();
				Track curTrack =new Track(trainRow,trainColumnStart,trainColumnEnd);
				if(trackMap.containsKey(trainRow)){
					trackMap.put(trainRow,getTrackList(trackMap.get(trainRow),curTrack));
				}else{
					List<Track> trackList = new ArrayList<Track>();
					trackList.add(curTrack);
					trackMap.put(trainRow, trackList);
				}				
			}			
			System.out.println( (rows*columns)-findCount(trackMap));
		}else{
			System.out.println(rows*columns);
		}
    }

	

}
