//Fiona Robertson and Juna Kim (Team Fina <- our names combined)
//June 17, 2022
//Final Project
//Cookie Run: OvenBreak Remake

package files;

import java.lang.Math;
import hsa2.GraphicsConsole;
import java.awt.*;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		new Main();
	}

	GraphicsConsole gc = new GraphicsConsole(800, 400);

	Main() throws InterruptedException {

		while (true) {
			// setting initial variables and score
			int score = 0;
			int COOKIEX = 100;
			int cookiey = 250;
			boolean jump = false;
			boolean slide = false;
			boolean touchGround = true;
			int COOKIEH = 100;
			int COOKIEW = 80;
			int bgx = 0;
			int floorx = 0;
			int z = 0;// Image cycle variables
			int s = 0;
			int j = 0;
			boolean hitob = false;
			int cookieEnergy;
			int vy = 0;
			boolean up_not_pressed = true;

			// obstacle initial positions
			// jump obstacles
			int jobx[] = { 1100, 2300, 2900, 3300, 5000, 5500, 6600, 7500, 7800, 8100, 9100, 9400, 9700, 10000 };
			int joby = 280;
			int jobw = 70;
			int jobh = 70;
			// slide obstacles
			int sobx[] = { 700, 1700, 1900, 3800, 4100, 4500, 6000, 6200, 6800, 7000, 7200, 8300, 8400, 8500, 8600,
					8700, 8900, 9900 };
			int soby = 0;
			int sobw = 70;
			int sobh = 280;

			// blue jelly initial positions
			int jel1x[] = { 200, 230, 260, 290, 320, 350, 380, 410, 440, 1040, 1070, 1100, 1130, 1160, 1190, 1770, 1800,
					1830, 1860, 1970, 2000, 2030, 2840, 2870, 2900, 2930, 2960, 2990, 4940, 4970, 5000, 5030, 5060,
					5090 };
			int jel1y[] = { 310, 310, 310, 310, 310, 310, 310, 310, 310, 190, 170, 150, 150, 170, 190, 250, 250, 250,
					250, 250, 250, 250, 190, 170, 150, 150, 170, 190, 190, 170, 150, 150, 170, 190 };

			boolean[] jel1 = new boolean[jel1x.length];
			Arrays.fill(jel1, true);// sets everything in array to true

			// pink bear candy initial positions
			int jel2x[] = { 570, 600, 630, 660, 690, 720, 750, 780, 810, 2240, 2270, 2300, 2330, 2360, 2390, 3240, 3270,
					3300, 3330, 3360, 3390, 5430, 5470, 5500, 5530, 5560, 5590, 6540, 6570, 6600, 6630, 6660, 6690 };
			int jel2y[] = { 310, 310, 310, 310, 310, 310, 310, 310, 310, 190, 170, 150, 150, 170, 190, 190, 170, 150,
					150, 170, 190, 190, 170, 150, 150, 170, 190, 190, 170, 150, 150, 170, 190 };
			boolean jel2[] = new boolean[jel2x.length];
			Arrays.fill(jel2, true);

			// energy potion initial positions
			int Epotionx[] = { 470, 1000, 7200 };
			int Epotiony = 280;
			boolean[] Epotioncheck = new boolean[Epotionx.length];
			int Epotionw = 70;
			int Epotionh = 70;
			Arrays.fill(Epotioncheck, true);

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
					.getImage(gc.getClass().getClassLoader().getResource("images/stage3ob_s1.png"));
			Image jelly1 = Toolkit.getDefaultToolkit()
					.getImage(gc.getClass().getClassLoader().getResource("images/Basic_Jelly_Lv_1.png"));
			Image jelly2 = Toolkit.getDefaultToolkit()
					.getImage(gc.getClass().getClassLoader().getResource("images/Pink_Bear_Jelly.png"));
			Image Epotion = Toolkit.getDefaultToolkit()
					.getImage(gc.getClass().getClassLoader().getResource("images/Energy_Potion.png"));
			Image remake = Toolkit.getDefaultToolkit()
					.getImage(gc.getClass().getClassLoader().getResource("images/remake.png"));

			Image die1 = Toolkit.getDefaultToolkit()
					.getImage(gc.getClass().getClassLoader().getResource("images/die1.png"));
			Image die2 = Toolkit.getDefaultToolkit()
					.getImage(gc.getClass().getClassLoader().getResource("images/die2.png"));
			Image die3 = Toolkit.getDefaultToolkit()
					.getImage(gc.getClass().getClassLoader().getResource("images/die3.png"));
			Image die4 = Toolkit.getDefaultToolkit()
					.getImage(gc.getClass().getClassLoader().getResource("images/die4.png"));

			// The different cookies
			CookieObject c1 = new CookieObject();
			c1.cookieName = "Ginger";
			c1.hits = 0;
			c1.speed = 3;
			c1.energy = 600;
			CookieObject c2 = new CookieObject();
			c2.cookieName = "Blueberry Cookie";
			c2.hits = 0;
			c2.speed = 5;
			c2.energy = 400;
			CookieObject c3 = new CookieObject();
			c3.cookieName = "Cocoa Cookie";
			c3.hits = -1;
			c3.speed = 3;
			c3.energy = 400;
			CookieObject c4 = new CookieObject();
			c4.cookieName = "Cotton Candy Cookie";
			c4.hits = 0;
			c4.speed = 3;
			c4.energy = 400;

			// jelly object (initialize points and type)
			Jellies j1 = new Jellies();
			j1.jellyPoint = 1;
			j1.jellyType = "blue jelly";
			Jellies j2 = new Jellies();
			j2.jellyPoint = 5;
			j2.jellyType = "bear jelly";

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
			// gc.drawString("Creates extra bear jellies", 115, 300);
			gc.drawString("Faster speed", 500, 160);
			// gc.drawString("First hit doesn't count", 500, 300);
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
				cookieEnergy = c1.energy;
			} else if (CookieChoice == 3) {
				gc.drawImage(cottonicon, 300, 110, 200, 200);
				cookieEnergy = c2.energy;
			} else if (CookieChoice == 2) {
				gc.drawImage(blueberryicon, 330, 110, 150, 200);
				cookieEnergy = c3.energy;
			} else if (CookieChoice == 4) {
				gc.drawImage(cocoaicon, 300, 110, 200, 200);
				cookieEnergy = c4.energy;
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
			gc.drawString("Gain 150 points and make it to the end to win!", 50, 320);
			gc.drawString("Press any key to start :D", 50, 360);

			gc.getChar();

			// loading in images
			int c_num = CookieChoice;
			// running images
			Image[] r_animate = new Image[4];
			images_load(c_num, "r", r_animate, gc);

			// jumping images
			Image[] j_animate = new Image[2];
			images_load(c_num, "j", j_animate, gc);

			// sliding images
			Image[] s_animate = new Image[2];
			images_load(c_num, "s", s_animate, gc);

			while (true) {
				synchronized (gc) {
					gc.clear();

					// Drawing backgrounds, two of same image on loop
					gc.drawImage(bg, bgx, 0, 1500, 400);
					gc.drawImage(bg, bgx + 1490, 0, 1500, 400);

					// Drawing floor on loop
					gc.drawImage(floor, floorx, 250, 1000, 150);
					gc.drawImage(floor, floorx + 990, 250, 1000, 150);

					// Reset image sizes while running
					if (jump == false && slide == false) {
						cookiey = 250;
						COOKIEW = 70;
						COOKIEH = 100;
					}

					// Drawing single jump obstacles
					for (int i = 0; i < jobx.length; i++) {
						gc.drawImage(j1obstacles, jobx[i], joby, jobw, jobh);
						if (collision_detection(COOKIEX, cookiey, COOKIEW, COOKIEH, jobx[i], joby, jobw, jobh)) {
							hitob = true;

						}
					}

					// Making cookie shorter when sliding (for collision detection)
					if (slide == true) {
						cookiey = 300;
						COOKIEW = 120;
						COOKIEH = 50;
					} else if (jump == true && slide == false) {
						COOKIEW = 70;// makes jumping cookie regular size
						COOKIEH = 80;
					}
					// Drawing slide obstacles
					for (int i = 0; i < sobx.length; i++) {
						gc.drawImage(s1obstacles, sobx[i], soby, sobw, sobh);
						if (collision_detection(COOKIEX, cookiey, COOKIEW, COOKIEH, sobx[i], soby, sobw, sobh)) {
							hitob = true;// checks for collision
						}
					}

					// Display score
					gc.setColor(Color.WHITE);
					gc.drawString("Score: " + score, 10, 40);

					// Energy bar
					gc.drawImage(Epotion, 130, 10, 50, 50);

					if (hitob == true) {
						gc.setColor(Color.RED);
						gc.fillRoundRect(170, 25, cookieEnergy, 20, 10, 10);
					} else if (hitob == false) {
						gc.setColor(new Color(247, 173, 54));
						gc.fillRoundRect(170, 25, cookieEnergy, 20, 10, 10);
					}
					// Drawing blue jelly beans
					for (int i = 0; i < jel1x.length; i++) {
						draw_features(jel1[i], jelly1, jel1x[i], jel1y[i], 30, 30, gc);

						if (collision_detection(COOKIEX, cookiey, COOKIEW, COOKIEH, jel1x[i], jel1y[i], 30, 30)
								&& (jel1[i] == true)) {
							jel1[i] = false; // erases jelly
							score += j1.jellyPoint; // adds to score
						}

					}

					// Drawing pink bear candy
					for (int i = 0; i < jel2x.length; i++) {
						draw_features(jel2[i], jelly2, jel2x[i], jel2y[i], 30, 30, gc);

						if (collision_detection(COOKIEX, cookiey, COOKIEW, COOKIEH, jel2x[i], jel2y[i], 30, 30)
								&& (jel2[i] == true)) {
							jel2[i] = false; // erases jelly
							score += j2.jellyPoint; // adds to score
						}

					}

					// Drawing energy potion
					for (int i = 0; i < Epotionx.length; i++) {
						draw_features(Epotioncheck[i], Epotion, Epotionx[i], Epotiony, Epotionw, Epotionh, gc);

						if (collision_detection(COOKIEX, cookiey, COOKIEW, COOKIEH, Epotionx[i], Epotiony, Epotionw,
								Epotionh) && (Epotioncheck[i] == true)) {
							Epotioncheck[i] = false;
							cookieEnergy += 30; // increases energy if collected
						}
					}

					// When cookie is running on ground
					if (!gc.isKeyDown(GraphicsConsole.VK_UP) && up_not_pressed == true && cookiey + COOKIEH <= 340) {
						jump = false;
						touchGround = true;
						up_not_pressed = true;
					}
					// Jump when up is pressed
					if (gc.isKeyDown(GraphicsConsole.VK_UP) && touchGround == true && jump == false) {
						jump = true;
						vy -= 30;
						touchGround = false;
						up_not_pressed = false;
						System.out.println("jump");
					}

					// gravity
					cookiey += vy;

					// no gravity while running
					if (jump == false && slide == false) {
						vy = 0;
					}
					if (cookiey + COOKIEH >= 350) {
						// checks if cookie is on floor
						touchGround = true;
						jump = false;
						cookiey = 350 - COOKIEH;
					}

					if (touchGround == false)
						vy += 5;
					if (vy > COOKIEH)
						vy = COOKIEH;

					// running animation, cycles through images

					if (slide == false && jump == false) {

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
					if (gc.isKeyDown(GraphicsConsole.VK_DOWN))
						slide = true;
					else if (!gc.isKeyDown(GraphicsConsole.VK_DOWN))
						slide = false;
					if (slide == true) {
						System.out.println("im sliding");
						images_change(s_animate, s, COOKIEX, cookiey, COOKIEW, COOKIEH, gc);
					}

					// jumping animation
					if (jump == true || touchGround == false) {
						System.out.println("im jumping");
						images_change(j_animate, j, COOKIEX, cookiey, COOKIEW, COOKIEH, gc);

					}
					System.out.println(jel1x[0]);
				}

				Thread.sleep(50);
				cookieEnergy--; // energy decrease as time goes
				// cycles images
				z++;
				s++;
				j++;
				// resets image cycle
				if (z == 4)
					z = 0;
				if (s == 2)
					s = 0;
				if (j == 2)
					j = 0;

				// blueberry cookie gets faster speed
				if (c_num == 2) {
					bgx -= 5;
					floorx -= 20;
				} else {// normal speed
					bgx -= 3;// moves background
					floorx -= 15;// moves floor
				}

				// moves obstacles and jellies and potion
				move_features(jobx);
				move_features(sobx);
				move_features(jel1x);
				move_features(jel2x);
				move_features(Epotionx);

				if (bgx < -1490)// keeps background and floor on repeat
					bgx = 0;
				if (floorx < -990)
					floorx = 0;

				// displays hit and takes away energy
				if (hitob == true) {
					cookieEnergy -= 5;
					gc.setColor(new Color(255, 0, 0, 100));
					gc.fillRect(0, 0, 800, 400);
					gc.setColor(Color.WHITE);
					gc.drawString("Ouch!", COOKIEX, cookiey - 30);
					Thread.sleep(50);
					hitob = false;
				}

				// checks if energy is depleted and ends game
				// draws dead cookie (Can cookies die?!)
				if (cookieEnergy <= 0) {
					if (c_num == 1)
						gc.drawImage(die1, COOKIEX, cookiey, COOKIEW, COOKIEH);
					else if (c_num == 2)
						gc.drawImage(die2, COOKIEX, cookiey, COOKIEW, COOKIEH);
					else if (c_num == 3)
						gc.drawImage(die3, COOKIEX, cookiey, COOKIEW, COOKIEH);
					else if (c_num == 4)
						gc.drawImage(die4, COOKIEX, cookiey, COOKIEW, COOKIEH);
					Thread.sleep(2000);

					if (score >= 150) {
						gc.clear();
						gc.setColor(Color.BLACK);
						gc.drawString("Congrats! You Escaped!! You Earned " + score + " jellies!!", 100, 70);
						if (c_num == 1) {
							gc.drawImage(gingericon, 330, 110, 180, 180);
						} else if (c_num == 3) {
							gc.drawImage(cottonicon, 300, 110, 200, 200);
						} else if (c_num == 2) {
							gc.drawImage(blueberryicon, 330, 110, 150, 200);
						} else if (c_num == 4) {
							gc.drawImage(cocoaicon, 300, 110, 200, 200);
						}
						gc.drawString("Press any key to exit.", 250, 350);
						gc.getChar();
						gc.close();
					} else if (score < 150) {
						gc.clear();
						gc.setColor(Color.BLACK);
						gc.drawString("Sorry, you lose..", 220, 70);
						if (c_num == 1) {
							gc.drawImage(die1, 330, 110, 180, 180);
						} else if (c_num == 3) {
							gc.drawImage(die3, 300, 110, 200, 200);
						} else if (c_num == 2) {
							gc.drawImage(die2, 330, 110, 150, 200);
						} else if (c_num == 4) {
							gc.drawImage(die4, 300, 110, 200, 200);
						}
						gc.drawString("Press any key to exit.", 250, 350);
						gc.getChar();
						gc.close();
					}

				}
			}

		}

	}

	// collision detection method
	static boolean collision_detection(int ax, int ay, int aw, int ah, int bx, int by, int bw, int bh) {
		return ax < bx + bw && ay < by + bh && bx < ax + aw && by < ay + ah;
	}

	// moving across screen
	static void move_features(int x[]) {
		for (int i = 0; i < x.length; i++)
			x[i] -= 15;
	}

	// drawing game features
	static void draw_features(boolean fb, Image f, int fx, int fy, int fw, int fh, GraphicsConsole gc) {
		if (fb == true) {
			gc.drawImage(f, fx, fy, fw, fh);
		}
	}

	// cycle through images, creates animation. Jumping and sliding.
	static void images_change(Image c_animate[], int c, int cx, int cy, int cw, int ch, GraphicsConsole gc) {
		if (c == 0) {
			gc.drawImage(c_animate[c], cx, cy, cw, ch);
		} else if (c == 1) {
			gc.drawImage(c_animate[c], cx, cy, cw, ch);
		}
	}

	// loading images for running, jumping, and sliding
	static void images_load(int num, String f, Image animate[], GraphicsConsole gc) {
		for (int i = 1; i < animate.length + 1; i++) {
			String source;
			source = "images/" + f + num + "_" + i + ".png";
			animate[i - 1] = Toolkit.getDefaultToolkit().getImage(gc.getClass().getClassLoader().getResource(source));

		}
	}
}
