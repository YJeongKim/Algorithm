#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> arr) {
    vector<int> answer;
    int n = 0;

    answer.push_back(arr[0]);

    for (int i = 1; i < arr.size(); i++) {
        if (answer[n] != arr[i]) {
            answer.push_back(arr[i]);
            n++;
        }
    }
    
    return answer;
}

int main(void) {
    vector<int> arr = {1, 1, 3, 3, 0, 1, 1};

    for (int n : solution(arr))
        cout << n << " ";
    cout << endl;

    return 0;
}