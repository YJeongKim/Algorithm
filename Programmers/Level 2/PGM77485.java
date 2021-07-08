/* 문제: 행렬 테두리 회전하기 / 분류: 2021 Dev-Matching: 웹 백엔드 개발자(상반기) */
public class PGM77485 {
    private static int[][] matrix;

    public static void main(String[] args) {
        int[] rows = { 6, 3, 100 }, columns = { 6, 3, 97 };
        int[][][] queries = { { { 2, 2, 5, 4 }, { 3, 3, 6, 6 }, { 5, 1, 6, 3 } },
                { { 1, 1, 2, 2 }, { 1, 2, 2, 3 }, { 2, 1, 3, 2 }, { 2, 2, 3, 3 } }, { { 1, 1, 100, 97 } } };

        for (int i = 0; i < rows.length; i++) {
            int[] result = solution(rows[i], columns[i], queries[i]);
            for (int j = 0; j < result.length; j++)
                System.out.print(result[j] + " ");
            System.out.println();
        }
    }

    public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        matrix = new int[rows + 1][columns + 1];

        for (int x = 1; x <= rows; x++) {
            for (int y = 1; y <= columns; y++) {
                matrix[x][y] = columns * (x - 1) + y;
            }
        }
        for (int i = 0; i < queries.length; i++) {
            answer[i] = rotateMatrix(queries[i][0], queries[i][1], queries[i][2], queries[i][3]);
        }
        return answer;
    }

    public static int rotateMatrix(int x1, int y1, int x2, int y2) {
        int min = matrix[x1][y1], next = matrix[x1][y1], temp = 0;

        for (int y = y1; y < y2; y++) {
            min = Math.min(min, matrix[x1][y + 1]);
            temp = matrix[x1][y + 1];
            matrix[x1][y + 1] = next;
            next = temp;
        }
        for (int x = x1; x < x2; x++) {
            min = Math.min(min, matrix[x + 1][y2]);
            temp = matrix[x + 1][y2];
            matrix[x + 1][y2] = next;
            next = temp;
        }
        for (int y = y2; y > y1; y--) {
            min = Math.min(min, matrix[x2][y - 1]);
            temp = matrix[x2][y - 1];
            matrix[x2][y - 1] = next;
            next = temp;
        }
        for (int x = x2; x > x1; x--) {
            min = Math.min(min, matrix[x - 1][y1]);
            temp = matrix[x - 1][y1];
            matrix[x - 1][y1] = next;
            next = temp;
        }
        return min;
    }
}