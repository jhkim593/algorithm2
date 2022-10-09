import java.util.*;
class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int max = 20000001;
        int [][]dp=new int[n+1][n+1];

        for(int []temp:dp){
            Arrays.fill(temp,max);
        }

        for(int i=0; i<dp.length;i++){
            for(int j=0;j<dp.length;j++){
                if(i==j){
                    dp[i][j]=0;
                }
            }
        }

        for(int i=0; i<fares.length;i++){
            int[]temp=fares[i];
            int start=temp[0];
            int end = temp[1];
            int cost = temp[2];
            dp[start][end]=cost;
            dp[end][start]=cost;
        }

        for(int i=1; i<=n;i++){
            for(int j=1;j<=n;j++){
                for(int k=1; k<=n;k++){
                    dp[j][k]=Math.min(dp[j][k],dp[j][i]+dp[i][k]);
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for(int i=1;i<=n;i++){
            if(dp[s][i]+dp[i][a]+dp[i][b]<answer){
                answer = dp[s][i]+dp[i][a]+dp[i][b];
            }
        }
       return answer;
    }
}
