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
{   Image  nowimg;//,downImg,leftImg,upImg,rightImg,leftImg_1,leftImg_2,upImg_1,upImg_2,rightImg_1,rightImg_2,downImg_1,downImg_2;
    Image HeroLeftImg[]=new Image[3];
	Image HeroRightImg[]=new Image[3];  
	Image HeroUpImg[]=new Image[3];  
	Image HeroDownImg[]=new Image[3];
	int x,y,i;
	int Flag;
    public MainCanvas()
	{
		try
		{
		 for(i=0;i<HeroLeftImg.length;i++)
		HeroLeftImg[i]=Image.createImage("/sayo"+i+"2.png");
			/*
			leftImg=Image.createImage("/sayo12.png");
			leftImg_1=Image.createImage("/sayo02.png");
			leftImg_2=Image.createImage("/sayo22.png");
		*/
      
		for(i=0;i<HeroRightImg.length;i++)
		HeroRightImg[i]=Image.createImage("/sayo"+i+"6.png");
            /*rightImg=Image.createImage("/sayo16.png");
			rightImg_1=Image.createImage("/sayo06.png");
			rightImg_2=Image.createImage("/sayo26.png");*/
   
			
        for(i=0;i<HeroUpImg.length;i++)
		HeroUpImg[i]=Image.createImage("/sayo"+i+"4.png");
			/*upImg=Image.createImage("/sayo14.png");
			upImg_1=Image.createImage("/sayo04.png");
            upImg_2=Image.createImage("/sayo24.png");
      */
		for(i=0;i<HeroDownImg.length;i++)
		HeroDownImg[i]=Image.createImage("/sayo"+i+"0.png");
			/*
			downImg=Image.createImage("/sayo10.png");
			downImg_1=Image.createImage("/sayo00.png");
			downImg_2=Image.createImage("/sayo20.png");*/
		
			nowimg=HeroDownImg[1];
			x=110;y=130;
			Flag=1;
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
	
	if(action==LEFT && x>=0){
    if(Flag==1){nowimg=HeroLeftImg[0];Flag++;}
	else if(Flag==2){nowimg=HeroLeftImg[2];Flag--;}
	x=x-5;} 

	if(action==RIGHT && x<=215){
    if(Flag==1){nowimg=HeroRightImg[0];Flag++;}
	else if(Flag==2){nowimg=HeroRightImg[2];Flag--;}
    x=x+5; }

    if(action==UP && y>=0){
	if(Flag==1){nowimg=HeroUpImg[0];Flag++;}
	else if(Flag==2){nowimg=HeroUpImg[2];Flag--;}
	y=y-5;}

	if(action==DOWN && y<=260){
	if(Flag==1){nowimg=HeroDownImg[0];Flag++;}
	else if(Flag==2){nowimg=HeroDownImg[2];Flag--;}
	y=y+5;
	}
 	       repaint();
	}
}



