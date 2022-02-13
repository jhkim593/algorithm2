import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
       
        int start=0;
        int min=0;
        int a=0;
        int b=0;
        Set<String>set=new HashSet<>();
        Queue<String> q = new LinkedList<String>();
        Map<String,Integer>map=new HashMap<>();
        for(int i=0;i<gems.length;i++){
            set.add(gems[i]);
        }
        for(int i=0;i<gems.length;i++){
            if(!map.containsKey(gems[i]))map.put(gems[i],1);
            else map.put(gems[i],map.get(gems[i])+1);
            
            q.add(gems[i]);
            
            while(true){
                String temp=q.peek();
                if(map.get(temp)>1){
                    q.poll();
                    start++;
                    map.put(temp,map.get(temp)-1);
                }
                else break;
            }
            
            if(map.size()==set.size()){
                if(min==0){
                    min=i-start+1;
                    a=start+1;
                    b=i+1;
                }
                else {
                    if(min>i-start+1){
                        min=i-start+1;
                        a=start+1;
                        b=i+1;
                       
                    }
                }
            }
            
            if(min+1==set.size()){
                a=start+1;
                b=i+1;
                break;
            }
        }
        
        return new int[]{a,b};
    }
}