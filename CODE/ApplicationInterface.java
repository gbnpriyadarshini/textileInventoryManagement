import java.awt.*;
import javax.swing.*;
  
class ApplicationInterface extends JFrame
{

	JTabbedPane tabbedPane;

	public ApplicationInterface()
	{
		super("Textile Industry");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(750,750);
		setVisible(true);

		JPanel topPanel = new JPanel();
		topPanel.setLayout(new BorderLayout());
		getContentPane().add(topPanel);

		tabbedPane = new JTabbedPane();
		tabbedPane.addTab("Raw Materials",new RawMaterials());
		tabbedPane.addTab("Cloth",new Cloth());
		tabbedPane.addTab("Order",new Orders());
		tabbedPane.addTab("Stock",new Stock());
		tabbedPane.addTab("Customer",new Customers());
		tabbedPane.addTab("Vendor",new Vendors());
		tabbedPane.addTab("Standards",new Standards());
		tabbedPane.addTab("Help",new Help());

		topPanel.add(tabbedPane,BorderLayout.CENTER);
	}
	
	public static void main(String args[])
	{
		new ApplicationInterface();
	}
}
