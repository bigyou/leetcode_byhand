//package in.kaixin.leetcode_byhand.other;
//
//import com.alibaba.fastjson.JSON;
//
//import java.util.*;
//
//public class ExclusiveTime {
//    //TODO
//    //    https://leetcode.cn/problems/exclusive-time-of-functions/description/
//    //    public int[] exclusiveTime(int n, List<String> logs) {
////        int[] processArr = new int[n];
////        for (int i = 0; i < processArr.length; i++) {
////            processArr[i] = -1;
////        }
////        int[] ret = new int[n];
////        for (int i = 0; i < logs.size(); i++) {
////            String log = logs.get(i);
////            String[] info = log.split(":");
////            int threadNo = Integer.parseInt(info[0]);
////            String process = info[1];
////            int time = Integer.parseInt(info[2]);
////            if ("start".equals(process)) {
////                processArr[threadNo] = time;
////            } else if ("end".equals(process)) {
////                int cost = time - processArr[threadNo] + 1;
////                processArr[threadNo] = -1;
////                ret[threadNo] += cost;
////            }
////
////        }
////        return ret;
////
////    }
////    public int[] exclusiveTime(int n, List<String> logs) {
////        int[] ret = new int[n];
////        int preStart = 0;
////        int preThreadNo = -1;
////        for (String str : logs) {
////            String[] info = str.split(":");
////            int threadNo = Integer.parseInt(info[0]);
////            String process = info[1];
////            int time = Integer.parseInt(info[2]);
////            if ("start".equals(process)) {
////                if (preThreadNo != -1) {//第一条记录
////                    int cost = time - preStart;
////                    ret[preThreadNo] += cost;
////                }
////                preThreadNo = threadNo;
////                preStart = time;
////            } else if ("end".equals(process)) {
////                int cost = time - preStart + 1;
////                ret[threadNo] += cost;
////                preStart = time + 1;
////                preThreadNo = -1;
////            }
////        }
////        return ret;
////    }
////    public int[] exclusiveTime(int n, List<String> logs) {
////        int[] res = new int[n];
////        Stack<PrcessInfo> stack = new Stack<>();
////        long currentT = -1;
////        for (String str : logs) {
////            PrcessInfo info = parse(str);
////            PrcessInfo peek = stack.peek();
////            if ("start".equals(info.getProcessStatus())) {
////                stack.push(info);
////                currentT = info.getT();
////                if (peek == null) {
////
////                } else {
////                    if (peek.getTrdNo() == info.getTrdNo()) {//同现成递归调用
////
////                    } else {
////
////                    }
////                }
////
////            } else if ("end".equals(info.getProcessStatus())) {
////                if (peek.getTrdNo() == info.getTrdNo()) {
////                    PrcessInfo pop = stack.pop();
////                    res[peek.getTrdNo()] += info.getT() - pop.getT() + 1;
////                    currentT = info.getT() + 1;
////                } else {
////
////                }
////
////
////            }
////
////
////        }
////
////    }
//    public int[] exclusiveTime(int n, List<String> logs) {
//        int[] res = new int[n];
//        long currentT = -1;
//        PrcessInfo preInfo = null;
//        for (int i = 0; i < logs.size(); i++) {
//            PrcessInfo info = parse(logs.get(i));
//            if (i == 0) {//第一条记录
//
//
//            } else {//不是第一条
//                if ("start".equals(preInfo)) {
//                    if (preInfo.getTrdNo() == info.getTrdNo()) {
//
//
//
//
//                    }else { //start -> start
//
//
//
//
//                    }
//
//                }
//
//
//            }
//
//
//        }
//    }
//
//    public PrcessInfo parse(String str) {
//        String[] info = str.split(":");
//        int threadNo = Integer.parseInt(info[0]);
//        String process = info[1];
//        long time = Long.parseLong(info[2]);
//        ExclusiveTime.PrcessInfo processInfo = new PrcessInfo();
//        processInfo.setT(time);
//        processInfo.setProcessStatus(process);
//        processInfo.setTrdNo(threadNo);
//        return processInfo;
//    }
//
//    class PrcessInfo {
//        int trdNo;
//        String processStatus;
//        Long t;
//
//        public int getTrdNo() {
//            return trdNo;
//        }
//
//        public void setTrdNo(int trdNo) {
//            this.trdNo = trdNo;
//        }
//
//        public String getProcessStatus() {
//            return processStatus;
//        }
//
//        public void setProcessStatus(String processStatus) {
//            this.processStatus = processStatus;
//        }
//
//        public Long getT() {
//            return t;
//        }
//
//        public void setT(Long t) {
//            this.t = t;
//        }
//    }
//
//    public static void main(String... args) {
//        ExclusiveTime time = new ExclusiveTime();
//        List<String> list = new ArrayList<String>() {
//        };
//        list.add("0:start:0");
//        list.add("0:start:2");
//        list.add("0:end:5");
//        list.add("1:start:7");
//        list.add("1:end:7");
//        list.add("0:end:8");
//        int[] ints = time.exclusiveTime(2, list);
//        System.out.println(JSON.toJSON(ints));
//    }
//}
