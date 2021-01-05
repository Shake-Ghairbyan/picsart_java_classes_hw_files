package Services;

import Comparators.AuthorComparator;
import Comparators.PagesComparator;
import Exceptions.InvalidAuthorNameException;
import Exceptions.InvalidPageNumberException;
import Model.PDF;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * This class is used for working with pdf type files /creating, reading, printing,
 * sorting by different options, etc./.
 *
 * @author Shake Gharibyan
 * @version 1.0
 * @since 2021-01-04
 */

public class PDFService {
    /**
     * This field shows where created pdf files will be written.
     *
     * @author Shake Gharibyan
     * @version 1.0
     * @since 2021-01-04
     */
    private static final String PATH = "ForPDFObjects.txt";

    /**
     * This method is used to create new pdf file.
     *
     * @author Shake Gharibyan
     * @version 1.0
     * @since 2021-01-04
     */
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
        } catch (InvalidAuthorNameException | InvalidPageNumberException | IOException e) {
            System.out.println(e);
            System.out.println("Inputs are discarded");
        }
    }

    /**
     * This method reads pdf files from the text file and
     * returns the written pdf files as an ArrayList of pdf files.
     *
     * @return  List
     * @author Shake Gharibyan
     * @version 1.0
     * @since 2021-01-04
     */
    private static List<PDF> readPDFFiles() {
        try {
            List<String> strings = FileService.read(PATH);
            List<PDF> pdfs = new ArrayList<>();
            for (String s : strings) {
                pdfs.add(new PDF(s));
            }
            return pdfs;
        } catch (IndexOutOfBoundsException | InvalidAuthorNameException | InvalidPageNumberException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println("Could not read PDF files.");
        }
        return new ArrayList<>();
    }

    /**
     * Prints pdf files written in the text file.
     *
     * @author Shake Gharibyan
     * @version 1.0
     * @since 2021-01-04
     */
    public static void printPDFFiles() {
        PrintableService.printAllInfo(readPDFFiles());
    }

    /**
     * Prints pdf files written in the text file sorted by number of pages in ascending order.
     *
     * @author Shake Gharibyan
     * @version 1.0
     * @since 2021-01-04
     */
    public static void printPDFFilesSortedByPNumberOfPages() {
        List<PDF> pdfs = readPDFFiles();
        Collections.sort(pdfs, new PagesComparator());
        PrintableService.printAllInfo(pdfs);
    }

    /**
     * Prints non-secured pdf files written in the text file.
     *
     * @author Shake Gharibyan
     * @version 1.0
     * @since 2021-01-04
     */
    public static void printNonSecuredPDFFiles() {
        List<PDF> pdfs = readPDFFiles();
        for (PDF p : pdfs) {
            if (!p.isSecured()) {
                p.printInfo();
            }
        }
    }

    /**
     * Prints pdf files wirtten in the text file sorted by Author's full name in ascending order.
     *
     * @author Shake Gharibyan
     * @version 1.0
     * @since 2021-01-04
     */
    public static void printSortedByAuthor() {
        List<PDF> pdfs = readPDFFiles();
        Collections.sort(pdfs, new AuthorComparator());
        PrintableService.printAllInfo(pdfs);
    }
}

