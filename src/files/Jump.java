//Fiona Robertson and Juna Kim
//June 17, 2022
//Final Project
//Cookie Run: OvenBreak Remake

package files;

import java.lang.Math;
import hsa2.GraphicsConsole;
import java.awt.*;

public class Jump {

	public static void main(String[] args) throws InterruptedException {
		new Jump();
	}

	GraphicsConsole gc = new GraphicsConsole(800, 400, "COOKIE RUN");

	Jump() throws InterruptedException {
		while (true) {

			// setting initial variables and score
			int score = 0;
			int COOKIEX = 100;
			int cookiey = 250;
			boolean jump = false;
			int jumpCount = 0;
			boolean slide = false;
			boolean touchGround = true;
			int COOKIEH = 100;
			int COOKIEW = 80;
			int backgroundx = 0;
			int bgx = 0;
			int floorx = 0;
			int z = 0;

			// Images
			Image welcome = Toolkit.getDefaultToolkit()
					.getImage(gc.getClass().getClassLoader().getResource("images/start.png"));
			Image logo = gc.loadImage("src/images/logo.png");
			Image gingericon = gc.loadImage("src/images/GingerIcon.png");
			Image cocoaicon = gc.loadImage("src/images/CocoaIcon.png");
			Image blueberryicon = gc.loadImage("src/images/BlueberryIcon.png");
			Image cottonicon = gc.loadImage("src/images/CottonIcon.png");
			Image oven = gc.loadImage("src/images/OvenScenebg.png");
			Image bg = gc.loadImage("src/images/stage3bg1.png");
			Image floor = gc.loadImage("src/images/stage3bg2.png");

			CookieObject c1 = new CookieObject();
			c1.cookieName = "Ginger";
			c1.hits = 0;
			c1.speed = 3;
			c1.energy = 120;
			CookieObject c2 = new CookieObject();
			c2.cookieName = "Blueberry Cookie";
			c2.hits = 0;
			c2.speed = 5;
			c2.energy = 100;
			CookieObject c3 = new CookieObject();
			c3.cookieName = "Cocoa Cookie";
			c3.hits = -1;
			c3.speed = 3;
			c3.energy = 100;
			CookieObject c4 = new CookieObject();
			c4.cookieName = "Cotton Candy Cookie";
			c4.hits = 0;
			c4.speed = 3;
			c4.energy = 100;

			// Welcome screen
			gc.drawImage(welcome, 0, 0, 800, 400);
			gc.setFont(new Font("Serif", Font.BOLD, 25));
			gc.setColor(Color.WHITE);
			gc.drawString("Press any key to start!", 280, 380);
			gc.getChar();
			Thread.sleep(10);

			gc.clear();

			// Cookie Choice screen with different abilities
			gc.setColor(new Color(244, 226, 198));
			gc.fillRoundRect(0, 100, 800, 400, 30, 30);
			gc.drawImage(logo, 230, 10, 300, 100);
			gc.setColor(new Color(118, 80, 56));
			gc.drawString("CHOOSE YOUR COOKIE!", 70, 380);
			gc.drawString("Enter your choice:", 480, 380);
			gc.drawImage(gingericon, 20, 110, 80, 100);
			gc.drawImage(cottonicon, 5, 230, 100, 110);
			gc.drawImage(blueberryicon, 400, 115, 80, 100);
			gc.drawImage(cocoaicon, 385, 240, 100, 110);
			gc.drawString("Ginger Cookie", 110, 130);
			gc.drawString("Cotton Candy Cookie", 110, 270);
			gc.drawString("Blueberry Cookie", 500, 130);
			gc.drawString("Cocoa Cookie", 500, 270);
			gc.drawString("1", 45, 230);
			gc.drawString("3", 50, 360);
			gc.drawString("2", 430, 235);
			gc.drawString("4", 425, 365);
			gc.setFont(new Font("Serif", Font.PLAIN, 15));
			gc.drawString("Starts with extra energy", 115, 160);
			gc.drawString("Creates extra bear jellies", 115, 300);
			gc.drawString("Faster speed", 500, 160);
			gc.drawString("First hit doesn't count", 500, 300);
			gc.setCursor(21, 100);

			// opening screen with chosen cookie
			int CookieChoice;
			CookieChoice = gc.readInt();
			gc.drawImage(oven, 0, 0, 800, 400);
			gc.setFont(new Font("Serif", Font.BOLD, 25));
			gc.setColor(Color.WHITE);
			gc.drawString("DONT EAT ME!!! I MUST ESCAPE", 200, 50);
			if (CookieChoice == 1) {
				gc.drawImage(gingericon, 310, 110, 180, 180);
			} else if (CookieChoice == 3) {
				gc.drawImage(cottonicon, 300, 110, 200, 200);
			} else if (CookieChoice == 2) {
				gc.drawImage(blueberryicon, 330, 110, 150, 200);
			} else if (CookieChoice == 4) {
				gc.drawImage(cocoaicon, 300, 110, 200, 200);
			}
//instructions screen

			Thread.sleep(1000);
			gc.clear();
			gc.setColor(Color.BLACK);
			gc.drawString("Press up arrow to jump", 100, 100);
			gc.drawString("Press down arrow to slide", 100, 200);
			gc.drawString("Avoid obstacles and make it to the end of the stage", 200, 300);
			gc.drawString("Collect jellies to gain points", 200, 400);
			gc.drawString("Gain 1000 points and make it to the end to win!", 200, 500);
			gc.drawString("Press any key to start", 200, 500);

			gc.getChar();

			// loading in images
			int c_num = CookieChoice;
			Image[] r_animate = new Image[4];
			String source;
			for (int i = 1; i < r_animate.length; i++) {
				source = "src/images/r" + c_num + "_" + i + ".png";
				r_animate[i - 1] = gc.loadImage(source);

			}
			Image[] j_animate = new Image[0];
			for (int i = 1; i < j_animate.length; i++) {
				source = "images/j" + c_num + "_" + i + ".png";
				j_animate[i - 1] = Toolkit.getDefaultToolkit()
						.getImage(gc.getClass().getClassLoader().getResource(source));

			}
			Image[] s_animate = new Image[0];

			for (int i = 1; i < s_animate.length; i++) {
				source = "images/s_" + c_num + "_" + i + ".png";
				s_animate[i - 1] = Toolkit.getDefaultToolkit()
						.getImage(gc.getClass().getClassLoader().getResource(source));

			}
			Image[] dj_animate = new Image[0];
			for (int i = 1; i < dj_animate.length; i++) {
				source = "images/dj" + c_num + "_" + i + ".png";
				dj_animate[i - 1] = Toolkit.getDefaultToolkit()
						.getImage(gc.getClass().getClassLoader().getResource(source));

			}

			while (true) {
				synchronized (gc) {
					gc.clear();

					// Drawing backgrounds, two of same image on loop
					gc.drawImage(bg, bgx, 0, 1500, 400);
					gc.drawImage(bg, bgx + 1490, 0, 1500, 400);

					gc.drawImage(floor, floorx, 250, 1000, 150);
					gc.drawImage(floor, floorx + 990, 250, 1000, 150);

					// Jump
					if (gc.isKeyDown(GraphicsConsole.VK_UP) && touchGround == true) {
						jump = true;
						System.out.print(cookiey);
						// slide = false;
						jumpCount++;
						touchGround = false;
						if (jumpCount > 2)
							jumpCount = 0;
					}

					if (jumpCount == 1) {
						cookiey = -15;

					} else if (jumpCount == 2) {
						cookiey = -15;

					}

				}
				
				if(cookiey != 250) {
					touchGround=false;
				}
				
				if (cookiey >=250 && jump == false) {
					cookiey=250;
				} else if (cookiey <250) {
				System.out.print(cookiey);
				}
				// Slide
				if (gc.getKeyCode() == GraphicsConsole.VK_DOWN) {
					slide = true;
				}

				// running animation, cycles through images
				if (z == 0) {
					gc.drawImage(r_animate[0], COOKIEX, cookiey, COOKIEW, COOKIEH);

				}

				else if (z == 1) {
					gc.drawImage(r_animate[1], COOKIEX, cookiey, COOKIEW, COOKIEH);

				}

				else if (z == 2) {
					gc.drawImage(r_animate[2], COOKIEX, cookiey, COOKIEW, COOKIEH);

				}

				else if (z == 3) {
					gc.drawImage(r_animate[3], COOKIEX, cookiey, COOKIEW, COOKIEH);

				}
				// Slide animation
				for (int i = 0; i < s_animate.length; i++) {
					if (jump == false && slide == true && jumpCount == 0) {
						gc.drawImage(s_animate[i], COOKIEX, cookiey, COOKIEW, COOKIEH);
						i++;
					}
				}

				Thread.sleep(50);
				z++;// changing image cycles
				if (z == 4)
					z = 0;
				bgx -= 3;// moves background
				floorx -= 10;// moves floor
				if (bgx < -1490)
					bgx = 0;
				if (floorx < -990)
					floorx = 0;

			}
		}
	}
}
