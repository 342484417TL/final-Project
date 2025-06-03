
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package the.story.of.change.e.and.hou.yi;
import processing.core.PApplet;

/**
 * This is a sketch class that will display all images, animated movements and scenes
 * @author tina
 */
public class MySketch extends PApplet{
    private Character Houyi;
    private Character ChangeE;
    private Character sun1;
    private Character sun2;
    private Character sun3;
    private Character sun4;
    private Character sun5;
    private Character sun6;
    private Character sun7;
    private Character sun8;
    private Character sun9;
    private Character sun10;
    
    public void settings(){
        size(600,600);//Sets the size of the screen
    }
    
    public void setup(){
        //Sets the background colour to white
        background(255);
        Houyi=new Character(this, 100, 30, "images/houyi.png");
        //ChangeE=new Character(this, 0, 20, "images/changeE.png");
        
        sun1=new Character(this, 480, 30, "images/sun.png");
        sun2=new Character(this, 280, 80, "images/sun.png");
        sun3=new Character(this, 400, 160, "images/sun.png");
        sun4=new Character(this, 150, 25, "images/sun.png");
        sun5=new Character(this, 30, 170, "images/sun.png");
        sun6=new Character(this, 500, 350, "images/sun.png");
        sun7=new Character(this, 10, 20, "images/sun.png");
        sun8=new Character(this, 320, 300, "images/sun.png");
        sun9=new Character(this, 350, 450, "images/sun.png");
        sun10=new Character(this, 490, 500, "images/sun.png");
    }
    
    public void scene1draw(){
        background(239,221,58);
        sun1.draw();
        sun2.draw();
        sun3.draw();
        sun4.draw();
        sun5.draw();
        sun6.draw();
        sun7.draw();
        sun8.draw();
        sun9.draw();
        sun10.draw();
        Houyi.draw();
    }
    
    public void draw(){
       
       scene1draw(); 
    }   
}
