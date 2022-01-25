package Project.Swap;

import Project.Process.IProcess;

import java.util.ArrayList;
import java.util.List;


public class OPT extends ASwap {

    int [] frames;
    public OPT(List<IProcess> processes_list) {
        super(processes_list);
        this.frames = new int [100];

    }

    public double missing_pages(int x) {
        List<IProcess> processes = new ArrayList<>();
        int[] at = new int[2];
        at[0] = 0;
        at[1] = 0;
        processes.add(processes_list.get(0));
        at[0]++;
        at[1]++;
        addFirst(x, at, processes);
        addOPT(x,at,processes);
        return at[0];
    }

    public void addOPT(int x, int[] at, List<IProcess> processes) {
        for (int i = at[1]; i < processes_list.size(); i++) {
            int b = 0;
            for (int j = 0; j < x; j++) {
                if (processes.get(j).getPage() != processes_list.get(i).getPage()) {
                    b++;
                }
                if (b == x) {
                    at[0]++;
                    checkWhenArrive(processes,x,at);
                    processes.set(optimal(processes,x), processes_list.get(i));
                }
            }
            at[1]++;
            wyswietl(processes);
        }
    }



    public int optimal( List<IProcess> processes, int x) {
        int y = 0;
        int max = frames[processes.get(0).getPage()];
        for (int i = 1; i < x; i++) {
            if (max < frames[processes.get(i).getPage()]) {
                max = frames[processes.get(i).getPage()];
                y = i;
            }
        }
            return y;
    }

        public void checkWhenArrive(List<IProcess> processes, int x, int[] at){

            for(int i=0; i<x; i++){
                for(int j=at[1]; j<processes_list.size();j++){
                    if(processes.get(i).getPage()!=processes_list.get(j).getPage()){
                        frames[processes.get(i).getPage()]=20;
                    }
                    if(processes.get(i).getPage()==processes_list.get(j).getPage()){
                        frames[processes.get(i).getPage()]=j;
                        break;
                    }
                }
            }

        }

        }



