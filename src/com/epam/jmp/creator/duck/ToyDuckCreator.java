package com.epam.jmp.creator.duck;

import java.util.Random;

import com.epam.jmp.model.duck.ToyDuck;

public class ToyDuckCreator extends AbstractDuckCreator<ToyDuck> {

	private static int MIN_BATTERY_QUANTITY = 1;

	private static int MAX_BATTERY_QUANTITY = 3;

	@Override
	public ToyDuck createSimpleDuck() {
		String name = DuckNameManager.generateDuckNameFromId();
		Random random = new Random();
		int availableBatteryQuantity = random.nextInt(MAX_BATTERY_QUANTITY
				- MIN_BATTERY_QUANTITY + 1)
				+ MIN_BATTERY_QUANTITY;
		ToyDuck duck = new ToyDuck(name, availableBatteryQuantity);
		return duck;

	}

}
