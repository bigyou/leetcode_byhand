package in.kaixin.leetcode_byhand.graph;

import java.util.*;

public class GTravel {

    //    https://leetcode-cn.com/problems/all-paths-from-source-to-target/submissions/
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int to = graph.length - 1;
        List<Integer> steps = new LinkedList<>();
        steps.add(0);//需要添加第一个节点位置
        allPathsSourceTarget(graph, 0, to, steps);
        return res;
    }

    public void allPathsSourceTarget(int[][] graph, int from, int to, List<Integer> steps) {
        int[] options = graph[from];//可以选择的方式
        for (int i = 0; i < options.length; i++) {
            steps.add(options[i]);
            if (options[i] == to) {
                List<Integer> suc = new LinkedList<>();
                res.add(suc);
                suc.addAll(steps);
                steps.remove(steps.size() - 1);//将刚加入进去的点取出
                continue;
            }
            allPathsSourceTarget(graph, options[i], to, steps);
            steps.remove(steps.size() - 1);//我在这里忘记删除了
        }
    }

    public static void main(String[] args) {
        GTravel gTravel = new GTravel();
        int arr[][] = {{1, 2}, {3}, {3}, {}};
        gTravel.allPathsSourceTarget(arr);
    }
}
