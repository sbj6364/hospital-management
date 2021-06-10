import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;



@SuppressWarnings("serial")
public class SearchPage extends JPanel {

	private JTextArea table;
	private JPanelTest win;
	private Font f;
	JLabel l1, l2, l3, title;
	ResultSet rs;
	JButton btn1, btn2, btn3, btnClear;
	
	
	public SearchPage(JPanelTest win) {
		setLayout(null);
		this.win = win;

		table = new JTextArea();
		table.setBounds(50, 150, 900, 450);
		table.setEditable(false);
		
		title = new JLabel("Search Page");
		title.setBounds(400, 10, 200, 50);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Serif", Font.BOLD, 25));
		add(title);
		
		
		l1 = new JLabel("1. Show All Patients");
		l2 = new JLabel("2. asdfasd");
		l3 = new JLabel("3. asdfasdf");
		
		l1.setBounds(100, 50, 200, 30);
		l1.setHorizontalAlignment(SwingConstants.CENTER);
		l2.setBounds(400, 50, 200, 30);
		l2.setHorizontalAlignment(SwingConstants.CENTER);
		l3.setBounds(700, 50, 200, 30);
		l3.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		btn1 = new JButton("Search1");
		btn2 = new JButton("Search2");
		btn3 = new JButton("Search3");
		btnClear = new JButton("Clear");
		
		
		btn1.setBounds(150, 80, 100, 30);
		btn2.setBounds(450, 80, 100, 30);
		btn3.setBounds(750, 80, 100, 30);
		btnClear.setBounds(900, 20, 70, 30);

		
		
		
		
		
		add(l1);
		add(l2);
		add(l3);
		
		add(btn1);
		add(btn2);
		add(btn3);
		add(btnClear);
		
		
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String query = "select * from Patients";
				
//				System.out.println(query);
				
				try {
					Statement stmt;
					stmt = JPanelTest.con.createStatement();
				    table.setText("");
				    table.setText("\n\n   ID \tNUR_ID \t   DOC_ID \tNAME \tGEN \t Jumin \tADDR \t PHONE \t EMAIL \t JOB\n\n");
//				    PreparedStatement pstat = JPanelTest.con.prepareStatement(query);


				    rs = stmt.executeQuery(query);
				    while (rs.next()) {
				    	String str = rs.getInt(1) + "\t"
				    			  + rs.getInt(2) + "\t   "
				    			  + rs.getString(3) + "\t"
				    			  + rs.getString(4) + "\t"
				    			  + rs.getString(5) + "\t"
				    			  + rs.getString(6) + "\t"
				    			  + rs.getString(7) + "\t"
				    			  + rs.getString(8) + "\t"
				    			  + rs.getString(9) + "\t"
				    			  + rs.getString(10) + "\n";
				    	table.append(str);
				      }
				  }
				  catch (Exception e2) {
					  System.out.println("쿼리 읽기 실패 :" + e2);
				  }
			}
		});
		
		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String query = "select * from Patients";
				
//				System.out.println(query);
				
				try {
					Statement stmt;
					stmt = JPanelTest.con.createStatement();
				    table.setText("");
				    table.setText("\n\n   ID \tNUR_ID \t   DOC_ID \tNAME \tGEN \t Jumin \tADDR \t PHONE \t EMAIL \t JOB\n\n");
//				    PreparedStatement pstat = JPanelTest.con.prepareStatement(query);


				    rs = stmt.executeQuery(query);
				    while (rs.next()) {
				    	String str = rs.getInt(1) + "\t"
				    			  + rs.getInt(2) + "\t   "
				    			  + rs.getString(3) + "\t"
				    			  + rs.getString(4) + "\t"
				    			  + rs.getString(5) + "\t"
				    			  + rs.getString(6) + "\t"
				    			  + rs.getString(7) + "\t"
				    			  + rs.getString(8) + "\t"
				    			  + rs.getString(9) + "\t"
				    			  + rs.getString(10) + "\n";
				    	table.append(str);
				      }
				  }
				  catch (Exception e2) {
					  System.out.println("쿼리 읽기 실패 :" + e2);
				  }
			}
		});
		
		btnClear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			table.setText("");
		   }
			
		});

		f = new Font("Dialog", Font.PLAIN,12);
		
//		JScrollPane scrollPane = new JScrollPane(table);
		table.setFont(f);
		add(table);
		


		
		
//		add("North", scrollPane);
		
	   
		JButton btn_home = new JButton("Back");
		btn_home.setSize(120, 40);
		btn_home.setLocation(840, 620);
		btn_home.setHorizontalAlignment(SwingConstants.CENTER);
		add(btn_home);
		btn_home.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				win.change("StartPage");
			}
		});
}
}


//class ShowPatient extends JPanel { 
//	private JTextArea table;
//	private JPanelTest win;
//	private Font f;
//	JLabel l1, l2, l3, title;
//	JTextField f1, f2, f3;
//	ResultSet rs;
//	JButton btn1, btn2, btn3, btnClear;
//	
//	
//	public ShowPatient(JPanelTest win) {
//		setLayout(null);
//		this.win = win;
//
//		table = new JTextArea();
//		table.setBounds(50, 100, 900, 500);
//		table.setEditable(false);
//		
//		title = new JLabel("Search Page");
//		title.setBounds(450, 50, 200, 50);
//		
//		btn1 = new JButton("Search1 - Patient");
//		btn1.setBounds(700, 100, 100, 30);
//		btn2 = new JButton("Search2 - ");
//		btn2.setBounds(700, 150, 100, 30);
//		btn3 = new JButton("Search3 - ");
//		btn3.setBounds(700, 200, 100, 30);
//
//		add(title);
//		add(btn1);
//		add(btn2);
//		add(btn3);
//		
//		
//		btn1.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				
//				String query = "select * from Patients";
//				
////				System.out.println(query);
//				
//				try {
//					Statement stmt;
//					stmt = JPanelTest.con.createStatement();
//				    table.setText("");
//				    table.setText("\n\n   ID    NUR_ID    DOC_ID \t NAME \t GEN \t Jumin \t ADDR \t PHONE \t EMAIL \t JOB\n");
////				    PreparedStatement pstat = JPanelTest.con.prepareStatement(query);
//
//
//				    rs = stmt.executeQuery(query);
//				    while (rs.next()) {
//				    	String str = rs.getInt(1) + "\t"
//				    			  + rs.getInt(2) + "\t   "
//				    			  + rs.getString(3) + "\t"
//				    			  + rs.getString(4) + "\t"
//				    			  + rs.getString(5) + "\t"
//				    			  + rs.getString(6) + "\t"
//				    			  + rs.getString(7) + "\t"
//				    			  + rs.getString(8) + "\t"
//				    			  + rs.getString(9) + "\n";
//				    	table.append(str);
//				      }
//				  }
//				  catch (Exception e2) {
//					  System.out.println("쿼리 읽기 실패 :" + e2);
//				  }
//			}
//		});
//		
//		btnClear.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				table.setText("");
//	           f1.setText("");
//	           f2.setText("");
//	           f3.setText("");
//		   }
//			
//		});
//
//		f = new Font("Dialog", Font.PLAIN,10);
//		
////		JScrollPane scrollPane = new JScrollPane(table);
//		table.setFont(f);
//		add(table);
//		
//		l1 = new JLabel("student_id");
//		l2 = new JLabel("year");
//		l3 = new JLabel("semester");
//		
//		f1 = new JTextField(5);
//		f2 = new JTextField(5);
//		f3 = new JTextField(5);
//		
//		f1.setText("17011806");
//		f2.setText("2021");
//		f3.setText("1");
//		
//		add(l1);
//		add(l2);
//		add(l3);
//		
//		add(f1);
//		add(f2);
//		add(f3);
//		
//		l1.setBounds(100, 50, 100, 30);
//		l2.setBounds(360, 50, 100, 30);
//		l3.setBounds(530, 50, 100, 30);
//		
//		f1.setBounds(200, 50, 100, 30);
//		f2.setBounds(400, 50, 100, 30);
//		f3.setBounds(600, 50, 100, 30);
////		add("North", scrollPane);
//		
//	   
//		JButton btn_home = new JButton("Back");
//		btn_home.setSize(120, 40);
//		btn_home.setLocation(10, 10);
//		add(btn_home);
//		btn_home.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				win.change("studentHome");
//			}
//		});
//	}
//
//	class MyActionListener implements ActionListener { 
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			win.change("jpanel01");
//		}
//	}
//}



class SLectureView extends JPanel { 
	private JTextArea table;
	private JPanelTest win;
	private Font f;
	JLabel l1, l2, l3, title;
	JTextField f1, f2, f3;
	ResultSet rs;
	JButton btn, btnClear;
	
	
	public SLectureView(JPanelTest win) {
		setLayout(null);
		this.win = win;

		table = new JTextArea();
		table.setBounds(50, 100, 900, 500);
		table.setEditable(false);
		
		title = new JLabel("My Lectures");
		title.setBounds(450, 5, 200, 50);
		btn = new JButton("Search");
		btn.setBounds(750, 50, 80, 30);
		btnClear = new JButton("Clear");
		btnClear.setBounds(850, 50, 80, 30);
		add(title);
		add(btn);
		add(btnClear);
		
		
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				int stdid = 17011800;
				int year = 2021;
				int semester = 1;
				
				String s1 = String.valueOf(f1.getText());
				String s2 = String.valueOf(f2.getText());
				String s3 = String.valueOf(f3.getText());
				
				stdid = Integer.parseInt(s1);
				year = Integer.parseInt(s2);
				semester = Integer.parseInt(s3);
				
				String query = "select l.*, c.gpa from `lecture` l, `course` c "
						+ "where l.year = " + year + " and l.semester = " + semester
						+ "	and c.student_id = " + stdid
						+ " and l.id = c.lecture_id and l.class_id = c.class_id";
				
//				System.out.println(query);
				try {
					Statement stmt;
					stmt = JPanelTest.con.createStatement();
				    table.setText("");
				    table.setText("\n\n   ID    CLASS_ID    PROF_ID \t NAME \t DAY \t PERIOD \t CREDIT \t TIME \t DEPT_ID \t ROOM \t YEAR\t SEMESTER\t GPA\n");
//				    PreparedStatement pstat = JPanelTest.con.prepareStatement(query);


				    rs = stmt.executeQuery(query);
				    while (rs.next()) {
				    	String str = rs.getInt(1) + "        "
				    			  + rs.getInt(2) + "\t   "
				    			  + rs.getInt(3) + "\t"
				    			  + rs.getString(4) + "\t"
				    			  + rs.getString(5) + "\t"
				    			  + rs.getInt(6) + "\t"
				    			  + rs.getInt(7) + "\t"
				    			  + rs.getInt(8) + "\t"
				    			  + rs.getInt(9) + "\t"
				    			  + rs.getString(10) + "\t"
				    			  + rs.getInt(11) + "\t"
				    			  + rs.getInt(12) + "\t"
				    			  + rs.getString(13) + "\n";
				    	table.append(str);
				      }
				  }
				  catch (Exception e2) {
					  System.out.println("쿼리 읽기 실패 :" + e2);
				  }
			}
		});
		
		btnClear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				table.setText("");
	           f1.setText("");
	           f2.setText("");
	           f3.setText("");
		   }
			
		});

		f = new Font("Dialog", Font.PLAIN,10);
		
//		JScrollPane scrollPane = new JScrollPane(table);
		table.setFont(f);
		add(table);
		
		l1 = new JLabel("student_id");
		l2 = new JLabel("year");
		l3 = new JLabel("semester");
		
		f1 = new JTextField(5);
		f2 = new JTextField(5);
		f3 = new JTextField(5);
		
		f1.setText("17011806");
		f2.setText("2021");
		f3.setText("1");
		
		add(l1);
		add(l2);
		add(l3);
		
		add(f1);
		add(f2);
		add(f3);
		
		l1.setBounds(100, 50, 100, 30);
		l2.setBounds(360, 50, 100, 30);
		l3.setBounds(530, 50, 100, 30);
		
		f1.setBounds(200, 50, 100, 30);
		f2.setBounds(400, 50, 100, 30);
		f3.setBounds(600, 50, 100, 30);
//		add("North", scrollPane);
		
	   
		JButton btn_home = new JButton("Back");
		btn_home.setSize(120, 40);
		btn_home.setLocation(10, 10);
		add(btn_home);
		btn_home.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				win.change("studentHome");
			}
		});
	}

	class MyActionListener implements ActionListener { 
		@Override
		public void actionPerformed(ActionEvent e) {
			win.change("jpanel01");
		}
	}
}


class SClubView extends JPanel { 
	private JTextArea table;
	private JPanelTest win;
	private Font f;
	JLabel l1, title;
	JTextField f1;
	ResultSet rs;
	JButton btn, btnClear;
	
	
	public SClubView(JPanelTest win) {
		setLayout(null);
		this.win = win;

		table = new JTextArea();
		table.setBounds(50, 100, 900, 500);
		table.setEditable(false);
		
		title = new JLabel("My Clubs");
		title.setBounds(450, 5, 200, 50);
		btn = new JButton("Search");
		btn.setBounds(750, 50, 80, 30);
		btnClear = new JButton("Clear");
		btnClear.setBounds(850, 50, 80, 30);
		add(title);
		add(btn);
		add(btnClear);
		
		
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				int stdid = 17011800;

				
				String s1 = String.valueOf(f1.getText());
				
				stdid = Integer.parseInt(s1);
				
				String query = "select * from club c \n"
						+ "where id in (select club_id from club_member \n"
						+ "where student_id = " + stdid + ")";
				
//				System.out.println(query);
				try {
					Statement stmt;
					stmt = JPanelTest.con.createStatement();
				    table.setText("");
				    table.setText("\n\n   ID    NAME\t\tNUM_OF_STUDENTS \t PRESIDENT_ID \t ROOM \n");
//				    PreparedStatement pstat = JPanelTest.con.prepareStatement(query);


				    rs = stmt.executeQuery(query);
				    while (rs.next()) {
				    	String str = rs.getInt(1) + "    "
				    			  + rs.getString(2) + "\t\t"
				    			  + rs.getInt(3) + "\t\t"
				    			  + rs.getInt(4) + "\t"
				    			  + rs.getString(5) + "\n";
				    	table.append(str);
				      }
				  }
				  catch (Exception e2) {
					  System.out.println("쿼리 읽기 실패 :" + e2);
				  }
			}
		});
		
		btnClear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				table.setText("");
	           f1.setText("");
		   }
			
		});

		f = new Font("Dialog", Font.PLAIN,10);
		
//		JScrollPane scrollPane = new JScrollPane(table);
		table.setFont(f);
		add(table);
		
		l1 = new JLabel("student_id");
		
		f1 = new JTextField(5);
		
		f1.setText("17011806");
		
		add(l1);
		
		add(f1);
		
		l1.setBounds(100, 50, 100, 30);
		
		f1.setBounds(200, 50, 100, 30);
		
	   
		JButton btn_home = new JButton("Back");
		btn_home.setSize(120, 40);
		btn_home.setLocation(10, 10);
		add(btn_home);
		btn_home.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				win.change("studentHome");
			}
		});
	}

	class MyActionListener implements ActionListener { 
		@Override
		public void actionPerformed(ActionEvent e) {
			win.change("jpanel01");
		}
	}
}