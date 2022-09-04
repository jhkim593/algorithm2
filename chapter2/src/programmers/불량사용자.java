package programmers;

import java.util.*;

class 불량사용자 {
    Set<String> answer = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {
        List<List<String>> list = new ArrayList<>();

        for (String banId : banned_id) {
            String[] splitBanId = banId.split("");
            // searchId(temp,user_id);
            List<String> tempList = new ArrayList<>();
            user:
            for (String userId : user_id) {
                String[] splitUserId = userId.split("");
                if (splitBanId.length != splitUserId.length) {
                    continue;
                }


                for (int i = 0; i < splitBanId.length; i++) {
                    if (!splitBanId[i].equals("*")) {
                        if (!splitBanId[i].equals(splitUserId[i])) {
                            continue user;
                        }
                    }
                }
                tempList.add(userId);
            }
            list.add(tempList);
        }
        List<String> temp = new ArrayList<>();
        search(temp, list);


        return answer.size();
    }

    public void search(List<String> temp, List<List<String>> list) {
        if (temp.size() == list.size()) {
            Collections.sort(temp);
            String answerStr = "";
            for (String str : temp) {
                answerStr += str;
            }
            answer.add(answerStr);
            return;
        }
        List<String> array = list.get(temp.size());
        for (int i = 0; i < array.size(); i++) {
            if (!temp.contains(array.get(i))) {
                List<String> newTemp = new ArrayList<>();
                for (String tempStr : temp) {
                    newTemp.add(tempStr);
                }
                newTemp.add(array.get(i));
                search(newTemp, list);
            }
        }
    }
}
