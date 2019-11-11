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

******
#### 참고

###### [강의] [인프런:영리한 프로그래밍을 위한 알고리즘 강좌](https://www.inflearn.com/course/알고리즘-강좌/lecture/4075)

