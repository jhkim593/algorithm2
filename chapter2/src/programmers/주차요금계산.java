package programmers;

import java.util.*;

class 주차요금계산 {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        Map<String, Integer> map = new HashMap<>();
        Map<String, String> temp = new HashMap<>();
        Map<String, Integer> answerMap = new HashMap<>();
        for (String record : records) {
            String[] split = record.split(" ");
            String time = split[0];
            String number = split[1];
            // String type = split[2];
            if (temp.containsKey(number)) {
                //가격 처리
                int newTime = checkTime(temp.get(number), time);
                if (!map.containsKey(number)) {
                    map.put(number, newTime);
                } else {
                    map.put(number, map.get(number) + newTime);
                }
                temp.remove(number);
            } else
                temp.put(number, time);
        }
        //out 처리
        for (String number : temp.keySet()) {
            // answerMap.put(key,feeCheck(map,key,"23:59",fees));
            int newTime = checkTime(temp.get(number), "23:59");
            if (!map.containsKey(number)) {
                map.put(number, newTime);
            } else {
                map.put(number, map.get(number) + newTime);
            }
        }

        for (String number : map.keySet()) {
            System.out.println(number + "    " + map.get(number));
            answerMap.put(number, feeCheck(map.get(number), fees));
        }
        int[] arr = new int[answerMap.size()];
        List<String> list = new ArrayList<>(answerMap.keySet());
        Collections.sort(list);
        // Collections.sort(map);
        int index = 0;
        for (String key : list) {
            arr[index] = answerMap.get(key);
            index++;
        }
        return arr;

    }

    public int feeCheck(int totalTime, int[] fees) {
        int basicTime = fees[0]; //기본시간 분
        int basicFee = fees[1]; //기본 요금
        int calcTime = fees[2]; //단위시간분
        int calcFee = fees[3]; //단위 요금

        //기본 시간안쪽일때
        if (totalTime <= basicTime) {
            return basicFee;
        } else {
            int op = (totalTime - basicTime) / calcTime;
            double d = (totalTime - basicTime) % calcTime;
            if (d != 0) {
                op++;
            }
            if (op == 0) {
                op = 1;
            }
            return basicFee + (op) * calcFee;
        }
    }

    public int checkTime(String inTime, String outTime) {
        //시간 계산 (분)
        String[] splitOutTime = outTime.split(":");
        String[] splitInTime = inTime.split(":");

        int hour = Integer.parseInt(splitOutTime[0]) - Integer.parseInt(splitInTime[0]);
        int min = 0;
        if (Integer.parseInt(splitOutTime[1]) < Integer.parseInt(splitInTime[1])) {
            hour--;
            min = (60 - Integer.parseInt(splitInTime[1])) + Integer.parseInt(splitOutTime[1]);
        } else {
            min = Integer.parseInt(splitOutTime[1]) - Integer.parseInt(splitInTime[1]);
        }
        return hour * 60 + min;
    }
}