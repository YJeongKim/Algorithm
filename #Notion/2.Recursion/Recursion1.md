# 순환 (Recursion) 1

<br>

> ### Recursion의 개념

<br>

#### # 재귀적 호출(Recursive call) 함수란?

- 재귀란? (Recursion, 순환)

  : 수학이나 컴퓨터 과학 등에서 자신을 정의할 때 **자기 자신을 재참조하는 방법**을 말한다.

- 재귀호출 함수란? (Recursive Function, 순환 함수)

  : 함수 내부에서 직접 혹은 간접적으로 **자기 자신을 호출하는 함수**를 말한다.

```c
void func(...) 
{
	func(...);
}
```

<br>

#### # Recursion의 특징

- 재귀적 정의를 이용해서 재귀(순환) 함수를 구현한다.

  - 재귀 호출 - 유도 부분 (Inductive part)

  - 재귀 종료 - 기본 부분 (Base part)

- 재귀적 프로그래밍은 구조적으로 볼 때 반복 구조에 비해 간결하다.

  → 코드의 가독성이 좋다.

- 재귀 함수 호출은 반복적인 함수 호출을 하기 때문에 스택 메모리를 사용한다. 

  자기 자신을 호출하지만 호출된 함수의 스택 프레임 내의 메모리 영역을 사용하므로 다른 함수를 호출하는 것과 같다.

  → 메모리 및 속도에서 성능(RAM) 저하가 발생한다.

- 특정 시점에서 재귀적 호출을 종료하지 못하면 무한 재귀 호출에 빠질 수 있다.

  (기본 부분인 재귀 종료가 제대로 구현되지 않은 경우)

<br>

다음 코드는 Recursion의 간단한 예시이다. 수행 결과를 통해 무한루프에 빠진 것을 확인할 수 있다.

```java
public class Recursion01 {
	public static void main(String [] args) {
		func();
	}

	public static void func() {
		System.out.println("Hello!");
		func();
	}
}
// 수행 결과
// Hello!
// Hello!
// Hello!
// Hello!
// Hello!
// ...
```

그렇다면 Recursion은 항상 무한루프에 빠질까? 다음 코드를 보면 위의 코드와 다른 수행 결과를 확인할 수 있다.

```java
public class Recursion02 {
	public static void main(String [] args) {
		int n = 4;
		func(n);
	}

	public static void func(int k) {
		if (k<=0) // 종료조건
			return;
		else {
			System.out.println("Hello!");
			func(k-1);
		}
	}
}
// 수행 결과
// Hello!
// Hello!
// Hello!
// Hello!
```

이렇게 순환 함수에 종료조건이 존재할 경우 무한루프에 빠지지 않는다.

순환 함수가 **무한루프에 빠지지 않게 하기 위한 기본 조건**은 다음과 같다.

1. **Base case** : 적어도 하나의 Recursion에 빠지지 않는 (자기 자신을 다시 호출하지 않는) 경우가 존재해야 한다.

```java
	if(k<=0)
		return;
```

2. **Recursive case** : Recursion을 반복하다보면 결국 base case로 수렴해야 한다. (종료되어야 한다)

```java
	func(k-1);
```

<br>

#### # 순환(재귀) 함수의 구조

위 내용을 바탕으로 순환 함수를 구현하려면 **기본 부분 (Base part)** 과 **유도 부분 (Inductive part)** 이 필요하다.

- 기본 부분 : 재귀 호출 종결 조건(Base case)을 위한 부분으로 재귀 호출 완료 시 해야 하는 작업을 기술한다.

- 유도 부분 : 재귀 호출 부분으로 재귀 호출 단계마다 해야 하는 작업을 기술한다.

Recursion의 가장 기본적인 형태는 다음과 같다.

```c
func() {
	// 기본 부분
	if (종료조건) {
		/* 재귀 호출 완료 시 해야 하는 작업을 기술 */
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

간단한 예로 N개의 배열 원소를 출력하는 순환 함수를 살펴보자. 여기서 n은 index를, k는 data 개수를 나타낸다.

```c
int L[] = { 10, 20, 30 };

void func(n, k) {
	// 기본 부분
	if (n==k) {
		printf("\n"); // 완료 시 마무리 코드
		return;
	}
	// 유도 부분
	else {
		printf("%d ", L[n]); // 재귀 시 처리 코드
		func(n+1, k);
	}
}

int main() {
	func(0, 3);
}
// 수행 결과
// 10 20 30 \n
```

또, 위와 같은 형태로 재귀 호출을 이용하여 배열을 복사하는 순환 함수를 살펴보자.

```c
int A[3] = { 3, 6, 9 };
int B[3];

void func(n, k) { // n : index, k : data개수
	if (n==k) {
		printArray();
		return;
	}
	else {
		B[n] = A[n];
		func(n+1, k);
	}
}

int main() {
	func(0, 3);
}
```

두 함수 모두 반복문을 이용하지 않고 재귀 호출을 이용하여 구현하였다.

함수의 인수 n을 배열 인덱스로 활용하였고, k를 배열의 크기로 하여 재귀 호출의 횟수를 결정짓는 데 활용되었다.

배열의 크기 k와 인덱스 n이 같아지면 (n==k) 마무리 작업 후 재귀 호출을 중단한다.

<br>

******

<br>

>### Recursion의 기본 예제

<br>

#### # 1~n까지의 합

```java
public class Recursion03 {
	public static void main(String[] args) {
		int result = func(4); // result = 10 = 4 + 3 + 2 + 1 + 0
	}

	public static int func(int n) {
		if (n==0)
			return 0;
		else
			return n + func(n-1);
	}
}
```

func(int n) 의 미션은 0부터 n까지의 합을 구하는 것이다.

- (n=0)&emsp;n이 0이라면 합은 0이다.

- (n>0)&emsp;n이 0보다 크다면 0에서 n까지의 합은 **0에서 n-1까지의 합에 n을 더한 것**이다.

<br>

**▶ 순환함수와 수학적귀납법**

> 정리 : func(int n)은 음이 아닌 정수 n에 대해서 0에서 n까지의 합을 올바로 계산한다.
>
> 증명 :
>
> 1. n=0인 경우 : n이 0인 경우 0을 반환한다. 올바르다.
>
> 2. n<k인 경우 : 임의의 양의 정수 k에 대해서 n<k인 경우 0에서 n까지의 합을 올바르게 계산한다.
>
> 3. n=k인 경우 : 
>
>    func은 먼저 func(k-1) 호출하는데 2번의 가정에 의해서 k-1까지의 합이 올바르게 계산되어 반환된다.
>
>    따라서 메서드 func은 0에서 k까지의 합을 올바르게 계산하여 반환한다.

<br>

#### # Factorial : n!

```java
public class Recursion04 {
	public static void main(String[] args) {
		int result = factorial(4); // result = 24 = 4 * 3 * 2 * 1 * 1
	}

	public static int factorial(int n) {
		if(n==0)
			return 1;
		else
			return n * factorial(n-1);
	}
}
```

factorial의 정의는 다음과 같다.

- (n=0)&emsp;0! = 1

- (n>0)&emsp;n! = n * (n-1)!

<br>

**▶ 순환함수와 수학적귀납법**

> 정리 : factorial(int n)은 음이 아닌 정수 n에 대해서 n!을 올바로 계산한다.
>
> 증명 :
>
> 1. n=0인 경우 : n이 0인 경우 1을 반환한다. 올바르다.
>
> 2. n<k인 경우 : 임의의 양의 정수 k에 대해서 n<k인 경우 n!을 올바르게 계산한다.
>
> 3. n=k인 경우 : 
>
>    factorial은 먼저 factorial(k-1) 호출하는데 2번의 가정에 의해서 (k-1)!이 올바르게 계산되어 반환된다.
>
>    따라서 메서드 factorial은 k*(k-1)!=k!을 반환한다.

<br>

#### # X to the Power of N : x<sup>n</sup>

```java
public class Recursion05 {
	public static void main(String[] args) {
		double result = power(2, 4); // result = 16 = 2 * 2 * 2 * 2 * 1
	}

	public static double power(double x, int n) {
		if(n==0)
			return 1;
		else
			return x * power(x, n-1);
	}
}
```

x<sup>n</sup>(x의 n승)의 정의는 다음과 같다.

- (n=0)&emsp;x<sup>0</sup> = 1

- (n>0)&emsp;x<sup>n</sup> = x * x<sup>n-1</sup>

<br>

#### # Fibonacci Number : 피보나치 수

```java
public class Recursion06 {
	public static void main(String[] args) {
		int result = fibonacci(4); // result = 3 = f(3) + f(2) 
					   // = f(2) + f(1) + f(1) + f(0)
        				   // = f(1) + f(0) + 1 + 1 + 0 = 1 + 0 + 1 + 1 + 0
	}
    
	public static int fibonacci(int n) {
		if(n<2)
			return n; // n=0이면 0, n=1이면 1 반환
		else
			return fibonacci(n-1) + fibonacci(n-2);
	}
}
```

fibonacci의 정의는 다음과 같다.

- (n=0)&emsp;f<sub>0</sub> = 0

- (n=1)&emsp;f<sub>1</sub> = 1

- (n>1)&emsp;f<sub>n</sub> = f<sub>n-1</sub> + f<sub>n-2</sub>

첫째 및 둘째 항이 1이며 그 뒤의 모든 항은 바로 앞 두 항의 합이다.

|       n       |  0   |  1   |  2   |  3   |  4   |  5   |  6   |  7   |  8   |  9   |  10  |  11  |
| :-----------: | :--: | :--: | :--: | :--: | :--: | :--: | :--: | :--: | :--: | :--: | :--: | :--: |
| F<sub>n</sub> |  0   |  1   |  1   |  2   |  3   |  5   |  8   |  13  |  21  |  34  |  55  |  89  |

<br>

#### # 최대공약수 : Euclid Method

```java
public class Recursion07 {
	public static void main(String[] args) {
		int result = gcd(10, 4); // result = 2 = gcd(4, 2)
	}
    
	public static int gcd(int m, int n) {
		if(m<n) {
			int tmp = m; m=n; n=tmp; // swap m and n
		}
		if (m%n==0)
			return n;
		else
			return gcd(n, m%n);
	}
}
```

m >= n인 두 양의 정수 m과 n에 대해서 최대공약수를 다음과 같이 구한다.

- (m이 n의 배수이면)&emsp;&nbsp;gcd(m, n) = n

- (그렇지 않으면)&emsp;&emsp;&emsp;gcd(m, n) = gcd(n, m%n)

다음 코드는 좀 더 단순하게 최대공약수를 구하는 방법이다.

```java
public class Recursion08 {
	public static void main(String[] args) {
		int result = gcd(10, 4); // result = 2 = gcd(4, 2) = gcd(2, 0)
	}
    
	public static int gcd(int p, int q) {
		if (q==0)
			return p;
		else
			return gcd(q, p%q); // 무한루프에 빠지지 않는다.
	}
}
```

p >= q인 두 양의 정수 p과 q에 대해서 최대공약수를 다음과 같이 구한다.

- (q=0)&emsp;gcd(p, q) = p

- (q>0)&emsp;gcd(p, q) = gcd(q, p%q)

<br>

******
#### 참고

###### [강의] [인프런:영리한 프로그래밍을 위한 알고리즘 강좌](https://www.inflearn.com/course/알고리즘-강좌/lecture/4072)

###### [문서] 개인 소지 자료

