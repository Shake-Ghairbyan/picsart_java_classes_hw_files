package Services;

import Interfaces.Printable;

public class PrintableService {
    public static void printAllInfo(Printable[] printables) {
        for (Printable p : printables) {
            p.printInfo();
        }
    }
}
