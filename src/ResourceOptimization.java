interface ResourceOptimization {
    void optimizeWaterUsage();
    void optimizeEnergyUsage();
    void optimizeResourceUsage();
    double getWaterUsage();
    double getEnergyUsage();
}


class ResourceOptimizationImpl implements ResourceOptimization {
    private double waterUsage;
    private double energyUsage;

    @Override
    public void optimizeWaterUsage() {
        //water usage optimization logic
        waterUsage = calculateWaterUsage();
        System.out.println("Water usage optimized.");
    }

    @Override
    public void optimizeEnergyUsage() {
        //energy usage optimization logic
        energyUsage = calculateEnergyUsage();
        System.out.println("Energy usage optimized.");
    }

    @Override
    public void optimizeResourceUsage() {
        waterUsage = 100.0;
        energyUsage = 200.0;
    }


    @Override
    public double getWaterUsage() {
        return waterUsage;
    }

    @Override
    public double getEnergyUsage() {
        return energyUsage;
    }

    private double calculateWaterUsage() {
        // Calculate water usage based on crop type and area
        double area = 1000;
        double waterConsumptionPerSquareMeter = 10;
        return area * waterConsumptionPerSquareMeter;
    }

    private double calculateEnergyUsage() {
        //Calculate energy usage based on number of sensors and devices
        int numSensors = 10;
        int numDevices = 5;
        double energyConsumptionPerSensor = 0.5;
        double energyConsumptionPerDevice = 2.0;
        double sensorEnergyUsage = numSensors * energyConsumptionPerSensor;
        double deviceEnergyUsage = numDevices * energyConsumptionPerDevice;
        return sensorEnergyUsage + deviceEnergyUsage;
    }
}