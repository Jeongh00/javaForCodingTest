package lecture.StackAndQueue;

import java.util.Stack;

public class correctBracket {

    public String solution(String str){

        String answer = "YES";

        Stack<Character> stack = new Stack<>();
        for(char x : str.toCharArray()){
            if(x == '(') stack.push(x);
            else{
                if(stack.isEmpty()) return "NO";
                stack.pop();
            }
        }

        if(!stack.isEmpty()) return "NO";
        return answer;

    }

}
