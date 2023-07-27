import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = null;
        st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());

        for(int i=0; i<n;i++){
            st = new StringTokenizer(reader.readLine());

            //a , b 수
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // a초기화
            int[] arrA  = new int[a];
            st = new StringTokenizer(reader.readLine());
            for(int j = 0; j<a;j++){
                arrA[j] = Integer.parseInt(st.nextToken());
            }

            //b초기화
            int[] arrB  = new int[b];
            st = new StringTokenizer(reader.readLine());
            for(int k=0; k<b;k++){
                arrB[k] = Integer.parseInt(st.nextToken());
            }

            //오름차순 변경
            Arrays.sort(arrA);
            Arrays.sort(arrB);

            int sum = 0;
            int bIdx = 0;
            for(int j = 0; j<a;j++){
                int valA = arrA[j];

                for(int k=bIdx;k<b;k++){
                    int valB = arrB[k];
                    if(valA <= valB){
                        break;
                    }else{
                        bIdx++;
                    }
                }
                sum = sum + bIdx;
            }
            System.out.println(sum);
        }
    }
}
