#include <algorithm>
#include <vector>

using namespace std;

int solution(int n, vector<vector<int>> wires) {
    vector<vector<int>> adj(n+1);
    for (const vector<int>& w : wires) {
        adj[w[0]].push_back(w[1]);
        adj[w[1]].push_back(w[0]);
    }
    
    int answer = n;
    for (const vector<int>& w : wires) {
        int a = w[0], b = w[1];
        
        vector<bool> visited(n+1, false);
        vector<int> stk;
        stk.push_back(a);
        visited[a] = true;
        int cnt = 0;
        
        while(!stk.empty()) {
            int cur = stk.back();
            stk.pop_back();
            cnt ++;
            for (int nxt : adj[cur]) {
                if (cur == a && nxt == b) continue;
                if (cur == b && nxt == a) continue;
                if (visited[nxt]) continue;
                visited[nxt] = true;
                stk.push_back(nxt);
            }
        }
        answer = min(answer, abs(n-2*cnt));
    }
    
    
    return answer;
}