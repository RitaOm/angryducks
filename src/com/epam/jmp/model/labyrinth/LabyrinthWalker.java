package com.epam.jmp.model.labyrinth;

public class LabyrinthWalker {

	private Cell currentCell;
	
	private WalkerStatus status;
	
	public LabyrinthWalker () {
		status = WalkerStatus.ON_START;
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
	
}
