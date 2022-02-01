import java.util.*;
class Solution {
    public int solution(String[][] relation) {
        int answer = 0;
        int rowsize= relation.length;
        int colsize= relation[0].length;
        List<Integer>candidates =new LinkedList<Integer>();
        
        for(int i=1; i<1<<colsize; i++){
            if(check(relation,rowsize,colsize,i))
                candidates.add(i);
        }
        
        int count=0;
        while(candidates.size()!=0){
            int temp=candidates.remove(0);
            answer++;
          //   for(int i=0;i<candidates.size();i++){
          //       if((candidates.get(i)&temp)==temp){
          //           candidates.remove((Integer));
          //           i-=1;
          //    }
          // }
            for(Iterator<Integer>it=  candidates.iterator(); it.hasNext();){
                int c=it.next();
                if((c&temp)==temp)it.remove();
            }
        }
        return answer;   
    }
    public boolean check(String[][]relation,int rowsize,int colsize,int subset){
        for(int a=0; a<rowsize-1; a++){
            for(int b=a+1;b<rowsize;b++){
                boolean isSame = true;
                for(int k=0;k<colsize;k++){
                    if((subset&1<<k) ==0)continue;
                    if(relation[a][k].equals(relation[b][k])==false){
                        isSame=false;
                        break;
                    }
                }
                if(isSame)return false;
            }
        }
        return true;
    }
}