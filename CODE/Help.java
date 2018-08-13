import java.awt.*;
import javax.swing.*;

class Help extends JPanel
{
	Help()
	{
		designLayout();
		setVisible(true);
	}

	public void designLayout()
	{
		JPanel DisplayPanel;
		
		DisplayPanel = new JPanel();
		DisplayPanel.setLayout(new GridLayout(4,4));

		DisplayPanel.add(new JLabel("All the fields in all the pages are mandatory."));
		DisplayPanel.add(new JLabel("If any field is omitted in a page then data will not be entered."));
		DisplayPanel.add(new JLabel("In vendor page, the details of the vendor entered is not immediately seen. It can be viewed the next time you login."));
		DisplayPanel.add(new JLabel("In customer page, the details of the customer entered is not immediately seen. It can be viewed the next time you login. "));
		

		add(DisplayPanel);
	}
}