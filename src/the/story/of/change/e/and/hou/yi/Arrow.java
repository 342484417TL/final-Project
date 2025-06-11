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
public class Arrow {
    public int x,y;//x and y coord
    private int width, height;//dimention of the character image 
    private PApplet app;//the canvas used to used to display graphical element
    private PImage image;//image of the characters
    public static float angle=0;
    private boolean isMoving=false;
    private  float vx=0;
    private float vy=0;
    private float speed=5;
    
    
    public Arrow(PApplet P, int x, int y,String imagePath){
        this.app=P;
        this.x=x;
        this.y=y;
        this.image=app.loadImage(imagePath);
        this.width=image.width;
        this.height=image.height;
        this.image.resize(150, 150);
    }
    //method that moves the object to a certain position
    public void arrowmove(float dx, float dy){
        x+=dx;
        y+=dy;
    }
    
    public void move(int dx, int dy){
        x+=dx;
        y+=dy;
    }
    
    public void rotate(float delta) {
        angle += delta;
        angle = PApplet.constrain(angle, -180, 180);
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
    
    //method that draw the image
    public void draw() {
        app.pushMatrix();
        app.translate(x + image.width / 2, y + image.height / 2); // Move to image center
        app.rotate(PApplet.radians(angle));                       // Rotate around center
        app.imageMode(PApplet.CENTER);                            // Draw image from center
        app.image(image, 0, 0);                                    // Draw at transformed origin
        app.imageMode(PApplet.CORNER);                            // Reset to default
        app.popMatrix();
    }
}
