package com.epam.jmp.model.duck;

import com.epam.jmp.model.labyrinth.LabyrinthWalker;

public class Duck extends LabyrinthWalker{

	static {
		id = 0;
	}

	private static int id;

	private String name;

	private float stepMeasure = 1;

	private int stepsQuantityDuckBecomesHungry = 10;

	private int counter = 0;

	public Duck() {
		id++;
	}

	public void walk() {
	}

	public void swim() {
	}

	public void quack() {
	}

	public int getId() {
		return id;
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

	public void setStepMeasure(float stepMeasure) {
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
		if (this.getId() != other.getId()) {
			return false;
		}
		if ((this.name == null) ? (other.name != null) : !this.name
				.equals(other.name)) {
			return false;
		}
		return true;
	}

	public int hashCode() {
		final int PRIME = 31;
		int result = 7;
		result = PRIME * result + getId();
		return result;
	}

}
