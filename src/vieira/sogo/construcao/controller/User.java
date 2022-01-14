package vieira.sogo.construcao.controller;

public class User {
    private String name;
    private double facilityLength;
    private double facilityWidth;
    private int quantityOfFacilities;

    public User (String name, double facilityLength, double facilityWidth, int quantityOfFacilities) {
        this.name = name;
        this.facilityLength = facilityLength;
        this.facilityWidth = facilityWidth;
        this.quantityOfFacilities = quantityOfFacilities;
    }

    public String getName() {
        return name;
    }

    public double getFacilityLength() { return facilityLength; }

    public double getFacilityWidth() { return facilityWidth; }

    public int getQuantityOfFacilities() { return quantityOfFacilities; }

}
