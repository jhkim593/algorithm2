package programmers;

import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        
        ArrayList<Integer>list=new ArrayList<>();
        for(int i=0;i<prices.length;i++){
            int a=prices[i];
            int count=0;
            if(i==prices.length-1)list.add(0);
           for(int j=i+1;j<prices.length;j++){
               count++;
               if(a>prices[j]){list.add(count);break;}
               
               if(j==prices.length-1){list.add(count);}
           }
            
        }
        int []answer=new int[list.size()];
        int index=0;
        for(int i=0;i<list.size();i++){
            answer[index++]=list.get(i);
        }
        return answer;
    }
}