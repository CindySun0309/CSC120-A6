import java.util.ArrayList;

/* This is a stub for the House class */
public class House extends Building {

  private ArrayList<String> residents;
  private boolean hasDiningRoom;

  public House(String name, String address, int nFloors, boolean hasDiningRoom) {
    super(name, address, nFloors);
    this.residents = new ArrayList<String>();
    this.hasDiningRoom = hasDiningRoom;
  }

  /** Accessor for hasDiningRoom */
  public boolean hasDiningRoom() {
    return this.hasDiningRoom;
  }

  /** Accessor for number of residents */
  public int nResidents() {
    return this.residents.size();
  }

  public void moveIn(String name) {
    // check if this.residents contains name
    if (this.residents.contains(name)) {
      //   if so: throw and exception
      throw new RuntimeException(name + " is already a resident of " + this.name);
    }
    // if we're good to go, add to roster
    this.residents.add(name);
    System.out.println(name + " has just moved into " + this.name + "! Go say hello :-)");
  }

  public String moveOut(String name) { 
    // check if this.residents contains name
    if (!this.residents.contains(name)) {
      // if the person is not in the house : throw and exception
      throw new RuntimeException("Cannot remove " + name + " because " + name + " is not a resident of " + this.name);
    }
    // if we're good to go, delete from roster
    this.residents.remove(name);
    System.out.println(name + " has just removed from " + this.name + "! Go say goodbye :-(");
    // return the name of the person who moved out
    return name;
  }

  public boolean isResident(String person) {
    if (this.residents.contains(person)) {
      System.out.println(person + " is a resident of " + this.name + ".");
      return true;
    }
    else {
      System.out.println(person + " is a not resident of " + this.name + ".");
      return false;
    }
  }

  public String toString() {
    String description = super.toString();
    description += " There are currently " + this.nResidents() + " people living in this house.";
    description += " This house ";
    if (this.hasDiningRoom) {
      description += "has";
    } else {
      description += "does not have";
    }
    description += " an active dining room.";
    return description;
  }

  public static void main(String[] args) {
    House morrow = new House("Morrow", "The Quad", 4, false);
    System.out.println(morrow);
    morrow.moveIn("Jordan");
    //morrow.moveIn("Jordan");
    morrow.isResident("Jordan");
    morrow.isResident("Cindy");
    System.out.println(morrow);
    //morrow.moveOut("Jordan");
    //morrow.moveOut("Jordan");
    //morrow.moveOut("Cindy");
    morrow.moveIn("Cindy");
    System.out.println(morrow);
    
    House king = new House("King", "The Quad", 3, true);
    System.out.println(king);
  }

}