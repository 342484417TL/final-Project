package the.story.of.change.e.and.hou.yi;

import processing.core.PApplet;
import processing.core.PImage;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * This is a subClass of Character where it specifically instances arrow.
 * Additionally, it moves, rotates and collision detects.
 * @Version 1.0
 * @since 06/15/2025
 * @author Tina
 */
public class Arrow extends Character{
    public static float angles=-38;//angle of rotation for all arrows(default)
    private int angle;//angle of which the arrow is angled at
    private boolean isMoving=true;//determines if the arrow is moving
    private  float vx=0;//x-cord speed of arrow 
    private float vy=0;//y-cord speed of arrow
    
    /**
     * This is a constructor that will instance the attributes.
     * @param P the canvas used to used to display graphical element
     * @param x the x-cord of the position for the image
     * @param y the y-cord of the position for the image
     * @param angle angle of which the arrow is angled at
     * @param imagePath image of the object
     */
    public Arrow(PApplet P, int x, int y, int angle, String imagePath){
        super(P, x, y,imagePath);//calls the parent class
        this.angle=angle;//sets the angle
    }
    
    /**
     * This is a method that moves the object to a specific position
     * @param dx This is the amount the object's going to move in the x-cord
     * @param dy This is the amount the object's going to move in the y-cord
     */
    @Override
    public void move(float dx, float dy){
        x+=dx;
        y+=dy;
    }
    /**
     * This is a method rotates the arrow
     * @param angle the degree the arrow need to rotate
     */
    public void rotate(float angle) {
        angles += angle;//rotates the angle 
        angles = PApplet.constrain(angles, -180, 180);//allows the angle to go 360
    }
    /**
     * This is a method that sets x and y direction it needs to go.
     * @param dx This is the amount the object's going to move in the x-cord
     * @param dy This is the amount the object's going to move in the y-cord
     */
    public void startMoving(float dx, float dy){
        vx=dx;
        vy=dy;
        //sets it as true to allow it to move
        isMoving=true;
    }
    /**
     * This is a method that moves the arrow when it's true
     */
    public void update(){
        if(isMoving){
            move(vx, vy);
        }
    }
    /**
     * A method that returns weather the arrow is moving or not
     * @return a Boolean of weather the arrow is moving or not
     */
    public boolean isMoving(){
        return isMoving;
    }
    /**
     * A method that collision detects
     * @param other the other object that will be detected for collision
     * @return booleans of weather collision is detected 
     */
    public boolean isColliding(Character other){
        //detects if the arrow is left edge of the right edge of the other object
        boolean isLeftOfRight= x<other.x+other.width;
        //detects if the arrow is right edge of the left edge of the other object
        boolean isRightOfLeft= x+width>other.x;
        //detects if the arrow is top edge of the bottom edge of the other object
        boolean isAboveOtherBottom=y<other.y+other.height;
        //detects if the arrow is bottom edge of the top edge of the other object
        boolean isBelowOtherTop=y+height>other.y;
        return isLeftOfRight&&isRightOfLeft&&isAboveOtherBottom&&isBelowOtherTop;
    }
    
    /**
     * A method that draws out the image of the arrow
     */
    @Override
    public void draw() {
        app.pushMatrix();
        app.translate(x + image.width / 2, y + image.height / 2); // Move to image center
        app.rotate(PApplet.radians(angles));                       // Rotate around center
        app.imageMode(PApplet.CENTER);                            // Draw image from center
        app.image(image, 0, 0);                                    // Draw at transformed origin
        app.imageMode(PApplet.CORNER);                            // Reset to default
        app.popMatrix();
    }
}
