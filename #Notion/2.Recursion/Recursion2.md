# 순환 (Recursion) 2

<br>

> ### Recursion의 개념

<br>

#### # 특정 조건에 따라 종료되는 Recursion

어떤 함수에는 기본적으로 종료 조건을 만족하는 경우 외에 특정한 조건에서도 재귀 호출 종료를 해야 하는 경우가 있다.

[Recursion1](https://github.com/YJeongKim/algorithm/blob/master/%23Notion/2.Recursion/Recursion1.md) 글에서 알아본 순환 함수의 가장 기본적인 형태에서 **특정 조건이 추가된 형태**를 확인해보자.

```c
func() {
	// 기본 부분
	if (종료조건) {
		/* 재귀 호출 완료 시 해야 하는 작업을 기술 */
		return;
	}
	// 기본 부분
	else if (결과충족) {
		/* 특정 조건을 만족하였을 때의 작업을 기술 */
		return;
	}
	// 유도 부분
	else {
		/* 재귀 호출 단계마다 해야 하는 작업을 기술
		이 부분에서의 함수 호출은 처리 속도 저하의 요인이 된다. */
		func();
	}
}
```

위와 같은 형태의 간단한 예로 배열 내의 특정 값을 검색하는 순환 함수를 살펴보자.

```c
int L[] = { 1, 5, 9 };

void func(int n, int k, int v) { // n : index, k : data개수, v : 찾는 data
	// 종료조건 : 값을 찾지 못한 경우
	if (n==k) {
		printf("검색실패\n");
		return;
	}
	// 결과충족 : 값을 찾은 경우
	else if (L[n]==v) {
		printf("%d\n", n);
		return;
	}
	else {
		func(n+1, k, v);
	}
}

int main() {
	func(0, 3, 5);
}
```

<br>

#### # 결과를 반환하는 Recursion

어떤 함수에는 재귀호출 결과를 필요로 하여 그 결과를 반환하여야 하는 경우가 있다. 그 형태를 알아보자.

```c
int func() {
	if (종료조건) {
		return 값;
	}
	else if (결과충족) {
		return 값;
	}
	else {
		return func(); // ★재귀호출 결과 반환 필수★
	}
}
```

위와 비슷한 예로 배열 내의 특정 값을 검색하여 결과를 반환하는 순환 함수를 살펴보자.

주어진 집합에 검색할 data인 v가 포함되어 있으면 1을, 없으면 0을 리턴하는 함수이다.

```c
int L[] = { 1, 5, 9, 8, 4, 2, 3 };

int func(int n, int k, int v) { // n : index, k : 검색 범위(data개수), v : 검색할 data
	// 종료조건 : 값을 찾지 못한 경우
	if (n==k) {
		return 0;
	}
	// 결과충족 : 값을 찾은 경우
	else if (L[n]==v) {
		return 1;
	}
	else {
		return func(n+1, k, v); // ★return 필수★
	}
}

int main() {
	int result = func(0, 7, 4);
}
```

<br>

#### # 재귀 호출이 두 번인 경우

```c
func() {
	if (종료조건) {
		return;
	}
	else {
		func();
		func();
	}
}
```

위와 같이 순환 함수의 유도 부분에서 재귀 호출이 두 번 되는 경우가 있다.

<p align="center">
    <img src="https://user-images.githubusercontent.com/33328991/72218682-f9210c00-3580-11ea-8f20-73909aa5a272.png" alt="recursion1" width="65%" />
</p>

이를 이용하여 배열 L의 각 자리에 0과 1이 오는 모든 경우를 만들어보자.

```c
int L[3];

void func(int n, int k) { // n : index, k : 방의 개수
	if (n==k) {
		for (int i = 0; i < k; i++)
			printf("%d ", L[i]);
		printf("\n");
	}
	else {
		L[n] = 0;
		func(n+1, k);
		L[n] = 1;
		func(n+1, k);
	}
}

int main() {
	func(0, 3);
}
// 수행 결과
// 0 0 0
// 0 0 1
// 0 1 0
// 0 1 1
// 1 0 0
// 1 0 1
// 1 1 0
// 1 1 1
```

아래 그림을 통해 함수 func(n, k)이 호출되는 과정을 알 수 있다.

![func](https://user-images.githubusercontent.com/33328991/72219619-823d4080-358b-11ea-93df-d083597d497b.png)

그림에서 수평으로 나타낸 화살표는 for문으로 처리할 수 있다.

```c
	else {
		for(i=0; i<2; i++) {
			L[n] = i;
			func(n+1, k);
		}
	}
```

<br>

#### # 재귀 호출이 여러 번인 경우

유도 부분에서 재귀 호출이 여러 번 되는 경우에는 **항상 k번인 경우**와 **조건에 따라 달라지는 경우**가 있다.

- 항상 k번인 경우

```c
func(int n, int k) {
	int i;
	if (종료조건) {
		return;
	}
	else {
		for(int i=0; i<k; i++) {
			L[n]= i;
			func(n+1, k);
		}
	}
}
```

예) 1, 2, 3을 중복 사용하여 3자리 숫자 만들기 (총 3 * 3 * 3개의 수열)

- 조건에 따라 달라지는 경우

```c
func(int n, int k) {
	int i;
	if (종료조건) {
		return;
	}
	else {
		for(int i=0; i<k; i++) {
			if (i가 유효하면) {
				L[n]= i;
				func(n+1, k);
			}
		}
	}
}
```

예) 1, 2, 3을 중복 사용하지 않고 3자리 숫자 만들기 (총 3 * 2 * 1개의 수열), 그래프에서 인접 노드에 방문하기

<br>

#### # Recursion vs Iteration

- 모든 순환함수는 반복문으로 변경 가능하다.

- 그 역도 성립한다. **모든 반복문은 recursion으로 표현 가능**하다.

- 순환함수는 복잡한 알고리즘을 단순하고 알기쉽게 표현하는 것을 가능하게 한다.

  - 하지만 함수 호출에 따른 오버헤드가 있다. (매개변수 전달, 액티베이션 프레임 생성 등)

    → 프로그램 실행 속도 면에서 손해를 볼 수 있다.

|               | Recursion (순환)                  | Iteration (반복문)               |
| :-----------: | --------------------------------- | -------------------------------- |
|     종료      | 재귀 함수 호출의 종료 부분이 필요 | 반복문이 종료 조건               |
|   수행 시간   | 반복에 비해 느림                  | 빠름                             |
|  메모리 공간  | 반복에 비해 많이 사용             | 적게 사용                        |
| 소스코드 길이 | 짧고 간결                         | 길다                             |
| 소스코드 형태 | 선택 구조 (if ~ else)             | 반복 구조 (for, while, do while) |
| 무한 반복 시  | Stack Overflow 발생               | CPU 반복적 점유                  |

<br>

******
#### 참고

###### [강의] [인프런:영리한 프로그래밍을 위한 알고리즘 강좌](https://www.inflearn.com/course/알고리즘-강좌/lecture/4073)

###### [문서] 개인 소지 자료