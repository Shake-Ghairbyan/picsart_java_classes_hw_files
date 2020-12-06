package Model;

import Exceptions.TrackDurationException;
import Exceptions.NameException;

public class Audio extends File {
    private static final int BIT_RATE = 128 * 1024;
    private double durationOfTrack = 0.0;
    private boolean isLicensedRecord = false;

    public double getDurationOfTrack() {
        return durationOfTrack;
    }

    public void setDurationOfTrack(double durationOfTrack) throws TrackDurationException {
        if (durationOfTrack >= 0) {
            this.durationOfTrack = durationOfTrack;
        } else {
            throw new TrackDurationException(durationOfTrack);
        }
    }

    public boolean isLicensedRecord() {
        return isLicensedRecord;
    }

    public void setLicensedRecord(boolean isLicensedRecord) {
        this.isLicensedRecord = isLicensedRecord;
    }

    public Audio() {
    }

    public Audio(String a) throws NameException, TrackDurationException {
        String[] split = a.split(",");
        setCreationDate(split[0]);
        setFileName(split[1]);
        setAuthor(split[2]);
        setDurationOfTrack(Double.parseDouble(split[3]));
        setLicensedRecord(Boolean.parseBoolean(split[4]));
    }

    @Override
    public String toString() {
        return super.toString() + "," + durationOfTrack + "," + isLicensedRecord;
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

