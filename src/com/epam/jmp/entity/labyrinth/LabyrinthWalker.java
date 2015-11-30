package com.epam.jmp.entity.labyrinth;

public class LabyrinthWalker {

	private Coordinates coordinates;
	
	private WalkerStatus status;
	
	public LabyrinthWalker () {
		status = WalkerStatus.ON_START;
	}

	public Coordinates getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}

	public WalkerStatus getStatus() {
		return status;
	}

	public void setStatus(WalkerStatus status) {
		this.status = status;
	}	
	
}
