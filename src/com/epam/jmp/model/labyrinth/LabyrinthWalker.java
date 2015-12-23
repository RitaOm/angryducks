package com.epam.jmp.model.labyrinth;

public class LabyrinthWalker {

	private Cell currentCell;

	private WalkerStatus status;

	public LabyrinthWalker() {
		status = WalkerStatus.ON_START;
		currentCell = new Cell(0, 0);
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
	
	public void move(int deltaX, int deltaY) {
		currentCell.changeCoordinates(deltaX, deltaY);
	}
}
