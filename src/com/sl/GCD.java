package com.sl;

public class GCD {
	
    public int gcdForN(int[] a){
    	
    	int res = a[0];
    	for(int i=1;i<a.length;i++){
    		res= gcd(res, a[i]);
    	}
    	return res;
    }
	
	public int gcd(int a,int b){
		int max = Math.max(a,b);
		int min= Math.min(a, b);
		
		if(max%min==0)return min;
		 int rem=0;
		
		 while(max%min!=0){
			 rem= max%min;
			 if(rem!=0){
				 min =rem;
				 max = min;
			 }
		 }
		return min;
	}
	
	public static void main(String args[]){
		GCD gcd=new GCD();
		System.out.println(gcd.gcd(72,48));
		
		int[] a= new int[]{20,30,12};
		System.out.println(gcd.gcdForN(a));
	}

}
