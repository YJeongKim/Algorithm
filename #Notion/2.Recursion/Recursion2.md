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

<br>

> ### Recursion의 기본 예제

<br>

#### # Recursive Thinking : 순환적으로 사고하기

: Recursion은 수학함수 계산에만 유용한가?

 → 수학함수뿐 아니라 다른 많은 문제들을 Recursion으로 해결할 수 있다.

<br>

#### # 문자열의 길이 계산

일반적으로 문자열의 길이를 계산한다면 반복문을 이용해서 앞에서부터 순서대로 문자를 하나씩 세면 된다.

그러나 순환적으로 생각해본다면 다음 그림처럼 첫 번째 문자를 제외한 나머지 문자열의 길이에 1을 더하면 된다.

<p align="center">
    <img src="https://user-images.githubusercontent.com/33328991/72266776-65c00780-3662-11ea-85f9-c807225a0615.png" alt="string" width="60%" />
</p>

```c
if the string is empty
	return 0;
else
	return 1 plus the length of the string that
		excludes the first character;
```

이를 코드로 표현하면 다음과 같다.

```java
public class Recursion09 {
	public static void main(String[] args) {
		int result = length("abc"); // result = 3 = 1 + length("bc") 
					// = 1 + 1 + length("c") = 1 + 1 + 1 + length("")
	}

	public static int length(String str) {
		if(str.equals(""))
			return 0;
		else
			return 1 + length(str.substring(1)); // 첫 글자를 제외한 후 재귀호출
	}
}
```

<br>

#### # 문자열의 프린트

```java
public class Recursion10 {
	public static void main(String[] args) {
		printChars("abc"); // "abc" = "a" + printChars("bc")
				// = "ab" + printChars("c") 
				// = "abc" + printChars("")
	}

	public static void printChars(String str) {
		if(str.length()==0)
			return;
		else {
			System.out.print(str.charAt(0)); // 첫 글자를 먼저 출력
			printChars(str.substring(1)); // 첫 글자를 제외한 후 재귀호출
		}
	}
}
```

입력으로 들어온 문자열을 화면에 출력하는 메소드이다.

위와 비슷한 방식으로 첫 글자를 먼저 화면에 출력한 후, 출력한 첫 글자를 제외하고 재귀호출을 한다.

반대로 문자열을 뒤집어 프린트하려면 다음과 같이 할 수 있다.

먼저 첫 글자를 제외한 문자열을 뒤집어 프린트한 후 마지막으로 첫 글자를 프린트하면 된다. 

```java
public class Recursion11 {
	public static void main(String[] args) {
		printCharsReverse("abc"); // "cba" = printCharsReverse("bc") + "a"
					// = printCharsReverse("c") + "ba" 
					// = printCharsReverse("") + "cba"
	}

	public static void printCharsReverse(String str) {
		if(str.length()==0)
			return;
		else {
			printCharsReverse(str.substring(1)); // 첫 글자를 제외한 후 재귀호출
			System.out.print(str.charAt(0)); // 첫 글자를 출력
		}
	}
}
```

그대로 프린트하는 메소드와 뒤집어 프린트하는 메소드의 차이점은 else 구문의 메소드 호출 순서가 바뀐 것 뿐이다.

<br>

#### # 2진수로 변환

```java
public class Recursion12 {
	public static void main(String[] args) {
		printInBinary(10); // = printCharsReverse(10/2) + 10%2
				// = printCharsReverse(5/2) + 5%2 + 10%2 
				// = printCharsReverse(2/2) + 2%2 + 5%2 + 10%2
				// = 1 0 1 0
	}

	public static void printInBinary(int n) {
		if(n<2)
			System.out.print(n);
		else {
			printInBinary(n/2); // n을 2로 나눈 몫을 먼저 2진수로 변환
			System.out.print(n%2); // n을 2로 나눈 나머지를 출력
		}
	}
}
```

printInBinary(int n) 은 음이 아닌 정수 n을 이진수로 변환하여 출력한다.

2진수에서 마지막 비트가 0이라는 것은 짝수, 1이라는 것은 홀수를 의미한다.

즉, 양의 정수 n의 2진수 **마지막 비트**는 그 정수 **n을 2로 나누었을 때의 나머지**인 n%2의 결과이다.

마지막 비트를 제외한 **나머지 비트**는 **n을 2로 나누었을 때의 몫**을 2진수로 변환한 것이다.

- n = 10&ensp;↔ &ensp;1010<sub>(2)</sub>

  - 10 / 2 = 5&ensp;↔ 101<sub>(2)</sub>

  - 10%2 = 0&ensp;← 마지막 bit

- n = 15&ensp;↔ &ensp;1111<sub>(2)</sub>

  - 15 / 2 = 7&ensp;↔ 111<sub>(2)</sub>
  
  - 15%2 = 1&ensp;← 마지막 bit

<br>

#### # 배열의 합

```java
public class Recursion13 {
	public static void main(String[] args) {
        int[] data = { 2, 4, 6 };
		sum(3, data); // = sum(2, data) + data[2]
				// = sum(1, data) + data[1] + data[2]
				// = sum(0, data) + data[0] + data[1] + data[2] 
				// = 0 + 2 + 4 + 6 = 12
	}

	public static int sum(int n, int[] data) {
		if(n<=0)
			return 0;
		else
			return sum(n-1, data) + data[n-1];
	}
}
```

data는 정수 배열이고, n은 배열에 저장된 data의 개수를 의미한다. data[0]에서 data[n-1]까지의 합을 구하여 반환한다.

일반적으로는 sum을 0으로 선언하고 반복문을 이용하여 배열에 저장된 모든 값을 sum에 차례로 더하여 구한다.

그러나 여기에서는 반복문을 이용하는 대신 recursion을 이용하여 처음 n-1개 data의 합을 구하고 마지막 data를 더한다.

<br>

#### # 데이터파일로부터 n개의 정수 읽어오기

```java
class Sub {
	public void readFrom(int n, int[] data, Scanner in) {
		if(n==0)
			return;
		else {
			readFrom(n-1, data, in);
			data[n-1] = in.nextInt();
		}
	}
}

public class Recursion14 {
	public static void main(String[] args) {
        int[] data = new int[5];
        Sub sub = new Sub();
		File file = new File("D:\\data.txt");
		Scanner in;
		try {
			in = new Scanner(file);
			sub.readFrom(5, data, in);
			for(int num : data)
				System.out.println(num);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
```

Scanner in이 참조하는 파일로부터 n개의 정수를 입력받아 배열 data의 data[0], ..., data[n-1]에 저장한다.

흔치 않지만 이런 데이터를 읽어오는 것도 recursion으로 구현 가능하다.

<br>

******
#### 참고

###### [강의] [인프런:영리한 프로그래밍을 위한 알고리즘 강좌](https://www.inflearn.com/course/알고리즘-강좌/lecture/4073)

###### [문서] 개인 소지 자료

###### * 이미지는 자료를 참고하여 직접 그림

