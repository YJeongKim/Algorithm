# 순환 (Recursion) 5

<br>

> ### Recursion의 응용

<br>

#### # 멱집합 : Power Set

: 어떤 집합의 모든 부분 집합들로 구성된 집합이다.

임의의 집합 data = {a, b, c, d}의 모든 부분집합은 2<sup>4</sup> = 16개 이다.

<p align="center">
    <img src="https://user-images.githubusercontent.com/33328991/72801432-d2538b80-3c8c-11ea-9519-f900ec26af68.JPG" alt="power1" width="70%" />
</p>

▶ {a, b, c, d, e, f}의 모든 부분집합을 나열하려면?

a를 포함하지 않는 부분집합과 a를 포함하는 부분집합으로 나눌 수 있다.

a를 포함하지 않은 {b, c, d, e, f}의 모든 부분집합 2<sup>5</sup> + {b, c, d, e, f}의 모든 부분집합에 {a}를 추가한 집합 2<sup>5</sup> = 2<sup>6</sup>개

- a를 제외한 {b, c, d, e, f}의 모든 부분집합들을 나열하고

- {b, c, d, e, f}의 모든 부분집합에 {a}를 추가한 집합들을 나열한다.

- {b, c, d, e, f}의 모든 부분집합에 {a}를 추가한 집합들을 나열하려면?

  - {c, d, e, f}의 모든 부분집합들에 {a}를 추가한 집합들을 나열하고

  - {c, d, e, f}의 모든 부분집합에 {a, b}를 추가한 집합들을 나열한다.

  - {c, d, e, f}의 모든 부분에 {a}를 추가한 집합들을 나열하려면?

    - {d, e, f}의 모든 부분집합들에 {a}를 추가한 집합들을 나열하고

    - {d, e, f}의 모든 부분집합에 {a, c}를 추가한 집합들을 나열한다.

<br>

이를 Recursion으로 표현한다면 다음과 같다. powerSet(S)의 mission은 S의 멱집합을 출력하는 것이다.

```java
powerSet(S) // S의 멱집합을 출력
	if S is an empty set // 공집합이라면
		print nothing;
	else
		let t be the first element of S;
		find all subsets of S-{t} by calling powerSet(S-{t});
		return all of them;
```

집합 S에서 첫번째 원소 t를 제외한 모든 부분집합들을 recursion을 호출하여 구한 후 return 한다.

이렇게 하려면 powerSet 함수는 여러 개의 집합들을 return 해야한다.

2<sup>n</sup>개의 집합들을 어딘가 메모리에 저장해야하기 때문에, 모든 부분집합을 출력하는 문제에는 좋지 않은 방법이다.

```java
powerSet(S)
	if S is an empty set
		print nothing;
	else
		let t be the first element of S;
		find all subsets of S-{t} by calling powerSet(S-{t});
		print the subsets;
		print the subsets with adding t;
```

집합 S에서 첫번째 원소 t를 제외한 모든 부분집합들을 recursion을 호출하여 구한다.

그리고 그 부분 집합들을 출력하고, 그 부분 집합들에 t를 추가하여 출력한다.

그러나 이렇게 변경을 해도 코드 상 subsets인 모든 부분집합을 출력만 하고 저장하지 않았기때문에

모든 부분집합에 t를 추가한 집합들을 나타내는 subsets with adding t를 해결할 수 없다.

<br>

▶ Recursion 함수가 두 개의 집합을 매개변수를 받도록 수정

powerSet(P, S)의 mission은 S의 멱집합을 구한 후 각각에 집합 P를 합집합하여 출력하는 것이다.

```java
powerSet(P, S)
	if S is an empty set
		print P;
	else
		let t be the first element of S;
		powerSet(P, S-{t}); // t를 포함하지 않음
		powerSet(P∪{t}, S-{t}); // t를 포함
```

recursion 함수가 두 개의 집합을 매개변수로 받도록 설계해야한다는 의미이다.

두 번째 집합의 모든 부분집합들에 첫번째 집합을 합집합하여 출력한다.

맨 처음 초기 호출은 powerSet(null, S)으로 하면 된다. S의 멱집합을 구하기 위한 호출이다.

예를 들어 {b, c, d, e, f}의 모든 부분집합에 {a}를 추가한 집합들을 나열하려면

- {c, d, e, f}의 모든 부분 집합들에 {a}를 추가한 집합들을 나열하고

- {c, d, e, f}의 모든 부분집합에 {a, b}를 추가한 집합들을 나열한다.

{a, b, c, d, e, f} 에서 k를 c라 하였을 때,

집합 S : {c, d, e, f} - k번째부터 마지막 원소까지 연속된 원소들이다.

집합 P : {a, b} - 처음부터 k-1번째 원소들 중 일부이다.

<br>

▶ 두 집합의 표현

집합 S와 P를 인덱스 k와 boolean 배열 P를 이용하여 나타낸다. (TRUE : 포함 / FALSE : 불포함)

<p align="center">
    <img src="https://user-images.githubusercontent.com/33328991/72807005-c5896480-3c99-11ea-84f4-051a7377a748.JPG" alt="power2" width="90%" />
</p>

집합 S는 data[k], ..., data[n-1]이고, 집합 P는 include[i]=true (i = 0, ..., k-1) 인 원소들이다.

다음 함수의 mission은 data[k], ..., data[n-1]의 멱집합을 구한 후,

각각에 include[i]=true 인 원소를 추가하여 출력하는 것이다.

```java
private static char data[] = {'a', 'b', 'c', 'd', 'e', 'f'};
private static int n = data.length;
private static boolean [] include = new boolean [n];

public static void powerSet(int k) {
	if (k==n) { // 집합 S가 공집합이라는 의미
		for (int i=0; i<n; i++)
			if (include[i])
				System.out.print(data[i] + " ");
		System.out.println();
		return;
	}
	include[k]=false; // k번째 원소를 포함하지 않는 경우
	powerSet(k+1);
	include[k]=true; // k번째 원소를 포함하는 경우
	powerSet(k+1);
}
```

처음 이 함수를 호출할 때는 powerSet(0)으로 호출한다. 즉, P는 공집합이고 S는 전체집합이다.

<br>

▶ 상태공간트리 (State Space Tree)

다음은 집합 {a, b, c}의 모든 멱집합을 구하는 과정을 트리로 나타낸 예이다.

(그림이 잘못됨. include와 exclude가 반대로 표기되어있다.)

<p align="center">
    <img src="https://user-images.githubusercontent.com/33328991/72808282-9a544480-3c9c-11ea-96d5-35e056b217b8.JPG" alt="power3" width="80%" />
</p>

- 해를 찾기 위해 탐색할 필요가 있는 모든 후보들을 포함하는 트리이다.

- 트리의 모든 노드들을 방문하면 원하는 해를 찾을 수 있다.

- 루트에서 출발하여 체계적으로 모든 노드를 방문하는 절차를 기술한다.

위의 코드에 상태공간트리를 적용시켜보면 다음과 같다.

```java
private static char data[] = {'a', 'b', 'c', 'd', 'e', 'f'};
private static int n = data.length;
private static boolean [] include = new boolean [n];

/* include 배열과 k는 트리상에서 현재 나의 위치를 표현한다. */

public static void powerSet(int k) {
	/* 만약 내 위치가 리프노드라면 (트리의 마지막 level) 가지고 있는 값들을 출력한다. */
	if (k==n) {
		for (int i=0; i<n; i++)
			if (include[i])
				System.out.print(data[i] + " ");
		System.out.println();
		return;
	}
	/* 그렇지 않다면 (트리의 마지막 level이 아닌 중간 level) */
	include[k]=false;
	powerSet(k+1); /* 먼저 왼쪽으로 내려가 왼쪽 아래에 모든 노드를 방문한다. */
	include[k]=true;
	powerSet(k+1); /* 다음 오른쪽으로 내려가 오른쪽 아래에 모든 노드를 방문한다.*/
}
```

<br>

******
#### 참고

###### [강의] [인프런:영리한 프로그래밍을 위한 알고리즘 강좌](https://www.inflearn.com/course/알고리즘-강좌/lecture/4078)

