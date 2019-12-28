package jeu;
//import javafx.scene.paint.Color;

public class Score extends GraphicObject {
	private double score;
	
	public Score(double score) {
		super();
		this.score = score;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}
	
}
