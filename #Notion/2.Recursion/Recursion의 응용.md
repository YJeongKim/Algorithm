## Recursion의 응용



### 미로찾기1

현재 위치에서 출구까지 가는 경로가 있으려면

1) 현재 위치가 출구이거나

2) 이웃한 셀들 중 하나에서 현재 위치를 지나지않고 출구까지 가는 경로가 있거나



Decision Problem : 답이 Yes or No인 문제



boolean findPath(x,y)

​	if (x,y) is the exit

​		return true;

​	else

​		for each neighbouring cell (x',y') of (x,y) do

​			if(x',y') is **on the pathway**

​				if findPath(x',y')

​					return true;

​		return false;



무한루프에 빠지지 않으려면?

이미 방문한 위치를 체크해야한다.

boolean findPath(x,y)

​	if (x,y) is the exit

​		return true;

​	else

​		mark (x,y) as a visited cell;

​		for each neighbouring cell (x',y') of (x,y) do

​			if(x',y') is <u>**on the pathway and not visited**</u>

​				if findPath(x',y')

​					return true;

​		return false;



boolean findPath(x,y)

​	if (x,y) is either on the wall or a visited cell

​		return false;

​	else if (x,y) is the exit

​		return true;

​	else

​		mark (x,y) as a visited cell;

​		for each neighbouring cell (x',y') of (x,y) do

​			if(x',y') findPath(x',y')

​				return true;

​		return false;



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
    private static final int PATHWAY_COLOUR = 0;
    private static final int WALL_COLOUR = 1;
    private static final int BLOCKED_COLOUR = 2;
    private static final int PATH_COLOUR = 3;
    
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
            maze[x][y] = PATH_COLOUR;
            if (findMazePath(x-1,y) || findMazePath(x,y+1)
                || findMazePath(x+1,y) || findMazePath(x,y-1)) { // 인접한 좌표 4방향 check
                return true;
            }
            maze[x][y] = BLOCKED_COLOUR; // dead end 길이 막힘
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

![image-20191218173358783](C:\Users\김연정\AppData\Roaming\Typora\typora-user-images\image-20191218173358783.png)

움직인 경로 (북 -> 동 -> 남 -> 서)



### Counting cells in a Blob



![image-20191218173653951](C:\Users\김연정\AppData\Roaming\Typora\typora-user-images\image-20191218173653951.png)

- Binary 이미지
- 각 픽셀은 background pixel이거나 image pixel
- 서로 연결된 image pixel들의 집합을 blob이라고 부름
- 상하좌우 및 대각방향으로도 연결된 것으로 간주



![image-20191218173925802](C:\Users\김연정\AppData\Roaming\Typora\typora-user-images\image-20191218173925802.png)

입력 :

- N*N 크기의 2차원 그리드(grid)

- 하나의 좌표 (x,y)

출력:

- 픽셀 (x,y)가 포함된 blob의 크기

- (x,y)가 어떤 blob에도 속하지 않는 경우에는 0



<u>현재 픽셀이 속한 blob의 크기를 카운트하려면</u>

​	현재 픽셀이 image color가 아니라면

​		0을 반환한다.

​	현재 픽셀이 image color라면

​		먼저 현재 픽셀을 카운트한다. (count=1)

​		현재 픽셀이 중복 카운트되는 것을 방지하기위해 다른 색을 칠한다.

​		현재 픽셀에 이웃한 모든 픽셀들에 대해서 그 픽셀이 속한 blob의 크기를 카운트하여 카운터에 더해준다.

​		카운터를 반환한다.



인접한 8개의 픽셀 각각에 대해서 순서대로 그 픽셀이 포함된 blob의 크기를 count. 북, 북동, 동, 동남, ... 이런 순서로 고려한다.



__<u>Algorithm for countCells(x,y)</u>__

if the pixel (x,y) is outside the grid

​	the result is 0;

else if pixel (x,y) is not an image pixel or already counted

​	the result is 0;

else

​	set the colour of the pixel (x,y) to a red colour;

​	the result is 1 plus the number of cells in each piece of the blob that includes a nearest neighbour;



```java
private static int BACKGROUND_COLOR = 0;
private static int IMAGE_COLOR = 1;
private static int ALREADY_COUNTED = 2;

public int countCells(int x, int y) {
    int result;
    if (x<0 || x>=N || y<0 || y>=N)
        return 0;
    else if (grid[x][y] != IMAGE_COLOR)
        return 0;
    else {
        grid[x][y] = ALREADY_COUNTED;
        return 1 + countCells(x-1, y+1) + countCells(x, y+1) + countCells(x+1, y+1) + countCells(x-1, y) + countCells(x+1, y) + countCells(x-1, y-1) + countCells(x, y-1) + countCells(x+1, y-1);
    }
}
```



### N-Queens Problem

###### (Backtracking: 최근의 내렸던 결정을 번복하고 다른 결정으로, 되추적 기법)



상태공간트리 : 찾는 해를 포함하는 트리

![image-20191219172257073](C:\Users\김연정\AppData\Roaming\Typora\typora-user-images\image-20191219172257073.png)

즉 해가 존재한다면 그것은 반드시 이 트리의 어떤 한 노드에 해당함 따라서 이 트리를 체계적으로 탐색하면 해를 구할 수 있음

상태공간 트리의 모든 노드를 탐색해야하는 것은 아님

![image-20191219172738207](C:\Users\김연정\AppData\Roaming\Typora\typora-user-images\image-20191219172738207.png)

Backtracking : 상태공간 트리를 __깊이 우선 방식__으로 탐색하여 해를 찾는 알고리즘



int [] cols = new int [N+1];

boolean queens( int level ) {

​	if non-promising

​		report failure and return;

​	else if success

​		report answer and return;

​	else

​		visit children and recursively;

}



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

###### Promising Test

![image-20191219181444244](C:\Users\김연정\AppData\Roaming\Typora\typora-user-images\image-20191219181444244.png)

```java
boolean promising(int level) {
    for (int i=1; i<level; i++) {
        if (cols[i]==cols[level]) // 같은 열에 놓였는지 check
            return false;
        else if (level-i==Math.abs(cols[level]-cols[i])) // 같은 대각선에 놓였는지 check
            return false;
    }
    return true;
}
```

대각선 검사 - i와 level 중 어느 것이 큰 지 모르니 절대값으로

![image-20191219181914300](C:\Users\김연정\AppData\Roaming\Typora\typora-user-images\image-20191219181914300.png)

