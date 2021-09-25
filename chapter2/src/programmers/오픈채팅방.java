package programmers;

import java.util.*;
class 오픈채팅방 {
    public String[] solution(String[] record) {
       
        ArrayList<String>list=new ArrayList<>();
        Map<String,String>map=new HashMap<>();
        for(int i=0;i<record.length;i++){
            String []temp=record[i].split(" ");
          
               if(temp[0].equals("Leave")){
                   list.add(temp[1]+" 님이 나갔습니다.");
               }
               else if(temp[0].equals("Enter")){
                     list.add(temp[1]+" 님이 들어왔습니다.");
                     map.put(temp[1],temp[2]);
               }
               else{
                   map.put(temp[1],temp[2]);
               }
           
        }
       String[]answer=new String[list.size()];
        for(int i=0;i<list.size();i++){
           String[]lis=list.get(i).split(" ");
            answer[i]=map.get(lis[0])+lis[1]+" "+lis[2];
        }
        return answer;
    }
}