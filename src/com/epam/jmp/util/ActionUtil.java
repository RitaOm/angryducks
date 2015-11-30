package com.epam.jmp.util;

import java.util.List;

import com.epam.jmp.client.ActionStatus;
import com.epam.jmp.model.duck.Duck;

public class ActionUtil {
	
	private ActionUtil() {		
	}

	public static List<String> getAvailableActions(Duck duck){		
		return null;
	}
	
	public static ActionStatus executeAction(String action){	
		return ActionStatus.ACCEPTED;
	}
}
