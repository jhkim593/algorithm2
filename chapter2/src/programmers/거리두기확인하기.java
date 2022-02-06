import java.util.*;
class Solution {
    int[]tx={1,-1,0,0};
    int[]ty={0,0,1,-1};
    public int[] solution(String[][] places) {
        int[] answer = {1,1,1,1,1};
     
        for(int i=0;i<5;i++){
            
            // String[][]arr=new String[places[i].length][places[i][0].length()];
            String[][]arr=new String[5][5];
           
            Queue<int[]>que=new LinkedList<>();
            
            for(int j=0;j<5;j++){
                for(int k=0;k<5;k++){
                    arr[j][k]=""+places[i][j].charAt(k);
                }
            }
            for(int j=0;j<5;j++){
                for(int k=0;k<5;k++){
                    System.out.print(arr[j][k]);
                    
                    
                }
            System.out.println();}
          
             con:
             for(int j=0;j<5;j++){
                 for(int k=0;k<5;k++){
                     if(arr[j][k].equals("P")){
                         int[][]check=new int[5][5];
                         check[j][k]=1;
                         que.add(new int[]{j,k,1});
                         if(bfs(arr,check,que,j,k)==1){
                             answer[i]=0;
                             break con;
                         }
                     }
                 }
             }
            
            
        }
        return answer;
    }
    public int bfs(String[][]arr,int[][]check,Queue<int[]> que,int j,int k){
        while(!que.isEmpty()){
            int []temp=que.poll();
            for(int i=0;i<4;i++){
                int rx=tx[i]+temp[0];
                int ry=ty[i]+temp[1];
                
                if(rx>=0&&ry>=0&&rx<arr.length&&ry<arr[0].length){
                    if(arr[rx][ry].equals("O")&&check[rx][ry]==0){
                        que.add(new int[]{rx,ry,temp[2]+1});
                        check[rx][ry]=1;
                    }
                    else if(arr[rx][ry].equals("P")&&check[rx][ry]==0){
                        if(temp[2]>2){
                            que.add(new int[]{rx,ry,temp[2]+1});
                            
                            check[rx][ry]=1;
                        }
                        else{
                            System.out.println("½ÃÀÛ°ª"+j+"   "+k);
                            System.out.println(rx+"  "+ry);
                            return 1;
                        }
                    }
                }
            }
            
        }
        return 0;
    }
}