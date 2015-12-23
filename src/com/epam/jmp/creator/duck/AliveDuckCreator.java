package com.epam.jmp.creator.duck;

import java.util.Random;

import com.epam.jmp.model.duck.AliveDuck;

public class AliveDuckCreator extends AbstractDuckCreator<AliveDuck> {

	private static int MIN_SNACK_QUANTITY = 1;

	private static int MAX_SNACK_QUANTITY = 5;

	@Override
	public AliveDuck createSimpleDuck() {
		AliveDuck duck = new AliveDuck();
		duck.setName(DuckNameManager.generateDuckNameFromId());
		Random random = new Random();
		duck.setAvailableSnackQuantity(random.nextInt(MAX_SNACK_QUANTITY
				- MIN_SNACK_QUANTITY + 1)
				+ MIN_SNACK_QUANTITY);
		return duck;
	}
}
