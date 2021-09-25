package programmers;

import java.util.*;
class 컬러링북 {
    Queue<int[]>que;
    int[] tx={1,-1,0,0};
    int[]ty={0,0,1,-1};
    int num=0;
    int answer=0;
    
    public int[] solution(int m, int n, int[][] picture) {
       
    
        ArrayList<Integer>list=new ArrayList<>();
      
        que=new LinkedList<>();
        int [][]check=new int[m][n];
        for(int i=0;i<check.length;i++){
            for(int j=0;j<check[0].length;j++){
                if(check[i][j]==0&&picture[i][j]!=0){
                    num=0;
                    check[i][j]=1;
                    que.add(new int[]{i,j,picture[i][j]});
                    answer++;
                    bfs(check,picture);
                    list.add(num);
                }
            }
        }
        Collections.sort(list,Collections.reverseOrder());

        
        return new int[]{answer,list.get(0)};
    }
    
    public void bfs(int[][]check,int[][]picture){
        while(!que.isEmpty()){
            int[]temp=que.poll();
            num+=1;
            for(int i=0;i<4;i++){
                int rx=temp[0]+tx[i];
                int ry=temp[1]+ty[i];
                if(rx>=0&&ry>=0&&rx<picture.length&&ry<picture[0].length){
                    if(check[rx][ry]==0){
                        if(picture[rx][ry]==temp[2]){
                            check[rx][ry]=1;
                            que.add(new int[]{rx,ry,picture[rx][ry]});
                        }
                        
                    }
                }
            }
        }
    }
}