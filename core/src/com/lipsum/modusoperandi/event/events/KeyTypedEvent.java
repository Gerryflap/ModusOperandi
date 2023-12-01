package com.lipsum.modusoperandi.event.events;

import com.lipsum.modusoperandi.event.Event;
import com.lipsum.modusoperandi.event.EventType;

public class KeyTypedEvent implements Event {
    final char charTyped;

    public KeyTypedEvent(char charTyped) {
        this.charTyped = charTyped;
    }

    public char getCharTyped() {
        return charTyped;
    }

    @Override
    public EventType getEventType() {
        return EventType.KEY_TYPED;
    }
}