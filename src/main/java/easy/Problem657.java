package easy;

/**
 Initially, there is a Robot at position (0, 0). Given a sequence of its moves, judge if this robot makes a circle,
 which means it moves back to the original place.

 The move sequence is represented by a string. And each move is represent by a character.
 The valid robot moves are R (Right), L (Left), U (Up) and D (down).
 The output should be true or false representing whether the robot makes a circle.

 Example 1:

 Input: "UD"
 Output: true

 Example 2:

 Input: "LL"
 Output: false

 */
public class Problem657 {
    public boolean judgeCircle(String moves) {
        int rCnt = 0, lCnt = 0, uCnt = 0, dCnt = 0;
        for (int i = 0; i < moves.length(); i++) {
            switch (moves.charAt(i)) {
                case 'R':
                    rCnt++;
                    break;
                case 'L':
                    lCnt++;
                    break;
                case 'U':
                    uCnt++;
                    break;
                case 'D':
                    dCnt++;
                    break;
            }
        }

        return (rCnt == lCnt) && (uCnt == dCnt);
    }

    public static void main(String[] args) {
        Problem657 problem657 = new Problem657();
        boolean result = problem657.judgeCircle("UD");
        System.out.println(result);
    }
}
