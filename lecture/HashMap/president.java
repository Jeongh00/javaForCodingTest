package lecture.HashMap;

import java.util.HashMap;

public class president {

    public char soltuion(Integer n, String s) {

        char answer = ' ';

        HashMap<Character, Integer> map = new HashMap<>();

        for(char x : s.toCharArray()){
            map.put(x, map.getOrDefault(x,0) + 1);
        }

        int MAX = Integer.MIN_VALUE;
        for(char key : map.keySet()){
            if(map.get(key) > MAX){
                MAX = map.get(key);
                answer = key;
            }
        }

        return answer;

    }

}
