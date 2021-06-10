import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
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

public class DeletePage extends JPanel {
	private HashMap<String, JTextField> textFieldMap;
	private JPanelTest win;
	private JLabel title, lb1, lb2, lb3, lb4, lb5;
	private JTextArea statusText;

	public DeletePage(JPanelTest win) {
		setLayout(null);
		this.win = win;
		addDefaultLabel();
		addDefaultEditText();

		title = new JLabel("Delete Charts");
		title.setBounds(400, 10, 200, 50);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Serif", Font.BOLD, 25));

		JButton btn = new JButton("Delete");

		lb1 = new JLabel("You can delete Charts if the treatment of the chart has been out-dated.");
		lb2 = new JLabel("Once you input `date`, all Charts with treatment before the `date` will be deleted.");
		lb5 = new JLabel("날짜를 입력하면 해당 날짜 이전의 진료기록이 있는 차트를 모두 삭제합니다.");
		lb1.setBounds(200, 100, 600, 20);
		lb2.setBounds(200, 120, 600, 20);
		lb5.setBounds(200, 150, 600, 30);
		lb1.setFont(new Font("Dialog", Font.ITALIC, 13));
		lb2.setFont(new Font("Dialog", Font.ITALIC, 13));
		lb5.setFont(new Font("Dialog", Font.ITALIC, 13));
		lb1.setHorizontalAlignment(SwingConstants.CENTER);
		lb2.setHorizontalAlignment(SwingConstants.CENTER);
		lb5.setHorizontalAlignment(SwingConstants.CENTER);

		add(lb1);
		add(lb2);
		add(lb5);

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
		btn.setLocation(600, 300);
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

				String date = "20210610";
//				Date d = null;

				String s1 = textFieldMap.get("date").getText();

				if (true) {
					date = s1;

//					d = Date.valueOf(date);

					String sql = "delete from Charts where treat_id in ("
									+ "select treat_id from Treatments "
									+ "where treat_date < ? );";

					try {
						System.out.println("Deleting Charts before " + date + "...");
						Statement stmt;
						stmt = JPanelTest.con.createStatement();
						statusText.setText("");
						statusText.setText("Deleting Charts before " + date + "...");
						PreparedStatement pstat = JPanelTest.con.prepareStatement(sql);
						pstat.setString(1, date);

						pstat.executeUpdate();
						statusText.append("Delete Completed!\n");
						System.out.println("Delete Completed!");
					} catch (Exception e2) {
						err.setText("Invalid!");
						err.setBounds(380, 450, 200, 50);
						add(err);
						statusText.append("Delete Failed!\n" + "Please try again with proper values.\n");
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
				textFieldMap.get("date").setText("");
				err.setText("");
			}

		});

	}

	private void addDefaultLabel() {
		ArrayList<String> infoList = new ArrayList<>();
		infoList.add("* Date ");

		int x = 350, y = 300, m = 80, n = 30;
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
		String[] keys = { "date" };
		int x = 430, y = 300, m = 150, n = 30;
		int increasedY = 40;

		for (int idx = 0; idx < 1; idx++) {
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
