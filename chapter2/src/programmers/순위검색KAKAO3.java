package programmers;

import java.util.*;
class Solution {
    Map<String , List<Integer>>map=new HashMap<>();
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        for(int i=0; i<info.length;i++){
            //info 띄어쓰기 별로 쪼갬
            String[] split = info[i].split(" ");

            add(split,"",0);
        }
        for(String key :map.keySet()){
            Collections.sort(map.get(key));
        }


        //쿼리로 몇명인지 탐색
        for(int i=0;i<query.length;i++){
            String str=query[i];
            String[]split = str.split(" and ");
            //조건
            String cond =split[0]+split[1]+split[2]+split[3].split(" ")[0];
            //점수
            int score=Integer.parseInt(split[3].split(" ")[1]);
            if(!map.containsKey(cond)){
                answer[i]=0;
            }
            else{
                List<Integer>tempList=map.get(cond);
                answer[i]=binarySearch(tempList,score);
            }

        }

        return answer;
    }

    public int binarySearch(List<Integer>tempList,int score){

        int start= 0, end = tempList.size()-1;
        while(start<=end) {

            int mid =(start+end)/2;
            if(tempList.get(mid) <score) {
                start = mid+1;
            }else {
                end = mid-1;
            }
        }
        return tempList.size()-start;

    }

    public void add(String[]split, String str,int idx){
        if(idx == 4){
            //점수 집어넣음
            if(map.containsKey(str)){
                map.get(str).add(Integer.parseInt(split[4]));
            }
            else{
                List<Integer>list=new ArrayList<>();
                list.add(Integer.parseInt(split[4]));
                map.put(str,list);
            }
            return;
        }

        String str1=str+split[idx];
        add(split,str1,idx+1);

        String str2=str+"-";
        add(split,str2,idx+1);
    }

}
