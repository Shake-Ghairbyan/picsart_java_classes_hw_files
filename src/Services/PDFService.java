package Services;

import Comparators.AuthorComparator;
import Comparators.FileNameComparator;
import Exceptions.InvalidAuthorNameException;
import Exceptions.InvalidFileNameException;
import Exceptions.InvalidPageNumberException;
import Model.PDF;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
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
     * @since 2021-01-04
     */
    private static final String PATH = "PDFObjects.txt";

    /**
     * This method is used to create new pdf file.
     *
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
        } catch (InvalidAuthorNameException | InvalidPageNumberException | IOException
                | InvalidFileNameException e) {
            System.out.println(e);
            System.out.println("Inputs are discarded");
        }
    }

    /**
     * This method reads pdf files from the text file and
     * returns the written pdf files as an ArrayList of pdf files.
     *
     * @return new ArrayList<>()
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
        } catch (IndexOutOfBoundsException | InvalidAuthorNameException |
                InvalidPageNumberException | InvalidFileNameException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println("Could not read PDF files.");
        }
        return new ArrayList<>();
    }

    /**
     * Prints pdf files written in the text file.
     *
     * @since 2021-01-04
     */
    public static void printPDFFiles() {
        PrintableService.printAllInfo(readPDFFiles());
    }

    /**
     * Prints pdf files written in the text file sorted by number of pages in ascending order.
     *
     * @since 2021-01-04
     */
    public static void printPDFFilesSortedByPNumberOfPages() {
        List<PDF> pdfs = readPDFFiles();
        pdfs.sort(Comparator.comparingInt(PDF::getNumberOfPages));
        PrintableService.printAllInfo(pdfs);
    }

    /**
     * Prints non-secured pdf files written in the text file.
     *
     * @since 2021-01-04
     */
    public static void printNonSecuredPDFFiles() {
        readPDFFiles()
                .stream()
                .filter(pdf -> !pdf.isSecured())
                .forEach(PDF::printInfo);
    }

    /**
     * This method is used to print instances of the PDF class, which are read from text file,
     * sorted by the filenames of those instances in Ascending Order.
     *
     * @since 2021-01-04
     */
    public static void printSortedByPDFFileNameInAscendingOrder() {
        List<PDF> pdfs = readPDFFiles();
        pdfs.sort(new FileNameComparator(false));
        PrintableService.printAllInfo(pdfs);
    }

    /**
     * This method is used to print instances of the PDF class, which are read from text file,
     * sorted by the filenames of those instances in Descending Order.
     *
     * @since 2021-01-04
     */
    public static void printSortedByPDFFileNameInDescendingOrder() {
        List<PDF> pdfs = readPDFFiles();
        pdfs.sort(new FileNameComparator(true));
        PrintableService.printAllInfo(pdfs);
    }

    /**
     * Prints pdf files written in the text file sorted by Author's full name in ascending order.
     *
     * @since 2021-01-04
     */
    public static void printSortedByAuthor() {
        List<PDF> pdfs = readPDFFiles();
        pdfs.sort(new AuthorComparator());
        PrintableService.printAllInfo(pdfs);
    }
}

