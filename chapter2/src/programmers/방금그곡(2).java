import java.util.*;
class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int max=0;
        for(String str:musicinfos){
            String[]temp=str.split(",");
            String []timeA=temp[0].split(":");
            String []timeB=temp[1].split(":");
            
            int hour=Integer.parseInt(timeB[0])- Integer.parseInt(timeA[0]);
            int min=Integer.parseInt(timeB[1])- Integer.parseInt(timeA[1]); 
            if(min <0){
                hour=hour-1;
                min=60-Integer.parseInt(timeA[1])+Integer.parseInt(timeB[1]);
            }
            StringBuilder st=new StringBuilder();
            String music=temp[3];
            int count=0;
            for(int i=0;i<60*hour+min;i++){
                st.append(""+music.charAt(count));
                count++;
                if(count<music.length()&& music.charAt(count)=='#'){
                    st.append("#");count++;
                }
                if(count>=music.length())count=0;
            }
            System.out.println(st.toString());
            if(st.toString().contains(m)){
                if(m.charAt(m.length()-1)!='#'){
                //     int check=st.toString().indexOf(m);
                //     if(check+m.length()<st.toString().length()&&st.toString().charAt(check+m.length())=='#'&&st.toString().contains(m))continue;
                // }
                String checkStr=st.toString().replaceAll(m+"#","");
                    if(!checkStr.contains(m))continue;
                    }
            // abc   abc#abc  abc#abc
                if(max<60*hour+min){
                    max=60*hour+min;
                    answer=temp[2];
                }
            }
            
        }
        return answer;
    }
}