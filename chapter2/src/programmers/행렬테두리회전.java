import java.util.*;
class Solution {
    int[]tx={0,1,0,-1};
    int[]ty={1,0,-1,0};
    public int[] solution(int rows, int columns, int[][] queries) {
      
        int[][]arr=new int[rows][columns];
        int count=1;
        ArrayList<Integer>list=new ArrayList<>();
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                arr[i][j]=count++;
            }
        }
        for(int i=0;i<queries.length;i++){
            int rowa=queries[i][0];
            int cola=queries[i][1];
            int rowb=queries[i][2];
            int colb=queries[i][3];
            int temp=0;
            int x=rowa-1;
            int y=cola-1;
            int index=0;
            int cnt=arr[x][y];
            int min=cnt;
            while(index<4){
                
                x=x+tx[index];
                y=y+ty[index];               
                temp=arr[x][y];
                if(temp<min){min=temp;}
                arr[x][y]=cnt;
                cnt=temp;
              
              if(y==colb-1&&index==0)index+=1;
             else if(x==rowb-1&&index==1)index+=1;
            
             
              else if(y==cola-1&&index==2)index+=1;
                  else if(x==rowa-1&&index==3)index+=1;
            }
            list.add(min);
        }
        int[]answer=new int[list.size()];
        
        for(int i=0;i<list.size();i++){
            answer[i]=list.get(i);
        }
       
        return answer;
    }
    
}