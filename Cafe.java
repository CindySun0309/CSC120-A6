/**
 * This class extends from the Building parent class
 * and construct a Cafe
 */
public class Cafe extends Building{

    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory

    /**
     * construct a cafe with parameters below
     * @param name the name of the cafe
     * @param address the address of the cafe
     * @param nFloors the number of floors of the cafe
     * @param nCoffeeOunces the amount of coffee (in ounce) in the inventory of the cafe
     * @param nSugarPackets the number of sugar packets in the inventory of the cafe
     * @param nCreams the number of creams in the inventory of the cafe
     * @param nCups the number of cups of coffee in the inventory of the cafe
     */
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        System.out.println("You have built a cafe: ☕");
    }

    /**
     * Method to sell coffee
     * @param size the amount of coffee (in ounce) to sell
     * @param nSugarPackets the number of sugar packets to sell
     * @param nCreams the number of creams to sell
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        //check if all requirements are met
        if (this.nCoffeeOunces >= size && 
            this.nSugarPackets >= nSugarPackets && 
            this.nCreams >= nCreams && 
            this.nCups >= 1) {
                //sell the coffee if all requirements are met
                this.nCoffeeOunces -= size;
                this.nSugarPackets -= nSugarPackets;
                this.nCreams -= nCreams;
                this.nCups -= 1;
                System.out.println("Successfully sold coffee!");
        }
        else {
            //restock the right amount of nCoffeeOunces, nSugarPackets, nCreams, and nCups
            this.restock(Math.max(0, size - this.nCoffeeOunces), 
                         Math.max(0, nSugarPackets - this.nSugarPackets), 
                         Math.max(0, nCreams - this.nCreams), 
                         Math.max(0, 1 - this.nCups));
            //after restocked the inventory, sell the coffee
            this.nCoffeeOunces -= size;
                this.nSugarPackets -= nSugarPackets;
                this.nCreams -= nCreams;
                this.nCups -= 1;
                System.out.println("Restocked the inventory and successfully sold coffee!");
        }
    }

    /**
     * Method to restock the inventory accroding to needs
     * @param nCoffeeOunces the amount of coffee (in ounce) to restock
     * @param nSugarPackets the number of sugar packets to restock
     * @param nCreams the number of creams to restock
     * @param nCups the number of cups to restock
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
    }




    public static void main(String[] args) {
        Cafe campusCenter = new Cafe("Campus Center Cafe", "some street", 1, 2, 2, 2, 2);
        campusCenter.sellCoffee(3,2, 1);
    }
    
}
