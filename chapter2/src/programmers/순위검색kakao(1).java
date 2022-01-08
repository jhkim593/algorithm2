import java.util.*;

class Solution {
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
//         for (int i=0 ; i<info.length;i++){
//             String[] temp=info[i].split(" ");
//             for(int j=0; j<5;j++){
                
//             }
//         }
        
        for(int i=0;i<query.length;i++){
            List<String>list=new ArrayList<>();
            for(int c=0;c<info.length;c++){
                list.add(String.valueOf(c));
            }
            String []tempx=query[i].split(" and ");
            List<String>tempList=new ArrayList<>(Arrays.asList(tempx));
            tempList.remove(3);
            tempList.add(tempx[3].split(" ")[0]);
            tempList.add(tempx[3].split(" ")[1]);
            String[]temp=tempList.toArray(new String[tempList.size()]);
           
      
             // System.out.println("======="+i);
            // System.out.print(temp[0]+" "+temp[1]+" "+temp[2]+" "+temp[3]);
            for(int j=0;j<4;j++){
                if(!temp[j].equals("-")){
                   
            // System.out.println(list.size());
                    if(find(list,j,temp[j] ,info)==0) break;
                }
            }
            
            // 점수 확인
            int count=0;
            int sizex=list.size();
            List<Integer>score=new ArrayList<>();
            for(int j=0;j<list.size();j++){
                
                score.add(Integer.parseInt(info[Integer.parseInt(list.get(j))].split(" ")[4]));
            }
            // if(!score.contains((Integer)Integer.parseInt(temp[4])))
            //     score.add(Integer.parseInt(temp[4]));
            
            Collections.sort(score);
            // for(int n=0;n<score.size();n++){
            //     System.out.println(score.get(n));
            // }
            int middle=0;
            int first=0;
            int last=score.size()-1;
            while(first<=last){
                middle=(first+last)/2;
                // if(Integer.parseInt(temp[4])==score.get(middle)){break;}
                // else{
                    if(Integer.parseInt(temp[4])>score.get(middle)){
                        first=middle+1;
                    }
          
                    else{
                        last=middle-1;
                    }
                    
                // }
            }
            
            
            // answer[i]=list.size();
            answer[i]=sizex-first;
            // System.out.println("==============");
        }
        return answer;
    }
    public int find(List<String> list, int index,String str ,String[]info){
        if(list.isEmpty())return 0;
        List<String>cor=new ArrayList<>();
        for(int i=0;i<list.size();i++){
            String []temp=info[Integer.parseInt(list.get(i))].split(" ");
            if(!temp[index].equals(str)){
                cor.add(list.get(i));
            }
        }
        for(int i=0;i<cor.size();i++){
            list.remove(cor.get(i));
        }
        return 1;
    }
}