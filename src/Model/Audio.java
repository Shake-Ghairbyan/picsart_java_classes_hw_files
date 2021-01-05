package Model;

import Exceptions.InvalidFileNameException;
import Exceptions.InvalidTrackDurationException;
import Exceptions.InvalidAuthorNameException;

public class Audio extends File {
    private static final int BIT_RATE = 128 * 1024;
    private double durationOfTrack = 0.0;
    private boolean isLicensedRecord = false;

    /**
     * This method is used to get the duration of the track for an instance of File Audio class.
     *
     * @since 2021-01-04
     */
    public double getDurationOfTrack() {
        return durationOfTrack;
    }

    /**
     * This method is used to set the duration of the track for an instance of File Audio class.
     *
     * @throws InvalidTrackDurationException is thrown when track's duration was assigned a negative value.
     * @since 2021-01-04
     */

    public void setDurationOfTrack(double durationOfTrack) throws InvalidTrackDurationException {
        if (durationOfTrack >= 0) {
            this.durationOfTrack = durationOfTrack;
        } else {
            throw new InvalidTrackDurationException(durationOfTrack);
        }
    }

    /**
     * This method is used to get the status of the audio file, whether it is licensed or not.
     *
     * @return boolean status of the audio file: true -  Licensed : false - Not Licensed.
     * @since 2021-01-04
     */

    public boolean isLicensedRecord() {
        return isLicensedRecord;
    }

    /**
     * This method is used to set the status of the audio file, whether it is licensed or not.
     *
     * @param isLicensedRecord boolean variable which shows the status of the PDF's instance:
     *                         true - Licensed : false - Not Licensed.
     * @since 2021-01-04
     */

    public void setLicensedRecord(boolean isLicensedRecord) {
        this.isLicensedRecord = isLicensedRecord;
    }

    /**
     * This method is used to construct new instance of Audio class.
     *
     * @since 2021-01-04
     */
    public Audio() {
    }

    /**
     * This method is used to construct new instance of Audio class,
     * from the stringified file that is read from "ForAudioObjects.txt".
     *
     * @param a CSVStringified Audio class' instance that is read from "ForAudioObjects.txt".
     * @throws InvalidAuthorNameException    is thrown when Author name of File's instance is invalid.
     * @throws InvalidTrackDurationException is thrown when Track Duration of the Audio's instance
     *                                       is given negative value.
     * @throws InvalidFileNameException      is thrown when name of the file of the File class'
     *                                       instance is not valid /non-empty string/.
     * @since 2021-01-04
     */

    public Audio(String a) throws InvalidAuthorNameException, InvalidTrackDurationException,
            InvalidFileNameException {
        String[] split = a.split(",");
        setCreationDate(split[0]);
        setFileName(split[1]);
        setAuthor(split[2]);
        setDurationOfTrack(Double.parseDouble(split[3]));
        setLicensedRecord(Boolean.parseBoolean(split[4]));
    }

    @Override
    public String toCSVString() {
        return super.toCSVString() + "," + durationOfTrack + "," + isLicensedRecord;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Duration of track (s): " + getDurationOfTrack() + "s");
        System.out.println("Licensed Record Status: " + (isLicensedRecord ? "Licensed" : "Not Licensed"));
    }

    @Override
    public int getEstimatedStorageSize() {
        return (int) (durationOfTrack * BIT_RATE / 8);
    }
}

