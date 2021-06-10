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

		l1 = new JLabel("1. All Patients");
		l2 = new JLabel("2. Hard-Working Nurses");
		l3 = new JLabel("3. Most Symptoms in Pediatric");

		l1.setBounds(100, 70, 200, 30);
		l1.setHorizontalAlignment(SwingConstants.CENTER);
		l2.setBounds(400, 70, 200, 30);
		l2.setHorizontalAlignment(SwingConstants.CENTER);
		l3.setBounds(700, 70, 200, 30);
		l3.setHorizontalAlignment(SwingConstants.CENTER);

		btn1 = new JButton("Search1");
		btn2 = new JButton("Search2");
		btn3 = new JButton("Search3");
		btnClear = new JButton("Clear");

		btn1.setBounds(150, 100, 100, 30);
		btn2.setBounds(450, 100, 100, 30);
		btn3.setBounds(750, 100, 100, 30);
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
					table.setText(
							"\n\n\t All informations about Patients in our Hospital.\n"
							+ "\t 전체 환자 정보 보기 \n"
							+ "\t --------------------------------------------------\n\n"
							+ "   ID \tNUR_ID \t   DOC_ID \tNAME \tGEN   Jumin \tADDR \t PHONE \t EMAIL \t JOB\n\n");

					rs = stmt.executeQuery(query);
					while (rs.next()) {
						String str = rs.getInt(1) + "\t" + rs.getInt(2) + "\t   " + rs.getString(3) + "\t"
								+ rs.getString(4) + "\t" + rs.getString(5) + "     " + rs.getString(6) + "\t"
								+ rs.getString(7) + "\t" + rs.getString(8) + "\t" + rs.getString(9) + "\t"
								+ rs.getString(10) + "\n";
						table.append(str);
					}
				} catch (Exception e2) {
					System.out.println("쿼리 읽기 실패 :" + e2);
				}
			}
		});

		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String query = "select n.nur_id, n.nur_name, count(*)\n"
						+ "from Nurses n, Charts c\n"
						+ "where c.nur_id = n.nur_id\n"
						+ "group by n.nur_id\n"
						+ "having count(*) >= 2\n"
						+ "order by count(*) desc;";

				try {
					Statement stmt;
					stmt = JPanelTest.con.createStatement();
					table.setText("");
					table.setText(
							"\n\n\t List of the Nurses who have more than 1 chart.\n"
							+ "\t We can find out who is the most Hard-Working Nurse.\n"
							+ "\t 2개 이상의 차트(처방)에 이름이 적힌 간호사를 이름에 따라 분류.\n"
							+ "\t ---------------------------------------------------\n\n"
							+ "\t NURSE_ID \t NURSE_NAME \t     NUMBER OF CHARTS \n\n");

					rs = stmt.executeQuery(query);
					while (rs.next()) {
						String str = "\t" + rs.getInt(1) + "\t   " + rs.getString(2) + "\t\t" + rs.getInt(3) + "\n";
						table.append(str);
					}
				} catch (Exception e2) {
					System.out.println("쿼리 읽기 실패 :" + e2);
				}
			}
		});
		
		btn3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String query = "select t.treat_contents, count(*)\n"
						+ "from Treatments t, Patients p, Doctors d\n"
						+ "where t.pat_id = p.pat_id and p.doc_id = d.doc_id and d.major_treat = '소아과'\n"
						+ "group by t.treat_contents\n"
						+ "order by t.treat_contents;";

				try {
					Statement stmt;
					stmt = JPanelTest.con.createStatement();
					table.setText("");
					table.setText(
							"\n\n\t the number of patients\n"
							+ "\t treated by pediatricians grouping by each symptom.\n"
							+ "\t 소아과 의사에게 진료를 받은 환자들의 수를 각 진료 내용에 따라 분류 \n"
							+ "\t -------------------------------------------------------\n\n"
							+ "\tTREAT_CONTENTS \tNUMBER_OF_PATIENTS\n");

					rs = stmt.executeQuery(query);
					while (rs.next()) {
						String str = "\t     " + rs.getString(1) + "\t\t     " + rs.getInt(2) + "\n";
						table.append(str);
					}
				} catch (Exception e2) {
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

		f = new Font("Dialog", Font.PLAIN, 12);

//		JScrollPane scrollPane = new JScrollPane(table);
		table.setFont(f);
		add(table);

//		add("North", scrollPane);

		JButton btn_home = new JButton("Back");
		btn_home.setSize(120, 40);
		btn_home.setLocation(10, 10);
		btn_home.setHorizontalAlignment(SwingConstants.CENTER);
		add(btn_home);
		btn_home.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				win.change("jpanel01");
			}
		});
	}
}
