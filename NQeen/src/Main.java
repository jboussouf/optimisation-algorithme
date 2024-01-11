
import java.util.List;
import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
        List<Thread> threads = new ArrayList<>();
        List<Solve> slvs = new ArrayList<>();
        int nq = 24;
        long startTime = System.currentTimeMillis();
        for (int i =0; i<nq; i++){
            Solve s = new Solve(nq, i);
            slvs.add(s);
            Thread th = new Thread(s);
            threads.add(th);
        }

        for (Thread th: threads){
            th.start();
        }
        for (Thread th: threads){
            th.join();

        }
        for (Solve solve: slvs){
            solve.showBoard_();
        }

        long endTime = System.currentTimeMillis();

        // Calculate and print the execution time
        long executionTime = endTime - startTime;
        System.out.println("Execution time: " + executionTime + " milliseconds");

    }
}