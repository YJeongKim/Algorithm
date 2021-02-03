#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

/* 문제: 문자열 내 마음대로 정렬하기 / 분류: 연습문제 */
int idx;

bool compare(string s1, string s2) {
    if (s1[idx] == s2[idx])
        return s1 < s2;
    else
        return s1[idx] < s2[idx];
}
vector<string> solution(vector<string> strings, int n) {
    vector<string> answer = strings;
    idx = n;
    sort(answer.begin(), answer.end(), compare);
    return answer;
}
int main(void) {
    vector<string> strings1 = {"sun", "bed", "car"};
    vector<string> strings2 = {"abce", "abcd", "cdx"};

    for (string s : solution(strings1, 1))
        cout << s << " ";
    cout << endl;
    for (string s : solution(strings2, 2))
        cout << s << " ";
    cout << endl;
 
    return 0;
}