import java.util.Scanner;

public class SmartIrrigationSystem {
    private final Sensor soilMoistureSensor;
    private final Sensor weatherSensor;
    private final IrrigationStrategy irrigationStrategy;
    private final DecisionMaker decisionMaker;


    public SmartIrrigationSystem(Sensor soilMoistureSensor, Sensor weatherSensor, IrrigationStrategy irrigationStrategy, DecisionMaker decisionMaker) {
        this.soilMoistureSensor = soilMoistureSensor;
        this.weatherSensor = weatherSensor;
        this.irrigationStrategy = irrigationStrategy;
        this.decisionMaker = decisionMaker;
    }

    public Sensor getSoilMoistureSensor() {
        return soilMoistureSensor;
    }

    public Sensor getWeatherSensor() {
        return weatherSensor;
    }

    public void collectAndProcessData(Scanner scanner) {
        double moistureLevel = soilMoistureSensor.readMoistureLevel();
        String weatherCondition = weatherSensor.readWeatherCondition();

        System.out.println("Sensor Readings:");
        System.out.println("- Soil Moisture Level: " + moistureLevel + "%");
        System.out.println("- Weather Condition: " + weatherCondition);

        double irrigationAmount = irrigationStrategy.determineIrrigationAmount(moistureLevel, weatherCondition);
        System.out.println("\nIrrigation Amount: " + irrigationAmount + " units");

        irrigationStrategy.scheduleIrrigation();

        decisionMaker.makeIrrigationDecision(moistureLevel, weatherCondition);
       //methods to get nitrogen, phosphorus, potassium levels, temperature, and humidity
        decisionMaker.makeFertilizationDecision(getNitrogenLevel(), getPhosphorusLevel(), getPotassiumLevel());
        decisionMaker.makePestControlDecision(getTemperature(), getHumidity());
    }

    private double getNitrogenLevel() {
        return Math.random() * 100; }

    private double getPhosphorusLevel() {
        return Math.random() * 100; }

    private double getPotassiumLevel() {
        return Math.random() * 100; }

    private double getTemperature() {
        return 20 + Math.random() * 15; }

    private double getHumidity() {
        return 50 + Math.random() * 50; }

    public String getLivestockHealthData() {

        return """
                Livestock Health Report:
                1. Cow: Healthy
                2. Sheep: Moderate
                3. Chicken: Good
                """;
    }
}
