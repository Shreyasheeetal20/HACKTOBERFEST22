
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
/*
<applet code="MouseDemo.class" width=200 height=200> </applet>
*/

public class MouseDemo extends Applet implements MouseListener,MouseMotionListener
{
	int mousex=0,mousey=0;
	String msg="";
	public void init()
	{
		// setBackground(Color.red);
		// setForeground(Color.blue);
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	public void mouseClicked(MouseEvent me)
	{
		mousex=10;
		mousey=20;
		msg="you have clicked the mouse";
		repaint();
	}

	public void mousePressed(MouseEvent me)
	{
		mousex=me.getX();
		mousey=me.getY();
		msg="you have pressed the mouse";
		repaint();	
	}

	public void mouseReleased(MouseEvent me)
	{
		mousex=me.getX();
		mousey=me.getY();
		msg="you have Released the mouse";
		repaint();	
	}

	public void mouseEntered(MouseEvent me)
	{
		mousex=60;
		mousey=40;
		msg="mouse is entered into applet";
		repaint();	
	}

	public void mouseExited(MouseEvent me)
	{
		mousex=70;
		mousey=40;
		msg="mouse is exited from applet";
		repaint();	
	}

	public void mouseDragged(MouseEvent me)
	{
		showStatus("mouse is Dragged from ("+me.getX()+","+me.getY()+")");
	}

	public void mouseMoved(MouseEvent me)
	{
		showStatus("mouse is Moved from ("+me.getX()+","+me.getY()+")");
	}

	public void paint(Graphics g)
	{
		g.drawString(msg,mousex,mousey);
	}
	

}
