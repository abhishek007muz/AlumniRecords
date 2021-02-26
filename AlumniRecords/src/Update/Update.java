package Update;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Login.Login;
import Search.Search;
import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Set;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.border.MatteBorder;

import Dashboard.Dashboard;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Update extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update frame = new Update();
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
	public Update() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, -13, 300, 547);
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/Alumni1.jpg")));
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("USN                       :");
		label.setForeground(new Color(0, 0, 153));
		label.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		label.setBounds(342, 95, 142, 30);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("FIRST NAME        :");
		label_1.setForeground(new Color(0, 0, 153));
		label_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		label_1.setBounds(342, 129, 142, 30);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("LAST NAME          :");
		label_2.setForeground(new Color(0, 0, 153));
		label_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		label_2.setBounds(342, 163, 142, 30);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("DATE OF BIRTH   :");
		label_3.setForeground(new Color(0, 0, 153));
		label_3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		label_3.setBounds(342, 196, 142, 30);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("GENDER                :");
		label_4.setForeground(new Color(0, 0, 153));
		label_4.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		label_4.setBounds(342, 230, 142, 30);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("FATHER'S NAME :");
		label_5.setForeground(new Color(0, 0, 153));
		label_5.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		label_5.setBounds(342, 261, 142, 30);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("DEPARTMENT      :");
		label_6.setForeground(new Color(0, 0, 153));
		label_6.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		label_6.setBounds(342, 295, 142, 30);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("EMAIL ID               :");
		label_7.setForeground(new Color(0, 0, 153));
		label_7.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		label_7.setBounds(342, 326, 142, 37);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("MOBILE                 :");
		label_8.setForeground(new Color(0, 0, 153));
		label_8.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		label_8.setBounds(342, 361, 142, 27);
		contentPane.add(label_8);
		
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
		textField_1.setColumns(10);
		textField_1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 153)));
		textField_1.setBackground(new Color(153, 204, 153));
		textField_1.setBounds(482, 119, 187, 30);
		contentPane.add(textField_1);
		
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
		textField_2.setColumns(10);
		textField_2.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 153)));
		textField_2.setBackground(new Color(153, 204, 153));
		textField_2.setBounds(482, 153, 187, 30);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		textField_3.setColumns(10);
		textField_3.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 153)));
		textField_3.setBackground(new Color(153, 204, 153));
		textField_3.setBounds(482, 186, 187, 30);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char input=e.getKeyChar();
				if(Character.isLetter(input)||Character.isISOControl(input))
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
		textField_4.setColumns(10);
		textField_4.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 153)));
		textField_4.setBackground(new Color(153, 204, 153));
		textField_4.setBounds(482, 220, 187, 30);
		contentPane.add(textField_4);
		
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
		textField_5.setColumns(10);
		textField_5.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 153)));
		textField_5.setBackground(new Color(153, 204, 153));
		textField_5.setBounds(482, 251, 187, 30);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char input=e.getKeyChar();
				if(Character.isLetter(input)||Character.isSpace(input)||Character.isISOControl(input))
				{
					textField_6.setEditable(true);
				}
				else
				{
					textField_6.setEditable(false);
				}
			}
		});
		textField_6.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		textField_6.setColumns(10);
		textField_6.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 153)));
		textField_6.setBackground(new Color(153, 204, 153));
		textField_6.setBounds(482, 285, 187, 30);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		textField_7.setColumns(10);
		textField_7.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 153)));
		textField_7.setBackground(new Color(153, 204, 153));
		textField_7.setBounds(482, 320, 187, 30);
		contentPane.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char input=e.getKeyChar();
				if(Character.isDigit(input)||Character.isISOControl(input))
				{
					textField_8.setEditable(true);
				}
				else
				{
					textField_8.setEditable(false);
				}
			}
		});
		textField_8.setForeground(Color.BLACK);
		textField_8.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		textField_8.setColumns(10);
		textField_8.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 153)));
		textField_8.setBackground(new Color(153, 204, 153));
		textField_8.setBounds(482, 353, 187, 30);
		contentPane.add(textField_8);
		
		JButton button = new JButton("SUBMIT");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().trim().isEmpty()||textField_1.getText().trim().isEmpty()||textField_2.getText().trim().isEmpty()||textField_3.getText().trim().isEmpty()||textField_4.getText().trim().isEmpty()||textField_5.getText().trim().isEmpty()||textField_6.getText().trim().isEmpty()||textField_7.getText().trim().isEmpty()||textField_8.getText().trim().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"INVALID ...");
				}
				else
				{
				try
				{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ABHISHEK","MUZ007muz@");
					String query1="UPDATE adding SET f_name='"+textField_1.getText()+"'where usn='"+textField.getText()+"'";
					PreparedStatement pst1=con.prepareStatement(query1);
					pst1.execute();
					String query2="UPDATE adding SET l_name='"+textField_2.getText()+"'where usn='"+textField.getText()+"'";
					PreparedStatement pst2=con.prepareStatement(query2);
					pst2.execute();
					String query3="UPDATE adding SET dob='"+textField_3.getText()+"'where usn='"+textField.getText()+"'";
					PreparedStatement pst3=con.prepareStatement(query3);
					pst3.execute();
					String query4="UPDATE adding SET gender='"+textField_4.getText()+"'where usn='"+textField.getText()+"'";
					PreparedStatement pst4=con.prepareStatement(query4);
					pst4.execute();
					String query5="UPDATE adding SET fathersname='"+textField_5.getText()+"'where usn='"+textField.getText()+"'";
					PreparedStatement pst5=con.prepareStatement(query5);
					pst5.execute();
					String query6="UPDATE adding SET department='"+textField_6.getText()+"'where usn='"+textField.getText()+"'";
					PreparedStatement pst6=con.prepareStatement(query6);
					pst6.execute();
					String query7="UPDATE adding SET email='"+textField_7.getText()+"'where usn='"+textField.getText()+"'";
					PreparedStatement pst7=con.prepareStatement(query7);
					pst7.execute();
					String query8="UPDATE adding SET mobile='"+textField_8.getText()+"'where usn='"+textField.getText()+"'";
					PreparedStatement pst8=con.prepareStatement(query8);
					pst8.execute();
					
					JOptionPane.showMessageDialog(null, "UPDATED SUCCESSFULLY ...");
					
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
				}
			}
		});
		button.setOpaque(false);
		button.setForeground(new Color(0, 0, 153));
		button.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		button.setBounds(342, 416, 111, 35);
		contentPane.add(button);
		
		JButton button_1 = new JButton("BACK");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Update.this.dispose();
				Dashboard d = new Dashboard();
				d.setVisible(true);
			}
		});
		button_1.setOpaque(false);
		button_1.setForeground(new Color(0, 0, 153));
		button_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		button_1.setBounds(558, 416, 111, 35);
		contentPane.add(button_1);
		
		JLabel lblUpdateAlumniRecords = new JLabel("UPDATE ALUMNI RECORDS ...");
		lblUpdateAlumniRecords.setForeground(new Color(0, 0, 153));
		lblUpdateAlumniRecords.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 35));
		lblUpdateAlumniRecords.setBounds(262, 11, 569, 35);
		contentPane.add(lblUpdateAlumniRecords);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try
				{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ABHISHEK","MUZ007muz@");
					String query="Select * from adding where usn=?";
					PreparedStatement pst=con.prepareStatement(query);
					pst.setString(1, textField.getText());
					ResultSet rs=pst.executeQuery();
					if(rs.next())
					{
						String setusn=rs.getString("usn");
						textField.setText(setusn);
						String setf_name=rs.getString("f_name");
						textField_1.setText(setf_name);
						String setl_name=rs.getString("l_name");
						textField_2.setText(setl_name);
						String setdob=rs.getString("dob");
						textField_3.setText(setdob);
						String setgender=rs.getString("gender");
						textField_4.setText(setgender);
						String setfathersname=rs.getString("fathersname");
						textField_5.setText(setfathersname);
						String setdept=rs.getString("department");
						textField_6.setText(setdept);
						String setemail=rs.getString("email");
						textField_7.setText(setemail);
						String setmobile=rs.getString("mobile");
						textField_8.setText(setmobile);
				
						
					}
					
				}
				catch(Exception e1)
				{
					System.out.println(e1);
				}
			}
		});
		textField.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		textField.setColumns(10);
		textField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 153)));
		textField.setBackground(new Color(153, 204, 153));
		textField.setBounds(482, 88, 187, 30);
		contentPane.add(textField);
		
		JLabel label_9 = new JLabel("");
		label_9.setIcon(new ImageIcon(Login.class.getResource("/Alumni8.png")));
		label_9.setBounds(725, 11, 163, 489);
		contentPane.add(label_9);
	}
}
