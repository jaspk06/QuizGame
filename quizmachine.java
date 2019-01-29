import hsa.*;
import java.awt.*;
public class quizmachine{
  public static void main (String[]args){
    Console con = new Console(24,80);
    
    int intLineCount;//counts number of lines in a text file
    int intQuestionCount;//number of questions in a quiz text file
    int intCount;//counter for for loop
    int intScore;//the amount of questions answered correctly
    int intScoreCount;//Counts the number of questions in a quiz while it is being played
    int intPercentage;
    int intLoopCode=0;//loop the code so i can go back to the main menu
    int intSelectionLoop;
    char chrAnswerInput;//the answer the user inputs
    char chrAnswer='a';//the value that is for the actual correct answer
    char chrMenu;//selection for main menu
    char chrQuizSelection;//menu selection for selecting quiz
    char chrNext;//char for the press any key to continue parts
    String strName;//store the player name
    String strQuizFile="";//change the type of quiz
    String strQuizName="";//change the quiz name in the high scores
    con.setColor(Color.white);
    
    //intro logo plays once
    CPTtools.importimage(con,"logo.jpg",200,100);//import logo
    CPTtools.pause(2000);
    con.clear();  
    
    //main menu
    CPTtools.importimage(con,"menu.jpg",0,0);
    chrMenu = con.getChar();//get the input for the menu
    intSelectionLoop=0;//make sure the loop for the selection will loop
    while (intLoopCode ==0){
      if (chrMenu == 'a' || chrMenu == 'A'){  //the code for the game
        con.clear();
        CPTtools.importimage(con,"Quizselect.jpg",0,0);//import the quiz select screen
        chrQuizSelection = con.getChar();//get the input for the quiz selection
        
        while (intSelectionLoop==0){//loop the quiz selection so if the input is not valid, keep asking for an input
          if (chrQuizSelection == 'a' || chrQuizSelection == 'A'){//user chooses computer quiz   
            strQuizFile = "Computer.txt";
            strQuizName = "Computer Quiz";
            intSelectionLoop=1;//exit loop
          }
          else if (chrQuizSelection == 'b' || chrQuizSelection == 'B'){//user chooses nba quiz   
            strQuizFile = "NBA.txt";
            strQuizName = "NBA Quiz";
            intSelectionLoop=1;//exit loop
          }
          else if (chrQuizSelection == 'c' || chrQuizSelection == 'C'){//user chooses CSGO quiz   
            strQuizFile = "CSGO.txt";
            strQuizName = "CSGO Quiz";
            intSelectionLoop=1;//exit loop
          }
          else {//if
            chrQuizSelection = con.getChar();//keep asking for valid input
          } 
        }
        con.clear();
        intLineCount = CPTtools.linecount(strQuizFile);//count number of lines in computer quiz
        intQuestionCount = intLineCount/6;//number of questions in computer quiz
        
        String strQuestion[][];//new 2d array to store the information in the quiz files
        strQuestion = new String [6][intQuestionCount];//6 rows of text by the number of questions          
        TextInputFile ComputerQuizVar = new TextInputFile(strQuizFile);//import the quiz file
        
        CPTtools.importimage(con,"background.jpg",0,0);
        con.setFont(new Font("Arial",Font.PLAIN, 40));
        
        con.drawString("What is your name?",160,240);
        strName = con.readLine();//get name so I can use it in the high scores file       
        //loop to assign each column in the array to its designated line of text
        for (intCount=0;intCount<intQuestionCount;intCount++){
          strQuestion[0][intCount] = ComputerQuizVar.readLine();
          strQuestion[1][intCount] = ComputerQuizVar.readLine();
          strQuestion[2][intCount] = ComputerQuizVar.readLine();
          strQuestion[3][intCount] = ComputerQuizVar.readLine();
          strQuestion[4][intCount] = ComputerQuizVar.readLine();
          strQuestion[5][intCount] = ComputerQuizVar.readLine();
        }
        ComputerQuizVar.close();
        
        //the actual gameplay part
        intScore = 0;//reset score for a new game
        intScoreCount = 0;
        intPercentage = 0;          
        for (intCount=0;intCount<intQuestionCount;intCount++){
          CPTtools.importimage(con,"background.jpg",0,0);
          con.setFont(new Font("Arial",Font.PLAIN, 20));
          con.drawString(strQuestion[0][intCount],0,40);//print the question at the top
          con.setFont(new Font("Arial",Font.PLAIN, 28));
          //very long if statement for importing pictures
          //checks the answer of the current question and if there is a picture that matches the answer
          //display the picture in the console
          //if nothing matches, print a place holder picture
          if (strQuestion[0][intCount].equals("The transistor size of Intel's \"Devil's Canyon\" CPUs are:")){
            CPTtools.importimage(con,"devilscanyon.png",140,50);
          }
          else if (strQuestion[0][intCount].equals("What does NVMe stand for?")){
            CPTtools.importimage(con,"750.png",140,50);
          }
          else if (strQuestion[0][intCount].equals("What does the \"L\" stand for in \"DDR3L\"?")){
            CPTtools.importimage(con,"ddr3.png",90,50);
          }
          else if (strQuestion[0][intCount].equals("The AMD Ryzen CPUs are on which platform?")){
            CPTtools.importimage(con,"ryzen.jpg",140,50);
          }
          else if (strQuestion[0][intCount].equals("Which of these GPUs feature HBM (High bandwidth memory)?")){
            CPTtools.importimage(con,"hbm.png",70,50);
          }
          else if (strQuestion[0][intCount].equals("What is true about the i7 6950x?")){
            CPTtools.importimage(con,"6950x.png",140,50);
          }
          else if (strQuestion[0][intCount].equals("Which of these computer form factors are incorrect?")){
            CPTtools.importimage(con,"pc.png",140,50);
          }
          else if (strQuestion[0][intCount].equals("Which of these are not PSU efficiency ratings?")){
            CPTtools.importimage(con,"psu.png",140,50);
          }
          else if (strQuestion[0][intCount].equals("To achieve a stable CPU overclock, you have to:")){
            CPTtools.importimage(con,"overclock.jpg",140,50);
          }
          else if (strQuestion[0][intCount].equals("What is coil whine?")){
            CPTtools.importimage(con,"coil.png",140,50);
          }
          else if (strQuestion[0][intCount].equals("What is the purpose of a heatsink?")){
            CPTtools.importimage(con,"heatsink.png",140,50);
          }
          else if (strQuestion[0][intCount].equals("What does the ASIC quality of a GPU determine?")){
            CPTtools.importimage(con,"asic.png",100,50);
          }
          else if (strQuestion[0][intCount].equals("Static pressure fans perform best as:")){
            CPTtools.importimage(con,"static.png",140,50);
          }
          else if (strQuestion[0][intCount].equals("How many championships did Michael Jordan win?")){
            CPTtools.importimage(con,"jordan.jpg",140,50);
          }
          else if (strQuestion[0][intCount].equals("Which year did LeBron James get traded to the Miami Heat?")){
            CPTtools.importimage(con,"lebron.jpg",140,50);
          }
          else if (strQuestion[0][intCount].equals("Which season did the Raptors first make the Eastern Conference Finals?")){
            CPTtools.importimage(con,"raptors.jpg",147,50);
          }
          else if (strQuestion[0][intCount].equals("Which team drafted Kobe Bryant as the 13th pick in the 1996 NBA draft?")){
            CPTtools.importimage(con,"kobe.jpg",150,50);
          }
          else if (strQuestion[0][intCount].equals("Which of these players retired without winning a championship?")){
            CPTtools.importimage(con,"trophy.jpg",150,50);
          }
          else if (strQuestion[0][intCount].equals("Which of the following teams had the worst ever winning percentage?")){
            CPTtools.importimage(con,"lose.jpg",140,50);
          }
          else if (strQuestion[0][intCount].equals("Which player was drafted first overall in the 2001 NBA draft?")){
            CPTtools.importimage(con,"2001.jpg",150,50);
          }
          else if (strQuestion[0][intCount].equals("Which player was the first to ever be given a unanimous MVP?")){
            CPTtools.importimage(con,"mvp.jpg",140,50);
          }
          else if (strQuestion[0][intCount].equals("Which player has won the most championships?")){
            CPTtools.importimage(con,"rings.jpg",180,50);
          }
          else if (strQuestion[0][intCount].equals("Which player was denied a trade by the NBA to the Lakers in 2011?")){
            CPTtools.importimage(con,"lakers.jpg",170,50);
          }
          else if (strQuestion[0][intCount].equals("Which of the following has the highest armour penetration?")){
            CPTtools.importimage(con,"armourpen.png",140,50);
          }
          else if (strQuestion[0][intCount].equals("What is this graffiti known for?")){
            CPTtools.importimage(con,"fnaticawp.jpg",140,50);
          }
          else if (strQuestion[0][intCount].equals("What was the first operation called?")){
            CPTtools.importimage(con,"payback.png",140,50);
          }
          else if (strQuestion[0][intCount].equals("When is the kill reward of the CZ-75?")){
            CPTtools.importimage(con,"cz75.png",140,50);
          }
          else if (strQuestion[0][intCount].equals("Which of the following SMGs have the highest fire rate?")){
            CPTtools.importimage(con,"smg.jpg",140,50);
          }
          else if (strQuestion[0][intCount].equals("What is the running speed of the Zeus x27?")){
            CPTtools.importimage(con,"zeus.png",140,50);
          }
          else if (strQuestion[0][intCount].equals("Which shotgun is the only shotgun with a magazine?")){
            CPTtools.importimage(con,"mag7.jpg",140,50);
          }
          else if (strQuestion[0][intCount].equals("Who was ranked first in the HLTV 2016 player rankings?")){
            CPTtools.importimage(con,"sk.jpg",140,50);
          }
          else if (strQuestion[0][intCount].equals("Which team did the infamous overpass boost against LDLC in 2014?")){
            CPTtools.importimage(con,"LDLC.jpg",140,50);
          }
          else if (strQuestion[0][intCount].equals("Which team dominated the CS:GO scene from 2012-2014?")){
            CPTtools.importimage(con,"cologne.png",125,50);
          }
          else if (strQuestion[0][intCount].equals("Which player is known for their one taps?")){
            CPTtools.importimage(con,"onetap.png",120,50);
          }
          else if (strQuestion[0][intCount].equals("Which player is known for \"yo les noobs\"?")){
            CPTtools.importimage(con,"g2.jpg",140,50);
          }
          else{
            CPTtools.importimage(con,"placeholder.jpg",140,50);
          }
          //hud at the bottom left that displays the name, score, and percentage
          con.drawString(strName+" | "+intScore+"/"+intScoreCount+" | "+intPercentage+"%",0,470);
          //printing the options. intCount will determine which question to put
          con.drawString("a) "+strQuestion[1][intCount],0,290);
          con.drawString("b) "+strQuestion[2][intCount],0,320);
          con.drawString("c) "+strQuestion[3][intCount],0,350);
          con.drawString("d) "+strQuestion[4][intCount],0,380);
          //using a method to check which of the 4 options is the actual answer
          chrAnswer = CPTtools.answer(strQuestion[5][intCount],strQuestion[1][intCount],strQuestion[2][intCount],
                                      strQuestion[3][intCount],strQuestion[4][intCount]);
          
          chrAnswerInput = con.getChar();//user inputs one of the options
          //force the char to be lower case so the game will work when caps is on
          chrAnswerInput = Character.toLowerCase(chrAnswerInput);
          
          if( chrAnswerInput==(chrAnswer)){//if the input matches the answer...
            con.drawString("Correct!",0,410);
            intScore = intScore+1;//add 1 to the score
            intScoreCount = intScoreCount+1;//add 1 to count the number of questions
            intPercentage =(intScore*100/intScoreCount);
            CPTtools.pause(500);
            con.clear();
          }
          else{//if the input doesnt match...
            con.drawString("Incorrect",0,410);
            con.drawString("The correct answer is "+chrAnswer,0,440);//print the correct answer
            intScoreCount = intScoreCount+1;//add 1 to counting the question
            intPercentage =(intScore*100/intScoreCount);
            CPTtools.pause(1500);
            con.clear();
          }
          
        }
        //after the game ends, display the information stats of the user
        CPTtools.importimage(con,"background.jpg",0,0);
        con.drawString ("Name: "+strName,0,40);
        con.drawString ("Score: "+intScore+"/"+intScoreCount,0,80);
        con.drawString("Percentage: "+intPercentage+"%",0,120);
        con.drawString("Quiz: "+strQuizName,0,160);
        CPTtools.highscore(strName,intPercentage,strQuizName);//write the highscore to a text file using a method  
        con.drawString ("Press any key to go to the menu",0,200);
        chrNext= con.getChar();//placeholder to press any key
        intSelectionLoop=0;
        CPTtools.importimage(con,"menu.jpg",0,0);//display the menu
        chrMenu = con.getChar();//get the input for the menu
        
        
      }
      else if (chrMenu=='b'||chrMenu =='B'){//if the user inputs b, go to the instructions
        CPTtools.importimage(con,"instructions.jpg",0,0);
        chrNext = con.getChar();
        CPTtools.importimage(con,"menu.jpg",0,0);
        chrMenu = con.getChar();
      }
      else if (chrMenu == 'c'||chrMenu=='C'){//if user inputs c, go to highscores
        int intHighScoreLines;
        int intHighScoreEntries;
        intHighScoreLines = CPTtools.linecount("scores.txt");
        
        if (intHighScoreLines ==0) {//if there are no high scores, return to the menu
          con.setFont(new Font("Arial",Font.PLAIN, 40));
          CPTtools.importimage(con,"background.jpg",0,0);
          con.drawString ("No scores recorded",160,240);
          CPTtools.pause(1300);
          CPTtools.importimage(con,"menu.jpg",0,0);
          chrMenu = con.getChar();
          //bubble sorting the high scores so they can print
        }
        else{
          intHighScoreEntries = intHighScoreLines/3;
          String strHighScore[][];
          strHighScore = new String [intHighScoreEntries][3];//number of 
          TextInputFile highscore = new TextInputFile ("scores.txt");
          for(intCount=0;intCount<intHighScoreEntries;intCount++){//assign the array to the appropriate lines of text
            strHighScore[intCount][0]=highscore.readLine();
            strHighScore[intCount][1]=highscore.readLine();
            strHighScore[intCount][2]=highscore.readLine();
          }
          highscore.close();
          String strLeft;
          String strRight;
          String strTemp;
          int intBCount;
          int intBCount2;
          
          for (intBCount2 = 0;intBCount2<intHighScoreEntries-1;intBCount2++){
            for (intBCount = 0; intBCount<intHighScoreEntries-1;intBCount++){
              strLeft = strHighScore[intBCount][1];
              strRight = strHighScore[intBCount+1][1];
              if (Integer.parseInt(strLeft) < Integer.parseInt(strRight)){
                //swap column index 1
                strTemp = strHighScore [intBCount][1];
                strHighScore [intBCount][1] = strHighScore [intBCount+1][1];
                strHighScore[intBCount+1][1]=strTemp;
                //also swap column 0 and 2 because they need to match the info from column 1
                strTemp = strHighScore [intBCount][0];
                strHighScore [intBCount][0] = strHighScore [intBCount+1][0];
                strHighScore[intBCount+1][0]=strTemp;
                strTemp = strHighScore [intBCount][2];
                strHighScore [intBCount][2] = strHighScore [intBCount+1][2];
                strHighScore[intBCount+1][2]=strTemp;
              }
            }
          }
          CPTtools.importimage(con,"background.jpg",0,0);
          con.setFont(new Font("Arial",Font.PLAIN, 40));
          con.drawString ("Name",10,40);
          con.drawString ("Score",330,40);
          con.drawString("Quiz",480,40);
          if (intHighScoreEntries<10){//if there are less than 10 high scores,print the number of scores in the file
            for (intCount = 0;intCount<intHighScoreEntries;intCount++){
              con.setFont(new Font("Arial",Font.PLAIN, 20));
              con.drawString(intCount+1 +". "+strHighScore[intCount][0],0,(intCount+2)*35);//print the name on the left
              con.drawString(strHighScore[intCount][1]+"%",360,(intCount+2)*35);//print the score in the middle
              con.drawString(strHighScore[intCount][2],480,(intCount+2)*35);//print the quiz name on the right
              con.setFont(new Font("Arial",Font.PLAIN, 40));
            }
          }
          else{//otherwise, print the top 10
            for (intCount = 0;intCount<10;intCount++){
              con.setFont(new Font("Arial",Font.PLAIN, 20));
              con.drawString(intCount+1 +". "+strHighScore[intCount][0],0,(intCount+2)*35);//print the name on the left
              con.drawString(strHighScore[intCount][1]+"%",360,(intCount+2)*35);//print the score in the middle
              con.drawString(strHighScore[intCount][2],480,(intCount+2)*35);//print the quiz name on the right
              con.setFont(new Font("Arial",Font.PLAIN, 40));
            }
          }
          con.drawString ("Press any key to return to menu",0,460);
          chrNext = con.getChar();
          CPTtools.importimage(con,"menu.jpg",0,0);
          chrMenu = con.getChar();
        }
      }
      else if (chrMenu == 'd'||chrMenu== 'D'){//exit game
        con.close();
      }
      else{//if the user enters something else, it will ask for input again
        chrMenu = con.getChar();
      }
    }
  }
}