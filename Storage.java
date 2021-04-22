/** Derek Yin 113251504 Recitation Section 1
*  This class defines the Storage object that represents the nodes of a hash table.
*
*  @author Derek Yin
*/
import java.io.Serializable;
public class Storage implements Serializable{
  private static long serialVersionUID;
  private int id;
  private String client;
  private String contents;
/**
*This is the constructor for the Storage object.
*
*@param initId
*desired initial ID of the Storage
*@param initClient
*desired initial client of the Storage
*@param initContents
*desired initial contents of the Storage.
*
*/
  public Storage(int initId, String initClient, String initContents){
    id = initId;
    client = initClient;
    contents = initContents;
  }
/**
*This getter returns the id of this Storage.
*@return
*Id value of this Storage.
*
*/
  public int getID(){
    return id;
  }
/**
*This getter returns the name of the Client of this Storage.
*@return
*Name of the Client of this Storage.
*
*/
  public String getClient(){
    return client;
  }
/**
*This getter returns the contents of this Storage.
*@return
*Name of the contents of this Storage.
*
*/
  public String getContents(){
    return contents;
  }
/**
*This method sets the ID of this Storage.
*@param
*desired new ID of this Storage.
*
*/
  public void setID(int newID){
    id = newID;
  }
/**
*This method sets a new Client for this Storage.
*@param
*desired new client of this storage.
*
*/
  public void setClient(String newClient){
    client = newClient;
  }
/**
*This method sets new contents for this Storage.
*@param
*desired new contents of this storage.
*
*/
  public void setContents(String newContents){
    contents = newContents;
  }
}
