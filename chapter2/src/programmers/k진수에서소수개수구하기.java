package programmers;

import java.util.Stack;

class k진수에서소수개수구하기 {
    public int solution(int n, int k) {
        int answer = 0;

        int start=n;
        String str="";
        while(true){
            if(start<k){
                str=String.valueOf(start)+str;
                break;
            }
            str=String.valueOf(start%k)+str;
            start=start/k;
        }
        String []split=str.split("0");
        for(String temp : split){
            if(temp.equals(""))continue;
            // System.out.println(temp);
            if(check(Long.parseLong(temp))){
                answer++;
            }
        }
        return answer;
    }

    public boolean check(long num){
        if(num<=1)return false;
        // if(num==2)return true;
        for(int i=2;i<=Math.sqrt(num);i++){
            // if(num%i==0){return false;}
            // if(num%(num-i)==0){return false;}
            if(num%i==0)return false;
        }
        return true;
    }
}