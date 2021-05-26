import java.util.*;

/* 문제: 전화번호 목록 / 분류: 해시 */
public class PGM42577 {
    public static void main(String[] args) {
        String[][] phoneBook = { { "119", "97674223", "1195524421" }, { "123", "456", "789" },
                { "12", "123", "1235", "567", "88" } };

        for (int i = 0; i < phoneBook.length; i++) {
            System.out.println(solution(phoneBook[i]));
        }
    }

    public static boolean solution(String[] phone_book) {
        Map<String, String> map = new HashMap<>();

        Arrays.sort(phone_book, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() < s2.length()) {
                    return -1;
                } else if (s1.length() > s2.length()) {
                    return 1;
                }
                return 0;
            }
        });
        for (String phone : phone_book) {
            map.put(phone, "");
        }
        for (String phone : phone_book) {
            for (int i = 1; i < phone.length(); i++) {
                if (map.containsKey(phone.substring(0, i))) return false;
            }
        }
        return true;
    }    
}