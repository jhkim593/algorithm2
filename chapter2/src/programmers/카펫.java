import java.util.Arrays;
class Solution {
    public int[] solution(int brown, int yellow) {
	        int[] answer = new int[2];
	        int all=brown+yellow;
	        for(int i=3;i<all;i++){
	            if(all%i==0){
	                if(all/i>=i){
	                    int x=i;
	                    int y=all/i;
	                    if(search(x,y,brown,yellow)) {
	                    	answer[0]=y;
	                    	answer[1]=x;
	                    	break;}
	                    
	                }
	                
	            }
	        }
	        
	        
	        return answer;
	    }
	 public boolean search(int x,int y,int brown,int yellow) {
		 int bro=2*x+2*y-4;
		 int yel=x*y-bro;
		 if(bro==brown&&yellow==yel) {
			 return true;
		 }
		 return false;
		 
		 
	 }
}