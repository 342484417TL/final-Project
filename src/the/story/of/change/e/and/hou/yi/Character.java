/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package the.story.of.change.e.and.hou.yi;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * A class that instances the object, moves, hides and draws the objects
 * Aversion 1.0
 * @since 06/15/2025
 * @author Tina 
 */
public class Character {
    public int x,y;//x and y coord
    protected int width, height;//dimention of the character image 
    protected PApplet app;//the canvas used to used to display graphical element
    protected PImage image;//image of the characters
    private int fillcolour;//colour of the object
    /**\
     * This is a constructor that will instance the attributes.
     * @param P the canvas used to used to display graphical element
     * @param x the x-cord of the position for the image
     * @param y the y-cord of the position for the image
     * @param imagePath image of the object
     */
    public Character(PApplet P, int x, int y,String imagePath){
        this.app=P;
        this.x=x;
        this.y=y;
        this.image=app.loadImage(imagePath);
        this.width=image.width;
        this.height=image.height;
    }
    /**
     * This is a constructor that will instance the rectangle
     * @param p the canvas used to used to display graphical element
     * @param x the x-cord of the position for the image
     * @param y the y-cord of the position for the image
     * @param width the width of the rectangle
     * @param height the height of the rectangle
     * @param fillcolour the colour of the rectangle
     */
    public Character(PApplet p, int x, int y,int width, int height,int fillcolour) {
        this.app= p;
        this.x= x;
        this.y= y;
        this.width = width;
        this.height = height;
        this.fillcolour = fillcolour;
    }
    
    /**
     * This is a method that moves the object to a specific position
     * @param dx This is the amount the object's going to move in the x-cord
     * @param dy This is the amount the object's going to move in the y-cord
     */
   public void move(float dx, float dy){
        x+=dx;
        y+=dy;
    }
    
    /**
     * This is a method that hides the object after it has collision was detected.
     */ 
    public void hidedraw(){
        //To hid it, it will transport the x and y cords out of frame
        //where then it can't be seen anymore
        x=5000;
        y=5000;
    }
    
    /**
     * This is a method that draws rectangle that is used as background of the timer
     */
    public void drawingtimer(){
        app.fill(fillcolour);//sets the colour of the rectangle
        app.rect(x, y, width, height);//draws the rectanlge, setting it's position and dimentions
    }
    
    /**
     * This is a method that draw the background and characters
     */
    public void draw(){
        app.image(image, x, y);//draws the characters
        app.fill(134,114,59);//fills the colour of the rectangle(used as the clif)
        app.rect(0, 400, 300, 200);////draws the rectanlge, setting it's position and dimentions(used as a clif)
    }
   
}
