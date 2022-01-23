import java.util.*;

class Solution {
    static Map<String,ArrayList<Integer>>map=new HashMap<>();
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        
        for(int i=0; i<info.length;i++){
            dfs("",info[i].split(" "),0);
        }
        
          List<String> list1 = new ArrayList<>(map.keySet());
        for(int i=0; i<list1.size(); i++) {
        	List<Integer> scoreList = map.get(list1.get(i));
        	Collections.sort(scoreList);
        }
        
        for(int i=0;i<query.length;i++){
            String temp=query[i].replaceAll(" and ","").split(" ")[0];
            int scoreTemp= Integer.parseInt(query[i].replaceAll(" and ","").split(" ")[1]);
            
            answer[i]=find(temp ,scoreTemp);

        }    
        return answer;
    }
    
    public int find(String temp , int scoreTemp){
            if(map.containsKey(temp)){
            
            // 점수 확인
            List<Integer>score=map.get(temp);
            // Collections.sort(score);
            int middle=0;
            int first=0;
            int last=score.size()-1;
            while(first<=last){
                middle=(first+last)/2;
                    if(scoreTemp>score.get(middle)){
                        first=middle+1;
                    }
                    else{
                        last=middle-1;
                    }
            }
               return score.size()-first;
            }
        
            else{
                return 0;
            } 
        
    }
    public void dfs(String ori , String[] infoTemp, int depth){
        if(depth==4){
            if(map.containsKey(ori)){
               map.get(ori).add(Integer.parseInt(infoTemp[4]));
            }
            else {
                ArrayList<Integer>list=new ArrayList<>();
                list.add(Integer.parseInt(infoTemp[4]));
                map.put(ori,list);
               
            }
            return;
        }
        dfs (ori+infoTemp[depth],infoTemp , depth+1);
        dfs (ori+"-", infoTemp,depth+1);
    }
}

