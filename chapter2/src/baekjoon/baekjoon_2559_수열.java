import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = 0;
        int size = 0;


        StringTokenizer st;
        st = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(st.nextToken());
        size = Integer.parseInt(st.nextToken());


        int[] arr = new int[n];

        st = new StringTokenizer(reader.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        int max = -Integer.MAX_VALUE;
        for(int i=0; i< arr.length; i++){
            if( i< size) {
                sum += arr[i];
            }
            else {
                sum += arr[i];
                sum -= arr[i-size];
            }

            if(i+1 >= size){
                if(max < sum){
                    max = sum;
                }
            }

        }
        System.out.print(max);

    }
}
