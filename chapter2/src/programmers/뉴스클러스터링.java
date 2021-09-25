package programmers;

import java.util.*;
class 뉴스클러스터링 {
    public int solution(String str1, String str2) {
        int answer = 0;
        Map<String,Integer>map1=new HashMap<>();
        Map<String,Integer>map2=new HashMap<>();
        for(int i=0;i<str1.length()-1;i++){
            // String a=i.substring(i,i+1);
            char ta=str1.charAt(i);
            char tb=str1.charAt(i+1);
            if((ta>=65&&ta<=90)||(ta>=97&&ta<=122)){
                 if((tb>=65&&tb<=90)||(tb>=97&&tb<=122)){
            // String b=i.substring(i+1,i+2);
            String temp=(""+ta+tb).toUpperCase();
                     
                     if(map1.containsKey(temp)){
                     map1.put(temp,map1.get(temp)+1);}
                     else{map1.put(temp,1);}
            }
            }
        }
          for(int i=0;i<str2.length()-1;i++){
            // String a=i.substring(i,i+1);
            char ta=str2.charAt(i);
            char tb=str2.charAt(i+1);
            if((ta>=65&&ta<=90)||(ta>=97&&ta<=122)){
                 if((tb>=65&&tb<=90)||(tb>=97&&tb<=122)){
            // String b=i.substring(i+1,i+2);
            String temp=(""+ta+tb).toUpperCase();
                     if(map2.containsKey(temp)){
                     map2.put(temp,map2.get(temp)+1);}
                     else{map2.put(temp,1);}
            }
            }
        }
        //교집합
        double answer1=0;
        for(String a:map1.keySet()){
            if(map2.containsKey(a)){
                if(map1.get(a)<map2.get(a)){
                    answer1+=map1.get(a);
                }
                 else if(map1.get(a)>map2.get(a)){
                    answer1+=map2.get(a);
                }
                else{answer1+=map1.get(a);}
            }
        }
        double answer2=0;
        for(String a:map1.keySet()){
            if(map2.containsKey(a)){
                answer2+=Math.max(map1.get(a),map2.get(a));
                map2.remove(a);
            }
            else answer2+=map1.get(a);
        }
        for(String b:map2.keySet()){
            answer2+=map2.get(b);
        }
        
        if(answer2==0){return 65536;}
        return (int)((answer1/answer2)*65536);
    }
}