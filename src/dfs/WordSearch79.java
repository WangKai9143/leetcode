package dfs;

public class WordSearch79 {
    public static void main(String[] args) {
//        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
//        String word = "ABCCED";
//        System.out.println(exist(board, word));

        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCB";
        System.out.println(exist(board, word));
    }

    static int direct[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static boolean find = false;

    public static boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null || word.isEmpty()) {
            return false;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    backTracking(board, i, j, word, 0, visited);
                }
            }
        }
        return find;
    }

    private static void backTracking(char[][] board, int x, int y, String word, int k, boolean[][] visited) {
        if (k == word.length()) {
            find = true;
            return;
        }
        if (x < 0 || x >= board.length || y < 0 || y >= board[x].length || visited[x][y]) {
            return;
        }
        visited[x][y] = true;
        for (int i = 0; i < direct.length; i++) {
            if (board[x][y] == word.charAt(k)) {
                backTracking(board, x + direct[i][0], y + direct[i][1], word, k + 1, visited);
            }
        }
        visited[x][y] = false;
    }
}
