package in.kaixin.leetcode_byhand.other;

import java.util.*;

public class FindAllPeoplefindAllPeople {
//    //    https://leetcode.cn/problems/find-all-people-with-secret/?envType=daily-question&envId=2025-12-19

    /// /    hard
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        //处理数据将会议信息转换成很map
        Map<Integer, Map<Integer, Set<Integer>>> map = preProcessData(meetings);
        Set<Integer> know = process(map, firstPerson);
        return new ArrayList<>(know);
    }

    public Set<Integer> process(Map<Integer, Map<Integer, Set<Integer>>> map, int firstPerson) {
        Integer[] meetingTimes = map.keySet().toArray(new Integer[0]);
        Arrays.sort(meetingTimes);
        Set<Integer> knowPeopleSet = new HashSet<>();
        knowPeopleSet.add(0);
        knowPeopleSet.add(firstPerson);
        for (Integer t : meetingTimes) {
            Map<Integer, Set<Integer>> tTimeMeetings = map.get(t);

            tTimeMeetings.keySet().forEach(i -> {
                if (knowPeopleSet.contains(i)) {
                    dfsfind(knowPeopleSet, tTimeMeetings, i);
                }
            });


        }
        return knowPeopleSet;

    }

    public void dfsfind(Set<Integer> knowPeopleSet, Map<Integer, Set<Integer>> tTimeMeetingPeople, int know) {
        Set<Integer> meetWihtKnow = tTimeMeetingPeople.get(know);
        if (meetWihtKnow == null || meetWihtKnow.isEmpty()) {
            return;
        }
        knowPeopleSet.addAll(meetWihtKnow);
        tTimeMeetingPeople.put(know, null);
        meetWihtKnow.forEach(j -> {
            dfsfind(knowPeopleSet, tTimeMeetingPeople, j);
        });


    }

    public Map<Integer, Map<Integer, Set<Integer>>> preProcessData(int[][] meetings) {
        Map<Integer, Map<Integer, Set<Integer>>> map = new HashMap<>();
        for (int[] meeting : meetings) {
            int time = meeting[2];
            int x = meeting[0];
            int y = meeting[1];
            Map<Integer, Set<Integer>> mettingInfo = map.get(time);
            if (mettingInfo == null) {
                mettingInfo = new HashMap<>();
                map.put(time, mettingInfo);
            }
            Set<Integer> xmeetsSet = mettingInfo.get(x);
            if (xmeetsSet == null) {
                xmeetsSet = new HashSet<>();
                mettingInfo.put(x, xmeetsSet);
            }
            xmeetsSet.add(y);

            Set<Integer> ymeetsSet = mettingInfo.get(y);
            if (ymeetsSet == null) {
                ymeetsSet = new HashSet<>();
                mettingInfo.put(y, ymeetsSet);
            }
            ymeetsSet.add(x);
        }
        return map;
    }

}

