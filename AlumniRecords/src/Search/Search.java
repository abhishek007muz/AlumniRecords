package Search;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Login.Login;
//import net.proteanit.sql.DbUtils;
import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import Add.Add;
import Dashboard.Dashboard;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Search extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Search frame = new Search();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void DataTable()
	{
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ABHISHEK","MUZ007muz@");
			String search="select * from adding";
			java.sql.Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(search);
			table.setModel(DbUtils.resultSetToTableModel(rs));	
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	/**
	 * Create the frame.
	 */
	public Search() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, -14, 250, 537);
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/Alumni1.jpg")));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("SEARCH ALUMNI RECORDS ...");
		lblNewLabel_1.setBounds(260, 11, 559, 52);
		lblNewLabel_1.setForeground(new Color(0, 0, 153));
		lblNewLabel_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 36));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblEnterTheName = new JLabel("ENTER THE USN TO SEARCH :");
		lblEnterTheName.setBounds(405, 164, 243, 68);
		lblEnterTheName.setForeground(new Color(0, 0, 153));
		lblEnterTheName.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		contentPane.add(lblEnterTheName);
		
		textField = new JTextField();
		textField.setBounds(405, 230, 243, 30);
		textField.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		textField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 153)));
		textField.setBackground(new Color(153, 204, 153));
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Search.this.dispose();
				Dashboard d = new Dashboard();
				d.setVisible(true);
			}
		});
		btnBack.setBounds(542, 281, 106, 37);
		btnBack.setOpaque(false);
		btnBack.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		btnBack.setForeground(new Color(0, 0, 153));
		contentPane.add(btnBack);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 10));
		scrollPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		scrollPane.setBounds(260, 393, 664, 107);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ABHISHEK","MUZ007muz@");
					String query="Select * from adding where usn=?";
					PreparedStatement pst=con.prepareStatement(query);
					pst.setString(1, textField.getText());
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					pst.close();
					
				}
				catch(Exception e1)
				{
					System.out.println(e1);
				}
			}
		});
		btnSearch.setOpaque(false);
		btnSearch.setForeground(new Color(0, 0, 153));
		btnSearch.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		btnSearch.setBounds(405, 281, 106, 37);
		contentPane.add(btnSearch);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Login.class.getResource("/Alumni8.png")));
		label.setBounds(761, 11, 163, 489);
		contentPane.add(label);
		//DataTable();
	}
}
