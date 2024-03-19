# 개념

- 오름차순으로 정렬된 리스트에서 특정 값을 찾기 위해 탐색 범위를 절반씩 줄여가며 찾는 탐색 알고리즘
- 순차 탐색과는 달리, $O(logn)$의 시간복잡도를 가짐

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/b76ff81f-d61c-4963-90ab-446091444a67/Untitled.png)

# 동작

1. 오름차순으로 정렬된 배열에서 중간 인덱스의 값을 선택
2. 찾고자 하는 값과 중간 인덱스의 값을 비교
    1. 찾고자 하는 값이 중간 인덱스 값보다 작은 경우 → 중간 인덱스의 왼쪽 부분을 대상으로 다시 탐색
    2. 찾고자 하는 값이 중간 인덱스 값보다 큰 경우 → 중간 인덱스의 오른쪽 부분을 대상으로 다시 탐색
    3. 찾고자 하는 값이 중간 인덱스 값과 같은 경우 → 해당 인덱스를 반환하고 탐색 종료
    4. 찾고자 하는 값이 없는 경우 → 탐색 종료

# 구현

- [BOJ 1920 수 찾기](https://www.acmicpc.net/problem/1920)

```swift
// 반복문 기반 구현
func binarySearch<T: Comparable>(_ arr: [T], _ target: T) -> Int? {
    var low = 0
    var high = arr.count - 1
    
    while low <= high {
        let mid = (low + high) / 2
        
        if arr[mid] == target { return mid }
        else if arr[mid] > target { high = mid - 1 }
        else { low = mid + 1 }
    }
    
    return nil
}

// 재귀 기반 구현
func binarySearch<T: Comparable>(
		_ arr: [T],
    _ range: Range<Int>,
    _ target: T
) -> Int? 
{
    let mid = (range.lowerBound + range.upperBound) / 2

    if range.lowerBound >= range.upperBound { return nil }

    if arr[mid] == target { return mid }
    else if arr[mid] > target { 
				return binarySearch(arr, range.lowerBound ..< mid, target)
		}
    else { return binarySearch(arr, mid + 1 ..< range.upperBound, target) }
}
```

# 예제

- [BOJ 10816 숫자 카드 2](https://www.acmicpc.net/problem/10816)
- [BOJ 18870 좌표 압축](https://www.acmicpc.net/problem/18870)
- [BOJ 2295 세 수의 합](https://www.acmicpc.net/problem/2295)
- [BOJ 2230 수 고르기](https://www.acmicpc.net/problem/2230)

# Parametric Search

- 최대값이나 최소값을 찾는 최적화 문제를 ‘예’ 혹은 ‘아니오’로 대답할 수 있는 결정 문제로 변환하는 방법
- 변환한 결정 문제에 대한 함수를 세운 뒤, binary search를 수행함
- 세운 함수는 monotonic한(항상 감소하거나 증가하는) 성질을 가져야만 함

## 예제

- [BOJ 1654 랜선 자르기](https://www.acmicpc.net/problem/1654)

  ![Screenshot 2023-08-01 at 12.28.07 PM.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/0aa1d84f-c821-4b7b-b40b-6fccf28debac/Screenshot_2023-08-01_at_12.28.07_PM.png)