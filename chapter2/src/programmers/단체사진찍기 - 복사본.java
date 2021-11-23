package programmers;

import java.util.*;
class 단체사진찍기 {
    HashSet<String>set;
    public int solution(int n, String[] data) {
        int answer = 0;
        int []visit=new int[8];
    
        set=new HashSet<>();
        String []arr={"A","C","F","J","M","N","R","T"};
       

       
        dfs(8,"",visit,arr);
        
        con:
        for(String s:set){
             for(int i=0;i<data.length;i++){
              char one=data[i].charAt(0);
              char two=data[i].charAt(2);
              char com=data[i].charAt(3);
               char num=data[i].charAt(4);
                 int dep=Math.abs(s.indexOf(one)-s.indexOf(two))-1;
                 if(com=='>'){if(dep<=num-'0')continue con;}
                 else if(com=='<'){if(dep>=num-'0')continue con;}
                 else {if(dep!=num-'0')continue con;}
                 
                
            }
            answer++;
        }
        
        return answer;
    }
    public void dfs(int len ,String ori,int[]visit,String []arr){
        if(ori.length()==len){
            set.add(ori);
                return;
        }
        for(int i=0;i<arr.length;i++){
            if(visit[i]==0){
            int[]newvisit=visit.clone();
            newvisit[i]++; 
            String nori=ori+arr[i];
            dfs(len,nori,newvisit,arr);
            }      
           
        }
        
    }
   
}