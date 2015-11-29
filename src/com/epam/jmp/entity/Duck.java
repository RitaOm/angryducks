package com.epam.jmp.entity;

public class Duck {

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

	public void setStepsQuantityDuckBecomesHungry(int stepsQuantityDuckBecomesHungry) {
		this.stepsQuantityDuckBecomesHungry = stepsQuantityDuckBecomesHungry;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}	

}
