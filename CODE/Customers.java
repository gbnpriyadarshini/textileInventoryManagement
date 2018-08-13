import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.io.*;


class Customers extends JPanel
{
	JTable CustomerTable;
	String[][] CustomerData;
	String ColumnHeaders[];
	int RowCount,ColumnCount;
	int RowCtr=0,ColCtr;
	
	ResultSet rs;
	ResultSetMetaData rsmd;

	JPanel DisplayPanel;
	JTextField Id,Name,Address,PhoneNo,Email;
	JButton Add,Reset;
	String t1,t2,t3,t4,t5;

	Customers()
	{
		designLayout();
		PrepareDB();
		ColumnHeaders = getColumnHeaders();
		CustomerData = getTableData();
		CustomerTable = new JTable(CustomerData,ColumnHeaders);
		add(new JScrollPane(CustomerTable));
		setSize(500,500);
		setVisible(true);
		
	}

	public void PrepareDB()
	{
		try
		{
			Connection con;
			Statement stmt;

			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery("select * from CUSTOMERDETAILS");
			rsmd = rs.getMetaData();
			RowCount = getRowCount();
			ColumnCount = rsmd.getColumnCount();
		}catch(Exception e)
		{
			System.out.println("error in prepareDB");
		}
	}

	public int getRowCount()
	{
		int RowCount = 0;
		try
		{
			rs.last();
			RowCount = rs.getRow();
			rs.beforeFirst();
			return RowCount;
		}catch(Exception e)
		{
			System.out.println("error in getRowCount");
			return 0;	
		}
	}

	public String[] getColumnHeaders()
	{
		String ColumnHeaders[] = new String[ColumnCount];
		try
		{
			for(ColCtr=1;ColCtr<=ColumnCount;ColCtr++)
			ColumnHeaders[ColCtr-1] = rsmd.getColumnName(ColCtr);
			return ColumnHeaders;
		}catch(Exception e)
		{
			System.out.println("error in getColumnHeaders");
			return null;
		}
	}

	public String[][] getTableData()
	{
		String TableData[][] = new String[RowCount][ColumnCount];
		try
		{
			while(rs.next())
			{
				for(ColCtr=1;ColCtr<=ColumnCount;ColCtr++)
				TableData[RowCtr][ColCtr-1] = rs.getString(ColCtr);
				RowCtr++;
			}
			return TableData;
		}catch(Exception e)
		{
			System.out.println("error in getTableData");
			return null;
		}
	}

	public void designLayout()
	{

		DisplayPanel = new JPanel();
		DisplayPanel.setLayout(new GridLayout(6,2));

		Id = new JTextField(20);
		Name = new JTextField(20);
		Address = new JTextField(50);
		PhoneNo = new JTextField(20);
		Email = new JTextField(20);

		Add = new JButton("ADD");
		Reset = new JButton("RESET");

		DisplayPanel.add(new JLabel("Id : "));
		DisplayPanel.add(Id);

		DisplayPanel.add(new JLabel("Name : "));
		DisplayPanel.add(Name);
		
		DisplayPanel.add(new JLabel("Address : "));
		DisplayPanel.add(Address);
		
		DisplayPanel.add(new JLabel("Phone Number : "));
		DisplayPanel.add(PhoneNo);

		DisplayPanel.add(new JLabel("E-mail : "));
		DisplayPanel.add(Email);

		DisplayPanel.add(Add);
		DisplayPanel.add(Reset);

		add(DisplayPanel);

		Add.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				if(Id.getText().trim().equals("")||Name.getText().trim().equals("")||Address.getText().trim().equals("")||PhoneNo.getText().trim().equals("")||Email.getText().trim().equals(""))
				{
					JOptionPane.showMessageDialog(null,"NOT ALL FIELDS ENTERED");
				}else
				{
					t1 = Id.getText();
					t2 = Name.getText();
					t3 = Address.getText();
					t4 = PhoneNo.getText();
					t5 = Email.getText();

					try
					{
						Class.forName("oracle.jdbc.driver.OracleDriver");
						Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
						Statement stmt=con.createStatement();
						int i = stmt.executeUpdate("INSERT INTO CUSTOMERDETAILS(CID,CNAME,CADDRESS,CPHONE,CEMAIL) VALUES('"+t1+"','"+t2+"','"+t3+"','"+t4+"','"+t5+"')");
						JOptionPane.showMessageDialog(null,"ENTERED A NEW CUSTOMER");
						con.close();
					}catch(Exception e)
					{
						JOptionPane.showMessageDialog(null,"ERROR IN ENTERING NEW CUSTOMER");
					}
				}
			}
		});

		Reset.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				Id.setText(" ");
				Name.setText(" ");
				Address.setText(" ");
				PhoneNo.setText(" ");
				Email.setText(" ");
			} 
		});
	}
}