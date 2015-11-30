package com.epam.jmp.main;

import java.util.ArrayList;
import java.util.List;

import com.epam.jmp.creator.AliveDuckCreator;
import com.epam.jmp.creator.ToyDuckCreator;
import com.epam.jmp.model.duck.AliveDuck;
import com.epam.jmp.model.duck.Duck;
import com.epam.jmp.model.duck.ToyDuck;


public class GameRunner {

	public static void main(String[] args) {
		AliveDuck ad = new AliveDuckCreator().createSimpleDuck();
		ToyDuck td = new ToyDuckCreator().createSimpleDuck();
		AliveDuck ad2 = new AliveDuckCreator().createSimpleDuck();
		List<Duck> players = new ArrayList<Duck>();
		players.add(ad);
		players.add(td);
		players.add(ad2);
	}

}
