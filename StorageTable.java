/** Derek Yin 113251504 Recitation Section 1
*  This class defines a hash table that stores Storage objects.
*  @author Derek Yin
*/
import java.io.Serializable;
import java.util.*;
public class StorageTable extends HashMap<Integer, Storage> implements Serializable{
  private int serialVersionUID;
/**
*This is the constructor for the StorageTable
*
*/
  public StorageTable(){
    super();
  }
/**
*This method checks if this Table is empty.
*@return
*true if empty, false if not empty.
*
*/
  public boolean isEmpty(){
    return super.isEmpty();
  }

/**
*This method adds a desired Storage to the StorageTable
*@param storageId
*desired ID of storage to be added to the Table
*@param storage
*Storage to be added to the StorageTable
*@throws
*IllegalArgumentException if StorageID is negative or Storage object is null.
*/
  public void putStorage(int storageId, Storage storage) throws IllegalArgumentException{
    if (storageId < 0 || storage == null) throw new IllegalArgumentException();
    //also handle duplicate storageid
    super.put(storageId, storage);
  }

/**
*This method accesses the Storage at the desired ID.
*@param storageId
*desired ID of storage to be accessed
*@return
*Desired Storage
*/
  public Storage getStorage(int storageId){
    return super.get(storageId);
  }
/**
*This method accesses the Storage at the desired ID.
*@param storageId
*desired ID of storage to be removed
*@return
*Desired Storage removed
*@throws
*EmptyTableException when Table is empty.
*/
  public Storage removeStorage(int storageId) throws EmptyTableException{
    if (this.isEmpty()) throw new EmptyTableException("");
    return super.remove(storageId);
  }
  /**
  *This method prints the entire table.
  *
  */
  public void printTable(){
    String pr = String.format("%-11s%-20s%-19s", "Box#", "Contents", "Owners");
    pr += "\n---------------------------------------------------------\n";
    Iterator hmIterator = this.entrySet().iterator();
    while (hmIterator.hasNext()){
      Map.Entry mapElement = (Map.Entry)hmIterator.next();
      pr += String.format("%-11d%-20s%-19s", (int)mapElement.getKey(), (((Storage)mapElement.getValue()).getContents()), (((Storage)mapElement.getValue()).getClient()));
      pr += "\n";
    }
    System.out.println(pr);
  }
/**
*This method prints a Table of all Storage with specified client. 
*@param client
*Name of all Storage with desired Client to print.
*/
  public void printClient(String client){
    String pr = String.format("%-11s%-20s%-19s", "Box#", "Contents", "Owners");
    pr += "\n---------------------------------------------------------\n";
    boolean exists = false;
    Iterator hmIterator = this.entrySet().iterator();
    while (hmIterator.hasNext()){
      Map.Entry mapElement = (Map.Entry)hmIterator.next();
      if ((((Storage)mapElement.getValue()).getClient()).equals(client)){
        exists = true;
        pr += String.format("%-11d%-20s%-19s", (int)mapElement.getKey(), (((Storage)mapElement.getValue()).getContents()), (((Storage)mapElement.getValue()).getClient()));
        pr += "\n";
      }

    }
    System.out.println(pr);
    if (!exists){
      System.out.println("Client " + client + " not found.");
    }
  }




}
