1. Entry 사용이 안되는데? -> 이것도 선언, 편집 공부해야된다

2. 일단 Comparator사용한다 -> Comparator도 추가 공부필요하다 
   1. 람다식 말고 그냥하는법 알아야됨, 같을때 정렬해야됨 -> 추가공부 필요
3. Map 자체를 정렬할 필요는 없는 건가? 그런듯 굳이 라는 생각이 들긴함 -> map이 정렬을 위한 요소 인가


# 방법 
1. keyset -> map value로 정렬한 다음 출력
~~~java
List<String> key_list = new ArrayList<>(key);

        // 이거 람다식말고
        key_list.sort((v1,v2) -> map.get(v2) - map.get(v1));
        System.out.println(key_list);

        for(String s : key_list){
            System.out.println("key: " +s + "값: "+map.get(s));
        }
~~~


2. entryset 
1. entry.sort(Map.Entry.comparingByValue())
~~~java
// Entry
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());

        entryList.sort(Map.Entry.comparingByValue());
        System.out.println(entryList);

~~~

2. Comoarator 
~~~java
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort((v1, v2) -> v2.getValue() - v1.getValue());
        System.out.println(entryList);
~~~

// 이거 타입 왜 앞에 넣어야되는지 모르겠네 
명시적 지정한 코드:
java
코드 복사
entryList.sort(Map.Entry.<String, Integer>comparingByValue().reversed());
이 코드는 Map.Entry의 제네릭 타입을 명시적으로 지정하여 타입 추론 문제를 피합니다. 여기서 <String, Integer>는 Map.Entry의 키와 값의 타입을 명시적으로 지정하는 역할을 합니다.