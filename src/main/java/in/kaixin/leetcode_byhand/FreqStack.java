package in.kaixin.leetcode_byhand;

import java.util.*;

public class FreqStack {
    //    https://leetcode-cn.com/problems/maximum-frequency-stack/
    Map<Integer, List<Integer>> freqToValueMap = null;
    Map<Integer, Integer> valToFre = null;
    Stack<Integer> stack = null;
    int maxFreq = 0;

    public FreqStack() {
        this.freqToValueMap = new HashMap<>();
        this.valToFre = new HashMap<>();
        this.stack = new Stack<>();
    }

    public void push(int val) {
        Integer freq = valToFre.getOrDefault(val, 0) + 1;

        if (freq > maxFreq) {
            maxFreq = freq;
        }

        valToFre.put(val, freq);
        List<Integer> list = freqToValueMap.get(freq);
        if (list == null) {
            list = new LinkedList<>();
            freqToValueMap.put(freq, list);
        }

        list.add(val);
    }

    public int pop() {
        List<Integer> list = freqToValueMap.get(maxFreq);
        Integer v = list.remove(list.size() - 1);
        if (list.size() == 0) {
            freqToValueMap.remove(maxFreq);
            maxFreq--;
        }
        Integer freq = valToFre.get(v);
        if (freq <= 1) {
            valToFre.remove(v);
        } else {
            valToFre.put(v, freq - 1);
        }
        return v;

    }

    public static void main(String... args) {
        FreqStack freqStack = new FreqStack();
        freqStack.push(5);
        freqStack.push(1);
        freqStack.push(2);
        freqStack.push(5);
        freqStack.push(5);
        freqStack.push(5);

        freqStack.push(1);
        freqStack.push(6);
        freqStack.push(1);
        freqStack.push(5);


        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
    }

}
