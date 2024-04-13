# 개념

- 각 단계에서만 최적인 해의 선택을 반복하는 알고리즘
- 즉, 관찰을 통해 탐색 범위를 줄이는 알고리즘
- 이러한 선택은 각 단계에서는 가장 최적이지만, 대부분의 경우 전체적인 최적해를 보장하진 않음
- 항상 최적해를 찾아내지는 못하더라도, 근사적인 해를 찾는 데 유용함

# 사용 조건

- 아래의 두 조건들을 만족하는 경우, 그리디 알고리즘으로 구한 해가 최적임이 보장됨

## Greedy Choice Property

- 앞의 선택이 이후의 선택에 영향을 주지 않는 경우

## [Optimal Substructure](https://en.wikipedia.org/wiki/Optimal_substructure)

- 부분 문제의 최적 해결 방법으로부터, 전체 문제의 최적 해결 방법을 구할 수 있는 경우

![최단 거리](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/c6f009a4-3e68-49b5-8a38-27bf5fb174fb/Untitled.png)

최단 거리

# 풀이 흐름

1. 관찰을 통해 탐색 범위를 줄이는 방법 고안
2. 탐색 범위를 줄여도 올바른 결과를 낸다는 사실을 수학적으로 증명
3. 구현

# 예제

- [BOJ 11047 동전 0](https://www.acmicpc.net/problem/11047)
- [BOJ 1931 회의실 배정](https://www.acmicpc.net/problem/1931)
- [BOJ 2217 로프](https://www.acmicpc.net/problem/2217)
- [BOJ 1026 보물](https://www.acmicpc.net/problem/1026)