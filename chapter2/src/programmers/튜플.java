package programmers;

import java.util.*;
class Solution {
    public int[] solution(String s) {

          String[] arr = s.replaceAll("[{]", " ").replaceAll("[}]", " ").trim().split(" , ");
         Arrays.sort(arr,(String o1,String o2)->{
             return o1.split(",").length-o2.split(",").length;
         });
        List<Integer>list = new ArrayList<>();
        Set<String>set = new HashSet<>();
        for(String temp :arr){
            for(String str : temp.split(",")){
                if(set.add(str))list.add(Integer.parseInt(str));
            }
        }
        return list.stream().mapToInt(i->i).toArray();
      }
    }
