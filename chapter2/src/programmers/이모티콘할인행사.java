class Solution {
    int []sale ={10,20,30,40};
    int max1=0;
    int max2=0;
    public int[] solution(int[][] users, int[] emoticons) {
        int[]salePer = new int[emoticons.length];
        dfs(0,emoticons,salePer,users);
        return new int[]{max1,max2};
    }
    void dfs(int count,int[]emoticons,int[]salePer,int[][]users){
        if(count == emoticons.length){
            int[]check=check(emoticons,salePer,users);
            if(max1<check[0]){
                max1=check[0];
                max2=check[1];
            }
            //같으면 판매수익 높은거를 기준으로 업데이트
            else if(max1==check[0]){
                if(max2<check[1]){
                    max2=check[1];
                }
            }
            return;
        }
     
        for(int i=0;i<sale.length;i++){
            int[]newEmotions = emoticons.clone();
            int[]newSalePer = salePer.clone();
            newEmotions[count]=(emoticons[count]/100)*(100-sale[i]);
            newSalePer[count]=sale[i];
            dfs(count+1,newEmotions,newSalePer,users);
        }
    }
    //가입자수랑 판매수익 계산
    int[] check(int[]emoticons,int[]salePer,int[][]users){
        //가입자수
        int plus = 0;
        //판매자수
        int price = 0;
        for(int i=0;i<users.length;i++){
            //할인율
            int targetPer=users[i][0];
            //목표가격
            int targetPrice = users[i][1];
            
            //실제 이모티콘 구매가격
            int realPrice = 0;
            for(int j=0;j<emoticons.length;j++){
                if(salePer[j]>=targetPer){
                    realPrice+=emoticons[j];
                }
            }
            
            //목표가격보다 구매가격이 높으면 플러스 가입
            if(realPrice>=targetPrice){
                plus++;
            }
            //아니면 그냥 판매수익을 더함
            else{
                price+=realPrice;
            }
        }
        
        return new int[]{plus,price};
    }
}