package cn.g.view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import cn.g.model.Food;
import cn.g.model.Ground;
import cn.g.model.Snake;
import cn.g.util.Square;

public class GamePanel extends JPanel {

	private Snake snake;
	private Food food;
	private Ground ground;

	public void display(Snake snake, Food food, Ground ground) {
	//	System.out.println("GamePanel's display");
		this.snake = snake;
		this.food = food;
		this.ground = ground;
		this.repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO 自动生成的方法存根
		g.setColor(new Color(100,200,255));
		g.fillRect(0, 0, Square.WIDTH*Square.SIZE, Square.HIGHT*Square.SIZE);
		if (snake != null && food != null && ground != null) {
			this.snake.drawMe(g);
			this.food.drawMe(g);
			this.ground.drawMe(g);
		}
	}

}
