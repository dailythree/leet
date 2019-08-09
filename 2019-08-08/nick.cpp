// 289. Game of Life
/*
状态: 前一位表示下一代的状态,后一位表示当前的状态
00: 死->死
10: 死->活
01: 活->死
11: 活->活
*/
class Solution {
public:
    void gameOfLife(vector<vector<int>>& board) {
        int d[][2] = {{1,-1}, {1,0},{1,1},{0,-1},{0,1},{-1,-1},{-1,0},{-1,1}};
        for (int i = 0; i < board.size(); ++i) {
            for (int j = 0; j < board[0].size(); ++j) {
                int live = 0;
                for (int k = 0; k < 8; ++k) {
                    int x = d[k][0] + i;
                    int y = d[k][1] + j;
                
                    if(x < 0 || x >= board.size() || y < 0 || y >= board[0].size()) continue;
                    
                    if (board[x][y] & 1) ++live;
                }
                
                if (board[i][j] == 0) {
                    if (live == 3) board[i][j] = 2;
                }
                else {
                    if (live < 2 || live > 3) board[i][j] = 1;
                    else board[i][j] = 3;
                }
            }
        }
        
        for (int i = 0; i < board.size(); ++i) {
            for (int j = 0; j < board[0].size(); ++j) {
                board[i][j] >>= 1;
            }
        }
    }
};


//79. Word Search

class Solution {
public:
    bool exist(vector<vector<char>>& board, string word) {
        if (board.empty() || board[0].empty()) return false;
        int m = board.size(), n = board[0].size();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (dfs(board, word, 0, i, j)) return true;
            }
        }
        return false;
    }
    
private:
    bool dfs(vector<vector<char>>& board, string& word, int idx, int i, int j) {
        if (idx == word.size()) return true;
        if (i < 0 || j < 0 || i >= board.size() || j >= board[0].size() || board[i][j] != word[idx]) return false;
        char c = board[i][j];
        board[i][j] = '#';
        bool res = dfs(board, word, idx + 1, i - 1, j) ||
                   dfs(board, word, idx + 1, i, j - 1) ||
                   dfs(board, word, idx + 1, i + 1, j) ||
                   dfs(board, word, idx + 1, i, j + 1);
        board[i][j] = c;
        return res;
    }
};