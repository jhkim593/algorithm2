import java.util.*;
class Solution {
    Queue<String>que=new LinkedList<>();
    public int solution(String s) {
       
       
       StringBuilder st=new StringBuilder(s);
        
       
         int answer=0;
        for(int i=0;i<s.length();i++){
             String[]arr =st.toString().split("");
             
             Stack<String>stack=new Stack<>();
            
             if(check(stack,arr)==1)answer++;
             
            st.append(st.charAt(0));
            st.deleteCharAt(0);
        }
        return answer;
    }
    public int check(Stack<String>stack , String []arr){
        for(String str:arr){
            if(str.equals("(")||str.equals("[")||str.equals("{")){
                stack.push(str);  
            }
            else {
                if(stack.size()==0)return 0;
                String pop=stack.pop();
                if (str.equals("]")){
                    if(!pop.equals("[")) return 0;
                }
                if (str.equals(")")){
                    if(!pop.equals("(")) return 0;
                }
                if (str.equals("}")){
                    if(!pop.equals("{")) return 0;
                }
            }
        }
        if(stack.size()!=0)return 0;
        return 1;
    }
}