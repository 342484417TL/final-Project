package the.story.of.change.e.and.hou.yi;

import processing.core.PApplet;
import processing.core.PImage;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author tina
 */
public class Arrow extends Character{
    public static float angles=-30;
    private int angle;
    private boolean isMoving=true;
    private  float vx=0;
    private float vy=0;
    
    
    public Arrow(PApplet P, int x, int y, int angle, String imagePath){
        super(P, x, y,imagePath);
        this.angle=angle;
    }
    
    //method that moves the object to a certain position
    public void arrowmove(float dx, float dy){
        x+=dx;
        y+=dy;
    }
    
    @Override
    public void move(int dx, int dy){
        x+=dx;
        y+=dy;
    }
    
    public void rotate(float angle) {
        angles += angle;
        angles = PApplet.constrain(angles, -180, 180);
    }

    public void startMoving(float dx, float dy){
        vx=dx;
        vy=dy;
        isMoving=true;
    }
    
    public void update(){
        if(isMoving){
            arrowmove(vx, vy);
        }
    }
    
    public boolean isMoving(){
        return isMoving;
    }
    
    public boolean isColliding(Character other){
        boolean isLeftOfRight= x<other.x+other.width;
        boolean isRightOfLeft= x+width>other.x;
        boolean isAboveOtherBottom=y<other.y+other.height;
        boolean isBelowOtherTop=y+height>other.y;
        return isLeftOfRight&&isRightOfLeft&&isAboveOtherBottom&&isBelowOtherTop;
    }
    
    //method that draw the imageA
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
