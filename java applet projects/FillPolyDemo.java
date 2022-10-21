
import java.awt.*;
import java.applet.*;
/*
<applet code="FillPolyDemo.class" width=200 height=200></applet>
*/
public class FillPolyDemo extends Applet
{
	public void init()
	{
		setBackground(Color.black);
		setForeground(Color.green);
	}
	
	public void paint(Graphics g)
	{
		int x[]={25,25,75,75,25,50,75,25};
		int y[]={35,85,85,35,35,10,35,35};
		g.fillPolygon(x,y,8);
		showStatus("Abhishek");
	}
}