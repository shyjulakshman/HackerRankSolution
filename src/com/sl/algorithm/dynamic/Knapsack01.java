package com.sl.algorithm.dynamic;

public class Knapsack01 {
	
	/*
	 * input: List of items with weights and corresponding values. Also given max weight.	 
	 * Find the maximum value which can be picked such that weight is less than or equal 
	 * to given max weight
	 * 
	 */
	
	public static int findMaxValueRecursive(int weights[],int values[],int maxWeight){
		return recursiveKnapSack(weights,values,maxWeight,maxWeight,0);		
	}
	
	private static int recursiveKnapSack(int[] weights,int[] values,int maxWeight,int remainingWeight,
			int currentItem){
		
		//Base case
		//checking if there is no more weight left or no more items left
		if(remainingWeight<=0 || currentItem>=weights.length){
			return 0;
		}
		
		//Memoisation can be used to avoid computing the same subproblem again
		//Remaining weight&Remaining items against the value
		//TODO memoisation
		
		int maxValue=0;
		
		//Check if remainingWeight < weight of current Item.
		if(remainingWeight<weights[currentItem]){ // the current item cannot be picked so check the next item
			maxValue= recursiveKnapSack(weights,values,maxWeight,remainingWeight,currentItem+1);
		}else{
			//if we are able to choose the item, then retur max value of either choosing the item 
			//or not choosing the item
			
			//Option 1 Choose current item
			int valueOfChoosingCurrent= values[currentItem]+ recursiveKnapSack(weights,values,maxWeight,remainingWeight-weights[currentItem],currentItem+1);
			//Option 2.. Dont choose current item
			int valueOfNotChoosingCurrent = recursiveKnapSack(weights,values,maxWeight,remainingWeight,currentItem+1);
			maxValue= Math.max(valueOfChoosingCurrent, valueOfNotChoosingCurrent);			
		}
		
		return maxValue;
	}
	
	public static void main(String args[]){
		int values[] = new int[]{60, 100, 120};
        int weights[] = new int[]{10, 20, 30};
        int  maxWeight = 50;
        
        int maxValue= findMaxValueRecursive(weights,values,maxWeight);
        System.out.println(maxValue);
        
	}

}
