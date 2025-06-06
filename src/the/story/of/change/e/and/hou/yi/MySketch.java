
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
    private Character[] sun;
    private int sun1Speed=2;
    private int sun2Speed=2;
    private int [] sunSpeedx= {1,2,3,1,2,3,1,2,3,2};
    private int [] sunSpeedy= {1,2,3,1,2,3,1,2,3,2};
    //private Character
    
    public void settings(){
        size(600,600);//Sets the size of the screen
    }
    
    public void setup(){
        //Sets the background colour to white
        background(255);
        Houyi=new Character(this, 100, 30, "images/houyi.png");
        //ChangeE=new Character(this, 0, 20, "images/changeE.png");
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
        sun[0].move(sunSpeedx[0], sunSpeedy[0]);
        if ((sun[0].x >= 500 || sun[0].x <= 400) && (sun[0].y >= 100 || sun[0].y <= 30)) {
            sunSpeedx[0] = -sunSpeedx[0];
            sunSpeedy[0]=-sunSpeedy[0];
        }
    }
    
    public void sun2Animated() {
        sun[1].move(-sunSpeedx[1], sunSpeedy[1]);
        if (sun[1].y >= 200 || sun[1].y <= 80) {
            sunSpeedy[1] = -sunSpeedy[1];
        }
        if(sun[1].x<=200||sun[1].x>280){
            sunSpeedx[1] = -sunSpeedx[1];
            sunSpeedy[1] = -sunSpeedy[1];
        } 
    }
    
    public void sun3Animated(){
        sun[2].move(sunSpeedx[2], sunSpeedy[2]);
        if ((sun[2].x >= 480 || sun[2].x <= 400) && (sun[2].y >= 200 || sun[2].y <= 160)) {
            sunSpeedx[2] = -sunSpeedx[2];
            sunSpeedy[2]=-sunSpeedy[2];
        }
    }
    
    public void sun4Animated(){
        sun[3].move(-sunSpeedx[3], sunSpeedy[3]);
        if (sun[3].y >= 100 || sun[3].y <= 25) {
            sunSpeedy[3] = -sunSpeedy[3];
        }
        if(sun[3].x<=100||sun[3].x>150){
            sunSpeedx[3] = -sunSpeedx[3];
            sunSpeedy[3] = -sunSpeedy[3];
        } 
    }
     
    private void sun5Animated(){
        sun[4].move(0, sunSpeedy[4]);
        if(sun[4].y==150||sun[4].y==300){
            sunSpeedy[4]=-sunSpeedy[4];
            //sun[4].move(0, sunSpeedy[4]);
        }
    }
    
    private void sun6Animated(){
        sun[5].move(-sunSpeedx[5], 0);
        if(sun[5].x==500||sun[5].x==450){
            sunSpeedx[5]=-sunSpeedx[5];
            sun[5].move(sunSpeedx[5],0);
        }
    }
       
    
    public void scene1draw(){
        background(239,221,58);
        for(int i=0; i<10; i++){
            sun[i].draw();
        }
        Houyi.draw();
        sun1Animated();
        sun2Animated();
        sun3Animated();
        sun4Animated();
        sun5Animated();
        sun6Animated();
    }
    
    public void draw(){ 
       scene1draw(); 
    }   
}
