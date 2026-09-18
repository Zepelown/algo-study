#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> answers) {
    vector<int> answer;

    vector<vector<int>> matrix = {
        { 1, 2, 3, 4, 5 },
        { 2, 1, 2, 3, 2, 4, 2, 5 },
        { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 }
    };
    
    vector<int> scores(3,0); 
    
    for (int i = 0; i < 3; i++) {
        int index = i + 1;
        const auto& cur_vec = matrix[i];
        int n = cur_vec.size();
 
        for (int j = 0; j < answers.size(); j++) {
            if (answers[j] == cur_vec[j%n]) scores[i]++;
        }
    }
    

    int max_score = *max_element(scores.begin(), scores.end());
    
    for (int i = 0; i < 3; i++) {
        if (scores[i] == max_score) {
            answer.push_back(i+1);
        }
    }
    
    
    return answer;
}