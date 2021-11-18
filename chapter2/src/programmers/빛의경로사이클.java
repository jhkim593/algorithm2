package programmers;

import java.util.*;
class 빛의경로사이클 {
    public int[] solution(String[] grid) {
        
        int b=grid[0].length();
        int a=grid.length;
        
        int [][][]check=new int[a][b][4];
        String[][]arr=new String[a][b];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length();j++){
                arr[i][j]=""+grid[i].charAt(j);
             
            }
          
        }
        List<Integer>list=new ArrayList<>();
        for(int i=0;i<a;i++){
            for(int j=0;j<b;j++){
                for(int k=0;k<4;k++){
                    if(check[i][j][k]==0){
                        int count=0;
                        check[i][j][k]=1;
                        int tx=i;
                        int ty=j;
                        int di=k;
                        while(true){
                            if(arr[tx][ty].equals("L")){
                                di=di+1;
                                if(di==4){di=0;}
                            }
                            else if(arr[tx][ty].equals("R")){
                                di=di-1;
                                if(di==-1){di=3;}
                            
                            }
                            
                            if(di==1){
                                ty=ty-1;
                            }
                            else if(di==2){
                                tx=tx+1;
                            }
                            else if(di==3){
                                ty=ty+1;
                            }
                            else{
                                tx=tx-1;
                            }
                            
                            
                            
                            
                            if(tx<0){
                                tx=a-1;
                            }
                            else if(tx>=a){
                                tx=0;
                            }
                            else if(ty<0){
                                ty=b-1;
                            }
                            else if(ty>=b){
                                ty=0;
                            }
                            check[tx][ty][di]=1;
                            
                            
                            count++;
                            if(tx==i&&ty==j&&di==k){
                                break;
                            }
                        }
                        list.add(count);
                }
            }
         }
        }  
        Collections.sort(list);
        int []answer=new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i]=list.get(i);
        }
        return answer;
    }

}