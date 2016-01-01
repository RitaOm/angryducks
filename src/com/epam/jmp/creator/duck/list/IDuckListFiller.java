package com.epam.jmp.creator.duck.list;

import java.util.List;

import com.epam.jmp.model.duck.Duck;

public interface IDuckListFiller {

	List<Duck> buildDuckList(int quantity);
	
}
