import java.util.*;
class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        //n 지점 개수
        //s  출발지점
        //a  , b 도착 지점
        int [][] arr=new int[n+1][n+1];
        for(int[] temp : fares){
            int start = temp[0];
            int end = temp[1];
            int cost = temp[2];
            arr[start][end]=cost;
            arr[end][start]=cost;
        }

        int []dpS=dsk(arr, s);
        int []dpA=dsk(arr, a);
        int []dpB=dsk(arr, b);

        int answer = Integer.MAX_VALUE;
        for(int i=1;i<dpS.length;i++){
           answer= Math.min(answer,dpS[i]+dpA[i]+dpB[i]);

        }
        return answer;
    }

    public int[] dsk(int[][]arr,int s){
        int[]dp=new int[arr.length];
        int[]check=new int[arr.length];
        Arrays.fill(dp,Integer.MAX_VALUE);
        PriorityQueue<int[]> que=new PriorityQueue<>((i1,i2)->i1[1]-i2[1]);
        que.add(new int[]{s,0});
        dp[s]=0;
        while(!que.isEmpty()){
            int[]temp=que.poll();
            int start = temp[0];
            int cost = temp[1];

            if(check[start]!=0)continue;
            check[start]++;

            for(int i=1;i<arr.length;i++){
                if(arr[start][i]!=0){
                    dp[i]=Math.min(dp[i],dp[start]+arr[start][i]);
                    que.add(new int[]{i,dp[i]});
                }
            }
        }
        return dp;
    }
}
