import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Sensor soilMoistureSensor = new SoilMoistureSensor();
        Sensor weatherSensor = new WeatherSensor();
        IrrigationStrategy irrigationStrategy = new BasicIrrigationStrategy();
        DecisionMaker decisionMaker = new DecisionMakerImpl();
        SmartIrrigationSystem smartIrrigationSystem = new SmartIrrigationSystem
                (soilMoistureSensor, weatherSensor, irrigationStrategy, decisionMaker);
        ResourceOptimization resourceOptimization = new ResourceOptimizationImpl();
        WasteManagement wasteManagement = new WasteManagement();
        CarbonFootprintImpl carbonFootprint = new CarbonFootprintImpl(100.0);


        Livestock[] livestockArray = {
                new Cow("Bessie", new Random().nextInt(10) + 1, "Jersey", (int) (Math.random() * (200 - 50) + 50)),
                new Sheep("Fluffy", new Random().nextInt(10) + 1, "Merino", (int) (Math.random() * (100 - 30) + 30)),
                new Chicken("Henrietta", new Random().nextInt(5) + 1, "Leghorn", (int) (Math.random() * (5 - 1) + 1))
        };

        int choice;
        System.out.println("\nWelcome to your Smart Farming System!");
        carbonFootprint.trackEmissions();
        carbonFootprint.trackEmissions();
        do {
            System.out.println("\nMain Menu:");
            System.out.println("1. View Sensor Data");
            System.out.println("2. Configure Settings");
            System.out.println("3. Perform Actions");
            System.out.println("4. Generate Reports");
            System.out.println("5. Manage Livestock");
            System.out.println("6. Manage Crops");
            System.out.println("7. System Information");
            System.out.println("8. Exit");
            System.out.print("\nPlease enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    viewSensorDataMenu(scanner, smartIrrigationSystem);
                    break;
                case 2:
                    configureSettingsMenu(scanner);
                    break;
                case 3:
                    performActionsMenu(scanner, smartIrrigationSystem, livestockArray, carbonFootprint);
                    break;
                case 4:
                    generateReportsMenu(scanner, smartIrrigationSystem, resourceOptimization);
                    break;
                case 5:
                    manageLivestockMenu(scanner, livestockArray);
                    break;
                case 6:
                    manageCropsMenu(scanner);
                    break;
                case 7:
                    systemInformationMenu(scanner,wasteManagement);
                    break;
                case 8:
                    System.out.println("Exiting Smart Farming System... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 8);
    }

    private static void viewSensorDataMenu(Scanner scanner, SmartIrrigationSystem smartIrrigationSystem) {
        int choice;
        do {
            System.out.println("\nView Sensor Data Menu:");
            System.out.println("1. View Soil Moisture Levels");
            System.out.println("2. View Weather Conditions");
            System.out.println("3. Back to Main Menu");
            System.out.print("\nPlease enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("\nCurrent Soil Moisture Level: " + smartIrrigationSystem.getSoilMoistureSensor().readMoistureLevel() + "%");
                    break;
                case 2:
                    System.out.println("\nCurrent Weather Condition: " + smartIrrigationSystem.getWeatherSensor().readWeatherCondition());
                    break;
                case 3:
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);
    }


    private static void configureSettingsMenu(Scanner scanner) {
        int choice;
        do {
            System.out.println("\nConfigure Settings Menu:");
            System.out.println("1. Set Irrigation Frequency");
            System.out.println("2. Set Irrigation Duration");
            System.out.println("3. Back to Main Menu");
            System.out.print("\nPlease enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    //irrigation frequency logic
                    int minFrequency = 1;
                    int maxFrequency = 10;
                    int frequency = generateRandomInRange(minFrequency, maxFrequency);
                    System.out.println("Irrigation frequency set to: " + frequency + " times per day");
                    break;
                case 2:
                    //irrigation duration logic
                    int minDuration = 10; // in minutes
                    int maxDuration = 60; // in minutes
                    int duration = generateRandomInRange(minDuration, maxDuration);
                    System.out.println("Irrigation duration set to: " + duration + " minutes per session");
                    break;
                case 3:
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);
    }
    private static int generateRandomInRange(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }


    private static void performActionsMenu(Scanner scanner, SmartIrrigationSystem smartIrrigationSystem,
                                           Livestock[] livestockArray, CarbonFootprintImpl carbonFootprint) {
        int choice;
        do {
            System.out.println("\nPerform Actions Menu:");
            System.out.println("1. Initiate Sensor Readings");
            System.out.println("2. Feed Livestock");
            System.out.println("3. Administer Medication to Livestock");
            System.out.println("4. Track Emissions");
            System.out.println("5. Reduce Emissions");
            System.out.println("6. Back to Main Menu");
            System.out.print("\nPlease enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    // Initiate sensor readings logic
                    //System.out.println("Initiating sensor readings...");
                    smartIrrigationSystem.collectAndProcessData(scanner);
                    break;
                case 2:
                    // Feed livestock logic
                    feedLivestock(livestockArray);
                    break;
                case 3:
                    administerMedication(livestockArray);
                    break;
                case 4:
                    carbonFootprint.trackEmissions();
                    break;
                case 5:
                    carbonFootprint.reduceEmissions();
                    break;
                case 6:
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);
    }

    private static void feedLivestock(Livestock[] livestockArray) {
            // Print a message indicating that the livestock is being fed
        System.out.println("Feed Livestock:");
        for (Livestock livestock : livestockArray) {
            int hayAmount = generateRandomAmount();
            int grainAmount = generateRandomAmount();
            System.out.println("- Feeding " + livestock.getName() + " with " + hayAmount
                    + " kg of hay and " + grainAmount + " kg of grains.");
        }
    }

    private static void administerMedication(Livestock[] livestockArray) {
            // Print a message indicating that medication is being administered to the livestock
        for (Livestock livestock : livestockArray) {
            System.out.println("Administering medication to " + livestock.getName() + "...");
            int dosage = generateRandomDosage();
            String injectionSite = generateRandomInjectionSite();
            System.out.println("- Administering vaccination to " + livestock.getName() + ".");
            System.out.println("- Dosage: " + dosage + " ml");
            System.out.println("- Injection Site: " + injectionSite);
        }
    }

    private static int generateRandomAmount() {
        // Generate a random value between 1 and 5
        return (int) (Math.random() * 5 + 1);
    }

    private static int generateRandomDosage() {
        // Generate a random value between 1 and 10
        return (int) (Math.random() * 10 + 1);
    }

    // Method to generate random injection site
    private static String generateRandomInjectionSite() {
        // Array of possible injection sites
        String[] sites = {"Intramuscular", "Subcutaneous", "Intravenous"};
        // Generate a random index to select an injection site
        int index = new Random().nextInt(sites.length);
        return sites[index];
    }



    private static void generateReportsMenu(Scanner scanner, SmartIrrigationSystem smartIrrigationSystem, ResourceOptimization resourceOptimization) {
        int choice;
        do {
            System.out.println("\nGenerate Reports Menu:");
            System.out.println("1. Generate Resource Usage Report");
            System.out.println("2. Generate Livestock Health Report");
            System.out.println("3. Optimize Resource Usage");
            System.out.println("4. Back to Main Menu");
            System.out.print("\nPlease enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    generateResourceUsageReport(resourceOptimization);
                    break;
                case 2:
                    generateLivestockHealthReport(smartIrrigationSystem);
                    break;
                case 3:
                    resourceOptimization.optimizeResourceUsage();
                    System.out.println("Resource usage optimized.");
                    break;
                case 4:
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

    private static void generateResourceUsageReport(ResourceOptimization resourceOptimization) {
        // Optimize resource usage first to get accurate data
        resourceOptimization.optimizeWaterUsage();
        resourceOptimization.optimizeEnergyUsage();

        // Retrieve resource usage data
        double waterUsage = resourceOptimization.getWaterUsage();
        double energyUsage = resourceOptimization.getEnergyUsage();

        // Display resource usage report
        System.out.println("\nResource Usage Report:");
        System.out.println("Water Usage: " + waterUsage + " liters per day");
        System.out.println("Energy Usage: " + energyUsage + " kWh per day");
    }

    private static void generateLivestockHealthReport(SmartIrrigationSystem smartIrrigationSystem) {
        String livestockHealthData = smartIrrigationSystem.getLivestockHealthData();

        // Display livestock health report
        System.out.println(livestockHealthData);
    }


    private static void manageLivestockMenu(Scanner scanner, Livestock[] livestockArray) {
        int choice;
        do {
            System.out.println("\nManage Livestock Menu:");
            System.out.println("1. View Livestock Information");
            System.out.println("2. Track Livestock Health Indicators");
            System.out.println("3. Back to Main Menu");
            System.out.print("\nPlease enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    // View livestock information logic
                    viewLivestockInformation(livestockArray);
                    break;
                case 2:
                    // Track livestock health indicators logic
                   trackLivestockHealthIndicators(livestockArray);
                    break;
                case 3:
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);
    }



    private static void viewLivestockInformation(Livestock[] livestockArray) {
        System.out.println("\nLivestock Information:");
        for (Livestock livestock : livestockArray) {
            livestock.displayInformation();
            System.out.println();
        }
    }

    private static void trackLivestockHealthIndicators(Livestock[] livestockArray) {
        System.out.println("\nTracking Livestock Health Indicators:");
        for (Livestock livestock : livestockArray) {
            livestock.trackHealthIndicators();
            System.out.println("Health status of " + livestock.getName() + ": " + livestock.healthStatus);
        }
    }



    private static void manageCropsMenu(Scanner scanner) {
        int choice;
        do {
            System.out.println("\nManage Crops Menu:");
            System.out.println("1. View Crop Information");
            System.out.println("2. Monitor Crop Health");
            System.out.println("3. Back to Main Menu");
            System.out.print("\nPlease enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    viewCropInformation(new Crop[]{new Wheat("Wheat", "Tillering Stage"),
                            new Corn("Corn", "Seedling Stage")}); // Pass instances of Wheat and Corn to Crop array
                    break;
                case 2:
                    monitorCropHealth();
                    break;
                case 3:
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);
    }

    private static void viewCropInformation(Crop[] crops) {
        System.out.println("\nCrop Information:");
        for (Crop crop : crops) {
            crop.displayInformation();
            System.out.println();
        }
    }

    private static void monitorCropHealth() {
        Crop[] crops = new Crop[]{new Wheat("Wheat", "Tillering Stage"), new Corn("Corn", "Seedling Stage")};

        for (Crop crop : crops) {
            System.out.println("Monitoring crop health for " + crop.getType() + "...");
            String healthStatus = generateRandomHealthStatus();
            crop.healthStatus = healthStatus;
            System.out.println("Health status of " + crop.getType() + ": " + healthStatus);
        }

        System.out.println("Crop health monitoring completed.");
    }

    private static String generateRandomHealthStatus() {
        String[] healthStatuses = {"Healthy", "Moderate", "Poor"};
        int randomIndex = (int) (Math.random() * healthStatuses.length);
        return healthStatuses[randomIndex];
    }


    private static void displayOverallHealth() {
        System.out.println("System Overall Health: Good");
    }

    private static void displaySoftwareVersion() {
        System.out.println("Software Version: v1.2.0");
    }


    private static void systemInformationMenu(Scanner scanner, WasteManagement wasteManagement) {
        int choice;
        do {
            System.out.println("\nSystem Information Menu:");
            System.out.println("1. Display Overall Health");
            System.out.println("2. Display Software Version");
            System.out.println("3. Perform Waste Management");
            System.out.println("4. Recycle Materials");
            System.out.println("5. Back to Main Menu");
            System.out.print("\nPlease enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    displayOverallHealth();
                    break;
                case 2:
                    displaySoftwareVersion();
                    break;
                case 3:
                    wasteManagement.manageWaste();
                    break;
                case 4:
                    wasteManagement.recycleMaterials();
                    break;
                case 5:
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }
}
