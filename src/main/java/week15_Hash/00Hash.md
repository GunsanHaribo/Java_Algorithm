# Hash Function

- 임의의 길의의 데이터(key)를 고정된 길이의 데이터로 매핑하는 단방향 함수
- 해시 함수에 의해 얻어지는 고정된 길이의 고유 값을 해시 값이라 부름
- 해시 함수는 일반적으로 입력값의 범위보다 출력값의 범위가 작기 때문에, 서로 다른 입력값이 동일한 해시 값을 생성하는 충돌이 일어날 수 있음
- 좋은 해시 함수란, 주어진 해시 값으로 원래 입력을 찾기 어려워야하고, 충돌이 적어야하며, 유사한 입력값에 대해서도 불규칙한 해시 값을 생성하는 함수임

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/4bfad724-c720-49d6-85a0-4f0699c66e25/Untitled.png)

# Hash Table

- Key-value pair를 저장하는 배열 기반의 자료구조
- 키를 해시 함수에 입력하여 생성한 해시 값을 테이블의 인덱스로 사용함
- 각 인덱스에 대응하는 저장 공간을 버킷이라 부르며, key-value pair가 저장됨
- 충돌 발생 시, 하나의 버킷에 여러 key-value pair가 저장될 수 있음

![Screenshot 2023-08-08 at 1.19.20 PM.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/3065e8ef-ef17-4b44-a8be-3b47f4230b2e/Screenshot_2023-08-08_at_1.19.20_PM.png)

## 성질

- 모든 연산은 평균적으로 $O(1)$의 시간 복잡도를 가지지만, 충돌이 빈번하게 발생하거나 해시 함수가 해시 값을 계산하는데 드는 비용이 높으면 성능이 저하될 수 있음
- 해시 테이블의 크기가 실제 데이터의 크기보다 크다면 메모리가 낭비될 수 있으며, 반대로 해시 테이블의 크기가 실제 데이터의 크기보다 작다면 충돌이 일어나 성능이 저하될 수 있음  (space-time tradeoff)
- 해시 함수의 특성과 충돌 처리 방식 때문에 key-value pair의 저장 위치는 삽입 순서와는 무관함
- 즉, 해시 테이블은 속도는 빠르지만, 공간 효율성이 떨어지며 저장 순서가 보장되지 않는 자료구조임

# Hash Collision

- 해시 함수로 입력된 서로 다른 입력값이 동일한 해시 값을 생성하면 충돌이 발생함
- 충돌이 발생하면 추가적인 탐색이 필요하므로, 해시 테이블의 성능이 저하됨
- 대표적인 충돌 회피 방법으로는 separate chaining과 open addressing이 있음

![Screenshot 2023-08-08 at 2.57.57 PM.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/6308e54e-9651-427b-a994-5229c3ddf778/Screenshot_2023-08-08_at_2.57.57_PM.png)

## Separate Chaining

- 같은 해시 값을 갖는 key-value pair들을 연결 리스트 등의 자료구조를 사용해 체인으로 관리하는 방식
- 최악의 경우, 즉 생성된 해시 값이 모두 같을 때 $O(N)$의 시간 복잡도를 가짐

![Screenshot 2023-08-08 at 2.58.55 PM.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/c58999c7-03c2-4202-8bc2-651b43c5d228/Screenshot_2023-08-08_at_2.58.55_PM.png)

## Open Addressing

- 충돌이 발생하면 비어있는 다른 버킷을 찾아 key-value pair를 저장하는 방식
- 비어있는 다른 버킷을 찾는 과정을 probing이라 부름
- 충돌 처리를 위해 별도의 자료구조를 사용하지 않으므로, separate chaining에 비해 메모리를 적게 사용함

![Screenshot 2023-08-08 at 3.03.49 PM.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/c5323f72-e58a-45a8-bf9b-a66e6acaef78/Screenshot_2023-08-08_at_3.03.49_PM.png)

### **Linear Probing**

- 충돌이 발생한 인덱스부터 빈 버킷을 찾을때까지 1칸씩 이동하며 탐색하는 방식

  ![Screenshot 2023-08-08 at 3.20.52 PM.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/6dd09da3-55dc-45ce-b729-0eaef16de223/Screenshot_2023-08-08_at_3.20.52_PM.png)

- 구현이 간단하고 cache hit rate가 높지만, 연속된 공간에 key-value pair들이 밀집되어 있는 현상인 clustering이 발생함
- Clustering이 발생하면 빈 칸을 찾기까지 이동을 많이해야하므로 성능이 저하됨
- Key-value pair가 삭제된 경우, 잘못된 빈 공간 검색을 방지하기 위해 다른 적절한 pair를 빈 공간으로 옮겨야함

  ![Screenshot 2023-08-09 at 11.41.26 AM.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/8ed00658-aa04-4688-af36-108057e9737d/Screenshot_2023-08-09_at_11.41.26_AM.png)


### **Quadratic Probing**

- 충돌이 발생한 인덱스부터 빈 버킷을 찾을때까지 $1^2$, $2^2$, $3^2$… 칸씩 이동하며 탐색하는 방식
- Cache hit rate는 나쁘지 않으며, clustering도 어느 정도 회피 가능함
- 하지만, 해시 값이 같은 경우 여전히 clustering이 발생함

![Screenshot 2023-08-08 at 3.22.23 PM.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/fda6223b-12ca-4f1f-969d-2d4629c9895a/Screenshot_2023-08-08_at_3.22.23_PM.png)

### **Double Hashing**

- 충돌 발생 시 이동할 칸 수를 또 다른 해시 함수로 계산하여 빈 버킷을 탐색하는 방식
- Clustering을 효과적으로 회피할 수 있지만, 구현이 복잡하고 cache hit rate가 매우 나쁨

![Screenshot 2023-05-07 at 11.14.24 AM.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/ebb97290-0eef-43fd-b76c-d2cb77d7fa71/Screenshot_2023-05-07_at_11.14.24_AM.png)

# Swift

## `Dictionary`

- Key-value pair를 저장하는 해시 테이블 기반의 자료구조
- 딕셔너리의 key는 `Hashable` 프로토콜을 채택한 타입이어야 함
- Open addressing의 linear probing 방식을 사용해 해시 충돌을 해결함

```swift
var responseMessages = [
    200: "OK",
    403: "Access forbidden",
    404: "File not found",
    500: "Internal server error"
]
```

# 구현

- tbd

# 예제

- [BOJ 7785 회사에 있는 사람](https://www.acmicpc.net/problem/7785)
- [BOJ 1620 나는야 포켓몬 마스터 이다솜](https://www.acmicpc.net/problem/1620)

# 과제

- 본인이 사용하는 언어에서는 해시 충돌을 어떤 방식으로 처리하는지 찾아보세요.

https://d2.naver.com/helloworld/831311

# Hash 정리
map => 딕셔너리친구
map이 table보다 성능이 더 좋다고 한다
openAddressing => linear, quadratic


seperateChaging => 연결리스트  => 자바에서는 이거 사용함
이유=> 
1.데이터가 많이 질수록 L1,L2 캐시효율이 낮아져서 openaddressing의 장점이 사라진다 
2.openaddressing은 데이터 찾기가 어려워(동일한거 나오면 계속 밀린다) remove호출시 효율낮다
3.키값 개수가 일정개수이상 많아지면 느리다 =>버킷 밀도가 높으면 worst case 발생빈도가 높다
4.separtingChaining은 해시충돌 안나게 조정하면 worstcase 줄일 수 있다


SeperatingChainging 알고리즘
=> 데이터가 많아지면 링크드리스트 대신 트리를 사용
=> 6개 이하면 링크리스트, 8개 이상이면 트리

웹 애플리케이션 서버의 경우 HTTPRequest가 생성될때 여러개의 hashmap이 생성된다고한다
이 hashmap들이 1초동안되는 시간에 생성되었다가 바로 GC의 대상이 된다고 하는 것을 보면 
서버(java)에서 hashmap의 발전은 필수인 듯 하다


    구현해야할 항목
1.버킷 => Entry[]
2.put => Entry리스트 순회
3.seperateChanging(노드) => 임계값 기준으로 연결리스트 아니면 트리구조
4.해시버킷확장=> 넘으면 다시 해시 설정
5.보조해시함수...?=>M(테이블 크기) 값이 소수일 떄 가장 균등해진다고 하는데 항상 소수일 수 없으므로 보조 해시함수를 통해 키의 해시값을 변형하여 해시 충돌 가능성을 줄인다
6.숫자 & 문자 따로 만들어줘야함


transient 키워드는 Java 직렬화 과정에서 해당 변수를 무시하고 직렬화에서 제외시키는 역할을 합니다.

궁금한 것
버킷의 인덱스? map에 인덱스가 있나?


