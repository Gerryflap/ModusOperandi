package com.lipsum.modusoperandi.event.events;

import com.lipsum.modusoperandi.GameManager;
import com.lipsum.modusoperandi.event.Event;
import com.lipsum.modusoperandi.event.EventType;

public class SetupGameEvent implements Event {

    public SetupGameEvent() {
        GameManager.getInstance().setupGame();
    }

    @Override
    public EventType getEventType() {
        return EventType.SETUP_GAME;
    }


}