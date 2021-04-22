/** Derek Yin 113251504 Recitation Section 1
*  This class defines the exception called when the user tries to add to a tree that is full.
*
*  @author Derek Yin
*/
public class EmptyTableException extends Exception{
/**
*This is the constructor for the EmptyTableException
*
*@param message
*the error message to be displayed
*
*/
  public EmptyTableException(String message){
    super(message);
  }

}
