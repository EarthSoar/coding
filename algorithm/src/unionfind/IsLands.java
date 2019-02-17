package unionfind;

/**
 * @author Willing
 * @date 2019/2/17
 */

/**
     【岛问题】
     一个矩阵中只有0和1两种值，每个位置都可以和自己的上、下、左、右
     四个位置相连，如果有一片1连在一起，这个部分叫做一个岛，求一个
     矩阵中有多少个岛？
         举例：
         0 0 1 0 1 0
         1 1 1 0 1 0
         1 0 0 1 0 0
         0 0 0 0 0 0
         这个矩阵中有三个岛
 */
public class IsLands {
    public static int countIslands(int[][] m){
        if(m == null || m[0] == null){
            return 0;
        }
        int res = 0;//岛的个数

        int N = m.length;//行数
        int M = m[0].length;//列数
        //对矩阵遍历
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(m[i][j] == 1){   //判断如果存在1,立刻执行感染函数infect,岛的个数+1
                    infect(m,i,j,N,M);
                    res++;
                }
            }
        }
        return res;
    }

    /**
     * 当前位置是1,感染自己周围是1的位置变成2
     * @param m  矩阵
     * @param i  当前位置所在行
     * @param j  当前位置所在列
     * @param N  行数
     * @param M  列数
     */
    public static void infect(int[][] m, int i, int j, int N, int M) {
        //索引越界 或者 当前位置不为1,结束感染
        if(i < 0 || i >= N || j < 0 || j >= M || m[i][j] != 1){
            return;
        }
        m[i][j] = 2;
        infect(m, i + 1, j, N, M);//下
        infect(m, i - 1, j, N, M);//上
        infect(m, i, j - 1, N, M);//左
        infect(m, i, j + 1, N, M);//右
    }

    //test
    public static void main(String[] args) {
        int[][] m1 = {
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 1, 1, 0, 1, 1, 1, 0 },
                { 0, 1, 1, 1, 0, 0, 0, 1, 0 },
                { 0, 1, 1, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 1, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
        System.out.println(countIslands(m1));

        int[][] m2 = {
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 1, 1, 1, 1, 1, 1, 0 },
                { 0, 1, 1, 1, 0, 0, 0, 1, 0 },
                { 0, 1, 1, 0, 0, 0, 1, 1, 0 },
                { 0, 0, 0, 0, 0, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 1, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
        System.out.println(countIslands(m2));

    }
}
