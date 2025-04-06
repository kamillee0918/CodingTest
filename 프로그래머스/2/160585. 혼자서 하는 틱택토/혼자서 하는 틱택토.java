class Solution {
    public int solution(String[] board) {
        int oCount = 0, xCount = 0;
        boolean oWins = false, xWins = false;

        // O와 X의 개수 세기
        for (String row : board) {
            for (char c : row.toCharArray()) {
                if (c == 'O') oCount++;
                if (c == 'X') xCount++;
            }
        }

        // 승리 조건 확인
        oWins = checkWin(board, 'O');
        xWins = checkWin(board, 'X');

        if (xCount > oCount || oCount > xCount + 1) return 0;
        if (oWins && xWins) return 0;
        if (oWins && oCount != xCount + 1) return 0;
        if (xWins && oCount != xCount) return 0;

        return 1;
    }

    private boolean checkWin(String[] board, char player) {
        // 가로, 세로, 대각선 승리 조건 확인
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == player && board[i].charAt(1) == player && board[i].charAt(2) == player) return true;
            if (board[0].charAt(i) == player && board[1].charAt(i) == player && board[2].charAt(i) == player) return true;
        }
        if (board[0].charAt(0) == player && board[1].charAt(1) == player && board[2].charAt(2) == player) return true;
        if (board[0].charAt(2) == player && board[1].charAt(1) == player && board[2].charAt(0) == player) return true;
        return false;
    }
}
