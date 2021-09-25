package programmers;

class 숫자의나라124 {
    public String solution(int n) {
        String answer = "";
        while(n>=3){
           int b=n%3;
            if(b==0){
                n=n/3-1;
            }
            else{
                n=n/3;
            }
            answer=String.valueOf(b)+answer;
            
        }
        if(n!=0)
        answer=String.valueOf(n)+answer;
        answer=answer.replaceAll("0","4");
        return answer;
    }
}