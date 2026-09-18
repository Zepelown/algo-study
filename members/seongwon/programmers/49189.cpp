#include <string>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

int solution(int n, vector<vector<int>> edge) {
    int answer = 0;
    vector<vector<int>> adj(n+1);
    for (auto& e : edge) {
        adj[e[0]].push_back(e[1]);
        adj[e[1]].push_back(e[0]);
    }
    
    vector<int> dist(n+1,-1);
    queue<int> q;
    
    dist[1] = 0;
    q.push(1);
    
    while (!q.empty()) {
        int cur = q.front();
        q.pop();
        
        for (int nxt : adj[cur]) {
            if (dist[nxt] == -1) {
                dist[nxt] = dist[cur] + 1;
                q.push(nxt);
            }
        }
    }
    
    int max_dist = *max_element(dist.begin() + 1, dist.end());
    answer = count(dist.begin() + 1, dist.end(), max_dist);
    
    return answer;
}