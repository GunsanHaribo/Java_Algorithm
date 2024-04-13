# 그래프

- 정점(vertex)과 간선(edge)으로 이루어진 비선형 자료구조

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/d83ff43e-e85f-499f-a775-e72ccd52a3ec/Untitled.png)

# BFS **(Breadth-first search)**

## 개념

- 그래프에서 각 노드를 방문할때 너비를 우선으로 탐색하는 알고리즘
- 큐(Queue) 자료구조를 사용

![노드의 숫자는 방문 순서를 의미](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/3d0803df-b718-47f0-af3a-e2b675fa9451/Screenshot_2023-06-12_at_6.49.55_PM.png)

노드의 숫자는 방문 순서를 의미

## 시간 복잡도

- 2차원 배열의 모든 셀이 큐에 추가되므로 $O(row \times col)$

## 동작

- 큐에 원소를 넣어가며 동작을 이해해보세요.

![Screenshot 2023-06-12 at 7.13.22 PM.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/e9d67dda-c9ae-4c5f-b88f-9f90d1bb6e3a/Screenshot_2023-06-12_at_7.13.22_PM.png)

## 구현

```cpp
#include <bits/stdc++.h>

using namespace std;
#define X first
#define Y second // pair에서 first, second를 줄여서 쓰기 위해서 사용

int board[502][502] = {  // 1은 파란 칸, 0은 빨간 칸에 대응
	{1,1,1,0,1,0,0,0,0,0},
	{1,0,0,0,1,0,0,0,0,0},
	{1,1,1,0,1,0,0,0,0,0},
	{1,1,0,0,1,0,0,0,0,0},
	{0,1,0,0,0,0,0,0,0,0},
	{0,0,0,0,0,0,0,0,0,0},
	{0,0,0,0,0,0,0,0,0,0}
}; 
bool visited[502][502];  // 해당 칸을 방문했는지 여부를 저장
int r = 7, c = 10;       // r: 행, c: 열

int dx[4] = {1,0,-1,0};  // 남동북서
int dy[4] = {0,1,0,-1};

int main(void) {
	ios::sync_with_stdio(0);
	cin.tie(0);

	queue<pair<int,int>> Q;
	visited[0][0] = 1;  // (0, 0) 방문 표시
	Q.push({0,0});      // 큐에 시작점 삽입
	while(!Q.empty()) {
		pair<int,int> cur = Q.front();
		Q.pop();

		for(int dir = 0; dir < 4; dir++) {  // 상하좌우 칸 살펴보기
			int nx = cur.X + dx[dir];  // 다음 인접한 칸의 좌표
			int ny = cur.Y + dy[dir];
			if(nx < 0 || nx >= r || ny < 0 || ny >= c) continue;  // board 범위 체크
			if(visited[nx][ny] || board[nx][ny] == 0) continue;   // 이동 가능 체크 
			visited[nx][ny] = 1;  // (nx, ny) 방문 표시
			Q.push({nx, ny});     // 다음에 방문할 곳 큐에 삽입
		}
	}
}
```

### 주의사항

1. 시작점 방문 표시 여부
2. 큐에 방문 표시하는 타이밍
3. 인접한 칸에 대한 board의 범위 체크

## 유형별 예제

- [정답 코드](https://github.com/encrypted-def/basic-algo-lecture/blob/master/workbook/0x09.md)

### Connected component

- [BOJ 1926 그림](https://www.acmicpc.net/problem/1926)
- [BOJ 10026 적록색약](https://www.acmicpc.net/problem/10026)

### 거리 측정

- [BOJ 2178 미로 탐색](https://www.acmicpc.net/problem/2178)
- [BOJ 7562 나이트의 이동](https://www.acmicpc.net/problem/7562)

### 다양한 시작점

- [BOJ 7576 토마토](https://www.acmicpc.net/problem/7576)
- [BOJ 4179 불!](https://www.acmicpc.net/problem/4179)

### n차원

- [BOJ 1697 숨바꼭질](https://www.acmicpc.net/problem/1697)
- [BOJ 7569 토마토](https://www.acmicpc.net/problem/7569)

# DFS (Depth-first search)

## 개념

- 그래프에서 각 노드를 방문할때 깊이를 우선으로 탐색하는 알고리즘
- 스택(Stack) 자료구조나 재귀를 사용

  ![Screenshot 2023-06-13 at 10.42.49 AM.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/c93617dc-3fc0-4ee4-9ab9-64fc46daa04f/Screenshot_2023-06-13_at_10.42.49_AM.png)


## 시간 복잡도

- 2차원 배열의 모든 셀이 스택에 추가되므로 $O(row \times col)$

## 동작

- 스택에 원소를 넣어가며 동작을 이해해보세요.

![Screenshot 2023-06-13 at 10.46.54 AM.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/e70f65a0-dda2-4768-b9f4-0c91e201a90e/Screenshot_2023-06-13_at_10.46.54_AM.png)

## 구현

```cpp
#include <bits/stdc++.h>

using namespace std;
#define X first
#define Y second // pair에서 first, second를 줄여서 쓰기 위해서 사용

int board[502][502] = {  // 1은 파란 칸, 0은 빨간 칸에 대응
	{1,1,1,0,1,0,0,0,0,0},
	{1,0,0,0,1,0,0,0,0,0},
	{1,1,1,0,1,0,0,0,0,0},
	{1,1,0,0,1,0,0,0,0,0},
	{0,1,0,0,0,0,0,0,0,0},
	{0,0,0,0,0,0,0,0,0,0},
	{0,0,0,0,0,0,0,0,0,0}
}; 
bool visited[502][502];  // 해당 칸을 방문했는지 여부를 저장
int r = 7, c = 10;       // r: 행, c: 열

int dx[4] = {1,0,-1,0};  // 남동북서
int dy[4] = {0,1,0,-1};

int main(void) {
	ios::sync_with_stdio(0);
	cin.tie(0);

	stack<pair<int,int>> S;
	visited[0][0] = 1;  // (0, 0) 방문 표시
	S.push({0,0});      // 스택에 시작점 삽입
	while(!S.empty()) {
		pair<int,int> cur = S.top();
		S.pop();

		for(int dir = 0; dir < 4; dir++) {  // 상하좌우 칸 살펴보기
			int nx = cur.X + dx[dir];  // 다음 인접한 칸의 좌표
			int ny = cur.Y + dy[dir];
			if(nx < 0 || nx >= r || ny < 0 || ny >= c) continue;  // board 범위 체크
			if(visited[nx][ny] || board[nx][ny] == 0) continue;   // 이동 가능 체크 
			visited[nx][ny] = 1;  // (nx, ny) 방문 표시
			S.push({nx, ny});     // 다음에 방문할 곳 스택에 삽입
	  }
	}
}
```

# BFS vs DFS

|  | BFS | DFS |
| --- | --- | --- |
| 방식 | 너비 우선 | 깊이 우선 |
| 자료구조 | 큐 | 스택 |
| 시간 복잡도 | O(n) | O(n) |

## 방문 순서

![숫자는 방문 순서를 의미](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/6ea9b97b-3a54-4fdc-a690-d046fff6fe30/Screenshot_2023-06-13_at_10.50.23_AM.png)

숫자는 방문 순서를 의미

# 과제

- BFS 유형별 예제