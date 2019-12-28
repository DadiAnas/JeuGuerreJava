package jeu;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Arme {

	private Rectangle corps = new Rectangle(0,60,10,40);
	private Circle sortie = new Circle(-8	,10,5);
	
	
	public Arme(GraphicObject player)
	{
		corps.setTranslateX(player.getCorps().getTranslateX());
		corps.setTranslateY(player.getCorps().getTranslateY());
		corps.setRotate(-20);
		corps.setFill(Color.WHITE);
		updateSortie();
	}


	public void updateSortie() {
		// TODO Auto-generated method stub
		sortie.setTranslateX(corps.getTranslateX()+12);
		sortie.setTranslateY(corps.getTranslateY()+70);
	}


	public Rectangle getCorps() {
		return corps;
	}


	public void setCorps(Rectangle corps) {
		this.corps = corps;
	}

	//rotation right
	public void rotateRight()
	{
		corps.setRotate(corps.getRotate()-5);
	}
	
	
	//rotation left
	public void rotateLeft()
	{
		corps.setRotate(corps.getRotate()+5);
	}
	public Circle getSortie() {
		return sortie;
	}


	public void setSortie(Circle sortie) {
		this.sortie = sortie;
	}
}
