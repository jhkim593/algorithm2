class Solution {
    int[] temp;
    int max = 0;
     int[] a={1,1,2,0,1,2,2,0,0,0,0};
    public int[] solution(int n, int[] info) {

        //맨 마지막에 점수를 계산
        int[] arr = new int[11];
         dfs(info, n ,arr,10);
        
        if(max==0){
            return new int[]{-1};
        }
        return temp;
    }
    
    void dfs(int[]info, int count ,int []arr,int start ){
        if(start==-1||count==0){
            if(count>0){
                arr[10]+=count;
            }
            
            
            //점수 계산해서 가장큰 점수차인것 arr선정
            int checkScore=checkScore(info,arr);
            if(checkScore!=-1){
                //점수차가 더크면 해당 점수로 바꿈
                if(max<checkScore){
                    temp = arr;
                    max = checkScore;
                }
                //만약 점수가 같으면 뒤에서 계산
                else if(max == checkScore){
                    //true면 바꿈
                    if(checkBack(temp,arr)){
                        temp = arr;
                    }
                }
            }
        }
        for(int i = start ; i>-1; i--){
            
            int need= info[i]+1;
            if(count>=need){
                //점수계산
                int[] newArr = arr.clone();
                newArr[i] = need;
                //화살수계산
                int newCount = count-need;
                dfs(info,newCount,newArr,i-1);
            }    
        }
    }
    int checkScore(int[]info , int[]arr){
        int lion = 0;
        int peach = 0;
        for(int i=0; i<info.length;i++){
            //둘다 0점이면 둘다 점수 없음
            if(info[i]==0&&arr[i]==0)continue;
            
            if(info[i]<arr[i])lion =lion+(10-i);
            else peach = peach+(10-i);
        }
        if(lion>peach){
            return lion-peach;
        }
        return -1;
    }
    
    boolean checkBack(int[]temp , int[]arr){
        for(int i=0;i<temp.length;i++){
            if(temp[temp.length-i-1]>arr[temp.length-i-1])return false;
            else if(temp[temp.length-i-1]<arr[temp.length-i-1])return true;
        }
        return false;
    }
}