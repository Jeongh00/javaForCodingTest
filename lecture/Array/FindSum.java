package lecture.Array;

public class FindSum {
    public int solution(int n, int m, int [] arr) {
        int answer=0, sum=0, lt=0;
        for(int rt=0; rt<n; rt++) {
            sum += arr[rt];
            if(sum == m) answer++;
            while(sum >= m) {
                sum -= arr[lt++];
                if(sum == m) answer++;
            }
        }
        return answer;
    }
}
