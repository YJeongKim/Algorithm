#include <iostream>
#include <string>
#include <vector>

using namespace std;

/* 문제: 비밀지도 / 분류: 2018 KAKAO BLIND RECRUITMENT [1차], 비트마스크 */
vector<int> makeBinary(vector<int> binaryNum, int n, int num) {
    if (num == 0) {
        return binaryNum;
    } else {
        binaryNum[n - 1] = (num % 2);
        return makeBinary(binaryNum, --n, num / 2);
    }
}
vector<string> solution(int n, vector<int> arr1, vector<int> arr2) {
    vector<string> answer(n, "");
    vector<int> arrSum(n);

    for (int i = 0; i < n; i++) {
        arrSum[i] = arr1[i] | arr2[i];
    }
    for (int i = 0; i < n; i++) {
        vector<int> binaryNum(n, 0);
        binaryNum = makeBinary(binaryNum, n, arrSum[i]);
        for (int b : binaryNum) {
            answer[i] += (b ? '#' : ' ');
        }
    }
    return answer;
}
int main(void) {
    for (string s : solution(5, {9, 20, 28, 18, 11}, {30, 1, 21, 17, 28}))
        cout << s << " ";
    cout << endl;
    for (string s : solution(6, {46, 33, 33, 22, 31, 50}, {27, 56, 19, 14, 14, 10}))
        cout << s << " ";
    cout << endl;

    return 0;
}