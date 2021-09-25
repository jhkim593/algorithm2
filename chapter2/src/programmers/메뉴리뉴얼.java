package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class 메뉴리뉴얼 {
	

	    HashMap<String,Integer>comp;
	    int m;
	    public String[] solution(String[] orders, int[] course) {
	        ArrayList<String>list=new ArrayList<String>();
	        for(int i=0;i<course.length;i++){
	            comp=new HashMap<>();
	            m=0;
	            for(int j=0;j<orders.length;j++){
	                dfs(0,"",course[i],0,orders[j]);
	            }
	           
	            for(String s:comp.keySet()){
	                if(comp.get(s)==m&&m>1){
	                    list.add(s);
	                }
	            }
	            
	        }
	        String[]answer=new String[list.size()];
	        for(int i=0;i<list.size();i++){
	            answer[i]=list.get(i);
	        }
	        Arrays.sort(answer);
	        return answer;
	        
	     
	}
	    public void dfs(int cnt,String str,int targetNum,int idx,String word){
	        if(cnt==targetNum){
	            char[]c=str.toCharArray();
	            Arrays.sort(c);
	            String temp=String.valueOf(c);
	            comp.put(temp,comp.getOrDefault(temp,0)+1);
	            m=Math.max(m,comp.get(temp));
	            return ;
	        }
	        for(int i=idx;i<word.length();i++){
	            char c=word.charAt(i);
	            dfs(cnt+1,str+c,targetNum,i+1,word);
	        }
	    }
	    
	
}
