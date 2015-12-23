package com.epam.jmp.creator.duck;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.epam.jmp.model.duck.Duck;

public class RandomDuckListBuilder implements IDuckListBuilder {

	@Override
	public List<Duck> buildDuckList(int quantity) {
		List<Duck> list = new ArrayList<Duck>();
		Random random = new Random();
		AliveDuckCreator adCreator = new AliveDuckCreator();
		ToyDuckCreator tdCreator = new ToyDuckCreator();
		for (int i = 0; i < quantity; i++) {
			Duck duck;
			switch (random.nextInt(2)) {
			case 0:
				duck = adCreator.createSimpleDuck();
				break;
			case 1:
				duck = tdCreator.createSimpleDuck();
				break;
			default:
				duck = tdCreator.createSimpleDuck();
			}
			list.add(duck);
		}
		return list;
	}

}
