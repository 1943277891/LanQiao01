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
{   Image HeroImg[][]=new Image[4][3];
	Image  HeroNowImg;/*//,downImg,leftImg,upImg,rightImg,leftImg_1,leftImg_2,upImg_1,upImg_2,rightImg_1,rightImg_2,downImg_1,downImg_2;
    Image HeroLeftImg[]=new Image[3];
	Image HeroRightImg[]=new Image[3];  
	Image HeroUpImg[]=new Image[3];  
	Image HeroDownImg[]=new Image[3];*/
	int x,y,i,j;
	int Flag;
    public MainCanvas()
	{
		try
		{
		 for(i=0;i<HeroImg.length;i++){
		    for(j=0;j<HeroImg[i].length;j++){
          HeroImg[i][j]=Image.createImage("/sayo"+i+j+".png");
		 }
		 }

		 /*
		 0表示向左
		 1表示向右
		 2表示向上
		 3表示向下
		 */
		/*HeroLeftImg[i]=Image.createImage("/sayo"+i+"2.png");
			/*向左走
			leftImg=Image.createImage("/sayo12.png");
			leftImg_1=Image.createImage("/sayo02.png");
			leftImg_2=Image.createImage("/sayo22.png");
		    
      
		for(i=0;i<HeroRightImg.length;i++)
		HeroRightImg[i]=Image.createImage("/sayo"+i+"6.png");
            /*向右走
			rightImg=Image.createImage("/sayo16.png");
			rightImg_1=Image.createImage("/sayo06.png");
			rightImg_2=Image.createImage("/sayo26.png");
   
			
        for(i=0;i<HeroUpImg.length;i++)
		HeroUpImg[i]=Image.createImage("/sayo"+i+"4.png");
			/*向上走
			upImg=Image.createImage("/sayo14.png");
			upImg_1=Image.createImage("/sayo04.png");
            upImg_2=Image.createImage("/sayo24.png");
            
		for(i=0;i<HeroDownImg.length;i++)
		HeroDownImg[i]=Image.createImage("/sayo"+i+"0.png");
			/*向下走
			downImg=Image.createImage("/sayo10.png");
			downImg_1=Image.createImage("/sayo00.png");
			downImg_2=Image.createImage("/sayo20.png");
			*/
		
			HeroNowImg=HeroImg[3][1];
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
		g.drawImage(HeroNowImg,x,y,0);
	}
	public void keyPressed(int keyCode){
	int action=getGameAction(keyCode);
	
	if(action==LEFT && x>=0){
    if(Flag==1){HeroNowImg=HeroImg[0][0];Flag++;}
	else if(Flag==2){HeroNowImg=HeroImg[0][2];Flag--;}
	x=x-5;} 

	if(action==RIGHT && x<=215){
    if(Flag==1){HeroNowImg=HeroImg[1][0];Flag++;}
	else if(Flag==2){HeroNowImg=HeroImg[1][2];Flag--;}
    x=x+5; }

    if(action==UP && y>=0){
	if(Flag==1){HeroNowImg=HeroImg[2][0];Flag++;}
	else if(Flag==2){HeroNowImg=HeroImg[2][2];Flag--;}
	y=y-5;}

	if(action==DOWN && y<=260){
	if(Flag==1){HeroNowImg=HeroImg[3][0];Flag++;}
	else if(Flag==2){HeroNowImg=HeroImg[3][2];Flag--;}
	y=y+5;
	}
 	       repaint();
	}
}