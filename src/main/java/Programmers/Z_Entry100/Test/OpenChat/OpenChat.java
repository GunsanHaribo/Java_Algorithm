package Programmers.Z_Entry100.Test.OpenChat;

import java.util.*;



// 정적 팩토리 메서드 써보기

public class OpenChat {
    public static void main(String[] args) {
        repository rep = repository.create_repository();

//        repository rep = new repository();
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        //레코드 토큰 분해



        StringTokenizer st ;
        for(String i : record){
            st = new StringTokenizer(i);
            String command= st.nextToken();
            String uid = st.nextToken();
//            System.out.println(uid);
            if(!command.equals("Leave")){

            String nickname = st.nextToken();
                if(command.equals("Enter") || command.equals("Change")){
                    rep.Enter(uid, nickname);
                }
            }



        }
        List<String> answer = new ArrayList<>();

        for(String i : record){
            st = new StringTokenizer(i);
            String command= st.nextToken();
            String uid = st.nextToken();
//            String nickname = st.nextToken();

            if(command.equals("Enter")){
                String se = rep.get_nickname(uid)+"님이 들어왔습니다.";
                answer.add(se);
            }else if(command.equals("Leave")){
                String se = rep.get_nickname(uid)+"님이 나갔습니다.";
                answer.add(se);
            }
        }
        System.out.println(answer);


    }
}

class repository{
//    String uid;
//    String nick_name;
    static Map<String,String> store = new HashMap<>();
    private repository(){}

    public static repository create_repository(){
        return new repository();
    }

    // Enter나 Change시 맞는 uid 찾아서 바꿔준다
    public void Enter(String uid, String nickname){
        store.put(uid, nickname);
    }
    public String get_nickname(String uid){

        return store.get(uid);
    }

}

