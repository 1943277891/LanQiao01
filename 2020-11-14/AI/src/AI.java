import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;
public class AI extends MIDlet
{
	Display display;
	MainCanvas mc;
	public AI(){
		display=Display.getDisplay(this);
		mc=new MainCanvas();
		display.setCurrent(mc);
	}
	public void startApp(){
	}
	public void destroyApp(boolean unc){
	}
	public void pauseApp(){
	}
}
class MainCanvas extends Canvas
{   Image  nowimg,downImg,leftImg,upImg,rightImg;
    int x,y;
    public MainCanvas()
	{
		try
		{
			downImg=Image.createImage("/sayo10.png");
			leftImg=Image.createImage("/sayo12.png");
		    upImg=Image.createImage("/sayo14.png");
			rightImg=Image.createImage("/sayo16.png");
			nowimg=downImg;
			x=110;y=130;
		}
		
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.setColor(0,191,255);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(nowimg,x,y,0);
	}
	public void keyPressed(int keyCode){
	int action=getGameAction(keyCode);
	if(action==LEFT){
	nowimg=leftImg;
	x=x-5;
	} 
	if(action==RIGHT){
	nowimg=rightImg;
	x=x+5; 
	}
	if(action==UP){
	nowimg=upImg;
	y=y-5;
	}
	if(action==DOWN){
	nowimg=downImg;
	y=y+5;
	}
		repaint();
	}
}