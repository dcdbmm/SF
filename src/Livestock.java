abstract class Livestock {
    private String name;
    private int age;
    private String breed;
    protected String healthStatus; // Moved to the superclass


    public Livestock(String name, int age, String breed) {
        this.name = name;
        this.age = age;
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getBreed() {
        return breed;
    }

    // Method to track health indicators
    public abstract void trackHealthIndicators();

    // Method to display information
    public abstract void displayInformation();
}

class Cow extends Livestock {
    private final int milkProductionLevel;

    public Cow(String name, int age, String breed, int milkProductionLevel) {
        super(name, age, breed);
        this.milkProductionLevel = milkProductionLevel;
    }

    @Override
    public void trackHealthIndicators() {
        //logic to track health indicators for a cow
        if (milkProductionLevel < 3) {
            healthStatus = "Poor";
        } else if (milkProductionLevel < 6) {
            healthStatus = "Fair";
        } else {
            healthStatus = "Good";
        }
    }

    @Override
    public void displayInformation() {
        System.out.println("Livestock Information:");
        System.out.println("- Name: " + getName());
        System.out.println("- Age: " + getAge() + " years");
        System.out.println("- Breed: " + getBreed());
        System.out.println("- Milk Production Level: " + milkProductionLevel);
        System.out.println("- Health Status: " + healthStatus);
    }
}

class Sheep extends Livestock {
    private final int woolQuality;

    public Sheep(String name, int age, String breed, int woolQuality) {
        super(name, age, breed);
        this.woolQuality = woolQuality;
    }

    @Override
    public void trackHealthIndicators() {
        //logic to track health indicators for a sheep
        if (woolQuality < 2) {
            healthStatus = "Poor";
        } else if (woolQuality < 4) {
            healthStatus = "Fair";
        } else {
            healthStatus = "Good";
        }
    }

    @Override
    public void displayInformation() {
        System.out.println("Livestock Information:");
        System.out.println("- Name: " + getName());
        System.out.println("- Age: " + getAge() + " years");
        System.out.println("- Breed: " + getBreed());
        System.out.println("- Wool Quality: " + woolQuality);
        System.out.println("- Health Status: " + healthStatus);
    }
}

class Chicken extends Livestock {
    private final int eggProductionLevel;

    public Chicken(String name, int age, String breed, int eggProductionLevel) {
        super(name, age, breed);
        this.eggProductionLevel = eggProductionLevel;
    }

    @Override
    public void trackHealthIndicators() {
        //logic to track health indicators for a chicken
        if (eggProductionLevel < 3) {
            healthStatus = "Poor";
        } else if (eggProductionLevel < 6) {
            healthStatus = "Fair";
        } else {
            healthStatus = "Good";
        }
    }

    @Override
    public void displayInformation() {
        System.out.println("Livestock Information:");
        System.out.println("- Name: " + getName());
        System.out.println("- Age: " + getAge() + " years");
        System.out.println("- Breed: " + getBreed());
        System.out.println("- Egg Production Level: " + eggProductionLevel);
        System.out.println("- Health Status: " + healthStatus);
    }
}
