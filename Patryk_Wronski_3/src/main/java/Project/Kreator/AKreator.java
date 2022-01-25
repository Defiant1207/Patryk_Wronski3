package Project.Kreator;

import Project.Process.IProcess;
import Project.Process.Process;
import Project.Swap.FIFO;
import Project.Swap.LFU;
import Project.Swap.LRU;
import Project.Swap.OPT;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public abstract class AKreator implements IKreator {

    Scanner scanner;
    int page[] = new int[20];
    int x;
    List<IProcess> procesy;

    public AKreator(File dane) throws FileNotFoundException{
        this.scanner = new Scanner(dane);
        this.x = x;
        this.procesy = new ArrayList<>();

    }
    @Override
    public void load() {
        while (scanner.hasNext()) {
            for (int j = 0; j < 20; j++) {
                page[j] = scanner.nextInt();
                IProcess proces = new Process(page[j]);
                procesy.add(proces);
            }
            x = scanner.nextInt();
        }
    }
    @Override
    public void createFIFO() {
        FIFO fifo = new FIFO(procesy);
        System.out.println(" Liczba brakujacych ramek FIFO " + fifo.missing_pages(x));
    }
    @Override
    public void createLFU() {
        LFU lfu = new LFU(procesy);
        System.out.println(" Liczba brakujacych ramek LFU " + lfu.missing_pages(x));
    }
    @Override
    public void createOPT() {
        OPT opt = new OPT(procesy);
        System.out.println(" Liczba brakujacych ramek OPT " + opt.missing_pages(x));

    }
    @Override
    public void createLRU() {
        LRU lru = new LRU(procesy);
        System.out.println(" Liczba brakujacych ramek LRU " + lru.missing_pages(x));

    }
}
