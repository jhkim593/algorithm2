import java.util.*;

class Solution {
    int picksSize = 0;
    int min = Integer.MAX_VALUE;
    Set<String> set = new HashSet<>();

    public int solution(int[] picks, String[] minerals) {
        for (int i : picks) {
            picksSize += i;

        }

        dfs(picks, "");
        check(minerals);


        return min;
    }

    void dfs(int[] picks, String ori) {
        if (ori.length() == picksSize) {
            set.add(ori);
        }
        for (int i = 0; i < picks.length; i++) {
            if (picks[i] != 0) {
                String newOri = ori;
                if (i == 0) {
                    newOri += "d";
                } else if (i == 1) {
                    newOri += "i";
                } else {
                    newOri += "s";
                }
                int[] newPicks = picks.clone();
                newPicks[i]--;
                dfs(newPicks, newOri);
            }
        }

    }

    void check(String[] minerals) {
        for (String str : set) {
            int count = 0;
            int idx = 0;
            int score = 0;
            for (int i = 0; i < minerals.length; i++) {
                count++;
                //곡괭이가 다이아일때
                if (str.charAt(idx) == 'd') {
                    score += 1;
                }
                //철일때
                else if (str.charAt(idx) == 'i') {
                    if (minerals[i].equals("diamond")) {
                        score += 5;
                    } else {
                        score += 1;
                    }
                }
                //돌일때
                else {
                    if (minerals[i].equals("diamond")) {
                        score += 25;
                    } else if (minerals[i].equals("iron")) {
                        score += 5;
                    } else {
                        score += 1;
                    }

                }
                if (count % 5 == 0) {
                    idx++;
                    //더 사용할 곡괭이없을때
                    if (idx == str.length()) {
                        break;
                    }
                }
            }
            if (min > score) {
                min = score;
            }
        }

    }
} 
