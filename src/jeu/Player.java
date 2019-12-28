package jeu;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Player extends GraphicObject{
	
	public Player(Zone zone)
	{
		
		corps = new ImageView(playerImage("photoJeu/player.png"));
	
		
		((ImageView) corps).setX(0);
		((ImageView) corps).setY(0);
		
		
		double x = zone.getX1() + (zone.getX2() - zone.getX1())*Math.random() - 100;
		double y = zone.getY1() + (zone.getY2() - zone.getY1())*Math.random()- 80;
		//System.out.println(x + "-"+y);
		//((ImageView) corps).setX(x);
		//((ImageView) corps).setY(y);

		//((ImageView) corps).minWidth(80);
		//((ImageView) corps).minHeight(80);
		corps.setTranslateX(x);
		corps.setTranslateY(y);
		System.out.println("x1 = " + corps.getTranslateX());
		System.out.println("x1 = " + corps.getTranslateY());
	}
	
	public Image playerImage(String url)
	{
		Image image = null;
		try {
			image = new Image(new FileInputStream(url));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return image;
	
	}
}
