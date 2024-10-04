class WasteManagement {
    private final int wasteLevel; // Assume waste level is measured in percentage

    public WasteManagement() {
        //waste level to a random value between 0 and 100
        this.wasteLevel = (int) (Math.random() * 101);
    }

    public void manageWaste() {
        System.out.println("Waste management performed.");
        //waste management logic
        if (wasteLevel > 70) {
            System.out.println("Waste level is high. Initiating waste disposal.");
            disposeWaste();
        } else {
            System.out.println("Waste level is normal.");
        }
    }

    public void recycleMaterials() {
        System.out.println("Recycling materials...");
        //recycling process takes some time
        try {
            Thread.sleep(2000); // Simulate recycling process for 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Recycling process completed.");
    }

    private void disposeWaste() {
        System.out.println("Disposing waste...");
        try {
            Thread.sleep(3000); // Simulate waste disposal process for 3 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Waste disposal completed.");
    }
}
