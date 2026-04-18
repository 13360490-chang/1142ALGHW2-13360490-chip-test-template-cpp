#include <iostream>
#include <vector>
using namespace std;

int findGoodChip(const vector<int>& chips,
                 const vector<vector<bool>>& report) {

    vector<int> candidates = chips;

    while (!candidates.empty()) {
        int n = candidates.size();

        // 1. 若只剩一顆
        if (n == 1) {
            return candidates[0];
        }

        // 2. 第一顆當候選 A
        int A = candidates[0];

        // 3. V = 0
        int V = 0;

        // 4. 與其他晶片互測
        for (int i = 1; i < n; i++) {
            int B = candidates[i];

            if (report[A][B] && report[B][A]) {
                V++;
            }
        }

        // 5. 判斷
        if (V >= n / 2) {
            return A;
        }

        // 6. 刪掉 A
        candidates.erase(candidates.begin());
    }

    return -1;
}