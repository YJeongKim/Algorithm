# 순환 (Recursion) 1

<br>

> ### Recursion의 개념

<br>

#### # 순환(재귀) 함수

: 자기 자신을 호출하는 함수

```c
void func(...) 
{
	func(...);
}
```

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

1. Base case : 적어도 하나의 Recursion에(자기 자신을 다시 호출하지 않는) 빠지지 않는 경우가 존재해야 한다.

```java
	if(k<=0)
		return;
```

2. Recursive case : Recursion을 반복하다보면 결국 base case로 수렴해야 한다. (종료되어야 한다)

```java
	func(k-1);
```

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

func(int n) 함수의 미션은 0부터 n까지의 합을 구하는 것이다.

- (n=0)&emsp;n이 0이라면 합은 0이다.

- (n>0)&emsp;n이 0보다 크다면 0에서 n까지의 합은 **0에서 n-1까지의 합에 n을 더한 것**이다.



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