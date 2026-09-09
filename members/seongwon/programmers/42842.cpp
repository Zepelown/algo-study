#include <vector>

using namespace std;

vector<int> solution(int brown, int yellow) {
    for (int i=1; i*i <= yellow; i++) {
        if (yellow % i != 0) continue;
        int x = yellow / i;  // 노란 가로 (더 김)
        int y = i;           // 노란 세로
        if (brown == 2*(x+y)+4) {
            return {x+2, y+2};
        }
    }
    return {};
}