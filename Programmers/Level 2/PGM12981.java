import java.util.*;

/* 문제: 영어 끝말잇기 / 분류: Summer/Winter Coding(~2018) */
public class PGM12981 {
    public static void main(String[] args) {
        int[] n = { 3, 5, 2 };
        String[][] words = { { "tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank" },
                { "hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish",
                        "hang", "gather", "refer", "reference", "estimate", "executive" },
                { "hello", "one", "even", "never", "now", "world", "draw" } };

        for (int i = 0; i < n.length; i++) {
            int[] result = solution(n[i], words[i]);
            for (int j = 0; j < result.length; j++)
                System.out.print(result[j] + " ");
            System.out.println();
        }
    }

    public static int[] solution(int n, String[] words) {
        int order = 1, turn = 1;
        char lastCh = ' ';
        List<String> usedWords = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            if (lastCh != ' ' && words[i].charAt(0) != lastCh) break;
            if (usedWords.contains(words[i])) break;
            usedWords.add(words[i]);
            lastCh = words[i].charAt(words[i].length() - 1);
            order++;
            if (order > n) {
                order = 1;
                turn++;
            }
        }
        if (words.length == usedWords.size()) {
            order = 0;
            turn = 0;
        }
        int[] answer = { order, turn };
        return answer;
    }
}