package com.lipsum.modusoperandi.event.events;

import com.lipsum.modusoperandi.event.Event;
import com.lipsum.modusoperandi.event.EventType;

public class MenuChangeEvent implements Event {

    private final int menuId;

    public MenuChangeEvent(int menuIdToChangeTo) {
        menuId = menuIdToChangeTo;
    }

    @Override
    public EventType getEventType() {
        return EventType.MENU_CHANGE;
    }

    public int getMenuId() {
        return menuId;
    }

}