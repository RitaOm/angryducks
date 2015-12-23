package com.epam.jmp.creator.duck;

import java.util.List;

import com.epam.jmp.model.duck.Duck;

public interface IDuckListBuilder {

	List<Duck> buildDuckList(int quantity);
	
}
