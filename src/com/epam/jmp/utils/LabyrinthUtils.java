package com.epam.jmp.utils;

import java.util.List;

import com.epam.jmp.action.Action;
import com.epam.jmp.model.duck.Duck;
import com.epam.jmp.model.duck.DuckType;
import com.epam.jmp.model.labyrinth.Cell;
import com.epam.jmp.model.labyrinth.Labyrinth;
import com.epam.jmp.model.labyrinth.LabyrinthLevel;

public class LabyrinthUtils {

	enum LabyrinthPoint {

		ENTRY, EXIT, WALL, WALK, SWIM;

		@Override
		public String toString() {
			return super.toString().toLowerCase();
		}

	}

	private LabyrinthUtils() {
	}

	private static boolean compare(Labyrinth labyrinth, int x, int y,
			String point) {
		return labyrinth.getInstance()[y][x]
				.equals(Messages.getProperty(point));
	}

	public static boolean isMovingToDirectionAvailable(Labyrinth labyrinth, Duck duck,
			Action action) {
		switch (action) {
		case UP:
			return isUpAvailable(labyrinth, duck);
		case DOWN:
			return isDownAvailable(labyrinth, duck);
		case LEFT:
			return isLeftAvailable(labyrinth, duck);
		case RIGHT:
			return isRightAvailable(labyrinth, duck);
		default:
			return false;
		}
	}

	public static boolean isUpAvailable(Labyrinth labyrinth, Duck duck) {
		Cell cell = duck.getCurrentCell();
		if (cell.getY() == 0) {
			return false;
		}
		boolean isWalk = compare(labyrinth, cell.getX(), cell.getY() - 1,
				LabyrinthPoint.WALK.toString());
		if (isWalk) {
			return true;
		}
		boolean isWall = compare(labyrinth, cell.getX(), cell.getY() - 1,
				LabyrinthPoint.SWIM.toString());
		if (duck.getDuckType() == DuckType.ALIVE && isWall) {
			return false;
		}
		boolean isWater = compare(labyrinth, cell.getX(), cell.getY() - 1,
				LabyrinthPoint.SWIM.toString());
		if (duck.getDuckType() == DuckType.TOY) {
			if (isWater) {
				return false;
			}
			if (isWall && cell.getY() - 1 > 0) {
				boolean secondUpIsWalk = compare(labyrinth, cell.getX(),
						cell.getY() - 2, LabyrinthPoint.WALK.toString());
                return secondUpIsWalk;
			} else {
				return false;
			}
		}
		return false;
	}

	public static boolean isLeftAvailable(Labyrinth labyrinth, Duck duck) {
		Cell cell = duck.getCurrentCell();
		if (cell.getX() == 0) {
			return false;
		}
		boolean isWalk = compare(labyrinth, cell.getX() - 1, cell.getY(),
				LabyrinthPoint.WALK.toString());
		if (isWalk) {
			return true;
		}
		boolean isWall = compare(labyrinth, cell.getX() - 1, cell.getY(),
				LabyrinthPoint.SWIM.toString());
		if (duck.getDuckType() == DuckType.ALIVE && isWall) {
			return false;
		}
		boolean isWater = compare(labyrinth, cell.getX() - 1, cell.getY(),
				LabyrinthPoint.SWIM.toString());
		if (duck.getDuckType() == DuckType.TOY) {
			if (isWater) {
				return false;
			}
			if (isWall && cell.getX() - 1 > 0) {
				boolean secondUpIsWalk = compare(labyrinth, cell.getX() - 2,
						cell.getY(), LabyrinthPoint.WALK.toString());
                return secondUpIsWalk;
			} else {
				return false;
			}
		}
		return false;
	}

	public static boolean isDownAvailable(Labyrinth labyrinth, Duck duck) {
		Cell cell = duck.getCurrentCell();
		if (cell.getY() >= labyrinth.getRows()) {
			return false;
		}
		boolean isWalk = compare(labyrinth, cell.getX(), cell.getY() + 1,
				LabyrinthPoint.WALK.toString());
		if (isWalk) {
			return true;
		}
		boolean isWall = compare(labyrinth, cell.getX(), cell.getY() + 1,
				LabyrinthPoint.SWIM.toString());
		if (duck.getDuckType() == DuckType.ALIVE && isWall) {
			return false;
		}
		boolean isWater = compare(labyrinth, cell.getX(), cell.getY() + 1,
				LabyrinthPoint.SWIM.toString());
		if (duck.getDuckType() == DuckType.TOY) {
			if (isWater) {
				return false;
			}
			if (isWall && cell.getY() + 1 > 0) {
				boolean secondUpIsWalk = compare(labyrinth, cell.getX(),
						cell.getY() + 2, LabyrinthPoint.WALK.toString());
                return secondUpIsWalk;
			} else {
				return false;
			}
		}
		return false;
	}

	public static boolean isRightAvailable(Labyrinth labyrinth, Duck duck) {
		Cell cell = duck.getCurrentCell();
		if (cell.getX() >= labyrinth.getColumns()) {
			return false;
		}
		boolean isWalk = compare(labyrinth, cell.getX() + 1, cell.getY(),
				LabyrinthPoint.WALK.toString());
		if (isWalk) {
			return true;
		}
		boolean isWall = compare(labyrinth, cell.getX() + 1, cell.getY(),
				LabyrinthPoint.SWIM.toString());
		if (duck.getDuckType() == DuckType.ALIVE && isWall) {
			return false;
		}
		boolean isWater = compare(labyrinth, cell.getX() + 1, cell.getY(),
				LabyrinthPoint.SWIM.toString());
		if (duck.getDuckType() == DuckType.TOY) {
			if (isWater) {
				return false;
			}
			if (isWall && cell.getX() + 1 > 0) {
				boolean secondUpIsWalk = compare(labyrinth, cell.getX() + 2,
						cell.getY(), LabyrinthPoint.WALK.toString());
                return secondUpIsWalk;
			} else {
				return false;
			}
		}
		return false;
	}

	public static void addKeyPoints(Labyrinth labyrinth) {
		Cell entry = findLabyrinthPoint(labyrinth,
				LabyrinthPoint.ENTRY.toString());
		Cell exit = findLabyrinthPoint(labyrinth,
				LabyrinthPoint.EXIT.toString());
		labyrinth.setEntry(entry);
		labyrinth.setExit(exit);
	}

	public static Cell findLabyrinthPoint(Labyrinth labyrinth, String point) {
		Cell cell = new Cell();
		String symbol = Messages.getProperty(point);
		for (int i = 0; i < labyrinth.getRows(); i++) {
			for (int j = 0; j < labyrinth.getColumns(); j++) {
				if (labyrinth.getInstance()[i][j].equals(symbol)) {
					cell.setX(j);
					cell.setY(i);
				}
			}
		}
		return cell;
	}

	public static LabyrinthLevel initLabyrinthLevel(int level) {
		switch (level) {
		case 1:
			return LabyrinthLevel.LEVEL1;
		case 2:
			return LabyrinthLevel.LEVEL2;
		default:
			return LabyrinthLevel.LEVEL1;
		}
	}

	public static boolean isDuckFinished(Duck duck, Labyrinth labyrinth) {
		if (labyrinth.getExit().getX() == duck.getCurrentCell().getX()
				&& labyrinth.getExit().getY() == duck.getCurrentCell().getY()) {
			return true;
		}
		return false;
	}

	public static void copyCellCoordinates(Cell toBeCopied, Cell c2) {
		c2.setX(toBeCopied.getX());
		c2.setY(toBeCopied.getY());
	}

	public static boolean stringLinesLengthChecker(List<String> lines) {
		int length = lines.get(0).trim().length();
		for (String line : lines) {
			if (line.trim().length() != length) {
				return false;
			}
		}
		return true;
	}

	public static String[][] stringLinesToArrayConverter(List<String> lines) {
		String[][] labyrinthInstance;
		int rows = lines.size();
		int columns = lines.get(0).length();
		labyrinthInstance = new String[rows][columns];
		for (int i = 0; i < rows; i++) {
			String line = lines.get(i).trim();
			for (int j = 0; j < columns; j++) {
				labyrinthInstance[i][j] = line.substring(j, j + 1);
			}
		}
		return labyrinthInstance;
	}

}
