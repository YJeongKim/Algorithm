import java.util.*;

/* 문제: 괄호 회전하기 / 분류: 월간 코드 챌린지 시즌2 */
public class PGM76502 {
    public static void main(String[] args) {
        String[] s = { "[](){}", "}]()[{", "[)(]", "}}}" };

        for (int i = 0; i < s.length; i++) {
            System.out.println(solution(s[i]));
        }
    }

    public static int solution(String s) {
        int answer = 0;
        int len = s.length();

        for (int i = 0; i < len; i++) {
            char[] t = rotateString(s, i).toCharArray();
            Stack<Character> stack = new Stack<>();
            for (int j = 0; j < len; j++) {
                if (t[j] == '(' || t[j] == '[' || t[j] == '{') {
                    stack.push(t[j]);
                    continue;
                }
                if (!stack.isEmpty()) {
                    char p = stack.peek();
                    if ((p == '(' && t[j] == ')') || (p == '[' && t[j] == ']') || (p == '{' && t[j] == '}')) {
                        stack.pop();
                        continue;
                    }
                }
                stack.push(t[j]);
            }
            if (stack.size() == 0) answer++;
        }
        return answer;
    }

    public static String rotateString(String s, int idx) {
        StringBuilder rotation = new StringBuilder();

        for (int i = idx; i < s.length(); i++)
            rotation.append(s.charAt(i));
        for (int i = 0; i < idx; i++)
            rotation.append(s.charAt(i));
        return rotation.toString();
    }
}