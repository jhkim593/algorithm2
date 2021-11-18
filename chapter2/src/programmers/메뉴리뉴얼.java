package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

//public class 메뉴리뉴얼 {
//	
//
//	    HashMap<String,Integer>comp;
//	    int m;
//	 
//	    
//	    public String[] solution(String[] orders, int[] course) {
//	        ArrayList<String>list=new ArrayList<String>();
//	        for(int i=0;i<course.length;i++){
//	            comp=new HashMap<>();
//	       	
//	           
//	            m=0;
//	            for(int j=0;j<orders.length;j++){
//	                dfs(0,"",course[i],0,orders[j]);
//	            }
//	           
//	            for(String s:comp.keySet()){
//	                if(comp.get(s)==m&&m>1){
//	                    list.add(s);
//	                }
//	            }
//	            
//	        }
//	        String[]answer=new String[list.size()];
//	        for(int i=0;i<list.size();i++){
//	            answer[i]=list.get(i);
//	        }
//	        Arrays.sort(answer);
//	        return answer;
//	        
//	     
//	}
//	    public void dfs(int cnt,String str,int targetNum,int idx,String word){
//	        if(cnt==targetNum){
//	            char[]c=str.toCharArray();
//	            Arrays.sort(c);
//	            String temp=String.valueOf(c);
//	            comp.put(temp,comp.getOrDefault(temp,0)+1);
//	            m=Math.max(m,comp.get(temp));
//	            return ;
//	        }
//	        for(int i=idx;i<word.length();i++){
//	            char c=word.charAt(i);
//	            dfs(cnt+1,str+c,targetNum,i+1,word);
//	        }
//	    }
//	    
//	
//}
import java.util.*;
class 메뉴리뉴얼 {
    int max=0;
 List<String>list=new ArrayList<>();     
    public String[] solution(String[] orders, int[] course) {
        Set<String>set=new HashSet<>();
   
        for(int i=0;i<orders.length;i++){
            for(int j=0;j<orders[i].length();j++){
                String temp=""+orders[i].charAt(j);
                set.add(temp);
            }
            
        }
        String[] arr=new String[set.size()];
        int index=0;
       for(String s:set){
           arr[index]=s;
           index++;
       }
        List<String>answerList=new ArrayList<>();
     
        for(int i=0;i<course.length;i++){
            int []check=new int [set.size()];
            
            menuCheck(course[i],"",check,orders,0,arr);
            for(int j=0;j<list.size();j++){
             String[] temp=list.get(j).split("");
                Arrays.sort(temp);
             String str="";
                for(String s:temp){
                 str+=s;
             }           
             answerList.add(str);
            }
            max=0;
            list.clear();
        }
        Collections.sort(answerList);
        String[]answer=new String[answerList.size()];
        for(int i=0;i<answerList.size();i++){
            answer[i]=answerList.get(i);
        }
     
        return answer;
    }
    public void menuCheck(int length,String ori,int[]check,String[] orders,int k,String[]arr){
        if(length==ori.length()){
            int count=0;
            out:
            for(int i=0;i<orders.length;i++){
                for(int j=0;j<ori.length();j++){
                   String temp=""+ori.charAt(j);
                   if(!orders[i].contains(temp))continue out;
                }
                count++;
            }
            if(count>=2){
               if(count>max){
                   list.clear();
                   list.add(ori);
                   max=count;
            }
                else if(count==max)
                    list.add(ori);
                    
           }
            return;
        }
        for(int i=k; i<arr.length;i++ ){
            if(check[i]==0){
                int []newcheck=check.clone();
                newcheck[i]++;
                String newori=ori+arr[i];
                menuCheck(length,newori,newcheck,orders,i,arr);
            }
        }
    }
    
}
