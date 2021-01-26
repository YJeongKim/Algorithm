#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

/* 문제: 자연수 뒤집어 배열로 만들기 / 분류: 연습문제 */
vector<int> solution(long long n) {
    vector<int> answer;
    string number = to_string(n);

    reverse(number.begin(), number.end());
    for (int i = 0; i < number.length(); i++)
        answer.push_back(number[i] - '0');
    
    return answer;
}
int main(void) {
    for(int n : solution(12345)) cout << n << " ";
    cout << endl;

    return 0;
}