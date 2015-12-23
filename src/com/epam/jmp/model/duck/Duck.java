package com.epam.jmp.model.duck;

import com.epam.jmp.model.labyrinth.LabyrinthWalker;
import com.epam.jmp.util.Messages;

public class Duck extends LabyrinthWalker {

	private String name;

	private int stepMeasure = 1;

	private int stepsQuantityDuckBecomesHungry = 10;

	private int counter = stepsQuantityDuckBecomesHungry;

	public Duck() {
	}

	public void walk(int deltaX, int deltaY) {
		move(deltaX, deltaY);
		counter--;
		System.out.println(Messages.getProperty("duck.walk", getName()));
	}

	public void quack() {
		System.out.println(Messages.getProperty("duck.quack", getName()));
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getStepMeasure() {
		return stepMeasure;
	}

	public void setStepMeasure(int stepMeasure) {
		this.stepMeasure = stepMeasure;
	}

	public int getStepsQuantityDuckBecomesHungry() {
		return stepsQuantityDuckBecomesHungry;
	}

	public void setStepsQuantityDuckBecomesHungry(
			int stepsQuantityDuckBecomesHungry) {
		this.stepsQuantityDuckBecomesHungry = stepsQuantityDuckBecomesHungry;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Duck other = (Duck) obj;
		if ((this.name == null) ? (other.name != null) : !this.name
				.equals(other.name)) {
			return false;
		}
		return true;
	}

	public int hashCode() {
		final int PRIME = 31;
		int result = 7;
		result = PRIME * result + name.hashCode();
		return result;
	}

}
