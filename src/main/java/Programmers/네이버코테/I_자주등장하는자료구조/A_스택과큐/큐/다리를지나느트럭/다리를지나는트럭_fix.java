package Programmers.네이버코테.I_자주등장하는자료구조.A_스택과큐.큐.다리를지나느트럭;

//import Vacation.week3_Queue_Deque.Queue;

import java.util.LinkedList;
import java.util.Queue;

//
public class 다리를지나는트럭_fix {
    public static void main(String[] args) {

        int bridge_length = 2;
//        int bridge_length = 100;
//        int bridge_weight = 100;
        int bridge_weight = 10;
        int[] truck_weight = new int[]{7,4,5,6};
//        int[] truck_weight = new int[]{10, 10,10,10,10,10,10,10,10,10};
        Queue<TruckCount> waiting_truck = new LinkedList<>();
        for(int i : truck_weight){
            TruckCount trC = new TruckCount(i);
            waiting_truck.add(trC);
        }

        Queue<TruckCount> Bridge = new LinkedList<>();



        int time = 0;
        // 아니면 0으로 두고 time으로 하던가
        // 둘다 비지 않았으면 시작 // 둘다 비었으면 stop
        int current_truckTotal_onbridge = 0;
        // int possible_BridgeWeight_total = bridge_weight;
        int depart_count = 0;
        // 어 이거 무한루프 각인데;;

        while(true){
            time++;  // 동작시작

            // 2-0이면 아직 안지났고 3-0이여야 지난 것으로 간주

            // time 3일때 나오게 해야된다  0초에 들어가면 1초떄는 건너고 있고 2초떄도 건너고 있고 3초때 나오는게 맞는데
            // 이게 의미가 살짝 변질 되듯하는게 문제인 것 같은데 0초에는 그러면 지금 아무도 못 들어가는건데
            if(!Bridge.isEmpty()){
                int current_truck_recordedTime = Bridge.peek().bridge_entry_specificTime;
                // 여기를 못들어 와서 못빠지는 것 같은데

                // 2-0 =2 => 사이 숫자라고하면 3이 나오는게 맞긴한데
                // 2일때 내려가는게 맞나? 내생각은 3일때 가는게 3-0 -> 아웃, 근데 2이면  //
                if((time - current_truck_recordedTime+1) > bridge_length){
                    TruckCount removeTruck = Bridge.poll();
                    current_truckTotal_onbridge -= removeTruck.truck_weight; // 아근데 이게 앞에 있어야 다른 트럭들이 올라갈듯
                    // 트럭 나간개수
                    depart_count ++;

//                    // 나 나갔으면 time++ 한다  -> 여기도 조금 이상한데
//                    if(depart_count == truck_weight.length) {
//                        time++;
//                        System.out.println("시점 :"+ time+ " waiting_truck : "+ waiting_truck +" Bridge:"+ Bridge);
//                        break;  // 이게 있어서 중간에 끝나서 그럼 미안
//                    }
                }

            }


            // 다리에 삽입  => 여기 로직이 조금 꼬였네... 이걸 어떻게 개선하지?
            if(!waiting_truck.isEmpty()){
                int current_truck_weight = waiting_truck.peek().truck_weight;

                // 이걸 왜하는거야?
                int Brigde_first_truck_weight = 0;
//                if(!Bridge.isEmpty()){
//                    // 여기도 좀 이상한데
//                    // total이랑 분리되야 될 것 같은데
//                    Brigde_first_truck_weight = Bridge.peek().truck_weight;
////                    current_truckTotal_onbridge = Bridge.peek().truck_weight;
//                }
                // 현재 다라의 무게 체크 후 다리에 트럭 올리기
                // 근데 아니면 이거 뱉어야 되는데 그냥 계산을 해버리네;;

                // 이게 지금 실제 다리에 올라간 트럭 값은 유지를 해야되거든 // 이게 작아야만 뺄수있는 값이라;;
                int possible_BridgeWeight = bridge_weight - current_truckTotal_onbridge;

                // 여기서  null point dksksdhrp 일단 다 뽑혔다
                if(possible_BridgeWeight >= current_truck_weight){

                    // 올라가는 트럭에 시점 추가
                    TruckCount realcurrent_truck = waiting_truck.poll();
                    System.out.println("트럭무게:"+ realcurrent_truck.truck_weight);
                    realcurrent_truck.set_bridge_entry_specificTime(time);

                    // 다리에 남은 무게도 줄여줘야한다 => // 줄이지 말고 그떄 시점에서 계산 해야될듯
                    Bridge.add(realcurrent_truck);
                    // 현재 트런 total 무게에 추가한다
                    current_truckTotal_onbridge += realcurrent_truck.truck_weight;
                }

            }
            // 만약 대지 트럭 weight < 가능한 Bridgeweight 라면 트럭을 태운다
            // 그러면 트럭을 언제 내려야할까? while을 한번씩 돌때마다 => 트럭의 진행정도를 ++ 하면되는데 아 모르겠으니깐
            // 현재time - 트럭 time => 해서 bride length를 초과하면

            System.out.println("시점 :"+ time+ " waiting_truck : "+ waiting_truck +" Bridge:"+ Bridge);

//            System.out.println(time);
//            System.out.println("시점 :"+ time+ " waiting_truck : "+ waiting_truck +" Bridge:"+ Bridge);
            if(depart_count == truck_weight.length) {
//              time++; 안씀
//                System.out.println("시점 :"+ time+ " waiting_truck : "+ waiting_truck +" Bridge:"+ Bridge);
                break;  // 이게 있어서 중간에 끝나서 그럼 미안
            }
        }


        System.out.println("시간: "+time);

    }

    static class TruckCount{
        int truck_weight ;
        int bridge_entry_specificTime;

        public TruckCount(int truck_weight){
            this.truck_weight = truck_weight;
//            this.bridge_entry_specificTime = bridge_entry_specificTime;
        }

        public void set_bridge_entry_specificTime(int x){
            bridge_entry_specificTime = x;
        }


        @Override
        public String toString() {
            return "truckCount{" +
                    "truck_weight=" + truck_weight +
                    ", bridge_entry_specificTime=" + bridge_entry_specificTime +
                    '}';
        }
    }


}
