import java.util.*;

/* 문제: 여행경로 / 분류: DFS, BFS */
public class PGM43164 {
    private static List<String> paths;
    private static boolean[] checked;
    private static StringBuilder path;

    public static void main(String[] args) {
        String[][][] tickets = { { { "ICN", "JFK" }, { "HND", "IAD" }, { "JFK", "HND" } },
                { { "ICN", "SFO" }, { "ICN", "ATL" }, { "SFO", "ATL" }, { "ATL", "ICN" }, { "ATL", "SFO" } } };

        for (int i = 0; i < tickets.length; i++) {
            String[] result = solution(tickets[i]);
            for (int j = 0; j < result.length; j++)
                System.out.print(result[j] + " ");
            System.out.println();
        }
    }

    public static String[] solution(String[][] tickets) {
        paths = new ArrayList<>();

        for (int i = 0; i < tickets.length; i++) {
            checked = new boolean[tickets.length];
            path = new StringBuilder();
            if (tickets[i][0].equals("ICN")) {
                checked[i] = true;
                path.append("ICN,");
                dfs(tickets, 1, tickets[i][1]);
            }
        }
        Collections.sort(paths);
        return paths.get(0).split(",");
    }

    private static void dfs(String[][] tickets, int count, String destination) {
        path.append(destination + ",");
        if (tickets.length == count) {
            paths.add(path.toString());
            return;
        }
        for (int i = 0; i < tickets.length; i++) {
            if (!checked[i] && tickets[i][0].equals(destination)) {
                checked[i] = true;
                dfs(tickets, count + 1, tickets[i][1]);
                checked[i] = false;
                path.delete(path.length() - 4, path.length());
            }
        }
    }
}