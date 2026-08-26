import java.util.*;

class Solution {

    class Edge {
        int to;
        int type; // a, b, c인데 1, 2, 3으로 치환

        Edge(int to, int type) {
            this.to = to;
            this.type = type;
        }
    }

    int n;
    List<List<Edge>> graph;
    int k;
    int maxInfected = 0;

    public int solution(int n, int infection, int[][] edges, int k) {
        this.n = n;
        this.k = k;

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int t = e[2];
            graph.get(u).add(new Edge(v, t));
            graph.get(v).add(new Edge(u, t));
        }

        maxInfected = 0;
        dfs(infection, new int[0]);

        return maxInfected;
    }

    private void dfs(int startNode, int[] seq) {
        if (seq.length == k) {
            simulate(startNode, seq);
            return;
        }

        for (int t = 1; t <= 3; t++) {
            int[] next = Arrays.copyOf(seq, seq.length + 1);
            next[seq.length] = t;
            dfs(startNode, next);
        }
    }

    void simulate(int startNode, int[] seq) {
        boolean[] infected = new boolean[n + 1];
        infected[startNode] = true;

        for (int type : seq) {
            infected = bfsSpread(infected, type);
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (infected[i]) {
                count++;
            }
        }

        maxInfected = Math.max(maxInfected, count);
    }

    boolean[] bfsSpread(boolean[] infected, int type) {
        boolean[] nextInfected = infected.clone();
        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            if (infected[i]) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (Edge e : graph.get(cur)) {
                if (e.type != type) {
                    continue;
                }
                if (nextInfected[e.to]) {
                    continue;
                }

                nextInfected[e.to] = true;
                q.add(e.to);
            }
        }

        return nextInfected;
    }
}
