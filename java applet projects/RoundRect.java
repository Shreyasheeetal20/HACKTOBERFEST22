import java.awt.*;
import java.applet.*;
/*<applet code="RoundRect.class" width=500 height=900></applet>*/

public class RoundRect extends Applet
{
	public void paint(Graphics g)
	{
		// g.drawRoundRect(20,30,30,40,20,30);
		// g.fillRoundRect(20,60,30,40,20,30);	
		
		// int x1=10;
		// for (int i=1;i<=4;i++) 
		// {
		// 	g.drawRoundRect(x1,20,30,30,20,20);
		// 	x1=x1+50;	
		// }

		int y=20;
		for (int i=1;i<=6;i++) 
		{
			if (i%2==0) 
			{	
				g.fillRoundRect(10,y,80,70,20,20);
				y=y+100;
			}	
			else
			{	
				g.drawRoundRect(10,y,80,70,20,20);
				y=y+100;
			}		
		}
	}
}
