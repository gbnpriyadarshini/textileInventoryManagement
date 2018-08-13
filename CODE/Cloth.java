import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class Cloth extends JPanel
{
	JPanel DisplayPanel,ButtonsPanel;
	JTextField ClothType,Color,Customer,Quantity,Sold,Date;
	JButton Add,Reset;
	String t1,t2,t3,t4,t5,t6;

	Cloth()
	{
		designLayout();
		setSize(500,500);
		setVisible(true);
	}

	public void designLayout()
	{		

		DisplayPanel = new JPanel();
		DisplayPanel.setLayout(new GridLayout(7,2));
		ButtonsPanel = new JPanel();
		ButtonsPanel.setLayout(new GridLayout(1,2));

		ClothType = new JTextField(20);
		Color = new JTextField(20);
		Customer = new JTextField(20);
		Quantity = new JTextField(20);
		Sold = new JTextField(20);
		Date = new JTextField(20);

		Add = new JButton("ADD");
		Reset = new JButton("RESET");

		DisplayPanel.add(new JLabel("Cloth Type : "));
		DisplayPanel.add(ClothType);

		DisplayPanel.add(new JLabel("Color : "));
		DisplayPanel.add(Color);

		DisplayPanel.add(new JLabel("Quantity (in bundles) : "));
		DisplayPanel.add(Quantity);

		// Sold = new ButtonGroup();

		// YesButton = new JRadioButton("Yes");
		// NoButton = new JRadioButton("No");

		// Sold.add(YesButton);
		// Sold.add(NoButton);

		DisplayPanel.add(new JLabel("Sold : "));
		DisplayPanel.add(Sold);

		// ButtonsPanel.add(YesButton);
		// ButtonsPanel.add(NoButton);
			
		// DisplayPanel.add(ButtonsPanel);

		DisplayPanel.add(new JLabel("Customer Id : "));
		DisplayPanel.add(Customer);

		DisplayPanel.add(new JLabel("Date : "));
		DisplayPanel.add(Date);

		DisplayPanel.add(Add);
		DisplayPanel.add(Reset);

		add(DisplayPanel);

		Add.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				if(ClothType.getText().trim().equals("")||Color.getText().trim().equals("")||Date.getText().trim().equals("")||Quantity.getText().trim().equals("")||Customer.getText().trim().equals("")||Sold.getText().trim().equals(""))
				{
					JOptionPane.showMessageDialog(null,"NOT ALL FIELDS ENTERED");
				}else
				{
					t1 = ClothType.getText();
					t2 = Color.getText();
					t3 = Quantity.getText();
					t4 = Customer.getText();
					t5 = Sold.getText();
					t6 = Date.getText();
					// Boolean t5 = Sold.getSelection().isSelected();
		
					try
					{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
					Statement stmt=con.createStatement();
					int i = stmt.executeUpdate("INSERT INTO OUTPUTCLOTH(CLOTHTYPE,COLOR,QUANTITY,CUSTOMER,SOLD,ORDERDATE) VALUES('"+t1+"','"+t2+"','"+t3+"','"+t4+"','"+t5+"','"+t6+"')");
					JOptionPane.showMessageDialog(null,"CLOTH OUTPUT ENTERED");
					con.close();
					}catch(Exception e)
					{
					JOptionPane.showMessageDialog(null,"ERROR IN ENTERING CLOTH OUTPUT");
					}
				}
			}
		});

		Reset.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				ClothType.setText(" ");
				Color.setText(" ");
				Quantity.setText(" ");
				Customer.setText(" ");
				Sold.setText(" ");
				Date.setText(" ");
				// Sold.clearSelection();
			} 
		});
	}
}