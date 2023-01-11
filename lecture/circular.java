package lecture;

import java.util.Scanner;

class circular {
    public String solution(String str) {
        String answer = "YES";
        String tmp = new StringBuilder(str).reverse().toString();
        if(str.equalsIgnoreCase(tmp)) answer = "YES";
        return answer;
    }

    public static void main(String args[]) {
        circular T = new circular();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.print(T.solution(str));
    }
}


