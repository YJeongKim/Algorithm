import java.util.*;

/* 문제: 스킬트리 / 분류: Summer/Winter Coding(~2018) */
public class PGM49993 {
    public static void main(String[] args) {
        String skill = "CBD";
        String[] skillTree = { "BACDE", "CBADF", "AECB", "BDA" };

        System.out.println(solution(skill, skillTree));
    }

    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        String regex = "[^" + skill + "]"; // [^문자]: 문자를 제외한 나머지

        for (String skillTree : skill_trees) {
            if (isValidSkill(skill, skillTree.replaceAll(regex, ""))) answer++;
        }
        return answer;
    }

    public static boolean isValidSkill(String skill, String skillTree) {
        for (int i = 0; i < skillTree.length(); i++) {
            if (skill.charAt(i) != skillTree.charAt(i)) return false;
        }
        return true;
    }
}