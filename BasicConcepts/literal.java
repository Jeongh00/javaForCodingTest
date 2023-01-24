package BasicConcepts;

public class literal {

    public static void main(String[] args){
        String s = "I like Java and Python";

        System.out.println(s.length());

        s.toUpperCase();

        s.contains("Java");

        s.indexOf("C++"); // 몇 번째위치에 있는지와 없으면 -1 반환

        s.lastIndexOf("and"); // 마지막 위치 반환
    }

}
