#include <string>
#include <vector>
#include <set>
using namespace std;

string s;
vector<bool> used;
set<int> result;

bool is_prime(int n) {
    if (n < 2) return false;
    for (int i = 2; i <= n/i; i++) {
        if (n%i == 0) return false;
    }
    return true;
}

void dfs(string cur) {
    if (!cur.empty()) result.insert(stoi(cur));
    for (int i; i < s.size(); i++) {
        if (used[i]) continue;
        used[i] = true;
        dfs(cur + s[i]);
        used[i] = false;
    }
}

int solution(string numbers) {
    s = numbers;
    used.assign(s.size(), false); 
    result.clear();
    
    dfs("");
    
    int answer = 0;
    for (int num : result) {
        if (is_prime(num)) answer ++;
    }
    return answer;
}