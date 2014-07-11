package cn.g.controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import cn.g.listener.SnakeListener;
import cn.g.model.Food;
import cn.g.model.Ground;
import cn.g.model.Snake;
import cn.g.view.GamePanel;

public class Controller extends KeyAdapter implements SnakeListener{

	private Snake snake;
	private Food food;
	private Ground ground;
	private GamePanel gamepanel;

	public Controller(Snake snake, Food food, Ground ground, GamePanel gamepanel) {
		super();
		this.snake = snake;
		this.food = food;
		this.ground = ground;
		this.gamepanel = gamepanel;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO 自动生成的方法存根
		switch(e.getKeyCode()){
		case KeyEvent.VK_UP:
			snake.changeDirection(Snake.UP);
			break;
		case KeyEvent.VK_LEFT:
			snake.changeDirection(Snake.LEFT);
			break;
		case KeyEvent.VK_DOWN:
			snake.changeDirection(Snake.DOWN);
			break;
		case KeyEvent.VK_RIGHT:
			snake.changeDirection(Snake.RIGHT);
			break;

		
		}

	}
	

	
	public void newGame(){
		snake.start();
		food.newFood(ground.getPoint());
	}

	@Override
	public void snakeMoved(Snake snake) {
		// TODO 自动生成的方法存根
		if(food.isSnakeEatFood(snake)){
			snake.eatFood();
			food.newFood(ground.getPoint());
		}
		
		if(ground.isSnakeEatRock(snake)){
			snake.dead();
		}
		if(snake.isEatBody()){
			snake.dead();
		}
		
		gamepanel.display(snake, food, ground);
		
	
	}

}
