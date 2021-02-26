package Add;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Login.Login;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import Dashboard.Dashboard;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Add extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add frame = new Add();
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
	public Add() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/Alumni1.jpg")));
		lblNewLabel.setBounds(0, -12, 250, 544);
		contentPane.add(lblNewLabel);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().trim().isEmpty()||textField_1.getText().trim().isEmpty()||textField_2.getText().trim().isEmpty()||textField_3.getText().trim().isEmpty()||textField_4.getText().trim().isEmpty()||textField_5.getText().trim().isEmpty()||textField_6.getText().trim().isEmpty()||textField_7.getText().trim().isEmpty()||textField_8.getText().trim().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"INVALID ...");
				}
				else
				{
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ABHISHEK","MUZ007muz@");
					String insert="insert into adding values(?,?,?,?,?,?,?,?,?)";
					PreparedStatement stmt=con.prepareStatement(insert);
					stmt.setString(1, textField.getText());
					stmt.setString(2, textField_1.getText());
					stmt.setString(3, textField_2.getText());
					stmt.setString(4, textField_3.getText());
					stmt.setString(5, textField_8.getText());
					stmt.setString(6, textField_4.getText());
					stmt.setString(7, textField_5.getText());
					stmt.setString(8, textField_6.getText());
					stmt.setString(9, textField_7.getText());
				
					int data=stmt.executeUpdate();
					
					if(data>0)
					{
						JOptionPane.showMessageDialog(null,"SUBMIT SUCCESSFULLY ...");
						Add.this.dispose();
						Dashboard a = new Dashboard();
						a.setVisible(true);
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
		btnSubmit.setForeground(new Color(0, 0, 153));
		btnSubmit.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		btnSubmit.setOpaque(false);
		btnSubmit.setBounds(324, 429, 111, 35);
		contentPane.add(btnSubmit);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Add.this.dispose();
				Dashboard d = new Dashboard();
				d.setVisible(true);
			}
		});
		btnBack.setForeground(new Color(0, 0, 153));
		btnBack.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		btnBack.setOpaque(false);
		btnBack.setBounds(540, 429, 111, 35);
		contentPane.add(btnBack);
		
		JLabel lblFirstName = new JLabel("FIRST NAME        :");
		lblFirstName.setForeground(new Color(0, 0, 153));
		lblFirstName.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblFirstName.setBounds(324, 142, 142, 30);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("LAST NAME          :");
		lblLastName.setForeground(new Color(0, 0, 153));
		lblLastName.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblLastName.setBounds(324, 176, 142, 30);
		contentPane.add(lblLastName);
		
		JLabel lblDepartment = new JLabel("DEPARTMENT      :");
		lblDepartment.setForeground(new Color(0, 0, 153));
		lblDepartment.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblDepartment.setBounds(324, 308, 142, 30);
		contentPane.add(lblDepartment);
		
		JLabel lblDateOfBirth = new JLabel("DATE OF BIRTH   :");
		lblDateOfBirth.setForeground(new Color(0, 0, 153));
		lblDateOfBirth.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblDateOfBirth.setBounds(324, 209, 142, 30);
		contentPane.add(lblDateOfBirth);
		
		JLabel lblFathersName = new JLabel("FATHER'S NAME :");
		lblFathersName.setForeground(new Color(0, 0, 153));
		lblFathersName.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblFathersName.setBounds(324, 274, 142, 30);
		contentPane.add(lblFathersName);
		
		JLabel lblUsn = new JLabel("USN                       :");
		lblUsn.setForeground(new Color(0, 0, 153));
		lblUsn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblUsn.setBounds(324, 108, 142, 30);
		contentPane.add(lblUsn);
		
		JLabel lblSection = new JLabel("EMAIL ID               :");
		lblSection.setForeground(new Color(0, 0, 153));
		lblSection.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblSection.setBounds(324, 339, 142, 37);
		contentPane.add(lblSection);
		
		JLabel lblAddAlumniRecords = new JLabel("ADD ALUMNI RECORDS ...");
		lblAddAlumniRecords.setForeground(new Color(0, 0, 153));
		lblAddAlumniRecords.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 36));
		lblAddAlumniRecords.setBounds(260, 11, 518, 35);
		contentPane.add(lblAddAlumniRecords);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char input=e.getKeyChar();
				if(Character.isLetter(input)||Character.isDigit(input)||Character.isISOControl(input))
				{
					textField.setEditable(true);
				}
				else
				{
					textField.setEditable(false);
				}
			}
		});
		textField.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		textField.setBackground(new Color(153, 204, 153));
		textField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 153)));
		textField.setBounds(464, 98, 187, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char input=e.getKeyChar();
				if(Character.isLetter(input)||Character.isISOControl(input))
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
		textField_1.setBounds(464, 132, 187, 30);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char input=e.getKeyChar();
				if(Character.isLetter(input)||Character.isISOControl(input))
				{
					textField_2.setEditable(true);
				}
				else
				{
					textField_2.setEditable(false);
				}
			}
		});
		textField_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		textField_2.setBackground(new Color(153, 204, 153));
		textField_2.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 153)));
		textField_2.setBounds(464, 166, 187, 30);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		textField_3.setBackground(new Color(153, 204, 153));
		textField_3.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 153)));
		textField_3.setBounds(464, 199, 187, 30);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char input=e.getKeyChar();
				if(Character.isLetter(input)||Character.isSpace(input)||Character.isISOControl(input))
				{
					textField_4.setEditable(true);
				}
				else
				{
					textField_4.setEditable(false);
				}
			}
		});
		textField_4.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		textField_4.setBackground(new Color(153, 204, 153));
		textField_4.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 153)));
		textField_4.setBounds(464, 264, 187, 30);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char input=e.getKeyChar();
				if(Character.isLetter(input)||Character.isSpace(input)||Character.isISOControl(input))
				{
					textField_5.setEditable(true);
				}
				else
				{
					textField_5.setEditable(false);
				}
			}
		});
		textField_5.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		textField_5.setBackground(new Color(153, 204, 153));
		textField_5.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 153)));
		textField_5.setBounds(464, 298, 187, 30);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		textField_6.setBackground(new Color(153, 204, 153));
		textField_6.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 153)));
		textField_6.setBounds(464, 333, 187, 30);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblMobile = new JLabel("MOBILE                 :");
		lblMobile.setForeground(new Color(0, 0, 153));
		lblMobile.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblMobile.setBounds(324, 374, 142, 27);
		contentPane.add(lblMobile);
		
		textField_7 = new JTextField();
		textField_7.addKeyListener(new KeyAdapter() {
			@Override
			//validation
			public void keyTyped(KeyEvent e) {
				char input=e.getKeyChar();
				if(Character.isDigit(input)||Character.isISOControl(input))
				{
					textField_7.setEditable(true);
				}
				else
				{
					textField_7.setEditable(false);
				}
			}
			//validation
		});
		textField_7.setForeground(new Color(0, 0, 0));
		textField_7.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		textField_7.setColumns(10);
		textField_7.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 153)));
		textField_7.setBackground(new Color(153, 204, 153));
		textField_7.setBounds(464, 366, 187, 30);
		contentPane.add(textField_7);
		
		JLabel lblGender = new JLabel("GENDER                :");
		lblGender.setForeground(new Color(0, 0, 153));
		lblGender.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblGender.setBounds(324, 243, 142, 30);
		contentPane.add(lblGender);
		
		textField_8 = new JTextField();
		textField_8.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char input=e.getKeyChar();
				if(Character.isLetter(input)||Character.isISOControl(input))
				{
					textField_8.setEditable(true);
				}
				else
				{
					textField_8.setEditable(false);
				}
			}
		});
		textField_8.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		textField_8.setColumns(10);
		textField_8.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 153)));
		textField_8.setBackground(new Color(153, 204, 153));
		textField_8.setBounds(464, 233, 187, 30);
		contentPane.add(textField_8);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Login.class.getResource("/Alumni8.png")));
		label.setBounds(692, 11, 163, 489);
		contentPane.add(label);
	}
}
