import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import MapPac.MapPanel;
import Save.TextFileER;

public class MapCreator {
	public static void main(String[] args) {
		TextFileER save = new TextFileER();
		try {
			save.fileNew("file1");
			save.saveRetriver("file1");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * Close frame JFrame close = new JFrame(); close.setTitle("Close");
		 * close.setSize(250, 20);
		 * close.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 * close.setVisible(true);
		 */

		// Map frame
		/*
		JFrame mapFrame = new JFrame();
		JPanel mapPanel = new MapPanel();
		mapPanel.setBackground(Color.CYAN);
		mapFrame.add(mapPanel);
		mapFrame.setSize(500, 500);
		mapFrame.setVisible(true);
		*/
		// Action Frame
		JFrame actionFrame = new JFrame();
		ActionPanel actionPanel = new ActionPanel();
		actionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		actionFrame.setTitle("Closing this frame will close the program!");
		actionFrame.add(actionPanel);
		actionFrame.setSize(430, 135);
		actionFrame.setVisible(true);
	}
}
