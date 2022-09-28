import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String>que = new LinkedList<>();
        for(String temp : cities){
            String city=temp.toLowerCase();
            if(que.contains(city)){
                answer++;
                que.remove(city);
                que.add(city);
                continue;
            }
            if(cacheSize>que.size()){
                que.add(city);
            }
            else{
                if(que.peek()!=null){
                que.poll();
                que.add(city);
                }
            }
            answer+=5;
        }
        return answer;
    }
}
