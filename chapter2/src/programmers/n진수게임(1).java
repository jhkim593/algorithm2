class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        int index=0;
        int count=0;
        int check=1;
        int total=1;
        int b=0;
         String a="";
        while(answer.length()!=t){
            if(count==0){
            
            a="";
            int temp=index;
           while(true){
               
               
                   b=1;
                   if(temp%n>=10){
                       char ch=(char)((temp%n)+55);
                       a=ch+a;
                       temp/=n;
                   }
                   
                   else{a=String.valueOf(temp%n)+a;
                   temp/=n;
                       }
                       
                   if(temp==0){break;}
              
           }
                if(b==1){count=a.length();
                   check=1;
                    index++;b=0;}
                
                
        }
            if(total%m==p){
                answer+=a.charAt(check-1);
                
            }
            if(count-check==0){
                count=0;
            }
            check++;
            total++;
            
        }
        return answer;
    }
}