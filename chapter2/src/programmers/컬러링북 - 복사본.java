package programmers;

import java.util.Arrays;

import java.util.LinkedList;
import java.util.Queue;
class Solution {
  public int solution(int bridge_length, int weight, int[] truck_weights) {
	        int answer = 0;
	        
	        Queue<Integer>qu=new LinkedList<>();
	        
	        
	     for(int i=0; i<bridge_length-1;i++) {
	    	qu.add(0);
	     }
	     int curWeight=truck_weights[0];
	     qu.add(curWeight);
	     int index=1;
	      answer=1;
	     while(!qu.isEmpty()) {
	    	 answer++;
	    	
	    	 int truck=qu.poll();
	    	 
	    	 curWeight-=truck;
	    	 
	    	 if(index<truck_weights.length) {
	    	 if(curWeight+truck_weights[index]<=weight) {
	    		
	    		 qu.add(truck_weights[index]);
	    		 curWeight+=truck_weights[index];
	    		index++;
	    		 
	    	 }
	    	 else
	    		 if(qu.size()<bridge_length) {
	    		 if(index<truck_weights.length) {
	    		 qu.add(0);
	    		 }
	    		 }
	     }
	     }
	        return answer;
	    }
       
        
        
}}