package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JSplitPane;
import javax.swing.JButton;

public class Gui extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField StartingLocationTextField;
	private JTextField DestinationTextField;
	
	public Gui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		panel.add(splitPane_1);
		
		JLabel lblNewLabel = new JLabel("Starting Location");
		splitPane_1.setLeftComponent(lblNewLabel);
		
		JLabel lblDestination = new JLabel("Destination");
		splitPane_1.setRightComponent(lblDestination);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		panel.add(splitPane);
		
		StartingLocationTextField = new JTextField();
		splitPane.setLeftComponent(StartingLocationTextField);
		StartingLocationTextField.setColumns(10);
		
		DestinationTextField = new JTextField();
		splitPane.setRightComponent(DestinationTextField);
		DestinationTextField.setColumns(10);
	}
}
