package Services;

import Comparators.AuthorComparator;
import Comparators.PagesComparator;
import Exceptions.NameException;
import Exceptions.PageException;
import Model.PDF;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PDFService {
    private static final String PATH = "ForPDFObjects.txt";

    public static void createPDFFile() {
        Scanner scan = new Scanner(System.in);
        PDF pdf = new PDF();
        try {
            System.out.println("***************************");
            System.out.println("Insert creation Date");
            pdf.setCreationDate(scan.nextLine());
            System.out.println("Print file name");
            pdf.setFileName(scan.nextLine());
            System.out.println("Print Author's name");
            pdf.setAuthor(scan.nextLine());
            System.out.println("Insert number of pages of the file");
            pdf.setNumberOfPages(scan.nextInt());
            System.out.println("Set Secured mode for the file: 1. Secured , 2. Not Secured.");
            pdf.setSecured(scan.nextInt() == 1);
            System.out.println("PDF file was created.");
            System.out.println("***************************");
            FileService.write(PATH, pdf);
        } catch (NameException | PageException | IOException e) {
            System.out.println(e);
            System.out.println("Inputs are discarded");
        }
    }

    private static List<PDF> readPDFFiles() {
        try {
            List<String> strings = FileService.read(PATH);
            List<PDF> pdfs = new ArrayList<>();
            for (String s: strings) {
                pdfs.add(new PDF(s));
            }
            return pdfs;
        } catch (IndexOutOfBoundsException | NameException | PageException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println("Could not read PDF files.");
        }
        return new ArrayList<>();
    }

    public static void printPDFFiles() {
        PrintableService.printAllInfo(readPDFFiles());
    }

    public static void printPDFFilesSortedByPNumberOfPages() {
        List<PDF> pdfs = readPDFFiles();
        Collections.sort(pdfs, new PagesComparator());
        PrintableService.printAllInfo(pdfs);
    }

    public static void printNonSecuredPDFFiles() {
        List<PDF> pdfs = readPDFFiles();
        for (PDF p : pdfs) {
            if (!p.isSecured()) {
                p.printInfo();
            }
        }
    }

    public static void printSortedByAuthor() {
        List<PDF> pdfs = readPDFFiles();
        Collections.sort(pdfs, new AuthorComparator());
        PrintableService.printAllInfo(pdfs);
    }
}

