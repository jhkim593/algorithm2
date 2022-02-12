import java.util.*;
class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        Map<String , Integer> index=new HashMap<>();
        for(int i=0; i<enroll.length;i++){
            index.put(enroll[i],i);
        }
        Map<String , Integer>map=new HashMap<>();
        for(int i=0; i<referral.length;i++){
            if(referral[i].equals("-")){
                map.put(enroll[i],-1);
            }
            else {
                map.put(enroll[i],i);
            }
        }
        for(int i=0; i<amount.length;i++){
            int total=amount[i]*100;
            int cur=i;
            while(true){
                int little=(int)(total*0.1);
                if(map.get(seller[cur])==-1||little<1){
                    answer[index.get(seller[i])]+=total;
                    break;
                }
            
                
                answer[index.get(seller[cur])]+=total*0.9;
                answer[map.get(seller[cur])]+=total*0.1;
                total*=0.1;
                cur=map.get(seller[cur]);
                
            }
        }
        
        return answer;
    }
}