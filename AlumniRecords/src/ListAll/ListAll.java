package ListAll;

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
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.sql.*;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.JSplitPane;
import javax.swing.border.MatteBorder;

import Dashboard.Dashboard;

public class ListAll extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListAll frame = new ListAll();
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
	public ListAll() {
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
		
		JLabel lblListAll = new JLabel("LIST ALL ALUMNI RECORDS ...");
		lblListAll.setBounds(260, 15, 498, 49);
		lblListAll.setForeground(new Color(0, 0, 153));
		lblListAll.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 32));
		contentPane.add(lblListAll);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 10));
		scrollPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        scrollPane.setBounds(260, 75, 664, 425);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton button = new JButton("BACK");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListAll.this.dispose();
				Dashboard d = new Dashboard();
				d.setVisible(true);
			}
		});
		button.setOpaque(false);
		button.setForeground(new Color(0, 0, 153));
		button.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		button.setBounds(818, 23, 106, 34);
		contentPane.add(button);
		DataTable();
	}
}
