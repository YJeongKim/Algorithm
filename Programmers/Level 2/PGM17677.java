import java.util.*;

/* 문제: 뉴스 클러스터링 / 분류: 2018 KAKAO BLIND RECRUITMENT */
public class PGM17677 {
    private static final int N = 65536;

    public static void main(String[] args) {
        String[] str1 = { "FRANCE", "handshake", "aa1+aa2", "E=M*C^2" };
        String[] str2 = { "french", "shake hands", "AAAA12", "e=m*c^2" };

        for (int i = 0; i < str1.length; i++) {
            System.out.println(solution(str1[i], str2[i]));
        }
    }

    public static int solution(String str1, String str2) {
        List<String> list1 = makeMultiset(str1), list2 = makeMultiset(str2);
        List<String> intersection = findIntersection(list1, list2);
        List<String> union = findUnion(list1, list2);
        float similarity = intersection.size() == 0 && union.size() == 0 ? 1 : (float) intersection.size() / union.size();
        int answer = (int) Math.floor(N * similarity);
        return answer;
    }

    private static List<String> makeMultiset(String str) {
        List<String> multiset = new ArrayList<>();

        str = str.toUpperCase();
        for (int i = 0; i < str.length() - 1; i++) {
            char a = str.charAt(i), b = str.charAt(i + 1);
            if (!('A' <= a && a <= 'Z' && 'A' <= b && b <= 'Z')) continue;
            multiset.add("" + a + b);
        }
        return multiset;
    }

    private static List<String> findIntersection(List<String> set1, List<String> set2) {
        List<String> intersection = new ArrayList<>();

        for (String e : set1) {
            if (!set2.contains(e)) continue;
            int count1 = countElement(set1, e), count2 = countElement(set2, e);
            if (Math.min(count1, count2) > countElement(intersection, e)) intersection.add(e);
        }
        return intersection;
    }

    private static List<String> findUnion(List<String> set1, List<String> set2) {
        List<String> union = set1;

        for (String e : set2) {
            if (!set1.contains(e)) {
                union.add(e);
                continue;
            }
            int count1 = countElement(set1, e), count2 = countElement(set2, e);
            if (Math.max(count1, count2) > countElement(union, e)) union.add(e);
        }
        return union;
    }

    private static int countElement(List<String> set, String s) {
        int count = 0;
        for (String e : set) {
            if (e.equals(s)) count++;
        }
        return count;
    }
}