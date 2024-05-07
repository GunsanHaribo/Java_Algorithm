package Programmers.Z_Entry100;

public class 옹알이 {
    // length로 처리
    public static void main(String[] args) {

        //4개 중 하나
        //"aya", "ye", "woo", "ma"  이거라면
//        ["aya", "yee", "u", "maa", "wyeoo"]
//        여기서 aya, yee라면 aya, ye 인데 2개 아닌가 발음할 수 있는게
        // aya, ye....시발  이해가 안되나한번씩만 등장하는데
        // woo wo 같이.. 하나만 해야 된다
        //aya가 한번씩 등장해야 된다 그니깐 문자열의 조합이 발음할 수 있는 집합내에 있는 것의 조합이여하한다
        //이걸 어떻게 알아 // 문자열이 가능한 조합으로 이루어져 있는지 체크해야 한다
        //문자하나를 보고 aya랑 ye가 포함 되어 있으면 패스?
        // 아니면 가능한 조합을 만들어서? => 이건 아니다
        //

        String dd = "ayaye";
        String sub = "aya";

        // 뺴는거 안되고 그럼 더해서 해야하나 다 구하고 하면 조금 무린것 같은데 합쳤을떄 다른게 나올 수 도 있고
        // aya, ye , woo, ma 근데 aya ye라aus aya ye ,  ye aya 일 수 도 있고 살짝 경우의 수가 다양하다
        // ye, + aya 시발 y다음에 e가 있으면 체크해야되나?
        // subString?으로 근데 문자열을 찾을 수 있나?
        // 부분 문자열을 어떻게 나눠야 하는가

        String[] canSpeak = new String[]{"aya", "ye", "woo", "ma"};
//        String[] given = new String[]{"aya", "yee", "u", "maa", "wyeoo"};

        String[] given = new String[]{"ayaye", "uuuma", "ye", "yemawoo", "ayaa"};


        // canSpeak를 포함하고 있으면 일단 분류
        // 아예 같은 문자이면 count = 1 올리고
        // 포함하고 있는데 다른 문자열들이 canSpeak에 없는 문자이면 실패
        // 여기서 그러면 다른 문자열 들임을 어떻게 아는가
        // 문자열 length로 체크? => 5 length 문자인데 3개가 aya인데 2개가 can Speak에 속하지 않는 문자 이면 실패
        // 그니깐 (문자별로 length를 세고) (canSpeak에 있는 문자이면) length에서 제외하고 그 length 가 0이 되면 전체 count를 1올린다

        int count = 0;

        for(String m : given){
            int strlen = m.length();

            for(String c : canSpeak){
                if(m.contains(c)){
                    strlen -= c.length();
                };

            }
            if(strlen == 0){
                count +=1;
            }
        }

        System.out.println(count);



    }
}
