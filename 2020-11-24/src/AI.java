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
class MainCanvas extends Canvas implements Runnable
{   Image HeroImg[][]=new Image[4][3];
    Thread thread;
    Image BossImg;
	Image  HeroNowImg;/*//,downImg,leftImg,upImg,rightImg,leftImg_1,leftImg_2,upImg_1,upImg_2,rightImg_1,rightImg_2,downImg_1,downImg_2;
    Image HeroLeftImg[]=new Image[3];
	Image HeroRightImg[]=new Image[3];  
	Image HeroUpImg[]=new Image[3];  
	Image HeroDownImg[]=new Image[3];*/
	int heroX,heroY,bossX,bossY,i,j;
	int Flag;
    public MainCanvas()
	{
		try
		{
		 for(i=0;i<HeroImg.length;i++){
		    for(j=0;j<HeroImg[i].length;j++){
          HeroImg[i][j]=Image.createImage("/sayo"+i+j+".png");
		 }
		 BossImg=Image.createImage("/asd.png");
		 }

		 /*
		 0��ʾ����
		 1��ʾ����
		 2��ʾ����
		 3��ʾ����
		 */
		/*HeroLeftImg[i]=Image.createImage("/sayo"+i+"2.png");
			/*������
			leftImg=Image.createImage("/sayo12.png");
			leftImg_1=Image.createImage("/sayo02.png");
			leftImg_2=Image.createImage("/sayo22.png");
		    
      
		for(i=0;i<HeroRightImg.length;i++)
		HeroRightImg[i]=Image.createImage("/sayo"+i+"6.png");
            /*������
			rightImg=Image.createImage("/sayo16.png");
			rightImg_1=Image.createImage("/sayo06.png");
			rightImg_2=Image.createImage("/sayo26.png");
   
			
        for(i=0;i<HeroUpImg.length;i++)
		HeroUpImg[i]=Image.createImage("/sayo"+i+"4.png");
			/*������
			upImg=Image.createImage("/sayo14.png");
			upImg_1=Image.createImage("/sayo04.png");
            upImg_2=Image.createImage("/sayo24.png");
            
		for(i=0;i<HeroDownImg.length;i++)
		HeroDownImg[i]=Image.createImage("/sayo"+i+"0.png");
			/*������
			downImg=Image.createImage("/sayo10.png");
			downImg_1=Image.createImage("/sayo00.png");
			downImg_2=Image.createImage("/sayo20.png");
			*/
		
			HeroNowImg=HeroImg[3][1];
			heroX=110;heroY=130;
			bossX=0;bossY=0;
			Flag=1;
			thread=new Thread(this);
			thread.start();
		}
		
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void run(){
		while(true){
			try
			{
				Thread.sleep(200);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			if(bossX<heroX)
			{
				bossX++;
			}
			else{
				bossX--;
				}
				if(bossY<heroY)
			{
				bossY++;
			}
			else{
				bossY--;
				}  repaint();
		}
	}
	public void paint(Graphics g){
		g.setColor(0,191,255);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(HeroNowImg,heroX,heroY,0);
        g.drawImage(BossImg,bossX,bossY,0);
	} 
	public void ChangePicAndDirection(int direction)//����һ������Ӣ���ƶ�ʱͼƬ����ĺ���
	{
	    if(Flag==1){HeroNowImg=HeroImg[direction][0];Flag++;}//����� direction �βα�ʾΪ���򣬷��ڶ�ά����HeroImg�к�ֵ��HeroNowImg
	else if(Flag==2){HeroNowImg=HeroImg[direction][2];Flag--;}
	    
	}
	public void keyPressed(int keyCode){
	int action=getGameAction(keyCode);
	
	if(action==LEFT && heroX>=0){
     ChangePicAndDirection(0);   //���ú��� ChangePicAndDirection���������0��ʾӢ�۷���(directio)Ϊ��
	heroX=heroX-5;} 

	if(action==RIGHT && heroX<=215){
    ChangePicAndDirection(1);//���ú��� ChangePicAndDirection���������1��ʾӢ�۷���(directio)Ϊ��
    heroX=heroX+5; }//����λ����X��Y�������ò�Ҫ���¶���һ���������β�����ʾ

    if(action==UP && heroY>=0){
	 ChangePicAndDirection(2);
	heroY=heroY-5;}

	if(action==DOWN && heroY<=260){
 ChangePicAndDirection(3);
	heroY=heroY+5;
	}
 	       repaint();
	}
}