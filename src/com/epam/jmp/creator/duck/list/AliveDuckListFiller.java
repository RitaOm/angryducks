package com.epam.jmp.creator.duck.list;

import java.util.ArrayList;
import java.util.List;

import com.epam.jmp.creator.duck.AliveDuckCreator;
import com.epam.jmp.model.duck.Duck;

public class AliveDuckListFiller implements IDuckListFiller {

	@Override
	public List<Duck> buildDuckList(int quantity) {
		List<Duck> list = new ArrayList<Duck>();
		AliveDuckCreator adCreator = new AliveDuckCreator();
		for (int i = 0; i < quantity; i++) {
			Duck duck = adCreator.createSimpleDuck();
			list.add(duck);
		}
		return list;
	}

}
