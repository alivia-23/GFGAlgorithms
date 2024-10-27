package String;

public class Test {

    public static void print(String[] s) {
        for (String s1 : s) {
            System.out.print(s1 + " ");
        }
    }
    public static void main(String[] args) {
        String s = "m.y+name@email.com";
        String[] str = s.split("@");
        print(str);

    }
}
