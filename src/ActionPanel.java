import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import MapPac.MapPanel;
import Save.TextFileER;

public class ActionPanel extends JPanel {
	private JButton but = new JButton("Start");
	//private String commandStr = "";
	JLabel direct = new JLabel("You are the yellow block.");
	JLabel direct2 = new JLabel("Kill the red block by causing it to hit the blue or magenta blocks 3 times.");
	JLabel direct3 = new JLabel("Don't get hit by any other blocks or the red block gets stronger!");
	
	
	private ActionListener a = new EnterCommand();
	private TextFileER fileWorks = new TextFileER();
	ActionPanel() {
		but.addActionListener(a);
		
		add(direct);
		add(direct2);
		add(direct3);
		add(but);
	}

	public void map() {
		// Map frame
		JFrame mapFrame = new JFrame();
		JPanel mapPanel = new MapPanel();
		mapPanel.setBackground(Color.CYAN);
		mapFrame.add(mapPanel);
		mapFrame.setSize(500, 510);
		mapFrame.setVisible(true);
	}

	public class EnterCommand implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			map();
		}

	}
}
