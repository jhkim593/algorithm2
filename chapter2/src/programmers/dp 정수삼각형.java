package programmers;

class dp정수삼각형 {
  public int solution(int[] money) {
      int[]dp=new int[money.length-1];
      int[]dp2=new int[money.length-2];
      for(int i=0; i<money.length-1;i++){
          int temp=money[i];
          if(i==0){
              dp[i] = temp;
              continue;
          }
          if(i==1){
              dp[i] = Math.max(dp[i-1],temp);
              continue;
          }
          dp[i]=Math.max(dp[i-1],dp[i-2]+temp);
      }
      for(int i=1; i<money.length-2;i++){
          int temp=money[i];
           if(i==1){
              dp2[i] = temp;
              continue;
          }
          if(i==2){
              dp2[i] = Math.max(dp2[i-1],temp);
              continue;
          }
          dp2[i]=Math.max(dp2[i-1],dp2[i-2]+temp);
      }
     int last= money[money.length-1];
      return Math.max(dp[money.length-2],dp2[money.length-3]+last);

  }
}
