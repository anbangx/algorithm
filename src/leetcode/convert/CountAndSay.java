package leetcode.convert;

public class CountAndSay {

    public String countAndSay(int n) {
        StringBuilder input = new StringBuilder("1");
        StringBuilder sb = new StringBuilder("1");
        for (int i = 1; i < n; i++) {
            sb = new StringBuilder("");
            int len = String.valueOf(input).length();
            if (len == 1) {
                sb.append(1);
                sb.append(1);
                input = new StringBuilder(sb.toString());
                continue;
            }
            int preDigit = input.charAt(0) - '0';
            int count = 1;
            int curDigit = -1;
            for (int j = 1; j < len; j++) {
                curDigit = input.charAt(j) - '0';
                if (preDigit == curDigit) {
                    count++;
                } else {
                    sb.append(count);
                    sb.append(preDigit);
                    preDigit = curDigit;
                    count = 1;
                }
                if (j == len - 1) {
                    sb.append(count);
                    sb.append(preDigit);
                }
            }

            input = new StringBuilder(sb.toString());
        }

        return sb.toString();
    }

    public int getDigit(long number, int digit) {
        return (int) ((number / (int) Math.pow(10, digit - 1)) % 10);
    }

    public static void main(String[] args) {
        CountAndSay cas = new CountAndSay();
        System.out.println(cas.countAndSay(10));
        //        Integer.parseInt("31131211131221");
    }

}
