package com.epam.jmp.creator;

import java.util.Random;

import com.epam.jmp.entity.duck.ToyDuck;
import com.epam.jmp.util.DuckUtil;

public class ToyDuckCreator extends AbstractDuckCreator<ToyDuck>{
	
	private static int MIN_BATTERY_QUANTITY = 1;

	private static int MAX_BATTERY_QUANTITY = 5;

	@Override
	public ToyDuck createSimpleDuck() {
		ToyDuck duck = new ToyDuck();
		String name = DuckUtil.generateDuckNameFromId(duck.getId());
		duck.setName(name);
		Random random = new Random();
		duck.setAvailableBatteryQuantity(random.nextInt(MAX_BATTERY_QUANTITY
				- MIN_BATTERY_QUANTITY + 1)
				+ MIN_BATTERY_QUANTITY);
		return duck;

	}

}
