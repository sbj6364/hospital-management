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

public class UpdatePage extends JPanel {
	private HashMap<String, JTextField> textFieldMap;
	private JPanelTest win;
	private JLabel title, lb1, lb2, lb3, lb4;
	private JTextArea statusText;

	public UpdatePage(JPanelTest win) {
		setLayout(null);
		this.win = win;
		addDefaultLabel();
		addDefaultEditText();

		title = new JLabel("Update Doctors Rank Promotion");
		title.setBounds(400, 10, 300, 50);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Serif", Font.BOLD, 25));

		JButton btn = new JButton("Update");

		lb1 = new JLabel("You can update doctors' rank(position).");
		lb2 = new JLabel("Once you input `Doctor Id` and `Position`, his(or her) position will be updated.");
		lb1.setBounds(200, 100, 600, 30);
		lb2.setBounds(200, 130, 600, 30);
		lb1.setFont(new Font("Dialog", Font.ITALIC, 13));
		lb2.setFont(new Font("Dialog", Font.ITALIC, 13));
		lb1.setHorizontalAlignment(SwingConstants.CENTER);
		lb2.setHorizontalAlignment(SwingConstants.CENTER);

		add(lb1);
		add(lb2);

		statusText = new JTextArea(" ");
		statusText.setBounds(100, 550, 800, 100);
		statusText.setEditable(false);
		add(statusText);

		lb3 = new JLabel("Status");
		lb3.setBounds(100, 520, 60, 30);
		lb3.setHorizontalAlignment(SwingConstants.CENTER);
		add(lb3);
		
		lb4 = new JLabel("ex) 20140108");
		lb4.setBounds(450, 280, 100, 20);
		lb4.setHorizontalAlignment(SwingConstants.CENTER);
		add(lb4);

		btn.setSize(100, 30);
		btn.setLocation(600, 310);
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

				int id = 601;
				String pos = "과장";

				String s1 = textFieldMap.get("id").getText();
				String s2 = textFieldMap.get("pos").getText();

				if (true) {
					id = Integer.parseInt(s1);
					pos = s2;

					String sql = "update Doctors set doc_position = ? where doc_id = ?";

					try {
						System.out.println("Updating Doctor's position as " + pos + " ...");
						Statement stmt;
						stmt = JPanelTest.con.createStatement();
						statusText.setText("");
						statusText.setText("Updating Doctor's position as " + pos + " ...");
						PreparedStatement pstat = JPanelTest.con.prepareStatement(sql);
						pstat.setInt(1, id);
						pstat.setString(2, pos);

						pstat.executeUpdate();
						statusText.append("Update Completed!\n");
						System.out.println("Update Completed!");
					} catch (Exception e2) {
						err.setText("Invalid!");
						err.setBounds(380, 450, 200, 50);
						add(err);
						statusText.append("Update Failed!\n" + "Please try again with proper values.\n");
						System.out.println("쿼리 읽기 실패 :" + e2);
					}

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
				textFieldMap.get("pos").setText("");
				statusText.setText("");
				err.setText("");
			}

		});

	}

	private void addDefaultLabel() {
		ArrayList<String> infoList = new ArrayList<>();
		infoList.add("* Doctor ID ");
		infoList.add("* Rank Promoted ");

		int x = 320, y = 270, m = 150, n = 30;
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
		String[] keys = { "id", "pos" };
		int x = 430, y = 270, m = 150, n = 30;
		int increasedY = 40;

		for (int idx = 0; idx < 2; idx++) {
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