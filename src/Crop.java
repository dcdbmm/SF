abstract class Crop {
    private final String type;
    private final String growthStage;
    protected String healthStatus;

    public Crop(String type, String growthStage) {
        this.type = type;
        this.growthStage = growthStage;
        this.healthStatus = "Unknown";
    }

    public String getType() {
        return type;
    }

    public String getGrowthStage() {
        return growthStage;
    }

    public abstract void displayInformation();

    // Method to display crop information
    public void displayCropInformation() {
        System.out.println("Crop Information:");
        System.out.println("- Type: " + getType());
        System.out.println("- Growth Stage: " + getGrowthStage());
    }

}

class Wheat extends Crop {
    public Wheat(String type, String growthStage) {
        super(type, growthStage);
    }

    @Override
    public void displayInformation() {
        displayCropInformation();
    }

}

class Corn extends Crop {
    public Corn(String type, String growthStage) {
        super(type, growthStage);
    }

    @Override
    public void displayInformation() {
        displayCropInformation();
    }

}
