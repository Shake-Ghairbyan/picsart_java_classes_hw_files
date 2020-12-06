package Model;

import Exceptions.TrackDurationException;
import Exceptions.NameException;

public class Audio extends File {
    private static final int BIT_RATE = 128 * 1024;
    private double durationOfTrack = 0.0;
    private boolean isLicensedRecord;

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

    public Audio(String a) {
        String[] split = a.split(",");
        setCreationDate(split[0]);
        try {
            setFileName(split[1]);
        } catch (NameException e) {
            e.printStackTrace();
        }
        try {
            setAuthor(split[2]);
        } catch (NameException e) {
            e.printStackTrace();
        }
        durationOfTrack = Double.parseDouble(split[3].substring(0, split[3].length() - 2));
        isLicensedRecord = Boolean.parseBoolean(split[4]);
    }

    @Override
    public String toString() {
        return super.toString() + "," + durationOfTrack + "," + isLicensedRecord + "\n";
    }

    @Override
    public void printInfo() {
        if (getDurationOfTrack() > 0) {
            super.printInfo();
            System.out.println("Duration of track (s): " + getDurationOfTrack() + "s");
            System.out.println("Licensed Record Status: " + (isLicensedRecord ? "Licensed" : "Not Licensed"));
        } else {
            System.out.println("Audio file is empty.");
        }
    }

    @Override
    public int getEstimatedStorageSize() {
        return (int) (durationOfTrack * BIT_RATE/8);
    }
}

