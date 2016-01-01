package com.epam.jmp.creator.duck;

import java.util.Random;

import com.epam.jmp.model.duck.AliveDuck;

public class AliveDuckCreator extends AbstractDuckCreator<AliveDuck> {

	private static int MIN_SNACK_QUANTITY = 1;

	private static int MAX_SNACK_QUANTITY = 3;

	@Override
	public AliveDuck createSimpleDuck() {
		String name = DuckNameManager.generateDuckNameFromId();
		Random random = new Random();
		int availableSnackQuantity = random.nextInt(MAX_SNACK_QUANTITY
				- MIN_SNACK_QUANTITY + 1)
				+ MIN_SNACK_QUANTITY;
		AliveDuck duck = new AliveDuck(name, availableSnackQuantity);
		return duck;
	}
}
