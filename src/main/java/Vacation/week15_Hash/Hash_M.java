package Vacation.week15_Hash;


//    구현해야할 항목
//1.버킷 => Entry[](entry는 링크드리스트)
//2.put => Entry리스트 순회
//3.seperateChanging(노드) => 임계값 기준으로 연결리스트 아니면 트리구조
//4.해시버킷확장=> 넘으면 다시 해시 설정
//5.보조해시함수...?=>M(테이블 크기) 값이 소수일 떄 가장 균등해진다고 하는데 항상 소수일 수 없으므로  => 구현 ㄴㄴ
//보조 해시함수를 통해 키의 해시값을 변형하여 해시 충돌 가능성을 줄인다=> java8이상에서는 트리사용해서 충돌이 적게 발생해 잘 안쓴다고함
//숫자 & 문자 따로 만들어줘야함

//구현은  1, 2, 3, 4 까지만  + get

import java.util.*;


public class Hash_M<K,V> {

    //1. 일단 버킷은 테이블로 일단 링크드 리스트로 만든다
    //2. resize, transfer
    //노드 만들기// 그 노트를 일단 배열로만들어서 담는다
    //loadfactor 고려해야되나 모르겠음


    //Seperatingchanging을 위한 변수
    static class Node1<K, V> implements Map.Entry<K,V>{
        final int hash;
        final K key;
        V value;
        Node1<K,V> next;

        public Node1(int hash, K key, V value, Node1<K,V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        @Override
        public int hashCode() {
            //xor 연산으로 hashCode 반환
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
    //field
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16
    transient Node1<K,V>[] table;
    private int capacity;
    //##1.Construtor
    //필요한거 capacity
    //extends는 하위 타입만 받도록
    // 아직 load factor는 고려안한걸로
    //public인 것 만 보기
    //command click
    public Hash_M(int capacity) {
        Node1<K,V>[] newTable = (Node1<K,V>[])new Node1[capacity*2];
        table = newTable;
    }

    public Hash_M() {
        Node1<K,V>[] newTable = (Node1<K,V>[])new Node1[DEFAULT_INITIAL_CAPACITY*2];
        table = newTable;
    }

//    public Hash_M(int initialCapacity) {
//        this(initialCapacity, DEFAULT_LOAD_FACTOR);
//    }

    //##1. put 617
    public V put(K key, V value){ return putVal(hash(key), key, value);}


    //해시값이 같으면 그 뒤에 계속 추가하면 된다
    final V putVal(int hash, K key, V value){
        //처음 있는 hash
        Node1<K,V>[] tab = table;
        int n = (tab == null) ? 0 : tab.length;
        int i = (n - 1) & hash;
        Node1<K,V> p = table[i]; // 인자

        //그러면 해시 값이 값이 같을 떄는 어떻게 하지
        if (p == null) {//p에 아무 노드도 없을떄 => 새로운 노드 추가
            tab[i] = new Node1(hash, key, value, null);
        } else {
            //다른 노드가 있을떄 그리고 해시 값이 같을때
            //일단 후 작업을 위해 e를 p에 저장한다
            Node1<K,V> e; K k;
            if (p.hash == hash &&
                    ((k = p.key) == key || (key != null && key.equals(k))))
                e = p;
            else{
                //e있는지 찾을 떄까지 돌린다
                for (int binCount = 0; ; ++binCount) {
                    //해시값은 같은데 다음 값이 없으면 추가
                    if ((e = p.next) == null) {
                        p.next = new Node1(hash, key, value, null);
                        break;
                    }
                    //다음 hashdp 있으면 찾는다 찾아서
                    if (e.hash == hash &&
                            ((k = e.key) == key || (key != null && key.equals(k))))
                        break;
                    p = e; // 계속 e = p.next 이거 반영 다음 노드로
                }
            }

            //e값이 있을시
            if(e != null){
                V oldValue = e.value;
                if(oldValue ==null){
                    e.value = value;
                }
                return oldValue;
            }

        }

        return null;
    }
    //##2. remove 803
    public V remove(Object key) {
        //노드 반환인데 반환될것이 있으면 지우고 반환
        Node1<K,V> e;
        return (e = removeNode(hash(key), key, null)) == null ?
                null : e.value;
    }

    final Node1<K,V> removeNode(int hash, Object key, Object value){
        Node1<K,V>[] tab; Node1<K,V> p; int n, index;
        if ((tab = table) != null && (n = tab.length) > 0 &&
                (p = tab[index = (n - 1) & hash]) != null){
            Node1<K,V> node = null, e; K k; V v;

            // hash값에 바로 있으면 node에 적어 두기
            if (p.hash == hash &&
                    ((k = p.key) == key || (key != null && key.equals(k)))){
//                System.out.println("kkk");
                node = p;}
                    // 여기서 node가 p 여야한다
            //해시 값에 없으면 다음 노드로 가서 찾는다
            else if((e = p.next) != null){
                do {
                    if (e.hash == hash &&
                            ((k = e.key) == key ||
                                    (key != null && key.equals(k)))) {
                        node = e;
                        break;
                    }
                    p = e;
                } while ((e = e.next) != null);

            }
            //노드가 있을떄근데 값이null 일떄? 또는 null이 아니고  노드 valuev 랑 같을떄
            if (node != null){
//                (v = node.value) == value ||
//                        (value != null && value.equals(v)))) 조건 분석필요
//                System.out.println("ddd");
                if(node == p){ // 노드가 단 2개 일떄
                    tab[index] = node.next;
                }else{
                    p.next = node.next; //사이제외하고 이어준다
                }
                return node;
            }
        }
        return null;
    }

    public V get(Object key) {
        Node1<K,V> e;
        return (e = getNode(key)) == null ? null : e.value;
    }

    final Node1<K, V> getNode(Object key){
        Node1<K,V>[] tab; Node1<K,V> first, e; int n, hash; K k;
        //테이블 빈지 체크밑 인자 할당
        //여기선 P가 first랑 p랑 비슷한 느낌
        if ((tab = table) != null && (n = tab.length) > 0 &&
                (first = tab[(n - 1) & (hash = hash(key))]) != null) {
            if (first.hash == hash && // 첫번째 노드 체크
                    ((k = first.key) == key || (key != null && key.equals(k))))
                return first;
            if ((e = first.next) != null) { // 없으면 다음 걸로
                do {
                    if (e.hash == hash &&
                            ((k = e.key) == key || (key != null && key.equals(k))))
                        return e;
                } while ((e = e.next) != null);
            }

        }

        //없으면 null
        return null;
    }


    public static void main(String[] args) {
        Hash_M<Integer, String> test1 = new Hash_M<>();
        test1.put(1,"황");
        test1.put(2,"지");
        test1.put(3,"환");
        System.out.println("키1:"+test1.get(1));
        System.out.println("키1제거:"+test1.remove(1));// remove가 동작을 안함
        System.out.println("키1:"+test1.get(1));
        System.out.println("키2:"+test1.get(2));
        System.out.println("키3:"+test1.get(3));
    }

}
