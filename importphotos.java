import hsa.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.awt.image.*;
import javax.imageio.*;

public class importphotos{
  public static void main (String[]args){
    Console con = new Console ();
    //we need these two variables to import a picture file.
    File picturefile;
    BufferedImage pictureimage;
    picturefile = null;
    pictureimage = null;
    
    try{
      //try to open the picture file and import the contents of the file
      //into the buffered image variable
      picturefile = new File("logo.jpg");
      pictureimage = ImageIO.read(picturefile);
    }
    catch(IOException e){
      con.println("Error, unable to open file or load contents");
    }
    
    con.drawImage(pictureimage,200,100,null);
  }
}