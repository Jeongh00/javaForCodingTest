package Programmers;

import java.util.Arrays;
import java.util.HashMap;

public class phoneList {

    public boolean solution1(String[] phone_book) {

        // phone book을 정렬
        Arrays.sort(phone_book);

        // loop 를 통해 접두어인지 확인
        for(int i=0; i< phone_book.length - 1; i++){
            if(phone_book[i+1].startsWith(phone_book[i])){
                return false;
            }
        }

        // 저 조건을 그대로 통과했다면
        return true;

    }

    public boolean solution2(String[] phone) {

        // hashmap 을 만든다
        HashMap<String, Integer> map = new HashMap<>();
        for(int i= 0; i< phone.length; i++) {
            map.put(phone[i], 1);
        }

        // 모든 전화번호 접두어가 map에 있는지를 확인
        //if(map.containsKey(phone[i].substring(0,j))) return false;

        // 다 통과했다면
        return true;

    }

}
