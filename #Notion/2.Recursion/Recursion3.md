# 순환 (Recursion) 3

<br>

> ### Designing Recursion

<br>

#### # 순환 알고리즘의 설계

▶ Recursion 함수의 조건

- 적어도 하나의 base case, 즉 순환되지 않고 종료되는 case가 있어야 한다.
- 모든 case는 결국 base case로 수렴해야 한다.

```c
/* 가장 기본적인 구조 */
if( ) {
	base_case;
}
else {
	recursion;
}
```

▶ 암시적(implicit) 매개변수를 **명시적(explicit) 매개변수**로 바꿔라.

<br>

******

<br>

> ### Implicit vs Explicit 매개변수와 예제

<br>

#### # 순차 탐색 (Sequential Search)

: 입력으로 어떤 데이터가 저장된 배열이 주어지고, 이 데이터 중 특정한 값이 있는지 검색한다.

  만약 데이터들이 정렬되어있다면 "이진 검색"이 가능하다.

  그렇지 않다면 하나씩 순서대로 데이터를 확인하여 검색하는 방법뿐이다.

  이처럼 데이터를 하나씩 순차적으로 검색하여 판단하는 알고리즘을 **순차 탐색 (순차 검색)** 이라 한다.

<br>

- 암시적 매개변수 version

```java
int search(int[] data, int n, int target) {
	for(int i=0; i<n; i++)
		if(data[i]==target)
			return i;
	return -1;
}
```

이 함수의 미션은 data[0]에서 data[n-1] 사이에서 target을 검색하는 것이다.

하지만 검색 구간의 시작 인덱스 0은 보통 생략한다.

데이터가 저장되어있는 구간의 시작 지점이 명시적으로 표현되어있지 않다. 즉 암시적 매개변수이다.

배열의 데이터가 n개니까 인덱스 0부터 시작하겠지 하고 암묵적으로 공유한 것이다.

<br>

- 명시적 매개변수 version

```java
int search(int[] data, int begin, int end, int target) {
	if (begin>end) // 검색할 데이터가 0개인 경우
		return -1;
	else if(target==data[begin])
		return begin;
	else
		return search(data, begin+1, end, target);
}
```

이 함수의 미션은 data[begin]에서 data[end] 사이에서 target을 검색하는 것이다.

데이터가 저장되어있는 구간의 시작 지점과 끝 지점이 명시적으로 표현되어 있다.

즉, 검색구간의 시작점을 명시적(explicit)으로 지정하여 매개변수의 명시화가 되어있다.

이 함수를 search(data, 0, n-1, target)으로 호출한다면 앞의 암시적인 함수와 완전히 동일한 일을 한다.

<br>

암시적 매개변수 version은 끝 지점은 명시적으로 제시되어 있지만, 시작 지점은 암시되어 있다.

명시적 매개변수 version은 시작 지점, 끝 지점 모두 명시적으로 제시되어 있다.

<br>

- 다른 version 1 - 마지막 값부터 비교하는 방법

```java
int search(int[] data, int begin, int end, int target) {
	if (begin>end) // 검색할 데이터가 0개인 경우
		return -1;
	else if(target==data[end])
		return end;
	else
		return search(data, begin, end-1, target);
}
```

위의 명시적 매개변수 version에서는 배열의 시작 값부터 검색하여 비교를 하고있다.

그 역으로 배열의 마지막 값부터 검색하여 비교하는 방법도 가능하다.

<br>

- 다른 version 2 - 반으로 나누어 비교하는 방법 (binary search와는 다름)

```java
int search(int[] data, int begin, int end, int target) {
	if (begin>end)
		return -1;
	else {
		int middle = (begin+end)/2;
		if(data[middle]==target) // 가운데 값부터 비교
			return middle;
		int index = search(data, begin, middle-1, target); // 시작 지점 ~ 가운데 비교
		if(index != -1) // target을 찾은 경우 리턴
			return index;
		else // 앞에서 못찾은 경우, 가운데 ~ 끝 지점 비교
			return search(data, middle+1, end, target);
	}
}
```

<br>

#### # 최대값 찾기

: 입력으로 어떤 데이터가 저장된 배열이 주어지고, 이 데이터를 비교하여 최대값을 찾는다.

<br>

- 암시적 매개변수 version

```java
int findMax(int[] data, int n) {
	int max = -1;
	for(int i=0; i<n; i++)
		if(data[i]>max)
			max = data[i];
	return max;
}
```

이 함수의 미션은 data[0]에서 data[n-1] 사이에서 최대값을 찾아 반환하는 것이다.

역시 끝 지점은 명시적으로 제시되어 있지만, 시작 지점은 암시되어 있다.

<br>

- 명시적 매개변수 version

```java
int findMax(int[] data, int begin, int end) {
	if(begin==end) // 데이터가 한 개일 경우
		return data[begin];
	else
		return Math.max(data[begin], findMax(data, begin+1, end));
}
```

이 함수의 미션은 data[begin]에서 data[end] 사이에서 최대값을 찾아 반환하는 것이다.

(단, 데이터의 개수는 한 개 이상이며, begin<=end라고 가정한다)

시작 지점과 끝 지점이 명시적으로 begin, end로 지정되어 있다.

<br>

- 다른 version 1 - 데이터를 반으로 나누어 찾는 방법

```java
int findMax(int[] data, int begin, int end) {
	if(begin==end) // 데이터가 한 개일 경우
		return data[begin];
	else {
		int middle = (begin+end)/2;
		int max1 = findMax(data, begin, middle); // 시작 지점 ~ 가운데 중 최대값
		int max2 = findMax(data, middle +1, end); // 가운데 ~ 끝 지점 중 최대값
		return Math.max(max1, max2); // 두 최대값을 비교
	}
}
```

<br>

#### # 이진 검색 (Binary Search)

: 데이터가 크기순으로 정렬되어있을 경우 적용할 수 있는 검색 알고리즘이다.

  먼저 가운데 값을 찾는 값인 target과 비교하여 두 값이 동일하다면 검색을 완료한다.

  가운데 값이 찾는 값보다 크다면 앞 부분을 검색하고, 작다면 뒷 부분을 검색한다.

  이진 검색 알고리즘은 그 알고리즘 자체가 본질적으로 recursive하다고 이야기 할 수 있다.

```java
public static int binarySearch(String[] items, String target, int begin, int end)
{
	if(begin>end)
		return -1;
	else {
		/* String 두 값을 비교할 때 compareTo() 메소드 사용 */
		/* 두 값이 같다면 0, 비교 값보다 작다면 음수, 크다면 양수 리턴 */
		int middle = (begin+end)/2;
		int compResult = target.compareTo(items[middle]); // 가운데 값과 비교
		if(compResult==0)
			return middle;
		else if(compResult<0)
			return binarySearch(items, target, begin, middle-1);
		else
			return binarySearch(items, target, middle+1, end);
	}
}
```

이 함수의 미션은 items[begin]에서 items[end] 사이에서 target을 검색하는 것이다.

<br>

******
#### 참고

###### [강의] [인프런:영리한 프로그래밍을 위한 알고리즘 강좌](https://www.inflearn.com/course/알고리즘-강좌/lecture/4074)

