#include <string>
#include <vector>
#include <unordered_map>
#include <set>
using namespace std;

unordered_map<char, set<int>> m;

// 포함되지 않는 경우를 먼저 판단
// 하지 않고 그냥 찾다가 특정 문자열이 keymap에 없는 순간 return -1

// dict에 "A" : 1 형식으로 저장

vector<int> solution(vector<string> keymap, vector<string> targets) {
    vector<int> answer;
    
    for (const string& s : keymap) {
        for (int i=0; i < s.size(); i++) {
            m[s[i]].insert(i+1);
        }
    }
    
    for (const string& s : targets) {
        int cnt = 0;
        bool exist = true;
        for (int i=0; i < s.size(); i++) {
            if (m.count(s[i]) == 0) {
                answer.push_back(-1);
                exist = false;
                break;
            } 
            cnt += *m[s[i]].begin();
        }
        if (exist) {
            answer.push_back(cnt);
        }
    }
    
    return answer;
}