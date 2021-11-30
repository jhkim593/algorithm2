package programmers;

import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        con:
        for(int i=0;i<phone_book.length;i++){
            String a=phone_book[i];
            for(int j=i+1;j<phone_book.length;i++){
                String temp=phone_book[j];
                if(a.length()<temp.length()){
                    if(temp.substring(0,a.length()).equals(a)){
                        answer=false;break con;}
                    else{break;}
                    
                }
                else{break;}
               
                
            }
        }
        return answer;
    }
}