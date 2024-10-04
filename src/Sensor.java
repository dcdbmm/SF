import java.util.Random;

interface Sensor {
    double readMoistureLevel();
    String readWeatherCondition();
}

class SoilMoistureSensor implements Sensor {
    private Random random;
    private static final double MIN_MOISTURE_LEVEL = 20.0;
    private static final double MAX_MOISTURE_LEVEL = 80.0;

    public SoilMoistureSensor() {
        this.random = new Random();
    }

    @Override
    public double readMoistureLevel() {
        double randomMoistureLevel = MIN_MOISTURE_LEVEL + (MAX_MOISTURE_LEVEL - MIN_MOISTURE_LEVEL) * random.nextDouble();
        return Math.round(randomMoistureLevel);
    }

    @Override
    public String readWeatherCondition() {
        String[] conditions = {"Sunny", "Rainy", "Cloudy", "Windy"};
        int index = random.nextInt(conditions.length);
        return conditions[index];
    }
}

class WeatherSensor implements Sensor {
    private Random random;

    public WeatherSensor() {
        this.random = new Random();
    }

    @Override
    public double readMoistureLevel() {
        return 0.0;
    }

    @Override
    public String readWeatherCondition() {
        String[] conditions = {"Sunny", "Rainy", "Cloudy", "Windy"};
        int index = random.nextInt(conditions.length);
        return conditions[index];
    }
}

