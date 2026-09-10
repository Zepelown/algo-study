#include <string>
#include <vector>
#include <unordered_map>
#include <set>
using namespace std;

vector<int> solution(vector<string> id_list, vector<string> report, int k) {
    unordered_map<string, set<string>> m;
    unordered_map<string, int> mail;
    
    for (const string& s : report) {
        size_t p = s.find(' ');
        m[s.substr(p+1)].insert(s.substr(0,p));
    }
    
    for (const auto& [target, reporters] : m) {
        if ((int)reporters.size() >= k) {
            for (const string& r : reporters) mail[r]++;
        }
    }
    
    vector<int> answer;
    for (const string&id : id_list) answer.push_back(mail[id]);
    
    return answer;
}