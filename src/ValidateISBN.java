public class ValidateISBN {
    public static boolean isValid(String s) {
        if (s == null || s.length() != 10) return false;
        int sum = 0; int multiplier = 10;
        for (int i = 0; i < s.length() - 1; i++) {
            char ch = s.charAt(i);
            int digit = ch - '0';
            if(digit < 0 || digit > 9) {
                return false;
            }
            sum += digit * multiplier;
            multiplier--;
        }
        char last = s.charAt(s.length() - 1);
        if (last != 'X' && (last < '0' || last > '9'))
            return false;

        if (last == 'X') {
            sum += 10;
        } else {
            int digit = last - '0';
            sum += digit * 1;
        }
        return sum % 11 == 0 ? true : false;
    }

    public static void main(String[] args) {
        String s = "007462542X";
        String s1 = "0112112425";
        System.out.println(isValid(s1));
    }
}
