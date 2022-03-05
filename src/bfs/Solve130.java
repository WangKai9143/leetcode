package bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Administrator on 2020/5/1.
 */

/*这里简单总结下 dfs 和 dfs。
bfs 递归。可以想想二叉树中如何递归的进行层序遍历。
bfs 非递归。一般用队列存储。
dfs 递归。最常用，如二叉树的先序遍历。
dfs 非递归。一般用 stack。*/


/*
130. 被围绕的区域
        给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。

        找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。

        示例:

        X X X X
        X O O X
        X X O X
        X O X X
        运行你的函数后，矩阵变为：

        X X X X
        X X X X
        X X X X
        X O X X
        解释:

        被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。·····



        写在前面
本题给定的矩阵中有三种元素：

字母 X；
被字母 X 包围的字母 O；
没有被字母 X 包围的字母 O。
本题要求将所有被字母 X 包围的字母 O都变为字母 X ，但很难判断哪些 O 是被包围的，哪些 O 不是被包围的。

注意到题目解释中提到：任何边界上的 O 都不会被填充为 X。 我们可以想到，所有的不被包围的 O 都直接或间接与边界上的 O 相连。我们可以利用这个性质判断 O 是否在边界上，具体地说：

对于每一个边界上的 O，我们以它为起点，标记所有与它直接或间接相连的字母 O；
最后我们遍历这个矩阵，对于每一个字母：
如果该字母被标记过，则该字母为没有被字母 X 包围的字母 O，我们将其还原为字母 O；
如果该字母没有被标记过，则该字母为被字母 X 包围的字母 O，我们将其修改为字母 X。
*/

public class Solve130 {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return;
        }
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if ((i == 0 || j == 0 || i == row - 1 || j == col - 1) && board[i][j] == 'O') {
                    bfs(board,i,j);
                }
            }
        }
        // 从边界像里面找联通性
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                else if (board[i][j] == '#'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    // bfs的精髓还是在于队列
    public void bfs(char[][] board,int x,int y) {
        Queue<Pos> queue = new LinkedList<>();
        if (board == null || board.length ==0 || board[0] == null ||  board[0].length == 0){
            return;
        }
        int row = board.length;
        int col = board[0].length;
        queue.offer(new Pos(x,y));
        while (!queue.isEmpty()){
            Pos cur = queue.poll();
            if (board[cur.i][cur.j]!='#') { //访问过的就不在访问，及时推出防止超时
                board[cur.i][cur.j] = '#';
                if (cur.i - 1 >= 0 && board[cur.i - 1][cur.j] == 'O') {
                    queue.offer(new Pos(cur.i - 1, cur.j));
                }
                if (cur.i + 1 < row && board[cur.i + 1][cur.j] == 'O') {
                    queue.offer(new Pos(cur.i + 1, cur.j));
                }
                if (cur.j - 1 >= 0 && board[cur.i][cur.j - 1] == 'O') {
                    queue.offer(new Pos(cur.i, cur.j - 1));
                }
                if (cur.j + 1 < col && board[cur.i][cur.j + 1] == 'O') {
                    queue.offer(new Pos(cur.i, cur.j + 1));
                }
            }
        }
    }

     static class Pos{
        int i;
        int j;
        Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

}
