import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;

import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class MainPanel {

	JFrame frame;
	JPanel panel;
	JPanel south = new JPanel();
	JPanel center = new JPanel();
	
	JButton searchButton;
	JTextField input_text;
	JComboBox<String> select_list;
//	JList<String> result_list;
	JTextPane result_list;
	
	public MainPanel() {
		
		frame = new JFrame();
		panel = new JPanel(new BorderLayout());
		searchButton = new JButton();
		input_text = new JTextField(20);
		String[] select_choice = {"inceput", "sfarsit", "oriunde"};
		select_list = new JComboBox<String>(select_choice);
		result_list = new JTextPane();
		JScrollPane scroll = new JScrollPane (result_list, 
				   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//		jsp.setSize(300, 200);
		south.add(input_text);
		south.add(select_list);
		south.add(searchButton);
		
		center.add(scroll, BorderLayout.CENTER);
		panel.add(south, BorderLayout.NORTH);
		
		panel.add(center, BorderLayout.CENTER);
		panel.setSize(400,400);
		frame.add(panel);
		
		design();
		frame.setVisible(true);
		
	}
	
	private void design() {

		ImageIcon icon = new ImageIcon("logo.jpg");
		Image img = icon.getImage();
		frame.setIconImage(img);
		frame.setForeground(Color.white);
		frame.setTitle("Cu Substrat");
		frame.setSize(600, 250);
		
		input_text.setBackground(new Color(170, 227, 214));
		
		searchButton.setBackground(Color.orange);
		searchButton.setText("Cauta Substrat");
		
		result_list.setText("avbasda\nflakjfdkskfdsa;cf\na,ljkfadskfjasd");
		result_list.setBackground(new Color(170, 227, 214));
	}
	
	public static void main(String args[]) {
		new MainPanel();	
	}
}