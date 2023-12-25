package solutions.amazon;

import java.util.ArrayList;
import java.util.List;

/**
 * 207 Course Schedule
 * Keywords: directed graph
 * Difficulty: Medium
 * Company: Facebook, Amazon, Google, Apple, Microsoft
 */
public class _207CourseSchedule {

    private boolean isCycle = false;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = buildGraph(numCourses, prerequisites);
        boolean[] visited = new boolean[numCourses];
        boolean[] onPath = new boolean[numCourses];
        for(int v = 0; v < graph.size(); v++){
            dfs(graph, visited, onPath, v);
        }
        return !isCycle;
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

    private void dfs(List<List<Integer>> graph, boolean[] visited, boolean[] onPath, int from){
        if(onPath[from]){
            isCycle = true;
        }
        if(visited[from] || isCycle){
            return;
        }
        visited[from] = true;
        onPath[from] = true;
        for(int to : graph.get(from)){
            dfs(graph, visited, onPath, to);
        }
        onPath[from] = false;
    }


    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {
                {1,0},
                {0,1},
        };
        _207CourseSchedule s = new _207CourseSchedule();
        boolean canFinish = s.canFinish(numCourses, prerequisites);
        System.out.println("canFinish = " + canFinish);
    }
}
