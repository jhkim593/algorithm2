import java.util.*;
class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        Map<String , Integer> index=new HashMap<>();
        for(int i=0; i<enroll.length;i++){
            index.put(enroll[i],i);
        }
        // for(String str :index.keySet()){
        //     System.out.print(str);
        //     System.out.println(index.get(str));
        // }
        Map<Integer , Integer>map=new HashMap<>();
        for(int i=0; i<referral.length;i++){
            if(referral[i].equals("-")){
                map.put(index.get(enroll[i]),-1);
            }
            else {
                map.put(index.get(enroll[i]),index.get(referral[i]));
            }
        }
//         for(String str :map.keySet()){
//             System.out.print(str);
//             System.out.println(map.get(str));
//         }
        
        
        // List<int[]>list=new ArrayList<>();
        for(int i=0; i<amount.length;i++){
            int total=amount[i]*100;
            int cur=index.get(seller[i]);
            int[]temp=new int[enroll.length];
            while(true){
                int little=(int)(total*0.1);
                if(little<1){
                    temp[cur]=total;
                    break;
                }
                int tempTotal=(int)(total*0.1);
                if(map.get(cur)!=-1){
                    temp[cur]=total-tempTotal;
                    temp[map.get(cur)]=tempTotal;
                    total=tempTotal;
                    cur=map.get(cur);
                }
                else {
                    temp[cur]=total-tempTotal;
                    break;
                }
                
                
            }
            // for(int k=0;k<temp.length;k++){
            //     System.out.println(temp[k]);
            // }
           for(int k=0;k<temp.length;k++){
               answer[k]+=temp[k];
           }
        }
        
        // for(int i=0;i<list.size();i++){
        //     for(int j=0; j<answer.length;j++){
        //         answer[j]+=list.get(i)[j];
        //     }
        // }
        
        
        return answer;
    }
}