#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

/* 문제: 가장 큰 정사각형 찾기 / 분류: 연습문제 */
int solution(vector<vector<int>> board) {
    int answer = 0;
    int row = board.size() + 1;
    int col = board[0].size() + 1;
    vector<vector<int>> subBoard(row, vector<int>(col, 0));

    for (int i = 1; i < row; i++) {
        for (int j = 1; j < col; j++) {
            subBoard[i][j] = board[i - 1][j - 1];
        }
    }
    for (int i = 1; i < row; i++) {
        for (int j = 1; j < col; j++) {
            if (subBoard[i][j] == 0) continue;
            subBoard[i][j] = min(subBoard[i - 1][j - 1], min(subBoard[i - 1][j], subBoard[i][j - 1])) + 1;
            answer = max(answer, subBoard[i][j]);
        }
    }
    return answer * answer;
}
int main(void) {
    vector<vector<vector<int>>> boards = {{{0, 1, 1, 1}, {1, 1, 1, 1},
                                           {1, 1, 1, 1}, {0, 0, 1, 0}},
                                          {{0, 0, 1, 1}, {1, 1, 1, 1}}};

    for (vector<vector<int>> board : boards) {
        cout << solution(board) << endl;
    }

    return 0;
}