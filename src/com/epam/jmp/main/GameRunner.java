package com.epam.jmp.main;

import java.util.ArrayList;
import java.util.List;

import com.epam.jmp.creator.AliveDuckCreator;
import com.epam.jmp.creator.ToyDuckCreator;
import com.epam.jmp.model.duck.AliveDuck;
import com.epam.jmp.model.duck.Duck;
import com.epam.jmp.model.duck.ToyDuck;
import com.epam.jmp.model.labyrinth.Coordinates;


public class GameRunner {

	public static void main(String[] args) {
		AliveDuck ad = new AliveDuckCreator().createSimpleDuck();
		ad.setCoordinates(new Coordinates(2, 3));
		ToyDuck td = new ToyDuckCreator().createSimpleDuck();
		td.setCoordinates(new Coordinates(6, 4));
		AliveDuck ad2 = new AliveDuckCreator().createSimpleDuck();
		List<Duck> players = new ArrayList<Duck>();
		players.add(ad);
		players.add(td);
		players.add(ad2);
	}

}
