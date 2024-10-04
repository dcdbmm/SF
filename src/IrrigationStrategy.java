abstract class IrrigationStrategy {
    abstract double determineIrrigationAmount(double moistureLevel, String weatherCondition);
    abstract void scheduleIrrigation();
}

class BasicIrrigationStrategy extends IrrigationStrategy {
    @Override
    double determineIrrigationAmount(double moistureLevel, String weatherCondition) {
        // Implement basic irrigation amount calculation
        return 20.0; // Simulated value for demonstration
    }

    @Override
    void scheduleIrrigation() {
        // Implement basic irrigation scheduling
        System.out.println("Basic irrigation scheduled for fixed times of the day.");
    }
}

