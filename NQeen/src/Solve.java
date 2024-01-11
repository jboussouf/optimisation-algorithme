public class Solve implements Runnable{
    private int nQ=4;
    private int position;
    private NQueensProblem nqp;
    public Solve(int nQ, int position) {
        this.nQ = nQ;
        this.position = position;
        this.nqp = new NQueensProblem(this.nQ);
    }

    public void solve(){
        this.nqp.solveNQueens(0, nQ, position);
        //nqp.showBoard();

    }

    public void showBoard_(){
        this.nqp.showBoard();
    }

    @java.lang.Override
    public void run() {
        solve();
    }
}
