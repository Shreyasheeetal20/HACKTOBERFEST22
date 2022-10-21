
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
/*
<applet code="calculator.class" width=200 height=200> </applet>
*/
public class calculator extends Applet implements ActionListener
{
	Button b[]=new Button[10];
	Button btnadd,btnminus,btnmul,btndiv,btnmod,btneq,btnc;
	TextField tf;
	char ch;
	String op;
	int val1,val2,result;

	public void init()
	{
		setLayout(new GridLayout(5,4));
		
		for (int i=0;i<10;i++) 
		{
			b[i]=new Button(""+i);
		}	
		
		btnadd=new Button("+");
		btnminus=new Button("-");
		btnmul=new Button("*");
		btndiv=new Button("/");
		btnmod=new Button("%");
		btneq=new Button("=");
		btnc=new Button("c");
			
		tf=new TextField(20);		

		add(tf);
		for (int i=0;i<10;i++) 
		{
			add(b[i]);	
			b[i].addActionListener(this);
		}

		add(btnadd);
		add(btnminus);
		add(btnmul);
		add(btndiv);
		add(btnmod);
		add(btneq);
		add(btnc);

		btnadd.addActionListener(this);
		btnminus.addActionListener(this);
		btnmul.addActionListener(this);
		btndiv.addActionListener(this);
		btnmod.addActionListener(this);
		btneq.addActionListener(this);
		btnc.addActionListener(this);
	}

	public void actionPerformed(ActionEvent ae)
	{
		String msg=ae.getActionCommand();
		ch=msg.charAt(0);
		if (Character.isDigit(ch)) 
		{
			tf.setText(tf.getText()+msg);
		}
		else
		{
			if (msg.equals("+")) 
			{
				val1=Integer.parseInt(tf.getText());
				op="+";
				tf.setText("");	
			}

			else if (msg.equals("-")) 
			{
				val1=Integer.parseInt(tf.getText());
				op="-";
				tf.setText("");	
			}

			else if (msg.equals("*")) 
			{
				val1=Integer.parseInt(tf.getText());
				op="*";
				tf.setText("");	
			}

			else if (msg.equals("/")) 
			{
				val1=Integer.parseInt(tf.getText());
				op="/";
				tf.setText("");	
			}

			else if (msg.equals("%")) 
			{
				val1=Integer.parseInt(tf.getText());
				op="%";
				tf.setText("");	
			}

			else if (msg.equals("=")) 
			{
				val2=Integer.parseInt(tf.getText());
				if (op=="+") 
					result=val1+val2;	
				else if (op=="-") 
					result=val1-val2;	
				else if (op=="*") 
					result=val1*val2;					
				else if (op=="/") 
					result=val1/val2;					
				else if (op=="%") 
					result=val1%val2;	
				tf.setText(""+result);	
			}

			else if (msg.equals("c")) 
			{
				tf.setText("");	
			}
		}	
	}
}