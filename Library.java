import java.util.Hashtable;

/* This is a stub for the Library class */
public class Library extends Building {

  private Hashtable<String, Boolean> collection;
  
    public Library(String name, String address, int nFloors) {
      super(name, address, nFloors);
      this.collection = new Hashtable<String, Boolean>();
      System.out.println("You have built a library: 📖");
    }
  
    public void addTitle(String title) {
      // check if the book title is already in the library
      if (this.collection.containsKey(title)) {
        throw new RuntimeException("Error! " + title + " is already in the collection of " + this.name + ".");
      }
      this.collection.put(title, true);
      System.out.println(title + " has just moved into the collection of " + this.name + ".");
    }

    public String removeTitle(String title) {
      if (!this.collection.containsKey(title)) {
        throw new RuntimeException("Error! " + title + " is not in the collection of " + this.name + ".");
      }
      // return the title that we removed
      this.collection.remove(title);
      System.out.println(title + " has been removed from the collection of " + this.name + ".");
      return title;
    } 
    
    public void checkOut(String title) {
      if (!this.collection.containsKey(title)) {
        throw new RuntimeException("Error! " + title + " is not in the collection of " + this.name + ".");
      }
      if (this.collection.get(title) == false) {
        throw new RuntimeException("Error! " + title + " is already checked out.");
      }
      collection.replace(title, true, false);
      System.out.println(title + " is successfully checked out from " + this.name + ".");
    }
    
    public void returnBook(String title) {
      if (!this.collection.containsKey(title)) {
        throw new RuntimeException("Error! " + title + " is not in the collection of " + this.name + ".");
      }
      if (this.collection.get(title) == true) {
        throw new RuntimeException("Error! " + title + " cannot be returned to " + this.name + " because it was not borrowed from this library.");
      }
      collection.replace(title, false, true);
      System.out.println(title + " is successfully return to " + this.name + ".");
    }

    public boolean containsTitle(String title) {
      // returns true if the title appears as a key in the Libary's collection, false otherwise
      if (this.collection.containsKey(title)) {
        return true;
      }
      else {
        return false;
      }
    }

    public boolean isAvailable(String title) {
      // returns true if the title is currently available, false otherwise
      if (this.collection.get(title) == true) {
        return true;
      }
      else {
        return false;
      }
    }
    
    public void printCollection() {
      // prints out the entire collection in an easy-to-read way (including checkout status)
      
    }

    public static void main(String[] args) {
      Library neilson = new Library("Neilson", "some street", 4);
      neilson.addTitle("Bird Book");
      try {
        neilson.addTitle("Bird Book");
      }
      catch (Exception e) {
        System.out.println("Error! This book is already in the collection of " + neilson.getName() + "!");
      }
      //neilson.removeTitle("Bird Book");
      //neilson.removeTitle("Bird Book");
      neilson.checkOut("Bird Book");
      //neilson.checkOut("Bird Book");
      neilson.returnBook("Bird Book");
      neilson.returnBook("Bird Book");
      //neilson.checkOut("AAA");
      //neilson.returnBook("AAA");
    }
  }