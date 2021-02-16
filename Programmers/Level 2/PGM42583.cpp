#include <iostream>
#include <vector>

using namespace std;

/* 문제: 다리를 지나는 트럭 / 분류: 스택, 큐 */
int solution(int bridge_length, int weight, vector<int> truck_weights) {
    int answer = 0;
    vector<int> pass_truck, cross_truck, cross_progress;
    vector<int> stand_by = truck_weights;

    while (pass_truck.size() != truck_weights.size()) {
        int weightSum = 0;
        answer++;
        for (int i = 0; i < cross_truck.size(); i++) cross_progress[i]++;
        if (cross_progress.size() != 0 && cross_progress.front() == bridge_length) {
            pass_truck.push_back(cross_truck.front());
            cross_truck.erase(cross_truck.begin());
            cross_progress.erase(cross_progress.begin());
        }
        for (int i = 0; i < cross_truck.size(); i++) weightSum += cross_truck[i];
        if (stand_by.size() != 0 && (weightSum + stand_by.front()) <= weight) {
            cross_truck.push_back(stand_by.front());
            cross_progress.push_back(0);
            stand_by.erase(stand_by.begin());
        }
    }
    return answer;
}
int main(void) {
    cout << solution(2, 10, {7, 4, 5, 6}) << endl;
    cout << solution(100, 100, {10}) << endl;
    cout << solution(100, 100, {10, 10, 10, 10, 10, 10, 10, 10, 10, 10}) << endl;

    return 0;
}