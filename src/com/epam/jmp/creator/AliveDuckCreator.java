package com.epam.jmp.creator;

import java.util.Random;

import com.epam.jmp.entity.AliveDuck;
import com.epam.jmp.util.DuckManager;

public class AliveDuckCreator extends AbstractDuckCreator<AliveDuck> {

	private static int MIN_SNACK_QUANTITY = 1;

	private static int MAX_SNACK_QUANTITY = 5;

	private static int MIN_DRINK_QUANTITY = 1;

	private static int MAX_DRINK_QUANTITY = 5;

	@Override
	public AliveDuck createSimpleDuck() {
		AliveDuck duck = new AliveDuck();
		String name = DuckManager.generateDuckNameFromId(duck.getId());
		duck.setName(name);
		Random random = new Random();
		duck.setAvailableSnackQuantity(random.nextInt(MAX_SNACK_QUANTITY
				- MIN_SNACK_QUANTITY + 1)
				+ MIN_SNACK_QUANTITY);
		duck.setAvailableDrinkQuantity(random.nextInt(MAX_DRINK_QUANTITY
				- MIN_DRINK_QUANTITY + 1)
				+ MIN_DRINK_QUANTITY);
		return duck;
	}
}
