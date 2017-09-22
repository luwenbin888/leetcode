/**
 Given a positive integer, return its corresponding column title as appear in an Excel sheet.

 For example:

 1 -> A
 2 -> B
 3 -> C
 ...
 26 -> Z
 27 -> AA
 28 -> AB
 */
public class Problem168 {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n = n - 1;
            char c = (char)(n % 26 + 'A');
            sb.insert(0, c);
            n = n / 26;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Problem168 problem168 = new Problem168();
        String result = problem168.convertToTitle(27);
        System.out.println(result);
    }
}
