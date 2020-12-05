package Services;

import Text_SubClasses.PDF;

import java.io.IOException;
import java.util.Scanner;

public class PDF_Service {
    private static final String PATH = "ForPDFObjects.txt";

    public static void createPDFFile() {
        Scanner scan = new Scanner(System.in);
        PDF pdf = new PDF();
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
        try {
            File_Service.write(PATH, pdf);
        } catch (IOException e){
            System.out.println("Could not write to the file.");
        }
    }

    private static PDF[] readPDFFiles() {
        String[] strings = {};
        try {
            strings = File_Service.read(PATH);
        } catch (IOException e) {
            System.out.println("Could not read PDF files");
        }
        PDF[] pdfs = new PDF[strings.length];
        for (int i = 0; i < pdfs.length; i++) {
            try {
                pdfs[i] = new PDF(strings[i]);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Could not read PDF files due to corrupted record");
                return new PDF[]{};
            }
        }
        return pdfs;
    }

    public static void printPDFFiles() {
        for (PDF pdf : readPDFFiles()) {
            pdf.printInfo();
        }
    }

    public static void printPDFFilesSortedByPNumberOfPages()  {
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
        for (PDF p : pdfs) {
            p.printInfo();
        }
    }
}

