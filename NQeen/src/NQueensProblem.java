public class NQueensProblem {
    private int nQ;
    private int board[][];
    private int nb_solution_per_root=0;

    public NQueensProblem(int nQ) {
        this.nQ = nQ;
        this.board = new int[nQ][nQ];
        inisialize();
    }

    public boolean isAttack(int row, int j){
        for (int k=0; k<row; k++){
            if (this.board[k][j] == 1){
                return true;
            }
        }

        int k=row-1;
        int l = j+1;
        while ((k>=0) && (l<this.nQ)){
            if (this.board[k][l] == 1){
                return true;
            }
            k=k-1;
            l=l+1;
        }

        k=row-1;
        l=j-1;
        while ((k>=0) && (l>=0)){
            if (this.board[k][l]==1){
                return true;
            }
            k=k-1;
            l=l-1;
        }
        return false;

    }

    public boolean solveNQueens(int row, int n, int position){
        if (n==this.nQ){
            inisialize();
            this.board[row][position]=1;
            n = n-1;
            row++;

        }
        if (n==0){
            this.nb_solution_per_root ++;
            //showBoard();
            return true;
        }
        for (int i=0; i<this.nQ; i++){
            if (!isAttack(row, i)){
                this.board[row][i]=1;
                //showBoard();
                if (solveNQueens(row+1, n-1, position)){
                    return true;
                }
                this.board[row][i]=0;
            }
        }
        return false;
    }

    public void showBoard(){
        for (int i = 0; i < this.nQ; i++) {
            for (int j = 0; j < this.nQ; j++) {
                System.out.print(this.board[i][j]+"\t");
            }
            System.out.println();
        }
        System.out.println("------------------------------------------------");
    }

    public void getNb_solution(){
        System.out.println("number of solution is: "+this.nb_solution_per_root);
    }

    private void inisialize(){
        for (int i=0; i<nQ; i++){
            for (int j=0; j<nQ; j++){
                this.board[i][j]=0;
            }
        }
    }

}
