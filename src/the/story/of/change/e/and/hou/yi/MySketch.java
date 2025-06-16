
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
 * @version 1.0
 * @since 06/15/2025
 * @author tina
 */
public class MySketch extends PApplet{
    //declearing the variables
    private Character Houyi;
    private Arrow arrow;
    private Character timer;
    private Character[] sun;
    private int[] time;
    private int best;
    //initializing the variable
    public float angle=0;
    private int count=0;//tracks how many suns the user has shot down
    private int linecount;//tracks the number of lines in the file
    private int sec=0;//the number of secs used to finish the same
    private int keyPressCount=0;//used to track how many "enters" have been pressed
    private boolean tabPressed=false;//detects if tab was pressed
    private int lastSecond = 0;//
    private boolean scoreSaved = false;// 
    //initializing a 2D array
    private int[][] sunSpeed={{1,1}, {5,5}, {3,3}, {1,1},{0,5},{3,0}};
    public void settings(){
        size(600,600);//Sets the size of the screen
    }
    
    public void setup(){
        //Sets the background colour to white
        background(255);
        //Instantiates objects
        Houyi=new Character(this, 40, 32, "images/houyi.png"); 
        arrow = new Arrow(this, 105, 240, 0,"images/arrow.png");
        timer = new Character(this, 260, 0, 100, 40,255);
        //Setting size of the array and 
        sun = new Character[10];
        //Instantiate each sun element 
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
        //sets text size as 25
        textSize(25);
    }
    /**
     * This is a method that animates sun[0] 
     */
    public void sun1Animated(){
        sun[0].move(sunSpeed[0][0], sunSpeed[0][1]);//moves sun[0] in a right-down direction and sets their speed as 1
        //Reverse direction if the sun goes outside the defined boundary
        if ((sun[0].x >= 500 || sun[0].x <= 400) && (sun[0].y >= 100 || sun[0].y <= 30)) {
            sunSpeed[0][0] = -sunSpeed[0][0];//reverse x direction
            sunSpeed[0][1] = -sunSpeed[0][1];//reverse y direction
        }
    }
    /**
     * This is a method that animates sun[1] 
     */
    public void sun2Animated() {
        sun[1].move(-sunSpeed[1][0], sunSpeed[1][1]);//moves sun[1] in a left-down direction and sets their speed as 5
        //Reverse vertical direction if it reaches the max or min y-cord value
        if (sun[1].y >= 200 || sun[1].y <= 60) {
            sunSpeed[1][1] = -sunSpeed[1][1];
        //Reverse both horizontal and vertical direction if it's out of these x-cord boundaries 
        }else if(sun[1].x<=220||sun[1].x>320){
            sunSpeed[1][0] = -sunSpeed[1][0];
            sunSpeed[1][1] = -sunSpeed[1][1];
        } 
    }
    /**
     * This is the method that animates sun[2]
     */
    public void sun3Animated(){
        sun[2].move(sunSpeed[2][0], sunSpeed[2][1]);//moves sun[2] in a right-down direction and sets their speed as 3
        //Reverse both horizontal and vertical direction if the sun goes outside the defined boundary
        if ((sun[2].x >= 480 || sun[2].x <= 400) && (sun[2].y >= 200 || sun[2].y <= 160)) {
            sunSpeed[2][0] = -sunSpeed[2][0];
            sunSpeed[2][1]=-sunSpeed[2][1];
        }
    }
    /**
     * This method animates sun[3]
     */
    public void sun4Animated(){
        sun[3].move(-sunSpeed[3][0], sunSpeed[3][1]);//moves sun[3] in a left-down direction and sets their speed as 5
        //Reverse vertical direction if it reaches the max or min y-cord value
        if (sun[3].y >= 100 || sun[3].y <= 25) {
            sunSpeed[3][1] = -sunSpeed[3][1];
        }
        //Reverse both horizontal and vertical direction if it's out of these x-cord boundaries 
        if(sun[3].x<=100||sun[3].x>150){
            sunSpeed[3][0] = -sunSpeed[3][0];
            sunSpeed[3][1] = -sunSpeed[3][1];
        } 
    }
    /**
     * This method animates sun[4]
     */ 
    private void sun5Animated(){
        sun[4].move(sunSpeed[4][0], sunSpeed[4][1]);//moves sun[4] in a virtical direction and sets speed as 5
        //Reverse vertical direction if it reaches the max or min y-cord value
        if(sun[4].y<=150||sun[4].y>=300){
            sunSpeed[4][1]=-sunSpeed[4][1];
        }
    }
    /**
     * This method animates sun[5]
     */
    private void sun6Animated(){
        sun[5].move(-sunSpeed[5][0], sunSpeed[5][1]);//moves sun[5] in a horizontal dirextion and sets speed as 3
        //Reverse horizontal direction if it's out of these x-cord boundaries 
        if(sun[5].x>=500||sun[5].x<=450){
            sunSpeed[5][0]=-sunSpeed[5][0];
        }
    }
    /**
     * This is a method that displays text giving instruction and story description to the player
     */
    public void storyLines1(){
        //Sets the background colour to white
        background(255);
        //if no "enter" was pressed, it displays part one of the story
        if(keyPressCount==0){
            fill(0);//sets text colour as black
            text("This is the Story of Change E and Hou Yi.", 10, 50);
            text("Also known as the creation story to the moon festival.", 10, 80);
            text("This story is about a man named Hou yi, who saved the", 10, 110);
            text("world by shooting down nine of the ten suns.", 10, 140);
            fill(255,0,0);//set text colour as red
            text("PRESS ENTER TO GET TO NEXT PART", 10, 170);
        //if enter was detected and pressed once 
        }else if(keyPressCount==1){
            //clears everything
            background(255);
            fill(255,0,0);//sets text colour as back
            //displays instructions and a explanation 
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
    /**
     * This is a method that's displayed after user has shot down 9 suns.
     * It will display instruction and displays user's best score
     */
    public void storyLines2(){
        background(255);
        fill(0);
        text("You did it! You shot down 9 suns.", 10, 50);
        text(" ",10,80);
        fill(255,0,0);
        text("Press ENTER to continue with the story.", 10, 110);
        text("OR press TAB to replay.", 10, 140);
        text(" ",10,180);
        text("BEST TIME: "+best+" Seconds", 10, 200);
    }
    /**
     * This is displays when user pressed "enter" to conclude the game
     */
    public void end(){
        background(255);//clears everything
        fill(0);//sets text colout as black
        //displays the rest of the story
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
        fill(255,0,0);//sets text colout as red
        text("THANKS FOR PLAYING", 10, 440);//A concluding message
    }
    /**
     * A method that updates and displays the current time
     */
    public void updateAndDrawTimer() {
        //if the count is not 9, 1 sec has gone past and enter has been pressed twice
        if (count!=9 && millis() - lastSecond >= 1000&&keyPressCount==2) {   
            sec++;//second will increase by 1, which will be displayed on users screen
            lastSecond += 1000;//adds 1 seconds(1000 milliseconds) to the variable
        //this will make sure 1 sec has gone by
        //if the count is not 9, 1 sec has gone past and tab bar has been pressed
        }else if(count!=9 && millis() - lastSecond >= 1000&&tabPressed==true){
            sec++;//second will increase by 1, which will be displayed on users screen
            lastSecond += 1000;//adds 1 seconds(1000 milliseconds) to the variable
        //if count is equal to 9  
        }else if(count==9){
            lastSecond = millis();  //freezes lastSeconds
        }

        fill(0);//sets text colour as black
        text("Timer: " + sec, 265, 25);//shows updated time
    }
    /**
     * This method adds user's score to the file
     */
    public void addingScore(){
        //counts the number of lines in the txt
        lineCounts();
        try{
            //creases a print writer to write to file 
            PrintWriter outprint=new PrintWriter(new FileWriter("scores.txt", true));
            //writes it to file without newline 
            if(linecount==0){
                outprint.print(sec);
            //otherwise, it starts a newline and writes to it
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
    /**
     * This method counts the number of lines in the file
     * @return It returns the number of lines counted in the file
     */
    public int lineCounts(){
        //Initializes linecount as 0
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
    /**
     * This method reads the file, adds it to a array and compares to find the best score
     * @return It returns the best time currently detected
     */
    public int bestScore(){
        lineCounts();//counts the number of lines in the file
        time = new int[linecount];//sets the size of the variable by the number of lines in the file
        try{
            //create scanner tha reads though the files called "scores.txt"
            Scanner filereader = new Scanner(new File("scores.txt"));
             int index=0;//Initializes index of the array
            //loops and reads until no next line is detected
            while(filereader.hasNext()){
                String read=filereader.nextLine();//reads the line
                time[index]=Integer.parseInt(read);//converts string to int and adds it to the array
                index++;//increases index by 1
            }filereader.close();//closes reader
        }catch(IOException ioException){
            //when a error is detected, it will print out error message
            System.err.print("Error: "+ioException);
        }
        
        //if the number of element in the array is more than 0
        if (time.length > 0) {
            best = time[0];//first sets the best score as the first time the user got
            //loops through all times to find if theres any lower ones
            for (int i = 1; i < time.length; i++) {
                //if one of the element was detected to be lower than the currently set as best time
                if (time[i]< best) {
                    //it replaces it with this time
                    best = time[i];
                }
            }
        }
        return best;
        
    }
    /**
     * This is a method that draw out all the characters and background.
     */
    public void Gamedraw(){
        //sets background as orange/yellow
        background(239,221,58);
        Houyi.draw();//draws out houYi
        //loops though all elemnts in sun tp draws them out
        for(int i=0; i<10; i++){
            sun[i].draw();
        }
        arrow.draw();//draws the arrow
        timer.drawingtimer();//draws out the rectanlge box thats used as background for the timer
        updateAndDrawTimer();//calls the method that prints and updates the duration the user has used to play
    }
    /**
     * This method calls all methods that animated the sun
     */
    public void sunAnimations(){
        sun1Animated();
        sun2Animated();
        sun3Animated();
        sun4Animated();
        sun5Animated();
        sun6Animated();
    }
    /**
     * Will move and angle the objects when pressed left,right and space.
     * Will go to next page when pressed enter.
     * Will replay the game when pressed tab.
     */
    public void keyPressed() {
        //when left key is pressed and count is not 9
        if (keyCode == LEFT) {
            if(count!=9){
                //arrow rotates 10 degrees to the left
                arrow.rotate(-10);
            }
        //if right key is pressed and count is not 9
        } else if (keyCode == RIGHT){
            if(count!=9){
                //arrow rotates 10 degrees to the righ
                arrow.rotate(10);
            }
        //if the space bar is pressed
        }else if(keyCode == ' '){
            //converts the current arrow angle to radian
            float rad = PApplet.radians(Arrow.angles); 
            //calculayes the x and y speed using trigonometry
            float dx = (float)(Math.cos(rad) * 10);
            float dy = (float)(Math.sin(rad) * 10);
            //moves the arrow at the calculated x and y speeds
            arrow.startMoving(dx, dy);
        //if enter key is pressed
        }else if(keyCode==ENTER){
            //increases keyPressCount by 1, used to display diffrent texts at diffrent times
            keyPressCount++;
        //if tab bar is pressed
        }else if(keyCode==TAB){
            //sets tabPressed as true, used to replay the game
            tabPressed=true;
        }
    }
    /**
     * This method restart all game characters and variables
     */
    private void resetGame() { 
        tabPressed = false;//resets tabPress
        scoreSaved = false;//allows score to be saved again
        count = 0;//resets the counter for the number of suns shot
        sec = 0;//resets the timer
        lastSecond = millis();//resets the time tracker
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
    /**
     * This method collision detects for arrow and suns
     */
    public void ifColliding() {
        //initilizes collision as fasle
        boolean collisionDetection=false;
        //loops through all suns to detect if arrow had collided with a sun
        for (int i = 0; i < sun.length; i++) {
            //if collision was detected between a arrow and a sun
            if (arrow.isColliding(sun[i])) {
                //it hides the sun that the arrow has collided with
                sun[i].hidedraw();
                //resets the arrows position again and draws it out
                arrow = new Arrow(this, 106, 230, 0, "images/arrow.png");
                arrow.draw();
                count++;//increases the number of sun shot down by 1
                collisionDetection=true;//sets collision detection as true 
                break; // Stop after the first collision
            }
        }
        //if the collision was false and arrow was out of bound
        if(!collisionDetection&&(arrow.x<=0||arrow.y>=600||arrow.x>=600||arrow.y<=0)){
            ////resets the arrows position again and draws it out again
            arrow = new Arrow(this, 106, 230, 0, "images/arrow.png");
            arrow.draw();
        }  
    }

    /**
     * Draws and runs all methods and character
     */
    public void draw(){
        //if tab bar was pressed and detected
        if(tabPressed==true){
            resetGame();//it calls this method to resets all settings
        }
        //if keyPressCount(a count for the number of times "enter" was pressed) was less than 2
        if (keyPressCount < 2) {          
            storyLines1();//displays part 1 of the story and instrction for the game
            return;                       
        }
        //if keyPress was 2 and count was less than 9
        if (keyPressCount == 2 && count < 9) { 
            Gamedraw();//displays all character
            sunAnimations();//displays animates the sun
            arrow.update();//moves the arrow
            ifColliding();//calls the method that collision detects 
            
        }
        //if keyPress was 2 and count was 9
        if (keyPressCount == 2 && count == 9) {
            //only saves the score once
            if (!scoreSaved) {                       
                addingScore();//adds score to file
                bestScore();//gets best score
                scoreSaved = true;//prevents score from savinf again
            }
            storyLines2();//displays part2                       
        }
        //if user pressed enter for the 3rd time, meaning user wants to end the game
        if(keyPressCount==3){
            end();//it displays the resrt of the story and ends the game
        }
    }  
}
