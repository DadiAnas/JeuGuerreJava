package jeu;

import javafx.scene.paint.Color;

import javafx.geometry.Point2D;
import javafx.scene.shape.Circle;

public class Balle extends GraphicObject {

		private Point2D direction = new Point2D(0, 0);
		
		public Balle(Arme arme) {
			// TODO Auto-generated constructor stub
			corps = new Circle(0,0,4, Color.WHITE);
			corps.setTranslateX(arme.getSortie().getTranslateX()-8);
			corps.setTranslateY(arme.getSortie().getTranslateY() +10);
			updateDirection(arme.getCorps().getRotate()-90);
		}
		
		private void updateDirection(double rotation)
		{
			Point2D p;
			double x= Math.cos(Math.toRadians(rotation));
			double y= Math.sin(Math.toRadians(rotation));
			p = new Point2D(x, y);
			direction = p.normalize().multiply(4);
			
			
		}

		public void update() {
			// TODO Auto-generated method stub
			corps.setTranslateX(corps.getTranslateX()+direction.getX());
			corps.setTranslateY(corps.getTranslateY()+direction.getY());
		}
		
}
