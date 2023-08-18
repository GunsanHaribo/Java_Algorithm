package week15_Hash;

import java.io.*;
import java.util.*;



public class baekjoon_7785_회사에있는사람 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int max_number = Integer.parseInt(br.readLine());

        HashMap<String, String> company_attend = new HashMap<>(max_number);

        StringTokenizer st;
        for(int i=0; i<max_number; i++){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String attend = st.nextToken();
            if(attend.equals("enter")){
                company_attend.put(name, attend);
            }else{
                company_attend.remove(name);
            }

        }

        List<String> keySet = new ArrayList<>(company_attend.keySet());
        keySet.sort(Collections.reverseOrder());

//        Collections.sort(keySet, (o1, o2) -> String.compare( company_attend.get(o2), company_attend.get(o1) ) );

        for (String key : keySet) {
            bw.append(key+"\n");
//            System.out.println(", Val : " + company_attend.get(key));
        }

        bw.close();

    }
}
