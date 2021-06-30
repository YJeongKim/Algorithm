/* 문제: 키패드 누르기 / 분류: 2020 카카오 인턴십 */
public class PGM67256 {
    private static int[][] keypad;
    private static int[][] finger;
    private static final int lf = 0, rf = 2; // 왼,오른손가락 위치

    public static void main(String[] args) {
        int[][] numbers = { { 1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5 }, { 7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2 },
                { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 } };
        String[] hand = { "right", "left", "right" };

        for (int i = 0; i < numbers.length; i++) {
            System.out.println(solution(numbers[i], hand[i]));
        }
    }

    public static String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        keypad = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { -10, 0, 10 } }; // '*': -10, '#': 10
        finger = new int[][] { { 3, 0 }, { 0 }, { 3, 2 } }; // [0][]: 왼손, [2][]: 오른손

        for (int number : numbers) {
            switch (number) {
            case 1:
            case 4:
            case 7:
                changeFingerPosition(number, lf);
                answer.append('L');
                break;
            case 3:
            case 6:
            case 9:
                changeFingerPosition(number, rf);
                answer.append('R');
                break;
            default:
                char h = findWhichHand(number, hand);
                answer.append(h);
            }
        }
        return answer.toString();
    }

    public static void changeFingerPosition(int number, int f) {
        for (int i = 0; i < 4; i++) {
            if (keypad[i][f] == number) {
                finger[f][0] = i;
                finger[f][1] = f;
                break;
            }
        }
    }

    public static char findWhichHand(int number, String hand) {
        int x, y = 1;
        char result;

        for (x = 0; x < 4; x++) {
            if (keypad[x][y] == number)
                break;
        }

        int leftDistance = Math.abs(finger[lf][0] - x) + Math.abs(finger[lf][1] - y);
        int rightDistance = Math.abs(finger[rf][0] - x) + Math.abs(finger[rf][1] - y);

        if (leftDistance == rightDistance) {
            result = hand.equals("left") ? 'L' : 'R';
        } else {
            result = leftDistance < rightDistance ? 'L' : 'R';
        }

        if (result == 'L') {
            finger[lf][0] = x;
            finger[lf][1] = y;
        } else {
            finger[rf][0] = x;
            finger[rf][1] = y;
        }
        return result;
    }
}