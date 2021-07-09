/* 문제: JadenCase 문자열 만들기 / 분류: 연습문제 */
public class PGM12951 {
    public static void main(String[] args) {
        String[] s = { "3people unFollowed me", "for the last week", "hello        we",
                "3peOple 3unFollowed mE", "far" };

        for (int i = 0; i < s.length; i++) {
            System.out.println(solution(s[i]));
        }
    }

    public static String solution(String s) {
        StringBuilder answer = new StringBuilder();
        int idx = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (i == idx && c >= 'a' && c <= 'z') {
                c -= 32;
                answer.append(c);
                continue;
            }
            if (i != idx && c >= 'A' && c <= 'Z') {
                c += 32;
                answer.append(c);
                continue;
            }
            if (c == ' ' && i + 1 < s.length() - 1 && s.charAt(i + 1) != ' ') {
                idx = i + 1;
            }
            answer.append(c);
        }
        return answer.toString();
    }
}