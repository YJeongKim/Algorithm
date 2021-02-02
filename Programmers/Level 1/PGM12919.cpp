#include <iostream>
#include <string>
#include <vector>

using namespace std;

/* 문제: 서울에서 김서방 찾기 / 분류: 연습문제 */
string solution(vector<string> seoul) {
    string answer = "";

    for (int i = 0; i < seoul.size(); i++) {
        if (!seoul[i].compare("Kim")) {
            answer = "김서방은 " + to_string(i) + "에 있다";
            break;
        }
    }

    return answer;
}
int main(void) {
    vector<string> seoul1 = {"Jane", "Kim"};
    vector<string> seoul2 = {"Jane", "Park", "Kim", "Lee"};

    cout << solution(seoul1) << endl;
    cout << solution(seoul2) << endl;

    return 0;
}