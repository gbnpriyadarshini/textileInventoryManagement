import java.sql.*;
import oracle.jdbc.*;

class CreateTables
{
	public static void main(String args[])
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
			Statement stmt = con.createStatement();
			Boolean b0 = stmt.execute("CREATE TABLE INPUTRAW(RAWTYPE VARCHAR2(10),RAWCATEGORY VARCHAR2(15),QUANTITY NUMBER(5),COST NUMBER(5),BUYDATE DATE,VENDOR NUMBER(5))");
			Boolean b1 = stmt.execute("CREATE TABLE OUTPUTCLOTH(CLOTHTYPE VARCHAR2(7),COLOR VARCHAR2(15),QUANTITY NUMBER(5),SOLD VARCHAR2(3),CUSTOMER NUMBER(5),ORDERDATE DATE)");
			Boolean b2 = stmt.execute("CREATE TABLE VENDORDETAILS(VID NUMBER(5),VNAME VARCHAR2(15),VADDRESS VARCHAR2(50),VPHONE NUMBER(15),VEMAIL VARCHAR2(35))");
			Boolean b3 = stmt.execute("CREATE TABLE CUSTOMERDETAILS(CID NUMBER(5),CNAME VARCHAR2(15),CADDRESS VARCHAR2(50),CPHNE NUMBER(15),CEMAIL VARCHAR2(35))");
			Boolean b4 = stmt.execute("CREATE TABLE ORDERS(ORDERDATE DATE,CUSTOMER NUMBER(5),CLOTHTYPE VARCHAR2(7),QUANTITY NUMBER(5),COLOR VARCHAR2(15),LASTDATE DATE,AMOUNT NUMBER(7))");
			con.close();
		}catch(Exception e)
		{
			System.out.println("error in creating table");
		}
	}
}