package com.epam.jmp.model.labyrinth;

import com.epam.jmp.utils.Messages;

public abstract class LabyrinthWalker {

	private String name;

	private Cell currentCell;

	private WalkerStatus status;
	
	private float balance;
	
	private String currency="bel.ruble";

	public LabyrinthWalker(String name) {
		this.name = name;
		status = WalkerStatus.ON_START;
		currentCell = new Cell(0, 0);
	}

	public void pay(int sum, String curr) {
		//convert
		changeBalance(sum);
		System.out.println(Messages.getProperty("player.pay", sum, currency));
	}
	
    public void up() {
		currentCell.changeCoordinates(0, -1);
	}
		
	public void left() {
		currentCell.changeCoordinates(1, 0);
	}
	
	public void down() {
		currentCell.changeCoordinates(0, 1);
	}
	
	public void right() {
		currentCell.changeCoordinates(-1, 0);
	}

	public String getName() {
		return name;
	}
	
	public Cell getCurrentCell() {
		return currentCell;
	}

	public void setCurrentCell(Cell currentCell) {
		this.currentCell = currentCell;
	}

	public WalkerStatus getStatus() {
		return status;
	}
	
	public void setStatus(WalkerStatus status) {
		this.status = status;
	}

	public float getBalance() {
		return balance;
	}

	public void changeBalance(float sum) {
		balance += sum;
	}

	public String getCurrency() {
		return currency;
	}	

}
