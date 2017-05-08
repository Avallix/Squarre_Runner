package MapPac;

//import java.awt.Desktop.Action;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.io.File;

import javax.swing.AbstractAction;
//import javax.swing.ActionMap;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MapPanel extends JPanel {
	private MapGraphics block = new MapGraphics();
	private CommandPanel cp = new CommandPanel();
	private JLabel winLoose = new JLabel("Score: " + block.getScore());
	private JLabel goal = new JLabel("Get to a score of 3!");
	public MapPanel() {
		add(goal);
		add(winLoose);
		block.setPreferredSize(new Dimension(400, 400));
		add(block);
		add(cp);
		
	}

	public class CommandPanel extends JPanel {
		private JTextField commandInput = new JTextField(20);
		private JButton right = new JButton( new AbstractAction("Right") {
		        @Override
		        public void actionPerformed( ActionEvent e ) {
		        	block.passCommand(right.getLabel());
		        }
		    });
		private JButton left = new JButton( new AbstractAction("Left") {
	        @Override
	        public void actionPerformed( ActionEvent e ) {
	        	block.passCommand(left.getLabel());
	        }
	    });
		private JButton up = new JButton( new AbstractAction("Up") {
	        @Override
	        public void actionPerformed( ActionEvent e ) {
	        	block.passCommand(up.getLabel());
	        }
	    });
		private JButton down = new JButton( new AbstractAction("Down") {
	        @Override
	        public void actionPerformed( ActionEvent e ) {
	        	block.passCommand(down.getLabel());
	        }
	    });
		private JButton stay = new JButton( new AbstractAction("Stay") {
	        @Override
	        public void actionPerformed( ActionEvent e ) {
	        	block.passCommand(stay.getLabel());
	        }
	    });
		/*
		public String getCommandInput() {
			return commandInput.getText();
		}
		*/
		private ActionListener a = new EnterCommand();

		CommandPanel() {
			left.addActionListener(a);
			add(left);
			right.addActionListener(a);
			add(right);
			up.addActionListener(a);
			add(up);
			down.addActionListener(a);
			add(down);
			stay.addActionListener(a);
			add(stay);
		}

		public class EnterCommand implements ActionListener {

			public void actionPerformed(ActionEvent e) {
				if (Integer.parseInt(block.getScore()) == 3){
					winLoose.setText("YOU WIN!!");
				}else {
				winLoose.setText("Score: " + block.getScore());
			
				}
			}
		}
	}
}
