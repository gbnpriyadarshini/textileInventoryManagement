import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame 
{

	JButton Login;
	JPanel Panel,TextPanel,ButtonPanel;
	JTextField UserName;
	JPasswordField Password;
	JLabel UserNameLabel;
	JLabel PasswordLabel;

	Login()
	{
		super("Login Autentification");
		setSize(300,200);

		Panel = new JPanel();
		TextPanel = new JPanel();
		ButtonPanel = new JPanel();

		UserName = new JTextField(20);
		Password = new JPasswordField(20);
		Login = new JButton("LOGIN");

		UserNameLabel = new JLabel("User Name : ");
		PasswordLabel = new JLabel("Password : ");
		
		TextPanel.setLayout(new GridLayout(2,2));

		TextPanel.add(UserNameLabel);
		TextPanel.add(UserName);
		TextPanel.add(PasswordLabel);
		TextPanel.add(Password);

		ButtonPanel.setLayout(new GridLayout(1,1));
		ButtonPanel.add(Login);

		Panel.setLayout(new GridLayout(2,1));

		Panel.add(TextPanel);
		Panel.add(ButtonPanel);

		add(Panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		Login.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent ae) 
			{
				String UserVerification = UserName.getText();
				String PasswordVerification = Password.getText();
				if(UserVerification.equals("manager") && PasswordVerification.equals("textile")) 
				{
					ApplicationInterface Project = new ApplicationInterface();
					Project.setVisible(true);
				} 
				else 
				{

					JOptionPane.showMessageDialog(null,"Wrong Username/Password");
					UserName.setText("");
					Password.setText("");
					UserName.requestFocus();
				}

			}
		});
	}


	public static void main(String args[]) 
	{
		new Login();
	}
}