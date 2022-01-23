class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        int count=1;
        int num=0;
        root:
        while(answer.length()<t){
            int sum=num;
            String str="";
            while(sum>=n){
                String temp="";
                if(sum%n>=10){
                    int a='A'-10;
                    char b=(char)(a+(sum%n));
                    temp=""+b;
                }
                else{
                    temp=String.valueOf(sum%n);
                }
                str=temp+str;
                sum=sum/n;
            }
            
            String temp="";
            if(sum>=10){
                    int a='A'-10;
                    char b=(char)(a+(sum));
                    temp=""+b;
                }
                else{
                    temp=String.valueOf(sum);
                }
            str=temp+str;
            num++; 
            for(int j=0;j<str.length();j++){
                if(count==p)answer=answer+str.charAt(j);
                count++;
                if(answer.length()==t)break root;
                if(count>m)count=1;
             }
        }
        return answer;
    }
}