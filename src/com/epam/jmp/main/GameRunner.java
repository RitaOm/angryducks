package com.epam.jmp.main;

import com.epam.jmp.creator.AliveDuckCreator;
import com.epam.jmp.creator.ToyDuckCreator;
import com.epam.jmp.entity.AliveDuck;
import com.epam.jmp.entity.Duck;
import com.epam.jmp.entity.ToyDuck;

public class GameRunner {

	public static void main(String[] args) {
		AliveDuck ad = new AliveDuckCreator().createSimpleDuck();
		System.out.println(ad.getId()+","+ad.getName()+","+ad.getAvailableDrinkQuantity()+","+ad.getAvailableSnackQuantity());
		ToyDuck td = new ToyDuckCreator().createSimpleDuck();
		System.out.println(td.getId()+","+td.getName()+","+td.getAvailableBatteryQuantity());
	}

}
