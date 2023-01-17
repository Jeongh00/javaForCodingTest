package lecture.HashMap;

import java.util.HashMap;

public class Anagram {

    public String solution(String s1, String s2) {
        String answer = "YES";

        HashMap<Character, Integer> map = new HashMap<>();
        for(char x : s1.toCharArray()){
            map.put(x, map.getOrDefault(x,0)+1);
        }
        for(char x : s2.toCharArray()){
            map.put(x,map.get(x)-1);
            if(!map.containsKey(x) || map.get(x) == 0) return "NO";
        }

        return answer;
    }

}
