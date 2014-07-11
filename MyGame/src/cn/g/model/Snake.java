package cn.g.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import cn.g.listener.SnakeListener;
import cn.g.util.Square;

public class Snake {

	public static final int UP = -1;
	public static final int DOWN = 1;
	public static final int LEFT = 2;
	public static final int RIGHT = -2;

	private boolean life;

	private int direction, newDirection;

	private Point oldTail;

	private LinkedList<Point> body = new LinkedList<Point>();

	private Set<SnakeListener> listeners = new HashSet<SnakeListener>();

	public Snake() {
		init();
	}

	public void init() {
		int x = Square.WIDTH / 2;
		int y = Square.HIGHT / 2;

		for (int i = 0; i < 10; i++) {
			body.addLast(new Point(x--, y));
		}
		direction = newDirection = RIGHT;
		life = true;
	}

	public void dead() {
		life = false;
	}

	public Point getSnakeHead() {
		return body.getFirst();
	}

	public void move() {
	//	System.out.println("Snake's move");

		if (!(direction + newDirection == 0)) {
			direction = newDirection;
		}

		// 去尾
		oldTail = body.removeLast();

		int x = body.getFirst().x;
		int y = body.getFirst().y;

		switch (direction) {
		case UP:
			y--;
			if (y < 0) {
				y = Square.HIGHT - 1;
			}
			break;
		case DOWN:
			y++;
			if (y >= Square.HIGHT) {
				y = 0;
			}
			break;
		case LEFT:
			x--;
			if (x < 0) {
				x = Square.WIDTH - 1;
			}
			break;
		case RIGHT:
			x++;
			if (x >= Square.WIDTH) {
				x = 0;
			}
			break;
		}
		Point newhead = new Point(x, y);

		// 加头
		body.addFirst(newhead);

	}

	public void changeDirection(int direction) {
		//System.out.println("Snake's changeDirection");
		newDirection = direction;

	}

	public void eatFood() {
		//System.out.println("Snake's eatFood");

		body.addLast(oldTail);
	}

	public boolean isEatBody() {
		//System.out.println("Snake's isEatBody");
		for (int i = 1; i < body.size(); i++) {
			if(body.get(i).equals(getSnakeHead()))
				return true;

		}
		return false;
	}

	public void drawMe(Graphics g) {
	//	System.out.println("Snake's drawMe");
		g.setColor(Color.BLACK);
		for (Point p : body) {
			g.fill3DRect(p.x * Square.SIZE, p.y * Square.SIZE, Square.SIZE,
					Square.SIZE, true);
		}

	}

	private class SnakeDriver implements Runnable {

		@Override
		public void run() {
			// TODO 自动生成的方法存根
			while (life) {
				move();
				for (SnakeListener l : listeners) {
					l.snakeMoved(Snake.this);
				}
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}

		}
	}

	public void start() {
		new Thread(new SnakeDriver()).start();
	}

	public void addSnakeListener(SnakeListener l) {
		if (l != null) {
			this.listeners.add(l);
		}
	}

}
