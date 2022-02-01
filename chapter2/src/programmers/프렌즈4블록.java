import java.util.*;
class Solution {
    int tx[]={1,1,0};
    int ty[]={1,0,1};
    int count=1;
    public int solution(int m, int n, String[] board) {
        int answer = 0;
       
        
        String [][]arr=new String [m][n];
        for (int i=0; i<m;i++){
            String[]temp=board[i].split("");
            for(int j=0; j<n;j++){
                arr[i][j]=temp[j];
            }
        }
       
        
        
        while(count!=0){
            int[][]check=new int[m][n];
            count =0;
            for(int i=0;i<m-1;i++){
                for(int j=0; j<n-1;j++){
                    if(!arr[i][j].equals("0")){
                        dfs(arr, i,j,check);
                    }
                }
            }
            if(count!=0){
                for(int i=0;i<m;i++){
                    for(int j=0;j<n;j++){
                        if(check[i][j]==1)arr[i][j]="0";
                    }
                }
                //   for(int k=0;k<m;k++){
                //     for(int b=0;b<n;b++){
                //         System.out.print(arr[k][b]);
                //     }
                //     System.out.println();
                // }
                // System.out.println("=====================");
                move(arr, m,n);
              
                
                // System.out.println("move -------------------");
                //  for(int k=0;k<m;k++){
                //     for(int b=0;b<n;b++){
                //         System.out.print(arr[k][b]);
                //     }
                //     System.out.println();
                // }
                // System.out.println("=====================");
                
                
            }
            
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j].equals("0")){
                    answer++;
                }
            }
        }
        
        return answer;
    }
    
    public void dfs(String [][]arr,int a ,int b,int[][]check){
        
        for(int i=0;i<3;i++){
            int rx=tx[i]+a;
            int ry=ty[i]+b;
            if(rx>=0&&ry>=0&&rx<arr.length&&ry<arr[0].length){
                if(!arr[a][b].equals(arr[rx][ry])){return ;}
                // if(arr[rx][ry].equals("0"))return ;
                // if(check[rx][ry]==1)return;
            }
            else {return ;}
            // else {return 0;}
        }
        check[a][b]=1;
        // arr[a][b]="0";
        for(int i=0;i<3;i++){
            int rx=tx[i]+a;
            int ry=ty[i]+b;
            // System.out.println("rx:"+rx);
            // System.out.println("ry:"+ry);
            // arr[rx][ry]="0";
            check[rx][ry]=1;
            // dfs(arr,rx,ry,check);
        }
        count++;
        return ;
    }
    
    public void move(String [][]arr,int m ,int n){
        for(int i=0;i<n;i++){
            int find =0;
            for(int j=m-1;j>=0;j--){
                if (arr[j][i].equals("0")){
                    find ++;
                }
                else {
                    if(find!=0){
                    arr[j+find][i]=arr[j][i];
                    arr[j][i]="0";}
                }
            }
        }
    }
}