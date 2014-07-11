package cn.g.model;

import java.awt.Graphics;
import java.awt.Point;

import cn.g.util.Square;

public class Food extends Point{
	
	public void newFood(Point p){
		this.setLocation(p);
	}
	
	public boolean isSnakeEatFood(Snake snake){
	//	System.out.println("Food's isSnakeEatFood");
		return this.equals(snake.getSnakeHead());
	}
	
	public void drawMe(Graphics g){
		//System.out.println("Food's drawMe");
		
		g.fill3DRect(x*Square.SIZE, y*Square.SIZE, Square.SIZE, Square.SIZE, true);
		
	}

}
