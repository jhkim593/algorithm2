package programmers;

import java.util.PriorityQueue;
class Solution {
    public int solution(int[] scoville, int K) {
       int answer = 0;
	        PriorityQueue<Integer>pq=new PriorityQueue<Integer>();
	        for(int i=0;i<scoville.length;i++) {
	        	pq.add(scoville[i]);
	        }
	        
	       while(true) {
	        	answer++;
	        	int a=pq.poll();
	        	int b=pq.poll();
	        	int c=a+b*2;
	        	if(pq.isEmpty()) {
	        		if(c<K) {answer=-1;break;}
	        	}
	        	
	        	pq.offer(c);
	        	if(pq.peek()>=K)break;
	        	
	        	
	        
	        	
	        }
	        return answer++;
	        
	    }

	
    }