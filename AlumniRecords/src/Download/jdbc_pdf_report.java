package Download;

import java.io.FileOutputStream;
import java.awt.EventQueue;
import java.awt.Frame;
import java.sql.*; 
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import Update.Update;

public class jdbc_pdf_report extends Frame{
	public jdbc_pdf_report() {
	}  
        public static void main(String[] args) throws Exception{
                Class.forName("oracle.jdbc.driver.OracleDriver");
    			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ABHISHEK","MUZ007muz@");
                Statement stmt = conn.createStatement();
                ResultSet query_set = stmt.executeQuery("SELECT USN,F_NAME,DEPARTMENT,EMAIL,MOBILE FROM ADDING");               
                Document my_pdf_report = new Document();
                PdfWriter.getInstance(my_pdf_report, new FileOutputStream("D:\\ALUMNI RECORDS.pdf"));
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
                
        }
}