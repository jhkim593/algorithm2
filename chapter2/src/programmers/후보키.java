import java.util.*;
class Solution {
    int answer = 0;
    List<String>answerList=new ArrayList<>();
    public int solution(String[][] relation) {
        
        
        int count=0;
        for(int j=1; j<=relation[0].length;j++){
            for(int i=0; i<relation[0].length;i++){
                int []check=new int[relation[0].length];
                List<Integer>list=new ArrayList<>();
                System.out.println(j+"=========================");
                list.add(i);
                check[i]++;
                dfs(relation,check,list,j);
            }
        }
        return answerList.size();
    }
    public void dfs(String [][] relation , int[]check,List<Integer>list,int count){
        if(count==list.size()){
            Set<String>set=new HashSet<>();
            for(int i=0; i<relation.length;i++){
                String str="";
                for(Integer temp : list){
                    str+=relation[i][temp];
               }
                 set.add(str);
                System.out.println(str);
            }

           
            if(set.size()!=relation.length){
              return ;
            }
            
            else{
                String temp="";
                for(Integer listtemp: list){
                    temp+=String.valueOf(listtemp);
                }
                System.out.println(temp+"temp======================");
                                System.out.println("answer======");

                for(String dsd:answerList){
                    System.out.print(dsd+"");
                }
                 System.out.println("");
               for(int i=0; i<answerList.size();i++){
                    // if(temp.contains(answerList.get(i))){
                    //   return ;
                    // }
                   int find=0;
                   for(String str :answerList.get(i).split("")){
                       if(!temp.contains(str)) {find++; break;}
                   }
                   if(find==0){
                       return;
                   }
               }
            
               answerList.add(temp);
              
                return ;
            }
        }
        else {
               for(int i=list.get(list.size()-1);i<relation[0].length;i++){
                    if(check[i]==0){
                        int[]newcheck=check.clone();
                        newcheck[i]++;
                        List<Integer>newlist=new ArrayList<>();
                        for(Integer temp : list){
                            newlist.add(temp);
                        }
                        newlist.add(i);
                        dfs(relation,newcheck,newlist,count);
                    }
                }

        }
    }
}