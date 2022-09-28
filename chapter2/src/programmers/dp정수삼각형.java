package programmers;

import java.util.ArrayList;
import java.util.stream.Collectors;

class dp정수삼각형 {
    public int solution(int[][] triangle) {
        int[][]dp=new int[triangle.length][triangle[triangle.length-1].length];
        int index=0;
        for(int i=0; i< triangle.length;i++){
            for(int j=0;j<index+1;j++){
                int value=triangle[i][j];
                int temp=0;
                if(i-1>=0){
                    if(j-1>=0){
                        temp=Math.max(dp[i-1][j-1],dp[i-1][j]);
                    }
                    else{
                        temp=dp[i-1][j];
                    }
                }
                dp[i][j]=Math.max(dp[i][j],temp+value);
            }
            index++;
        }
        int max=0;
        for(int k: dp[triangle.length-1]){
            if(max<k){
                max=k;
            }
        }
        return max;
    }
}
