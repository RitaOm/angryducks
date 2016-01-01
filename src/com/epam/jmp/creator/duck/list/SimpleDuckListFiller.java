package com.epam.jmp.creator.duck.list;

import java.util.ArrayList;
import java.util.List;

import com.epam.jmp.creator.duck.AliveDuckCreator;
import com.epam.jmp.creator.duck.ToyDuckCreator;
import com.epam.jmp.model.duck.Duck;

public class SimpleDuckListFiller implements IDuckListFiller {

	@Override
	public List<Duck> buildDuckList(int quantity) {
		List<Duck> list = new ArrayList<Duck>();
		AliveDuckCreator adCreator = new AliveDuckCreator();
		ToyDuckCreator tdCreator = new ToyDuckCreator();
		for (int i = 0; i < quantity / 2; i++) {
			Duck aDuck = adCreator.createSimpleDuck();
			list.add(aDuck);
			Duck tDuck = tdCreator.createSimpleDuck();
			list.add(tDuck);
		}
		if (quantity % 2 != 0) {
			Duck duck = adCreator.createSimpleDuck();
			list.add(duck);
		}
		return list;
	}

}
