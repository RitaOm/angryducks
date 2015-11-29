package com.epam.jmp.creator;

import com.epam.jmp.entity.Duck;

public abstract class AbstractDuckCreator<T extends Duck> {
	
	public abstract T createSimpleDuck();

}
