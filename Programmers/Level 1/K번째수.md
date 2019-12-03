# [프로그래머스] K번째수

<br>

#### 문제 분류

- Level 1

- 정렬

<br>

#### 사용 언어

- C++

<br>

## 문제 설명

배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.

예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면

1. array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.

2. 1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다.

3. 2에서 나온 배열의 3번째 숫자는 5입니다.

배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때, commands의 모든 원소에

대해 앞서 설명한 연산을 적용했을 때 나온 결과를 배열에 담아 return 하도록 solution 함수를 작성해주세요.

<br>

#### 제한사항

- array의 길이는 1 이상 100 이하입니다.

- array의 각 원소는 1 이상 100 이하입니다.

- commands의 길이는 1 이상 50 이하입니다.

- commands의 각 원소는 길이가 3입니다.

<br>

#### 입출력 예

| array                 | commands                            | return    |
| --------------------- | ----------------------------------- | --------- |
| [1, 5, 2, 6, 3, 7, 4] | [ [2, 5, 3], [4, 4, 1], [1, 7, 3] ] | [5, 6, 3] |

##### 입출력 예 설명

[1, 5, 2, 6, 3, 7, 4]를 2번째부터 5번째까지 자른 후 정렬합니다. [2, 3, 5, 6]의 세 번째 숫자는 5입니다.

[1, 5, 2, 6, 3, 7, 4]를 4번째부터 4번째까지 자른 후 정렬합니다. [6]의 첫 번째 숫자는 6입니다.

[1, 5, 2, 6, 3, 7, 4]를 1번째부터 7번째까지 자릅니다. [1, 2, 3, 4, 5, 6, 7]의 세 번째 숫자는 3입니다.

<br>

<br>

## 문제 풀이

벡터 array의 데이터에는 영향을 주지 않기 위해 임시 저장용 벡터 temp를 이용하였습니다.

시간복잡도를 고려하여 데이터 복사 시 for문을 사용하지 않고, 벡터 생성자 중 **반복자 구간 [begin, end)** 을

이용하여 벡터 array에서 필요한 데이터의 구간으로 초기화하였습니다.

데이터의 정렬은 C++ STL에서 제공하는 sort 함수를 사용하였습니다.

<br>

### CODE

#### ▶ My Code

```c++
#include <iostream>
#include <algorithm>
#include <vector>
#include <string>

using namespace std;

vector<int> solution(vector<int> array, vector<vector<int>> commands) {
	vector<int> answer;

	for (int i = 0; i < commands.size(); i++) {
		vector<int> temp(array.begin() + commands[i][0] - 1, array.begin() + commands[i][1]);
		sort(temp.begin(), temp.end());
		answer.push_back(temp[commands[i][2] - 1]);
	}

	return answer;
}

int main() {
	vector<int> array = {1, 5, 2, 6, 3, 7, 4};
	vector<vector<int>> commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
	vector<int> result = solution(array, commands);

	for (int i = 0; i < result.size(); i++)
		cout << result[i] << " ";
	cout << endl;

	return 0;
}
```

#### ▶ Another's Code

```c++
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> array, vector<vector<int>> commands) {
	vector<int> answer;
	vector<int> temp;

	for(int i = 0; i < commands.size(); i++) {
		temp = array;
		sort(temp.begin() + commands[i][0] - 1, temp.begin() + commands[i][1]);
		answer.push_back(temp[commands[i][0] + commands[i][2]-2]);
    }

    return answer;
}
```

<br>

### MEMO

#### # vector의 생성자

| 생성자                 |                                                    |
| ---------------------- | -------------------------------------------------- |
| vector< type > v       | v는 빈 컨테이너입니다.                             |
| vector< type > v(n)    | v는 default 값으로 초기화된 n개의 원소를 갖습니다. |
| vector< type > v(n, x) | v는 x값으로 초기화된 n개의 원소를 갖습니다.        |
| vector< type > v(v2)   | v는 v2 컨테이너의 복사본입니다. (복사 생성자 호출) |
| vector< type > v(b, e) | v는 반복자 구간 [b, e)로 초기화된 원소를 갖습니다. |

#### # Sort 알고리즘

- < algorithm > 헤더 파일에 포함되어 있습니다.

- sort(begin, end) 으로 호출하며 [begin, end) 구간에 있는 데이터를 정렬해주는 함수입니다.

- void sort(T start, T end) 또는 void sort(T start, T end, Compare comp)

- 3번째 파라미터를 입력하지 않으면 default로 오름차순으로 정렬됩니다.

- sort 알고리즘은 quick sort를 기반으로 함수가 구현되어 있어 평균 시간복잡도는 n log n 입니다.

<br>

******

#### 출처

###### [Programmers] [코딩 테스트 연습 : K번째수](https://programmers.co.kr/learn/courses/30/lessons/42748) - 문제

###### [블로그] [개발이 하고 싶어요](https://hyeonstorage.tistory.com/324) - 벡터 정리