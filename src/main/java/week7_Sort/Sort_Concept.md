|속성 | | |
|------|---|---|
| 비교여부      |    Comparision  |  Non-comparison   |
| 메모리 사용량  |     In-place    |   Out-of-place    |
| Stability (안정성) | Stable |Unstable|
| Adaptability (순응성) | Adaptive | Non-adaptive|
| 데이터의 크기 | Internal | External|

# 1. Selection sort

### 동작

1. 주어진 리스트에서 최소값을 찾음
2. 최소값을 정렬되지 않은 부분의 가장 앞에 위치한 요소와 교체
3. 리스트의 정렬된 부분을 제외한 부분에 대해 위 과정을 반복

|Pass|	리스트	|최소값|
|------|---|---|
|0	|[9, 1, 6, 8, 4, 3, 2, 0]	|0|
|1	|[0, 1, 6, 8, 4, 3, 2, 9]	|1|
|2	|[0, 1, 6, 8, 4, 3, 2, 9]	|2|
|3	|[0, 1, 2, 8, 4, 3, 6, 9]	|3|
|4	|[0, 1, 2, 3, 4, 8, 6, 9]	|4|
|5	|[0, 1, 2, 3, 4, 8, 6, 9]	|6|
|6	|[0, 1, 2, 3, 4, 6, 8, 9]	|8|

- 시간 복잡도: $O(n^2)
- Comparison
- In-place
- Unstable
- Non-adaptive

# 2. Bubble sort

# 3. Insertion sort

# 4. Merge sort

# 5. Quick sort

# 6. Counting sort

# 7. Radix sort
