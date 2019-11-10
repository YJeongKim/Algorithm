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

(x, y)에 인접한 cell이 동,서,남,북 방향으로 1~4개라면 그 cell의 각각을 검사한다.

그리고 그 비교하는 인접한 cell을 (x', y') 라고 할 때, 다시 (x', y')에 인접한 cell을 검사하여 출구를 찾는다.

그러나 이 경우에는 무한루프에 빠질 위험이 있다.

(x', y')에 인접한 cell에는 처음 비교 대상이었던 (x, y)도 포함되기 때문에 이 두 cell을 무한히 검사할 것이다.

<br>

▶ 무한루프에 빠지지 않으려면?

​	1) 이미 방문한 위치와 그렇지 않은 위치를 표시해야 한다.

​	2) 이미 방문하였던 위치라면 다시 검사하지 않는다.

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
    <img src="https://user-images.githubusercontent.com/33328991/72596026-803dfd80-394e-11ea-9702-2a22ce74b8bf.JPG" alt="maze2" width="70%" />
</p>

<br>

******
#### 참고

###### [강의] [인프런:영리한 프로그래밍을 위한 알고리즘 강좌](https://www.inflearn.com/course/알고리즘-강좌/lecture/4075)

