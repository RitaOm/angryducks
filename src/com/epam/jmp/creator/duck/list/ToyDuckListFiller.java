package com.epam.jmp.creator.duck.list;

import java.util.ArrayList;
import java.util.List;

import com.epam.jmp.creator.duck.ToyDuckCreator;
import com.epam.jmp.model.duck.Duck;

public class ToyDuckListFiller implements IDuckListFiller {

	@Override
	public List<Duck> buildDuckList(int quantity) {
		List<Duck> list = new ArrayList<Duck>();
		ToyDuckCreator tdCreator = new ToyDuckCreator();
		for (int i = 0; i < quantity; i++) {
			Duck duck = tdCreator.createSimpleDuck();
			list.add(duck);
		}
		return list;
	}

}
