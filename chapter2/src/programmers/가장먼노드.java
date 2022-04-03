import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        // 인접 2차원 배열로 문제 접근시 메모리 초과됨
//         int  [][]arr = new int[n][n];
//         int answer=0;
//         int count =0;
//         int []check=new int [n];
//         Queue<int[]>que=new LinkedList<>();
//         for(int i=0;i<edge.length;i++){
//             arr[edge[i][0]-1][edge[i][1]-1]=1;
//             arr[edge[i][1]-1][edge[i][0]-1]=1;
//         }


//         que.add(new int[]{1,1});
//         check[0]=1;
//         while(!que.isEmpty()){
//             int[] poll=que.poll();
//             int temp=poll[0];
//             int length=poll[1];
//             for(int i=0;i<n;i++){
//                 if(arr[temp-1][i]==1&&check[i]==0){
//                     que.add(new int[]{i+1,length+1});
//                     check[i]=1;
//                   if(count<length){
//                       count=length;
//                       answer=1;
//                   }
//                   else if(count==length){
//                       answer++;
//                   }
//                 }
//             }
//         }

        //인접 리스트 방식으로 접근
        ArrayList<ArrayList<Integer>> list= new ArrayList<>();

        int answer=0;
        int count =0;
        int []check=new int [n+1];
        Queue<int[]>que=new LinkedList<>();

        for(int i=0;i<n+1;i++){
            list.add(new ArrayList<>());
        }

        for(int i=0;i<edge.length;i++){
            list.get(edge[i][0]).add(edge[i][1]);
            list.get(edge[i][1]).add(edge[i][0]);
        }


        que.add(new int[]{1,1});
        check[1]=1;
        while(!que.isEmpty()){
            int[] poll=que.poll();
            int temp=poll[0];
            int length=poll[1];
            for(int i=0;i<n+1;i++){
                if(list.get(i).contains(temp)&&check[i]==0){
                    que.add(new int[]{i,length+1});
                    check[i]=1;
                  if(count<length){
                      count=length;
                      answer=1;
                  }
                  else if(count==length){
                      answer++;
                      System.out.println(answer);
                  }
                }
            }
        }


    return answer;


    }
}
