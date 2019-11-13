# 순환 (Recursion) 4

<br>

> ### Recursion의 응용

<br>

#### # Maze : 미로찾기

<p align="center">
    <img src="https://user-images.githubusercontent.com/33328991/72526312-83cb7900-38a9-11ea-9de4-be794af70f81.JPG" alt="maze1" width="80%"/>
</p>

N x N 배열이라고 가정한다면 입구 좌표는 (0, 0) 이고, 출구 좌표는 (N-1, N-1) 이다.

흰색 cell은 pathway로 사람이 지나갈 수 있는 통로이고, 파란색 cell은 wall로 지나갈 수 없는 막힌 구간이다.

▶ 현재 위치에서 출구까지 가는 경로가 있으려면

​	1) 현재 위치가 출구이거나

​	2) 이웃한 셀들 중 하나에서 현재 위치를 지나지않고 출구까지 가는 경로가 있거나

<br>

Recursion으로 해결하기에 앞서 미로찾기를 Decision Problem (답이 Yes or No인 문제)으로 생각해보자.

출발점에서 출구까지 가는 경로가 있느냐 없느냐를 답하는 version이다.

```java
boolean findPath(x,y)
	if (x,y) is the exit
		return true;
	else
		for each neighbouring cell (x',y') of (x,y) do
			if(x',y') is on the pathway
				if findPath(x',y')
					return true;
		return false;
```

(x, y)에 인접한 cell이 동, 서, 남, 북 방향으로 1~4개라면 그 cell의 각각을 검사한다.

그리고 그 비교하는 인접한 cell을 (x', y') 라고 할 때, 다시 (x', y')에 인접한 cell을 검사하여 출구를 찾는다.

그러나 이 경우에는 무한루프에 빠질 위험이 있다.

(x', y')에 인접한 cell에는 처음 비교 대상이었던 (x, y)도 포함되기 때문에 이 두 cell을 무한히 검사할 것이다.

<br>

▶ 무한루프에 빠지지 않으려면?

​	1) 이미 방문한 위치와 그렇지 않은 위치를 표시해야 한다.

​	2) 이미 방문하였던 위치라면 다시 검사하지 않아야 한다.

<br>

```java
boolean findPath(x,y)
	if (x,y) is the exit
		return true;
	else
		mark (x, y) as a visited cell;
		for each neighbouring cell (x',y') of (x,y) do
			if(x',y') is on the pathway and not visited
				if findPath(x',y')
					return true;
		return false;
```

```java
boolean findPath(x,y)
	if (x, y) is either on the wall or a visited cell
		return false;
    else if (x,y) is the exit
		return true;
	else
		mark (x, y) as a visited cell;
		for each neighbouring cell (x',y') of (x,y) do
			if findPath(x',y')
				return true;
		return false;
```

위 코드의 차이는 크게 없지만, recursion이 호출되는 횟수는 두 번째의 경우가 더 많다. 그러나 코드는 좀 더 간결하다.

```java
public class Maze {
	private static int N=8;
	private static int [][] maze = {
		{0, 0, 0, 0, 0, 0, 0, 1},
		{0, 1, 1, 0, 1, 1, 0, 1},
		{0, 0, 0, 1, 0, 0, 0, 1},
		{0, 1, 0, 0, 1, 1, 0, 0},
		{0, 1, 1, 1, 0, 0, 1, 1},
		{0, 1, 0, 0, 0, 1, 0, 1},
		{0, 0, 0, 1, 0, 0, 0, 1},
		{0, 1, 1, 1, 0, 1, 0, 0}
	};
	private static final int PATHWAY_COLOUR = 0; // 지나갈 수 있는 통로
	private static final int WALL_COLOUR = 1; // 지나갈 수 없는 벽
	private static final int BLOCKED_COLOUR = 2; // 이미 방문, 출구까지의 경로상에 있지 않음
	private static final int PATH_COLOUR = 3; // 이미 방문, 출구로 가는 경로가 될 가능성이 있음

	public static boolean findMazePath(int x, int y) {
		if (x<0 || y<0 || x>=N || y>=N) // 범위 내 유효한 좌표인가 check
			return false;
		else if (maze[x][y] != PATHWAY_COLOUR) // 이미 방문하거나 벽인지 check
			return false;
		else if (x==N-1 && y==N-1) { // 출구인 경우 도착!
			maze[x][y] = PATH_COLOUR;
			return true;
		}
		else {
			maze[x][y] = PATH_COLOUR; // 일단 방문한 길로 check, 꽝인지 아닌지 아직 밝혀지지 않음
			if (findMazePath(x-1,y) || findMazePath(x,y+1)
				|| findMazePath(x+1,y) || findMazePath(x,y-1)) { // 인접한 좌표 4방향 check
				return true;
			}
			maze[x][y] = BLOCKED_COLOUR; // dead end, 이곳에 도달하면 길이 막힌 것임
			return false;
		}
	}

	public static void main(String [] args) {
		printMaze();
		findMazePath(0,0);
		printMaze();
	}
}
```

움직인 경로를 표시해보면 다음과 같은 방식으로 진행된다. (북 → 동 → 남 → 서)

<p align="center">
    <img src="https://user-images.githubusercontent.com/33328991/72596026-803dfd80-394e-11ea-9702-2a22ce74b8bf.JPG" alt="maze2" width="60%" />
</p>

<br>

#### # Counting Cells in a Blob

<p align="center">
    <img src="https://user-images.githubusercontent.com/33328991/72598151-9352cc80-3952-11ea-9743-a78e6b16d29f.JPG" alt="cell1" width="60%" />
</p>

- 입력으로 Binary 이미지가 주어질 때, 각 픽셀은 background pixel 이거나 image pixel 이다.

- 서로 연결된 image pixel들의 집합을 **Blob**이라고 하며, 상하좌우 및 대각방향으로도 연결된 것으로 간주한다.

<p align="center">
    <img src="https://user-images.githubusercontent.com/33328991/72599193-9353cc00-3954-11ea-8aab-76ca85fad932.JPG" alt="cell2" />
</p>

이 문제는 특정한 좌표 (x, y)가 속한 Blob의 크기를 구하는 것이다. 예를 들어 (1, 1)이 속한 Blob의 size는 5이다.

- 입력

  - N x N 크기의 2차원 그리드 (grid)

  - 하나의 좌표 (x, y)

- 출력

  - 픽셀 (x, y)가 포함된 blob의 크기

  - (x, y)가 어떤 blob에도 속하지 않는 경우에는 0

<br>

▶ Recursive Thinking

```
현재 픽셀이 속한 blob의 크기를 카운트하려면?
	
	현재 픽셀이 image color가 아니라면
		0을 반환한다.
	
	현재 픽셀이 image color라면
		먼저 현재 픽셀을 카운트한다. (count=1)
		현재 픽셀이 중복 카운트되는 것을 방지하기위해 다른 색을 칠한다.
		현재 픽셀에 이웃한 모든 픽셀들에 대해서
			그 픽셀이 속한 blob의 크기를 카운트하여 카운터에 더해준다.
		카운터를 반환한다.
```

이해를 돕기위해 위의 방법대로 다음 표시된 픽셀이 포함된 Blob의 크기를 계산해보자.

<p align="center">
    <img src="https://user-images.githubusercontent.com/33328991/72600749-93090000-3957-11ea-9b18-07439bf00afd.JPG" alt="cell3" width="60%" />
</p>

이 좌표를 x=5, y=3 이라고 가정해보자. count는 0으로 초기화하고 시작한다. (count=0)

1. 먼저 (5, 3) 픽셀은 image pixel이므로 count를 1 증가시킨다. (count=1)

2. 그리고 이 픽셀이 중복 카운트되는 것을 방지하기 위해 빨간색으로 칠한다.

3. 현재 픽셀이 인접한 8개의 픽셀 각각에 대해서 순서대로 그 픽셀이 속한 blob의 크기를 count한다.

   북동, 동, 동남, ... 이런 순서로 고려한다.

   1. 먼저 북쪽인 (5, 2) 픽셀이 포함된 Blob의 크기는 0이다. 따라서 count 값은 변화없다. (count=1)
   
   2. 다음 북동쪽인 (6, 2) 픽셀이 속한 Blob을 count하고, count된 픽셀들을 빨간색으로 칠한다.
   
      (6, 2) 픽셀을 포함한 Blob의 크기는 3이다. (6, 2), (5, 1), (4, 2) 이렇게 총 3개이다. (count=1+3=4)
   
   3. 동쪽인 (6, 3) 픽셀과 동남쪽인 (6, 4) 픽셀은 image pixel이 아니므로 Blob의 크기는 0이다. (count=4)
   
   4. 남쪽인 (5, 4) 픽셀이 속한 Blob을 count하고, count된 픽셀들을 빨간색으로 칠한다.
   
      (5, 4) 픽셀을 포함한 Blob의 크기는 9이다. (count=4+9=13)
   
   5. 남서쪽인 (4, 4) 픽셀과 서쪽인 (4, 3) 픽셀은 image pixel이 아니므로 Blob의 크기는 0이다. (count=13)
   
   6. 북서쪽인 (4, 2) 픽셀은 이미 카운트되어 빨간색으로 칠해졌기 때문에 고려하지 않는다.
   
4. 모든 픽셀의 검사가 완료되었기 때문에 count 값 13을 반환한다.

<br>

위의 방법을 알고리즘으로 나타내면 다음과 같다.

```java
int countCells(x, y)
	if the pixel (x, y) is outside the grid
		the result is 0;
	else if pixel (x,y) is not an image pixel or already counted
		the result is 0;
	else
		set the colour of the pixel (x,y) to a red colour;
		the result is 1 plus the number of cells 
			in each piece of the blob that includes a nearest neighbour;
```

```java
public class Blob {
	private static int N=8;
	private static int [][] grid = {
		{1, 0, 0, 0, 0, 0, 0, 1},
		{0, 1, 1, 0, 0, 1, 0, 0},
		{1, 1, 0, 0, 1, 0, 1, 0},
		{0, 0, 0, 0, 0, 1, 0, 0},
		{0, 1, 0, 1, 0, 1, 0, 0},
		{0, 1, 0, 1, 0, 1, 0, 0},
		{1, 0, 0, 0, 1, 0, 0, 1},
		{0, 1, 1, 0, 0, 1, 1, 1}
	};
	private static final int BACKGROUND_COLOR = 0; // background 픽셀
	private static final int IMAGE_COLOR = 1; // image 픽셀
	private static final int ALREADY_COUNTED = 2; // 이미 카운트 된 cell
    
	public static int countCells(int x, int y) {
		if (x<0 || x>=N || y<0 || y>=N) // 범위 내 유효한 좌표인가 check
			return 0;
		else if (grid[x][y] != IMAGE_COLOR) // 이미지 픽셀이 아니거나 이미 카운트 됐는지 check
			return 0;
		else {
			grid[x][y] = ALREADY_COUNTED; // 카운트 한 픽셀로 check
			return 1 + countCells(x-1, y+1) + countCells(x, y+1) 
				+ countCells(x+1, y+1) + countCells(x-1, y)  // 인접한 8개의 픽셀 count
				+ countCells(x+1, y) + countCells(x-1, y-1)
				+ countCells(x, y-1) + countCells(x+1, y-1);
		}
	}

    public static void main(String [] args) {
		printGrid();
		System.out.println("Counting cells in a Blob : " + countCells(3, 5));
		printGrid();
	}
}
```

<br>

#### # N-Queens Problem

N x N 크기의 체스 보드가 주어지며, 이 체스 보드에 N개의 퀸을 서로 공격할 수 없도록 배치하는 문제이다.

이때 N개의 퀸 모두 동일한 행, 동일한 열, 동일한 대각선 상에 겹치지 않도록 놓아야 한다.

즉, 조건을 만족하면서 하나의 행에 하나의 퀸을 놓아야 한다. 아래의 경우는 N=8인 경우이다.

<p align="center">
    <img src="https://user-images.githubusercontent.com/33328991/72676344-a7720780-3ad3-11ea-8c45-52bbf9de8197.JPG" alt="queen1" width="70%" />
</p>

이 문제를 푸는 방법의 하나는 **Backtracking**기법을 사용하는 것이다.

어떤 결정들을 내려가다가 결정이 막다른 길이라 그 결정을 내려서는 안된다는 것이 분명해지면,

**가장 최근의 내렸던 결정을 번복하고 다른 선택을 하는 문제 해결 방법**을 Backtracking (되추적 기법) 이라고 한다.

<br>

▶ Backtracking

: 특정 노드에서 유망성(promising)을 점검하고, 유망하지 않다면 그 노드의 부모로 돌아가서(Backtracking)

다음 노드에 대한 검색을 계속하게 되는 절차이다. 이로써 풀이 시간을 단축한다.

스택에 자식 노드를 넣기 전에 유망한지(해답이 될 가능성이 있는지) 확인하고 스택에 넣는다.

<br>

▶ DFS와 Backtracking의 차이점

- DFS는 완전 탐색 방법으로 모든 경로를 추적한다.

- Backtracking은 가지치기(Pruning)를 통해 불필요한 경로를 차단하기 때문에 모든 경로를 추적하지 않는다.

<br>

▶ 상태공간트리

: 찾는 해를 포함하는 트리이다. 즉, 해가 존재한다면 그것은 반드시 이 트리의 한 노드에 해당한다.

따라서, 이 트리를 체계적으로 탐색하면 해를 구할 수 있다.

<p align="center">
    <img src="https://user-images.githubusercontent.com/33328991/72777203-3314a100-3c58-11ea-83ca-37b3cb482fc4.JPG" alt="queen2" width="90%" />
</p>

n=4인 경우를 생각해보자. 먼저 1번 말을 (1,1), (1,2), (1,3), (1,4)에 놓을 수 있는 4가지 갈래가 있다.

그리고 그 각각에 대해서 2번 말을 (2,1), (2,2), (2,3), (2,4)에 놓을 수 있는 4가지의 갈래가 있다.

그 이후도 마찬가지이며, 실제로 완성된 상태공간트리를 그린다면 4 x 4의 체스 보드에 4개의 말을 놓을 수 있는

모든 가능한 경우의 수를 나열하는 그림이 될 것이다.

<br>

**※ 상태공간 트리의 모든 노드를 탐색해야하는 것은 아니다.**

<p align="center">
    <img src="https://user-images.githubusercontent.com/33328991/72785246-2307bc00-3c6e-11ea-8ddb-556148b66260.JPG" alt="queen3" width="70%" />
</p>

상태공간트리를 탐색한다는 것은 실제로 모든 노드를 탐색한다는 것이 아니다.

그리고 실제로 트리를 그리거나, data structure로 만든다는 뜻이 아니며 하나의 개념적인, 논리적인 것이다.

이런 트리를 개념적으로 염두해두고, 실제로는 이 트리의 노드를 탐색하는 코드를 만들면 된다.

<p align="center">
    <img src="https://user-images.githubusercontent.com/33328991/72786231-70852880-3c70-11ea-97e1-810bf2be64ee.JPG" alt="queen4" width="70%" />
</p>

정리하자면, **Backtracking**은 상태공간트리를 **깊이 우선 방식**으로 탐색하여 해를 찾는 알고리즘을 말한다.

이 알고리즘을 구현하는 방법은 recursion으로 구현하는 방법과 stack을 이용하여 구현하는 방법이 있다.

recursion을 이용하여 구현하는 것이 쉽고 간명하기 때문에 대부분 recursion으로 Backtracking을 구현한다.

<br>

▶ Design Recursion

가장 간단한 Backtracking을 구현하는 대부분의 함수들은 기본적으로 다음 구조를 가진다.

```java
return-type queens ( arguments ) {
	if non-promising
		report failure and return;
	else if success
		report answer and return;
	else
		visit children recursively;
}
```

- arguments : 매개변수는 내가 현재 트리의 어떤 노드에 있는지를 지정해야 한다.

  상태공간트리 상에서 어떤 노드에 도착했다는 것이다.

이 함수에서 수행할 코드는 어떤 노드에 도착했을 때, 그 이후에 행해져야 할 작업들이다.

1. 먼저 할 것은 이 노드가 non-promising 또는 infeasible 한 노드인지를 판단한다.

   즉, 해당 노드의 아래 깊이를 더 탐색해볼 가치가 있는 노드인가를 판단한다. 아니라면 되돌아간다.

2. 만약, 답을 찾은 경우라면 답을 출력하고 리턴한다.

3. 그렇지 않다면, (이 노드가 실패도 아니고 최종적인 답도 아니라면) 해당 노드의 자식들을 순서대로 방문한다.

<br>

```java
int [] cols = new int [N+1];
boolean queens( int level ) {
	if non-promising
		report failure and return;
	else if success
		report answer and return;
	else
		visit children and recursively;
}
```

매개변수 level과 전역변수 cols를 이용함으로써 현재 트리 상의 어떤 노드에 있는지를 나타낸다.

- 매개변수 level은 현재노드의 level을 표현한다.

- 전역변수 배열 cols는 i번에서 level 번째 퀸이 어디에 놓였는지를 표현한다.

- cols[i]=j는 i번 말이 (i행, j열)에 놓였음을 의미한다.

return type은 boolean으로 성공이냐 실패냐를 반환한다.

다음은 각 조건에 해당하는 코드를 작성한 것이다. non promising 여부를 판단하는 함수를 만들었다고 가정한다.

```java
int [] cols = new int [N+1];
boolean queens(int level) {
	if (!promising(level))
		return false;
	else if (level==N) // 모든 말이 놓였을 경우
		return true;
	for (int i=1; i<=N; i++) {
		cols[level+1] = i;
		if (queens(level+1)) // level+1번째 말을 각각의 열에 놓은 후 recursion을 호출한다.
			return true;
	}
	return false; // N개의 말을 다 두어봤지만 꽝
}
```

<br>

▶ Promising Test

위의 코드를 보면 queens()를 호출할 때 마다 promising 여부를 테스트하고 있다.

cols 배열의 1, 2, 3에 해당하는 말들 간에는 충돌이 없다고 보장할 수 있다.

<p align="center">
    <img src="https://user-images.githubusercontent.com/33328991/72792104-c9a68980-3c7b-11ea-9736-5cbdd1d04948.JPG" alt="queen5" width="80%" />
</p>

```java
boolean promising(int level) {
	for (int i=1; i<level; i++) { // 이전에 놓인 말들과 level 번째 말이 충돌하는지 검사
		if (cols[i]==cols[level]) // 같은 열에 놓였는지 check
			return false;
		else if (level-i==Math.abs(cols[level]-cols[i])) // 같은 대각선에 놓였는지 check
			return false;
	}
	return true;
}
```

다음 그림은 동일한 대각선에 놓였는지를 검사하는 방법이다.

i-th row와 level-th row 사이의 거리와 cols[level]과 cols[i] 사이의 거리가 같다면 같은 대각선에 놓인 것이다.

여기서 i와 level 중 어느 것이 큰 수인지 모르니 두 값의 차이에 절대값을 취한다.

<p align="center">
    <img src="https://user-images.githubusercontent.com/33328991/72792884-12ab0d80-3c7d-11ea-89a9-c46cd948861e.JPG" alt="queen6" width="60%" />
</p>

```java
public class NQueens {
	private static int N=8;
	private static int [] cols = new int [N+1];

	public static boolean queens(int level) {
		if (!promising(level))
			return false;
		else if (level==N) {
			for(int i=1; i<=N; i++)
				System.out.println("(" + i + ", " + cols[i] + ")");
			return true;
		}
		for (int i=1; i<=N; i++) {
			cols[level+1] = i;
			if (queens(level+1))
				return true;
		}
		return false;
	}

	public static boolean promising(int level) {
		for (int i=1; i<level; i++) {
			if (cols[i]==cols[level])
				return false;
			else if ((level-i)==Math.abs(cols[level]-cols[i]))
				return false;
		}
		return true;
	}

	public static void main(String [] args) {
		queens(0);
	}
}
```

<br>

******
#### 참고

###### [강의] [인프런:영리한 프로그래밍을 위한 알고리즘 강좌](https://www.inflearn.com/course/알고리즘-강좌/lecture/4075)

###### [강의] [인프런:영리한 프로그래밍을 위한 알고리즘 강좌](https://www.inflearn.com/course/알고리즘-강좌/lecture/4076)

###### [강의] [인프런:영리한 프로그래밍을 위한 알고리즘 강좌](https://www.inflearn.com/course/알고리즘-강좌/lecture/4077)

###### [블로그] [https://ict-nroo.tistory.com](https://ict-nroo.tistory.com/50?category=698685) - 내용

