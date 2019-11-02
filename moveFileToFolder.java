import java.io.*; 
import java.nio.file.Files; 
import java.nio.file.*; 

public class Advance_File_Manager 
{
  public static File folder = new File("C:/Users/Raj/Desktop/Codes/Images");
  static String temp = "";
  

  public static void main(String[] args) throws IOException
  {
    // TO DO Auto generated Stub
    System.out.println("Reading files under the folder "+ folder.getAbsolutePath());
    moveFilesToFolder(folder);
  }

  public static void moveFilesToFolder(final File folder) throws IOException
  {
   String[] extensionArray = new String[]{"txt", "pdf", "doc", "docx", "zip", "img", "gif", "png", "jpg", "jpeg"};
    for (final File fileEntry : folder.listFiles())
    {
      if (fileEntry.isDirectory())
      {
        moveFilesToFolder(fileEntry);
      }
      else
      {
        if (fileEntry.isFile())
        {
          temp = fileEntry.getName();

          for (int i=0;i<extensionArray.length;i++)
          {
            if ((temp.substring(temp.lastIndexOf('.') + 1, temp.length()).toLowerCase()).equals(extensionArray[i]))
            {
              String fileName = fileEntry.getName();
              new File(folder+"\\"+extensionArray[i]).mkdirs();
              Path extratemp = Files.move 
              (Paths.get("C:\\Users\\Raj\\Desktop\\Codes\\Images\\"+fileName),  
              Paths.get("C:\\Users\\Raj\\Desktop\\Codes\\Images\\"+extensionArray[i]+"\\"+fileName)); 
              try
              {
                  if(extratemp != null) 
                { 
                  System.out.println("File renamed and moved successfully"); 
                } 
                else
                { 
                  System.out.println("Failed to move the file"); 
                } 
              }
              catch (Exception e)
              {
                ;
              }  
            }
          }
        }
      }
    }
  }
}
