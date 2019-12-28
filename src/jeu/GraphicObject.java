package jeu;

import javafx.scene.Node;

public class GraphicObject {
	protected Node corps;
	private boolean isAlive = true;
	public Node getCorps() {
		return corps;
	}

	public void setCorps(Node corps) {
		this.corps = corps;
	}
	public void setIsAlive(boolean life)
	{
		isAlive = life;
	}
	
	public boolean getDead( )
	{
		return !isAlive ;
	}
	
	
	public boolean touched(GraphicObject obj)
	{
		return corps.getBoundsInParent().intersects(obj.getCorps().getBoundsInParent());
	}
	
	 
}
