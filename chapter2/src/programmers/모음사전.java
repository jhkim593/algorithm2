import java.util.*;
class Solution {
    List<String>list=new ArrayList<>();
    public int solution(String word) {
        int answer = 0;
        String []temp={"A","E","I","O","U"};
        dfs("",temp);
        Collections.sort(list);
        return list.indexOf(word)+1;
    }
    public void dfs(String ori,String[]temp){
        if(ori.length()==5)return;
        for(int i=0; i<temp.length;i++){
            String newori=ori+temp[i];
            list.add(newori);
            dfs(newori,temp);
        }
    }
}