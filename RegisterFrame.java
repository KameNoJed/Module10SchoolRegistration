import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Console;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;

public class RegisterFrame implements ActionListener {

	private static JTextField TKids;
	private static JButton Submit;
	private static JLabel Kids;
	private static JTextField TAddress;
	private static JLabel Address;
	private static JTextField TContact;
	private static JLabel Contact;
	private static JTextField PtSurname;
	private static JLabel PSurname;
	private static JTextField PtName;
	private static JLabel PName;
	private static JTextField StDOB;
	private static JLabel SDOB;
	private static JTextField StGrade;
	private static JLabel SGrade;
	private static JTextField StGender;
	private static JLabel SGender;
	private static JTextField StSurname;
	private static JLabel SSurname;
	private static JTextField StName;
	private static JLabel SName;
	private static JButton Admin;
	private static JButton Search;
	private static JButton Delete;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Window();
		Database();

	}
	
	public static void SearchDatabase() {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

			String path = "StudentData.mdb";

			String ur = "jdbc:ucanaccess://" + path;

			Connection con = DriverManager.getConnection(ur);

				Statement st = con.createStatement();
		   String Content = JOptionPane.showInputDialog("Enter Student name to search :");
		   String q="SELECT * FROM sDetails WHERE Name LIKE'%"+Content+"%'";
		   ResultSet rs= st.executeQuery(q);
	
		   if(rs.next())
			{
				do{

					System.out.println(
							rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getInt(4)
									+ "\t" + rs.getString(5) + "\t" + rs.getString(6) + "\t          " + rs.getString(7)
									+ "\t        " + rs.getString(8) + "\t" + rs.getString(9) + "\t" + rs.getInt(10));

				}while(rs.next());
			}
		else
		{
			System.out.println("Record Not Found...");
		}
		con.close();
		   }catch(Exception e){
				System.out.println(e);
			}
		
	}
	
	public static void DeleteRecord() {
		
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

			String path = "StudentData.mdb";

			String ur = "jdbc:ucanaccess://" + path;

			Connection con = DriverManager.getConnection(ur);

				Statement st = con.createStatement();
		   String Deleted = JOptionPane.showInputDialog("Enter Contact number of record to be deleted :");
		   String q="SELECT * FROM sDetails WHERE ParentContact ='"+Deleted+"'";
		   ResultSet rs= st.executeQuery(q);
		   String answer = JOptionPane.showInputDialog("Are you sure you want to Delete this record YES/NO");
		   if (answer.equalsIgnoreCase("Yes")) {
			   q="DELETE FROM sDetails WHERE ParentContact='"+Deleted+"'";
				//to execute query
				st.executeUpdate(q);
				System.out.println("Record Deleted...");
				try {

					 st = con.createStatement();

					 rs = st.executeQuery("SELECT * FROM sDetails");
					System.out.println("Name" + "\t" + "Surname" + "\t" + "Gender" + "\t" + "Grade" + "\t" + "DOB        "
							+ "\t" + "ParentName" + "\t" + "ParentSurname" + "\t" + "Contact " + "\t" + "Address"
							+ "\t       " + "NoKids");
					while (rs.next()) {

						System.out.println(
								rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getInt(4)
										+ "\t" + rs.getString(5) + "\t" + rs.getString(6) + "\t          " + rs.getString(7)
										+ "\t        " + rs.getString(8) + "\t" + rs.getString(9) + "\t" + rs.getInt(10));

					}
				} catch (Exception ex) {
					System.out.println("error occured " + ex);
				}
			
		}
		else
		{
			System.out.println("Record Not Found...");
		}
		con.close();
		   }catch(Exception e){
				System.out.println(e);
			}
	}

	public static void Window() {
		JFrame frame = new JFrame("Register page");
		frame.setSize(700, 500);

		JPanel panel = new JPanel();

		frame.add(panel);
		panel.setLayout(null);

		SName = new JLabel("Name:");
		SName.setBounds(10, 20, 80, 25);
		panel.add(SName);

		StName = new JTextField(20);
		StName.setBounds(100, 20, 165, 25);
		panel.add(StName);

		SSurname = new JLabel("Surname:");
		SSurname.setBounds(300, 20, 80, 25);
		panel.add(SSurname);

		StSurname = new JTextField(20);
		StSurname.setBounds(400, 20, 165, 25);
		panel.add(StSurname);

		SGender = new JLabel("Gender");
		SGender.setBounds(10, 60, 80, 25);
		panel.add(SGender);

		StGender = new JTextField(20);
		StGender.setBounds(100, 60, 165, 25);
		panel.add(StGender);

		SGrade = new JLabel("Grade");
		SGrade.setBounds(300, 60, 80, 25);
		panel.add(SGrade);

		StGrade = new JTextField(20);
		StGrade.setBounds(400, 60, 165, 25);
		panel.add(StGrade);

		SDOB = new JLabel("DOB");
		SDOB.setBounds(10, 100, 80, 25);
		panel.add(SDOB);

		StDOB = new JTextField(20);
		StDOB.setBounds(100, 100, 165, 25);
		panel.add(StDOB);

		PName = new JLabel("Parent Name");
		PName.setBounds(300, 100, 80, 25);
		panel.add(PName);

		PtName = new JTextField(20);
		PtName.setBounds(400, 100, 165, 25);
		panel.add(PtName);

		PSurname = new JLabel("Parent Surname");
		PSurname.setBounds(10, 140, 80, 25);
		panel.add(PSurname);

		PtSurname = new JTextField(20);
		PtSurname.setBounds(100, 140, 165, 25);
		panel.add(PtSurname);

		Contact = new JLabel("Contact");
		Contact.setBounds(300, 140, 80, 25);
		panel.add(Contact);

		TContact = new JTextField(20);
		TContact.setBounds(400, 140, 165, 25);
		panel.add(TContact);

		Address = new JLabel("Address");
		Address.setBounds(10, 180, 80, 25);
		panel.add(Address);

		TAddress = new JTextField(20);
		TAddress.setBounds(100, 180, 165, 25);
		panel.add(TAddress);

		Kids = new JLabel("Kids");
		Kids.setBounds(300, 180, 80, 25);
		panel.add(Kids);

		TKids = new JTextField(20);
		TKids.setBounds(400, 180, 165, 25);
		panel.add(TKids);

		Submit = new JButton("Submit");
		Submit.setBounds(250, 240, 80, 25);
		Submit.addActionListener(new RegisterFrame());
		panel.add(Submit);
		
		Search = new JButton("Search");
		Search.setBounds(200,330,80,25);
//		Search.setVisible(false);
		Search.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						SearchDatabase();
					}
				});
		Delete = new JButton("Delete");
		Delete.setBounds(300,330,80,25);
//		Delete.setVisible(false);
		Delete.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
					DeleteRecord();	
					}
				});

		Admin = new JButton("Admin");
		Admin.setBounds(250, 280, 80, 25);
		Admin.addActionListener(
				new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						String Admin = "password";
						String password = JOptionPane.showInputDialog("Enter password");
						while (!password.equals(Admin)) {
						 password = JOptionPane.showInputDialog("Enter password");
						}if(password.equals(Admin)) {
							Search.setVisible(true);
							Delete.setVisible(true);
							panel.add(Search);
							panel.add(Delete);
							
						}
						
					}
					
				}
				);
		panel.add(Admin);

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void Database() {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

			String path = "StudentData.mdb";

			String ur = "jdbc:ucanaccess://" + path;

			Connection con = DriverManager.getConnection(ur);

			try {

				Statement st = con.createStatement();

				ResultSet rs = st.executeQuery("SELECT * FROM sDetails");
				System.out.println("Name" + "\t" + "Surname" + "\t" + "Gender" + "\t" + "Grade" + "\t" + "DOB        "
						+ "\t" + "ParentName" + "\t" + "ParentSurname" + "\t" + "Contact " + "\t" + "Address"
						+ "\t       " + "NoKids");
				while (rs.next()) {

					System.out.println(
							rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getInt(4)
									+ "\t" + rs.getString(5) + "\t" + rs.getString(6) + "\t          " + rs.getString(7)
									+ "\t        " + rs.getString(8) + "\t" + rs.getString(9) + "\t" + rs.getInt(10));

				}
			} catch (Exception ex) {
				System.out.println("error occured " + ex);
			}
		} catch (Exception x) {
			System.out.println("error occured" + x);
		}

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String sName = StName.getText();
		String sSurname = StSurname.getText();
		String sGender = StGender.getText();
		String sDOB = StDOB.getText();
		Integer sGrade = Integer.parseInt(StGrade.getText());
		String pName = PtName.getText();
		String pSurname = PtSurname.getText();
		String pNumber = TContact.getText();
		String Address = TAddress.getText();
		Integer children = Integer.parseInt(TKids.getText());
		
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

			String path = "StudentData.mdb";

			String ur = "jdbc:ucanaccess://" + path;

			Connection con = DriverManager.getConnection(ur);

			String query = "INSERT INTO sDetails VALUES ('"+sName+"', '"+sSurname+"', '"+sGender+"', '"+sGrade+"', '"+sDOB+"', '"+pName+"','"+pSurname+"', '"+ pNumber+"','"+Address+"', '"+children+"')";
			Statement Stmt = con.createStatement();
			int rs = Stmt.executeUpdate(query);
			Statement st = con.createStatement();
		  
			System.out.println("Record inserted successfully.");
			ResultSet r = st.executeQuery("SELECT * FROM sDetails");
			System.out.println("Name" + "\t" + "Surname" + "\t" + "Gender" + "\t" + "Grade" + "\t" + "DOB        "
					+ "\t" + "ParentName" + "\t" + "ParentSurname" + "\t" + "Contact " + "\t" + "Address"
					+ "\t       " + "NoKids");
			while (r.next()) {

				System.out.println(
						r.getString(1) + "\t" + r.getString(2) + "\t" + r.getString(3) + "\t" + r.getInt(4)
								+ "\t" + r.getString(5) + "\t" + r.getString(6) + "\t          " + r.getString(7)
								+ "\t        " + r.getString(8) + "\t" + r.getString(9) + "\t" + r.getInt(10));
			
			}
			con.close();
		} catch (Exception ex) {
			System.out.println("error occured " + ex);
		}
				
	}
	
	
	
}
