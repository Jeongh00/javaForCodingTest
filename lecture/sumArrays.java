package lecture;

import java.util.ArrayList;

public class sumArrays {

    public ArrayList<Integer> solution(int n, int m, int [] a, int [] b) {
        ArrayList<Integer> answer = new ArrayList<>();
        int p1=0, p2 =0;
        while(p1<n && p2<m) {
            if(a[p1] < b[p2]) {
                answer.add(b[p2++]);
            }
        }
        while(p1 < n) answer.add(a[p1++]);
        while(p2 < n) answer.add(a[p2++]);
        return answer;
    }

}
