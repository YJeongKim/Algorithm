#include <iostream>
#include <string>
#include <vector>

using namespace std;

/* 문제: 두 정수 사이의 합 / 분류: 연습문제 */
long long solution(int a, int b) {
    long long answer = 0;
 
    if (a > b)
        swap(a, b);
        
    for (int i = a; i <= b; i++)
        answer += i;

    return answer;
}
int main(void) {
    cout << solution(3, 5) <<endl;    
    cout << solution(3, 3) <<endl;    
    cout << solution(5, 3) <<endl;    

    return 0;
}