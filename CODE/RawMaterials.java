import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


class RawMaterials extends JPanel
{

	JPanel DisplayPanel;
	JTextField RM,Quantity,Cost,Date,Vendor,RMType;
	JButton Add,Reset;
	String t1,t2,t3,t4,t5,t6;

	RawMaterials()
	{
		
		designLayout();
		setSize(500,500);
		setVisible(true);
		
	}

	public void designLayout()
	{
		
		DisplayPanel = new JPanel();
		DisplayPanel.setLayout(new GridLayout(7,2));
		
		RMType = new JTextField(20);
		RM = new JTextField(20);
		Quantity = new JTextField(20);
		Cost = new JTextField(20);
		Date = new JTextField(20);
		Vendor = new JTextField(20);

		Add = new JButton("ADD");
		Reset = new JButton("RESET");

		setLayout(new FlowLayout());

		DisplayPanel.add(new JLabel("Raw Material Type : "));
		DisplayPanel.add(RMType);
		
		DisplayPanel.add(new JLabel("Raw Material : "));
		DisplayPanel.add(RM);

		DisplayPanel.add(new JLabel("Quantity (in kg or meters) : "));
		DisplayPanel.add(Quantity);

		DisplayPanel.add(new JLabel("Cost (in rupees) : "));
		DisplayPanel.add(Cost);

		DisplayPanel.add(new JLabel("Date : "));
		DisplayPanel.add(Date);

		DisplayPanel.add(new JLabel("Vendor Id : "));
		DisplayPanel.add(Vendor);

		DisplayPanel.add(Add);
		DisplayPanel.add(Reset);

		add(DisplayPanel);


		Add.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				if(RMType.getText().trim().equals("")||RM.getText().trim().equals("")||Quantity.getText().trim().equals("")||Cost.getText().trim().equals("")||Date.getText().trim().equals("")||Vendor.getText().trim().equals(""))
				{
					JOptionPane.showMessageDialog(null,"NOT ALL FIELDS ENTERED");
				}else
				{
					t1 = RMType.getText();
					t2 = RM.getText();
					t3 = Quantity.getText();
					t4 = Cost.getText();
					t5 = Date.getText();
					t6 = Vendor.getText();
				

					try
					{
						Class.forName("oracle.jdbc.driver.OracleDriver");
						Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
						Statement stmt=con.createStatement();
						int i = stmt.executeUpdate("INSERT INTO INPUTRAW(RAWTYPE,RAWCATEGORY,QUANTITY,COST,BUYDATE,VENDOR) VALUES('"+t1+"','"+t2+"','"+t3+"','"+t4+"','"+t5+"','"+t6+"')");
						JOptionPane.showMessageDialog(null,"RAW MATERIALS ENTERED");
						con.close();
					}catch(Exception e)
					{
						JOptionPane.showMessageDialog(null,"ERROR IN ENTERING RAW MATERIALS");
					}
				}
			}
		});

		Reset.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				RMType.setText(" ");
				RM.setText(" ");
				Quantity.setText(" ");
				Cost.setText(" ");
				Date.setText(" ");
				Vendor.setText(" ");
			} 
		});
	}
}