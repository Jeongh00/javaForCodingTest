package Programmers;

import java.util.HashMap;
import java.util.Iterator;

public class spy {

    public int solution(String [][] clothes) {

        // 옷을 종류별로 구분
        HashMap<String, Integer> map = new HashMap<>();
        for(String [] clothe : clothes) {
            String type = clothe[1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }

        // 입지 않는 경우 고려
        Iterator<Integer> it = map.values().iterator();
        int answer = 1;

        while(it.hasNext()) answer *= it.next().intValue() + 1;

        return answer - 1;
    }

}
