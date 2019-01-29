import hsa.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.awt.image.*;
import javax.imageio.*;
public class CPTtools{
  public static void importimage (Console con,String strFileName,int intX,int intY){//import an image
    File picturefile;
    BufferedImage pictureimage;
    picturefile = null;
    pictureimage = null;
    try{
      //try to open the picture file and import the contents of the file
      //into the buffered image variable
      picturefile = new File(strFileName);
      pictureimage = ImageIO.read(picturefile);
    }
    catch(IOException e){//if the picture doesn't load print this
      con.println("Error, unable to open file or load contents");
    }   
    con.drawImage(pictureimage,intX,intY,null);
  }
  public static void pause(int intMS){//delay 
    try{
      Thread.sleep(intMS);
    }catch(InterruptedException e){
    }
  }
  public static int linecount(String strTextFile){//count the number of lines given a text file
    int intLineCount=0;
    
    TextInputFile Quiz = new TextInputFile (strTextFile);
    while (Quiz.eof()==false){//read lines until end of file
      Quiz.readLine();
      intLineCount = intLineCount+1;
    }
    Quiz.close();//close the file
    return intLineCount;
  }
  //If statement to match the options with the actual answer
  public static char answer(String strAnswer, String strOptionA,String strOptionB, String strOptionC, String strOptionD){
    char chrAnswer='a';
    if (strAnswer.equals(strOptionA)){
      chrAnswer='a';
    }
    else if (strAnswer.equals(strOptionB)){
      chrAnswer='b';
    }
    else if (strAnswer.equals(strOptionC)){
      chrAnswer='c';
    }
    else if (strAnswer.equals(strOptionD)){
      chrAnswer='d';
    }
    return chrAnswer;
  }
  public static void highscore (String strName, int intScore, String strQuizName){//printing the highscore to the text file
    TextOutputFile highscore = new TextOutputFile("scores.txt",true);
    highscore.println(strName);
    highscore.println(intScore);
    highscore.println(strQuizName);
  }
}