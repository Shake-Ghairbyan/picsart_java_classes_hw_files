package Services;

import Interfaces.Printable;

import java.util.List;

public class PrintableService {
    public static void printAllInfo(List<? extends Printable> printables) {
        for (Printable p : printables) {
            p.printInfo();
        }
    }
}
