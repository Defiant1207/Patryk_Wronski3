package Project.Swap;


import Project.Process.IProcess;

import java.util.ArrayList;
import java.util.List;

public abstract class ASwap implements ISwap {


    List<IProcess> processes_list;



    public ASwap(List<IProcess> processes_list) {

        this.processes_list = processes_list;

    }




    @Override
    public void addFirst(int x, int[] at, List<IProcess> processes) {
        while (at[0] > 0 && at[0] < x) {
            int ile_procesow = 0;

            for (int j = 0; j < processes.size(); j++) {
                if (processes_list.get(at[1]).getPage() != processes.get(j).getPage())
                    ile_procesow++;
            }
            if (ile_procesow == processes.size()) {
                processes.add(processes_list.get(at[1]));
                at[0]++;
            }
            at[1]++;
        }
    }

    public void addFIFO(int x, int[] at, List<IProcess> processes)
    {
    };

    public abstract double missing_pages(int x);

}
