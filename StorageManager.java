/** Derek Yin 113251504 Recitation Section 1
*  This class runs a terminal-driven menu that allows a user to insert, remove, select, and read entries in a Storage Table.
*
*  @author Derek Yin
*/

import java.util.Scanner;
import java.io.*;

public class StorageManager {
  private static StorageTable storageTable;

  public static void main(String[] args) {
    File fileTest = new File("storage.obj");
    StorageTable storage = new StorageTable();
    if (!fileTest.exists()){
      storage = new StorageTable();
    }
    else try{
      FileInputStream file = new FileInputStream("storage.obj");
      ObjectInputStream inStream = new ObjectInputStream(file);
      storage = (StorageTable) inStream.readObject();
      inStream.close();
      }
      catch (FileNotFoundException e){

      }
      catch (IOException e){

      }
      catch (ClassNotFoundException e){

      }

      Scanner in = new Scanner(System.in);

      boolean menu = true;
      System.out.println("Hello, and welcome to Rocky Stream Storage Manager\n");
      while (menu){
        System.out.println(" P - Print all storage boxes\n A - Insert into storage box\n R - Remove contents from a storage box\n C - Select all boxes owned by a particular client\n F - Find a box by ID and display its owner and contents\n Q - Quit and save workspace\n X - Quit and delete workspace\n");
        System.out.println("Please select an option");
        String opt = in.nextLine();
        if (opt.equalsIgnoreCase("p")){
          storage.printTable();
        }
        else if (opt.equalsIgnoreCase("a")){
          System.out.println("Please enter id:");
          if (in.hasNextInt()){
            int id = in.nextInt();
            if (id >= 0){
              in.nextLine();
              System.out.println("Please enter client:");
              String client = in.nextLine();
              System.out.println("Please enter Contents:");
              String contents = in.nextLine();
              Storage newStorage = new Storage(id, client, contents);
              try{
                storage.putStorage(id, newStorage);
                System.out.println("New storage added.");
              }
              catch (IllegalArgumentException e){

              }
            }
            else {
              System.out.println("Invalid input.");
              menu = false;
              menu = true;
              in.nextLine();
            }
          }
          else {
            System.out.println("Invalid input.");
            menu = false;
            menu = true;
          }
        }
        else if (opt.equalsIgnoreCase("r")){
          System.out.println("Please enter ID:");
          if (in.hasNextInt()){
            int id = in.nextInt();
            if (id >= 0){
              try{
                storage.removeStorage(id);
                System.out.println("Box " + id + " is now removed.");
                in.nextLine();
              }
              catch (EmptyTableException e){
                System.out.println("Table is empty.");
                menu = false;
                menu = true;
              }
            }
            else {
              System.out.println("Invalid input.");
              menu = false;
              menu = true;
              in.nextLine();
            }
          }
          else {
            System.out.println("Invalid input!");
            menu = false;
            menu = true;
          }
        }
        else if (opt.equalsIgnoreCase("c")){
          System.out.println("Please enter the name of the client:");
          String client = in.nextLine();
          storage.printClient(client);
        }
        else if (opt.equalsIgnoreCase("f")){
          System.out.println("Please enter ID:");
          if (in.hasNextInt()){
            int id = in.nextInt();
            if (storage.getStorage(id) != null){
              System.out.println("Box " + id);
              System.out.println("Contents: " + storage.getStorage(id).getContents());
              System.out.println("Owner: " + storage.getStorage(id).getClient());
              in.nextLine();
            }
            else {
              System.out.println("Invalid ID.");
              menu = false;
              menu = true;
              in.nextLine();
            }
          }
          else {
            System.out.println("Invalid input.");
            menu = false;
            menu = true;
          }
        }
        else if (opt.equalsIgnoreCase("q")){
            try{
              FileOutputStream file1 = new FileOutputStream("storage.obj");
              ObjectOutputStream outStream = new ObjectOutputStream(file1);
              outStream.writeObject(storage);
              outStream.close();
              System.out.println("Storage Manager is quitting, current storage is saved for next session.");
              menu = false;
            }
            catch (FileNotFoundException e){

            }
            catch (IOException e){

            }

        }
        else if (opt.equalsIgnoreCase("x")){
          File file = new File("storage.obj");
          if (file.delete()){
            System.out.println("Storage Manager is quitting, all data is being erased.");
            menu = false;
          }
          else{
            System.out.println("Storage Manager is quitting, all data is being erased.");
            menu = false;
          }
        }



      }

      // add Storage objects to this table


      // saves object in the file.



  }
}
