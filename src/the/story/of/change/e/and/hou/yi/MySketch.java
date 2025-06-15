
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package the.story.of.change.e.and.hou.yi;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.util.Scanner;
import processing.core.PApplet;

/**
 * This is a sketch class that will display all images, animated movements and scenes
 * @author tina
 */
public class MySketch extends PApplet{
    
    private Character Houyi;
    private Arrow arrow;
    private Character timer;
    private float[] target = new float [2];
    boolean arrowMoving = false;
    public float angle=0;
    float arrowSpeed=5;
    int[] score;
    int count=0;
    int count2=0;
    int linecount=0;
    int sec=0;
    int keyPressCount=0;
    int best;
    boolean tabPressed=false;
    private Character[] sun;
    int lastSecond = 0;
    boolean scoreSaved = false; 
    private int[][] sunSpeed={{1,1}, {5,5}, {3,3}, {1,1},{0,5},{3,0}};
    
    public void settings(){
        size(600,600);//Sets the size of the screen
        
    }
    
    public void setup(){
        //Sets the background colour to white
        background(255);
        Houyi=new Character(this, 70, 30, "images/houyi.png");
        arrow = new Arrow(this, 100, 228, 0,"images/arrow.png");
        timer = new Character(this, 260, 0, 100, 40,255);
        sun = new Character[10];
        sun[0]=new Character(this, 480, 30, "images/sun2.png");
        sun[1]=new Character(this, 320, 80, "images/sun2.png");
        sun[2]=new Character(this, 400, 160, "images/sun2.png");
        sun[3]=new Character(this, 150, 25, "images/sun2.png");
        sun[4]=new Character(this, 0, 150, "images/sun2.png");
        sun[5]=new Character(this, 500, 350, "images/sun2.png");
        sun[6]=new Character(this, 10, 20, "images/sun2.png");
        sun[7]=new Character(this, 320, 300, "images/sun2.png");
        sun[8]=new Character(this, 350, 450, "images/sun2.png");
        sun[9]=new Character(this, 490, 500, "images/sun2.png");
        textSize(25);
    }
    
    public void sun1Animated(){
        sun[0].move(sunSpeed[0][0], sunSpeed[0][1]);
        if ((sun[0].x >= 500 || sun[0].x <= 400) && (sun[0].y >= 100 || sun[0].y <= 30)) {
            sunSpeed[0][0] = -sunSpeed[0][0];
            sunSpeed[0][1] = -sunSpeed[0][1];
        }
    }
    
    public void sun2Animated() {
        sun[1].move(-sunSpeed[1][0], sunSpeed[1][1]);
        if (sun[1].y >= 200 || sun[1].y <= 60) {
            sunSpeed[1][1] = -sunSpeed[1][1];
        }else if(sun[1].x<=220||sun[1].x>320){
            sunSpeed[1][0] = -sunSpeed[1][0];
            sunSpeed[1][1] = -sunSpeed[1][1];
        } 
    }
    
    public void sun3Animated(){
        sun[2].move(sunSpeed[2][0], sunSpeed[2][1]);
        if ((sun[2].x >= 480 || sun[2].x <= 400) && (sun[2].y >= 200 || sun[2].y <= 160)) {
            sunSpeed[2][0] = -sunSpeed[2][0];
            sunSpeed[2][1]=-sunSpeed[2][1];
        }
    }
    
    public void sun4Animated(){
        sun[3].move(-sunSpeed[3][0], sunSpeed[3][1]);
        if (sun[3].y >= 100 || sun[3].y <= 25) {
            sunSpeed[3][1] = -sunSpeed[3][1];
        }
        if(sun[3].x<=100||sun[3].x>150){
            sunSpeed[3][0] = -sunSpeed[3][0];
            sunSpeed[3][1] = -sunSpeed[3][1];
        } 
    }
     
    private void sun5Animated(){
        sun[4].move(sunSpeed[4][0], sunSpeed[4][1]);
        if(sun[4].y<=150||sun[4].y>=300){
            sunSpeed[4][1]=-sunSpeed[4][1];
        }
    }
    
    private void sun6Animated(){
        sun[5].move(-sunSpeed[5][0], sunSpeed[5][1]);
        if(sun[5].x>=500||sun[5].x<=450){
            sunSpeed[5][0]=-sunSpeed[5][0];
        }
    }
    
    public void storyLines1(){
        background(255);
        if(keyPressCount==0){
            fill(0);
            text("This is the Story of Change E and Hou Yi.", 10, 50);
            text("Also known as the creation story to the moon festival.", 10, 80);
            text("This story is about a man named Hou yi, who saved the", 10, 110);
            text("world by shooting down nine of the ten suns.", 10, 140);
            fill(255,0,0);
            text("PRESS ENTER TO GET TO NEXT PART", 10, 170);
            
        }else if(keyPressCount==1){
            background(255);
            fill(255,0,0);
            text("Press ENTER to start playing.", 10, 50);
            text(" ", 10, 80);
            text("How to Play:", 10, 110);
            fill(0);
            text("You will take on the role of Hou Yi!", 10, 140);
            text("Your mission is to shoot down 9 of the 10 suns in the sky.",10,170);
            text("Note: Some suns will be moving, so aim carefully!",10,200);
            text("Use the left and right arrow keys to aim your bow.",10,230);
            text("When ready, press the space bar to fire an arrow.",10,260);
            text("Ready, set, aim!",10,290);
        }
    }
    
    public void storyLines2(){
        background(255);
        fill(0);
        text("You did it! You shot down 9 suns.", 10, 50);
        text(" ",10,80);
        fill(255,0,0);
        text("Press ENTER to continue with the story.", 10, 110);
        text("OR press TAB to replay.", 10, 140);
        text("BEST TIME: "+best, 10, 180);
    }
    
    public void end(){
        background(255);
        fill(0);
        text("As a reward, the Queen Mother of Heaven gave him a", 10, 50);
        text("magical elixir of immortality. However, the elixir came",10,80);
        text("with a cost: whoever drank it would become immortal",10,110);
        text("but be sent to live alone on the Moon. Not wanting to be",10,140);
        text("separated from his beloved wife Chang E, Hou Yi chose",10,170);
        text("not to drink it and gave it to her for safekeeping. One",10,200);
        text("day, while he was away, a thief broke into their home to",10,230);
        text("steal the elixir. To protect it, Chang’e drank it herself and",10,260);
        text("floated to the Moon, where she became the Moon",10,290);
        text("Goddess. Heartbroken, Hou Yi laid out her favorite foods",10,320);
        text("each year and looked up at the full moon, hoping to see",10,350);
        text("her again.",10,380);
        text(" ",10,410);
        fill(255,0,0);
        text("THANKS FOR PLAYING", 10, 440);
    }
    
    public void updateAndDrawTimer() {
        if (count!=9 && millis() - lastSecond >= 1000) {   // no more upper limit
            sec++;
            lastSecond += 1000;
            
        }else if(count==9){
            lastSecond = millis();  
        }

        fill(0);
        text("Timer: " + sec, 265, 25);        // just keep showing seconds
    }
    
    public void addingScore(){
        lineCounts();
        try{
            //creases a print writer to write to file 
            PrintWriter outprint=new PrintWriter(new FileWriter("scores.txt", true));
            //writes it to file 
            if(linecount==0){
                outprint.print(sec);
            }else{
                outprint.print("\n"+sec);
            }
            //closes print writer
            outprint.close();
        }catch(IOException ioException){
            //when a error is detected, it will print out error message
            System.err.print("Error: "+ioException);
        }
    }
    
    public int lineCounts(){
        linecount = 0; 
        try{
           //creates a scanner to read the file called "scores.txt"
           Scanner filereader = new Scanner(new File("scores.txt"));
           //loops and reads though all lines of the file when it detects that it has a next line to count the number of lines in the file
           while(filereader.hasNext()){
               String read=filereader.nextLine();//reads the line
               linecount++;//increases line count 
           } 
           filereader.close();//closes file reader
           
        }catch(IOException ioException){
          //when a error is detected, it will print out error message
          System.err.print("Error: "+ioException);
        }
        return linecount;
    }
    
    public int bestScore(){
        lineCounts();
        score = new int[linecount];
        try{
            //create scanner tha reads though the files called "scores.txt"
            Scanner filereader = new Scanner(new File("scores.txt"));
             //score = new int[linecount];
             int index=0;
            //loops and reads until no next line is detected
            while(filereader.hasNext()){
                String read=filereader.nextLine();//reads the line
                score[index]=Integer.parseInt(read);
                index++;
            }filereader.close();//closes reader
        }catch(IOException ioException){
            //when a error is detected, it will print out error message
            System.err.print("Error: "+ioException);
        }
        
        if (score.length > 0) {
            best = score[0]; // Start with first element
            for (int i = 1; i < score.length; i++) {
                if (score[i]< best) {
                    best = score[i];
                }
            }
        }
        return best;
        
    }
    
    public void Level1draw(){
        background(239,221,58);
        Houyi.draw();
        for(int i=0; i<10; i++){
            sun[i].draw();
        }
        arrow.draw();
        timer.drawingtimer();
        updateAndDrawTimer();
    }
    public void sunAnimations(){
        sun1Animated();
        sun2Animated();
        sun3Animated();
        sun4Animated();
        sun5Animated();
        sun6Animated();
    }
    
    public void keyPressed() {
        if (keyCode == LEFT) {
            if(count!=9){
                arrow.rotate(-15);
            }
        } else if (keyCode == RIGHT){
            if(count!=9){
                arrow.rotate(15);
            }
        }else if(keyCode == ' '){
            float rad = PApplet.radians(Arrow.angles); // get angle in radians
            float dx = (float)(Math.cos(rad) * 10);
            float dy = (float)(Math.sin(rad) * 10);
            arrow.startMoving(dx, dy); 
        }else if(keyCode==ENTER){
            keyPressCount++;
        }else if(keyCode==TAB){
            tabPressed=true;
        }
    }
    
    private void resetLevel1() { 
        tabPressed = false;
        scoreSaved = false;
        count = 0;
        sec = 0;
        lastSecond = millis();
        // reset arrow and suns to their original positions
        arrow = new Arrow(this, 106, 230, 0, "images/arrow.png");
        sun[0]=new Character(this, 480, 30, "images/sun2.png");
        sun[1]=new Character(this, 320, 80, "images/sun2.png");
        sun[2]=new Character(this, 400, 160, "images/sun2.png");
        sun[3]=new Character(this, 150, 25, "images/sun2.png");
        sun[4]=new Character(this, 0, 150, "images/sun2.png");
        sun[5]=new Character(this, 500, 350, "images/sun2.png");
        sun[6]=new Character(this, 10, 20, "images/sun2.png");
        sun[7]=new Character(this, 320, 300, "images/sun2.png");
        sun[8]=new Character(this, 350, 450, "images/sun2.png");
        sun[9]=new Character(this, 490, 500, "images/sun2.png");
    }
    
    public void ifColliding() {
        boolean colltionDetection=false;
        for (int i = 0; i < sun.length; i++) {
            if (arrow.isColliding(sun[i])) {
                sun[i].hidedraw();
                arrow = new Arrow(this, 106, 230, 0, "images/arrow.png");
                arrow.draw();
                count++;
                colltionDetection=true;
                break; // Stop after the first collision
            }
        }
        if(!colltionDetection&&(arrow.x<=0||arrow.y>=600||arrow.x>=600||arrow.y<=0)){
                arrow = new Arrow(this, 106, 230, 0, "images/arrow.png");
                arrow.draw();
        }  
    }

    
    public void draw(){
        if(tabPressed==true){
            resetLevel1();
        }
        if (keyPressCount < 2) {          
            storyLines1();
            return;                       
        }
        if (keyPressCount == 2 && count < 9) { 
            Level1draw();
            sunAnimations();
            arrow.update();
            ifColliding();
            
        }
        if (keyPressCount == 2 && count == 9) {      
            if (!scoreSaved) {                       
                addingScore();
                bestScore();
                scoreSaved = true;
            }
            storyLines2();                           
        }
        
        if(keyPressCount==3){
            end();
        }
    }  
}
