package cn.g.model;

import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

import cn.g.util.Square;

public class Ground {

	private int[][] rocks = new int[Square.WIDTH][Square.HIGHT];

	public Ground() {
		init();
	}

	public void init() {
		for (int x = 0; x < Square.WIDTH; x++)
			rocks[x][0] = 1;
		for (int x = 0; x < Square.WIDTH; x++)
			rocks[x][Square.HIGHT - 1] = 1;
		for (int y = 1; y < Square.HIGHT; y++)
			rocks[0][y] = 1;
		for (int y = 1; y < Square.HIGHT; y++)
			rocks[Square.WIDTH - 1][y] = 1;

	}

	public boolean isSnakeEatRock(Snake snake) {
	//	System.out.println("Ground's isSnakeEatRock");
		for (int x = 0; x < Square.WIDTH; x++) {
			for (int y = 0; y < Square.HIGHT; y++) {
				if (rocks[x][y] == 1 && x == snake.getSnakeHead().x
						&& y == snake.getSnakeHead().y)
					return true;
			}

		}
		return false;
	}

	public Point getPoint() {
		Random random = new Random();
		int x, y;
		do {
			x = random.nextInt(Square.WIDTH);
			y = random.nextInt(Square.HIGHT);
		} while (rocks[x][y] == 1);

		return new Point(x, y);
	}

	public void drawMe(Graphics g) {
		//System.out.println("Ground's drawMe");
		for (int x = 0; x < Square.WIDTH; x++) {
			for (int y = 0; y < Square.HIGHT; y++) {
				if (rocks[x][y] == 1)
					g.fill3DRect(x * Square.SIZE, y * Square.SIZE, Square.SIZE,
							Square.SIZE, true);
			}

		}

	}

}
