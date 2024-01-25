package files;

import hsa2.GraphicsConsole;
import java.awt.*;

public class PleaseWork {

	public static void main(String[] args) throws InterruptedException {

		final int XBLOCKS = 15;
		final int YBLOCKS = 20;
		final int BLOCKSIZE = 50;
		final int XSIZE = 543;
		final int YSIZE = 377;
		final int MARGIN = BLOCKSIZE * 3;
		int xoffset = 0;
		int yoffset = 0;
		GraphicsConsole gc = new GraphicsConsole(XSIZE, YSIZE);
		int grid[][] = new int[XBLOCKS][YBLOCKS];
		for (int i = 0; i < XBLOCKS; i++) {
			grid[i][0] = 1;
			grid[i][YBLOCKS - 1] = 1;
		}
		for (int j = 0; j < YBLOCKS; j++) {
			grid[0][j] = 1;
			grid[XBLOCKS - 1][j] = 1;
		}
		grid[1][8] = 1;
		grid[2][10] = 1;
		grid[1][12] = 1;
		grid[2][14] = 1;
		grid[1][16] = 1;
		grid[2][17] = 1;
		grid[3][6] = 1;
		grid[4][5] = 1;
		grid[5][4] = 1;
		grid[6][4] = 1;
		grid[7][4] = 1;
		grid[9][2] = 1;
		int x = 3 * BLOCKSIZE;
		int y = 5 * BLOCKSIZE;
		int vy = 0;
		final int AY = 1;
		int xblock0, xblock1;
		int yblock0, yblock1;
		boolean hit_ground = true;
		boolean up_not_pressed = true;

		int backgroundx = 0;
		int bgx = 0;
		int floorx = 0;
		int z = 0;
		int COOKIEH = 100;
		int COOKIEW = 80;
		int COOKIEX = 100;
		int cookiey = 250;
		boolean jump = false;
		
		Image bg = gc.loadImage("src/images/stage3bg1.png");
		Image floor = gc.loadImage("src/images/stage3bg2.png");
		
		int CookieChoice;
		CookieChoice = gc.readInt();

		
		
		int c_num = CookieChoice;
		Image[] r_animate = new Image[4];
		String source;
		for (int i = 1; i < r_animate.length; i++) {
			source = "src/images/r" + c_num + "_" + i + ".png";
			r_animate[i - 1] = gc.loadImage(source);
			while (true) {

				synchronized (gc) {

					gc.clear();
					// Drawing backgrounds, two of same image on loop
					gc.drawImage(bg, bgx, 0, 1500, 400);
					gc.drawImage(bg, bgx + 1490, 0, 1500, 400);

					gc.drawImage(floor, floorx, 250, 1000, 150);
					gc.drawImage(floor, floorx + 990, 250, 1000, 150);
					
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
					
					if (gc.isKeyDown(GraphicsConsole.VK_UP) && hit_ground && up_not_pressed) {

						vy = -15;
						hit_ground = false;
						up_not_pressed = false;

					}

					if (!gc.isKeyDown(GraphicsConsole.VK_UP))
						up_not_pressed = true;

					// Do "gravity"

					y += vy;

					if (vy < 0) {

						// Jumping; check for a collision with the ceiling

						xblock0 = x / BLOCKSIZE;
						yblock0 = y / BLOCKSIZE;
						xblock1 = x / BLOCKSIZE + 1;
						yblock1 = y / BLOCKSIZE;

						if ((grid[xblock0][yblock0] != 0) && (y < (yblock0 + 1) * BLOCKSIZE)) {
							y = (yblock0 + 1) * BLOCKSIZE;
							vy = 0;
						}
						if ((grid[xblock1][yblock1] != 0) && (y < (yblock1 + 1) * BLOCKSIZE) && (x % BLOCKSIZE != 0)) {
							y = (yblock1 + 1) * BLOCKSIZE;
							vy = 0;
						}

					}

					else if (vy > 0) {

						// Falling; check for a collision with the floor

						xblock0 = x / BLOCKSIZE;
						yblock0 = y / BLOCKSIZE + 1;
						xblock1 = x / BLOCKSIZE + 1;
						yblock1 = y / BLOCKSIZE + 1;

						if ((grid[xblock0][yblock0] != 0) && (y > (yblock0 - 1) * BLOCKSIZE)) {
							y = (yblock0 - 1) * BLOCKSIZE;
							vy = 0;
							hit_ground = true;
						}
						if ((grid[xblock1][yblock1] != 0) && (y > (yblock1 - 1) * BLOCKSIZE) && (x % BLOCKSIZE != 0)) {
							y = (yblock1 - 1) * BLOCKSIZE;
							vy = 0;
							hit_ground = true;
						}

					}

					vy += AY;

					// Limit maximum falling speed

					if (vy > BLOCKSIZE)
						vy = BLOCKSIZE;

					// Scroll the screen up/down/left/right to keep the character on-screen

					if (xoffset > x - MARGIN) {
						xoffset = x - MARGIN;
						if (xoffset < 0)
							xoffset = 0;
					}

					if (xoffset < x - XSIZE + MARGIN + BLOCKSIZE) {
						xoffset = x - XSIZE + MARGIN + BLOCKSIZE;
						if (xoffset > XBLOCKS * BLOCKSIZE - XSIZE)
							xoffset = XBLOCKS * BLOCKSIZE - XSIZE;
					}

					if (yoffset > y - MARGIN) {
						yoffset = y - MARGIN;
						if (yoffset < 0)
							yoffset = 0;
					}

					if (yoffset < y - YSIZE + MARGIN + BLOCKSIZE) {
						yoffset = y - YSIZE + MARGIN + BLOCKSIZE;
						if (yoffset > YBLOCKS * BLOCKSIZE - YSIZE)
							yoffset = YBLOCKS * BLOCKSIZE - YSIZE;
					}

				}

			}
		}
	}
}
