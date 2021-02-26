package Create;

import java.awt.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.SoftBevelBorder;

import Add.Add;
import Dashboard.Dashboard;
import Login.Login;
import java.sql.Connection;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Create extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JFrame frame;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				//try {
				//	Create c = new Create();
				//	c.frame.setVisible(true);
				//} catch (Exception e) {
				//	e.printStackTrace();
				//}
				try {
					Create frame = new Create();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Create() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 550);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 153));
		contentPane.setBackground(new Color(153, 204, 153));
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/Alumni1.jpg")));
		lblNewLabel.setBounds(0, -22, 250, 533);
		contentPane.add(lblNewLabel);
		
		JLabel lblUsername = new JLabel("USERNAME :");
		lblUsername.setBackground(new Color(153, 204, 153));
		lblUsername.setForeground(new Color(0, 0, 153));
		lblUsername.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblUsername.setBounds(379, 166, 273, 34);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("PASSWORD :");
		lblPassword.setBackground(new Color(153, 204, 153));
		lblPassword.setForeground(new Color(0, 0, 153));
		lblPassword.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblPassword.setBounds(379, 243, 273, 31);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char input=e.getKeyChar();
				if(Character.isLetter(input)||Character.isISOControl(input))
				{
					textField.setEditable(true);
				}
				else
				{
					textField.setEditable(false);
				}
			}
		});
		/*textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String PATTERN="^[a-z A-Z] {O,10}$";
				Pattern pat=Pattern.compile(PATTERN);
				Matcher mat=pat.matcher(textField.getText());
				if(!mat.matches())
				{
					lblPassword.setText("USERNAME SHOULD BE ALPHABET ...");
				}
				else
				{
					lblPassword.setText(null);
				}
			}
		});*/
		textField.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		textField.setBackground(new Color(153, 204, 153));
		textField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 153)));
		textField.setBounds(379, 196, 234, 34);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char input=e.getKeyChar();
				if(Character.isLetter(input)||Character.isDigit(input)||Character.isISOControl(input))
				{
					textField_1.setEditable(true);
				}
				else
				{
					textField_1.setEditable(false);
				}
			}
		});
		textField_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		textField_1.setBackground(new Color(153, 204, 153));
		textField_1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 153)));
		textField_1.setBounds(379, 264, 234, 34);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnSignUp = new JButton("SIGN UP");
		btnSignUp.setForeground(new Color(0, 0, 153));
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().trim().isEmpty()||textField_1.getText().trim().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"INVALID ...");
				}
				else
				{

				try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ABHISHEK","MUZ007muz@");
				String insert="insert into Reg values(?,?)";
				PreparedStatement stmt=con.prepareStatement(insert);
				stmt.setString(1, textField.getText());
				stmt.setString(2, textField_1.getText());
			
				int data=stmt.executeUpdate();
				
				if(data>0)
				{
					JOptionPane.showMessageDialog(null,"SIGN UP SUCCESSFULLY ...");
					Create.this.dispose();
					Login l = new Login();
				    Login.main(null);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"INVALID ...");
				}
			}
				
			catch(Exception x)
			{
				System.out.println(x);
			}
			}
			}
		});
		btnSignUp.setOpaque(false);
		btnSignUp.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		btnSignUp.setBounds(379, 334, 106, 34);
		contentPane.add(btnSignUp);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setForeground(new Color(0, 0, 153));
		btnBack.setOpaque(false);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Create.this.dispose();
				Login l=new Login();
				l.main(null);
			}
		});
		btnBack.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		btnBack.setBounds(507, 334, 106, 34);
		contentPane.add(btnBack);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Login.class.getResource("/Alumni8.png")));
		label.setBounds(684, 11, 163, 489);
		contentPane.add(label);
		
		JLabel lblNewLabel_2 = new JLabel("REGISTRATION ...");
		lblNewLabel_2.setForeground(new Color(0, 0, 153));
		lblNewLabel_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 40));
		lblNewLabel_2.setBounds(260, 11, 447, 63);
		contentPane.add(lblNewLabel_2);

	}
}
