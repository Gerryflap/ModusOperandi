package com.lipsum.modusoperandi.event.events;

import com.lipsum.modusoperandi.event.Event;
import com.lipsum.modusoperandi.event.EventConsumer;
import com.lipsum.modusoperandi.event.EventType;

public class KeyEvent implements Event {
    private final boolean isKeyDown;
    private final int keyCode;

    public KeyEvent(boolean isKeyDown, int keyCode) {
        this.isKeyDown = isKeyDown;
        this.keyCode = keyCode;
    }

    public int getKeyCode() {
        return keyCode;
    }

    public boolean isKeyDown() {
        return this.isKeyDown;
    }

    public boolean isKeyUp() {
        return !this.isKeyDown;
    }

    @Override
    public EventType getEventType() {
        return EventType.KEY_EVENT;
    }
}