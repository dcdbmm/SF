interface DecisionMaker {
    void makeIrrigationDecision(double moistureLevel, String weatherCondition);
    void makeFertilizationDecision(double nitrogenLevel, double phosphorusLevel, double potassiumLevel);
    void makePestControlDecision(double temperature, double humidity);
}

class DecisionMakerImpl implements DecisionMaker {
    @Override
    public void makeIrrigationDecision(double moistureLevel, String weatherCondition) {
        //decision-making logic for irrigation
        if (moistureLevel < 30 && (weatherCondition.equals("Sunny") || weatherCondition.equals("Cloudy"))) {
            System.out.println("Based on current conditions, irrigation is recommended.");
        } else {
            System.out.println("No irrigation needed at the moment.");
        }
    }

    @Override
    public void makeFertilizationDecision(double nitrogenLevel, double phosphorusLevel, double potassiumLevel) {
        //decision-making logic for fertilization
        if (nitrogenLevel < 20 || phosphorusLevel < 10 || potassiumLevel < 15) {
            System.out.println("Fertilization recommended due to low nutrient levels.");
        } else {
            System.out.println("No fertilization needed at the moment.");
        }
    }

    @Override
    public void makePestControlDecision(double temperature, double humidity) {
        //decision-making logic for pest control
        if (temperature > 25 && humidity > 70) {
            System.out.println("Pest control recommended due to high temperature and humidity.");
        } else {
            System.out.println("No pest control needed at the moment.");
        }
    }
}
