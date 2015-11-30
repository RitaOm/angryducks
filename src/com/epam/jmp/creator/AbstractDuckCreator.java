package com.epam.jmp.creator;

import com.epam.jmp.model.duck.Duck;

public abstract class AbstractDuckCreator<T extends Duck> {
	
	public abstract T createSimpleDuck();

}
