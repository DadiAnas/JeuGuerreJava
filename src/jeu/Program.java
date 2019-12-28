package jeu;

//import java.awt.Event;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

//import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.Pane;
//import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Program extends Application {

	private double widthWindow = 800;
	private double heightWindow = 600;
	private Pane container;
	private Line line= new Line(0,300,widthWindow,300);
	
	
	Zone zone1 = new Zone(0 ,0, line.getEndX()-100,line.getEndY()-100);
	Zone zone2 = new Zone(line.getStartX()+100 , line.getStartY()+110, line.getEndX()-50,heightWindow-50);
	
	Player player = new Player(zone2);
	Monster monster = new Monster(zone1);
	Arme arme = new Arme(player);
	Balle balle;
	private List<Monster> listMonster = new ArrayList<Monster>();
	private List<Balle> balles = new ArrayList<Balle>();
	
	
	AnimationTimer animation = new AnimationTimer() {
		@Override
		public void handle(long arg0) {
			// TODO Auto-generated method stub
			loop();
		}
		
	};
	EventHandler<KeyEvent> event = new EventHandler<KeyEvent>() {

		
		@Override
		public void handle(KeyEvent event) {
			// TODO Auto-generated method stub
			if(event.getCode() == KeyCode.X)
			{
				arme.rotateLeft();
			}
			
			if(event.getCode() == KeyCode.W)
			{
				arme.rotateRight();
			}
			
			if(event.getCode() == KeyCode.SPACE)
			{
				balle  = new Balle(arme);
				container.getChildren().add(balle.getCorps());
				balles.add(balle);
				
			}	
			
			if(event.getCode() == KeyCode.LEFT)
			{
				player.getCorps().setTranslateX(player.getCorps().getTranslateX()-5);
				arme.getCorps().setTranslateX(arme.getCorps().getTranslateX()-5);
				arme.updateSortie();
				
			}
			if(event.getCode() == KeyCode.RIGHT)
			{
				player.getCorps().setTranslateX(player.getCorps().getTranslateX()+5);
				arme.getCorps().setTranslateX(arme.getCorps().getTranslateX()+5);
				arme.updateSortie();
				
			}
			if(event.getCode() == KeyCode.UP)
			{
				player.getCorps().setTranslateY(player.getCorps().getTranslateY()-5);
				arme.getCorps().setTranslateY(arme.getCorps().getTranslateY()-5);
				arme.updateSortie();
			
			}
			if(event.getCode() == KeyCode.DOWN)
			{
				player.getCorps().setTranslateY(player.getCorps().getTranslateY()+5);
				arme.getCorps().setTranslateY(arme.getCorps().getTranslateY()+5);
				arme.updateSortie();
				
			}
		}
	};
	
	
	private void loop() {
		
		//add monster
		for(Balle b : balles)
		{
			for(Monster m : listMonster)
			{
				if(b.touched(m))
				{
					container.getChildren().remove(m.getCorps());
					container.getChildren().remove(b.getCorps());
					m.setIsAlive(false);
					b.setIsAlive(false);
					
				}
			}
		}
		
		listMonster.removeIf(GraphicObject :: getDead);
		balles.removeIf(GraphicObject :: getDead);
		for(Balle b : balles)
			b.update();
		if(Math.random()<0.02)
		{
			Monster m = new Monster(zone1);
			listMonster.add(m);
			container.getChildren().add(m.getCorps());
		}
	}
	public static void main(String []arg )
	{
		launch(arg);
	}
	@Override
	public void start(Stage window) throws Exception {
		// TODO Auto-generated method stub
		window.setWidth(widthWindow);
		window.setHeight(heightWindow);
		container = new Pane();
		
		window.setTitle("jeu de guere");
		
		//create content
		createContent();
		animation.start();
		
		
		//event listener
		
		//create scene
		Scene scene = new Scene(container);
		
		//set principal scene
		window.setScene(scene);
		scene.setOnKeyPressed(event);
		
		 //set background
		createBackground();
		
		
		window.show();
		
	}
	
	private void createContent()
	{
		//add line
		container.getChildren().add(line);
		
		//add player
		container.getChildren().add(player.getCorps());
		
		container.getChildren().add(arme.getCorps());
		container.getChildren().add(arme.getSortie());
	}
	private void createBackground()
	{
		FileInputStream file;
		try {
			file = new FileInputStream("photoJeu/background.png");
			Image backgroungImage = new Image(file, widthWindow, heightWindow, false, true);
			BackgroundImage background = new BackgroundImage(backgroungImage, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);
			container.setBackground(new Background(background));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("ddd");
		}
	
    }

}
