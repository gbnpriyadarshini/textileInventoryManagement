import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


class Orders extends JPanel
{
	JPanel DisplayPanel;
	JTextField Date,Customer,ClothType,Color,Quantity,LastDate,Amount;
	JButton Add,Reset;
	String t1,t2,t3,t4,t5,t6,t7;

	Orders()
	{
		designLayout();
		setSize(500,500);
		setVisible(true);
		
	}

	public void designLayout()
	{
		
		DisplayPanel = new JPanel();
		DisplayPanel.setLayout(new GridLayout(8,2));

		Date = new JTextField(20);
		Customer = new JTextField(20);
		ClothType = new JTextField(20);
		Color = new JTextField(20);
		Quantity = new JTextField(20);
		LastDate = new JTextField(20);
		Amount = new JTextField(20);

		Add = new JButton("ADD");
		Reset = new JButton("RESET");

		DisplayPanel.add(new JLabel("Date : "));
		DisplayPanel.add(Date);
		
		DisplayPanel.add(new JLabel("Customer Id : "));
		DisplayPanel.add(Customer);
		
		DisplayPanel.add(new JLabel("ClothType : "));
		DisplayPanel.add(ClothType);

		DisplayPanel.add(new JLabel("Color : "));
		DisplayPanel.add(Color);

		DisplayPanel.add(new JLabel("Quantity (in bundles) : "));
		DisplayPanel.add(Quantity);

		DisplayPanel.add(new JLabel("LastDate : "));
		DisplayPanel.add(LastDate);

		DisplayPanel.add(new JLabel("Amount (in rupees) : "));
		DisplayPanel.add(Amount);

		DisplayPanel.add(Add);
		DisplayPanel.add(Reset);

		add(DisplayPanel);

		Add.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				if(Date.getText().trim().equals("")||Customer.getText().trim().equals("")||ClothType.getText().trim().equals("")||Color.getText().trim().equals("")||LastDate.getText().trim().equals("")||Quantity.getText().trim().equals("")||Amount.getText().trim().equals(""))
				{
					JOptionPane.showMessageDialog(null,"NOT ALL FIELDS ENTERED");
				}else
				{
					t1 = Date.getText();
					t2 = Customer.getText();
					t3 = ClothType.getText();
					t4 = Color.getText();
					t5 = Quantity.getText();
					t6 = LastDate.getText();
					t7 = Amount.getText();
				
					try
					{
						Class.forName("oracle.jdbc.driver.OracleDriver");
						Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
						Statement stmt=con.createStatement();
						int i = stmt.executeUpdate("INSERT INTO ORDERS(ORDERDATE,CUSTOMER,CLOTHTYPE,COLOR,QUANTITY,LASTDATE,AMOUNT) VALUES('"+t1+"','"+t2+"','"+t3+"','"+t4+"','"+t5+"','"+t6+"','"+t7+"')");
						JOptionPane.showMessageDialog(null,"ORDER ENTERED");
						con.close();
					}catch(Exception e)
					{
						JOptionPane.showMessageDialog(null,"ERROR IN ENTERING ORDER");
					}
				}
			}
		});

		Reset.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				Date.setText(" ");
				ClothType.setText(" ");
				Color.setText(" ");
				Quantity.setText(" ");
				Customer.setText(" ");
				LastDate.setText(" ");
				Amount.setText(" ");
			} 
		});
	}
}