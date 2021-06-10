/* 문제: 행렬의 곱셈 / 분류: 연습문제, 수학 */
public class PGM12949 {
    public static void main(String[] args) {
        int[][][] arr1 = { { { 1, 4 }, { 3, 2 }, { 4, 1 } }, { { 2, 3, 2 }, { 4, 2, 4 }, { 3, 1, 4 } } };
        int[][][] arr2 = { { { 3, 3 }, { 3, 3 } }, { { 5, 4, 3 }, { 2, 4, 1 }, { 3, 1, 1 } } };

        for (int i = 0; i < arr1.length; i++) {
            int[][] result = solution(arr1[i], arr2[i]);
            for (int j = 0; j < result.length; j++) {
                for (int k = 0; k < result[j].length; k++)
                    System.out.print(result[j][k] + " ");
                System.out.println();
            }
        }
    }

    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int a = arr1.length, b = arr1[0].length, c = arr2[0].length;
        int[][] answer = new int[a][c];

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < c; j++) {
                for (int k = 0; k < b; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return answer;
    }
}