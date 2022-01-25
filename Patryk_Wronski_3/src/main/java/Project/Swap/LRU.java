package Project.Swap;

import Project.Process.IProcess;

import java.util.ArrayList;
import java.util.List;

public class LRU extends ASwap{

    int[] frames;

    public LRU(List<IProcess> processes_list) {
        super(processes_list);
        this.frames = new int[100];
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
                frames[processes_list.get(at[1]).getPage()]=at[1];
            }
            at[1]++;
            wyswietl(processes);
        }
    }
    @Override
    public double missing_pages(int x) {
        List<IProcess> processes = new ArrayList<>();
        int[] at = new int[2];
        processes.add(processes_list.get(0));
        at[1]++;
        at[0]++;
        frames[processes_list.get(0).getPage()]=at[1];
        addFirst(x, at, processes);
        addLRU(x,at,processes);

        return at[0];
    }
    public void addLRU(int x, int[] at, List<IProcess> processes){
        for (int i = at[1]; i < processes_list.size(); i++) {

            int b = 0;
            for (int j = 0; j < x; j++) {
                if (processes.get(j).getPage() != processes_list.get(i).getPage()) {
                    b++;
                }
                if (b == x) {
                    at[0]++;
                    processes.set(LRU(processes,x),processes_list.get(i));
                    frames[processes_list.get(i).getPage()]=at[1]+1;
                }
                else{
                    frames[processes_list.get(i).getPage()]=at[1]+1;
                }
            }
            at[1]++;
            wyswietl(processes);
        }
    }

    public int LRU(List<IProcess> processes, int x){
        int y = 0;
        int min = frames[processes.get(0).getPage()];
        for(int i=1; i<x; i++){
            if(min>frames[processes.get(i).getPage()]){
                min=frames[processes.get(i).getPage()];
                y=i;
            }
            }
        return y;
    }

}
