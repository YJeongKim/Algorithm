/* 문제: 숫자 문자열과 영단어 / 분류: 2021 카카오 채용연계형 인턴십 */
public class PGM81301 {
    public static void main(String[] args) {
        String[] s = { "one4seveneight", "23four5six7", "2three45sixseven", "123" };

        for (int i = 0; i < s.length; i++) {
            System.out.println(solution(s[i]));
        }
    }

    public static int solution(String s) {
        String[][] numbers = new String[][] { { "zero", "0" }, { "one", "1" }, { "two", "2" }, { "three", "3" },
                { "four", "4" }, { "five", "5" }, { "six", "6" }, { "seven", "7" }, { "eight", "8" }, { "nine", "9" } };

        for (int i = 0; i < numbers.length; i++) {
            s = s.replaceAll(numbers[i][0], numbers[i][1]);
        }
        return Integer.parseInt(s);
    }
}