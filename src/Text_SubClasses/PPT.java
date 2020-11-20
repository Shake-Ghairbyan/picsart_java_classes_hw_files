package Text_SubClasses;
import Model.File;

public class PPT extends File {
    private int cuntOfSlides;
    private boolean isWithAnimation;

    public PPT(String creationDate, String lastModified, String fileFormat, String fileName, double storageSize, String author, int cuntOfSlides, boolean isWithAnimation) {
        super(creationDate, lastModified, fileFormat, fileName, storageSize, author);
        setCountOfSlides(cuntOfSlides);
        setWithAnimation(isWithAnimation);
    }

    public int getCountOfSlides() {
        return cuntOfSlides;
    }

    public void setCountOfSlides(int cuntOfSlides) {
        if (cuntOfSlides < 0) {
            this.cuntOfSlides = cuntOfSlides;
        } else {
            System.out.println("Not valid input for slides' count.");
        }
    }

    public boolean isWithAnimation() {
        return isWithAnimation;
    }

    public void setWithAnimation(boolean withAnimation) {
        isWithAnimation = withAnimation;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Number of slide: " + cuntOfSlides);
        System.out.println("Animation availability in presentation: " + (isWithAnimation ? "Yes" : "No"));
    }
}

