class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int sum=0;
        int count=0;
        while(!s.equals("1")){
            count++;
             String news=s.replace("0","");
             sum+=s.length()-news.length();
            int temp=news.length();
          s=Integer.toBinaryString(temp);
           
//             String com="";
//              while(temp!=0){
//                 com=String.valueOf(temp%2)+com;temp/=2;
                 
                 
//              }
//             s=com;
            
        }
       
        
        return new int[]{count,sum};
    }
}