import java.util.Arrays;

class Solution {
  int answer = 0;
        
	  public int solution(int n, int[][] computers) {
	        
	        int []visit=new int[n];
	        for(int i=0;i<n;i++) {
                
	        	visit[i]=0;
	        }
          
	       for(int i=0; i<n;i++){
		    	if(visit[i]==0) {
	              
	              search(i,computers,visit);
	              if(visit[i]==1){
		              answer++;
		              }
	              }
	              
	              
	          }  
	        return answer;
	    }
	  
	  public void search(int i,int[][]computers,int[]visit) {
		  
			  if(visit[i]==0) {
                  
				  for(int j=0;j<visit.length;j++) {
				  if(computers[i][j]==1&&visit[j]==0) {
                       visit[i]=1;
					  search(j,computers,visit);
                   
                      
                  }  
                    
                          
				  }	
               
                  
                  
			  }
    
        
              
		  }
	  
}