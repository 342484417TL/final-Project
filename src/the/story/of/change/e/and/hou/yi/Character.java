/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package the.story.of.change.e.and.hou.yi;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * A class
 * @author tina
 */
public class Character {
    public int x,y;//x and y coord
    private int width, height;//dimention of the character image 
    private PApplet app;//the canvas used to used to display graphical element
    private PImage image;//image of the characters
    
    public Character(PApplet P, int x, int y,String imagePath){
        this.app=P;
        this.x=x;
        this.y=y;
        this.image=app.loadImage(imagePath);
        this.width=image.width;
        this.height=image.height;
    }
    //method that moves the object to a certain position
    public void move(int dx, int dy){
        x= x+dx;
        y= y+dy;
    }
    //method that draw the image
    public void draw(){
        app.image(image, x, y);
    }
}
