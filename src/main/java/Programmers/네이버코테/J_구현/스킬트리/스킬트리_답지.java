package Programmers.네이버코테.J_구현.스킬트리;

import java.util.Arrays;

public class 스킬트리_답지 {
    public static void main(String[] args) {
        String skill = "CBD";
        String[] skillTrees = new String[]{"BACDE", "CBADF", "AECB", "BDA"};


        System.out.println(recursive(skillTrees,skill));
    }
    public static int recursive(String[] skillTrees, String skill){
        return (int) Arrays.stream(skillTrees)
                .map(s -> s.replaceAll("[^" + skill+ "]", ""))
                .filter(skill::startsWith)
                .count();
    }

}
