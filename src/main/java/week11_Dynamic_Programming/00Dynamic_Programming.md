# 개념

- 복잡한 문제를 간단한 부분 문제들로 나눈뒤, 그 해들을 재사용하여 문제를 해결하는 최적화 방법

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/313ca2da-c7ef-408e-90c4-7b69ce405022/Untitled.png)

# 사용 조건

- 아래의 두 조건들을 만족하는 경우에 DP를 효과적으로 사용할 수 있음

## [Overlapping Subproblems](https://en.wikipedia.org/wiki/Overlapping_subproblems)

- 큰 문제를 작은 부분 문제들로 분해할 수 있으며, 동일한 부분 문제들이 반복적으로 등장하는 경우

![재귀적으로 구현된 피보나치 수열](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/d2334517-7e48-4ed8-bf7e-db72944d30a5/Untitled.png)

재귀적으로 구현된 피보나치 수열

## [Optimal Substructure](https://en.wikipedia.org/wiki/Optimal_substructure)

- 부분 문제의 최적 해결 방법으로부터, 전체 문제의 최적 해결 방법을 구할 수 있는 경우

![최단 거리](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/c6f009a4-3e68-49b5-8a38-27bf5fb174fb/Untitled.png)

최단 거리

# 구현 방법

## Memoization

- Top-down 방식으로, 재귀 함수 형태의 DP에서 사용함
- 동일한 계산을 반복해야할 때, 이전에 계산한 값을 메모리에 저장함으로써 동일한 계산의 반복을 제거하여 프로그램 실행 속도를 빠르게 하는 방식

![Memoization을 사용한 피보나치 수열](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/3a486d99-bd64-44b6-82fd-9020f02f47d7/Untitled.png)

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
- 풀이
    1. 테이블 정의: `d[i]`는 i를 1로 만드는 데 필요한 연산 사용 횟수의 최솟값
    2. 점화식 세우기
        1. `d[k] = d[k - 1] + 1`
        2. `if k % 3 == 0 { d[k] = min(d[k], d[k / 3] + 1) }`
        3. `if k % 2 == 0 { d[k] = min(d[k], d[k / 2] + 1) }`
    3. 초기값 설정: `d[1] = 0`

## 2번

- [BOJ 9095 1, 2, 3 더하기](https://www.acmicpc.net/problem/9095)
- 풀이
    1. 테이블 정의: `d[i]`는 i를 1, 2, 3의 합으로 나타내는 방법의 수
    2. 점화식 세우기: `d[k] = d[k - 1] + d[k - 2] + d[k - 3]`
    3. 초기값 설정: `d[1] = 1, d[2] = 2, d[3] = 4`

## 3번

- [BOJ 2579 계단 오르기](https://www.acmicpc.net/problem/2579)
- 풀이
    1. 테이블 정의: `d[i][j]`는 i번째 계단을 j번 연속한 상태로 밟았을 때 점수의 최댓값
    2. 점화식 세우기
        1. `d[k][1] = max(d[k - 2][1], d[k - 2][2]) + s[k]`
        2. `d[k][2] = d[k - 1][1] + s[k]`
    3. 초기값 설정: `d[1][1] = s[1], d[1][2] = 0, d[2][1] = s[2], d[2][2] = s[1] + s[2]`

## 4번

- [BOJ 1149 RGB거리](https://www.acmicpc.net/problem/1149)
- 풀이
    1. 테이블 정의: `d[i][j]`는 i번째 집의 색이 j일때 드는 비용의 최솟값
    2. 점화식 세우기
        1. `d[i][0] = min(d[i - 1][1], d[i - 1][2]) + r[i]`
        2. `d[i][1] = min(d[i - 1][0], d[i - 1][2]) + g[i]`
        3. `d[i][2] = min(d[i - 1][0], d[i - 1][1]) + b[i]`
    3. 초기값 설정: `d[1][0] = r[1]`, `d[1][1] = g[1]`, `d[1][2] = b[1]`

## 5번

- [BOJ 11726 2xn 타일링](https://www.acmicpc.net/problem/11726)
- 풀이
    1. 테이블 정의: `d[i]`는 2 * i 크기의 직사각형을 채우는 방법의 수
    2. 점화식 세우기: `d[i] = (d[i - 1] + d[i - 2]) % 10_007`
    3. 초기값 설정: `d[1] = 1`, `d[2] = 2`

## 6번

- [BOJ 11659 구간 합 구하기 4](https://www.acmicpc.net/problem/11659)
- 풀이
    1. 테이블 정의: `d[i]`는 i번째 수까지의 합 (prefix sum)
    2. 점화식 세우기: `d[i] = d[i - 1] + num[i]`
    3. 초기값 설정: `d[1] = num[1]`

## 7번

- [BOJ 12852 1로 만들기 2](https://www.acmicpc.net/problem/12852)
- 풀이
    1. 테이블 정의
        1. `d[i]`는 i를 1로 만드는 데 필요한 연산 사용 횟수의 최솟값
        2. `pre[i]`는 i를 1로 만드는 경로
    2. 점화식 세우기

        ```swift
        d[k] = d[k - 1] + 1
        pre[i] = i - 1
        ```

        ```swift
        if k % 3 == 0 && d[i] > d[i / 3] + 1 { 
            d[k] = d[k / 3] + 1
            pre[i] = i / 3
        }
        ```

        ```swift
        if k % 2 == 0 && d[i] > d[i / 2] + 1 { 
            d[k] = d[k / 2] + 1
            pre[i] = i / 2
        }
        ```

    3. 초기값 설정: `d[1] = 0`

# 과제

- [BOJ 1003 피보나치 함수](https://www.acmicpc.net/problem/1003)
- [BOJ 11727 2xn 타일링 2](https://www.acmicpc.net/problem/11727)