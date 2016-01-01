package com.epam.jmp.model.duck;

import com.epam.jmp.model.labyrinth.Direction;
import com.epam.jmp.model.labyrinth.Labyrinth;
import com.epam.jmp.model.labyrinth.LabyrinthWalker;

public abstract class Duck extends LabyrinthWalker {

	private int stepsQuantityDuckBecomesHungry = 10;

	private int counter = stepsQuantityDuckBecomesHungry;
	
//	public void walk(int deltaX, int deltaY) {
//		getCurrentCell().changeCoordinates(deltaX, deltaY);
//		counter--;
//		System.out.println(Messages.getProperty("duck.walk", name));
//	}
	
	public Duck(String name) {
		super(name);
	}	
	
	public abstract void move(Labyrinth labyrinth, Direction direction);

	public abstract void refresh();
	
	public abstract void superAbility();
	
	public abstract boolean hasReserve();
	
	public abstract DuckType getDuckType();
	
	public int getStepsQuantityDuckBecomesHungry() {
		return stepsQuantityDuckBecomesHungry;
	}	

	public void makeAStep() {
		counter--;
	}
	
	public void setFullCounter () {
		counter = stepsQuantityDuckBecomesHungry;
	}

	public int getCounter() {
		return counter;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Duck other = (Duck) obj;
		if ((this.getName() == null) ? (other.getName() != null) : !this.getName()
				.equals(other.getName())) {
			return false;
		}
		return true;
	}

	public int hashCode() {
		final int PRIME = 31;
		int result = 7;
		result = PRIME * result + getName().hashCode();
		return result;
	}

}
