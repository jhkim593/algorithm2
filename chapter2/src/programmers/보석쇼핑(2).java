import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
       
        int start=0;
        int min=gems.length+1;
        int a=0;
        int b=0;
        Set<String>set=new HashSet<>();
        Map<String,Integer>map=new HashMap<>();
        for(int i=0;i<gems.length;i++){
            set.add(gems[i]);
        }
        for(int i=0;i<gems.length;i++){
            if(!map.containsKey(gems[i]))map.put(gems[i],1);
            else map.put(gems[i],map.get(gems[i])+1);
            
        
            while(true){
                if(map.containsKey(gems[start])&&map.get(gems[start])>1){
                    map.put(gems[start],map.get(gems[start])-1);
                    start++;
                }
                else break;
            }
            
            if(map.size()==set.size()){
                    if(min>i-start+1){
                        min=i-start+1;
                        a=start+1;
                        b=i+1;
                   }
             }
            
            if(min==set.size()){
                a=start+1;
                b=i+1;
                break;
            }
        }
        
        return new int[]{a,b};
    }
}