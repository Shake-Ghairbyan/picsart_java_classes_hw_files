package Media_SubClasses;

import Interfaces.I_File;
import Model.File;

public class Audio extends File implements I_File {
    private double durationOfTrack = 0.0;
    private boolean isLicensedRecord;

    public double getDurationOfTrack() {
        return durationOfTrack;
    }

    public void setDurationOfTrack(double durationOfTrack) {
        this.durationOfTrack = durationOfTrack;
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
        setFileName(split[1]);
        setAuthor(split[2]);
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
}

