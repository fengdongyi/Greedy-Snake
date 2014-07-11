package cn.g.game;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import cn.g.controller.Controller;
import cn.g.model.Food;
import cn.g.model.Ground;
import cn.g.model.Snake;
import cn.g.util.Square;
import cn.g.view.GamePanel;

public class Game {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Snake snake = new Snake();
		Food food = new Food();
		Ground ground = new Ground();
		GamePanel gamePanel = new GamePanel();
		Controller controller = new Controller(snake, food, ground, gamePanel);
		
		JFrame jFrame = new JFrame();
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gamePanel.setSize(Square.WIDTH*Square.SIZE, Square.HIGHT*Square.SIZE);
		jFrame.setSize(Square.WIDTH*Square.SIZE+10, Square.HIGHT*Square.SIZE+30);
		jFrame.add(gamePanel,BorderLayout.CENTER);
		
		gamePanel.addKeyListener(controller);
		snake.addSnakeListener(controller);
		jFrame.addKeyListener(controller);
		
		jFrame.setVisible(true);
		controller.newGame();

	}

}
