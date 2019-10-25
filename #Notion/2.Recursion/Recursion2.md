Designing Recursion 순환 알고리즘의 설계



Recursion 함수의 조건

- 적어도 하나의 base case, 즉 순환되지 않고 종료되는 case가 있어야 함

- 모든 case는 결국 base case로 수렴해야 함

가장 기본적인 형태

if (   ) {

​	base case;

}

else {

​	recursion;

}



*암시적(implicit) 매개변수를 명시적(explicit) 매개변수로 바꿔라.



순차 탐색 (Sequential search)

int search(int [] data, int n, int target) {

​	for(int i=0; i<n; i++) 

​		if(data[i]==target)

​			return i;

​	return -1;

}

이 함수의 미션은 data[0]에서 data[n-1] 사이에서 target을 검색하는 것이다. 하지만 검색 구간의 시작 인덱스 0은 보통 생략한다.(나타나있지 않다는 것(매개변수 안에!))

즉 암시적 매개변수이다. (인덱스 0부터 시작하겠지~하고 암시)



(데이터들이 정렬되어있다면) 이진 검색 가능

그렇지 않다면 하나씩 순서대로(순차대로) 보는 방법 뿐



매개변수의 명시화 : 순차탐색

이 함수의 미션은 data[begin]에서 data[end] 사이에서 target을 검색하는 것이다. 즉, 검색구간의 시작점을 명시적(explicit)으로 지정한다.

int search(int [] data, int begin, int end, int target) {

​	if (begin>end) // 검색할 데이터가 0개인 경우

​		return -1;

​	else if(target==data[begin])

​		return begin;

​	else

​		return search(data, begin+1, end, target);

}

이 함수를 search(data, 0, n-1, target)으로 호출한다면 앞의 함수와 완전히 동일한 일을 한다.



위는 끝지점은 명시적으로 지정되있지만, 시작지점은 x

아래는 시작, 끝지점 모드 명시적으로 지정되어있음



다른 version1 (마지막 값부터 비교하는 방법)

int search(int [] data, int begin, int end, int target) {

​	if (begin>end) // 검색할 데이터가 0개인 경우

​		return -1;

​	else if(target==data[end])

​		return end;

​	else

​		return search(data, begin, end-1, target);

}

다른 version2 (반으로 쪼개어 비교하는 방법)

int search(int [] data, int begin, int end, int target) {

​	if (begin>end)

​		return -1;

​	else {

​		int middle = (begin+end)/2;

​		if(data[middle]==target)

​			return middle;

​		int index = search(data, begin, middle-1, target);

​		if(index != -1) // 찾은경우 리턴

​			return index;

​		else // 앞에서 못찾은 경우

​			return search(data, middle+1, end, target);

​	}

}



매개변수의 명시화: 최대값 찾기

이 함수의 미션은 data[begin]에서 data[end] 사이에서 최대값을 찾아 반환한다. begin<=end라고 가정. 단, 데이터 개수는 한 개 이상

암시적이라면 int findMax(int [] data, int n) -> 0 ~ n-1

아래는 명시적으로 begin, end로 지정됨 -> begin ~ end

int findMax(int [] data, int begin, int end) {

​		if(begin==end) // 데이터가 한 개일 경우

​			return data[begin];

​		else

​			return Math.max(data[begin], findMax(data, begin+1, end));

}

다른 version1 (데이터를 반으로 나누어 찾는 방법)

int findMax(int [] data, int begin, int end) {

​		if(begin==end) // 데이터가 한 개일 경우

​			return data[begin];

​		else {

​			int middle = (begin+end)/2;

​			int max1 = findMax(data, begin, middle);

​			int max2 = findMax(data, middle +1, end);

​			return Math.max(max1, max2);

​		}

}



이진 검색 (Binary Search) : 데이터가 크기순으로 정렬되어있을 경우 적용할 수 있는 알고리즘

가운데 값을 target과 비교하여 값과 동일하다면 찾음

찾는 값보다 크다면 앞쪽을 검색, 작다면 뒤쪽을 검색

items[begin]에서 items[end] 사이에서 target을 검색한다.



public static int binarySearch(String[] items, String target, int begin, int end) {

​	if(begin>end)

​		return -1;

​	else {

​		int middle = (begin+end)/2;

​		int compResult = target.compareTo(items[middle]);

​		if(compResult==0)

​			return middle;

​		else if(compResult<0)

​			return binarySearch(items, target, begin, middle-1);

​		else

​			return binarySearch(items, target, middle+1, end);

​	}

}