package programmers;

import java.util.Arrays;
class Solution {
 public int solution(int[] citations) {
        int answer = 0;
        int a=0;
        int b=0;
        
       for(int i=0;i<=citations.length;i++) {
    	   for(int j=0;j<citations.length;j++) {
    	   if(citations[j]>=i)a++;
    	   if(citations[j]<=i)b++;
    	   }
    	  
    		   if(a>=i&&b<=i) {
    			  if(answer<i) {
    				  answer=i;
    			  }
    		   }
    		 a=0;b=0;
    	   }
       return answer;
       }
}