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
			}
			
		}		
		return count;
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
					trackMap.get(trainRow).add(curTrack);
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
