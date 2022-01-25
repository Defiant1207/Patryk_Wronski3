package Project.Swap;

import Project.Process.IProcess;

import java.util.ArrayList;
import java.util.List;

public class FIFO extends ASwap {


    public FIFO(List<IProcess> processes_list) {

        super(processes_list);
    }

    /**
     * dla podanej ilosci ramek wykonywany jest algorytm zastepowania stron
     *
     * @param x - liczba ramek
     * @return ilosc wymian stron
     */
    public double missing_pages(int x) {
        List<IProcess> processes = new ArrayList<>();
        int[] at = new int[2];
        at[0] = 0;
        at[1] = 0;
        processes.add(processes_list.get(0));
        at[0]++;
        addFirst(x, at, processes);
        addFIFO(x,at,processes);
        return at[0];
    }

    @Override
    public void addFIFO(int x, int[] at, List<IProcess> processes){
        for (int i = at[1]; i < processes_list.size(); i++) {

            int b = 0;
            for (int j = 0; j < x; j++) {
                if (processes.get(j).getPage() != processes_list.get(i).getPage()) {
                    b++;
                }
                if (b == x) {
                    at[0]++;
                    processes.remove(0);
                    processes.add(processes_list.get(i));
                }
            }
        }
    }
}
