interface CarbonFootprint {
    void trackEmissions();
    void reduceEmissions();
}

class CarbonFootprintImpl implements CarbonFootprint {
    private double currentEmissions;

    public CarbonFootprintImpl(double initialEmissions) {
        this.currentEmissions = initialEmissions;
    }

    @Override
    public void trackEmissions() {
        System.out.println("Current emissions: " + currentEmissions + " tons.");
    }

    @Override
    public void reduceEmissions() {
        // logic to reduce emissions by 10%
        double reducedEmissions = currentEmissions * 0.9;
        System.out.println("Reducing emissions by 10%...");
        System.out.println("Emissions reduced to: " + reducedEmissions + " tons.");
        currentEmissions = reducedEmissions;
    }
}
