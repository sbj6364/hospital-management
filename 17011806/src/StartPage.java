import javax.swing.JFrame;


public class StartPage {

	public static void main(String[] args) {
		JPanelTest win = new JPanelTest();


		win.setTitle("17011806 / Seo Byeong Jun");
		win.jpanel01 = new JPanel01(win);
		win.jpanel02 = new JPanel02(win);
		win.searchPage = new SearchPage(win);
		win.insertPage = new InsertPage(win);
		win.deletePage = new DeletePage(win);
		win.updatePage = new UpdatePage(win);

		win.add(win.jpanel01);
		win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		win.setBounds(150, 100, 1000, 700);
		win.setVisible(true);
		
	}
	
}
