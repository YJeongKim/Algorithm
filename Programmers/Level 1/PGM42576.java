import java.util.*;

/* 문제: 완주하지 못한 선수 / 분류: 해시 */
public class PGM42576 {
    public static void main(String[] args) {
        String[][] participant = { { "leo", "kiki", "eden" }, { "marina", "josipa", "nikola", "vinko", "filipa" },
                { "mislav", "stanko", "mislav", "ana" } };
        String[][] completion = { { "eden", "kiki" }, { "josipa", "filipa", "marina", "nikola" },
                { "stanko", "ana", "mislav" } };

        for (int i = 0; i < participant.length; i++) {
            System.out.println(solution(participant[i], completion[i]));
        }
    }

    public static String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        for (int i = 0; i < completion.length; i++) {
            if (!completion[i].equals(participant[i]))
                return participant[i];
        }
        return participant[participant.length - 1];
    }
}