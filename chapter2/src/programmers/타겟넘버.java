import java.util.Arrays;
class Solution {
      	int answer=0;
	  
		public int solution(int[] numbers, int target) {
			
			
			search(1,numbers[0],numbers,target);
			search(1,-numbers[0],numbers,target);
			return answer;
			
		
		}
		public void search(int index,int current,int[]numbers,int target) {
			if(index>=numbers.length) {
				if(target==current) {
					answer++;
				}
				
			}
            else{
			int cur1=current+numbers[index];
			int cur2=current-numbers[index];
			
			search(index+1,cur1,numbers,target);
			search(index+1,cur2,numbers,target);
            }
		
			
			
		}
}