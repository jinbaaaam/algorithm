import java.util.*;
import java.io.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] s1= {1,2,3,4,5};
		int[] s2= {2,1,2,3,2,4,2,5};
		int[] s3= {3,3,1,1,2,2,4,4,5,5};
		int s1Count=0;
		int s2Count=0;
		int s3Count=0;
		//가변 배열이므로 ArrayList 이용 차후에 배열로 복사
		List<Integer> arr = new ArrayList<>();  
		
		
		for(int i=0;i<answers.length;i++) {
			if(answers[i]==s1[i%5]) {
				s1Count++;
			}
			if(answers[i]==s2[i%8]) {
				s2Count++;
			}
			if(answers[i]==s3[i%10]) {
				s3Count++;
			}
		}
		if(s1Count>=s2Count && s1Count>=s3Count) {
			arr.add(1);
		}
		if(s2Count>=s3Count && s2Count>=s1Count) {
			arr.add(2);
		}
		if(s3Count>=s1Count && s3Count>=s2Count) {
			arr.add(3);
		}
		
		int[] answer = new int[arr.size()];
		for(int i=0;i<arr.size();i++) {
			answer[i]=arr.get(i);
		}
		
        return answer;
    }
}