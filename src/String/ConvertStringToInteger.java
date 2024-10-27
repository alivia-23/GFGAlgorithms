package String;

public class ConvertStringToInteger {
    public int getLucky(String s, int k) {
        String numStr = convert(s);

        while (k > 0) {
            numStr = transform(numStr);
            k--;
        }
        return Integer.parseInt(numStr);
    }

    private String convert(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int num = c - 'a' + 1;
            sb.append(num);
        }
        return sb.toString();
    }

    private String transform(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += s.charAt(i) - '0';
        }
        return String.valueOf(sum);
    }

    public static void main(String[] args) {
        String s = "leetcode";
        int k = 2;
        int result = new ConvertStringToInteger().getLucky(s, k);
        System.out.println(result);
    }
}
