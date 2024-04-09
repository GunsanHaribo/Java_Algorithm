# Java_Algorithm(미완, 부분부분 채워야함)  핵심만 기록 자세한건 노션에

8/24 이전 

8/24 Tree 문제 풀기
BFS(Queue,주변부터)를 이용한 level-order
DFS(재귀, 파고들기)를 이용한 pre-order, in-order, post-order

8/25 Tree 추가개념
AVL, RedBlack Tree

8/28 우선순위큐 
o(n)인 이유 



# 프로그래머스 - 자바  - 일단 level3는 건너 뛴다



## 0. 시간복잡도 
## 1. 배열  - 피지컬이 얼마나 좋은가
핵심 : 상하좌우 좌표(x,y)로 두기 + 규칙찾기

1. 삼각달팽이
   1) 정리 
2. 행렬의 곱셈
   1) 정리
3. 교점에 별만들기
   1) 런타임에러 - 고쳐야되는데...
4. 거리두기 확인하기
   1) 


## 2. 문자열(불변) - 메소드 숙련도
왜 불변하지?
result[trans_y].charAt(trans_x) = "*";
핵심 : StringBuilder => 문자 추가로 새로운 배열 생성시 O(n) -> O(1)

SB 대표 메소드 
1. toString()
2. append()
3. length()
4. reverse()

S 분별 메소드
1. isUpperCase()
2. isAlphabetic()

질문 
1. StringBuilder는 어떻게 구성되었길래 배열생성시 O(1)이 나오는걸까? 

문제 
1. 시저암호 - 메소드 알아야됨
2. 이상한 문자 만들기
   1. String[] array= k.split("\\s", -1);  -1이 마지막 " "고려한다는의미
   2. 공백문자일 경우 처리하는거 암기
3. 문자열압축
   1. compare 해야되는데 시작이랑 끝을 어떻게 선정
   2. 만약 나머지가 넘는다면 어떻게할건지 => 이거 디버거 없으면 못하는데...실제시험에서는 어떻게하지


## 3. 재귀 => 스택, 모든 예시 사용해서 종료조건까지 가보기

푸는 법  -> 이렇게 어떻게 풀지?
1. 상태(문제 구성요소 중 변하는 것) -> 구성요소들을 어떻게 구현 할 건가, 예를들면 알파벳이 추가되면 단어랑 길이가 변한다던가
2. 상태의 종료조건(어떻게 종료되는가)
3. 점화식(어떻게 변하는가)


1. 재귀압축 
   1. 손으로 시뮬레이션 돌리면서 변수 찾는다
   2. 시뮬레이션을 통해 관계식과 종료 시점을 찾는다
   3. 문제가 있던 부분 - 분등해서 새로 배열에 넣어줄떄 ㄹㅇ 헷갈림
   4. 수정해야할점 : 
      1. 재귀 정의 법 더 익혀야된다
      2. 전역변수 => 생성자를 통해 부분결과값 증가를 통해 증가시킨 값을 유지하자
      3. 정사각형 - (x, y, 범위)
2. 하노이탑 - 이걸로 재귀 마무리 하자
   1. 
3. 모음사전
   1. 이거 너무 while로 풀었는데 
   2. 단어 생성 까지는 좋았다 그런데 마무리가 좀 
   3. 
 

## 6. 완전탐색 - 경우의 수가 작아서 시간복잡도가 작게 나오면 시도 - 비교적 쉬움
BFS(큐)
DFS(스택)
방문 체크 필수 


## 7. 정렬 - 정렬 기준(이름 혹은 학번) + 순서

1. comparable
2. comparator
3. 기본 기준 사용하기
   1. 배열 - Arrays.sort()
   2. Collection - Collection.sort()
   3. Stream - stream.sorted()


## 8. 동적프로그래밍 - 

## 9. 자주등장하는 자료구조 
## 10. 구현 
### 1. 완전탐색 BFS, DFS
### 2. 그리디

## 카카오 블라인드
## PCCP 