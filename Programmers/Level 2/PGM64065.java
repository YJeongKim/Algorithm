import java.util.*;

/* 문제: 튜플 / 분류: 2019 카카오 개발자 겨울 인턴십 */
public class PGM64065 {
    public static void main(String[] args) {
        String[] s = { "{{2},{2,1},{2,1,3},{2,1,3,4}}", "{{1,2,3},{2,1},{1,2,4,3},{2}}", "{{20,111},{111}}", "{{123}}",
                "{{4,2,3},{3},{2,3,4,1},{2,3}}" };

        for (int i = 0; i < s.length; i++) {
            int[] result = solution(s[i]);
            for (int j = 0; j < result.length; j++)
                System.out.print(result[j] + " ");
            System.out.println();
        }
    }

    public static int[] solution(String s) {
        StringTokenizer st = new StringTokenizer(s, "{}");
        List<String> tuples = new ArrayList<>();
        Set<String> elements = new HashSet<>();

        while (st.hasMoreTokens()) {
            String t = st.nextToken();
            if (!t.equals(","))
                tuples.add(t);
        }
        Collections.sort(tuples, new Comparator<String>() {
            public int compare(String s1, String s2) {
                if (s1.length() > s2.length())
                    return 1;
                else if (s1.length() < s2.length())
                    return -1;
                else
                    return 0;
            }
        });

        int[] answer = new int[tuples.size()];
        for (int i = 0; i < tuples.size(); i++) {
            st = new StringTokenizer(tuples.get(i), ",");
            while (st.hasMoreTokens()) {
                String t = st.nextToken();
                if (elements.add(t))
                    answer[i] = Integer.parseInt(t);
            }
        }
        return answer;
    }
}