package com.epam.jmp.entity;

abstract public class Duck {

	static {
		id = 0;
	}

	private static int id;

	private String name;

	private float stepMeasure;

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

}
