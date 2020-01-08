package other;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wyc1856
 * @date 2020/1/8
 * @description 广度优先搜索、深度优先搜索
 **/
public class Search {

    public static void main(String[] args) {
        Graph graph = new Graph(8);
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);
        graph.addEdge(5, 7);
        graph.addEdge(6, 7);
        Search solution = new Search();
        System.out.println("广度优先搜索：");
        solution.bfs(graph, 0, 7);
        System.out.println("\n深度优先搜索：");
        solution.dfs(graph, 0, 7);
    }

    /**
     * 广度优先搜索-bfs(breadth-first-search)
     *
     * @param source
     * @param s
     * @param t
     */
    private void bfs(Graph source, int s, int t){
        if (s == t){
            return;
        }
        //记录被访问过的节点
        boolean[] visited = new boolean[source.size];
        visited[s] = true;
        //借助队列进行遍历
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        //记录节点的访问路径
        int[] pre = new int[source.size];
        Arrays.fill(pre, -1);
        //开始搜索
        while (!queue.isEmpty()){
            //队列队首元素出队
            Integer v = queue.poll();
            //遍历节点相关联的所有节点
            for (int i = 0; i < source.adj[v].size(); i++) {
                Integer q = source.adj[v].get(i);
                //节点未被访问过
                if (!visited[q]){
                    //记录访问路径
                    pre[q] = v;
                    if (q == t){
                        //搜索成功，打印搜索路径
                        print(pre, s, t);
                        return;
                    }
                    //更新访问标识
                    visited[q] = true;
                    //加入遍历队列
                    queue.add(q);
                }
            }
        }
    }


    /**
     * dfs需要用的的是否搜索成功的标识
     */
    private boolean found;

    /**
     * 深度优先搜索-dfs(depth-first-search)
     *
     * @param source
     * @param s
     * @param t
     */
    private void dfs(Graph source, int s, int t){
        found = false;
        if (s == t){
            return;
        }
        //记录被访问过的节点
        boolean[] visited = new boolean[source.size];
        visited[s] = true;
        //记录节点的访问路径
        int[] prev = new int[source.size];
        Arrays.fill(prev, -1);
        //递归搜索，回溯思想
        recurDfs(source, visited, prev, s, t);
        print(prev, s, t);
    }

    private void recurDfs(Graph source, boolean[] visited, int[] prev, int v, int t){
        if (found){
            //已经搜索成功就结束递归
            return;
        }
        if (v == t){
            //搜索成功，修改搜索成功标识，结束递归
            found = true;
            return;
        }
        //遍历节点相关联的所有节点
        for (int i = 0; i < source.adj[v].size(); i++) {
            Integer q = source.adj[v].get(i);
            //节点未被访问过
            if (!visited[q]){
                //记录访问路径
                prev[q] = v;
                //标记已访问
                visited[q] = true;
                //递归搜索
                recurDfs(source, visited, prev, q, t);
            }
        }
    }

    /**
     * 递归打印s->t的路径
     *
     * @param prev
     * @param s
     * @param t
     */
    private void print(int[] prev, int s, int t){
        if (prev[t] != -1 && t != s) {
            print(prev, s, prev[t]);
        }
        System.out.print(t + " ");
    }

    /**
     * 无向图
     */
    static class Graph {
        /**
         * 图内顶点个数
         */
        private int size;
        /**
         * 使用临接表存储节点的关系
         */
        private LinkedList<Integer> adj[];

        public Graph(int size) {
            this.size = size;
            adj = new LinkedList[size];
            for (int i = 0; i < size; i++) {
                adj[i] = new LinkedList<>();
            }
        }

        /**
         * 添加s-t关系
         *
         * @param s
         * @param t
         */
        public void addEdge(int s, int t){
            adj[s].add(t);
            adj[t].add(s);
        }
    }
}
