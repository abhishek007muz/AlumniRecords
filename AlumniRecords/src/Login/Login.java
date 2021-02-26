package Login;

import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Menu;
import java.awt.Window;
import javax.swing.JTextField;
import Create.Create;
import Dashboard.Dashboard;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JMenuBar;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
//import java.beans.Statement;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.border.MatteBorder;
import java.sql.Connection;

import javax.swing.border.LineBorder;

public class Login {

	private JFrame frame;
	private JTextField lblusername;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login l = new Login();
					l.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(153, 204, 153));
		frame.setBounds(100, 100, 900, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("USERNAME :");
		lblUsername.setForeground(new Color(0, 0, 153));
		lblUsername.setBounds(388, 201, 106, 34);
		lblUsername.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("PASSWORD :");
		lblPassword.setForeground(new Color(0, 0, 153));
		lblPassword.setBounds(388, 284, 106, 34);
		lblPassword.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		frame.getContentPane().add(lblPassword);
		
		lblusername = new JTextField();
		lblusername.setForeground(new Color(0, 0, 0));
		lblusername.setBackground(new Color(153, 204, 153));
		lblusername.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblusername.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 153)));
		lblusername.setBounds(388, 228, 222, 34);
		frame.getContentPane().add(lblusername);
		lblusername.setColumns(10);
		
		JButton btnSubmit = new JButton("LOGIN");
		btnSubmit.setForeground(new Color(0, 0, 153));
		btnSubmit.setOpaque(false);
		btnSubmit.setBounds(388, 374, 91, 34);
		btnSubmit.addActionListener(new ActionListener() {
			private JLabel txtPassword;
			private JLabel txtUsername;
			public void actionPerformed(ActionEvent e) {
				/*String password = passwordField.getText();
				String username = lblusername.getText();
				if(password.equals("abhi") && username.equals("abhi")) {
					JOptionPane.showMessageDialog(frame, "Login Successfully..");
					frame.dispose();
					Dashboard m = new Dashboard();
					m.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(frame, "Invalid Login Details..");
				}
			}*/
				try
				{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ABHISHEK","MUZ007muz@");
					Statement st=con.createStatement();
				    
					String sql="select * from Reg where username='"+lblusername.getText()+"'and password='"+passwordField.getText().toString()+"'";
					
					ResultSet rs=st.executeQuery(sql);
					if(rs.next())
					{
						JOptionPane.showMessageDialog(frame,"LOGIN SUCCESSFULLY ...");
						frame.dispose();
						Dashboard d=new Dashboard();
						d.setVisible(true);
						
					
					}
					else
					{
						JOptionPane.showMessageDialog(frame,"INVALID ...");
					}
				}
				catch(Exception x)
				{
					System.out.println(x);
				}
			}
		});
		btnSubmit.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		frame.getContentPane().add(btnSubmit);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(408, 54, 22, -12);
		frame.getContentPane().add(separator);
		
		JButton btnClose = new JButton("CLOSE");
		btnClose.setForeground(new Color(0, 0, 153));
		btnClose.setOpaque(false);
		btnClose.setBounds(519, 374, 91, 34);
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnClose.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		frame.getContentPane().add(btnClose);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(new Color(0, 0, 0));
		passwordField.setBackground(new Color(153, 204, 153));
		passwordField.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		passwordField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 153)));
		passwordField.setBounds(388, 312, 222, 34);
		frame.getContentPane().add(passwordField);
		
		JButton btnRegistration = new JButton("REGISTRATION");
		btnRegistration.setForeground(new Color(0, 0, 153));
		btnRegistration.setOpaque(false);
		btnRegistration.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		btnRegistration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Create c = new Create();
				c.setVisible(true);
			}
		});
		btnRegistration.setBounds(388, 419, 222, 34);
		frame.getContentPane().add(btnRegistration);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/Alumni1.jpg")));
		lblNewLabel.setBounds(158, 11, 308, 429);
		lblNewLabel.setBounds(0, -19, 250, 541);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/Alumni4.png")));
		lblNewLabel_1.setBounds(431, 29, 128, 174);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Login.class.getResource("/Alumni8.png")));
		lblNewLabel_2.setBounds(691, 11, 163, 489);
		frame.getContentPane().add(lblNewLabel_2);
	}

}
