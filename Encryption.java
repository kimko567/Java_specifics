import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultListModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;

public class Encryption extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;

	DefaultListModel list1 = new DefaultListModel();
	DefaultListModel list2 = new DefaultListModel();
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Encryption frame = new Encryption();
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
	public Encryption() {

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 375, 335);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) { // ENTER key
				if(e.getKeyCode()==10) {list1.addElement(textField.getText()); textField.setText("");} // ērtības labad.... lai ātrāk varētu ievadīt, vairāk virknes
			}
		});
		textField.setBounds(10, 10, 350, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			list1.addElement(textField.getText());
			textField.setText("");
			}
		});
		btnNewButton.setBounds(70, 50, 110, 30);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Run");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				list2.clear();
				String s, tmp;
				int f = list1.size();
				for(int i = 0; i<list1.size(); i++)
				{
					 s = (String) list1.elementAt(i);
					tmp= "";
				   for(int j = 0, k = 0; k < s.length();j++,k++) {
						
						if(k%2==0 ) {tmp += s.charAt(s.length()-1-j);j--;}
						else tmp += s.charAt(j); 
					}
					list2.addElement(tmp);
				}
			}
		});
		btnNewButton_1.setBounds(190, 50, 110, 30);
		contentPane.add(btnNewButton_1);
		

		JList list = new JList(list1);
		list.setBorder(new LineBorder(new Color(0, 0, 0)));
		list.setFont(new Font("Tahoma", Font.PLAIN, 13));
		scrollPane = new JScrollPane();
		scrollPane.setSize(170, 150);
		scrollPane.setLocation(10, 90);
	    scrollPane.setViewportView(list);
		contentPane.add(scrollPane);
		
		JList list_1 = new JList(list2);
		list_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		list_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setSize(170, 150);
		scrollPane_1.setLocation(190, 90);
	    scrollPane_1.setViewportView(list_1);
		contentPane.add(scrollPane_1);
		
		btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int [] arra = list.getSelectedIndices();
				for (int i = 0, k = 0; i < arra.length; i++)
			         list1.remove(arra[i]- k++);
				}
		});
		btnNewButton_2.setBounds(70, 250, 110, 30);
		contentPane.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("Clear");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				list2.clear();
			}
		});
		btnNewButton_3.setBounds(190, 250, 110, 30);
		contentPane.add(btnNewButton_3);
		
		btnNewButton.setToolTipText("Add String from textField to left list!");
		btnNewButton_1.setToolTipText("Encrypt Strings from the left list into the right list (last char, first char, second-to-last char, second char...)!");
		btnNewButton_2.setToolTipText("Delete selected Strings from the left list!");
		btnNewButton_3.setToolTipText("Clear the right list!");
		
		
	}
}
