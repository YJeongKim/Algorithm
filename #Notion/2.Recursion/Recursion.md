Recursion

순환(재귀)



자기 자신을 호출하는 함수

void func(...)

{

​		func(...);

}



항상 무한루프에 빠지는 것은 아님(종료조건이 존재할 경우)

public static void main(String[] args) {

​		func(4);

}

public static void func(int k) {

​		if(k<=0)

​				return;

​		else {

​				System.out.println("Hello");

​				func(k-1);

​		}

}

Base case : 적어도 하나의 Recursion에(자기 자신을 다시 호출하지 않는) 빠지지 않는 경우가 존재해야 한다. 

​		if(k<=0)

​				return;

Recursive case : Recursion을 반복하다보면 결국 base case에로 수렴해야 한다. (종료되어야 한다)

​				func(k-1);



public static int func(int n) {

​		if (n==0)

​			return 0;

​		else

​			return n + func(n-1);

}

이 함수의 missino은 0~n까지의 합을 구하는 것

n=0이라면 합은 0이다.

n이 0보다 크다면 0에서 n까지의 합은 0에서 n-1까지의 합에 n을 더한 것이다.



정리 : func(int n)은 음이 아닌 정수 n에 대해서 0에서 n까지의 합을 올바로 계산한다.

증명 :

1. n=0인 경우: n=0인 경우 0을 반환한다, 올바르다.
2. 임의의 양의 정수 k에 대해서 n<k인 경우 0에서 n까지의 합을 올바르게 계산한다.
3. n=k인 경우를 고려해보자. func은 먼저 func(k-1) 호출하는데2번의 가정에 의해서 k-1까지의 합이 올바르게 계산되어 반환된다. 따라서 메서드 func은 0에서 k까지의 합을 올바르게 계산하여 반환한다.



Factorial : n!

0! = 1

n! = n*(n-1)!    n>0

public static int factorial(int n)

{

​		if(n==0)

​			return 1;

​		else

​			return n*factorial(n-1);

}

정리 : func(int n)은 음이 아닌 정수 n에 대해서 n!을 올바로 계산한다.

증명 :

1. n=0인 경우: n=0인 경우 1을 반환한다, 올바르다.
2. 임의의 양의 정수 k에 대해서 n<k인 경우 n!을 올바르게 계산한다.
3. n=k인 경우를 고려해보자. factorial은 먼저 factorial(k-1) 호출하는데2번의 가정에 의해서 (k-1)!이 올바르게 계산되어 반환된다. 따라서 메서드 factorial은 k*(k-1)!=k!을 반환한다.



X의 n승

x의 0승 = 1

x의 n승 = x*x의 n-1승  if n>0

public static double power(double x, int n) {

​		if(n==0)

​			return 1;

​		else

​			return x*power(x, n-1);

}



Fibonacci Number 피보나치

f0 = 0

f1 = 1

fn = fn-1 + fn-2  n>1

public int fibonacci(int n) {

​		if(n<2)

​			return n; // n이 0이면 0, 1이면 1 리턴

​		else

​			return fibonacci(n-1) + fibonacci(n-2);

}



최대공약수 : Euclid Method

public static double gcd(int m, int n) {

​		if(m<n){

​			int tmp=m; m=n; n=tmp; //swap m and n

​		}

​		if(m%n==0)

​			return n;

​		else

​			return gcd(n, m%n);

}

m>=n인 두 양의 정수 m과 n에 대해서 m이 n의 배수이면 gcd(m,n)=n이고, 그렇지 않으면 gcd(m,n)=gcd(n,m%n)이다.



Euclid Method : 좀 더 단순한 버전

gcd(p,q)= p    if q=0

​				 gcd(q,p%q)  otherwise

public static int gcd(int p, int q) {

​		if(q==0)

​			return p;

​		else

​			return gcd(q, p%q); // 무한루프에 빠지지 않음

}

---

Recursive Thinking 순환적으로 사고하기

Recursion으로 수학함수 계산뿐 아니라 다른 많은 문제들을 해결할 수 있다.



문자열의 길이 계산

문자열의 길이는 n이다 == 문자열의 길이는 첫번째문자를 제거한 n+1이다

if the string is empty

​	return 0;

else

​	return 1 plus the length of th string that excludes the first character;

public static int length(String str) {

​		if(str.equals("")) return 0;

​		else

​			return 1 + length(str.substring(1)); // 첫글자를 제외한 후 호출

}

ex)

length("abc")

return 1 + length("ce");  // 1 + 2 = 3

​					return 1 + length("e"); // 1 + 1 =2

​										return 1 + length("");  // 1 + 0 = 1



문자열의 프린트

public static void printChars(String str) {

​		if(str.length()==0)	return;

​		else {

​			System.out.print(str.charAt(0));

​			printChars(str.substring(1));

​		}

}

문자열을 뒤집어 프린트

문자열을 뒤집어 프린트하려면

먼저 문자열을 뒤집어 프린트 한 후 마지막으로 첫 글자를 프린트한다.

public static void printCharsReverse(String str) {

​		if(str.length()==0) return;

​		else {

​				printCharsReverse(str.substirng(1));

​				System.out.print(str.charAt(0));

​		}

}

// 실제로 위에 함수와의 차이점은 else 구문의 함수 두개의 순서가 바뀐 것 뿐.



2진수로 변환하여 출력

음이 아닌 정수 n을 이진수로 변환하여 인쇄한다.

public void printInBinary(int n) {

​		if(n<2)

​			System.out.print(n);

​		else {

​			printInBianry(n/2); // n을 2로 나눈 몫을 먼저 2진수로 변환

​			System.out.print(n%2); // n을 2로 나눈 나머지를 인쇄한다.

​		}

}



1, 0

마지막 비트가 0이라는 것은 짝수

1이라는 것은 홀수

나머지 비트는 n/2 몫

n이 10 ->  1010(2)

10/2=5 -> 101(2)

10%2=0 -> 1010(2)

n이 15 -> 1111(2)

15/2=7 -> 111(2)

15%2=1 -> 1111(2)



배열의 합 구하기

data[0]에서 data[n-1]까지의 합을 구하여 반환

public static int sum(int n, int [] data) {

​		if(n<=0)

​			return 0;

​		else

​			return sum(n-1,data) + data[n-1];

}

// for문을 이용하는 대신 recursion을 이용



데이터파일로 부터 n개의 정수 읽어오기

Scanner in이 참조하는 파일로부터 n개의 정수를 입력받아 배열 data의 data[0],...,data[n-1]에 저장한다.

public void readFrom(int n, int [] data, Scanner in) {

​		if(n==0)

​			return;

​		else {

​			readFrom(n-1, data, in);

​			data[n-1] = in.nextInt();

​		}

} // 흔치 않지만 이런것도 recursion으로 구현 가능



Recursion vs Iteration

- 모든 순환함수는 반복문(iteration)으로 변경 가능
- 그 역도 성립함. 모든 반복문은 recursion으로 표현 가능함
- 순환함수는 복잡한 알고리즘을 단순하고 알기쉽게 표현하는 것을 가능하게 함
- 하지만 함수 호출에 따른 오버헤드가 있음 (매개변수 전달, 액티베이션 프레임 생성 등) -> 프로그램 실행 속도 면에서 손해를 볼 수 있음

