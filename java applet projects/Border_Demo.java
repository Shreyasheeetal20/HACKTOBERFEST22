
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
/*
<applet code="Border_Demo.class" width=500 height=500> </applet>
*/
public class Border_Demo extends Applet implements ActionListener
{
	Label l1;
	Button b1;
	public void init()
	{
		setLayout(new BorderLayout());
		b1=new Button("East");
		add(b1,BorderLayout.EAST);
		l1=new Label("West");
		add(l1,BorderLayout.WEST);
		// add(new Button("East"),BorderLayout.EAST);
		// add(new Button("West"),BorderLayout.WEST);
		add(new Button("North"),BorderLayout.NORTH);
		add(new Button("South"),BorderLayout.SOUTH);
		add(new Button("Center"),BorderLayout.CENTER);
		b1.addActionListener(this);	
	}
	public void actionPerformed(ActionEvent ae)
	{
		String msg=ae.getActionCommand();
		System.out.println(msg);
		if (msg.equals("East")) 
		{
			b1.setLabel("Hello");
			setBackground(Color.red);	
		}
	}
}