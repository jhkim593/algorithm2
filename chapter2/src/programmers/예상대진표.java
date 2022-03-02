import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String>que=new LinkedList<>();
        
        if(cacheSize==0){return cities.length*5;}
        for(int i=0;i<cities.length;i++){
            String temp=cities[i].toUpperCase();
            if(que.contains(temp)){
                
                     que.remove(temp);
                     que.add(temp);
                     answer++;
                }
            
            else{ 
            if(cacheSize>0){
                que.add(temp);
                answer+=5;
                cacheSize--;
            }
                else{
                   que.poll();
                  que.add(temp);
                   answer+=5; 
                }
                
                }
            
//             if(cacheSize>0){
//                 if()
//                 que.add(temp);
//                 answer+=5;
//                cacheSize--;
//             }
//             else{
                
//                 if(que.contains(temp)){
//                     que.remove(temp);
//                     que.add(temp);
//                     answer++;
//                 }
//                 else{
//                     que.poll();
//                     que.add(temp);
//                     answer+=5;
//                 }
            
        }
        return answer;
    }
}