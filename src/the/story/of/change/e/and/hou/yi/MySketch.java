
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
    private Arrow arrow;
    private float[] target = new float [2];
    boolean arrowMoving = false;
    public float angle=0;
    float arrowSpeed=5;
    private Character[] sun;
    private int sun1Speed=2;
    private int sun2Speed=2;
    private int[][] sunSpeed={{2,2}, {5,5}, {3,3}, {1,1},{0,2},{3,0}};
    
    public void settings(){
        size(600,600);//Sets the size of the screen
    }
    
    public void setup(){
        //Sets the background colour to white
        background(255);
        Houyi=new Character(this, 70, 30, "images/houyi.png");
        arrow = new Arrow(this, 170, 110, "images/arrow.png");
        sun = new Character[10];
        sun[0]=new Character(this, 480, 30, "images/sun.png");
        sun[1]=new Character(this, 280, 80, "images/sun.png");
        sun[2]=new Character(this, 400, 160, "images/sun.png");
        sun[3]=new Character(this, 150, 25, "images/sun.png");
        sun[4]=new Character(this, 30, 150, "images/sun.png");
        sun[5]=new Character(this, 500, 350, "images/sun.png");
        sun[6]=new Character(this, 10, 20, "images/sun.png");
        sun[7]=new Character(this, 320, 300, "images/sun.png");
        sun[8]=new Character(this, 350, 450, "images/sun.png");
        sun[9]=new Character(this, 490, 500, "images/sun.png");
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
        }else if(sun[1].x<=200||sun[1].x>280){
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

    
    public void scene1draw(){
        background(239,221,58);
        Houyi.draw();
        for(int i=0; i<10; i++){
            sun[i].draw();
        }
        arrow.draw();
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
            arrow.rotate(-5);
        } else if (keyCode == RIGHT){
            arrow.rotate(5);
        }//else if(angle<=90){
            //arrow.arrowmove(20, 34);
        else if(keyCode==ENTER){
           float rad = PApplet.radians(Arrow.angle); // get angle in radians
            float dx = (float)(Math.cos(rad) * 10);
            float dy = (float)(Math.sin(rad) * 10);
            arrow.startMoving(dx, dy); 
        }
    }


    
    public void draw(){ 
       //Houyi.draw();
       scene1draw(); 
       sunAnimations();
       arrow.update();
    }  
}
