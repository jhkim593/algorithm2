package programmers;

import java.util.*;
class Solution {
    Map<Integer, Set<Integer>> map = new HashMap<>();
    public int solution(int N, int number) {
        int answer = -1;

        if(N == number){return 1;}


        Set<Integer> set=new HashSet<>();
        set.add(N);
        map.put(1,set);

        loop:
        for(int i=2;i<9;i++){
                map.put(i,new HashSet<>());
            for(int j=1;j<i;j++){
                Set<Integer>set1 =map.get(j);
                Set<Integer>set2 =map.get(i-j);

                //숫자 조합
                for(int s1: set1){
                    for(int s2: set2){
                        for(int k=0; k<4;k++){
                            Set<Integer>tempSet=map.get(i);
                            tempSet.add(s1 + s2);
                            tempSet.add(s1 - s2);
                            tempSet.add(s1 * s2);
                            if(s1 != 0 && s2 != 0)
                                tempSet.add(s1 / s2);
                        }
                    }
                }
                map.get(i).add(Integer.parseInt(String.valueOf(N).repeat(i)));
                if(map.get(i).contains(number)){
                    answer = i;
                    break loop;
                }
            }
        }

        return answer;
    }
}
