class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        
        for(int i=0;i<musicinfos.length;i++){
            int count=0;
           String []temp=musicinfos[i].split(",");
           String []st=temp[0].split(":");
            String[]en=temp[1].split(":");
           String start=st[0]+st[1];
            String end=en[0]+en[1];
            String clock=String.valueOf(Integer.parseInt(end)-Integer.parseInt(start));
            if(clock.length()<=2){
                count=Integer.parseInt(clock);
            }
            else{
                if(clock.length()==3){
                    int cl=clock.charAt(0)-'0';
                    count+=cl*60;
                    count+=Integer.parseInt(clock.substring(1,3));
                    
                }
                else if(clock.length()==4){
                    int cl1=clock.charAt(0)-'0';
                    int cl2=clock.charAt(1)-'0';
                    count=cl1*600+cl2*60+Integer.parseInt(clock.substring(2,4));
                }
            }
            int len=temp[3].split("#").length;
            String test="";
            while(true){
                if(count>len){
                count/=len;
                test+=temp[3];}
                else{
                for(int k=0;k<count;k++){
                    if(temp[3].charAt(k)=='#'){
                        test+='#';
                        count++;
                    }
                    else{
                        test+= temp[3].charAt(k);
                    }
                }
            break;
            }
            }
            
            if(test.contains(m)){
              if(m.charAt(m.length()-1)=='#'){
                  return temp[2];
              }
                else{
                    
                }
                
            }
            
            
        }
        return "(None)";
    }
}