package MapPac;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JTextField;

import Save.TextFileER;

public class MapGraphics extends JComponent {
	private int magentaControlChangesRandomly = 0;
	private int score = 0;
	//private int magentaInLoc = 1;
	private int magentaControl = 1;
	private int bigestLoc = 9;// grid size
	private int smallestLoc = 1;
	private int rX = (int) ((Math.random() * bigestLoc) + smallestLoc);// enemy
																		// starting
																		// location
	private int rY = (int) ((Math.random() * bigestLoc) + smallestLoc);
	private int pX = (int) ((Math.random() * bigestLoc) + smallestLoc);// player
																		// starting
																		// location
	private int pY = (int) ((Math.random() * bigestLoc) + smallestLoc);
	private int bX = rY;// blue starting location
	private int bY = rX;
	private int maX = pY;
	private int maY = rX;
	private String playerSpawnComtroll = "null";
	//private String winLoose = "";
	private int[] location = { pX, pY };
	private TextFileER fileWorks = new TextFileER();
	private final Color red = Color.red;
	private final Color blue = Color.blue;
	private final Color yellow = Color.yellow;
	private final Color green = Color.green;
	private Color color = green;
	private final int top = 30;
	private final int left = top;
	private final int midColum = top + 40;
	private final int midRow = midColum;
	private final int bottom = midColum + 40;
	private final int right = midColum + 40;

	private String command = null;// Control for spawn
	private int upDown = location[1];
	private int leftRight = location[0];

	public String getScore() {
		return Integer.toString(score);
	}

	public void setScore(int score) {
		this.score = score;
	}

	private void commandNum(String command) {
		if ((command.equals("left")) && (leftRight != smallestLoc)) {
			leftRight -= 1;
		} else if ((command.equals("right")) && (leftRight != bigestLoc)) {
			leftRight += 1; // leftRight + 1;
		} else if ((command.equals("up")) && !(upDown == smallestLoc)) {
			upDown -= 1;
		} else if ((command.equals("down")) && !(upDown == bigestLoc)) {
			upDown += 1;
		}
	}

	public void paintComponent(Graphics g) {
		int BlueControl = (int) ((Math.random() * bigestLoc - 1) + smallestLoc);
		// if (magentaInLoc){
		// magentaControl = (int) ((Math.random() * bigestLoc - 7) +
		// smallestLoc);
		// }
		g.setColor(color);
		int lr = 1;
		int ud = 1; // helps the for loop cycle trough up/down cloums
		// System.out.println("PlayerLocation: " + leftRight + " " + upDown);
		// System.out.println("EnemyLocation: " + Ex + " " + Ey);
		// System.out.println(Px + " " + Py);
		if (((rY == upDown) && (rX == leftRight)) || ((upDown == bY) && (leftRight == bX)) || ((maX == leftRight) && (maY == upDown))) {
			score--;
			// win();
		} else if (((bX == rX) && (bY == rY)) || ((rX == maX) && (rY == maY))) {
			score++;
			// win();
		} else {
			//winLoose = "";
		}

		for (int i = left; i <= right + 240; i = i + (midColum - left)) {
			ud = 1;
			for (int r = top; r <= bottom + 240; r = r + (midRow - top)) {
				// sets red enemy spawn
				if ((rX == lr) && (rY == ud) && (playerSpawnComtroll.equals("null"))) {
					g.setColor(red);
					g.fillRect(i, r, 30, 30);
				}
				// sets player spawn
				else if ((leftRight == lr) && (upDown == ud) && (playerSpawnComtroll.equals("null"))) {
					g.setColor(yellow);
					g.fillRect(i, r, 30, 30);
				}
				// blue spawn
				else if ((bX == lr) && (bY == ud) && (playerSpawnComtroll.equals("null"))) {
					g.setColor(blue);
					g.fillRect(i, r, 30, 30);
				} else if ((maX == lr) && (maY == ud) && (playerSpawnComtroll.equals("null"))) {
					g.setColor(Color.magenta);
					g.fillRect(i, r, 30, 30);
				}
				// fills map with green tiles
				else {
					g.setColor(green);
					g.fillRect(i, r, 30, 30);
				}

				// animates player movement
				if ((leftRight == lr) && (upDown == ud) && (playerSpawnComtroll.equals(""))) {
					g.setColor(yellow);
					g.fillRect(i, r, 30, 30);
				}
				// Animates red enemy movement
				if ((rX == lr) && (rY == ud) && (playerSpawnComtroll.equals(""))) {
					g.setColor(red);
					g.fillRect(i, r, 30, 30);
				}
				// animates magenta movement
				if ((maX == lr) && (maY == ud) && (playerSpawnComtroll.equals(""))) {
					g.setColor(Color.MAGENTA);
					g.fillRect(i, r, 30, 30);
				}
				// Animates blue enemy movement
				if ((bX == lr) && (bY == ud) && (playerSpawnComtroll.equals(""))) {
					g.setColor(blue);
					g.fillRect(i, r, 30, 30);
				}
				ud++;
			}
			lr++;
		}
		// control magenta movement
		if (magentaControlChangesRandomly == 5) {
			magentaControl = (int) ((Math.random() * 3) + smallestLoc);
			magentaControlChangesRandomly = 0;
		}
		if ((maX == (leftRight + 2)) && (maY == (upDown - 2))) {
			magentaControl = (int) ((Math.random() * 3) + smallestLoc);
		}
		if ((maX == (leftRight - 2)) && (maY == (upDown + 2))) {
			magentaControl = (int) ((Math.random() * 3) + smallestLoc);
		}
		if ((maX == (bX - 2)) && (maY == (bY - 2))) {
			magentaControl = (int) ((Math.random() * 3) + smallestLoc);
		}
		if ((maX == (bX + 2)) && (maY == (bY + 2))) {
			magentaControl = (int) ((Math.random() * 3) + smallestLoc);
		}
		if (magentaControl == 1) {
			if (maX > (leftRight + 2)) {
				maX--;
			} else if (maX < (leftRight + 2)) {
				maX++;
			}
			if (maY > (upDown - 2)) {
				maY--;
			} else if (maY < (upDown - 2)) {
				maY++;
			}
		}
		else if (magentaControl == 2) {
			if (maX > (leftRight - 2)) {
				maX--;
			} else if (maX < (leftRight - 2)) {
				maX++;
			}
			if (maY > (upDown +2)){
				maY--;
			}else if (maY < (upDown +2)){
				maY++;
			}
		}
		else if (magentaControl == 3){
			if(maX > (bX -2)){
				maX--;
			}else if(maX < (bX - 2)){
				maX++;
			}
			if(maY > (bY - 2)){
				maY--;
			}else if(maY < (bY - 2)){
				maY++;
			}
		}
		// control blue enemy direction
		if (BlueControl == 1) {
			bX--;
			bY--;
		} else if (BlueControl == 2) {
			bY--;
		} else if (BlueControl == 3) {
			bY--;
			bX++;
		} else if (BlueControl == 4) {
			bX--;
		} else if (BlueControl == 6) {
			bX++;
		} else if (BlueControl == 7) {
			bX--;
			bY++;
		} else if (BlueControl == 8) {
			bY++;
		} else if (BlueControl == 9) {
			bX++;
			bY++;
		}
		// prevent blue from leaving border
		if (bX > bigestLoc) {
			bX--;
			bX--;
		} else if (bX < smallestLoc) {
			bX++;
			bX++;
		}
		if (bY > bigestLoc) {
			bY--;
			bY--;
		} else if (bY < smallestLoc) {
			bY++;
			bY++;
		}
		// control red enemy direction
		if (rX > leftRight) {
			rX = rX - 1;
		} else if (rX < leftRight) {
			rX = rX + 1;
		} else if (rY > upDown) {
			rY = rY - 1;
		} else if (rY < upDown) {
			rY = rY + 1;
		}
		// System.out.println("\nPlay AFter: " + leftRight + " " + upDown);
		// System.out.println("Enem After: " + Ex + " " + Ey);
		// System.out.println(Px + " " + Py);
		magentaControlChangesRandomly++;
		playerSpawnComtroll = "";
		//System.out.println("MagentaControl: " + magentaControl + "\nmaX: " + maX + "\nmaY: " + maY);
		//System.out.println("MagentaControl: " + magentaControl + "\nMagentaControlChangesRandomly: " + magentaControlChangesRandomly);
	}
	public void passCommand(String command) {
		this.command = command.toLowerCase();
		commandNum(this.command);
		if (command.contains("loadfile/")) {
			try {
				int temparray[] = fileWorks.saveRetriver(command.substring(9));
				location[0] = temparray[0];
				location[1] = temparray[1];
				upDown = location[1];
				leftRight = location[0];
			} catch (java.lang.NullPointerException e) {
				System.out.println("no file by that name");
			}
		}

		if (command.contains("savefile/")) {
			command = command.substring(9);
			fileWorks.mapSaveOverwriter(command, leftRight, upDown);
		}
		if (command.contains("deletefile/")) {
			command = command.substring(11);
			fileWorks.saveDeleter(command);
		}
		if (command.contains("listfiles")) {
			fileWorks.listFiles();
		}
		repaint();
	}
}
