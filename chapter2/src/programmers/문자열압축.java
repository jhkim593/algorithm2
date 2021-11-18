package programmers;

class 문자열압축 {
    public int solution(String s) {
        if(s.length()==1)return 1;
        int size=s.length()/2;
//         Queue<String>que=new LinkedList<>();
//         String []temp=s.split("");
//         for(int i=0;i<temp.length;i++){
//             que.add(temp[i]);
//         }
        
//         while(!que.isEmpty()){
            
//         }
        int min=0;
        for(int i=1;i<=size;i++){
            int cnt=0;
            int len=s.length()-i;
            int index=i;
            String ori=s.substring(0,i);
            String t="";
            while(len>=i){
                String temp=s.substring(index,index+i);
                index=index+i;
                if(ori.equals(temp)){cnt++;
                    
                }
                else{
                    if(cnt==0){
                    t+=ori;
                    }
                    else{
                        t=String.valueOf(cnt+1)+ori+t;
                        cnt=0;
                    }
                    ori=temp;
                }
                len-=i;
                if(len<i){
                    if(cnt!=0){t=String.valueOf(cnt+1)+ori+t;}
                    else{t+=temp;}
                }
            }
           
            int al=len+t.length();
            if(i==1){min=al;}
            else if(min>al){min=al;}
            
        }
        return min;
    }
}