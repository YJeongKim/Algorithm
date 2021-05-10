import java.util.*;

/* ����: �������� ���� ���� / �з�: �ؽ� */
/* �ؽø� �̿��ؼ� �ٽ� Ǯ����� -> ����ð� ª���� */
public class PGM42576Re1 {
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
        Map<String, Integer> finisher = new HashMap<>();

        for (int i = 0; i < completion.length; i++) {
            if (!finisher.containsKey(completion[i])) finisher.put(completion[i], 1);
            else finisher.replace(completion[i], finisher.get(completion[i]) + 1);
        }
        for (int i = 0; i < participant.length; i++) {
            if (finisher.containsKey(participant[i])) {
                int count = finisher.get(participant[i]);
                if (count > 1) finisher.replace(participant[i], count - 1);
                else finisher.remove(participant[i]);
            } else return participant[i];
        }
        return "none";
    }
}