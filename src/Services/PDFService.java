package Services;

import Exceptions.NameException;
import Exceptions.PageException;
import Model.PDF;

import java.io.IOException;
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

    private static PDF[] readPDFFiles() {
        try {
            String[] strings = FileService.read(PATH);
            PDF[] pdfs = new PDF[strings.length];
            for (int i = 0; i < pdfs.length; i++) {
                pdfs[i] = new PDF(strings[i]);
            }
            return pdfs;
        } catch (IndexOutOfBoundsException | NameException | PageException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println("Could not read PDF files.");
        }
        return new PDF[]{};
    }

    public static void printPDFFiles() {
        PrintableService.printAllInfo(readPDFFiles());
    }

    public static void printPDFFilesSortedByPNumberOfPages() {
        PDF[] pdfs = readPDFFiles();
        for (int i = 0; i < pdfs.length; i++) {
            for (int j = 0; j < pdfs.length - 1 - i; j++) {
                if (pdfs[j].getNumberOfPages() > pdfs[j + 1].getNumberOfPages()) {
                    PDF reservedPDF = pdfs[j];
                    pdfs[j] = pdfs[j + 1];
                    pdfs[j + 1] = reservedPDF;
                }
            }
        }
        PrintableService.printAllInfo(pdfs);
    }

    public static void printNonSecuredPDFFiles() {
        PDF[] pdfs = readPDFFiles();
        for (PDF p : pdfs) {
            if (!p.isSecured()) {
                p.printInfo();
            }
        }
    }

    public static void printSortedByAuthor() {
        PDF[] pdfs = readPDFFiles();
        for (int i = 0; i < pdfs.length; i++) {
            for (int j = 0; j < pdfs.length - 1 - i; j++) {
                int compare = pdfs[j].getAuthor().compareTo(pdfs[j + 1].getAuthor());
                if (compare > 0) {
                    PDF reservedPDF = pdfs[j];
                    pdfs[j] = pdfs[j + 1];
                    pdfs[j + 1] = reservedPDF;
                }
            }
        }
        PrintableService.printAllInfo(pdfs);
    }
}

