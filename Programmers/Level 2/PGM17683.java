import java.util.*;

/* 문제: 방금그곡 / 분류: 2018 KAKAO BLIND RECRUITMENT, 문자열 */
public class PGM17683 {
    private static int[] pi;

    public static void main(String[] args) {
        String[] m = { "ABCDEFG", "CC#BCC#BCC#BCC#B", "ABC", "ABC", "ABC", "ABC", "ABCDEFGABCDEFG" };
        String[][] musicinfos = { { "12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF" },
                { "03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B" },
                { "12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF" }, { "00:00,00:05,HI,ABC#ABC" },
                { "00:00,00:06,HI,ABC#ABC" }, { "00:00,00:04,HI,ABC#ABC" }, { "00:00,00:08,HI,ABCDEFG" } };

        for (int i = 0; i < m.length; i++) {
            System.out.println(solution(m[i], musicinfos[i]));
        }
    }

    public static String solution(String m, String[] musicinfos) {
        String answer = "";
        int max = 0;
        int len = musicinfos.length;
        m = updateSheet(m);
        pi = initPi(m);

        for (int i = 0; i < len; i++) {
            StringTokenizer st = new StringTokenizer(musicinfos[i], ",:");
            int[] times = new int[4];
            for (int j = 0; j < 4; j++)
                times[j] = Integer.parseInt(st.nextToken());
            int playtime = findPlaytime(times);
            String title = st.nextToken();
            String sheet = findPlayedSheet(playtime, updateSheet(st.nextToken()));
            if (KMP(sheet, m) && max < playtime) {
                answer = title;
                max = playtime;
            }
        }
        return answer.equals("") ? "(None)" : answer;
    }

    public static String updateSheet(String m) {
        String[] sharp = { "C#", "D#", "F#", "G#", "A#" };
        String[] natural = { "c", "d", "f", "g", "a" };
        for (int i = 0; i < sharp.length; i++) {
            m = m.replaceAll(sharp[i], natural[i]);
        }
        return m;
    }

    public static int[] initPi(String m) {
        pi = new int[m.length()];
        int j = 0; // j: 접두사, i: 접미사

        for (int i = 1; i < m.length(); i++) {
            while (j > 0 && m.charAt(i) != m.charAt(j))
                j = pi[j - 1]; // 일치할때까지 [j-1] 값 만큼 이동
            if (m.charAt(i) == m.charAt(j)) pi[i] = ++j;
        }
        return pi;
    }

    public static int findPlaytime(int[] times) {
        int hour = times[2] - times[0]; // hour = end_hour - start_hour
        int minute = times[3] - times[1]; // minute = end_minute - start_minute;

        if (times[3] < times[1]) {
            hour--;
            minute += 60;
        }
        return hour * 60 + minute;
    }

    public static String findPlayedSheet(int playtime, String sheet) {
        StringBuilder result = new StringBuilder();
        int idx = 0, n = sheet.length();

        for (int i = 0; i < playtime; i++) {
            result.append(sheet.charAt(idx++));
            if (idx == n) idx = 0;
        }
        return result.toString();
    }

    public static boolean KMP(String s, String m) {
        int j = 0, slen = s.length(), mlen = m.length();

        for (int i = 0; i < slen; i++) {
            while (j > 0 && s.charAt(i) != m.charAt(j))
                j = pi[j - 1];
            if (s.charAt(i) == m.charAt(j)) {
                if (j == mlen - 1) return true; // 모든 멜로디 일치
                else j++;
            }
        }
        return false;
    }
}