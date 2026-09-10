#include <string>
#include <vector>
#include <unordered_map>
#include <sstream>
using namespace std;

vector<string> solution(vector<string> record) {
    vector<string> answer;
    unordered_map<string, string> m; 

    // 닉네임 확정짓기 
    for (const string& s : record) {
        istringstream iss(s);
        string cmd, uid, nick;
        iss >> cmd >> uid >> nick;
        if (cmd == "Enter" || cmd == "Change") m[uid] = nick; 
    }

    for (const string& s : record) {
        istringstream iss(s);
        string cmd, uid, nick;
        iss >> cmd >> uid >> nick;
        if (cmd == "Enter")      answer.push_back(m[uid] + "님이 들어왔습니다.");
        else if (cmd == "Leave") answer.push_back(m[uid] + "님이 나갔습니다.");
    }

    return answer;
}