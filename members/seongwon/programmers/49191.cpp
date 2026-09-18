#include <string>
#include <vector>
#include <algorithm>

using namespace std;

void dfs(int cur, const vector<vector<int>>& graph, vector<bool>& visited) {
    visited[cur] = true;
    for (int nxt : graph[cur]) {
        if (!visited[nxt]) {
            dfs(nxt, graph, visited);
        }
    }
}

int solution(int n, vector<vector<int>> results) {
    int answer = 0;
    vector<vector<int>> edge(n+1);
    vector<vector<int>> reversed_edge(n+1);
    
    for (auto& e : results) {
        edge[e[0]].push_back(e[1]);
        reversed_edge[e[1]].push_back(e[0]);
    }
    
    for (int i = 1; i <= n; i++) {
        vector<bool> visited(n+1, false);
        dfs(i, edge, visited);
        dfs(i, reversed_edge, visited);
        int cnt = count(visited.begin(), visited.end(), true);
        if (cnt == n) answer++;
    }
    
    return answer;
}