package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution{


	 int a;
	 
	 public int solution(int[] priorities, int location) {
	        int answer = 0;
	        int []array=new int[priorities.length];
	        for(int i=0;i<priorities.length;i++) {
	        	array[i]=priorities[i];
	        }
	        
	       
	        Queue<Integer>que=new LinkedList<>();
	        for(int i=0;i<priorities.length;i++) {
	        	que.add(priorities[i]);
	        }
	        while(!que.isEmpty()) {
	        	
	         a=que.poll();
	        
	        Arrays.sort(array);
	        int max=array[array.length-1];
	        if(a==max) {
	        	array[array.length-1]=0;
	        	answer++;
	      
	        	if(location==0) {
	        		return answer;
                  
	        		
	        	}
	        	else {location--;}
	        }
	        
	        	
	        	
               
	        
	        
	        else {que.offer(a);location--;}
	        
	        if(location<0) {location=que.size()-1;}
	       
	        
	        
	        
	       
        	
	        
	        }
	        
	        
	        return answer;
	    }
}