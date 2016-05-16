package model;

public interface Observable {
	void registerObserver(Observer o);
	boolean removeObserver(Observer o );
	void setChanged();
	void notifyObservers();
}
