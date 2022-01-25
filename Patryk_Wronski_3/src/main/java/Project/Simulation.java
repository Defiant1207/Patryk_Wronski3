package Project;

import Project.Kreator.Kreator;
import Project.Process.IProcess;
import Project.Process.Process;
import Project.Swap.FIFO;
import Project.Swap.LFU;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Simulation {

    public static void main(String args[]) throws FileNotFoundException {

        File dane = new File("./../dane.txt");
        Kreator procesy = new Kreator(dane);
        procesy.load();
        procesy.createFIFO();
        procesy.load();
        procesy.createLFU();
        procesy.load();
        procesy.createOPT();
        procesy.load();
        procesy.createLRU();


    }
}
