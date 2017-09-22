/**
 You are given a string representing an attendance record for a student. The record only contains the following three characters:

 'A' : Absent.
 'L' : Late.
 'P' : Present.

 A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).

 You need to return whether the student could be rewarded according to his attendance record.

 Example 1:

 Input: "PPALLP"
 Output: True

 Example 2:

 Input: "PPALLL"
 Output: False
 */
public class Problem551 {
    public boolean checkRecord(String s) {
        return method2(s);
    }

    private boolean method1(String s) {
        int countA = 0;
        int currentL = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'L') currentL++;
            else {
                if (currentL > 2) return false;
                currentL = 0;
                if (c == 'A') countA++;
                if (countA > 1) return false;
            }
        }

        if (currentL > 2) return false;

        return true;
    }

    private boolean method2(String s) {
        return !(s.indexOf('A') != s.lastIndexOf('A') || s.contains("LLL"));
    }

    public static void main(String[] args) {
        Problem551 problem551 = new Problem551();
        boolean result = problem551.checkRecord("PPALLL");
        System.out.println(result);
    }
}
