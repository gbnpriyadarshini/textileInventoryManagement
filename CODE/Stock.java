import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.io.*;
import java.util.*;

class Stock extends JPanel
{
	JButton RawMaterial,Cloth;
	JPanel ButtonPanel;

	Stock()
	{
		
		designLayout();
		setSize(50,50);
		setVisible(true);
		
	}

	public void designLayout()
	{

		RawMaterial = new JButton("RAW MATERIALS");
		Cloth = new JButton("CLOTH");

		JPanel ButtonPanel = new JPanel();
		ButtonPanel.setLayout(new GridLayout(1,2));

		ButtonPanel.add(RawMaterial);
		ButtonPanel.add(Cloth);

		add(ButtonPanel);


		RawMaterial.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				JTextField Cotton,Silk,Wool,Dying,Preprocessing,Finishing,Dye;
				JPanel DisplayPanel;

				int a = 0;
				int b = 0;
				int c = 0;
				int d = 0;
				int f = 0;
				int g = 0;
				int h = 0;
				int i = 0;
				int j = 0;
				int k = 0;

				DisplayPanel = new JPanel();
				DisplayPanel.setLayout(new GridLayout(7,2)); 

				Cotton = new JTextField(5);
				Silk = new JTextField(5);
				Wool = new JTextField(5);
				Dying = new JTextField(5);
				Preprocessing = new JTextField(5);
				Finishing = new JTextField(5);
				Dye = new JTextField(5);

				DisplayPanel.add(new JLabel("Cotton : "));
				DisplayPanel.add(Cotton);
		
				DisplayPanel.add(new JLabel("Silk : "));
				DisplayPanel.add(Silk);
		
				DisplayPanel.add(new JLabel("Wool : "));
				DisplayPanel.add(Wool);

				DisplayPanel.add(new JLabel("Dying : "));
				DisplayPanel.add(Dying);
	
				DisplayPanel.add(new JLabel("Preprocessing : "));
				DisplayPanel.add(Preprocessing);
	
				DisplayPanel.add(new JLabel("Finishing : "));
				DisplayPanel.add(Finishing);

				DisplayPanel.add(new JLabel("Dye : "));
				DisplayPanel.add(Dye);

				add(DisplayPanel);

				try
				{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
					
					Statement stmt1 = con.createStatement();
					ResultSet rs1 = stmt1.executeQuery("SELECT QUANTITY FROM OUTPUTCLOTH WHERE CLOTHTYPE='COTTON'");

					while(rs1.next())
					{
						a = a + rs1.getInt("QUANTITY");
					}

					Statement stmt2 = con.createStatement();
					ResultSet rs2 = stmt2.executeQuery("SELECT QUANTITY FROM OUTPUTCLOTH WHERE CLOTHTYPE='SILK'");

					while(rs2.next())
					{
						b = b + rs2.getInt("QUANTITY");
					}
					
					Statement stmt3 = con.createStatement();
					ResultSet rs3 = stmt3.executeQuery("SELECT QUANTITY FROM OUTPUTCLOTH WHERE CLOTHTYPE='WOOL'");

					while(rs3.next())
					{
						c = c + rs3.getInt("QUANTITY");
					}

					Statement stmt4 = con.createStatement();
					ResultSet rs4 = stmt4.executeQuery("SELECT QUANTITY FROM INPUTRAW WHERE RAWCATEGORY='PREPROCESSING'");

					while(rs4.next())
					{
						d = d + rs4.getInt("QUANTITY");
					}

					Statement stmt5 = con.createStatement();
					ResultSet rs5 = stmt5.executeQuery("SELECT QUANTITY FROM INPUTRAW WHERE RAWCATEGORY='DYING'");

					while(rs5.next())
					{
						f = f + rs5.getInt("QUANTITY");
					}

					Statement stmt6 = con.createStatement();
					ResultSet rs6 = stmt6.executeQuery("SELECT QUANTITY FROM INPUTRAW WHERE RAWCATEGORY='FINISHING'");

					while(rs6.next())
					{
						g = g + rs6.getInt("QUANTITY");
					}

					Statement stmt7 = con.createStatement();
					ResultSet rs7 = stmt7.executeQuery("SELECT QUANTITY FROM INPUTRAW WHERE RAWCATEGORY='DYE'");

					while(rs7.next())
					{
						h = h + rs7.getInt("QUANTITY");
					}

					Statement stmt8 = con.createStatement();
					ResultSet rs8 = stmt8.executeQuery("SELECT QUANTITY FROM INPUTRAW WHERE RAWCATEGORY='COTTON'");
					
					while(rs8.next())
					{
						i = i + rs8.getInt("QUANTITY");
					}

					Statement stmt9 = con.createStatement();
					ResultSet rs9 = stmt9.executeQuery("SELECT QUANTITY FROM INPUTRAW WHERE RAWCATEGORY='SILK'");
					
					while(rs9.next())
					{
						j = j + rs9.getInt("QUANTITY");
					}

					Statement stmt10 = con.createStatement();
					ResultSet rs10 = stmt10.executeQuery("SELECT QUANTITY FROM INPUTRAW WHERE RAWCATEGORY='WOOL'");
					
					while(rs10.next())
					{
						k = k + rs10.getInt("QUANTITY");
					}

					Cotton.setText((i-(40*a))+"");
					Silk.setText((j-(15*b))+"");
					Wool.setText((k-(20*c))+"");
					Dying.setText((f-((a*1)+(b*3)+(c*1.5)))+"");
					Finishing.setText((g-((a*3)+(b*4)+(c*1)))+"");
					Preprocessing.setText((d-((a*5)+(b*2)+(c*3)))+"");
					Dye.setText((h-((a*1)+(b*2)+(c*3)))+"");

					con.close();
				}catch(Exception e)
				{
					JOptionPane.showMessageDialog(null,"ERROR IN ENTERING RAW MATERIALS");
				}
			} 
		});

		Cloth.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				JPanel DisplayPanel;
				JTextField Cotton,Silk,Wool;

				int a = 0;
				int b = 0;
				int c = 0;
				int d = 0;
				int f = 0;
				int g = 0;

				DisplayPanel = new JPanel();
				DisplayPanel.setLayout(new GridLayout(3,2));

				Cotton = new JTextField(5);
				Silk = new JTextField(5);
				Wool = new JTextField(5);

				DisplayPanel.add(new JLabel("Cotton : "));
				DisplayPanel.add(Cotton);

				DisplayPanel.add(new JLabel("Silk : "));
				DisplayPanel.add(Silk);
		
				DisplayPanel.add(new JLabel("Wool : "));
				DisplayPanel.add(Wool);

				add(DisplayPanel);

				try
				{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");

					Statement stmt1 = con.createStatement();
					ResultSet rs1 = stmt1.executeQuery("SELECT QUANTITY FROM OUTPUTCLOTH WHERE CLOTHTYPE='COTTON'");

					while(rs1.next())
					{
						a = a + rs1.getInt("QUANTITY");
					}

					Statement stmt2 = con.createStatement();
					ResultSet rs2 = stmt2.executeQuery("SELECT QUANTITY FROM OUTPUTCLOTH WHERE CLOTHTYPE='SILK'");

					while(rs2.next())
					{
						b = b + rs2.getInt("QUANTITY");
					}
					
					Statement stmt3 = con.createStatement();
					ResultSet rs3 = stmt3.executeQuery("SELECT QUANTITY FROM OUTPUTCLOTH WHERE CLOTHTYPE='WOOL'");

					while(rs3.next())
					{
						c = c + rs3.getInt("QUANTITY");
					}

					Statement stmt4 = con.createStatement();
					ResultSet rs4 = stmt4.executeQuery("SELECT QUANTITY FROM ORDERS WHERE CLOTHTYPE='COTTON'");

					while(rs4.next())
					{
						d = d + rs4.getInt("QUANTITY");
					}

					Statement stmt5 = con.createStatement();
					ResultSet rs5 = stmt5.executeQuery("SELECT QUANTITY FROM ORDERS WHERE CLOTHTYPE='SILK'");

					while(rs5.next())
					{
						f = f + rs5.getInt("QUANTITY");
					}
					
					Statement stmt6 = con.createStatement();
					ResultSet rs6 = stmt6.executeQuery("SELECT QUANTITY FROM ORDERS WHERE CLOTHTYPE='WOOL'");

					while(rs6.next())
					{
						g = g + rs6.getInt("QUANTITY");
					}

					Cotton.setText((a-d)+"");
					Silk.setText((b-f)+"");
					Wool.setText((c-g)+"");
					
					con.close();
				}catch(Exception e)
				{
					JOptionPane.showMessageDialog(null,"ERROR IN ENTERING RAW MATERIALS");
				}
			} 
		});
	}
}