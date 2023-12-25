package solutions.amazon;

import java.util.*;

/**
 * 210 Course Schedule 2
 * Keywords: Directed Graph, Topological Sorting
 * Difficulty: Medium
 * Company: TikTok, Amazon, Google, Apple, Microsoft
 */
public class _210CourseSchedule2 {

    private boolean hasCycle;
    private List<Integer> proOrders;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = buildGraph(numCourses, prerequisites);
        boolean[] visited = new boolean[numCourses];
        boolean[] onPath = new boolean[numCourses];
        proOrders = new ArrayList<>();
        for(int course = 0; course < numCourses; course++){
            dfs(graph,visited,onPath,course);
        }
        if(hasCycle){
            return new int[]{};
        }
        Collections.reverse(proOrders);
        int[] result = new int[proOrders.size()];
        for(int i = 0; i < proOrders.size(); i++){
            result[i] = proOrders.get(i);
        }
        return result;
    }

    private List<List<Integer>> buildGraph(int numCourses, int[][] prerequisites){
        List<List<Integer>> graph = new ArrayList<>(numCourses);
        for(int v = 0; v < numCourses; v++){
            List<Integer> v_adjacency = new ArrayList<>();
            graph.add(v,v_adjacency);
        }
        for(int[] edge : prerequisites){
            int from = edge[1], to = edge[0];
            graph.get(from).add(to);
        }
        return graph;
    }

    private void dfs(List<List<Integer>> graph, boolean[] visited, boolean[] onPath, int v){
        if(onPath[v]){
            hasCycle = true;
        }
        if(visited[v] || hasCycle){
            return;
        }
        visited[v] = true;
        onPath[v] = true;
        for(int adjacency: graph.get(v)){
            dfs(graph,visited,onPath,adjacency);
        }
        onPath[v] = false;
        proOrders.add(v);
    }

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {
                {1,0},
                {0,1},
                //{3,1},
                //{3,2},
        };
        _210CourseSchedule2 s = new _210CourseSchedule2();
        int[] order = s.findOrder(numCourses, prerequisites);
        System.out.println("order = " + Arrays.toString(order));
    }
}
