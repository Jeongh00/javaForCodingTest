package lecture;

public class slidingWindow {

    public int solution(int n, int k, int [] arr) {
        int answer=0 , sum=0 ;
        for(int i=0; i<k; i++) sum+=arr[i];
        answer=sum;
        for(int i=k; i<n; i++) {
            sum += (arr[i] - arr[i-k]);
            answer = Math.max(answer, sum);
        }
        return answer;
    }

}
