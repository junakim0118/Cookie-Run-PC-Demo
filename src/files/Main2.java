//Fiona Robertson and Juna Kim
//June 17, 2022
//Final Project
//Cookie Run: OvenBreak Remake

package files;

import java.lang.Math;
import hsa2.GraphicsConsole;
import java.awt.*;

public class Main2 {

	public static void main(String[] args) throws InterruptedException {
		new Main2();
	}

	GraphicsConsole gc = new GraphicsConsole(800, 400, "COOKIE RUN");

	Main2() throws InterruptedException {

		while (true) {
			// setting initial variables and score
			int score = 0;
			int COOKIEX = 100;
			int cookiey = 250;
			boolean jump = false;
			boolean doublejump = false;
			int jumpCount = 0;
			boolean slide = false;
			boolean touchGround = true;
			int COOKIEH = 100;
			int COOKIEW = 80;
			int backgroundx = 0;
			int bgx = 0;
			int floorx = 0;
			int z = 0;
			int s = 0;
			boolean hitob = false;
			int cookieEnergy;

			final int XBLOCKS = 105;
			final int YBLOCKS = 260;
			final int BLOCKSIZE = 50;
			// final int MARGIN = BLOCKSIZE * 3;
			int xoffset = 0;
			int yoffset = 0;
			int grid[][] = new int[XBLOCKS][YBLOCKS];
			for (int i = 0; i < XBLOCKS; i++) {
				grid[i][0] = 1;
				grid[i][YBLOCKS - 1] = 1;
			}
			for (int j = 0; j < YBLOCKS; j++) {
				grid[0][j] = 1;
				grid[XBLOCKS - 1][j] = 1;
			}

			int x = COOKIEX + COOKIEW;
			int y = cookiey + COOKIEH;
			int vy = 0;
			final int AY = 1;
			int xblock0, xblock1;
			int yblock0, yblock1;
			// boolean hit_ground = true;
			boolean up_not_pressed = true;

			int yblock;

			int jobx[] = { 1500, 2000, 3000 };
			int joby = 280;
			int sobx[] = { 700, 1000, 1300 };
			int soby = 0;

			int jel1x[] = { 200, 230, 260, 290, 320, 350, 380, 410, 440 };
			int jel1y = 310;
			boolean jel1[] = { true, true, true, true, true, true, true, true, true };

			int jel2x[] = { 570, 600, 630, 660, 690, 720, 750, 780, 810 };
			int jel2y = 310;
			boolean jel2[] = { true, true, true, true, true, true, true, true, true };

			int Epotionx[] = { 470 };
			int Epotiony = 280;
			boolean Epotioncheck[] = { true };

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
			Image j1obstacles = gc.loadImage("src/images/stage3ob_j1.png");
			Image s1obstacles = gc.loadImage("src/images/stage3ob_s1.png");
			Image jelly1 = gc.loadImage("src/images/Basic_Jelly_Lv_1.png");
			Image jelly2 = gc.loadImage("src/images/Pink_Bear_Jelly.png");
			Image Epotion = gc.loadImage("src/images/Energy_Potion.png");
			Image remake = gc.loadImage("src/images/remake.png");
			Image djob = gc.loadImage("src/images/stage3ob_dj1.png");

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
			gc.drawString("Press any key to start!", 550, 390);
			gc.drawString("Juna and Fiona", 300, 30);
			gc.setFont(new Font("Serif", Font.BOLD, 40));
			gc.drawImage(remake, 300, 320, 200, 100);
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
			gc.drawString("Creates extra bear j" + "ellies", 115, 300);
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
				gc.drawImage(gingericon, 330, 110, 180, 180);
				cookieEnergy = 600;
			} else if (CookieChoice == 3) {
				gc.drawImage(cottonicon, 300, 110, 200, 200);
				cookieEnergy = 400;
			} else if (CookieChoice == 2) {
				gc.drawImage(blueberryicon, 330, 110, 150, 200);
				cookieEnergy = 400;
			} else if (CookieChoice == 4) {
				gc.drawImage(cocoaicon, 300, 110, 200, 200);
				cookieEnergy = 400;
			} else {
				break;
			}

			// instructions screen
			Thread.sleep(1000);
			gc.clear();
			gc.setColor(new Color(244, 226, 198));
			gc.fillRoundRect(0, 80, 800, 400, 30, 30);
			gc.setColor(Color.BLACK);
			gc.drawString("INSTRUCTIONS", 300, 80);
			gc.drawString("Press up arrow to jump", 50, 120);
			gc.drawString("Press down arrow to slide", 50, 160);
			gc.drawString("Avoid obstacles and make it to the end of the stage", 50, 200);
			gc.drawString("Collect jellies to gain points", 50, 240);
			gc.drawString(" - 1 Point", 90, 280);
			gc.drawString(" - 5 Points", 240, 280);
			gc.drawImage(jelly1, 50, 255, 30, 30);
			gc.drawImage(jelly2, 200, 255, 30, 30);
			gc.drawString("Gain 1000 points and make it to the end to win!", 50, 320);
			gc.drawString("Press any key to start", 50, 360);

			gc.getChar();

			// loading in images
			int c_num = CookieChoice;
			Image[] r_animate = new Image[4];
			String source;
			for (int i = 1; i < r_animate.length + 1; i++) {
				source = "src/images/r" + c_num + "_" + i + ".png";
				r_animate[i - 1] = gc.loadImage(source);

			}
			Image[] j_animate = new Image[0];
			for (int i = 1; i < j_animate.length; i++) {
				source = "images/j" + c_num + "_" + i + ".png";
				j_animate[i - 1] = Toolkit.getDefaultToolkit()
						.getImage(gc.getClass().getClassLoader().getResource(source));

			}
			Image[] s_animate = new Image[2];

			for (int i = 1; i < s_animate.length + 1; i++) {
				source = "images/s" + c_num + "_" + i + ".png";
				s_animate[i - 1] = Toolkit.getDefaultToolkit()
						.getImage(gc.getClass().getClassLoader().getResource(source));

			}
			Image[] dj_animate = new Image[0];
			for (int i = 1; i < dj_animate.length + 1; i++) {
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

					// Energy bar
					gc.drawImage(Epotion, 110, 10, 50, 50);
					if (hitob == true) {
						gc.setColor(Color.RED);
						gc.fillRoundRect(150, 25, cookieEnergy, 20, 10, 10);
					} else if (hitob == false) {
						gc.setColor(new Color(247, 173, 54));
						gc.fillRoundRect(150, 25, cookieEnergy, 20, 10, 10);
					}

					// Display score
					gc.setColor(Color.WHITE);
					gc.drawString("Score: " + score, 10, 40);

					// Reset images while running
					if (jump == false && slide == false) {
						cookiey = 250;
						COOKIEW = 70;
						COOKIEH = 100;
					}

					// Drawing single jump obstacles
					for (int i = 0; i < jobx.length; i++) {
						gc.drawImage(j1obstacles, jobx[i], joby, 70, 70);
						if ((COOKIEX < jobx[i] + 70) && (cookiey < joby + 70) && (jobx[i] < COOKIEX + COOKIEW)
								&& (joby + 10 < cookiey + COOKIEH)) {
							hitob = true;
							Thread.sleep(50);

						}
					}

					// Making cookie shorter when sliding
					if (slide == true) {
						cookiey = 300;
						COOKIEW = 120;
						COOKIEH = 50;
					}

					// Drawing slide obstacles
					for (int i = 0; i < sobx.length; i++) {
						gc.drawImage(s1obstacles, sobx[i], soby + 10, 70, 280);
						if ((COOKIEX < sobx[i] + 70) && (cookiey < soby + 70) && (sobx[i] < COOKIEX + COOKIEW)
								&& (soby + 10 < cookiey + COOKIEH)) {
							hitob = true;
							Thread.sleep(50);

						}
					}

					// Drawing blue jelly beans
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

					// Drawing pink bear candy
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

					// Drawing energy potion
					for (int i = 0; i < Epotionx.length; i++) {
						if (Epotioncheck[i] == true) {
							gc.drawImage(Epotion, Epotionx[i], Epotiony, 70, 70);
						}

						if ((COOKIEX < Epotionx[i] + 30) && (cookiey < Epotiony + 30)
								&& (Epotionx[i] < COOKIEX + COOKIEW) && (Epotiony < cookiey + COOKIEH)
								&& (Epotioncheck[i] == true)) {
							Epotioncheck[i] = false;
							cookieEnergy += 30; // increases energy if collected
						}

					}
					if (!gc.isKeyDown(GraphicsConsole.VK_UP) && !gc.isKeyDown(GraphicsConsole.VK_RIGHT)
							&& up_not_pressed == true && cookiey + COOKIEH <= 350) {
						jump = false;
						doublejump = false;
						touchGround = true;
						up_not_pressed = true;
					}
					// Jump when up is pressed
					if (gc.isKeyDown(GraphicsConsole.VK_RIGHT) && jumpCount == 0 && touchGround == true
							&& jump == false) {
						jump = true;
						// slide = false;
						jumpCount = 1;
						vy -= 60;
						touchGround = false;
						up_not_pressed = false;
						System.out.println("jump");
					}
					// double jump when up is pressed twice
					if (gc.isKeyDown(GraphicsConsole.VK_UP) && touchGround == true && jump == false) {
						doublejump = true;
						jump = false;
						jumpCount = 2;
						vy -= 120;
						touchGround = false;
						up_not_pressed = false;
						System.out.println("doublejump");
					}
					cookiey += vy;
					if (!gc.isKeyDown(GraphicsConsole.VK_UP) && !gc.isKeyDown(GraphicsConsole.VK_RIGHT)) {
						up_not_pressed = true;
						jump = false;
						doublejump = false;
						jumpCount = 0;
						System.out.println("double");
					}
					if (jump == false || doublejump == false && slide == false && cookiey <= 250) {
						vy = 5;
					}
					// gravity

					// Thread.sleep(40);
					/*
					 * if (gc.isKeyDown(GraphicsConsole.VK_UP) && touchGround && up_not_pressed) {
					 * 
					 * vy = -15; touchGround = false; up_not_pressed = false;
					 * 
					 * }
					 * 
					 * if (!gc.isKeyDown(GraphicsConsole.VK_UP)) up_not_pressed = true;
					 * 
					 * // Do "gravity"
					 * 
					 * y += vy;
					 * 
					 * if (vy < 0) {
					 * 
					 * // Jumping; check for a collision with the ceiling
					 * 
					 * xblock0 = COOKIEX+COOKIEW / COOKIEW; yblock0 = cookiey+COOKIEH / COOKIEH;
					 * xblock1 = COOKIEX+COOKIEW / COOKIEW + 1; yblock1 = cookiey+COOKIEH / COOKIEH;
					 * 
					 * if ((grid[xblock0][yblock0] != 0) && (y < (yblock0 + 1) * COOKIEH)) { y =
					 * (yblock0 + 1) * COOKIEH; vy = 0; } if ((grid[xblock1][yblock1] != 0) && (y <
					 * (yblock1 + 1) * COOKIEH) && (x % COOKIEW != 0)) { y = (yblock1 + 1) *
					 * COOKIEH; vy = 0; }
					 * 
					 * }
					 * 
					 * else if (vy > 0) {
					 * 
					 * // Falling; check for a collision with the floor
					 * 
					 * xblock0 = COOKIEX+COOKIEW / COOKIEW; yblock0 = cookiey+COOKIEH / COOKIEH;
					 * xblock1 = COOKIEX+COOKIEW / COOKIEW + 1; yblock1 = cookiey+COOKIEH / COOKIEH;
					 * 
					 * if ((grid[xblock0][yblock0] != 0) && (y > (yblock0 - 1) * COOKIEH)) { y =
					 * (yblock0 - 1) * COOKIEH; vy = 0; touchGround = true; } if
					 * ((grid[xblock1][yblock1] != 0) && (y > (yblock1 - 1) * COOKIEH) && (x %
					 * COOKIEW != 0)) { y = (yblock1 - 1) * COOKIEH; vy = 0; touchGround = true; }
					 * 
					 * }
					 * 
					 * vy += AY;
					 * 
					 * // Limit maximum falling speed
					 * 
					 * if (vy > COOKIEH) vy = COOKIEH;
					 */
					// double jump when up is pressed twice
					/*if (gc.isKeyDown(GraphicsConsole.VK_UP) && jumpCount == 1 && touchGround == false &&doublejump==false
							&& cookiey < 200) {
						doublejump = true;
						jump = false;
						jumpCount = 2;
						vy -= 40;
						touchGround = false;
						up_not_pressed = false;
						System.out.println("doublejump");
					}
*/
					/*if (!gc.isKeyDown(GraphicsConsole.VK_UP)) {
						up_not_pressed = true;
						jump = false;
						doublejump = false;
					}
*/
					/*if (cookiey < 100 && jumpCount == 2) {
						jumpCount = 0;
						System.out.println("double");
						touchGround = false;
						vy = 5;
						doublejump = false;
					}
					*/
					cookiey += vy;
					/*if (cookiey < 200 && jumpCount == 1) {
						vy = 5;
						System.out.println("single");
						jumpCount = 0;
						jump = false;
					}*/
					// running animation, cycles through images

					if (slide == false) {

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
					}
					// Slide animation
					if (gc.isKeyDown(GraphicsConsole.VK_DOWN) && touchGround && up_not_pressed)
						slide = true;
					else if (!gc.isKeyDown(GraphicsConsole.VK_DOWN))
						slide = false;
					if (slide == true) {
						if (s == 0) {
							gc.drawImage(s_animate[0], COOKIEX, cookiey, COOKIEW, COOKIEH);

						}

						else if (s == 1) {
							gc.drawImage(s_animate[1], COOKIEX, cookiey, COOKIEW, COOKIEH);

						}
					}
					for (int i = 0; i < s_animate.length; i++) {
						if (jump == false && slide == true && jumpCount == 0) {
							gc.drawImage(s_animate[i], COOKIEX, cookiey, COOKIEW, COOKIEH);
							i++;
						}
					}

				}

				Thread.sleep(50);
				cookieEnergy--;
				z++;// changing image cycles
				s++;
				if (z == 4)
					z = 0;
				if (s == 2)
					s = 0;

				if (c_num == 2) {
					bgx -= 5;
					floorx -= 20;
				} else {
					bgx -= 3;// moves background
					floorx -= 15;// moves floor
				}

				for (int i = 0; i < jobx.length; i++) {
					jobx[i] -= 15;

				}
				for (int i = 0; i < sobx.length; i++) {
					sobx[i] -= 15;

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
				for (int i = 0; i < Epotionx.length; i++) {
					// moves jellies across screen
					if (Epotioncheck[i] == true) {
						Epotionx[i] -= 15;
					}

				}
				if (bgx < -1490)// keeps background and floor on repeat
					bgx = 0;
				if (floorx < -990)
					floorx = 0;

				if (cookiey + COOKIEH >= 350) {
					// checks if cookie is on floor
					touchGround = true;
					jump = false;
					doublejump = false;
					jumpCount = 0;
					cookiey = 350 - COOKIEH;
				}

				if (hitob == true) {
					cookieEnergy -= 5;
					hitob = false;
				}

				if (cookieEnergy <= 0)
					break;

			}
			gc.clear();
			gc.setColor(Color.BLACK);
			gc.println("game over");
			gc.println("try again? y/n");
			String in = gc.readLine();
			if (in == "y")
				break;
			if (in == "n")
				gc.close();
		}

	}
}
