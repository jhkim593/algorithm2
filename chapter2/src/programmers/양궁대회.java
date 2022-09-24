package programmers;

import java.util.Arrays;
class Solution {
    int max=0;
    int[] arr;
    public int[] solution(int n, int[] info) {
        int[] answer = {};
        for(int i=0; i<=10;i++){
            int[]temp=new int[12];
            temp[11]=n;
            dfs(info , temp,i);
        }
        if(max==0)return new int[]{-1};

        else{
            return arr;
        }
    }

    public void dfs(int[] info,int[]temp,int start){
        if(temp[11]==0){

            int []newTemp = new int[11];
            for(int i=0;i<newTemp.length;i++){
                newTemp[i]=temp[i];
            }

            int score=check(info,newTemp);
            if(max==0){
                if(max<score){
                    arr=newTemp;
                    max=score;
                }
                else return;
            }
            else{
                if(max==score){
//                     for(int ggg:newTemp){
//                         System.out.print(ggg);

//                     }
//                     System.out.println();

//                     for(int bbb:arr){
//                         System.out.print(bbb);

//                     }
//                     System.out.println();
                    for(int k=0; k<newTemp.length;k++){
                        int index=newTemp.length-1-k;
                        if(newTemp[index]>arr[index]){
                            arr=newTemp;
                            return;
                        }
                        else if (newTemp[index]==arr[index]){
                            continue;
                        }
                        else{
                            return;
                        }
                    }
                }
                else if(max<score){
                    max=score;
                    arr=newTemp;
                }
                else return;
            }
        }
        for(int i=start;i<=10;i++){
            if(i==10&&temp[11]>0){
                   int[]newTemp=temp.clone();
                    newTemp[10]=newTemp[10]+newTemp[11];
                    newTemp[11]=0;
                dfs(info,newTemp,i+1);
                }
            if(temp[11]>=info[i]+1){
                int[]newTemp=temp.clone();
                newTemp[11]=newTemp[11]-(info[i]+1);
                newTemp[i]=info[i]+1;
                dfs(info,newTemp,i+1);

            }
        }
    }
    public int check (int[]info,int[]temp){

        int peach=0;
        int lion=0;
        for(int i=0; i<10;i++){
            if(info[i]==0&&temp[i]==0)continue;
            if(info[i]>=temp[i]){
                peach+=10-i;
            }
            else {
                lion+=10-i;
            }
        }
        if(lion-peach<=0){
            return 0;
        }
        else return lion -peach;
    }
}
