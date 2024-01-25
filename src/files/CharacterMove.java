//Fiona Robertson and Juna Kim
//June 17, 2022
//Final Project
//Cookie Run: OvenBreak Remake

package files;

import java.lang.Math;
import hsa2.GraphicsConsole;
import java.awt.*;

public class CharacterMove {

	public static void main(String[] args) throws InterruptedException {

		final int XBLOCKS = 15;
		final int YBLOCKS = 20;
		//final int BLOCKSIZE = 50;
		final int XSIZE = 543;
		final int YSIZE = 377;
		//final int MARGIN = BLOCKSIZE * 3;
		int xoffset = 0;
		int yoffset = 0;
		GraphicsConsole gc = new GraphicsConsole(XSIZE, YSIZE);
		int grid[][] = new int[XBLOCKS][YBLOCKS];
		for (int i = 0; i < XBLOCKS; i++) {
			grid[i][7] = 1;
			grid[i][YBLOCKS - 1] = 1;
	}
		/*
		 * for (int j = 0; j < YBLOCKS; j++) { grid[0][j] = 1; grid[XBLOCKS - 1][j] = 1;
		 * } grid[1][8] = 1; grid[2][10] = 1; grid[1][12] = 1; grid[2][14] = 1;
		 * grid[1][16] = 1; grid[2][17] = 1; grid[3][6] = 1; grid[4][5] = 1; grid[5][4]
		 * = 1; grid[6][4] = 1; grid[7][4] = 1; grid[9][2] = 1;
		 */
		//int x = 3 * BLOCKSIZE;
		//int y = 5 * BLOCKSIZE;
		
		int vy = 0;
		final int AY = 1;
		int xblock0, xblock1;
		int yblock0, yblock1;
		boolean touch_ground = true;
		boolean up_not_pressed = true;

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
		boolean hitob = false;
int y =cookiey+COOKIEH;
int x =COOKIEX+COOKIEW ;
		int yblock;

		int obx[] = { 1500, 2000, 3000 };
		int oby = 280;

		int jel1x[] = { 200, 230, 260, 290, 320, 350, 380, 410, 440 };
		int jel1y = 310;
		boolean jel1[] = { true, true, true, true, true, true, true, true, true };

		int jel2x[] = { 500, 530, 560, 590, 620, 650, 680, 710, 740 };
		int jel2y = 310;
		boolean jel2[] = { true, true, true, true, true, true, true, true, true };

		// Images
		Image welcome = Toolkit.getDefaultToolkit()
				.getImage(gc.getClass().getClassLoader().getResource("images/start.png"));
		Image logo = Toolkit.getDefaultToolkit()
				.getImage(gc.getClass().getClassLoader().getResource("images/logo.png"));
		Image gingericon = Toolkit.getDefaultToolkit()
				.getImage(gc.getClass().getClassLoader().getResource("images/GingerIcon.png"));
		Image cocoaicon = Toolkit.getDefaultToolkit()
				.getImage(gc.getClass().getClassLoader().getResource("images/CocoaIcon.png"));
		Image blueberryicon = Toolkit.getDefaultToolkit()
				.getImage(gc.getClass().getClassLoader().getResource("images/BlueberryIcon.png"));
		Image cottonicon = Toolkit.getDefaultToolkit()
				.getImage(gc.getClass().getClassLoader().getResource("images/CottonIcon.png"));
		Image oven = Toolkit.getDefaultToolkit()
				.getImage(gc.getClass().getClassLoader().getResource("images/OvenScenebg.png"));
		Image bg = Toolkit.getDefaultToolkit()
				.getImage(gc.getClass().getClassLoader().getResource("images/stage3bg1.png"));
		Image floor = Toolkit.getDefaultToolkit()
				.getImage(gc.getClass().getClassLoader().getResource("images/stage3bg2.png"));
		Image j1obstacles = Toolkit.getDefaultToolkit()
				.getImage(gc.getClass().getClassLoader().getResource("images/stage3ob_j1.png"));
		Image s1obstacles = Toolkit.getDefaultToolkit()
				.getImage(gc.getClass().getClassLoader().getResource("images/slideob.png"));
		Image jelly1 = Toolkit.getDefaultToolkit()
				.getImage(gc.getClass().getClassLoader().getResource("images/Basic_Jelly_Lv_1.png"));
		Image jelly2 = Toolkit.getDefaultToolkit()
				.getImage(gc.getClass().getClassLoader().getResource("images/Pink_Bear_Jelly.png"));

		/*CookieObject c1 = new CookieObject();
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
*/
		// Welcome screen
		gc.drawImage(welcome, 0, 0, 800, 400);
		gc.setFont(new Font("Serif", Font.BOLD, 25));
		gc.setColor(Color.WHITE);
		gc.drawString("Press any key to start!", 280, 380);
		gc.drawString("Juna and Fiona", 300, 30);
		gc.setFont(new Font("Serif", Font.BOLD, 40));
		gc.setColor(Color.PINK);
		gc.drawString("REMAKE", 610, 335);
		gc.getChar();
		Thread.sleep(10);

		gc.clear();

		// Cookie Choice screen with different abilities
		gc.setColor(new Color(244, 226, 198));
		gc.setFont(new Font("Serif", Font.BOLD, 25));
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

		// opening (oven) screen with chosen cookie
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
		//else {
			//break;
		//}

		// instructions screen
		Thread.sleep(1000);
		gc.clear();
		gc.setColor(new Color(244, 226, 198));
		gc.fillRoundRect(0, 100, 800, 400, 30, 30);
		gc.setColor(Color.BLACK);
		gc.drawString("INSTRUCTIONS", 300, 80);
		gc.drawString("Press up arrow to jump", 500, 150);
		gc.drawString("Press down arrow to slide", 500, 175);
		gc.drawString("Avoid obstacles and make it to the end of the stage", 50, 200);
		gc.drawString("Collect jellies to gain points", 50, 250);
		gc.drawString(" - 1 Point", 120, 290);
		gc.drawImage(jelly1, 50, 290, 30, 30);
		gc.drawImage(jelly2, 150, 290, 30, 30);
		gc.drawString("Gain 1000 points and make it to the end to win!", 50, 330);
		gc.drawString("Press any key to start", 50, 360);

		gc.getChar();

		// loading in images
		

		while (true) {
			synchronized (gc) {
				gc.clear();

				// Drawing backgrounds, two of same image on loop
				gc.drawImage(bg, bgx, 0, 1500, 400);
				gc.drawImage(bg, bgx + 1490, 0, 1500, 400);

				gc.drawImage(floor, floorx, 250, 1000, 150);
				gc.drawImage(floor, floorx + 990, 250, 1000, 150);

				gc.setColor(new Color(247, 173, 54));
				// gc.fillRoundRect(("c"+ CookieChoice + ".energy", 20,);

				gc.setColor(Color.WHITE);
				gc.drawString("Score: " + score, 10, 30);
				gc.setColor(Color.green);
	            gc.fillRect(COOKIEX, cookiey, COOKIEW, COOKIEH);

				for (int i = 0; i < obx.length; i++) {
					gc.drawImage(j1obstacles, obx[i], oby, 70, 70);
					if ((COOKIEX < obx[i] + 70) && (cookiey < oby + 70) && (obx[i] < COOKIEX + COOKIEW)
							&& (oby + 10 < cookiey + COOKIEH)) {
						hitob = true;

					}
				}

				for (int i = 0; i < jel1x.length; i++) {
					if (jel1[i] == true) {
						gc.drawImage(jelly1, jel1x[i], jel1y, 30, 30);
					}

					if ((COOKIEX < jel1x[i] + 30) && (cookiey < jel1y + 30) && (jel1x[i] < COOKIEX + COOKIEW)
							&& (jel1y < cookiey + COOKIEH) && (jel1[i] == true)) {
						jel1[i] = false;
						score++;
					}

				}
				for (int i = 0; i < jel2x.length; i++) {
					if (jel2[i] == true) {
						gc.drawImage(jelly2, jel2x[i], jel2y, 30, 30);
					}

					if ((COOKIEX < jel2x[i] + 30) && (cookiey < jel2y + 30) && (jel2x[i] < COOKIEX + COOKIEW)
							&& (jel2y < cookiey + COOKIEH) && (jel2[i] == true)) {
						jel2[i] = false;
						score += 5;
					}

				}
				// Jump when up is pressed
				/*
				 * if (gc.isKeyDown(GraphicsConsole.VK_UP) && jumpCount == 0 && touchGround ==
				 * true) { jump = true; // slide = false; jumpCount = 1; up_not_pressed = false;
				 * } // double jump when up is pressed twice if
				 * (gc.isKeyDown(GraphicsConsole.VK_UP) && jumpCount == 1 && touchGround ==
				 * false && cookiey < 150) { jump = true; jumpCount = 2; touchGround = false;
				 * up_not_pressed = false; }
				 * 
				 * if (!gc.isKeyDown(GraphicsConsole.VK_UP)) { up_not_pressed = true; jump =
				 * false; } if (jumpCount == 1) { vy -= 50; touchGround = false; jump = true;
				 * System.out.println("Jump1__" + cookiey); }
				 * 
				 * if (jumpCount == 2) { vy -= 50; jump = true; touchGround = false;
				 * System.out.println("Jump2__" + cookiey); }
				 * 
				 * if (!gc.isKeyDown(GraphicsConsole.VK_UP) && up_not_pressed == true && cookiey
				 * + COOKIEH <= 340) { jump = false; touchGround= true; }
				 * 
				 * if (cookiey < 100 && jumpCount == 2) { jumpCount=0; vy=8; }
				 * 
				 * if (cookiey < 150 && jumpCount == 1) { vy=8; }
				 * 
				 * //gravity cookiey+=vy;
				 */
				if (gc.isKeyDown(GraphicsConsole.VK_UP) && touch_ground && up_not_pressed) {

					vy = -15;
					touch_ground = false;
					up_not_pressed = false;

				}

				if (!gc.isKeyDown(GraphicsConsole.VK_UP))
					up_not_pressed = true;

				// Do "gravity"

				y += vy;

				if (vy < 0) {

					// Jumping; check for a collision with the ceiling

					xblock0 = COOKIEX+COOKIEW / COOKIEW;
					yblock0 = cookiey+COOKIEH / COOKIEH;
					xblock1 = COOKIEX+COOKIEW / COOKIEW + 1;
					yblock1 = cookiey+COOKIEH / COOKIEH;

					if ((grid[xblock0][yblock0] != 0) && (y < (yblock0 + 1) * COOKIEH)) {
						y = (yblock0 + 1) * COOKIEH;
						vy = 0;
					}
					if ((grid[xblock1][yblock1] != 0) && (y < (yblock1 + 1) * COOKIEH) && (x % COOKIEW != 0)) {
						y = (yblock1 + 1) * COOKIEH;
						vy = 0;
					}

				}

				else if (vy > 0) {

					// Falling; check for a collision with the floor

					xblock0 = COOKIEX+COOKIEW / COOKIEW;
					yblock0 = cookiey+COOKIEH / COOKIEH;
					xblock1 = COOKIEX+COOKIEW / COOKIEW + 1;
					yblock1 = cookiey+COOKIEH / COOKIEH;

					if ((grid[xblock0][yblock0] != 0) && (y > (yblock0 - 1) * COOKIEH)) {
						y = (yblock0 - 1) * COOKIEH;
						vy = 0;
						touch_ground = true;
					}
					if ((grid[xblock1][yblock1] != 0) && (y > (yblock1 - 1) * COOKIEH) && (x % COOKIEW != 0)) {
						y = (yblock1 - 1) * COOKIEH;
						vy = 0;
						touch_ground = true;
					}

				}

				vy += AY;

				// Limit maximum falling speed

				if (vy > COOKIEH)
					vy = COOKIEH;

				// running animation, cycles through images
				/*if (z == 0) {
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
				*/

			}

			Thread.sleep(50);
			z++;// changing image cycles
			if (z == 4)
				z = 0;
			bgx -= 3;// moves background
			floorx -= 15;// moves floor
			for (int i = 0; i < obx.length; i++) {
				obx[i] -= 15;

			}
			for (int i = 0; i < jel1x.length; i++) {
				// moves jellies across screen
				if (jel1[i] == true) {
					jel1x[i] -= 15;
				}

			}
			for (int i = 0; i < jel2x.length; i++) {
				// moves jellies across screen
				if (jel2[i] == true) {
					jel2x[i] -= 15;
				}

			}
			if (bgx < -1490)// keeps background and floor on repeat
				bgx = 0;
			if (floorx < -990)
				floorx = 0;
			/*
			 * if (cookiey + COOKIEH >= 340) { // checks if cookie is on floor touchGround =
			 * true; jump = false; jumpCount = 0; cookiey = 340 - COOKIEH; }
			 */
			if (hitob == true)
				break;

		}
		gc.clear();
		gc.println("game over");
		gc.println("try again y/n");
		String in = gc.readLine();
		//if (in == "y")
			//break;
		//if (in == "n")
			//gc.close();
	}

}
