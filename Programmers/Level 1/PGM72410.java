/* 문제: 신규 아이디 추천 / 분류: 2021 KAKAO BLIND RECRUITMENT, 정규식 */
public class PGM72410 {
    public static void main(String[] args) {
        String[] numbers = { "...!@BaT#*..y.abcdefghijklm", "z-+.^.", "=.=", "123_.def", "abcdefghijklmn.p" };

        for (String number : numbers) {
            System.out.println(solution(number));
        }
    }

    public static String solution(String new_id) {
        String answer = "";
        answer = replaceLowercase(new_id);
        answer = removeLetter(answer);
        answer = replaceDot(answer);
        answer = removeDot(answer);
        answer = addEmptyString(answer);
        answer = removeLongString(answer);
        answer = repeatString(answer);
        return answer;
    }

    public static String replaceLowercase(String s) {
        return s.toLowerCase();
    }

    public static String removeLetter(String s) {
        String regex = "[^a-z0-9-_.]";
        return s.replaceAll(regex, "");
    }

    public static String replaceDot(String s) {
        String regex = "[.]{2,}";
        return s.replaceAll(regex, ".");
    }

    public static String removeDot(String s) {
        if (s.charAt(0) == '.')
            s = s.substring(1);
        if (s.length() > 1 && s.charAt(s.length() - 1) == '.')
            s = s.substring(0, s.length() - 1);
        // 다음과 같이 대체 가능
        // String regex = "^[.]|[.]$";
        // s = s.replaceAll(regex, "");
        return s;
    }

    public static String addEmptyString(String s) {
        if (s.length() == 0)
            s += "a";
        return s;
    }

    public static String removeLongString(String s) {
        if (s.length() >= 16) {
            s = s.substring(0, 15);
            if (s.charAt(s.length() - 1) == '.')
                s = s.substring(0, s.length() - 1);
        }
        return s;
    }

    public static String repeatString(String s) {
        char last = s.charAt(s.length() - 1);
        while (s.length() < 3) {
            s += last;
        }
        return s;
    }
}