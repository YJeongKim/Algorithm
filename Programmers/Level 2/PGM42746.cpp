#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

/* 문제: 가장 큰 수 / 분류: 정렬 */
bool comp(int n1, int n2) {
    string s1 = to_string(n1);
    string s2 = to_string(n2);
    return s1 + s2 > s2 + s1;
}
string solution(vector<int> numbers) {
    string answer = "";

    sort(numbers.begin(), numbers.end(), comp);
    for (int n : numbers) answer.append(to_string(n));
    if (numbers[0] == 0) answer = "0";

    return answer;
}
int main(void) {
    cout << solution({6, 10, 2}) << endl;
    cout << solution({3, 30, 34, 5, 9}) << endl;

    return 0;
}