

|개인의 해석|
|------------|
|재귀랑 비슷하다 k를 이용해서 k+1을 해결하는데 여기선 k-2 k-3 등등 이전 값들은 다른 곳에 기록해놓았다가 <u>규칙성을 찾은 후에 k+1을 구할 때 사용한다</u> |


----------------------------------------------------------------------------
# 개념
- 복잡한 문제를 간단한 부분 문제들로 나눈뒤, 그 해들을 재사용하여 문제를 해결하는 최적화 방법
![스크린샷 2023-07-21 오후 5 22 24](https://github.com/GunsanHaribo/Java_Algorithm/assets/119919849/b2e4991f-5c8a-4478-890f-a8494e491ae5)


\n 사용조건 - 1. 중복된 하위 문제들(재귀가능)  && 2. 최적 부분 구조(최적화)

Overlapping Subproblems
- 큰 문제를 작은 부분 문제들로 분해할 수 있으며, 동일한 부분 문제들이 반복적으로 등장하는 경우
![스크린샷 2023-07-21 오후 5 34 13](https://github.com/GunsanHaribo/Java_Algorithm/assets/119919849/47b086c7-bede-47f3-bb3b-a419fa9c8bae)

Optimal Substructure
부분 문제의 최적 해결 방법으로부터, 전체 문제의 최적 해결 방법을 구할 수 있는 경우
![스크린샷 2023-07-21 오후 5 36 04](https://github.com/GunsanHaribo/Java_Algorithm/assets/119919849/4e84d830-a2e7-4b23-be20-42fa3259f12f)


# 구현 방법

## Memoization

- Top-down 방식으로, 재귀 함수 형태의 DP에서 사용함
- 동일한 계산을 반복해야할 때, 이전에 계산한 값을 메모리에 저장함으로써 동일한 계산의 반복을 제거하여 프로그램 실행 속도를 빠르게 하는 방식

![스크린샷 2023-07-21 오후 5 49 45](https://github.com/GunsanHaribo/Java_Algorithm/assets/119919849/52ccaba7-2f35-44df-85e1-d1c3de6c99dd)

Memoization을 사용한 피보나치 수열

## Tabulation

- Bottom-up 방식으로, 반복문 형태의 DP에서 사용함

# Tabulation 기반 풀이법

1. 테이블 정의
2. 점화식 세우기
3. 초기값 설정

# 예제

## 1번

- [BOJ 1463 1로 만들기](https://www.acmicpc.net/problem/1463)

<details>
<summary>풀이</summary>
<div markdown="1">       


    1. 테이블 정의: `d[i]`는 i를 1로 만드는 데 필요한 연산 사용 횟수의 최솟값
    2. 점화식 세우기
        1. `d[k] = d[k - 1] + 1`
        2. `if k % 3 == 0 { d[k] = min(d[k], d[k / 3] + 1) }`
        3. `if k % 2 == 0 { d[k] = min(d[k], d[k / 2] + 1) }`
    3. 초기값 설정: `d[1] = 0`

</div>
</details>


## 2번

- [BOJ 9095 1, 2, 3 더하기](https://www.acmicpc.net/problem/9095)

<details>
<summary>풀이</summary>
<div markdown="1">  

    
    1. 테이블 정의: `d[i]`는 i를 1, 2, 3의 합으로 나타내는 방법의 수
    2. 점화식 세우기: `d[k] = d[k - 1] + d[k - 2] + d[k - 3]`
    3. 초기값 설정: `d[1] = 1, d[2] = 2, d[3] = 4`
    

</div>
</details>


## 3번

- [BOJ 2579 계단 오르기](https://www.acmicpc.net/problem/2579)

<details>
<summary>풀이</summary>
<div markdown="1">       

    
    1. 테이블 정의: `d[i][j]`는 i번째 계단을 j번 연속한 상태로 밟았을 때 점수의 최댓값
    2. 점화식 세우기
        1. `d[k][1] = max(d[k - 2][1], d[k - 2][2]) + s[k]`
        2. `d[k][2] = d[k - 1][1] + s[k]`
    3. 초기값 설정: `d[1][1] = s[1], d[1][2] = 0, d[2][1] = s[2], d[2][2] = s[1] + s[2]`

    

</div>
</details>
