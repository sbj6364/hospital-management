import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class InsertPage  extends JPanel {
	private HashMap<String, JTextField> textFieldMap;
	private JPanelTest win;
	private JLabel title, lb1, lb2, lb3;
	private JTextArea statusText;

	public InsertPage(JPanelTest win) {
		setLayout(null);
		this.win = win;
		addDefaultLabel();
		addDefaultEditText();

		title = new JLabel("Add New Patient");
		title.setBounds(400, 10, 200, 50);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Serif", Font.BOLD, 25));
		JButton btn = new JButton("Save");
		
		lb1 = new JLabel("Input Nurse ID which Exist!");
		lb2 = new JLabel("Input Doctor ID which Exist!");
		lb1.setBounds(650, 140, 200, 30);
		lb2.setBounds(650, 180, 200, 30);
		lb1.setFont(new Font("Dialog", Font.ITALIC, 12));
		lb2.setFont(new Font("Dialog", Font.ITALIC, 12));
		add(lb1);
		add(lb2);
		
		lb3 = new JLabel("Status");
		lb3.setBounds(100, 520, 60, 30);
		lb3.setHorizontalAlignment(SwingConstants.CENTER);
		add(lb3);
		
		statusText = new JTextArea(" ");
		statusText.setBounds(100, 550, 800, 100);
		statusText.setEditable(false);
		add(statusText);
		
		btn.setSize(100, 30);
		btn.setLocation(550, 500);
		add(title);
		add(btn);
		JLabel err = new JLabel("");
		err.setBounds(400, 470, 200, 50);
		add(err);
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for (String key : textFieldMap.keySet()) {
					System.out.print(key + ": \t");
					System.out.println(textFieldMap.get(key).getText().toString());

				}

				int id;
				int nur_id;
				int doc_id;
				String name;
				String gen;
				String jumin;
				String addr;
				String phone;
				String email;
				String job;

				String s1 = textFieldMap.get("id").getText();
				String s2 = textFieldMap.get("nur_id").getText();
				String s3 = textFieldMap.get("doc_id").getText();
				String s4 = textFieldMap.get("name").getText();
				String s5 = textFieldMap.get("gen").getText();
				String s6 = textFieldMap.get("jumin").getText();
				String s7 = textFieldMap.get("addr").getText();
				String s8 = textFieldMap.get("phone").getText();
				String s9 = textFieldMap.get("email").getText();
				String s10 = textFieldMap.get("job").getText();

				if (true) {
					id = Integer.parseInt(s1);
					nur_id = Integer.parseInt(s2);
					doc_id = Integer.parseInt(s3);
					name = s4;
					gen = s5;
					jumin = s6;
					addr = s7;
					if (s8 == "") {
						phone = "NULL";
					} else
						phone = s8;
					if (s9 == "") {
						email = "NULL";
					} else
						email = s9;
					job = s10;
				}

				
				String sql = "INSERT INTO Patients VALUES (?,?,?,?,?,?,?,?,?,?);";

				try {
					System.out.println("Inserting data...");
					statusText.setText("Inserting data...");
					Statement stmt;
					stmt = JPanelTest.con.createStatement();
					statusText.setText("");
					statusText.setText("Inserting data... ");
					PreparedStatement pstat = JPanelTest.con.prepareStatement(sql);
					pstat.setInt(1, id);
					pstat.setInt(2, nur_id);
					pstat.setInt(3, doc_id);
					pstat.setString(4, name);
					pstat.setString(5, gen);
					pstat.setString(6, jumin);
					pstat.setString(7, addr);
					if (phone == "NULL")
						pstat.setNull(8, 0);
					else
						pstat.setString(8, phone);
					if (email == "NULL")
						pstat.setNull(9, 0);
					else
						pstat.setString(9, email);
					pstat.setString(10, job);

					pstat.executeUpdate();
					statusText.append("Insert Completed!\n");
					System.out.println("Insert Completed!");
				} catch (Exception e2) {
					err.setText("Invalid!");
					err.setBounds(380, 450, 200, 50);
					add(err);
					statusText.append("Inserting Failed!\n" + "Please try again with proper values.\n\n"
							+ "- Check Doctor ID if it is an existing Doctor ID\n"
							+ "- Check Nurse ID if it is an existing Nurse ID\n" + "");
					System.out.println("?????? ?????? ?????? :" + e2);
				}
			}

		});

		JButton btn_home = new JButton("Back");
		btn_home.setSize(120, 40);
		btn_home.setLocation(10, 10);
		add(btn_home);
		btn_home.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				win.change("jpanel01");
			}
		});

		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(850, 50, 80, 30);
		add(btnClear);
		btnClear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				textFieldMap.get("id").setText("");
				textFieldMap.get("nur_id").setText("");
				textFieldMap.get("doc_id").setText("");
				textFieldMap.get("name").setText("");
				textFieldMap.get("gen").setText("");
				textFieldMap.get("jumin").setText("");
				textFieldMap.get("addr").setText("");
				textFieldMap.get("phone").setText("");
				textFieldMap.get("email").setText("");
				textFieldMap.get("job").setText("");
				err.setText("");
			}

		});

	}

	private void addDefaultLabel() {
		ArrayList<String> infoList = new ArrayList<>();
		infoList.add("* Patient ID");
		infoList.add("* Nurse ID");
		infoList.add("* Doctor ID");
		infoList.add("* Patient Name");
		infoList.add("* Gender");
		infoList.add("* Jumin Number");
		infoList.add("* Address");
		infoList.add("  Phone");
		infoList.add("  E-mail");
		infoList.add("* Job");

		int x = 350, y = 100, m = 100, n = 30;
		int increasedY = 40;
		for (String item : infoList) {
			JLabel label = new JLabel(item);
			label.setBounds(x, y, m, n);
			y = y + increasedY;
			add(label);
		}

	}

	private void addDefaultEditText() {
		textFieldMap = new HashMap<>();
		String[] keys = { "id", "nur_id", "doc_id", "name", "gen", "jumin", "addr", "phone", "email", "job"};
		int x = 500, y = 100, m = 150, n = 30;
		int increasedY = 40;

		for (int idx = 0; idx < 10; idx++) {
			JTextField textField = new JTextField();
			textField.setBounds(x, y, m, n);
			y += increasedY;
			textFieldMap.put(keys[idx], textField);
			add(textField);
			textField.setColumns(10);
		}
	}

	class MyActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			win.change("jpanel01");
		}
	}

}

