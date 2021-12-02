package programmers;

import java.util.*;
class Solution {
    int answer=1;
    public int solution(String[][] clothes) {
        
        Map<String,Integer>map=new HashMap<>();
        for(int i=0;i<clothes.length;i++){
            if(map.containsKey(clothes[i][1])){
                map.put(clothes[i][1],map.get(clothes[i][1])+1);
            }
            else{map.put(clothes[i][1],1);}
        }
        
        int[]arr=new int[map.size()];
        int index=0;
        for(String s:map.keySet()){
            arr[index++]=map.get(s);
        }
        // int[]visit=new int[arr.length];
        // for(int i=1;i<=arr.length;i++){
        //     dfs(i,0,visit,arr,0,1);
        // }
        for(int i=0;i<arr.length;i++){
            answer*=(arr[i]+1);
        }
        return answer-1;
    }
    // public void dfs(int len,int cnt,int[]visit,int[]arr,int start,int temp){
    //     if(len==cnt){
    //         answer+=temp;
    //     }
    //     for(int i=start;i<arr.length;i++){
    //         if(visit[i]==0){
    //             int[]newvisit=visit.clone();
    //             int newtemp=temp*arr[i];
    //             newvisit[i]=1;
    //             dfs(len,cnt+1,newvisit,arr,i+1,newtemp);
    //         }
    //     }
    // }
}