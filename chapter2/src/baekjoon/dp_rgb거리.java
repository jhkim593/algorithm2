import java.util.*;

class Main{
public static void main(String[]args){
    Scanner sca=new Scanner(System.in);
    int a=sca.nextInt();
    int[][]dp=new int[a][3];
       for(int i=0;i<a;i++){
        for(int j=0;j<3;j++){
            if(i==0){
                dp[i][j]=sca.nextInt();
            }
            else{
                if(j==0){
                 dp[i][j]=Math.min(dp[i-1][j+1],dp[i-1][j+2])+sca.nextInt();
                }
                if(j==1){
                  dp[i][j]=Math.min(dp[i-1][j-1],dp[i-1][j+1])+sca.nextInt();
                }
                 if(j==2){
                  dp[i][j]=Math.min(dp[i-1][j-1],dp[i-1][j-2])+sca.nextInt();
                }
            }
        }
    }

   int min =0;
   for(int ans:dp[a-1]){
       if(min ==0 ){min=ans; continue;}
       if(min>ans){
           min =ans;
       }
   }
   System.out.print( min);


    }
}
