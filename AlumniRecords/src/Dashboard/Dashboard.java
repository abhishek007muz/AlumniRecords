package Dashboard;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.io.FileOutputStream;
import java.awt.EventQueue;
import java.awt.Frame;
import java.sql.*; 
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itextpdf.text.Document;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import Add.Add;
import Create.Create;
import Download.jdbc_pdf_report;
import ListAll.ListAll;
import Login.Login;
import Search.Search;
import Update.Update;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Dashboard extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard();
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
	public Dashboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/Alumni1.jpg")));
		lblNewLabel.setBounds(0, -11, 250, 532);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.setForeground(new Color(0, 0, 153));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dashboard.this.dispose();
				Add a = new Add();
				a.setVisible(true);
			}
		});
		btnNewButton.setOpaque(false);
		btnNewButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		btnNewButton.setBounds(385, 107, 191, 35);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("SEARCH");
		btnNewButton_1.setForeground(new Color(0, 0, 153));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dashboard.this.dispose();
				Search a = new Search();
				a.setVisible(true);
			}
		});
		btnNewButton_1.setOpaque(false);
		btnNewButton_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		btnNewButton_1.setBounds(385, 176, 191, 35);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("LIST ALL");
		btnNewButton_2.setForeground(new Color(0, 0, 153));
		btnNewButton_2.setOpaque(false);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dashboard.this.dispose();
				ListAll la = new ListAll();
				la.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		btnNewButton_2.setBounds(385, 241, 191, 35);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("UPDATE");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dashboard.this.dispose();
				Update u = new Update();
				u.setVisible(true);
			}
		});
		btnNewButton_3.setForeground(new Color(0, 0, 153));
		btnNewButton_3.setOpaque(false);
		btnNewButton_3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		btnNewButton_3.setBounds(385, 307, 191, 35);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("DOWNLOAD");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//save
				try
				{
					 Class.forName("oracle.jdbc.driver.OracleDriver");
		    			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ABHISHEK","MUZ007muz@");
		                Statement stmt = conn.createStatement();
		                ResultSet query_set = stmt.executeQuery("SELECT USN,F_NAME,DEPARTMENT,EMAIL,MOBILE FROM ADDING");               
		                Document my_pdf_report = new Document();
		                PdfWriter.getInstance(my_pdf_report, new FileOutputStream("C:\\Users\\Abhishek Kumar\\Desktop\\DOWNLOAD ALUMNI\\ALUMNI RECORDS.pdf"));
		                my_pdf_report.open();            
		                PdfPTable my_report_table = new PdfPTable(5);
		                PdfPCell table_cell;
		             
		                while (query_set.next()) {                
		                    String alumni1 = query_set.getString("USN");
		                    table_cell=new PdfPCell(new Phrase(alumni1));
		                    my_report_table.addCell(table_cell);
		                    String alumni2=query_set.getString("F_NAME");
		                    table_cell=new PdfPCell(new Phrase(alumni2));
		                    my_report_table.addCell(table_cell);
		                    String alumni3=query_set.getString("DEPARTMENT");
		                    table_cell=new PdfPCell(new Phrase(alumni3));
		                    my_report_table.addCell(table_cell);
		                    String alumni4=query_set.getString("EMAIL");
		                    table_cell=new PdfPCell(new Phrase(alumni4));
		                    my_report_table.addCell(table_cell);
		                    String alumni5=query_set.getString("MOBILE");
		                    table_cell=new PdfPCell(new Phrase(alumni5));
		                    my_report_table.addCell(table_cell);
		                    }
		                
		                my_pdf_report.add(my_report_table);                       
		                my_pdf_report.close();
		                query_set.close();
		                stmt.close(); 
		                conn.close();               
		                JOptionPane.showMessageDialog(null, "DOWNLOAD SUCCESSFULLY ...");
		        }
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, "");
				}
				//save
			}
		});
		btnNewButton_4.setForeground(new Color(0, 0, 153));
		btnNewButton_4.setOpaque(false);
		btnNewButton_4.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		btnNewButton_4.setBounds(385, 367, 191, 35);
		contentPane.add(btnNewButton_4);
		
		JLabel lblDashboard = new JLabel("DASHBOARD ...");
		lblDashboard.setForeground(new Color(0, 0, 153));
		lblDashboard.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 40));
		lblDashboard.setBounds(260, 11, 414, 46);
		contentPane.add(lblDashboard);
		
		JButton btnBack = new JButton("LOGOUT");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dashboard.this.dispose();
				Login l=new Login();
				l.main(null);
			}
		});
		btnBack.setOpaque(false);
		btnBack.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		btnBack.setForeground(new Color(0, 0, 153));
		btnBack.setBounds(385, 425, 191, 35);
		contentPane.add(btnBack);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Login.class.getResource("/Alumni8.png")));
		label.setBounds(684, 11, 163, 489);
		contentPane.add(label);
	}
}
