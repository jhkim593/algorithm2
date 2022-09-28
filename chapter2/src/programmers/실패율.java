package programmers;

import java.util.*;

class 실패율 {
    public int[] solution(int N, int[] stages) {
        int[] answer = {};
        int[] arr=new int[N+6];
        Map<Integer,Double>map=new HashMap<>();
        for(int i=0; i<stages.length;i++){
            arr[stages[i]]++;
        }
        double sum=0;
        for(int i=1;i<=N;i++){
            if(arr[i]==0){map.put(i,0d);continue;}
            map.put(i,arr[i]/(stages.length-sum));
            sum+=arr[i];

        }
        List<Integer>keyList=new ArrayList<>(map.keySet());
        Collections.sort(keyList,(o1, o2) -> {
            if(Double.compare(map.get(o1),map.get(o2))==0){
                return o1-o2;
            }
            else if( Double.compare(map.get(o1),map.get(o2))==1){
                return -1;
            }
            else return 1;
        });
        return keyList.stream().mapToInt(i->i).toArray();
    }
}
