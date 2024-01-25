package files;

import hsa2.GraphicsConsole;
import java.awt.*;

public class testing {

	public static void main(String[] args) throws InterruptedException {

		
		 final int XBLOCKS = 15;
	      final int YBLOCKS = 20;
	      final int BLOCKSIZE = 50;
	      final int XSIZE = 543;
	      final int YSIZE = 377;
	      final int MARGIN = BLOCKSIZE * 3;
	      int xoffset = 0;
	      int yoffset = 0;
	      GraphicsConsole c = new GraphicsConsole(XSIZE, YSIZE);
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

	      while (true) {

	         synchronized (c) {

	            c.clear();

	            for (int i = 0; i < XBLOCKS; i++) {
	               for (int j = 0; j < YBLOCKS; j++) {

	                  if (grid[i][j] == 1) {
	                     c.setColor(Color.red);
	                     c.fillRect(i * BLOCKSIZE - xoffset, j * BLOCKSIZE - yoffset, BLOCKSIZE,
	                           BLOCKSIZE);
	                  } else {
	                     c.setColor(Color.blue);
	                     c.fillRect(i * BLOCKSIZE - xoffset, j * BLOCKSIZE - yoffset, BLOCKSIZE,
	                           BLOCKSIZE);
	                  }
	               }
	            }
	            c.setColor(Color.green);
	            c.fillRect(x - xoffset, y - yoffset, BLOCKSIZE, BLOCKSIZE);

	         }

	         Thread.sleep(25);

	         if (c.isKeyDown(GraphicsConsole.VK_LEFT)) {

	            x -= 5;

	            // Collision detection w/ "wall"

	            xblock0 = x / BLOCKSIZE;
	            yblock0 = y / BLOCKSIZE;
	            xblock1 = x / BLOCKSIZE;
	            yblock1 = y / BLOCKSIZE + 1;

	            if ((grid[xblock0][yblock0] != 0)
	                  && (x < (xblock0 + 1) * BLOCKSIZE))
	               x = (xblock0 + 1) * BLOCKSIZE;
	            if ((grid[xblock1][yblock1] != 0)
	                  && (x < (xblock1 + 1) * BLOCKSIZE)
	                  && (y % BLOCKSIZE != 0))
	               x = (xblock1 + 1) * BLOCKSIZE;

	         }

	         if (c.isKeyDown(GraphicsConsole.VK_RIGHT)) {

	            x += 5;

	            // Collision detection w/ "wall"

	            xblock0 = x / BLOCKSIZE + 1;
	            yblock0 = y / BLOCKSIZE;
	            xblock1 = x / BLOCKSIZE + 1;
	            yblock1 = y / BLOCKSIZE + 1;

	            if ((grid[xblock0][yblock0] != 0)
	                  && (x > (xblock0 - 1) * BLOCKSIZE))
	               x = (xblock0 - 1) * BLOCKSIZE;
	            if ((grid[xblock1][yblock1] != 0)
	                  && (x > (xblock1 - 1) * BLOCKSIZE)
	                  && (y % BLOCKSIZE != 0))
	               x = (xblock1 - 1) * BLOCKSIZE;

	         }

	         if (c.isKeyDown(GraphicsConsole.VK_UP) && hit_ground && up_not_pressed) {

	            vy = -15;
	            hit_ground = false;
	            up_not_pressed = false;

	         }

	         if (!c.isKeyDown(GraphicsConsole.VK_UP))
	            up_not_pressed = true;

	         // Do "gravity"

	         y += vy;

	         if (vy < 0) {

	            // Jumping; check for a collision with the ceiling

	            xblock0 = x / BLOCKSIZE;
	            yblock0 = y / BLOCKSIZE;
	            xblock1 = x / BLOCKSIZE + 1;
	            yblock1 = y / BLOCKSIZE;

	            if ((grid[xblock0][yblock0] != 0)
	                  && (y < (yblock0 + 1) * BLOCKSIZE)) {
	               y = (yblock0 + 1) * BLOCKSIZE;
	               vy = 0;
	            }
	            if ((grid[xblock1][yblock1] != 0)
	                  && (y < (yblock1 + 1) * BLOCKSIZE)
	                  && (x % BLOCKSIZE != 0)) {
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

	            if ((grid[xblock0][yblock0] != 0)
	                  && (y > (yblock0 - 1) * BLOCKSIZE)) {
	               y = (yblock0 - 1) * BLOCKSIZE;
	               vy = 0;
	               hit_ground = true;
	            }
	            if ((grid[xblock1][yblock1] != 0)
	                  && (y > (yblock1 - 1) * BLOCKSIZE)
	                  && (x % BLOCKSIZE != 0)) {
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
	         
	         if (xoffset < x - XSIZE + MARGIN + BLOCKSIZE){
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
