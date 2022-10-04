package programmers;

class Solution {
    public int[] solution(int n, long left, long right) {
        int[]arr=new int[(int)(right-left)+1];
        int index=0;
        for(long i=left;i<=right;i++){
            int num=(int)((i+1)/n);
            int ext=(int)((i+1)%n);
            if(ext==0){
                arr[index]=n;
            }
            else{
                if(num+1>=ext){
                    arr[index]=num+1;
                }
                else{
                    arr[index]=ext;
                }
            }
            index++;
        }
        return arr;
    }
}
