/**
 * This parent class construct a building in general
 */
public class Building {

    /** The name of the building */
    protected String name = "<Name Unknown>";

    /** the address of the building */
    protected String address = "<Address Unknown>";

    /** the number of floors of the building, initial nFloors = 1 */
    protected int nFloors = 1;

    /**
     * Construct a building with parameters name, address, and nFloors
     * @param name the name of the building
     * @param address the address of the building
     * @param nFloors the number of floors of the building
     */
    public Building(String name, String address, int nFloors) {
        if (name != null) { this.name = name; }
        if (address != null) { this.address = address; } 
        if (nFloors < 1) {
            throw new RuntimeException("Cannot construct a building with fewer than 1 floor.");
        }
        this.nFloors = nFloors;
    }

    /** Accessor for name of the building */
    public String getName() {
        return this.name;
    }

    /** Accessor for address of the building */
    public String getAddress() {
        return this.address;
    }

    /** Accessor for number of floors of the building */
    public int getFloors() {
        return this.nFloors;
    }

    /** Method to connect every information of a house into a string */
    public String toString() {
        return this.name + " is a " + this.nFloors + "-story building located at " + this.address;
    }

    public static void main(String[] args) {
        Building fordHall = new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4);
        System.out.println(fordHall);
    }

}
