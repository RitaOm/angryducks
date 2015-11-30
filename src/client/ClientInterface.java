package client;

import java.util.List;

import com.epam.jmp.entity.duck.Duck;

public class ClientInterface {

	public static void displayGameboard(List<Duck> players,
			List<String> labyrinth) {
		for (int i = 0; i < labyrinth.size(); i++) {
			String str = labyrinth.get(i);
			for (Duck duck : players) {
				if (duck.getCoordinates().getY() == i) {
					str = str.substring(0, duck.getCoordinates().getX())
							+ duck.getName()
							+ str.substring(duck.getCoordinates().getX() + 1);
				}
			}
            System.out.println(str);
		}
	}

	public static void displayDuckInfo(Duck duck) {
		System.out.println("Duck " + duck.getName() + " : "
				+ duck.getCoordinates());
	}

}
