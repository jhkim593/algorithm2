package programmers;

import java.util.*;
class 괄호변환 {
    StringBuilder st;
    String answer="";
    public String solution(String p) {
        String answer = "";
        
        int count=0;
        answer=dfs(p);
      
      
        return answer;
    }
    public String dfs(String p){
        int count=0;
        int check=0;
        Stack<Character>stack=new Stack<>();
       
          for(int i=0;i<p.length();i++){
            if(p.charAt(i)=='('){count+=1;stack.add('(');}
            else {
               count--;
                if(stack.isEmpty()){check++;}
                else{stack.pop();}
                
            }
            if(count==0){
                
               if(check==0){
                  
            return  answer+p.substring(0,i+1)+dfs(p.substring(i+1,p.length()));
               
               }
                else{
                    
                    String temp=p.substring(1,i);
                    String s="";
                    for(int j=0;j<temp.length();j++){
                        if(temp.charAt(j)==')'){
                            s+='(';
                        }
                        else
                            s+=')';
                    }
                    return "("+dfs(p.substring(i+1,p.length()))+")"+s;
                }
            }
        }
    return "";
    }
   
}